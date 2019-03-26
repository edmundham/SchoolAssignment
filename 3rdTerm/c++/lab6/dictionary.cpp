//
// Created by Sunguk Ham on 2018-11-01.
//

#include <fstream>
#include <iostream>
#include <sstream>
#include "dictionary.hpp"

using namespace std;

/**
 * default constructor
 */
dictionary::dictionary() {

}

/**
 * construct dictionary object by reading the dictionary txt file and store them to the map
 * @param file txt file
 */
dictionary::dictionary(fstream &file) {
    string line;

    while (getline(file, line)) {
        istringstream ss(line);
        string key;
        string value;
        getline(ss, key, '*');
        getline(ss, value, '*');

        dictMap.insert(make_pair(key, value));
    }
}

/**
 * print word and definitions in the map
 */
void dictionary::printDictionary() {
    map<string, string>::iterator it;

    for (it = dictMap.begin(); it != dictMap.end(); it++) {
        cout << it->first << " - " << it->second << endl;
    }

}

/**
 * get definition by word
 * @param word user input
 * @return definitions
 */
string dictionary::getDefByWord(string word) {
    if (isNewWord(word)) {
        return "notexist";
    }
    return dictMap.at(word);
}

/**
 * insert the word and definition to the map
 * @param word
 * @param definition
 * @param file txt file
 */
void dictionary::insertToMap(string word, string definition, fstream &file) {
    dictMap.insert(make_pair(word, definition));

    file.clear();
    file << word << "*" << definition << endl;
}

/**
 * checks if the word exists
 * @param word
 * @return true if exists
 */
bool dictionary::isNewWord(string word) {
    return dictMap.count(word) == 0;
}

