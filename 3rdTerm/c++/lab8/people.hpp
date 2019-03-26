//
// Created by Sunguk Ham on 2018-11-15.
//

#ifndef LAB8_PEOPLE_HPP
#define LAB8_PEOPLE_HPP

#include <string>
#include <vector>
#include "location.hpp"

using namespace std;

class people {

public:
    /**
     * Constructors
     */
    people();
    people(string name, vector<location> locations);

    /**
     * checks if person visited location specified by parameter
     * @param location_name name of the location
     * @return true if visited
     */
    bool is_visited(string location_name);

    /**
     * operator overloading
     */
    bool operator < (const people& m) const;
    bool operator == (const people& m) const;
    friend ostream& operator<<(ostream& os, const people& matrix1);

    /**
     * getters and setters
     */
    string get_name();
    void set_name(string name);
    vector<location> get_locations();
    void set_location(vector<location> locations);

private:
    /**
     * name of the person
     */
    string name;
    /**
     * list of locations
     */
    vector<location> locations;

};


#endif //LAB8_PEOPLE_HPP
