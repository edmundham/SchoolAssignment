//
// Created by Sunguk Ham on 2018-10-03.
//

#ifndef ASSIGNMENT1_MATRIX_HPP
#define ASSIGNMENT1_MATRIX_HPP

#include <vector>
#include <ostream>

using namespace std;

class matrix {
public:
    /**
     * Constructors and a destructor
     */
    matrix();
    ~matrix();
    matrix(int size);
    matrix(int row, int col);
    matrix(double* array, int arraySize);
    matrix(const matrix& obj);

    /**
     * Operator overloading
     */
    friend void swap(matrix& first, matrix& second);
    friend ostream& operator<<(ostream& os, const matrix& matrix1);
    friend bool operator==(const matrix& lhs, const matrix& rhs);
    friend bool operator!=(const matrix& lhs, const matrix& rhs);
    matrix& operator++();
    matrix& operator--();
    matrix operator++(int);
    matrix operator--(int);
    matrix& operator=(matrix rhs);
    matrix& operator+=(const matrix& rhs);
    friend matrix operator+(matrix lhs, const matrix& rhs);
    matrix& operator-=(const matrix& rhs);
    friend matrix operator-(matrix lhs, const matrix& rhs);
    friend matrix operator*(matrix lhs, const matrix& rhs);
    friend matrix operator*(double lhs, matrix& rhs);
    matrix& operator*=(const matrix& rhs);

    /**
     * member functions of matrix
     */
    void set_value(int row, int col, double value);
    double get_value(int row, int col);
    void clear();
    matrix getImportance();
    void getProbability();
    void divideElementsBySum();

    /**
     * Getters and setters
     */
    void setVec(vector<double> vec);
    vector<double> getVec();
    void setNumOfRows(int numOfRows);
    int getNumOfRows();
    void setNumOfCols(int numOfCols);
    int getNumOfCols();
    void setSize1D(int size1D);
    int getSize1D();


private:
    vector<double> vec;
    int numOfRows;
    int numOfCols;
    int size1D;

};


#endif //ASSIGNMENT1_MATRIX_HPP
