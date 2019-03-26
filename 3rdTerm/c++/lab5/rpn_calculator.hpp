//
// Created by Sunguk Ham on 2018-10-18.
//

#ifndef LAB5_RPN_CALCULATOR_HPP
#define LAB5_RPN_CALCULATOR_HPP

#include <iostream>
#include <stack>
#include "addition_operation.hpp"
#include "substraction_operation.hpp"
#include "multiplication_operation.hpp"
#include "division_operation.hpp"

class rpn_calculator {

public:
    int process_formula(std::string param);

private:
    int result;
    std::stack<int> rpn_stack;

    operation* operation_type(char operation_number);
    void perform(operation* operation1);
};


#endif //LAB5_RPN_CALCULATOR_HPP
