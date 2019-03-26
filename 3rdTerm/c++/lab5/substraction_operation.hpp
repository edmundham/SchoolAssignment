//
// Created by Sunguk Ham on 2018-10-18.
//

#ifndef LAB5_SUBSTRACTION_OPERATION_HPP
#define LAB5_SUBSTRACTION_OPERATION_HPP


#include "abstract_operation.hpp"

class substraction_operation : public abstract_operation {

public:
    static const char SUBSTRACTION_CODE = '-';

    substraction_operation() : abstract_operation(SUBSTRACTION_CODE) {}
    virtual ~substraction_operation() {}

    int perform(int first, int second) override {
        return first - second;
    }

};


#endif //LAB5_SUBSTRACTION_OPERATION_HPP
