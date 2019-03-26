#include <iostream>
#include "gcd.hpp"

using namespace std;

int main() {
    int firstNumber;
    int secondNumber;

    cout << "Enter the first number: ";
    cin >> firstNumber;
    cout << endl;

    cout << "Enter the second number:" ;
    cin >> secondNumber;
    cout << endl;

    try {
        int gcdNumber = gcd(firstNumber, secondNumber);
        cout << gcdNumber << endl;
    } catch (const char* msg) {
        cerr << msg << endl;
        return 1;
    }

    return 0;
}

int gcd(const int firstNumber, const int secondNumber) {
    int remainder;

    if (firstNumber <= 0 || secondNumber <= 0) {
        throw "received negative value";
    }

    if (firstNumber < secondNumber) {
        return gcd(secondNumber, firstNumber);
    }

    remainder = firstNumber % secondNumber;
    if (remainder == 0) {
        return secondNumber;
    } else {
        return gcd(secondNumber, remainder);
    }
}
