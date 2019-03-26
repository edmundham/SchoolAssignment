#define CATCH_CONFIG_MAIN

#include <sys/param.h>
#include "catch.hpp"
#include "Stack.hpp"

constexpr int testStackLength = 6;
constexpr int testStackElement[testStackLength] = {5132, 142, 43, 423, 562, 1423};

TEST_CASE("A new Stack should be empty when initialized", "Stack.Stack") {
    Stack tester;
    REQUIRE(tester.isEmpty());
    REQUIRE(!tester.isFull());
}

TEST_CASE("A new Stack should be able to have multiple elements", "Stack.Stack") {
    Stack tester;
    for (int i = 0; i < testStackLength; i++) {
        tester.push(testStackElement[i]);
    }
    REQUIRE(!tester.isEmpty());
    REQUIRE(!tester.isFull());
    REQUIRE(tester.topElement() == testStackElement[5]);
}

TEST_CASE("A new Stack should be able to have maximum capacity of 10", "Stack.Stack") {
    Stack tester;
    for (int i = 0; i < STACK_MAX; i++) {
        tester.push(i);
    }
    REQUIRE(!tester.isEmpty());
    REQUIRE(tester.isFull());
    REQUIRE(!tester.push(200));
    REQUIRE(tester.topElement() == STACK_MAX - 1);
}

TEST_CASE("push function should be able to push integers to Stacks", "Stack.push") {
    Stack tester;
    REQUIRE(tester.push(50));
    REQUIRE(tester.push(100));
}

TEST_CASE("A new Stack should be able to pop it's element", "Stack.pop") {
    Stack tester;
    for (int i = 0; i < testStackLength; i++) {
        tester.push(testStackElement[i]);
    }
    REQUIRE(!tester.isEmpty());
    REQUIRE(!tester.isFull());
    for (int i = 0; i < testStackLength; i++) {
        tester.pop();
    }
    REQUIRE(tester.isEmpty());
    REQUIRE(!tester.isFull());
}

TEST_CASE("A new Stack should not be able to pop it's element if it is empty", "Stack.pop") {
    Stack tester;
    REQUIRE_THROWS(tester.pop());
}

TEST_CASE("A new Stack should be able to return correct top element", "Stack.topElement") {
    Stack tester;
    for (int i = 0; i < testStackLength; i++) {
        tester.push(testStackElement[i]);
    }
    REQUIRE(tester.topElement() == testStackElement[5]);
}

TEST_CASE("A new Stack should be able to throw an exception in topElement if it is empty", "Stack.topElement") {
    Stack tester;
    REQUIRE_THROWS(tester.topElement());
}

TEST_CASE("A new Stack should be able to determine it is full or not", "Stack.isFull") {
    Stack tester;
    for (int i = 0; i < STACK_MAX; i++) {
        tester.push(i);
    }
    REQUIRE(tester.isFull());
}

TEST_CASE("A new Stack should be able to determine it is empty or not", "Stack.isEmpty") {
    Stack tester;
    for (int i = 0; i < STACK_MAX; i++) {
        tester.push(i);
    }
    REQUIRE(!tester.isEmpty());
}

TEST_CASE("A new Stack printing should throw exception if the Stack is empty", "Stack.printStacks") {
    Stack tester;
    REQUIRE_THROWS(tester.printStacks());
}

TEST_CASE("A new Stack should return string in the correct format", "Stack.printStacks") {
    Stack tester;
    tester.push(1);
    tester.push(2);
    tester.push(3);
    REQUIRE(tester.printStacks() == "1 2 3 ");
}
