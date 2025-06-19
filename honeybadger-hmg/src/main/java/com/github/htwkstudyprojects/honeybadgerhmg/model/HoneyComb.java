package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.Arrays;

public class HoneyComb {
    private static int idCounter = 0;

    private final int id;
    private final Point centerPoint;
    private Edge[] definingEdges;
    private int[] neighborHoneyCombs;

    public HoneyComb(Point centerPoint, int edgeLength){
        this.id = idCounter;
        idCounter++;
        this.centerPoint = centerPoint;

        definingEdges = new Edge[6];
        this.calculateDefiningEdges(this.centerPoint, edgeLength);
        neighborHoneyCombs = new int[6];
        for(int i = 0; i < neighborHoneyCombs.length; i++) neighborHoneyCombs[i] = -1;
    }

    @Override
    public String toString() {
        return "HoneyComb [id=" + id + ", centerPoint=" + centerPoint + ", \ndefiningEdges= \n"
                + Arrays.toString(definingEdges) + ", neighborHoneyCombs=" + Arrays.toString(neighborHoneyCombs) + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HoneyComb other = (HoneyComb) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public Edge[] getDefiningEdges() {
        return definingEdges;
    }

    public void setDefiningEdges(Edge[] definingEdges) {
        this.definingEdges = definingEdges;
    }

    public int[] getNeighborHoneyCombs() {
        return neighborHoneyCombs;
    }

    public void setNeighborHoneyComb(Directions direction, int neighborId) {
        this.neighborHoneyCombs[direction.getIndex()] = neighborId;
    }

    public boolean isEdgePartOfHoneyComb(Edge edgeToDecide){
        if (edgeToDecide == null) return false;
        for(Edge edge : this.definingEdges){
            if(edgeToDecide.equals(edge)) return true;
        }
        return false;
    }

    public void calculateDefiningEdges(Point startPoint, int edgeLength) {
        final double[] angles = {150, 90, 30, -30, -90, -150, 150};

        double centerX = startPoint.getX();
        double centerY = startPoint.getY();
        
        Point[] tempPoints = new Point[7];
        for (int i = 0; i < tempPoints.length; i++) {
            double angle = Math.toRadians(angles[i]);
            double x = centerX + edgeLength * Math.cos(angle);
            double y = centerY + edgeLength * Math.sin(angle);
            tempPoints[i] = new Point(x, y);
        }

        Edge[] calculatedEdges = new Edge[6];
        for(int i = 0; i < tempPoints.length - 1; i++){
            calculatedEdges[i] = new Edge(tempPoints[i], tempPoints[i + 1]);
        }
        this.definingEdges = calculatedEdges;
    }

    public void removeWallBetween(int neighborId){
        Directions direction = Directions.ERROR;
        for(int i = 0; i < this.neighborHoneyCombs.length; i++){
            if(this.neighborHoneyCombs[i] == neighborId) direction = Directions.fromIndex(i);
        }
        if(direction != Directions.ERROR){
            System.out.println("Trying to remove wall between " + this.getId() + " and neighbor " + neighborId);
            System.out.println("Neighbors: " + Arrays.toString(this.neighborHoneyCombs));
            System.out.println("Chosen direction: " + direction);
            this.definingEdges[direction.getIndex()].setWall(false);
            System.out.println(this.definingEdges[direction.getIndex()].isWall());
        } 
        else System.out.println("error bei remove wall");
    }
}
