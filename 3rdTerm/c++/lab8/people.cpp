//
// Created by Sunguk Ham on 2018-11-15.
//

#include <iostream>
#include "people.hpp"

using namespace std;

/**
 * default constructor
 */
people::people() {

}

/**
 * constructor with name and locations
 * @param name
 * @param locations
 */
people::people(string name, vector<location> locations) {
    people::name = name;
    people::locations = locations;
}

/**
 * checks if person visited location or not
 * @param location_name name of the location
 * @return true if visited, false otherwise
 */
bool people::is_visited(string location_name) {
    for (location location1 : people::locations) {
        if (location1.get_name() == location_name) {
            return true;
        }
    }
    return false;
}

bool people::operator==(const people &m) const {
    return this->name == m.name;
}

bool people::operator<(const people &m) const {
    return this->name < m.name;
}

ostream& operator<<(ostream& os, const people& m) {
    os << m.name << " visited: ";
    for (location location1 : m.locations) {
        os << location1.get_name() << " ";
    }
    os << endl;
    return os;
}

void people::set_name(string name) {
    people::name = name;
}

string people::get_name() {
    return people::name;
}

void people::set_location(vector<location> locations) {
    people::locations = locations;
}

vector<location> people::get_locations() {
    return people::locations;
}
