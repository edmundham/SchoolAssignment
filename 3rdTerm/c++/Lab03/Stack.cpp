#include "Stack.hpp"
#include <iostream>

using namespace std;

/**
 * Construct Stack object with top -1 index
 */
Stack::Stack() {
    top = -1;
}

/**
 * push new value on top of the stack
 * @param newValue
 * @return false if stack is full. Otherwise true
 */
bool Stack::push(int newValue) {
    if (top == STACK_MAX - 1) {
        return false;
    }
    top++;
    array[top] = newValue;
    return true;
}

/**
 * pop the top element. Throws an exception if stack is empty.
 */
void Stack::pop() {
    if (top == -1) {
        throw string("Nothing to pop, Stack is empty");
    }
    top--;
}

/**
 * gets top element. Throws an exception if stack is empty.
 * @return top element
 */
int Stack::topElement() const {
    if (top == -1) {
        throw string("Stack is empty, there is no top element");
    }
    return array[top];
}

/**
 * check if stack is empty.
 * @return true if empty
 */
bool Stack::isEmpty() const {
    return top == -1;
}

/**
 * check if stack is full.
 * @return true if full
 */
bool Stack::isFull() const {
    return top == STACK_MAX - 1;
}

/**
 * print stacks in format. Throws an exception if stack is empty.
 * @return
 */
string Stack::printStacks() const {
    if (top == -1) {
        throw string("Stack is empty, cannot print anything");
    }
    string returnString;
    for (int i = 0; i <= top; i++) {
        returnString += to_string(array[i]) + " ";
    }
    cout << returnString << endl;
    return returnString;
}
