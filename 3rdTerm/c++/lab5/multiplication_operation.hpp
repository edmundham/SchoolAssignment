//
// Created by Sunguk Ham on 2018-10-18.
//

#ifndef LAB5_MULTIPLICATION_OPERATION_HPP
#define LAB5_MULTIPLICATION_OPERATION_HPP


#include "abstract_operation.hpp"

class multiplication_operation : public abstract_operation {

public:
    static const char MULTIPLICATION_CODE = '*';

    multiplication_operation() : abstract_operation(MULTIPLICATION_CODE) {}
    virtual ~multiplication_operation() {}

    int perform(int first, int second) override {
        return first * second;
    }

};


#endif //LAB5_MULTIPLICATION_OPERATION_HPP
