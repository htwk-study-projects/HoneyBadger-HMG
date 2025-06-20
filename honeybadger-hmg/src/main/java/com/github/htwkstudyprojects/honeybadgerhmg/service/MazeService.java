package com.github.htwkstudyprojects.honeybadgerhmg.service;

import java.util.List;

import com.github.htwkstudyprojects.honeybadgerhmg.model.HoneyCombMaze;
import com.github.htwkstudyprojects.honeybadgerhmg.model.MazeBadger;
import com.github.htwkstudyprojects.honeybadgerhmg.model.MazeFactory;
import com.github.htwkstudyprojects.honeybadgerhmg.model.SolutionGraphNode;
import com.github.htwkstudyprojects.honeybadgerhmg.repository.CliConfigRepository;
import com.github.htwkstudyprojects.honeybadgerhmg.repository.IMazeConfigRepository;
import com.github.htwkstudyprojects.honeybadgerhmg.repository.MazeConfigDto;

public class MazeService {

    private IMazeConfigRepository repo;
    private MazeFactory factory;

    public MazeService(){
        repo = new CliConfigRepository();
        factory = new MazeFactory();
    }

    public HoneyCombMaze generateMaze(String[] args) {
        MazeConfigDto config;
        try {
            config = repo.loadConfiguration(args);
            
            HoneyCombMaze maze = factory.generateMaze(config.getMazeType(), config.getRang(), 2);
            maze.toSvg("normal.svg");
            
            HoneyCombMaze badgedMaze = MazeBadger.processHoneyBadger(maze, config.getCellChangePercent());
            String svgString = badgedMaze.toSvg("badged.svg");

            List<SolutionGraphNode> sg = SolutionGraphNode.generateSolutionGraph(badgedMaze);
            SolutionGraphNode.toSvg(sg, "sg.svg");

            cppParser.convertSvgToCpp(svgString);
            return maze;
        } catch (Exception e) {
            System.out.println("Error during maze generation!");
            System.out.println("Please check the input parameters. Example usage:");
            System.out.println("  -t <mazeType> (e.g., honeycomb)");
            System.out.println("  -r <int> (rank > 0)");
            System.out.println("  -p <double> (cell change percentage between 0.0 and 100.0)");
            System.out.println("  -s <seed> (optional, for reproducible results)");
            System.out.println("Error details: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
