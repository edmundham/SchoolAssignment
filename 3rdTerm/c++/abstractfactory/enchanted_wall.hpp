//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_ENCHANTED_WALL_HPP
#define ABSTRACTFACTORY_ENCHANTED_WALL_HPP

#include <iostream>

using namespace std;

#include "wall.hpp"

class enchanted_wall : public wall {
public:
    enchanted_wall() = default;
    enchanted_wall(string& direction);
    void print() override;
};


#endif //ABSTRACTFACTORY_ENCHANTED_WALL_HPP
