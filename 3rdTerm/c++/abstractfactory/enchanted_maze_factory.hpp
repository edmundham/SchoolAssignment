//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_ENCHANTED_MAZE_FACTORY_HPP
#define ABSTRACTFACTORY_ENCHANTED_MAZE_FACTORY_HPP


#include "maze_factory.hpp"

class enchanted_maze_factory : public maze_factory {
    maze* make_maze(room& room1, room& room2, door& door1) override;
    wall* make_wall(string direction) override;
    room* make_room(wall& north, wall& south, wall& west, wall& east) override;
    door* make_door(room& room1, room& room2) override;
};


#endif //ABSTRACTFACTORY_ENCHANTED_MAZE_FACTORY_HPP
