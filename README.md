# HoneyBadger-HMG

HoneyBadger-HMG is currently a Java program for generating and manipulating honeycomb mazes, including cell badging (modification of individual cells) and solution graph visualization. The generated data can be exported as SVG files and translated into C++ code for a Gazebo interface.

## Features

- Generation of honeycomb mazes with configurable type, rank, and edge length.
- Application of an algorithm to randomly modify cells (we call it the HoneyBadger, but it is not an actual badger algorithm).
- Generation of a solution graph that describes the path through the maze.
- Export as SVG, with combined rendering of maze and solution graph.
- Conversion of SVG data into C++ code for further processing.
- Configurable via CLI arguments.
- Saves the C++ file to the path specified by the user

## Build jar with maven
To build the project using Maven.

> ⚠️ **Requirement:** You need to have [Maven](https://maven.apache.org/) installed.

> 💡 **Install instructions:**
>
> - **macOS:**  
>   `brew install maven`
>
> - **Linux (Debian/Ubuntu):**  
>   `sudo apt update && sudo apt install maven`
>
> - **Windows:**  
>   1. Download the installer from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)  
>   2. Unzip it and set the `MAVEN_HOME` and update your `PATH` environment variable  
>   3. Verify with `mvn -v`


⚠️ **Important:** Use the command below in the **./HoneyBagder-HMG/honeybadger-hmg/** directory:

```bash
mvn clean install
```
This will create the JAR file in the **target** directory:
```bash
honeyBadger-hmg-1.0-SNAPSHOT.jar
```

## CLI Parameters

| Parameter | Description | Example |
|------------|-------------|---------|
| `-t` | Maze type (e.g., `honeycomb`) | `-t honeycomb` |
| `-r` | Rank (size of the maze, >0) | `-r 3` |
| `-el` | Edge length (>0) | `-el 2` |
| `-cp` | Percentage of cells to modify (0.0–100.0) | `-p 50.0` |
| `-p`| Path for generated C++ file | `-p ./path/path`|

## Example Execution

⚠️ **Important:** Use the command below in the **./HoneyBagder-HMG/honeybadger-hmg/** directory:

```bash
java -jar target/honeyBadger-hmg-1.0-SNAPSHOT.jar -t honeycomb -r 3 -el 2 -cp 20.0 -p ./c++
```

## After successful execution
- SVG files were successfully generated for quick viewing:
    - badged.svg — The maze with modified (badged) cells to make it more interesting
    - merged.svg — Combined view of the maze and the path graph
    -   normal.svg — Basic maze layout
    - sg.svg — Solution graph
- The output was also parsed into a C++ file.
- A folder and its corresponding C++ File were created at the path specified by the user
- ## Terminal output
    - **SVG file created:** /Users/<username>/HoneyBadger-HMG/honeybadger-hmg/svg/normal.svg
    - **SVG file created:** /Users/<username>/HoneyBadger-HMG/honeybadger-hmg/svg/badged.svg
    - **SVG file created:** /Users/<username>/HoneyBadger-HMG/honeybadger-hmg/svg/sg.svg
    - **SVG file created:** /Users/<username>/HoneyBadger-HMG/honeybadger-hmg/svg/merged.svg
    - **C++ file "maze_generator.cpp" created:** /Users/<username>/HoneyBadger-HMG/honeybadger-hmg/./c++/maze_generator.cpp
 


## Tech Stack

- **Java 21** — Main programming language
- **Maven** — Build automation and dependency management
- **JUnit 5 (Jupiter)** — Unit testing framework
- **C++ (generated output)** — The generated C++ code for integration with external systems (e.g., Gazebo)

