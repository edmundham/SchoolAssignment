cmake_minimum_required(VERSION 3.12)
project(lab4)

set(CMAKE_CXX_STANDARD 14)

add_executable(lab4 inheritance.cpp animal.cpp animal.hpp bird.cpp bird.hpp canine.cpp canine.hpp)