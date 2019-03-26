//
// Created by Sunguk Ham on 2018-10-03.
//

#include "matrix.hpp"
#include "utils.hpp"

using namespace std;

/**
 * construct default matrix object
 */
matrix::matrix() {
    vector<double> tempVec(0.0);
    vec = tempVec;
    numOfRows = 1;
    numOfCols = 1;
    size1D = numOfRows * numOfCols;
}

/**
 * destruct matrix object
 */
matrix::~matrix() {
    vec.clear();
    vec.shrink_to_fit();
}

/**
 * construct matrix object with size parameter
 * @param size of the matrix
 */
matrix::matrix(int size) {
    if (size <= 0) {
        throw invalid_argument("received negative value");
    }
    vector<double> tempVec(size * size, 0.0);
    vec = tempVec;
    numOfRows = size;
    numOfCols = size;
    size1D = size * size;
}

/**
 * construct matrix object with row and column parameter
 * @param row of the matrix
 * @param col of the matrix
 */
matrix::matrix(int row, int col) {
    if (row <= 0 || col <= 0) {
        throw invalid_argument("both column and numOfRows must be positive number");
    }
    vector<double> tempVec(row * col, 0.0);
    vec = tempVec;
    numOfRows = row;
    numOfCols = col;
    size1D = row * col;
}

/**
 * construct matrix object with double array and size of it
 * @param array double array
 * @param arraySize of the double array
 */
matrix::matrix(double* array, int arraySize) {
    if (isSqrt(arraySize)) {
        vector<double> tempVec(array, array + arraySize);
        vec = tempVec;
        numOfRows = floorSqrt(arraySize);
        numOfCols = floorSqrt(arraySize);
        size1D = arraySize;
    } else {
        throw invalid_argument("size1D of the array is not perfect square");
    }
}

/**
 * copy constructor
 * @param obj matrix object
 */
matrix::matrix(const matrix& obj) {
    vec = obj.vec;
    numOfCols = obj.numOfCols;
    numOfRows = obj.numOfRows;
    size1D = obj.size1D;
}

/**
 * swap two matrix object
 * @param first matrix object
 * @param second matrix object
 */
void swap(matrix& first, matrix& second) {
    using std::swap;
    swap(first.size1D, second.size1D);
    swap(first.vec, second.vec);
    swap(first.numOfCols, second.numOfCols);
    swap(first.numOfRows, second.numOfRows);
}

/**
 * displays matrix obejct formatted
 * @param os ostream
 * @param matrix1 matrix object
 * @return formatted matrix object
 */
ostream& operator<<(ostream& os, const matrix& matrix1) {
    for (int i = 0; i < matrix1.numOfRows; i++) {
        for (int j = 0; j < matrix1.numOfCols; j++) {
            os << matrix1.vec[(i) * matrix1.numOfCols + (j)] << " ";
        }
        os << endl;
    }
    return os;
}

/**
 * == operator
 * @param lhs left matrix object
 * @param rhs right matrix object
 * @return true if same
 */
bool operator==(const matrix& lhs, const matrix& rhs) {
    if (lhs.size1D != rhs.size1D) {
        return false;
    }
    for (int i = 0; i < lhs.size1D; i++) {
        if (fabs(lhs.vec[i] - rhs.vec[i]) > 0.0000001) {
            return false;
        }
    }
    return true;
}

/**
 * != operator
 * @param lhs left matrix object
 * @param rhs right matrix object
 * @return true if not same
 */
bool operator!=(const matrix& lhs, const matrix& rhs) {
    return !operator==(lhs, rhs);
}

/**
 * ++ operator prefix
 * @return incremented matrix object by 1
 */
matrix& matrix::operator++() {
    for (int i = 0; i < size1D; i++) {
        vec[i] += 1.0;
    }
    return *this;
}

/**
 * -- operator prefix
 * @return decremented matrix object by 1
 */
matrix& matrix::operator--() {
    for (int i = 0; i < size1D; i++) {
        vec[i] -= 1.0;
    }
    return *this;
}

/**
 * ++ operator postfix
 * @return incremented matrix object by 1
 */
