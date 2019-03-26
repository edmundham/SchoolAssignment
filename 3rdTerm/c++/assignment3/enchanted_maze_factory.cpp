//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_maze_factory.hpp"
#include "enchanted_maze.hpp"
#include "enchanted_wall.hpp"
#include "enchanted_room.hpp"
#include "enchanted_door.hpp"

maze* enchanted_maze_factory::make_maze(room &room1, room &room2, door &door1) {
    enchanted_maze* enchanted_maze1 = new enchanted_maze{room1, room2, door1};
    return enchanted_maze1;
}

wall* enchanted_maze_factory::make_wall(string direction) {
    enchanted_wall* enchanted_wall1 = new enchanted_wall{direction};
    return enchanted_wall1;
}

room* enchanted_maze_factory::make_room(wall &north, wall &south, wall &west, wall &east) {
    enchanted_room* enchanted_room1 = new enchanted_room{south, north, west, east};
    return enchanted_room1;
}

door* enchanted_maze_factory::make_door(room &room1, room &room2) {
    enchanted_door* enchanted_door1 = new enchanted_door{room1, room2};
    return enchanted_door1;
}
