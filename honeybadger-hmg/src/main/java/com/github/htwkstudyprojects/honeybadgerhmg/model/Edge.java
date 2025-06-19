package com.github.htwkstudyprojects.honeybadgerhmg.model;

public class Edge {
    private final Point startPoint;
    private final Point endPoint;
    private boolean isWall;
    private boolean isDestructible;

    public Edge(Point start, Point end){
        this.startPoint = start;
        this.endPoint = end;
        this.isWall = true;
        this.isDestructible = true;
    }

    @Override
    public String toString() {
        return "Edge [startPoint=" + startPoint + ", endPoint=" + endPoint + ", isWall: " + isWall + "]\n";
    }

    @Override
    public int hashCode() {
        int hashStart = (startPoint == null) ? 0 : startPoint.hashCode();
        int hashEnd = (endPoint == null) ? 0 : endPoint.hashCode();

        return hashStart + hashEnd;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Edge other = (Edge) obj;
        boolean directEqual = (startPoint == null ? other.startPoint == null : startPoint.equals(other.startPoint)) &&
                              (endPoint == null ? other.endPoint == null : endPoint.equals(other.endPoint));
        boolean reversedEqual = (startPoint == null ? other.endPoint == null : startPoint.equals(other.endPoint)) &&
                                (endPoint == null ? other.startPoint == null : endPoint.equals(other.startPoint));
        return directEqual || reversedEqual;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setWall(boolean isWall) {
        this.isWall = isWall;
    }

    public void setDestructible(boolean isDestructible) {
        this.isDestructible = isDestructible;
    }

    public boolean isWall() {
        return isWall;
    }

    public boolean isDestructible() {
        return isDestructible;
    }
    
}
