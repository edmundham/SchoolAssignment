//
// Created by Sunguk Ham on 2018-10-11.
//

#ifndef LAB4_BIRD_HPP
#define LAB4_BIRD_HPP

#include "animal.hpp"

class bird : public animal {

public:
    /**
     * bird default constructor
     */
    bird();
    /**
     * bird constructor with parameters
     * @param age
     * @param xCoord location
     * @param yCoord location
     * @param heightCoord altitude
     */
    bird(int age, double xCoord, double yCoord, double heightCoord);
    /**
     * bird copy constructor
     */
    bird(const bird& obj);
    /**
     * desctructor
     */
    ~bird() override;
    /**
     * move its location
     * @param xCoord location
     * @param yCoord location
     * @param heightCoord altitude
     */
    void move(double xCoord, double yCoord, double heightCoord);
    /**
     * bird sleeping
     */
    void sleep() override;
    /**
     * bird eating
     */
    void eat() override;
    /**
     * helper function for insertion operator
     * @param os
     * @return
     */
    ostream & output(ostream& os) const override;
    /**
     * insertion operator
     * @param os
     * @param bird1
     * @return
     */
    friend ostream& operator<<(ostream& os, const bird& bird1);
};
#endif //LAB4_BIRD_HPP
