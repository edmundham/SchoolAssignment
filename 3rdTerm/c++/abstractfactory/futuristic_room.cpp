//
// Created by Sunguk Ham on 2018-11-29.
//

#include "futuristic_room.hpp"
futuristic_room::futuristic_room(wall &south, wall &north, wall &west, wall &east) : room(south, north, west, east) {
    maze_name = "Futuristic Dystopian Maze";
}

void futuristic_room::print() {
    cout << maze_name << " Room has four walls: " << endl;
    north->print();
    south->print();
    west->print();
    east->print();
    cout << endl;
}