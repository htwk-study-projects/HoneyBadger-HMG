package com.github.htwkstudyprojects.honeybadgerhmg.model;

public enum Directions {
    UPPER_LEFT(0),
    UPPER_RIGHT(1),
    RIGHT(2),
    LOWER_RIGHT(3),
    LOWER_LEFT(4),
    LEFT(5);

    private final int index;

    Directions(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
