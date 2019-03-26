//
// Created by Sunguk Ham on 2018-10-18.
//

#ifndef LAB5_DIVISION_OPERATION_HPP
#define LAB5_DIVISION_OPERATION_HPP


#include "abstract_operation.hpp"

class division_operation : public abstract_operation {

public:
    static const char DIVISION_CODE = '/';

    division_operation() : abstract_operation(DIVISION_CODE) {}
    virtual ~division_operation() {}

    int perform(int first, int second) override {
        return first / second;
    }

};


#endif //LAB5_DIVISION_OPERATION_HPP
