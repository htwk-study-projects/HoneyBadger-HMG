package com.github.htwkstudyprojects.honeybadgerhmg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class EdgeTest {

    static Stream<Arguments> equalsTestCases() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(2, 2);

        Edge edgeA = new Edge(p1, p2);
        Edge edgeB = new Edge(p1, p2);
        Edge edgeC = new Edge(p2, p1);
        Edge edgeD = new Edge(p3, p2);
        Edge edgeE = new Edge(p1, p4);

        return Stream.of(
            Arguments.of("equal same order", edgeA, edgeB, true),
            Arguments.of("equal reversed order", edgeA, edgeC, true),
            Arguments.of("equal with equivalent point", edgeA, edgeD, true),
            Arguments.of("not equal different point", edgeA, edgeE, false),
            Arguments.of("not equal null", edgeA, null, false),
            Arguments.of("not equal different type", edgeA, "string", false)
        );
    }

    @ParameterizedTest(name = "{0} - equals")
    @MethodSource("equalsTestCases")
    void testEquals(String name, Edge edge1, Object other, boolean expected) {
        assertEquals(expected, edge1.equals(other));
    }

    @ParameterizedTest(name = "{0} - hashCode")
    @MethodSource("equalsTestCases")
    void testHashCodeConsistency(String name, Edge edge1, Object other, boolean expected) {
        if (expected && other instanceof Edge) {
            assertEquals(edge1.hashCode(), other.hashCode());
        }
    }
}