matrix matrix::operator++(int) {
    matrix temp(*this);
    operator++();
    return temp;
}

/**
 * -- operator postfix
 * @return decremented matrix object by 1
 */
matrix matrix::operator--(int) {
    matrix temp(*this);
    operator--();
    return temp;
}

/**
 * = operator
 * @param rhs right matrix
 * @return swap the matrix object
 */
matrix& matrix::operator=(matrix rhs) {
    swap(*this, rhs);
    return *this;
}

/**
 * += operator
 * @param rhs right matrix object
 * @return matrix object
 */
matrix& matrix::operator+=(const matrix& rhs) {
    if (numOfCols != rhs.numOfCols || numOfRows != rhs.numOfRows) {
        throw invalid_argument("Matrices size1D does not match");
    }
    for (int i = 0; i < size1D; i++) {
        vec[i] += rhs.vec[i];
    }
    return *this;
}

/**
 * + operator
 * @param lhs left matrix object
 * @param rhs right matrix object
 * @return matrix object
 */
matrix operator+(matrix lhs, const matrix& rhs) {
    if (lhs.numOfCols != rhs.numOfCols || lhs.numOfRows != rhs.numOfRows) {
        throw invalid_argument("Matrices size1D does not match");
    }
    for (int i = 0; i < lhs.size1D; i++) {
        lhs.vec[i] += rhs.vec[i];
    }
    return lhs;
}

/**
 * -= operator
 * @param rhs right matrix object
 * @return matrix object
 */
matrix& matrix:: operator-=(const matrix& rhs) {
    if (numOfCols != rhs.numOfCols || numOfRows != rhs.numOfRows) {
        throw invalid_argument("Matrices size does not match");
    }
    for (int i = 0; i < size1D; i++) {
        vec[i] -= rhs.vec[i];
    }
    return *this;
}

/**
 * - operator
 * @param lhs left matrix object
 * @param rhs right matrix object
 * @return matrix object
 */
matrix operator-(matrix lhs, const matrix& rhs) {
    if (lhs.numOfCols != rhs.numOfCols || lhs.numOfRows != rhs.numOfRows) {
        throw invalid_argument("Matrices size does not match");
    }
    for (int i = 0; i < lhs.size1D; i++) {
        lhs.vec[i] -= rhs.vec[i];
    }
    return lhs;
}

/**
 * * operator
 * @param lhs left matrix object
 * @param rhs right matrix object
 * @return matrix object
 */
matrix operator*(matrix lhs, const matrix& rhs) {
    if (lhs.numOfCols != rhs.numOfRows) {
        throw invalid_argument("Column of the first matrix and row of the second matrix should be same");
    }
    vector<double> tempVec(lhs.numOfRows * rhs.numOfCols);

    for (int i = 0; i < lhs.numOfRows; i++) {
        for (int j = 0; j < rhs.numOfCols; j++) {
            double sum = 0.0;
            for (int k = 0; k < rhs.numOfRows; k++) {
                sum = sum + lhs.vec[i * lhs.numOfCols + k] * rhs.vec[k * rhs.numOfCols + j];
            }
            tempVec[i * rhs.numOfCols + j] = sum;
        }
    }
    lhs.vec = tempVec;
    lhs.numOfRows = lhs.numOfRows;
    lhs.numOfCols = rhs.numOfCols;
    lhs.size1D = lhs.numOfRows * rhs.numOfCols;
    return lhs;
}

/**
 * * operator with double value
 * @param lhs left double value
 * @param rhs right matrix object
 * @return matrix object
 */
matrix operator*(double lhs, matrix& rhs) {
    for (int i = 0; i < rhs.vec.size(); i++) {
        rhs.vec[i] *= lhs;
    }
    return rhs;
}

/**
 * *= operator
 * @param rhs right matrix object
 * @return matrix object
 */
