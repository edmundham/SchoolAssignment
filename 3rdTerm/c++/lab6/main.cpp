#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include "dictionary.hpp"

using namespace std;

void findWordDef(fstream &file, dictionary *dict) {
    string userSearch;
    cout << "Enter the word" << endl;
    getline(cin, userSearch);
    string def = dict->getDefByWord(userSearch);
    if (def == "notexist") {
        cout << "the word does not exists" << endl;
    } else {
        cout << def << endl;
    }
}

void printWordDef(dictionary *dict) {
    dict->printDictionary();
}

void enterNewWordDef(fstream &file, dictionary *dict) {
    string userWord;
    string userDef;
    string promptMessage = "Enter the word";
    bool isNewWord = false;

    do {
        cout << promptMessage << endl;
        getline(cin, userWord);

        if (!dict->isNewWord(userWord)) {
            isNewWord = false;
            promptMessage="You enter the existed word, please enter again";
            continue;
        } else {
            isNewWord = true;
        }

        cout << "Enter the definition" << endl;
        getline(cin, userDef);
        dict->insertToMap(userWord, userDef, file);
    } while (!isNewWord);

}

int main() {

    string line;

    fstream myFile;
    myFile.open("../Dictionary.txt");

    try {
        dictionary *dict = new dictionary(myFile);

        int userChoice = 1;

        while (userChoice == 1 || userChoice == 2 || userChoice == 3) {
            cout << "1 - Print dictionary" << endl;
            cout << "2 - Find word definition" << endl;
            cout << "3 - Enter new word and definition" << endl;
            cout << "4 - Exit" << endl;

            string userChoiceString;

            getline(cin, userChoiceString);
            stringstream stoi(userChoiceString);
            stoi >> userChoice;

            switch(userChoice) {
                case 1:
                    printWordDef(dict);
                    break;
                case 2:
                    findWordDef(myFile, dict);
                    break;
                case 3:
                    enterNewWordDef(myFile, dict);
                    break;
                case 4:
                    cout << "Thanks" << endl;
                    break;
                default:
                    break;
            }
        }
    } catch (exception &e) {
        cerr << e.what() << endl;
        myFile.close();
    }

    if (myFile.is_open()) {
        myFile.close();
    }

    return 0;
}

