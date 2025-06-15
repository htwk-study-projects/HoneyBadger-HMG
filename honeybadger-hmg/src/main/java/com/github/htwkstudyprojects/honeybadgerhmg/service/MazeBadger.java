package com.github.htwkstudyprojects.honeybadgerhmg.service;

import com.github.htwkstudyprojects.honeybadgerhmg.model.HoneyCombMaze;
import com.github.htwkstudyprojects.honeybadgerhmg.model.IMaze;

public class MazeBadger {


    public IMaze processMazeBadger(IMaze maze) {
    return switch (maze) {
        case HoneyCombMaze honeyCombMaze -> (IMaze) honeyBadger(honeyCombMaze);

        default -> throw new UnsupportedOperationException("Maze type not supported: " + maze.getClass().getName());
    };
}

    private HoneyCombMaze honeyBadger(HoneyCombMaze maze) {

        throw new UnsupportedOperationException("Unimplemented method 'honeyBadger'");
    }
    
}