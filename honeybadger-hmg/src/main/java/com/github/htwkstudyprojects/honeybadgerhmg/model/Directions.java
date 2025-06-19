package com.github.htwkstudyprojects.honeybadgerhmg.model;

public enum Directions {
    UPPER_LEFT(0),
    UPPER_RIGHT(1),
    RIGHT(2),
    LOWER_RIGHT(3),
    LOWER_LEFT(4),
    LEFT(5),
    ERROR(-1);

    private final int index;

    Directions(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

   public static Directions fromIndex(int index) {
        for (Directions dir : Directions.values()) {
            if (dir.index == index) {
                return dir;
            }
        }
        return ERROR;
    }
}