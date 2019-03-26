//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_ROOM_HPP
#define ABSTRACTFACTORY_ROOM_HPP

#include "wall.hpp"
#include <iostream>

using namespace std;

class room {

public:
    room(wall& south, wall& north, wall& west, wall& east) {
        this->south = &south;
        this->north = &north;
        this->west = &west;
        this->east = &east;
    }

    room() = default;

    virtual void print() {
        cout << "Room has four walls: " << endl;
        north->print();
        south->print();
        west->print();
        east->print();
        cout << endl;
    }

protected:
    wall* south;
    wall* north;
    wall* west;
    wall* east;
    string maze_name = "";
};


#endif //ABSTRACTFACTORY_ROOM_HPP
