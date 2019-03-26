//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_room.hpp"

enchanted_room::enchanted_room(wall &south, wall &north, wall &west, wall &east) : room(south, north, west, east) {
    maze_name = "Enchanted Fairy Land";
}
