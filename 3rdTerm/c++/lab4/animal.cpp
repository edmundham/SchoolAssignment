//
// Created by Sunguk Ham on 2018-10-11.
//

#include <iostream>
#include "animal.hpp"

long animal::classCounter = 0;

/**
 * animal default constructor
 */
animal::animal() {
    uuid = classCounter++;
    age = 0;
    alive = true;
    xCoord = 0.0;
    yCoord = 0.0;
    cout << "animal default constructor is being called" << endl;
}

/**
 * animal constructor with parameters
 * @param age
 * @param xCoord location
 * @param yCoord location
 */
animal::animal(int age, double xCoord, double yCoord) {
    uuid = classCounter++;
    animal::age = age;
    alive = true;
    animal::xCoord = xCoord;
    animal::yCoord = yCoord;
    cout << "animal parameter constructor is being called" << endl;
}

/**
 * animal copy constructor
 * @param obj
 */
animal::animal(const animal& obj) {
    uuid = obj.uuid;
    age = obj.age;
    alive = obj.alive;
    xCoord = obj.xCoord;
    yCoord = obj.yCoord;
    heightCoord = obj.heightCoord;
    cout << "animal copy constructor is being called" << endl;
}

/**
 * destructor
 */
animal::~animal() = default;

/**
 * animal moves and can climb mountains
 * @param xCoord
 * @param yCoord
 */
void animal::move(double xCoord, double yCoord) {
    animal::xCoord = xCoord;
    animal::yCoord = yCoord;
    cout << "moved to: " << animal:: xCoord << ", " << animal::yCoord << ", " << animal::heightCoord << endl;
}

/**
 * animal sleeps
 */
void animal::sleep() {
    std::cout << "Animal sleeping" << std::endl;
}

/**
 * animal eats
 */
void animal::eat() {
    std::cout << "Animal eating" << std::endl;
}

/**
 * helper function for insertion operator
 * @param os
 * @return
 */
ostream & animal::output(ostream &os) const {
    os << "Animal #" << animal::uuid << endl;
    os << "Age: " << animal::age << endl;
    os << "Alive: " << animal::alive << endl;
    os << "Location: " << animal:: xCoord << ", " << animal::yCoord << ", " << animal::heightCoord << endl;
    return os;
}

/**
 * insertion operator
 * @param os
 * @param animal1
 * @return
 */
ostream &operator<<(ostream &os, const animal &animal1) {
    return animal1.output(os);
}

long animal::getUuid() const {
    return uuid;
}
void animal::setUuid(long uuid) {
    animal::uuid = uuid;
}
int animal::getAge() const {
    return age;
}
void animal::setAge(int age) {
    animal::age = age;
}
bool animal::isAlive() const {
    return alive;
}
void animal::setAlive(bool alive) {
    animal::alive = alive;
}
double animal::getXCoord() const {
    return xCoord;
}
void animal::setXCoord(double xCoord) {
    animal::xCoord = xCoord;
}
double animal::getYCoord() const {
    return yCoord;
}
void animal::setYCoord(double yCoord) {
    animal::yCoord = yCoord;
}
double animal::getHeightCoord() const {
    return heightCoord;
}
void animal::setHeightCoord(double heightCoord) {
    animal::heightCoord = heightCoord;
}
