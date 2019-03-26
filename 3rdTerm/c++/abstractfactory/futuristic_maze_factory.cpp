//
// Created by Sunguk Ham on 2018-11-29.
//

#include "futuristic_maze_factory.hpp"
#include "futuristic_maze.hpp"
#include "futuristic_wall.hpp"
#include "futuristic_door.hpp"
#include "futuristic_room.hpp"

maze* futuristic_maze_factory::make_maze(room &room1, room &room2, door &door1) {
    futuristic_maze* futuristic_maze1 = new futuristic_maze{room1, room2, door1};
    return futuristic_maze1;
}

wall* futuristic_maze_factory::make_wall(string direction) {
    futuristic_wall* futuristic_wall1 = new futuristic_wall{direction};
    return futuristic_wall1;
}

room* futuristic_maze_factory::make_room(wall &north, wall &south, wall &west, wall &east) {
    futuristic_room* futuristic_room1 = new futuristic_room{south, north, west, east};
    return futuristic_room1;
}

door* futuristic_maze_factory::make_door(room &room1, room &room2) {
    futuristic_door* futuristic_door1 = new futuristic_door{room1, room2};
    return futuristic_door1;
}
