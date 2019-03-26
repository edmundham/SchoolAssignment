#include <iostream>
#include <fstream>
#include "matrix.hpp"
#include "utils.hpp"

void processPageRank(matrix G, int matrixSize);

using namespace std;

int main() {
    ifstream file{"../connectivity.txt"};
    vector<double> connectivity;
    double num = 0.0;
    while (file >> num) {
        connectivity.emplace_back(num);
    }

    double doubleArray[connectivity.size()];
    copy(connectivity.begin(), connectivity.end(), doubleArray);

    try {
        matrix G(doubleArray, connectivity.size());
        processPageRank(G, connectivity.size());
    } catch (invalid_argument e) {
        cerr << e.what();
    }

}

void processPageRank(matrix G, int matrixSize) {
    matrix S = G.getImportance();
    S.getProbability();

    double doubleQArray[matrixSize];
    for (int i = 0; i < matrixSize; i++) {
        doubleQArray[i] = 1;
    }
    matrix Q(doubleQArray, matrixSize);
    Q = Q.getImportance();

    matrix M = 0.85 * S + (1 - 0.85) * Q;

    matrix rank(floorSqrt(matrixSize), 1);
    rank++;

    matrix tempRank;
    while (tempRank != rank) {
        tempRank = rank;
        rank = M * rank;
    }

    rank.divideElementsBySum();
    cout << rank;
}
