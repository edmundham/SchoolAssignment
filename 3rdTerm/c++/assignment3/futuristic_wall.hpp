//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_FUTURISTIC_WALL_HPP
#define ABSTRACTFACTORY_FUTURISTIC_WALL_HPP


#include "wall.hpp"

class futuristic_wall : public wall {
public:
    futuristic_wall() = default;
    futuristic_wall(string& direction);
};


#endif //ABSTRACTFACTORY_FUTURISTIC_WALL_HPP
