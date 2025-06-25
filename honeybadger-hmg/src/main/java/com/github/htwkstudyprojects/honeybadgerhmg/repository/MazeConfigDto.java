package com.github.htwkstudyprojects.honeybadgerhmg.repository;

/**
* Data Transfer Object (DTO) for maze configuration parameters.
* <p>
* This class holds the configuration values required to generate a maze,
* such as the type, size (rang), edge length, cell change percentage, output path, and an optional seed.
*/
public class MazeConfigDto {

    private final String mazeType;
    private final int rang;
    private final double cellChangePercent;
    private final int edgeLength;
    private final String pathForCpp;
    private final Long seed; // Optional, planned for future

    public MazeConfigDto(String type, int rang, double cellChangePercent, int edgeLength, String path, Long seed) {
        this.mazeType = type;
        this.rang = rang;
        this.cellChangePercent = cellChangePercent;
        this.edgeLength = edgeLength;
        this.pathForCpp = path;
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

    public String getPathForCpp(){
        return pathForCpp;
    }

    public Long getSeed() {
        return seed;
    }

    public String toString() {
        return "MazeConfigDto {" +
                "  mazeType='" + mazeType  +
                "  ,rang=" + rang +
                "  ,cellChangePercent=" + cellChangePercent +
                "  ,edgeLength=" + edgeLength +
                "  ,pathForCpp='" + pathForCpp +
                "  ,seed=" + seed +
                '}';
    }

}
