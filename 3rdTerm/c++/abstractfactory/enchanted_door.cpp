//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_door.hpp"

enchanted_door::enchanted_door(room &room1, room &room2) : door(room1, room2) {
    this->maze_name = "Enchanted Fairy Land";
}

void enchanted_door::print() {
    cout << maze_name << " Door has two rooms." << endl;
}
