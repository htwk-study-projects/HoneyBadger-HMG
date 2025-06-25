package com.github.htwkstudyprojects.honeybadgerhmg.model;

import java.util.Optional;
import java.util.Random;

/**
 * The MazeBadger simulates a "badger" that modifies a given honeycomb maze
 * by randomly selecting honeycombs and changing their structure.
 * 
 * For selected honeycombs:
 * <ul>
 *   <li>All of their edges become indestructible walls.</li>
 *   <li>Neighbor honeycombs may have some walls removed to create path connections.</li>
 * </ul>
 */
public class MazeBadger {

    public static HoneyCombMaze processHoneyBadger(HoneyCombMaze maze, double cellChangePercent) {
        int honeyCombsToChange = (int) ((double) maze.getHoneyCombCount() * (cellChangePercent / 100.0));
        Random random = new Random();
        for(int i = 0; i < honeyCombsToChange; i++){
            int randomHoneyCombId = random.nextInt(maze.getHoneyCombCount());
            Optional<HoneyComb> opt= maze.getHoneyCombById(randomHoneyCombId);
            if(!opt.isPresent()){
                continue;
            }
            HoneyComb currentHoneyComb = opt.get();
            for(Edge e : currentHoneyComb.getDefiningEdges()){
                e.setDestructible(false);
                e.setWall(true);
            }

            for(Directions dir : Directions.values()){
                if(dir == Directions.ERROR) continue;
                int neighborCombInDirectionId = currentHoneyComb.getNeighborHoneyCombs()[dir.getIndex()];
                maze.getHoneyCombById(neighborCombInDirectionId).ifPresent(neighborCombInDirection ->{
                    if(neighborCombInDirection.getDefiningEdges()[(dir.getIndex() + 2) % 6].isDestructible()){
                        neighborCombInDirection.getDefiningEdges()[(dir.getIndex() + 2) % 6].setWall(false);
                    }
                    if(neighborCombInDirection.getDefiningEdges()[(dir.getIndex() + 4) % 6].isDestructible()){
                        neighborCombInDirection.getDefiningEdges()[(dir.getIndex() + 4) % 6].setWall(false);
                    }
                });    
            }
        }
        return maze;
    }
}