cmake_minimum_required(VERSION 3.22.1)
project("sentraedgeaivault")

add_library(vault SHARED cpp_core/vault.cpp)

find_library(log-lib log)

target_link_libraries(vault ${log-lib})