//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_MAZE_FACTORY_HPP
#define ABSTRACTFACTORY_MAZE_FACTORY_HPP

#include "maze.hpp"
#include "wall.hpp"
#include "room.hpp"
#include "door.hpp"

class maze_factory {

public:
    maze_factory() = default;
    virtual ~maze_factory() = default;

    virtual maze* make_maze(room& room1, room& room2, door& door1) = 0;
    virtual wall* make_wall(string direction) = 0;
    virtual room* make_room(wall& north, wall& south, wall& west, wall& east) = 0;
    virtual door* make_door(room& room1, room& room2) = 0;

};


#endif //ABSTRACTFACTORY_MAZE_FACTORY_HPP
