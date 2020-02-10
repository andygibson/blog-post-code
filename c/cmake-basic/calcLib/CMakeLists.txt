
add_library(calcLib src/Calc.cpp)
message("${CMAKE_CURRENT_SOURCE_DIR} is the current source")
 

target_include_directories( calcLib PUBLIC ${CMAKE_CURRENT_SOURCE_DIR}/include)