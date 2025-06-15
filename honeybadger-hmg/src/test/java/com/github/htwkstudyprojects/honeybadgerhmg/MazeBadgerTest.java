package com.github.htwkstudyprojects.honeybadgerhmg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.github.htwkstudyprojects.honeybadgerhmg.model.HoneyCombMaze;
import com.github.htwkstudyprojects.honeybadgerhmg.model.IMaze;
import com.github.htwkstudyprojects.honeybadgerhmg.service.MazeBadger;

public class MazeBadgerTest {

    @Test
    public void testProcessMazeBadger_invalidInput_returnsEmpty(){
        HoneyCombMaze maze = null;
        MazeBadger badger = new MazeBadger();

        Optional<?> result = badger.processMazeBadger((IMaze) maze, 150.0);

        assertTrue(result.isEmpty(), "Result should be empty for invalid percent");
    }
    
}
