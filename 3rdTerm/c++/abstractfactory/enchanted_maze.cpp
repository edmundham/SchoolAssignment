//
// Created by Sunguk Ham on 2018-11-29.
//

#include "enchanted_maze.hpp"

enchanted_maze::enchanted_maze(room &room1, room &room2, door &door1) : maze(room1, room2, door1) {
    this->maze_name = "Enchanted Fairy Land";
}

void enchanted_maze::print() {
    cout << maze_name << " Maze have two rooms and one door." << endl;
    cout << "First room is: " << endl;
    room1->print();
    cout << "Second room is: " << endl;
    room2->print();
    cout << "Door is: ";
    door1->print();
}
