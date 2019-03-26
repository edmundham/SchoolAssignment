//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_MAZE_HPP
#define ABSTRACTFACTORY_MAZE_HPP

#include <iostream>
#include "door.hpp"
#include "wall.hpp"

using namespace std;

class maze {

public:
    maze() = default;

    maze(room& room1, room& room2, door& door1) {
        this->room1 = &room1;
        this->room2 = &room2;
        this->door1 = &door1;
    }

    virtual void print() {
        cout << "Maze have two rooms and one door." << endl;
        cout << "First room is: " << endl;
        room1->print();
        cout << "Second room is: " << endl;
        room2->print();
        cout << "Door is: ";
        door1->print();
    }

protected:
    room* room1;
    room* room2;
    door* door1;
    string maze_name = "";

};


#endif //ABSTRACTFACTORY_MAZE_HPP
