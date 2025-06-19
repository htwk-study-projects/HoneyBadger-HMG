package com.github.htwkstudyprojects.honeybadgerhmg;

import com.github.htwkstudyprojects.honeybadgerhmg.service.MazeService;

public class HoneyBadgerHMG{
    public static void main( String[] args ){

        MazeService controller = new MazeService();
        controller.generateMaze(args);
    }
}
