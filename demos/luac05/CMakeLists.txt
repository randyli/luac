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

project(luac05)

set(CMAKE_BUILD_TYPE Debug)


SET (CMAKE_CXX_STANDARD 17)
set(LLVM_DISABLE_ABI_BREAKING_CHECKS_ENFORCING 0)

# include generated files in project environment
include_directories(
  ${PROJECT_SOURCE_DIR}
)

set(MLIR_DIR /Users/randyli/Documents/dev/llvm-dist/lib/cmake/mlir)
link_directories(/usr/local/lib)
find_package(MLIR REQUIRED CONFIG)
message(STATUS "Using MLIRConfig.cmake in: ${MLIR_DIR}")
message(STATUS "Using LLVMConfig.cmake in: ${LLVM_DIR}")

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

include_directories(/usr/local/include/antlr4-runtime)
include_directories(${CMAKE_CURRENT_BINARY_DIR})

set(LLVM_COMPONENTS Support)

set(LIBS 
    MLIROptLib 
    MLIRExecutionEngine
    MLIRAffine
    LLVMLinker
    antlr4-runtime
)

add_llvm_executable(luac05 
  genir.cpp
  main.cpp
  ast.cpp
  LuaBaseListener.cpp 
  LuaBaseVisitor.cpp 
  LuaVisitor.cpp
  LuaLexer.cpp
  LuaListener.cpp 
  LuaParser.cpp 
)

llvm_update_compile_flags(luac05)

target_link_libraries(luac05
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
)

# add generated grammar to demo binary target
#add_dependencies(llvmtest)
