//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_FUTURISTIC_ROOM_HPP
#define ABSTRACTFACTORY_FUTURISTIC_ROOM_HPP


#include "room.hpp"

class futuristic_room : public room {
public:
    futuristic_room() = default;
    futuristic_room(wall& south, wall& north, wall& west, wall& east);
    void print() override;
};


#endif //ABSTRACTFACTORY_FUTURISTIC_ROOM_HPP
