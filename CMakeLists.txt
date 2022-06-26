CMAKE_MINIMUM_REQUIRED(VERSION 3.5)


if (POLICY CMP0068)
	cmake_policy(SET CMP0068 NEW)
	set(CMAKE_BUILD_WITH_INSTALL_NAME_DIR ON)
endif ()

if(POLICY CMP0075)
	cmake_policy(SET CMP0075 NEW)
endif()

if (POLICY CMP0077)
	cmake_policy(SET CMP0077 NEW)
endif ()

project(luac)

set(CMAKE_BUILD_TYPE Debug)

LIST( APPEND CMAKE_MODULE_PATH ${PROJECT_SOURCE_DIR}/cmake )

SET (CMAKE_CXX_STANDARD 17)
include (antlr)
set(ANTLR4CPP_JAR_LOCATION /usr/local/lib/antlr-4.10.1-complete.jar)
set(LLVM_DISABLE_ABI_BREAKING_CHECKS_ENFORCING 0)
antlr4cpp_process_grammar(luac luac
  ${CMAKE_CURRENT_SOURCE_DIR}/grammar/Lua.g4)
# include generated files in project environment
include_directories(
  /usr/local/include/antlr4-runtime 
  ${antlr4cpp_include_dirs_luac} 
  ${PROJECT_SOURCE_DIR}
)

set(MLIR_DIR /Users/randyli/Documents/dev/llvm-dist/lib/cmake/mlir)
link_directories(/usr/local/lib)
find_package(MLIR REQUIRED CONFIG)
message(STATUS "Using MLIRConfig.cmake in: ${MLIR_DIR}")
message(STATUS "Using LLVMConfig.cmake in: ${LLVM_DIR}")



message(STATUS "Using MLIRConfig.cmake in: ${MLIR_DIR}")

set(LLVM_RUNTIME_OUTPUT_INTDIR ${CMAKE_BINARY_DIR}/bin)
set(LLVM_LIBRARY_OUTPUT_INTDIR ${CMAKE_BINARY_DIR}/lib)
set(MLIR_BINARY_DIR ${CMAKE_BINARY_DIR})

list(APPEND CMAKE_MODULE_PATH "${MLIR_CMAKE_DIR}")
list(APPEND CMAKE_MODULE_PATH "${LLVM_CMAKE_DIR}")
include(TableGen)
include(AddLLVM)
include(AddMLIR)
include(HandleLLVMOptions)

include_directories(${LLVM_INCLUDE_DIRS})
separate_arguments(LLVM_DEFINITIONS_LIST NATIVE_COMMAND ${LLVM_DEFINITIONS})
add_definitions(${LLVM_DEFINITIONS_LIST})
link_directories(${LLVM_BUILD_LIBRARY_DIR})

include_directories(${MLIR_INCLUDE_DIRS})

include_directories(include/)
include_directories(${CMAKE_CURRENT_BINARY_DIR})

set(LLVM_COMPONENTS Support)

set(LIBS 
    MLIROptLib 
    MLIRExecutionEngine
    MLIRAffine
    LLVMLinker
)

add_llvm_executable(luac 
  main.cpp
  context.cpp 
  mlir_generator.cpp
  ${antlr4cpp_src_files_luac}
)

llvm_update_compile_flags(luac)

target_link_libraries(luac
  PRIVATE
	${LIBS}
    MLIRAnalysis 
    MLIRCallInterfaces 
    MLIRIR
    MLIRParser 
    MLIRPass
    MLIRSideEffectInterfaces
    MLIRTransforms
    MLIRDialect
    MLIRFunc
    MLIRFuncToLLVM
    antlr4-runtime
)

# add generated grammar to demo binary target
add_dependencies(luac antlr4cpp_generation_luac)