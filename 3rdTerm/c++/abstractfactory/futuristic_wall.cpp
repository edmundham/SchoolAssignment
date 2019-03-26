//
// Created by Sunguk Ham on 2018-11-29.
//

#include "futuristic_wall.hpp"


futuristic_wall::futuristic_wall(string &direction) : wall(direction) {
    maze_name = "Futuristic Dystopian Maze";
}

void futuristic_wall::print() {
    cout << maze_name << " Wall is facing: " << direction << endl;
}