package com.github.htwkstudyprojects.honeybadgerhmg.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.github.htwkstudyprojects.honeybadgerhmg.model.Edge;
import com.github.htwkstudyprojects.honeybadgerhmg.model.HoneyComb;
import com.github.htwkstudyprojects.honeybadgerhmg.model.HoneyCombMaze;
import com.github.htwkstudyprojects.honeybadgerhmg.model.IMaze;

public class MazeBadger {

    public Optional<IMaze> processMazeBadger(IMaze maze, double cellChangePercent) {
        try {
            if(cellChangePercent > 100.0 || cellChangePercent < 0.0) throw new IllegalStateException("Invalid cellChangePercent value: " + cellChangePercent);

            IMaze result = switch (maze) {
                case HoneyCombMaze honeyCombMaze -> (IMaze) honeyBadger(honeyCombMaze, cellChangePercent);

                default -> throw new UnsupportedOperationException("Maze type not supported: " + maze.getClass().getName());
            };
            return Optional.of(result);
        } catch (Exception e) {
            System.err.println("MazeBadger processing failed: " + e.getMessage());
            return Optional.empty();
        }
    }

    private HoneyCombMaze honeyBadger(HoneyCombMaze maze, double cellChangePercent) {
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