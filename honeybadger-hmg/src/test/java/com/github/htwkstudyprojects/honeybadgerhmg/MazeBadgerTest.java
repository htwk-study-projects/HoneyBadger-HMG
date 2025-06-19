package com.github.htwkstudyprojects.honeybadgerhmg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.github.htwkstudyprojects.honeybadgerhmg.model.HoneyCombMaze;
import com.github.htwkstudyprojects.honeybadgerhmg.model.MazeBadger;

public class MazeBadgerTest {

    @Test
    public void testProcessMazeBadger_invalidInput_returnsEmpty(){
        HoneyCombMaze maze = null;

        Optional<?> result = MazeBadger.processMazeBadger(maze, 150.0);

        assertTrue(result.isEmpty(), "Result should be empty for invalid percent");
    }
    
}
