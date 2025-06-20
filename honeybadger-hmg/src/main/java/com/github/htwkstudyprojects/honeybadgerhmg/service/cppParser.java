package com.github.htwkstudyprojects.honeybadgerhmg.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.htwkstudyprojects.honeybadgerhmg.model.SolutionGraphNode;

public class cppParser {

    public static String convertToCpp(String svg, List<SolutionGraphNode> solutionGraph) {
        String polygonPart = generatePolygonFromSvgCpp(svg);
        String graphPart = generateSolutionGraphCpp(solutionGraph);

        String cppCode = "#include <iostream>\n"
                       + "#include \"maze_generator.h\"\n\n"
                       + "void MazeGenerator::generateMaze()\n"
                       + "{\n"
                       + polygonPart
                       + "\n"
                       + graphPart
                       + "\n    std::cout << \"Maze and SolutionGraph generated!\" << std::endl;\n"
                       + "}\n";

        File targetDir = new File("c++");
        if (!targetDir.exists()) {
            targetDir.mkdirs();
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

    private static String generatePolygonFromSvgCpp(String svg) {
        Pattern linePattern = Pattern.compile(
            "<line x1=\"([-\\d.]+)\" y1=\"([-\\d.]+)\" x2=\"([-\\d.]+)\" y2=\"([-\\d.]+)\""
        );
        Matcher lineMatcher = linePattern.matcher(svg);

        StringBuilder sb = new StringBuilder();

        while (lineMatcher.find()) {
            float x1 = Float.parseFloat(lineMatcher.group(1));
            float y1 = Float.parseFloat(lineMatcher.group(2));
            float x2 = Float.parseFloat(lineMatcher.group(3));
            float y2 = Float.parseFloat(lineMatcher.group(4));

            sb.append(String.format(Locale.US,
                "    {\n" +
                "        Mazepolygon poly;\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        polygons.push_back(poly);\n" +
                "    }\n",
                x1, y1, x2, y2
            ));
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

            sb.append(String.format(Locale.US,
                "    {\n" +
                "        Mazepolygon poly;\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        poly.coordinates.push_back({%.2ff, %.2ff});\n" +
                "        polygons.push_back(poly);\n" +
                "    }\n",
                x1, y1, x2, y1, x2, y2, x1, y2
            ));
        }

        return sb.toString();
    }

    private static String generateSolutionGraphCpp(List<SolutionGraphNode> solutionGraph) {
        StringBuilder sb = new StringBuilder();
        Map<SolutionGraphNode, String> nodeNames = new HashMap<>();
        int nodeIndex = 0;

        for (SolutionGraphNode node : solutionGraph) {
            String nodeName = "node" + (++nodeIndex);
            nodeNames.put(node, nodeName);
            sb.append(String.format(Locale.US,
                "    SolutionGraphNode %s;\n" +
                "    %s.coordinate = {%.2ff, %.2ff};\n",
                nodeName, nodeName,
                node.getNodePoint().getX(),
                node.getNodePoint().getY()
            ));
        }

        for (SolutionGraphNode node : solutionGraph) {
            String nodeName = nodeNames.get(node);
            for (SolutionGraphNode neighbor : node.getNeighborNodes()) {
                String neighborName = nodeNames.get(neighbor);
                sb.append(String.format(
                    "    %s.neighbors.push_back(&%s);\n",
                    nodeName, neighborName
                ));
            }
        }

        for (SolutionGraphNode node : solutionGraph) {
            String nodeName = nodeNames.get(node);
            sb.append(String.format(
                "    solutionGraph.push_back(%s);\n",
                nodeName
            ));
        }

        return sb.toString();
    }

}
