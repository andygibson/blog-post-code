cmake_minimum_required( VERSION 3.1 )

project( OpenGL-starter )

find_package( OpenGL REQUIRED )

include_directories( ${OPENGL_INCLUDE_DIRS} )

set( GLFW_BUILD_DOCS OFF CACHE BOOL  "GLFW lib only" )
set( GLFW_INSTALL OFF CACHE BOOL  "GLFW lib only" )

add_subdirectory( lib/glfw)

 


#set( SRC src/main.cpp lib/glad/src/glad.c)

#add_executable( OpenGL-starter src/main.cpp lib/glad/src/glad.c)
add_executable( OpenGL-starter src/main.cpp lib/glfw/deps/glad_gl.c)

target_link_libraries( OpenGL-starter ${OPENGL_LIBRARIES} glfw )
target_include_directories(OpenGL-starter PRIVATE lib/glfw/deps/)

install(TARGETS OpenGL-starter RUNTIME DESTINATION bin)
