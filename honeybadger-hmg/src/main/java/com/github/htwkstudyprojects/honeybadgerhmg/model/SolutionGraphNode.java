package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
* Represents a node in a solution graph for a honeycomb maze.
* Each node corresponds to the center point of a honeycomb cell
* and keeps track of its reachable neighboring nodes.
*/
public class SolutionGraphNode {
    final Point nodePoint;
    List<SolutionGraphNode> neighborNodes;


    public SolutionGraphNode(Point point){
        this.nodePoint = point;
        neighborNodes = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SolutionGraphNode [nodePoint=").append(nodePoint).append(", neighbors=[");

        for (int i = 0; i < neighborNodes.size(); i++) {
            SolutionGraphNode neighbor = neighborNodes.get(i);
            sb.append(neighbor.nodePoint);
            if (i < neighborNodes.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]]\n");
        return sb.toString();
    }

    public Point getNodePoint() {
        return nodePoint;
    }


    public List<SolutionGraphNode> getNeighborNodes() {
        return neighborNodes;
    }


    public void addNeighborNodes(SolutionGraphNode node) {
        this.neighborNodes.add(node);
    }

    /**
    * Generates a solution graph from the given maze.
    * Each node corresponds to a honeycomb cell's center point,
    * and edges represent accessible paths between cells.
    *
    * @param maze the honeycomb maze to process
    * @return a list of solution graph nodes representing the graph
    */
    public static List<SolutionGraphNode> generateSolutionGraph(HoneyCombMaze maze) {
        List<SolutionGraphNode> solutionGraph = new ArrayList<>();
        List<List<HoneyComb>> honeyCombRows = maze.getHoneyCombs();

        Map<Integer, SolutionGraphNode> nodeMap = new HashMap<>();

        for (List<HoneyComb> row : honeyCombRows) {
            for (HoneyComb honeyComb : row) {
                SolutionGraphNode node = new SolutionGraphNode(honeyComb.getCenterPoint());
                solutionGraph.add(node);
                nodeMap.put(honeyComb.getId(), node);
            }
        }

         for (List<HoneyComb> row : honeyCombRows) {
            for (HoneyComb honeyComb : row) {
                SolutionGraphNode currentNode = nodeMap.get(honeyComb.getId());
                for(int id : honeyComb.getReachableNeighborHoneyCombs()){
                    if(id != -1){
                        if(!maze.getHoneyCombById(id).isPresent()){
                            continue;
                        }
                        HoneyComb reachableHoneyComb = maze.getHoneyCombById(id).get();
                        int[] fromOtherDirection = reachableHoneyComb.getReachableNeighborHoneyCombs();
                        for(int i : fromOtherDirection){
                            if(i == honeyComb.getId()){
                                currentNode.neighborNodes.add(nodeMap.get(id));
                                break;
                            }
                        }
                        
                    }
                }
            }
        }
        return solutionGraph;
    }

    public static String toSvg(List<SolutionGraphNode> graph, String fileName){
        StringBuilder svg = new StringBuilder();

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (SolutionGraphNode node : graph) {
            Point p = node.getNodePoint();
            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
            maxX = Math.max(maxX, p.getX());
            maxY = Math.max(maxY, p.getY());
        }

        double scale = 10.0;

        double padding = 2 * scale;
        double width = (maxX - minX) * scale + padding * 2;
        double height = (maxY - minY) * scale + padding * 2;

        svg.append(String.format(Locale.US,
            "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%.2f\" height=\"%.2f\" viewBox=\"%.2f %.2f %.2f %.2f\">\n",
            width, height, minX * scale - padding, minY * scale - padding, width, height
        ));
        svg.append("<g stroke-width=\"0.2\" fill=\"none\">\n");

        for (SolutionGraphNode node : graph) {
            Point p1 = node.getNodePoint();
            for (SolutionGraphNode neighbor : node.getNeighborNodes()) {
                Point p2 = neighbor.getNodePoint();
                svg.append(String.format(Locale.US,
                    "<line x1=\"%.2f\" y1=\"%.2f\" x2=\"%.2f\" y2=\"%.2f\" stroke-width=\"%.2f\" stroke=\"#32CD32\" />\n",
                    p1.getX() * scale, p1.getY() * scale, p2.getX() * scale, p2.getY() * scale, 0.1 * scale
                ));
            }
        }

        for (SolutionGraphNode node : graph) {
            Point p = node.getNodePoint();
            svg.append(String.format(Locale.US,
                "<circle cx=\"%.2f\" cy=\"%.2f\" r=\"%.2f\" fill=\"#32CD32\" />\n",
                p.getX() * scale, p.getY() * scale, 0.3 * scale
            ));
        }

        svg.append("</g>\n</svg>");

        File targetDir = new File("svg");
        if (!targetDir.exists()) {
           if (targetDir.mkdirs()) {
                System.out.println("Directory created: " + targetDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create directory!");
            }
        }

        File svgFile = new File(targetDir, fileName);
        try (PrintWriter out = new PrintWriter(svgFile)) {
            out.println(svg.toString());
            System.out.println("SVG file created: " + svgFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return svg.toString();
    }
}