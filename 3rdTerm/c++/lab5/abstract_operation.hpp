//
// Created by Sunguk Ham on 2018-10-18.
//

#ifndef LAB5_ABSTRACT_OPERATION_HPP
#define LAB5_ABSTRACT_OPERATION_HPP


#include "operation.hpp"

class abstract_operation : public operation {

public:
    abstract_operation(char character) {
        operation_type = character;
    }

    char get_code() override {
        return operation_type;
    }

    virtual ~abstract_operation() {}

private:
    char operation_type;
};


#endif //LAB5_ABSTRACT_OPERATION_HPP
