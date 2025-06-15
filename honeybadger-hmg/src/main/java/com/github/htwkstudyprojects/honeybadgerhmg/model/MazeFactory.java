package com.github.htwkstudyprojects.honeybadgerhmg.model;

public class MazeFactory {

    public IMaze generateMaze(String mazeType, int rang){
       return switch (mazeType.toLowerCase()){
            case "honeycomb" -> (IMaze) HoneyCombMaze.generateHoneyCombMaze(rang);

            default -> throw new IllegalArgumentException("Unknown maze type: " + mazeType);
        };
    }
    
}
