//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_WALL_HPP
#define ABSTRACTFACTORY_WALL_HPP

#include <iostream>

using namespace std;

class wall {

public:
    explicit wall(string& direction) {
        this->direction = direction;
    }

    wall() = default;

    virtual void print() {
        cout << "Wall is facing: " << direction << endl;
    }

protected:
    string direction;
    string maze_name = "";

};


#endif //ABSTRACTFACTORY_WALL_HPP
