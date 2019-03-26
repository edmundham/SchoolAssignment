//
// Created by Sunguk Ham on 2018-11-13.
//

#include "city.hpp"
#include <cmath>

/**
 * default constructor
 */
city::city() {

}

/**
 * constructor with city
 * @param id id of city
 * @param name name of city
 * @param x latitude of the city
 * @param y longitude of the city
 */
city::city(int id, string name, int x, int y) {
    city::id = id;
    city::name = name;
    city::x = x;
    city::y = y;
}

/**
 * calculate distance
 * @param city1 city to be compared with
 * @return distance between cities
 */
double city::calculate_distance(city &city1) {
    return sqrt(pow((city::x - city1.getX()), 2) + pow((city::y - city1.getY()), 2));
}

/**
 * operator overload
 * @param m tour
 * @return true if same, false otherwise
 */
bool city::operator==(const city& m) const {
    return this->id == m.id;
}

/**
 * operator overload
 * @param m tour
 * @return true if small, false otherwise
 */
bool city::operator<(const city& m) const {
    return this->id < m.id;
}

/**
 * get id
 * @return id
 */
int city::getId() {
    return id;
}

/**
 * set id
 * @param id
 */
void city::setId(int id) {
    city::id = id;
}

/**
 * get name
 * @return name
 */
string city::getName() {
    return name;
}

/**
 * set name
 * @param name
 */
void city::setName(string name) {
    city::name = name;
}

/**
 * get x
 * @return x
 */
int city::getX() {
    return x;
}

/**
 * set x
 * @param x
 */
void city::setX(int x) {
    city::x = x;
}

/**
 * get y
 * @return y
 */
int city::getY() {
    return y;
}

/**
 * set y
 * @param y
 */
void city::setY(int y) {
    city::y = y;
}