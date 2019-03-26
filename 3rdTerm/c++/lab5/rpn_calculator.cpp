//
// Created by Sunguk Ham on 2018-10-18.
//

#include <stdexcept>
#include <sstream>
#include <ctype.h>
#include <iostream>
#include <stdlib.h>
#include "rpn_calculator.hpp"

operation* rpn_calculator::operation_type(char operation_number) {
    operation* op;
    switch(operation_number) {
        case addition_operation::ADDITION_CODE :
            op = new addition_operation;
            break;
        case substraction_operation::SUBSTRACTION_CODE :
            op = new substraction_operation;
            break;
        case multiplication_operation::MULTIPLICATION_CODE :
            op = new multiplication_operation;
            break;
        case division_operation::DIVISION_CODE :
            op = new division_operation;
            break;
        default:
            throw std::invalid_argument("operation type does not match with any of operation types");
    }
    return op;
}

void rpn_calculator::perform(operation *operation1) {
    int second = rpn_stack.top();
    rpn_stack.pop();
    int first = rpn_stack.top();
    rpn_stack.pop();

    rpn_stack.push(operation1->perform(first, second));
    delete operation1;
}

int rpn_calculator::process_formula(std::string param) {
    std::istringstream iss(param);
    std::string number_value;

    while (iss >> number_value) {
        int number;
        std::istringstream iss2(number_value);
        iss2 >> number;
        if (!iss2.fail()) {
            rpn_stack.push(number);
        } else {
            perform(operation_type(number_value[0]));
        }
    }
    return rpn_stack.top();
}

