//
// Created by Sunguk Ham on 2018-11-13.
//

#ifndef ASSIGNMENT2_TOUR_HPP
#define ASSIGNMENT2_TOUR_HPP


#include "city.hpp"
#include <vector>
#include <algorithm>
#include <random>

using namespace std;

class tour {

public:
    /**
     * constructors
     */
    tour();
    tour(vector<city> cities);

    /**
     * shuffle cities
     */
    void shuffle_cities();

    /**
     * operator overloads
     */
    bool operator < (const tour& m) const;
    bool operator == (const tour& m) const;

    /**
     * getters
     * @return
     */
    long double get_fitness_rating();
    vector<city> get_cities();
    double get_total_distance();

private:
    vector<city> cities;
    long double fitness_rating;
    double total_distance;
    /**
     * calculate fitness rating
     * @return
     */
    long double calculate_fitness_rating();
    /**
     * calculate total distance
     * @return
     */
    double calculate_total_distance();
};


#endif //ASSIGNMENT2_TOUR_HPP
