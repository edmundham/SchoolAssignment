//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_ENCHANTED_ROOM_HPP
#define ABSTRACTFACTORY_ENCHANTED_ROOM_HPP


#include "room.hpp"

class enchanted_room : public room {
public:
    enchanted_room() = default;
    enchanted_room(wall& south, wall& north, wall& west, wall& east);
    void print() override;
};


#endif //ABSTRACTFACTORY_ENCHANTED_ROOM_HPP
