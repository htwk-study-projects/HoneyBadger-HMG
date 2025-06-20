# HoneyBadger-HMG

HoneyBadger-HMG is currently a Java program for generating and manipulating honeycomb mazes, including cell badging (modification of individual cells) and solution graph visualization. The generated data can be exported as SVG files and translated into C++ code for a Gazebo interface.

## Features

- Generation of honeycomb mazes with configurable type, rank, and edge length.
- Application of an algorithm to randomly modify cells (we call it the HoneyBadger, but it is not an actual badger algorithm).
- Generation of a solution graph that describes the path through the maze.
- Export as SVG, with combined rendering of maze and solution graph.
- Conversion of SVG data into C++ code for further processing.
- Configurable via CLI arguments.

## CLI Parameters

| Parameter | Description | Example |
|------------|-------------|---------|
| `-t` | Maze type (e.g., `honeycomb`) | `-t honeycomb` |
| `-r` | Rank (size of the maze, >0) | `-r 3` |
| `-el` | Edge length (>0) | `-el 2` |
| `-p` | Percentage of cells to modify (0.0–100.0) | `-p 50.0` |
| `-s` | Optional seed for random generation | `-s 12345` |

## Example Execution

```bash
java -jar honeybadger-hmg.jar -t honeycomb -r 3 -el 2 -p 50.0 -s 12345
```

## Tech Stack

- **Java 21** — Main programming language
- **Maven** — Build automation and dependency management
- **JUnit 5 (Jupiter)** — Unit testing framework
- **Maven Compiler Plugin** — Compilation management
- **Maven Surefire Plugin** — Test execution
- **Maven Jar Plugin** — JAR packaging with manifest
- **Maven Clean Plugin** — Build cleanup
- **Maven Install Plugin** — Local installation of artifacts
- **Maven Deploy Plugin** — Deployment to remote repositories
- **Maven Site Plugin** — Project site generation
- **Maven Project Info Reports Plugin** — Generates project reports
- **C++ (generated output)** — The generated C++ code for integration with external systems (e.g., Gazebo)

