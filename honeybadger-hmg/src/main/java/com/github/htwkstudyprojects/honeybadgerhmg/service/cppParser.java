package com.github.htwkstudyprojects.honeybadgerhmg.service;

import java.util.regex.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class cppParser {

    /**
     * Converts SVG <line> elements into C++ Maze polygon code.
     *
     * @param svg the SVG content as a string
     * @return generated C++ code for MazeGenerator::generateMaze()
     */
    public static String convertSvgToCpp(String svg) {
        Pattern linePattern = Pattern.compile(
            "<line x1=\"([-\\d.]+)\" y1=\"([-\\d.]+)\" x2=\"([-\\d.]+)\" y2=\"([-\\d.]+)\""
        );
        Matcher lineMatcher = linePattern.matcher(svg);

        List<String> polygonBlocks = new ArrayList<>();

        while (lineMatcher.find()) {
            float x1 = Float.parseFloat(lineMatcher.group(1));
            float y1 = Float.parseFloat(lineMatcher.group(2));
            float x2 = Float.parseFloat(lineMatcher.group(3));
            float y2 = Float.parseFloat(lineMatcher.group(4));

            String block = String.format(Locale.US,
                "    {\n" +
                "        Mazepolygon poly;\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        polygons.push_back(poly);\n" +
                "    }", x1, y1, x2, y2
            );
            polygonBlocks.add(block);
        }

        Pattern rectPattern = Pattern.compile(
        "<rect x=\"([-\\d.]+)\" y=\"([-\\d.]+)\" width=\"([-\\d.]+)\" height=\"([-\\d.]+)\""
        );

        Matcher rectMatcher = rectPattern.matcher(svg);

        while (rectMatcher.find()) {
            float x = Float.parseFloat(rectMatcher.group(1));
            float y = Float.parseFloat(rectMatcher.group(2));
            float w = Float.parseFloat(rectMatcher.group(3));
            float h = Float.parseFloat(rectMatcher.group(4));

            float x1 = x;
            float y1 = y;
            float x2 = x + w;
            float y2 = y + h;

            polygonBlocks.add(String.format(Locale.US,
                "    {\n" +
                "        Mazepolygon poly;\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" + // oben links
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" + // oben rechts
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" + // unten rechts
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" + // unten links
                "        polygons.push_back(poly);\n" +
                "    }",
                x1, y1,
                x2, y1,
                x2, y2,
                x1, y2
            ));
        }

        String cppCode = "#include <iostream>\n"
                       + "#include <list>\n"
                       + "#include \"maze_generator.h\"\n\n"
                       + "void MazeGenerator::generateMaze()\n"
                       + "{\n"
                       + String.join("\n\n", polygonBlocks)
                       + "\n\n    std::cout << \"Maze generated!\" << std::endl;\n"
                       + "}\n";

        File targetDir = new File("c++");
        if (!targetDir.exists()) {
            if (targetDir.mkdirs()) {
                System.out.println("Ordner erstellt: " + targetDir.getAbsolutePath());
            } else {
                System.err.println("Ordner konnte nicht erstellt werden!");
            }
        }

        File cppFile = new File(targetDir, "maze_generator.cpp");
        try (PrintWriter out = new PrintWriter(cppFile)) {
            out.println(cppCode);
            System.out.println("maze_generator.cpp wurde erstellt: " + cppFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cppCode;
    }
}
