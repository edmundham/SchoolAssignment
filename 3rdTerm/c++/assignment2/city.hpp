//
// Created by Sunguk Ham on 2018-11-13.
//

#ifndef ASSIGNMENT2_CITY_HPP
#define ASSIGNMENT2_CITY_HPP

#include <string>

using namespace std;

class city {

public:
    /**
     * Constructors
     */
    city();
    city(int id, string name, int x, int y);

    /**
     * calcuates distance between the city instance and parameter city
     * @param city1 city that is being compared with
     * @return distance
     */
    double calculate_distance(city& city1);

    /**
     * overload operators
     */
    bool operator < (const city& m) const;
    bool operator == (const city& m) const;

    /**
     * getters and setters
     */
    void setId(int id);
    int getId();
    void setName(string name);
    string getName();
    void setX(int x);
    int getX();
    void setY(int y);
    int getY();

private:
    string name;
    int x;
    int y;
    int id;

};


#endif //ASSIGNMENT2_CITY_HPP
