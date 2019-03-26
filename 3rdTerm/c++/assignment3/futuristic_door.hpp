//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_FUTURISTIC_DOOR_HPP
#define ABSTRACTFACTORY_FUTURISTIC_DOOR_HPP


#include "room.hpp"
#include "door.hpp"

class futuristic_door : public door {
public:
    futuristic_door() = default;
    futuristic_door(room& room1, room& room2);

};


#endif //ABSTRACTFACTORY_FUTURISTIC_DOOR_HPP
