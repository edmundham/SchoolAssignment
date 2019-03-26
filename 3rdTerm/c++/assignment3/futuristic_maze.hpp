//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_FUTURISTIC_MAZE_HPP
#define ABSTRACTFACTORY_FUTURISTIC_MAZE_HPP


#include "maze.hpp"

class futuristic_maze : public maze {
public:
    futuristic_maze() = default;
    futuristic_maze(room& room1, room& room2, door& door1);

};


#endif //ABSTRACTFACTORY_FUTURISTIC_MAZE_HPP
