#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <vector>
#include <map>
#include <algorithm>
#include "people.hpp"

using namespace std;

vector<people> get_people_from_file(vector<people> peoples) {

}

void print_everyone(vector<people> peoples) {

}


int main() {

    vector<people> peoples;
    vector<int> index_to_be_deleted;

    // GET LISTS FROM TXT FILE
    ifstream file("../peoplePlaces.txt");
    string line;

    while (getline(file, line)) {
        stringstream ss(line);

        string person_name;
        ss >> person_name;

        vector<location> locations;
        string location_name;
        while (ss >> location_name) {
            locations.emplace_back(location(location_name));
        }

        peoples.emplace_back(people(person_name, locations));
    }

    // PRINTS EVERYONE AFTER SORTING
    sort(peoples.begin(), peoples.end());
    cout << "Everybody in the city" << endl;
    for (people people1: peoples) {
        cout << people1;
    }
    cout << endl;

    // PRINTS PEOPLE WHO VISITED BOTH KRUSTY-BURGER AND TAVERN
    cout << "Visited both Krusty-Burger and Tavern" << endl;
    for (people people1 : peoples) {
        if (people1.is_visited("Krusty-Burger") && people1.is_visited("Tavern")) {
            cout << people1;
        }
    }
    cout << endl;

    // PRINTS PEOPLE WHO DID NOT VISIT KRUSTY-BURGER AND HOME
    cout << "Did NOT visit Krusty-Burger and Home" << endl;
    for (people people1 : peoples) {
        if (!people1.is_visited("Krusty-Burger") && !people1.is_visited("Home")) {
            cout << people1;
        }
    }
    cout << endl;

    // PRINTS PEOPLE WHO VISITED KRUSTY-BURGER AND SCHOOL BUT DID NOT VISIT TAVERN AND HOME
    cout << "Visited Krusty-Burger and School but did NOT visit Tavern and Home" << endl;
    for (people people1 : peoples) {
        if ((people1.is_visited("Krusty-Burger") && people1.is_visited("School"))
            && (!people1.is_visited("Tavern") && !people1.is_visited("Home"))) {
            cout << people1;
        }
    }
    cout << endl;

    // PRINTS PEOPLE WHO VISITED ALL LOCATIONS AND REMOVE THEM FROM THE LIST
    cout << "Removing visited all locations" << endl;
    int i = 0;
    for (people people1 : peoples) {
        if (people1.is_visited("Krusty-Burger") && people1.is_visited("School")
            && people1.is_visited("Tavern") && people1.is_visited("Home")) {
            cout << people1;
            index_to_be_deleted.emplace_back(i);
        }
        i++;
    }
    int deleted = 0;
    for (int index : index_to_be_deleted) {
        peoples.erase(peoples.begin() + index - deleted);
        deleted++;
    }
    cout << endl;

    // PRINTS EVERYONE AFTER REMOVING AND SORTING
    sort(peoples.begin(), peoples.end());
    cout << "Everybody in the city after removing people who visited all locations" << endl;
    for (people people1: peoples) {
        cout << people1;
    }



    return 0;
}