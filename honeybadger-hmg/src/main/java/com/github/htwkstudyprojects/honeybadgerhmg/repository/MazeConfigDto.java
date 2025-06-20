package com.github.htwkstudyprojects.honeybadgerhmg.repository;

public class MazeConfigDto {

    private final String mazeType;
    private final int rang;
    private final double cellChangePercent;
    private final int edgeLength;
    private final Long seed; // Optional

    public MazeConfigDto(String type, int rang, double cellChangePercent, int edgeLength, Long seed) {
        this.mazeType = type;
        this.rang = rang;
        this.cellChangePercent = cellChangePercent;
        this.edgeLength = edgeLength;
        this.seed = seed;
    }

    public String getMazeType(){
        return mazeType;
    }

    public int getRang() {
        return rang;
    }

    public double getCellChangePercent() {
        return cellChangePercent;
    }

    public int getEdgeLength(){
        return edgeLength;
    }

    public Long getSeed() {
        return seed;
    }

    @Override
    public String toString() {
        return "MazeConfiguration{" +
                "rang=" + rang +
                ", cellChangePercent=" + cellChangePercent +
                ", edgeLength=" + edgeLength+
                ", seed=" + seed +
                '}';
    }
}
