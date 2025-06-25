package com.github.htwkstudyprojects.honeybadgerhmg.model;

/**
 * Represents the possible directions (or sides) of a hexagonal honeycomb cell.
 * 
 * These directions are used to index the edges and neighboring cells of a honeycomb.
 * The index corresponds to the position in arrays storing edges or neighbors:
 * <pre>
 *   0 - UPPER_LEFT
 *1 - UPPER_RIGHT
 *2 - RIGHT
 *3 - LOWER_RIGHT
 *4 - LOWER_LEFT
 *5 - LEFT
 * <pre>
 * 
 * The directions follow a clockwise order starting from the upper-left side.
 */
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