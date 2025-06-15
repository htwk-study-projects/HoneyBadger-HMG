package com.github.htwkstudyprojects.honeybadgerhmg;

import com.github.htwkstudyprojects.honeybadgerhmg.model.*;

/**
 * Hello world!
 *
 */
public class HoneyBadgerHMG{
    public static void main( String[] args ){

        MazeFactory f = new MazeFactory();

        HoneyCombMaze test = f.generateMaze("honeyComb", 1, 2);
        System.out.println(test);
    }
}
