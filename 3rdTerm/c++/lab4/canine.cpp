//
// Created by Sunguk Ham on 2018-10-11.
//

#include <iostream>
#include "canine.hpp"

/**
 * Canine default constructor calls super
 */
canine::canine() : animal() {
    cout << "Canine default constructor is being called" << endl;
}

/**
 * Canine constructor with parameters calls super
 * @param age
 * @param xCoord location
 * @param yCoord location
 */
canine::canine(int age, double xCoord, double yCoord) : animal(age, xCoord, yCoord) {
    cout << "Canine parameter constructor is being called" << endl;
}

/**
 * Canine copy constructor
 * @param obj Canine object
 */
canine::canine(const canine &obj) : animal(obj) {
    cout << "Canine copy constructor is being called" << endl;
}

/**
 * destructor
 */
canine::~canine() = default;

/**
 * moves canine object
 * @param xCoord location
 * @param yCoord location
 */
void canine::move(double xCoord, double yCoord) {
    animal::move(xCoord, yCoord);
}

/**
 * canine object sleeps
 */
void canine::sleep() {
    cout << "canine sleeping" << endl;
}

/**
 * canine object eats
 */
void canine::eat() {
    cout << "canine eating" << endl;
}

/**
 * canine object hunts
 */
void canine::hunt() {
    cout << "Canine hunting" << endl;
};

/**
 * helper function for insertion operator
 * @param os
 * @return
 */
ostream &canine::output(ostream &os) const {
    os << "Canine #" << animal::getUuid() << endl;
    os << "Age: " << animal::getAge() << endl;
    os << "Alive: " << animal::isAlive() << endl;
    os << "Location: " << animal::getXCoord() << ", " << animal::getYCoord() << ", " << animal::getHeightCoord() << endl;
    return os;
}

/**
 * insertion operator
 * @param os
 * @param canine1 object
 * @return
 */
ostream &operator<<(ostream &os, const canine &canine1) {
    return canine1.output(os);
}
