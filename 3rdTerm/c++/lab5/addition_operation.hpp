//
// Created by Sunguk Ham on 2018-10-18.
//

#ifndef LAB5_ADDITION_OPERATION_HPP
#define LAB5_ADDITION_OPERATION_HPP

#include "abstract_operation.hpp"

class addition_operation : public abstract_operation {

public:
    static const char ADDITION_CODE = '+';

    addition_operation() : abstract_operation(ADDITION_CODE) {}
    virtual ~addition_operation() {}

    int perform(int first, int second) override {
        return first + second;
    }
};


#endif //LAB5_ADDITION_OPERATION_HPP
