package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class HoneyCombMaze {

    private List<List<HoneyComb>> honeyCombsRowGrid;
    private final int rang;
    private final int[] calculateElementsEachRow;
    private final Random random;

    private HoneyCombMaze(int rang) {
        this.honeyCombsRowGrid = new ArrayList<>();
        this.rang = rang;
        this.random = new Random();
        this.calculateElementsEachRow = calculateElementsEachRow();
    }

    static public HoneyCombMaze generateHoneyCombMaze(int rang, int edgeLength){
        HoneyCombMaze honeyCombMaze = new HoneyCombMaze(rang);
        honeyCombMaze.generateHoneyCombStructure(edgeLength, honeyCombMaze.calculateElementsEachRow);
        honeyCombMaze.generateMazePaths();
        return honeyCombMaze;
    }

    private int[] calculateElementsEachRow(){
        int[] rows = new int[this.rang * 2 + 1];
        int elementCount = this.rang + 1;
        for(int i = 0; i < rows.length; i++){
            rows[i] = elementCount;
            if(i >= rows.length/2) elementCount--;
            else elementCount++;
        }
        return rows;
    }

    private void generateHoneyCombStructure(int edgeLength, int[]rows){
        Point currentCenterPoint = new Point(0, 0);
        double distanceTopToCenter = edgeLength; // In a regular hexagon: distance (center to vertex) = edge length
        for(int i = 0; i < rows.length; i++){
            HoneyComb combAbove = null;
            this.honeyCombsRowGrid.add(new ArrayList<>());
            int currentRowStartId = 0;
            for (int r = 0; r < i; r++) currentRowStartId += rows[r];
            int upperRowStartId = -1;
            if (i > 0) upperRowStartId = currentRowStartId - rows[i - 1];

            for(int j = 0; j < rows[i]; j++){
                HoneyComb currentHoneyComb = new HoneyComb(new Point(currentCenterPoint.getX(), currentCenterPoint.getY()), edgeLength);
                this.honeyCombsRowGrid.get(i).add(currentHoneyComb);

                handleNeighbors(rows, i, upperRowStartId, j, currentHoneyComb);

                double newX = currentCenterPoint.getX() + 
                    2 * (currentHoneyComb.getDefiningEdges()[Directions.RIGHT.getIndex()].getStartPoint().getX() - currentCenterPoint.getX());
                currentCenterPoint.setX(newX);
                if(j == 0) combAbove = currentHoneyComb;
            }
            determineNextCurrentCenterPoint(rows, currentCenterPoint, distanceTopToCenter, i, combAbove);  
        }
    }


    private void determineNextCurrentCenterPoint(int[] rows, Point currentCenterPoint, double distanceTopToCenter, int i, HoneyComb combAbove) {
        if(i >= rows.length / 2){
            Edge adjacentEdge = combAbove.getDefiningEdges()[Directions.LOWER_RIGHT.getIndex()];
            Point topPoint = adjacentEdge.getStartPoint();
            updateCurrentCenterPoint(currentCenterPoint, topPoint, distanceTopToCenter);    
        }
        else{
            Edge adjacentEdge = combAbove.getDefiningEdges()[Directions.LOWER_LEFT.getIndex()];
            Point topPoint = adjacentEdge.getEndPoint();
            updateCurrentCenterPoint(currentCenterPoint, topPoint, distanceTopToCenter);
        }
    }

    private void handleNeighbors(int[] rows, int i, int upperRowStartId, int j, HoneyComb currentHoneyComb) {
        if(j > 0){
            currentHoneyComb.setNeighborHoneyComb(Directions.LEFT, currentHoneyComb.getId()-1);
            this.getHoneyCombById(currentHoneyComb.getId()-1).ifPresent(leftHoneyComb -> {leftHoneyComb.setNeighborHoneyComb(Directions.RIGHT, currentHoneyComb.getId());});
        }
        if(i > 0){
            boolean isAfterHalf = i > rows.length / 2;
            if(isAfterHalf){
                 if(j < rows[i - 1]){
                    int upperLeftId = upperRowStartId + j;
                    currentHoneyComb.setNeighborHoneyComb(Directions.UPPER_LEFT, upperLeftId);
                    this.getHoneyCombById(upperLeftId).ifPresent(upperLeftHoneyComb -> 
                        upperLeftHoneyComb.setNeighborHoneyComb(Directions.LOWER_RIGHT, currentHoneyComb.getId()));
                }
                if(j + 1 < rows[i - 1]){
                    int upperRightId = upperRowStartId + j + 1;
                    currentHoneyComb.setNeighborHoneyComb(Directions.UPPER_RIGHT, upperRightId);
                    this.getHoneyCombById(upperRightId).ifPresent(upperRightHoneyComb -> 
                        upperRightHoneyComb.setNeighborHoneyComb(Directions.LOWER_LEFT, currentHoneyComb.getId()));
                }
            }
            else{
                if(j > 0){
                    int upperLeftId = upperRowStartId + j - 1;
                    currentHoneyComb.setNeighborHoneyComb(Directions.UPPER_LEFT, upperLeftId);
                    this.getHoneyCombById(upperLeftId).ifPresent(upperLeftHoneyComb -> 
                        upperLeftHoneyComb.setNeighborHoneyComb(Directions.LOWER_RIGHT, currentHoneyComb.getId()));
                }
                if(j < rows[i - 1]){
                    int upperRightId = upperRowStartId + j;
                    currentHoneyComb.setNeighborHoneyComb(Directions.UPPER_RIGHT, upperRightId);
                    this.getHoneyCombById(upperRightId).ifPresent(upperRightHoneyComb  -> 
                        upperRightHoneyComb .setNeighborHoneyComb(Directions.LOWER_LEFT, currentHoneyComb.getId()));
                }
            }

        }
    }

    private void updateCurrentCenterPoint(Point currentCenterPoint, Point topPoint, double distanceTopToCenter){
        currentCenterPoint.setX(topPoint.getX());     
        currentCenterPoint.setY(topPoint.getY() - distanceTopToCenter); 
    }

    private void generateMazePaths(){
        Set<Integer> frontier = new HashSet<>();
        Set<Integer> mazeHoneyCombs = new HashSet<>();

        HoneyComb startComb = chooseRandomHoneyComb();
        mazeHoneyCombs.add(startComb.getId());
        System.out.println("start: " + startComb.getId());
        this.addFrontier(startComb, frontier, mazeHoneyCombs);

        while(!frontier.isEmpty()){
            Integer[] frontierAsArray = frontier.toArray(new Integer[0]);
            int currentId = frontierAsArray[this.random.nextInt(frontierAsArray.length)];
            frontier.remove(currentId);

            Optional<HoneyComb> currentOpt = getHoneyCombById(currentId);
            if (currentOpt.isEmpty()) {
                continue;
            }
            HoneyComb currentComb = currentOpt.get();

            List<Integer> connectedMazeNeighbors = new ArrayList<>();
            for (int neighborHoneyCombId : currentComb.getNeighborHoneyCombs()) {
                if (neighborHoneyCombId != -1 && mazeHoneyCombs.contains(neighborHoneyCombId)) {
                    connectedMazeNeighbors.add(neighborHoneyCombId);
                }
            }
            System.out.println(currentComb.getId() + " hat folgende Nachbarn die bereits im Maze sind: " + connectedMazeNeighbors);
            if (connectedMazeNeighbors.isEmpty()) {
                continue;
            }

            int randNeighborId = connectedMazeNeighbors.get(random.nextInt(connectedMazeNeighbors.size()));
            System.out.println("removes Wall from " + currentComb.getId() + " to " + randNeighborId);
            currentComb.removeWallBetween(randNeighborId);
            getHoneyCombById(randNeighborId).ifPresent(neighborComb -> neighborComb.removeWallBetween(currentId));

            mazeHoneyCombs.add(currentId);
            this.addFrontier(currentComb, frontier, mazeHoneyCombs);

        }
    }

    private HoneyComb chooseRandomHoneyComb() {
        List<HoneyComb> edgeCombs = new ArrayList<>();
        int numRows = honeyCombsRowGrid.size();
        for (int i = 0; i < numRows; i++) {
            List<HoneyComb> row = honeyCombsRowGrid.get(i);
            edgeCombs.addAll(row);
        }
        int randomIndex = this.random.nextInt(edgeCombs.size());
        return edgeCombs.get(randomIndex);
    }   

    private void addFrontier(HoneyComb comb, Set<Integer> frontier, Set<Integer> mazeHoneyCombs) {
        for (int neighborHoneyCombId : comb.getNeighborHoneyCombs()) {
            if (neighborHoneyCombId != -1 && !mazeHoneyCombs.contains(neighborHoneyCombId)) {
                frontier.add(neighborHoneyCombId);
            }
        }
    }

    public Optional<HoneyComb> getHoneyCombById(int id) {
        for (List<HoneyComb> honeyCombsRow : honeyCombsRowGrid) {
            for(HoneyComb honeyComb : honeyCombsRow)
            if (honeyComb != null && honeyComb.getId() == id) {
                return Optional.of(honeyComb);
            }
        }
        return Optional.empty();
    }

    public int getHoneyCombCount(){
        int count = 0;
        for(int rowCount : this.calculateElementsEachRow){
            count += rowCount;
        }
        return count;
    }

    public List<List<HoneyComb>> getHoneyCombs() {
        return honeyCombsRowGrid;
    }

    @Override
    public String toString() {
        return "HoneyCombMaze [honeyCombsRowGrid=\n" + honeyCombsRowGrid + "]";
    }

    public String toSvg(String name) {
        StringBuilder svg = new StringBuilder();
        
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        
        int edgeCount = 0;
        
        for (List<HoneyComb> row : honeyCombsRowGrid) {
            for (HoneyComb comb : row) {
                if (comb != null) {
                    for (Edge edge : comb.getDefiningEdges()) {
                        minX = Math.min(minX, Math.min(edge.getStartPoint().getX(), edge.getEndPoint().getX()));
                        minY = Math.min(minY, Math.min(edge.getStartPoint().getY(), edge.getEndPoint().getY()));
                        maxX = Math.max(maxX, Math.max(edge.getStartPoint().getX(), edge.getEndPoint().getX()));
                        maxY = Math.max(maxY, Math.max(edge.getStartPoint().getY(), edge.getEndPoint().getY()));
                        if(edge.isWall()) edgeCount++;
                    }
                }
            }
        }
    
        System.out.println("Anzahl gezeichneter Edges: " + edgeCount);
    
        double width = maxX - minX + 10;
        double height = maxY - minY + 10;
    
        svg.append(String.format(Locale.US,
            "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%.2f\" height=\"%.2f\" viewBox=\"%.2f %.2f %.2f %.2f\">\n",
            width, height, minX - 5, minY - 5, width, height
        ));
        svg.append("<g stroke-width=\"0.4\" fill=\"none\">\n");
    
        for (List<HoneyComb> row : honeyCombsRowGrid) {
            for (HoneyComb comb : row) {
                if (comb != null) {
                    for (Edge edge : comb.getDefiningEdges()) {
                        if(edge.isWall()){
                            svg.append(String.format(Locale.US,
                            "<line x1=\"%.2f\" y1=\"%.2f\" x2=\"%.2f\" y2=\"%.2f\" stroke=\"%s\" />\n",
                            edge.getStartPoint().getX(), edge.getStartPoint().getY(),
                            edge.getEndPoint().getX(), edge.getEndPoint().getY(),
                            "black"
                        ));
                        }
                        
                    }
                }
            }
        }
        svg.append("</g>\n</svg>");
        File targetDir = new File("svg");
        if (!targetDir.exists()) {
            if (targetDir.mkdirs()) {
                System.out.println("Ordner erstellt: " + targetDir.getAbsolutePath());
            } else {
                System.err.println("Ordner konnte nicht erstellt werden!");
            }
        }

        File svgFile = new File(targetDir, name);
        try (PrintWriter out = new PrintWriter(svgFile)) {
            out.println(svg.toString());
            System.out.println("SVG-Datei erstellt: " + svgFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return svg.toString();
    }
}
