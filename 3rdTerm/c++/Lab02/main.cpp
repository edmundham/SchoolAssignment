#include <iostream>
#include <fstream>
#include <iomanip>
#include <algorithm>
#include <vector>
#include "utils.hpp"

using namespace std;

const int PRECISION = 3;

int randomNumber;

void writeToFile();
void readFromFile();
void processStats(vector<double> doubleArray, int size);

/**
 * Main function, call writeToFile and readFromFile
 * @return 1
 */
int main() {
    writeToFile();
    readFromFile();

    return 1;
}

/**
 * Write random doubles into the file by calling utils.randInt and utils.randDouble functions
 */
void writeToFile() {
    ofstream outFile;
    outFile.open("Readings.txt");

    randomNumber = randInt();

    for (int i = 0; i < randomNumber; i++) {
        outFile << i << " ";
        outFile << fixed;
        outFile << setprecision(PRECISION);
        outFile << randDouble() << endl;
    }
    outFile.close();
}

/**
 * Read randomly generated numbers from the file, and call processStats function to print out statistics
 */
void readFromFile() {
    ifstream inFile;
    string line;
    int size = 0;
    double temp;
    vector<double> doubleArray;

    inFile.open("Readings.txt");
    while (getline(inFile, line)) {
        istringstream randomString(line);
        randomString >> size >> temp;
        doubleArray.push_back(temp);
    }
    processStats(doubleArray, size + 1);
}

/**
 * Prints out number of readings, average, highest and lowest value, and median.
 * @param doubleArray contains all randomly generated double values
 * @param size of the doubleArray
 */
void processStats(vector<double> doubleArray, int size) {
    sort(doubleArray.begin(), doubleArray.end());

    const int readings = size;
    double sum = 0;
    double average;
    double highest = 0;
    double lowest = doubleArray[0];
    double median;
    if (size % 2 == 0) {
        median = (doubleArray[(size / 2) - 1] + doubleArray[size / 2]) / 2;
    } else {
        median = doubleArray[size / 2];
    }

    for(int i = 0; i < size; i++) {
        highest = doubleArray[i];
        sum += doubleArray[i];
    }
    average = sum / (double) size;

    cout << "There are " << readings << " readings in the file." << endl;
    cout << "The average reading is " << fixed << setprecision(PRECISION) << average << "." << endl;
    cout << "The highest reading is " << fixed << setprecision(PRECISION) << highest << "." << endl;
    cout << "The lowest reading is " << fixed << setprecision(PRECISION) << lowest << "." << endl;
    cout << "The median reading is " << fixed << setprecision(PRECISION) << median << "." << endl;
}
