package com.github.htwkstudyprojects.honeybadgerhmg.model;

public class MazeFactory {

    public IMaze generateMaze(String mazeType, int size){
       return switch (mazeType.toLowerCase()){
            case "honeycomb" -> (IMaze) HoneyCombMaze.generateHoneyCombMaze(size);

            default -> throw new IllegalArgumentException("Unknown maze type: " + mazeType);
        };
    }
    
}
