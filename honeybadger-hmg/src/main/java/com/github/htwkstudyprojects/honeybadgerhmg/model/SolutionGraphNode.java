package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                System.out.println(honeyComb.getId());
                SolutionGraphNode currentNode = nodeMap.get(honeyComb.getId());
                for(int id : honeyComb.getReachableNeighborHoneyCombs()){
                    if(id != -1){
                        System.out.println(id);
                        currentNode.neighborNodes.add(nodeMap.get(id));
                    }
                }
            }
        }
        return solutionGraph;
    }



}