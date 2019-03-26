cmake_minimum_required(VERSION 3.12)
project(abstractfactory)

set(CMAKE_CXX_STANDARD 14)

add_executable(abstractfactory main.cpp maze_factory.hpp maze.hpp wall.hpp room.hpp door.hpp maze_game.cpp maze_game.hpp enchanted_maze_factory.cpp enchanted_maze_factory.hpp futuristic_maze_factory.cpp futuristic_maze_factory.hpp enchanted_maze.cpp enchanted_maze.hpp enchanted_wall.cpp enchanted_wall.hpp enchanted_door.cpp enchanted_door.hpp enchanted_room.cpp enchanted_room.hpp futuristic_door.cpp futuristic_door.hpp futuristic_maze.cpp futuristic_maze.hpp futuristic_room.cpp futuristic_room.hpp futuristic_wall.cpp futuristic_wall.hpp)