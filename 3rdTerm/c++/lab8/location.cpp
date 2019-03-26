//
// Created by Sunguk Ham on 2018-11-15.
//

#include "location.hpp"

/**
 * default constructor
 */
location::location() {

}

/**
 * constructor with name
 * @param name
 */
location::location(string name) {
    location::name = name;
}

void location::set_name(string name) {
    location::name = name;
}

string location::get_name() {
    return location::name;
}

