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
