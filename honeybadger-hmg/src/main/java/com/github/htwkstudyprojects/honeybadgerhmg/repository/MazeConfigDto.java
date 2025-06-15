package com.github.htwkstudyprojects.honeybadgerhmg.repository;

public class MazeConfigDto {

    private final int rang;
    private final double cellChangePercent;
    private final Long seed; // Optional

    public MazeConfigDto(int rang, double cellChangePercent, Long seed) {
        this.rang = rang;
        this.cellChangePercent = cellChangePercent;
        this.seed = seed;
    }

    public int getRang() {
        return rang;
    }

    public double getCellChangePercent() {
        return cellChangePercent;
    }

    public Long getSeed() {
        return seed;
    }

    @Override
    public String toString() {
        return "MazeConfiguration{" +
                "rang=" + rang +
                ", cellChangePercent=" + cellChangePercent +
                ", seed=" + seed +
                '}';
    }
}
