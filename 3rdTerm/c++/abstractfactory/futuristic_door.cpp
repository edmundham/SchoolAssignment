//
// Created by Sunguk Ham on 2018-11-29.
//

#include "futuristic_door.hpp"

futuristic_door::futuristic_door(room &room1, room &room2) : door(room1, room2) {
    this->maze_name = "Futuristic Dystopian Maze";
}

void futuristic_door::print() {
    cout << maze_name << " Door has two rooms." << endl;
}