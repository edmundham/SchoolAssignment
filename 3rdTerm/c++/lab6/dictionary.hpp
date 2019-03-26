//
// Created by Sunguk Ham on 2018-11-01.
//

#ifndef LAB6_DICTIONARY_HPP
#define LAB6_DICTIONARY_HPP

#include <map>

using namespace std;

class dictionary {

public:
    /**
     * default constructor
     */
    dictionary();
    /**
     * constructs the object and store the dictionary contents to the map
     * @param file txt file
     */
    dictionary(fstream &file);
    /**
     * print the contents of the dictionary
     */
    void printDictionary();
    /**
     * get definition by word
     * @param word user input
     * @return definition
     */
    string getDefByWord(string word);
    /**
     * insert the word and definition to the map
     * @param word
     * @param definition
     * @param file txt file
     */
    void insertToMap(string word, string definition, fstream &file);
    /**
     * checks if the word exists
     * @param word
     * @return true if exists, false otherwise
     */
    bool isNewWord(string word);

private:
    /**
     * map that stores contents of the dictionary
     */
    map<string, string> dictMap;

};

#endif //LAB6_DICTIONARY_HPP
