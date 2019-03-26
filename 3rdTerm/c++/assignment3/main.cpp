#include <iostream>
#include "heap.hpp"
#include "maze.hpp"
#include "maze_factory.hpp"
#include "enchanted_maze_factory.hpp"
#include "futuristic_maze_factory.hpp"
#include "maze_game.hpp"

using namespace std;

/**
 * Abstract Factory
 * @return 0
 */
int main() {
    random_device rd;
    mt19937 generator(rd());
    uniform_int_distribution<int> binary(0, 1);
    vector<maze> vec;
    maze_game mazeGame;
    for (int i = 0; i < 9; i++) {
        int flag = binary(generator);
        maze_factory* maze_factory1;
        if (flag == 0) {
            maze_factory1 = new enchanted_maze_factory();
        } else {
            maze_factory1 = new futuristic_maze_factory();
        }
        vec.emplace_back(*(mazeGame.create_maze(maze_factory1)));
        delete(maze_factory1);
    }

    heap<maze> heap2(vec.begin(), vec.end());

    cout << "HEAP elements are: " << endl << heap2;
    cout << "HEAP size is: " << heap2.size() << endl;

    cout << "POP: " << heap2.pop() << endl;
    cout << "HEAP elements are: " << endl << heap2;
    cout << "HEAP size is: " << heap2.size() << endl;

    heap2.clear();
    cout << "HEAP size after clearing: " << heap2.size() << endl;

    return 0;
}