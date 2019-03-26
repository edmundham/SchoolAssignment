cmake_minimum_required(VERSION 3.12)
project(Lab03)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_FLAGS  "${CMAKE_CXX_FLAGS} -Wall -Wextra -pedantic")

add_executable(Lab03 main.cpp Stack.cpp Stack.hpp unit_tests.cpp catch.hpp)