//
// Created by Sunguk Ham on 2018-09-20.
//

#ifndef LAB02_UTILS_HPP
#define LAB02_UTILS_HPP

#include <random>

using namespace std;

static const int INT_MAX = 1024;
static const int INT_MIN = 512;
static const int DOUBLE_MAX = 90;
static const int DOUBLE_MIN = 50;

/**
 * Generates random double value
 * @return random double
 */
static const double randDouble() {
    random_device rd;
    default_random_engine generator(rd());
    uniform_real_distribution<double> distribution(DOUBLE_MIN, DOUBLE_MAX);
    return distribution(generator);
}

/**
 * Generates random integer value
 * @return random integer
 */
static const int randInt() {
    random_device rd;
    mt19937 generator(rd());
    uniform_int_distribution<> distribution(INT_MIN, INT_MAX);
    return distribution(generator);
}

#endif //LAB02_UTILS_HPP
