cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)
set(libs "${CMAKE_SOURCE_DIR}/libs")
set(cpps "${CMAKE_SOURCE_DIR}/src/main/cpp")
include_directories(${CMAKE_SOURCE_DIR}/src/main/cpp/include)

add_library( yuv STATIC IMPORTED )
set_target_properties( yuv PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libyuv.a" )

add_library(
        yuvtool
        SHARED
        ${cpps}/yuvtool.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        yuvtool
        yuv
        ${log-lib})