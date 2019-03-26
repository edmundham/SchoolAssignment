//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_wall.hpp"


enchanted_wall::enchanted_wall(string &direction) : wall(direction) {
    maze_name = "Enchanted Fairy Land";
}

void enchanted_wall::print() {
    cout << maze_name << " Wall is facing: " << direction << endl;
}
