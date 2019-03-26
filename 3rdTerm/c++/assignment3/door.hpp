//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_DOOR_HPP
#define ABSTRACTFACTORY_DOOR_HPP

#include <iostream>

using namespace std;

#include "room.hpp"

class door {

public:
    door(room& room1, room& room2) {
        this->first_room = &room1;
        this->second_room = &room2;
    };

    door() = default;

    virtual void print() {
        cout << "Door has two rooms." << endl;
    }

protected:
    room* first_room;
    room* second_room;
    string maze_name = "";
};


#endif //ABSTRACTFACTORY_DOOR_HPP
