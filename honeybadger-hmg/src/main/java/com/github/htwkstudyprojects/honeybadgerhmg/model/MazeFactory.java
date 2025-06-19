package com.github.htwkstudyprojects.honeybadgerhmg.model;

public class MazeFactory {

    public HoneyCombMaze generateMaze(String mazeType, int rang, int edgeLength){
       return switch (mazeType.toLowerCase()){
            case "honeycomb" -> HoneyCombMaze.generateHoneyCombMaze(rang,edgeLength);

            default -> throw new IllegalArgumentException("Unknown maze type: " + mazeType);
        };
    }
    
}
