//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_MAZE_GAME_HPP
#define ABSTRACTFACTORY_MAZE_GAME_HPP


#include "maze.hpp"
#include "maze_factory.hpp"

class maze_game {

public:
    maze* create_maze(maze_factory* mazeFactory);

private:


};


#endif //ABSTRACTFACTORY_MAZE_GAME_HPP
