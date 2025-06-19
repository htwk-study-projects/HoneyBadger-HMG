#include <iostream>
#include <list>
#include "maze_generator.h"

void MazeGenerator::generateMaze()
{
    {
        Mazepolygon poly;
        poly.coordinates.push_back({-1,73f, 1,00f});
        poly.coordinates.push_back({0,00f, 2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, 2,00f});
        poly.coordinates.push_back({1,73f, 1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, 1,00f});
        poly.coordinates.push_back({1,73f, -1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -1,00f});
        poly.coordinates.push_back({0,00f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-1,73f, -1,00f});
        poly.coordinates.push_back({-1,73f, 1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, 1,00f});
        poly.coordinates.push_back({3,46f, 2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, 2,00f});
        poly.coordinates.push_back({5,20f, 1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -1,00f});
        poly.coordinates.push_back({1,73f, 1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, 1,00f});
        poly.coordinates.push_back({6,93f, 2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, 2,00f});
        poly.coordinates.push_back({8,66f, 1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, 1,00f});
        poly.coordinates.push_back({8,66f, -1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, -1,00f});
        poly.coordinates.push_back({6,93f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -2,00f});
        poly.coordinates.push_back({5,20f, -1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-3,46f, -2,00f});
        poly.coordinates.push_back({-1,73f, -1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -2,00f});
        poly.coordinates.push_back({0,00f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-1,73f, -5,00f});
        poly.coordinates.push_back({-3,46f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-3,46f, -4,00f});
        poly.coordinates.push_back({-3,46f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -2,00f});
        poly.coordinates.push_back({1,73f, -1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -2,00f});
        poly.coordinates.push_back({3,46f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -4,00f});
        poly.coordinates.push_back({1,73f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -5,00f});
        poly.coordinates.push_back({0,00f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -4,00f});
        poly.coordinates.push_back({0,00f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -1,00f});
        poly.coordinates.push_back({6,93f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -2,00f});
        poly.coordinates.push_back({6,93f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -4,00f});
        poly.coordinates.push_back({5,20f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -4,00f});
        poly.coordinates.push_back({3,46f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -2,00f});
        poly.coordinates.push_back({8,66f, -1,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, -1,00f});
        poly.coordinates.push_back({10,39f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({10,39f, -2,00f});
        poly.coordinates.push_back({10,39f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({10,39f, -4,00f});
        poly.coordinates.push_back({8,66f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -4,00f});
        poly.coordinates.push_back({6,93f, -2,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-5,20f, -5,00f});
        poly.coordinates.push_back({-3,46f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-3,46f, -4,00f});
        poly.coordinates.push_back({-1,73f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-3,46f, -8,00f});
        poly.coordinates.push_back({-5,20f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-5,20f, -7,00f});
        poly.coordinates.push_back({-5,20f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -4,00f});
        poly.coordinates.push_back({1,73f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -5,00f});
        poly.coordinates.push_back({1,73f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -7,00f});
        poly.coordinates.push_back({0,00f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -8,00f});
        poly.coordinates.push_back({-1,73f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -5,00f});
        poly.coordinates.push_back({3,46f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -5,00f});
        poly.coordinates.push_back({5,20f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -7,00f});
        poly.coordinates.push_back({3,46f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -7,00f});
        poly.coordinates.push_back({1,73f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -5,00f});
        poly.coordinates.push_back({6,93f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, -7,00f});
        poly.coordinates.push_back({6,93f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -7,00f});
        poly.coordinates.push_back({5,20f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, -5,00f});
        poly.coordinates.push_back({10,39f, -4,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({10,39f, -4,00f});
        poly.coordinates.push_back({12,12f, -5,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({12,12f, -5,00f});
        poly.coordinates.push_back({12,12f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({12,12f, -7,00f});
        poly.coordinates.push_back({10,39f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-1,73f, -7,00f});
        poly.coordinates.push_back({0,00f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -8,00f});
        poly.coordinates.push_back({0,00f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-1,73f, -11,00f});
        poly.coordinates.push_back({-3,46f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-3,46f, -10,00f});
        poly.coordinates.push_back({-3,46f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -8,00f});
        poly.coordinates.push_back({1,73f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -8,00f});
        poly.coordinates.push_back({3,46f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -10,00f});
        poly.coordinates.push_back({1,73f, -11,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -10,00f});
        poly.coordinates.push_back({0,00f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -8,00f});
        poly.coordinates.push_back({5,20f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -8,00f});
        poly.coordinates.push_back({6,93f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -10,00f});
        poly.coordinates.push_back({5,20f, -11,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -11,00f});
        poly.coordinates.push_back({3,46f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -10,00f});
        poly.coordinates.push_back({3,46f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -8,00f});
        poly.coordinates.push_back({8,66f, -7,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({10,39f, -8,00f});
        poly.coordinates.push_back({10,39f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({10,39f, -10,00f});
        poly.coordinates.push_back({8,66f, -11,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -10,00f});
        poly.coordinates.push_back({6,93f, -8,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -13,00f});
        poly.coordinates.push_back({0,00f, -14,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({0,00f, -14,00f});
        poly.coordinates.push_back({-1,73f, -13,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({-1,73f, -13,00f});
        poly.coordinates.push_back({-1,73f, -11,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({1,73f, -11,00f});
        poly.coordinates.push_back({3,46f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -10,00f});
        poly.coordinates.push_back({5,20f, -11,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -13,00f});
        poly.coordinates.push_back({3,46f, -14,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({3,46f, -14,00f});
        poly.coordinates.push_back({1,73f, -13,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({5,20f, -11,00f});
        poly.coordinates.push_back({6,93f, -10,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, -11,00f});
        poly.coordinates.push_back({8,66f, -13,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({8,66f, -13,00f});
        poly.coordinates.push_back({6,93f, -14,00f});
        polygons.push_back(poly);
    }

    {
        Mazepolygon poly;
        poly.coordinates.push_back({6,93f, -14,00f});
        poly.coordinates.push_back({5,20f, -13,00f});
        polygons.push_back(poly);
    }

    std::cout << "Maze generated!" << std::endl;
}

