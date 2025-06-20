package com.github.htwkstudyprojects.honeybadgerhmg.repository;

public class CliConfigRepository implements IMazeConfigRepository{

    @Override
    public MazeConfigDto loadConfiguration(String[] args) {
        String type = "";
        int rang = -1;
        int edgeLength = -1;
        double cellChangePercent = -1;
        Long seed = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-r":
                    rang = Integer.parseInt(args[++i]);
                    break;
                case "-p":
                    cellChangePercent = Double.parseDouble(args[++i]);
                    break;
                case "-s":
                    seed = Long.parseLong(args[++i]);
                    break;
                case "-t":
                    type = args[++i];
                    break;
                case "-el":
                    edgeLength = Integer.parseInt(args[++i]);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }

        if(type == ""){
            throw new IllegalArgumentException("Type was empty");
        }

        if (rang <= 0) {
            throw new IllegalArgumentException("Rang must be > 0, but was: " + rang);
        }

        if(edgeLength == -1){
            throw new IllegalArgumentException("EdgeLength must be > 0, but was: " + edgeLength);
        }

        if (cellChangePercent < 0.0 || cellChangePercent > 100.0) {
            throw new IllegalArgumentException("cellChangePercent must be between 0.0 and 100.0, but was: " + cellChangePercent);
        }

        return new MazeConfigDto(type, rang, cellChangePercent, edgeLength, seed);
    }
    
}
