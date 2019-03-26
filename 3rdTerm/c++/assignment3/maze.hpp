//
// Created by Sunguk Ham on 2018-11-29.
//

#ifndef ABSTRACTFACTORY_MAZE_HPP
#define ABSTRACTFACTORY_MAZE_HPP

#include <iostream>
#include "door.hpp"
#include "wall.hpp"
#include <random>

using namespace std;

class maze {

public:
    maze() = default;

    maze(room& room1, room& room2, door& door1) {
        this->room1 = &room1;
        this->room2 = &room2;
        this->door1 = &door1;
        mt19937 generator(rd());
        uniform_int_distribution<int> age_generator(1, 100);
        this->age = age_generator(generator);
    }

    maze(const maze& maze1) {
        this->room1 = maze1.room1;
        this->room2 = maze1.room2;
        this->door1 = maze1.door1;
        this->age = maze1.age;
        this->maze_name = maze1.maze_name;
    }

    friend ostream& operator<<(ostream& os, const maze &maze1) {
        return os << maze1.maze_name << " is " << maze1.age << " year old";
    }
    friend void swap(maze& first, maze& second) {
        using std::swap;
        swap(first.room1, second.room1);
        swap(first.room2, second.room2);
        swap(first.door1, second.door1);
        swap(first.age, second.age);
        swap(first.maze_name, second.maze_name);
    }
    bool operator < (const maze& m) {
        return this->age < m.age;
    }
    bool operator > (const maze& m) {
        return this->age > m.age;
    }
    bool operator == (const maze& m) {
        return this->age == m.age;
    }
    maze& operator=(maze rhs) {
        swap(*this, rhs);
        return *this;
    }

    virtual void print() {
        cout << maze_name << " Maze have two rooms and one door." << endl;
    }

protected:
    room* room1;
    room* room2;
    door* door1;
    string maze_name = "";
    int age;
    random_device rd;
};


#endif //ABSTRACTFACTORY_MAZE_HPP
