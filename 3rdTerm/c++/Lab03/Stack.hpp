#ifndef LAB03_STACK_HPP
#define LAB03_STACK_HPP

#include <string>

static const int STACK_MAX = 10;

/**
 * Stack class
 */
class Stack {

public:
    /**
     * Constructor with 0 argument
     */
    Stack();
    /**
     * pushes new value to the top of the stack
     * @param newValue
     * @return true if successful, false otherwise
     */
    bool push(int newValue);
    /**
     * pops the top element of the stack
     */
    void pop();
    /**
     * returns the top element of the stack
     * @return the top element
     */
    int topElement() const;
    /**
     * checks if the stack is empty
     * @return true if empty, false otherwise
     */
    bool isEmpty() const;
    /**
     * checks if the stack is full
     * @return true if full, false otherwise
     */
    bool isFull() const;
    /**
     * returns formatted string of the elements of the stack
     * @return formatted string of the stack
     */
    std::string printStacks() const;

private:
    /**
     * stacks where elements are stored
     */
    int array[STACK_MAX];
    /**
     * index
     */
    int top;
};

#endif
