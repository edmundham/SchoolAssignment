//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_ENCHANTED_MAZE_HPP
#define ABSTRACTFACTORY_ENCHANTED_MAZE_HPP


#include "maze.hpp"

class enchanted_maze : public maze {
public:
    enchanted_maze() = default;
    enchanted_maze(room& room1, room& room2, door& door1);

    void print() override;

};


#endif //ABSTRACTFACTORY_ENCHANTED_MAZE_HPP
