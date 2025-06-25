package com.github.htwkstudyprojects.honeybadgerhmg.repository;

/**
 * Repository implementation that loads maze configuration from command line arguments.
 * <p>
 * Expected arguments:
 * <ul>
 *   <li><code>-t &lt;type&gt;</code>: The type of maze (e.g., "honeycomb").</li>
 *   <li><code>-r &lt;rang&gt;</code>: The rang (size level) of the maze; must be &gt; 0.</li>
 *   <li><code>-el &lt;edgeLength&gt;</code>: The length of each edge of a honeycomb cell; must be &gt; 0.</li>
 *   <li><code>-cp &lt;cellChangePercent&gt;</code>: The percentage of cells to change (0.0 to 100.0).</li>
 *   <li><code>-p &lt;path&gt;</code>: The output path for generated files (must not be empty).</li>
 *   <li><code>-s &lt;seed&gt;</code>: (Optional) Seed for random number generation.</li>
 * </ul>
 * 
 * Throws an {@link IllegalArgumentException} if required parameters are missing or invalid.
 */
public class CliConfigRepository implements IMazeConfigRepository{

    /**
    * Parses the command line arguments and constructs a {@link MazeConfigDto} containing the configuration.
    *
    * @param args the command line arguments to parse
    * @return the populated {@link MazeConfigDto}
    * @throws IllegalArgumentException if required parameters are missing or invalid
    */
    @Override
    public MazeConfigDto loadConfiguration(String[] args) {
        String type = "";
        int rang = -1;
        int edgeLength = -1;
        double cellChangePercent = -1;
        String path = "";
        Long seed = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-r":
                    rang = Integer.parseInt(args[++i]);
                    break;
                case "-cp":
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
                case "-p":
                    path = args[++i];
                    break;
                default:
                    throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }

        if(type.trim().isEmpty()){
            throw new IllegalArgumentException("Type was empty");
        }

        if(rang <= 0) {
            throw new IllegalArgumentException("Rang must be > 0, but was: " + rang);
        }

        if(edgeLength == -1){
            throw new IllegalArgumentException("EdgeLength must be > 0, but was: " + edgeLength);
        }

        if(cellChangePercent < 0.0 || cellChangePercent > 100.0) {
            throw new IllegalArgumentException("cellChangePercent must be between 0.0 and 100.0, but was: " + cellChangePercent);
        }

        if(path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path is empty. Please provide the path where the C++ file should be generated.");
        }

        return new MazeConfigDto(type, rang, cellChangePercent, edgeLength, path, seed);
    }
}
