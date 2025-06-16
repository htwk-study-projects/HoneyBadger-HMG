package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.Arrays;

public class HoneyComb {
    private static int idCounter = 0;

    private final int id;
    private Edge[] definingEdges;
    private HoneyComb[] neighborHoneyCombs;

    public HoneyComb(){
        this.id = idCounter;
        idCounter++;

        definingEdges = new Edge[6];
        neighborHoneyCombs = new HoneyComb[6];
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

    public Edge[] getDefiningEdges() {
        return definingEdges;
    }

    public void setDefiningEdges(Edge[] definingEdges) {
        this.definingEdges = definingEdges;
    }

    public HoneyComb[] getNeighborHoneyCombs() {
        return neighborHoneyCombs;
    }

    public void setNeighborHoneyCombs(HoneyComb[] neighborHoneyCombs) {
        this.neighborHoneyCombs = neighborHoneyCombs;
    }

    public boolean isEdgePartOfHoneyComb(Edge edgeToDecide){
        if (edgeToDecide == null) return false;
        for(Edge edge : this.definingEdges){
            if(edgeToDecide.equals(edge)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HoneyComb [definingEdges=" + Arrays.toString(definingEdges) + "]\n";
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
        for(int i = 0; i < tempPoints.length; i++){
            calculatedEdges[i] = new Edge(tempPoints[i], tempPoints[i + 1]);
        }
        this.definingEdges = calculatedEdges;
    }
}
