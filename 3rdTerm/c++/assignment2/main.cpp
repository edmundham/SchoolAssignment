#include <iostream>
#include <random>
#include <sys/param.h>
#include <fstream>
#include <sstream>
#include <chrono>
#include "city.hpp"
#include "tour.hpp"

using namespace std::chrono;
using namespace std;

int CITIES_IN_TOURS = 32;
int POPULATION_SIZE = 32;
int ITERATIONS = 1000;
int MAP_BOUNDARY = 1000;
int PARENT_POOL_SIZE = 5;
double MUTATION_RATE = 0.15;
int MAX_PERCENTAGE = 100;

int main() {

    ifstream file{"../city.txt"};

    random_device rd;
    mt19937 generator(rd());

    vector<city> cities;
    string line;
//    Setting up 32 cities
    for (int i = 0; i < CITIES_IN_TOURS && getline(file, line); i++) {
        uniform_int_distribution<int> x_y_generator(0, MAP_BOUNDARY);
        istringstream ss(line);
        string city_name;
        ss >> city_name;
        cities.emplace_back(city(i, city_name, x_y_generator(generator), x_y_generator(generator)));
    }
//    Setting up 32 tours based on 32 cities
    vector<tour> tours;
    for (int i = 0; i < POPULATION_SIZE; i++) {
        long seed = system_clock::now().time_since_epoch().count();
        std::shuffle(std::begin(cities), std::end(cities), default_random_engine(seed));
        tours.emplace_back(tour(cities));
    }

    sort(tours.begin(), tours.end());
    cout << "Initial tours " << tours.size() <<  " : " << endl;
    for (auto tour : tours) {
        cout << "Tour's fitness rating is " << tour.get_fitness_rating() << endl;
    }
    cout << "===============================" << endl;

//    ITERATION
    for (int iteration = 0; iteration < ITERATIONS; iteration++) {
//        SELECTION
        sort(tours.begin(), tours.end());

        tour fittest_tour = tours.at(0);
        double base_distance = fittest_tour.get_total_distance();
        long double fitness_rating = fittest_tour.get_fitness_rating();
        cout << "Iterations: " << iteration << ", Fitness Rating: " << fitness_rating << ", Total Distance: " << base_distance << endl;

        vector<tour>::const_iterator first = tours.begin() + 1;
        vector<tour>::const_iterator end = tours.end();
        vector<tour> new_tours;

//        CROSSOVER
        vector<tour> pool1;
        vector<tour> pool2;
        long seed = system_clock::now().time_since_epoch().count();
        std::shuffle(std::begin(tours), std::end(tours), default_random_engine(seed));
        for (unsigned long i = 0; i < PARENT_POOL_SIZE * 2; i += 2) {
            pool1.emplace_back(tours.at((i)));
            pool2.emplace_back(tours.at(i + 1));
        }
        sort(tours.begin(), tours.end());
        tours.erase(tours.begin() + 1, tours.end());

        sort(pool1.begin(), pool1.end());
        sort(pool2.begin(), pool2.end());

        tour parent1 = pool1.at(0);
        tour parent2 = pool2.at(0);

        vector<city> parent1_cities = parent1.get_cities();
        vector<city> parent2_cities = parent2.get_cities();

//        MUTATION
        for (int i = 0; i < POPULATION_SIZE - 1; i++) {
            uniform_int_distribution<int> index_generator(0, CITIES_IN_TOURS);
            int random_index = index_generator(generator);
            vector<city> child_cities;
            for (unsigned long j = 0; j < random_index; j++) {
                child_cities.emplace_back(parent1_cities.at(j));
            }
            for (unsigned long j = 0; j < CITIES_IN_TOURS; j++) {
                child_cities.emplace_back(parent2_cities.at(j));
            }
            sort(child_cities.begin(), child_cities.end());
            child_cities.erase(unique(child_cities.begin(), child_cities.end()), child_cities.end());

            for (int j = 0; j < child_cities.size() - 1; j++) {
                uniform_int_distribution<int> die_generator(1, MAX_PERCENTAGE);
                if (die_generator(generator) <= MUTATION_RATE * MAX_PERCENTAGE) {
                    iter_swap(child_cities.begin() + j, child_cities.begin() + j + 1);
                }
            }

            seed = system_clock::now().time_since_epoch().count();
            std::shuffle(std::begin(child_cities), std::end(child_cities), default_random_engine(seed));
            tour child(child_cities);

            new_tours.emplace_back(child);
        }
        tours.insert(std::end(tours), std::begin(new_tours), std::end(new_tours));
    }

    sort(tours.begin(), tours.end());
    cout << "===============================" << endl << "Final tours " << tours.size() <<  " : " << endl;
    for (auto tour : tours) {
        cout << "Tour's fitness rating is " << tour.get_fitness_rating() << endl;
    }

    return 0;
}