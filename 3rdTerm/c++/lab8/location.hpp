//
// Created by Sunguk Ham on 2018-11-15.
//

#ifndef LAB8_LOCATION_HPP
#define LAB8_LOCATION_HPP

#include <string>

using namespace std;

class location {

public:
    /**
     * constructors
     */
    location();
    location(string name);

    /**
     * getters and setters
     */
    string get_name();
    void set_name(string name);

private:
    string name;

};


#endif //LAB8_LOCATION_HPP
