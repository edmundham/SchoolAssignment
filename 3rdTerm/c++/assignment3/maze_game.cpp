//
// Created by Sunguk Ham on 2018-11-29.
//

#include "maze_game.hpp"

maze* maze_game::create_maze(maze_factory *mazeFactory) {
    wall* room1_north = mazeFactory->make_wall("north");
    wall* room1_south = mazeFactory->make_wall("south");
    wall* room1_west = mazeFactory->make_wall("west");
    wall* room1_east = mazeFactory->make_wall("east");

    wall* room2_north = mazeFactory->make_wall("north");
    wall* room2_south = mazeFactory->make_wall("south");
    wall* room2_west = mazeFactory->make_wall("west");
    wall* room2_east = mazeFactory->make_wall("east");

    room* room1 = mazeFactory->make_room(*room1_south, *room1_north, *room1_west, *room1_east);
    room* room2 = mazeFactory->make_room(*room2_south, *room2_north, *room2_west, *room2_east);

    door* door1 = mazeFactory->make_door(*room1, *room2);

    maze* maze1 = mazeFactory->make_maze(*room1, *room2, *door1);

    return maze1;
}
