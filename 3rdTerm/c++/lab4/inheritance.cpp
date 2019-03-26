#include <iostream>
#include "animal.hpp"
#include "bird.hpp"
#include "canine.hpp"

int main() {

    // Creating pointer objects of animals
    animal* animal1;
    animal* animal2;
    animal* animal3;

    // Dynamically allocating objects
    animal1 = new animal;
    animal2 = new bird;
    animal3 = new canine;

    cout << endl;

    // Animals move. Assumption here is that animals can change its' altitude, i.e. climbing mountains
    animal1->move(1.0, 1.0);
    ((bird*)animal2)->move(2.0, 2.0, 2.0);
    animal3->move(3.0, 3.0);

    cout << endl;

    // Print to check
    cout << *animal1 << *animal2 << *animal3 << endl;

    cout << endl;

    // Animals are sleeping
    animal1->sleep();
    animal2->sleep();
    animal3->sleep();

    cout << endl;

    // Animals are eating
    animal1->eat();
    animal2->eat();
    animal3->eat();

    cout << endl;

    // Canine hunting. I had to cast as animal3 is a animal pointer pointing canine reference.
    ((canine*)animal3)->hunt();




    return 0;
}