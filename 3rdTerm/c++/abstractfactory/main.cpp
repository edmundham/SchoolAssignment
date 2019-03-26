#include <iostream>
#include "maze_game.hpp"
#include "enchanted_maze_factory.hpp"
#include "futuristic_maze_factory.hpp"

int main() {
    maze_game mazeGame;
    maze_factory* mazeFactory = new enchanted_maze_factory();

    maze* maze1 = mazeGame.create_maze(mazeFactory);
    maze1->print();

    mazeFactory = new futuristic_maze_factory();

    maze1 = mazeGame.create_maze(mazeFactory);
    maze1->print();

    return 0;
}