//
// Created by Sunguk Ham on 2018-10-11.
//

#ifndef LAB4_CANINE_HPP
#define LAB4_CANINE_HPP

#include "animal.hpp"

class canine : public animal {

public:
    /**
     * canine default constructor
     */
    canine();
    /**
     * canine constructor with parameters
     * @param age
     * @param xCoord
     * @param yCoord
     */
    canine(int age, double xCoord, double yCoord);
    /**
     * canine copy constructor
     * @param obj
     */
    canine(const canine& obj);
    /**
     * destructor
     */
    ~canine() override;
    /**
     * move its location
     * @param xCoord location
     * @param yCoord location
     */
    void move(double xCoord, double yCoord) override;
    /**
     * canine sleeping
     */
    void sleep() override;
    /**
     * canine eating
     */
    void eat() override;
    /**
     * canine hunting
     */
    void hunt();
    /**
     * helper function for insertion operator
     * @param os
     * @return
     */
    ostream & output(ostream& os) const override;
    /**
     * insertion operator
     * @param os
     * @param canine1
     * @return
     */
    friend ostream& operator<<(ostream& os, const canine& canine1);
};
#endif //LAB4_CANINE_HPP
