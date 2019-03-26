//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_room.hpp"

enchanted_room::enchanted_room(wall &south, wall &north, wall &west, wall &east) : room(south, north, west, east) {
    maze_name = "Enchanted Fairy Land";
}

void enchanted_room::print() {
    cout << maze_name << " Room has four walls: " << endl;
    north->print();
    south->print();
    west->print();
    east->print();
    cout << endl;
}