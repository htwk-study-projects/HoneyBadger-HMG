package com.github.htwkstudyprojects.honeybadgerhmg.model;

public class Edge {
    private final Point startPoint;
    private final Point endPoint;
    private boolean isWall;
    private boolean isDestructible;

    public Edge(Point start, Point end, boolean isWall, boolean isDestructible){
        this.startPoint = start;
        this.endPoint = end;
        this.isWall = isWall;
        this.isDestructible = isDestructible;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((startPoint == null) ? 0 : startPoint.hashCode());
        result = prime * result + ((endPoint == null) ? 0 : endPoint.hashCode());
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
        Edge other = (Edge) obj;
        if (startPoint == null) {
            if (other.startPoint != null)
                return false;
        } else if (!startPoint.equals(other.startPoint))
            return false;
        if (endPoint == null) {
            if (other.endPoint != null)
                return false;
        } else if (!endPoint.equals(other.endPoint))
            return false;
        return true;
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
