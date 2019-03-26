//
// Created by Sunguk Ham on 2018-11-13.
//

#include "tour.hpp"
#include <chrono>

using namespace std;
using namespace std::chrono;

/**
 * default constructor
 */
tour::tour() = default;

/**
 * constructors with tour parameters
 * @param cities of the tour
 */
tour::tour(vector<city> cities) {
    tour::cities = cities;
    tour::total_distance = calculate_total_distance();
    tour::fitness_rating = calculate_fitness_rating();
}

/**
 * shuffle cities
 */
void tour::shuffle_cities() {
    long seed = system_clock::now().time_since_epoch().count();
    std::shuffle(std::begin(cities), std::end(cities), default_random_engine(seed));
}

/**
 * get total distance
 * @return total distance
 */
double tour::get_total_distance() {
    return total_distance;
}

/**
 * operator overload
 * @param m tour
 * @return true if same, false otherwise
 */
bool tour::operator==(const tour& m) const {
    return -0.000001 < this->total_distance - m.total_distance < 0.000001;
}

/**
 * operator overload
 * @param m tour
 * @return true if smaller, flase otherwise
 */
bool tour::operator<(const tour& m) const {
    return this->total_distance < m.total_distance;
}

/**
 * get fitness rating
 * @return
 */
long double tour::get_fitness_rating() {
    return fitness_rating;
}

/**
 * get cities
 * @return
 */
vector<city> tour::get_cities() {
    return cities;
}

/**
 * calculate fitness rating
 * @return fitness rating
 */
long double tour::calculate_fitness_rating() {
    tour:: total_distance = tour::get_total_distance();
    tour::fitness_rating = 1.0 / tour::total_distance;
    tour::fitness_rating *= 1000000.0;
    return tour::fitness_rating;
}

/**
 * calculate total distance
 * @return total distance
 */
double tour::calculate_total_distance() {
    tour::total_distance= 0;
    for (int i = 0; i < tour::cities.size() - 1; i++) {
        tour::total_distance += tour::cities.at(i).calculate_distance(tour::cities.at(i+1));
    }
    tour::total_distance += tour::cities.at(0).calculate_distance(tour::cities.at(cities.size() - 1));
    return tour::total_distance;
}
