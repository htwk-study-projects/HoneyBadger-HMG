package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MazeBadger {

    public static Optional<HoneyCombMaze> processMazeBadger(HoneyCombMaze maze, double cellChangePercent) {
        try {
            if(cellChangePercent > 100.0 || cellChangePercent < 0.0) throw new IllegalStateException("Invalid cellChangePercent value: " + cellChangePercent);

            HoneyCombMaze result = honeyBadger(maze, cellChangePercent);
            return Optional.of(result);
        } catch (Exception e) {
            System.err.println("MazeBadger processing failed: " + e.getMessage());
            return Optional.empty();
        }
    }

    // TODO: geht so nicht, copy machen und das löschen neu machen
    private static HoneyCombMaze honeyBadger(HoneyCombMaze maze, double cellChangePercent) {
        HoneyCombMaze mazeCopy = maze.
        List<List<HoneyComb>> honeyCombsList = maze.getHoneyCombs();
        List<HoneyComb> honeyCombs = honeyCombsList.stream().flatMap(List::stream).toList();

        if(honeyCombs.isEmpty()) throw new IllegalStateException("Maze contains no honeycombs");

        Random random = new Random();
        int honeyCombsToChange = (int)((double)maze.size() * cellChangePercent);

        for(int i = 0; i < honeyCombsToChange; i++){
            HoneyComb selectedHoneyComb = honeyCombs.get(random.nextInt(honeyCombs.size()));

            for(Edge edge : selectedHoneyComb.getDefiningEdges()){
                edge.setWall(true);
                edge.setDestructible(false);

            }

            for(int neighborId : selectedHoneyComb.getNeighborHoneyCombs()){
                if (neighborId != -1) {
                    maze.getHoneyCombById(neighborId).ifPresent(neighbor -> {
                    for (Edge edge : neighbor.getDefiningEdges()){
                            if (!selectedHoneyComb.isEdgePartOfHoneyComb(edge) && edge.isDestructible()) {
                                edge.setWall(false);
                            };
                    }});
                }
            }
        }
        return maze;
    }
}