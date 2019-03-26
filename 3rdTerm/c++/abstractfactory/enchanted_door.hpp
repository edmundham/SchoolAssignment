//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_ENCHANTED_DOOR_HPP
#define ABSTRACTFACTORY_ENCHANTED_DOOR_HPP


#include "door.hpp"

class enchanted_door : public door {
public:
    enchanted_door() = default;
    enchanted_door(room& room1, room& room2);

    void print() override;
};


#endif //ABSTRACTFACTORY_ENCHANTED_DOOR_HPP
