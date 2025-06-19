package com.github.htwkstudyprojects.honeybadgerhmg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PointTest {

    static Stream<Arguments> equalsTestCases() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(0, 1);

        return Stream.of(
            Arguments.of("same object", p1, p1, true),
            Arguments.of("equal values", p1, p2, true),
            Arguments.of("different values", p1, p3, false),
            Arguments.of("different x or y", p1, p4, false),
            Arguments.of("null comparison", p1, null, false),
            Arguments.of("different type", p1, "string", false)
        );
    }

    @ParameterizedTest(name = "{0} - equals")
    @MethodSource("equalsTestCases")
    void testEquals(String name, Point p1, Object other, boolean expected) {
        assertEquals(expected, p1.equals(other), "equals failed for: " + name);
    }

    @ParameterizedTest(name = "{0} - hashCode")
    @MethodSource("equalsTestCases")
    void testHashCode(String name, Point p1, Object other, boolean expected) {
        if (expected && other instanceof Point) {
            assertEquals(p1.hashCode(), other.hashCode(), "hashCode mismatch for: " + name);
        }
    }

    static Stream<Arguments> distanceTestCases() {
    return Stream.of(
        Arguments.of("distance between (0,0) and (3,4)", new Point(0, 0), new Point(3, 4), 5.0),
        Arguments.of("distance to self", new Point(0, 0), new Point(0, 0), 0.0),
        Arguments.of("distance between (0,0) and (1,1)", new Point(0, 0), new Point(1, 1), Math.sqrt(2)),
        Arguments.of("distance symmetry", new Point(3, 4), new Point(0, 0), 5.0)
    );
}

    @ParameterizedTest(name = "{0}")
    @MethodSource("distanceTestCases")
    void testDistanceTo(String name, Point p1, Point p2, double expectedDistance) {
        assertEquals(expectedDistance, p1.distanceTo(p2), 1e-9);
    }
}
