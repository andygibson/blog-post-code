cmake_minimum_required( VERSION 3.1 )

project( OpenGL-starter )

find_package( OpenGL REQUIRED )

include_directories( ${OPENGL_INCLUDE_DIRS} )

set(GLFW_BUILD_EXAMPLES OFF CACHE INTERNAL "Build the GLFW example programs")
set(GLFW_BUILD_TESTS OFF CACHE INTERNAL "Build the GLFW test programs")
set( GLFW_BUILD_DOCS OFF CACHE BOOL  "GLFW lib only" )
set( GLFW_INSTALL OFF CACHE BOOL  "GLFW lib only" )

add_subdirectory( lib/glfw)
include_directories(lib/glad/include)
include_directories(lib/glfw/include)

 


set( SRC src/main.cpp lib/glad/src/glad.c)

##add_executable( OpenGL-starter src/main.cpp lib/glad/src/glad.c)
add_executable( OpenGL-starter src/main.cpp lib/glad/src/glad.c)

target_link_libraries( OpenGL-starter ${OPENGL_LIBRARIES} glfw )

