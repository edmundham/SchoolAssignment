//
// Created by Sunguk Ham on 2018-10-11.
//

#ifndef LAB4_ANIMAL_HPP
#define LAB4_ANIMAL_HPP

#include <ostream>

using namespace std;

class animal {

public:
    /**
     * animal default constructor
     */
    animal();
    /**
     * animal constructor with parameters
     * @param age
     * @param xCoord location
     * @param yCoord location
     */
    animal(int age, double xCoord, double yCoord);
    /**
     * animal copy constructor
     * @param obj animal object
     */
    animal(const animal& obj);
    /**
     * destructor
     */
    virtual ~animal();
    /**
     * move its location
     * @param xCoord location
     * @param yCoord location
     */
    virtual void move(double xCoord, double yCoord);
    /**
     * animal sleeping
     */
    virtual void sleep();
    /**
     * animal eating
     */
    virtual void eat();
    /**
     * helper function for insertion operator
     * @param os
     * @return
     */
    virtual ostream & output(ostream& os) const;
    /**
     * insertion operator
     * @param os
     * @param animal1
     * @return
     */
    friend ostream& operator<<(ostream& os, const animal& animal1);

    long getUuid() const;
    void setUuid(long uuid);
    int getAge() const;
    void setAge(int age);
    bool isAlive() const;
    void setAlive(bool alive);
    double getXCoord() const;
    void setXCoord(double xCoord);
    double getYCoord() const;
    void setYCoord(double yCoord);
    double getHeightCoord() const;
    void setHeightCoord(double heightCoord);

private:
    static long classCounter;
    long uuid;
    int age;
    bool alive;
    double xCoord;
    double yCoord;
    double heightCoord = 0;
};
#endif //LAB4_ANIMAL_HPP
