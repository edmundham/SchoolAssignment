//
// Created by Sunguk Ham on 2018-11-29.
//

#include "futuristic_room.hpp"
futuristic_room::futuristic_room(wall &south, wall &north, wall &west, wall &east) : room(south, north, west, east) {
    maze_name = "Futuristic Dystopian Maze";
}
