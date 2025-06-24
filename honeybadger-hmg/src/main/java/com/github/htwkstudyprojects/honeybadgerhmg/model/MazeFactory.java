package com.github.htwkstudyprojects.honeybadgerhmg.model;

/**
* Factory class for creating different types of mazes.
* <p>
* Currently supports generation of honeycomb mazes.
*/
public class MazeFactory {

    /**
    * Generates a maze of the specified type.
    *
    * @param mazeType The type of maze to generate (e.g. "honeycomb").
    * @param rang The "range" or size parameter of the maze, usually representing
    *             how many layers or rings the maze should have.
    * @param edgeLength The length of the edges of each honeycomb cell.
    * @return A generated {@link HoneyCombMaze} instance.
    * @throws IllegalArgumentException If the maze type is unknown or unsupported.
    */
    public HoneyCombMaze generateMaze(String mazeType, int rang, int edgeLength){
       return switch (mazeType.toLowerCase()){
            case "honeycomb" -> HoneyCombMaze.generateHoneyCombMaze(rang,edgeLength);

            default -> throw new IllegalArgumentException("Unknown maze type: " + mazeType);
        };
    }
}
