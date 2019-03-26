//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_maze.hpp"

enchanted_maze::enchanted_maze(room &room1, room &room2, door &door1) : maze(room1, room2, door1) {
    this->maze_name = "Enchanted Fairy Land";
}
