package com.github.htwkstudyprojects.honeybadgerhmg.repository;


public interface IMazeConfigRepository {
    MazeConfigDto loadConfiguration(String[] args);
}