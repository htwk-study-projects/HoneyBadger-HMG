package com.github.htwkstudyprojects.honeybadgerhmg.service;

import java.io.File;
import java.io.PrintWriter;

public class SvgService {

    public String mergeSvg(String svg1, String svg2, String fileName) {
        String content1 = extractSvgContent(svg1);
        String content2 = extractSvgContent(svg2);

        String svgHeader = extractSvgHeader(svg1);

        StringBuilder mergedSvg = new StringBuilder();
        mergedSvg.append(svgHeader);
        mergedSvg.append("\n");

        mergedSvg.append(content1);
        mergedSvg.append("\n");

        mergedSvg.append(content2);
        mergedSvg.append("\n");

        mergedSvg.append("</svg>");

        String mergedString = mergedSvg.toString();

        File targetDir = new File("svg");
        if (!targetDir.exists()) {
            if (targetDir.mkdirs()) {
                System.out.println("Directory created: " + targetDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create directory!");
            }
        }

        File svgFile = new File(targetDir, fileName);
        try (PrintWriter out = new PrintWriter(svgFile)) {
            out.println(mergedString);
            System.out.println("SVG file created: " + svgFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mergedString;
    }

    private static String extractSvgContent(String svg) {
        int start = svg.indexOf(">");
        int end = svg.lastIndexOf("</svg>");
        if (start >= 0 && end >= 0 && end > start) {
            return svg.substring(start + 1, end).trim();
        }
        return "";
    }

    private static String extractSvgHeader(String svg) {
        int start = svg.indexOf("<svg");
        int end = svg.indexOf(">", start);
        if (start >= 0 && end >= 0 && end > start) {
            return svg.substring(start, end + 1).trim();
        }
        return "<svg xmlns=\"http://www.w3.org/2000/svg\">";
    }
}

