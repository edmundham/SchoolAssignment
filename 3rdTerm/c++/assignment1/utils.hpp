//
// Created by Sunguk Ham on 2018-10-04.
//

#ifndef ASSIGNMENT1_UTILS_HPP
#define ASSIGNMENT1_UTILS_HPP

#include <bits/stdc++.h>
using namespace std;

/**
 * check if a parameter is divisible by square root
 * @param x number
 * @return true if square root
 */
static const bool isSqrt(const long double x) {
    long double sr = sqrt(x);
    return ((sr - floor(sr)) == 0);
}

/**
 * returns square root of the parameter
 * @param x number
 * @return square root of the parameter
 */
static const int floorSqrt(int x) {
    if (x == 0 || x == 1) {
        return x;
    }
    int i = 1;
    int result = 1;
    while (result <= x) {
        i++;
        result = i * i;
    }
    return i - 1;
}


#endif //ASSIGNMENT1_UTILS_HPP
