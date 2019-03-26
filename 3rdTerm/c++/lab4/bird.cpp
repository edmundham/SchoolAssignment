//
// Created by Sunguk Ham on 2018-10-11.
//

#include <iostream>
#include "bird.hpp"

/**
 * Bird default constructor
 */
bird::bird() : animal() {
    cout << "bird default constructor is being called" << endl;
}

/**
 * Bird constructor with parameters
 * @param age
 * @param xCoord location
 * @param yCoord location
 * @param heightCoord altitude
 */
bird::bird(int age, double xCoord, double yCoord, double heightCoord) : animal(age, xCoord, yCoord) {
    animal::setHeightCoord(heightCoord);
    cout << "bird parameter constructor is being called" << endl;
}

/**
 * Bird copy constructor
 * @param obj
 */
bird::bird(const bird &obj) : animal(obj) {
    cout << "bird copy constructor is being called" << endl;
}

/**
 * destructor
 */
bird::~bird() = default;

/**
 * bird moves
 * @param xCoord location
 * @param yCoord location
 * @param heightCoord altitude
 */
void bird::move(double xCoord, double yCoord, double heightCoord) {
    animal::setHeightCoord(heightCoord);
    animal::move(xCoord, yCoord);
}

/**
 * bird sleeps
 */
void bird::sleep() {
    cout << "bird sleeping" << endl;
}

/**
 * bird eats
 */
void bird::eat() {
    cout << "bird eating" << endl;
}

/**
 * helper function for insertion operator
 * @param os
 * @return
 */
ostream &bird::output(ostream &os) const {
    os << "Bird #" << animal::getUuid() << endl;
    os << "Age: " << animal::getAge() << endl;
    os << "Alive: " << animal::isAlive() << endl;
    os << "Location: " << animal::getXCoord() << ", " << animal::getYCoord() << ", " << animal::getHeightCoord() << endl;
    return os;
}

/**
 * insertion operator
 * @param os
 * @param bird1
 * @return
 */
ostream &operator<<(ostream &os, const bird &bird1) {
    return bird1.output(os);
}