matrix& matrix::operator*=(const matrix& rhs) {
    if (numOfCols != rhs.numOfRows) {
        throw invalid_argument("Row of the first matrix and column of the second matrix should be same");
    }
    vector<double> tempVec(numOfRows * rhs.numOfCols);

    for (int i = 0; i < numOfRows; i++) {
        for (int j = 0; j < rhs.numOfCols; j++) {
            double sum = 0.0;
            for (int k = 0; k < rhs.numOfRows; k++) {
                sum = sum + vec[i * numOfCols + k] * rhs.vec[k * rhs.numOfCols + j];
            }
            tempVec[i * rhs.numOfCols + j] = sum;
        }
    }
    vec = tempVec;
    numOfCols = rhs.numOfCols;
    size1D = numOfRows * rhs.numOfCols;
    return *this;
}

/**
 * set value of the matrix
 * @param row location
 * @param col location
 * @param value to set
 */
void matrix::set_value(int row, int col, double value) {
    if (row <= 0 || col <= 0 || numOfRows >= row || numOfCols >= col) {
        vec[(row-1) * numOfCols + (col-1)] = value;
    } else {
        throw invalid_argument("IndexOutOfBoundsException occurred");
    }
}

/**
 * get value of specific location
 * @param row location
 * @param col location
 * @return value of location
 */
double matrix::get_value(int row, int col) {
    if (row <= 0 || col <= 0 || numOfRows >= row || numOfCols >= col) {
        return vec[(row-1) * numOfCols + (col-1)];
    } else {
        throw invalid_argument("IndexOutOfBoundsException occurred");
    }
}

/**
 * clear the matrix to 0
 */
void matrix::clear() {
    vec.clear();
}

/**
 * get importance of the matrix. returns new matrix object
 * @return matrix object
 */
matrix matrix::getImportance() {
    vector<double> tempVector(vec);
    for (int i = 0; i < numOfRows; i++) {
        int sum = 0;
        for (int j = 0; j < numOfCols; j++) {
            sum += tempVector[j * numOfRows + i];
        }
        for (int j = 0; j < numOfCols; j++) {
            if (tempVector[j * numOfRows + i] != 0)
            tempVector[j * numOfRows + i] /= sum;
        }
    }

    double tempDoubleArray[tempVector.size()];
    copy(tempVector.begin(), tempVector.end(), tempDoubleArray);
    matrix tempMatrix(tempDoubleArray, tempVector.size());
    return tempMatrix;
}

/**
 * get probability of the matrix. change the current matrix object's instances
 */
void matrix::getProbability() {
    for (int i = 0; i < numOfRows; i++) {
        int nonZeroCols = 0;
        for (int j = 0; j < numOfCols; j++) {
            if (vec[j * numOfRows + i] == 0) {
                nonZeroCols++;
            }
        }
        if (nonZeroCols == numOfCols) {
            for (int j = 0; j < numOfCols; j++) {
                vec[j * numOfRows + i] = 1.0 / nonZeroCols;
            }
        }
    }
}

/**
 * divide elements of the matrix by the total sum of the matrix elements
 */
void matrix::divideElementsBySum() {
    double sum = 0;
    for (int i = 0; i < size1D; i++) {
        sum += vec[i];
    }

    for (int i = 0; i < size1D; i++) {
        vec[i] = vec[i] / sum;
    }
}

/**
 * sets vec
 * @param vec
 */
void matrix::setVec(vector<double> vec) {
    matrix::vec = vec;
}

/**
 * gets vec
 * @return vec
 */
vector<double> matrix::getVec() {
    return vec;
}

/**
 * sets numOfRows
 * @param numOfRows
 */
void matrix::setNumOfRows(int numOfRows) {
    matrix::numOfRows = numOfRows;
}

/**
 * gets numOfRows
 * @return numOfRows
 */
int matrix::getNumOfRows() {
    return numOfRows;
}

/**
 * sets numOfCols
 * @param numOfCols
 */
void matrix::setNumOfCols(int numOfCols) {
    matrix::numOfCols = numOfCols;
}

/**
 * gets numOfCols
 * @return numOfCols
 */
int matrix::getNumOfCols() {
    return numOfCols;
}

/**
 * sets size1D
 * @param size1D
 */
void matrix::setSize1D(int size1D) {
    matrix::size1D = size1D;
}

/**
 * gets size1D
 * @return
 */
int matrix::getSize1D() {
    return size1D;
}
