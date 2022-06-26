# -*- mode:cmake -*-

CMAKE_MINIMUM_REQUIRED(VERSION 2.8.12.2)

macro(antlr4cpp_process_grammar
    antlr4cpp_project
    antlr4cpp_project_namespace
    antlr4cpp_grammar_parser)
  if(EXISTS "${ANTLR4CPP_JAR_LOCATION}")
    message(STATUS "Found antlr tool: ${ANTLR4CPP_JAR_LOCATION}")
  else()
    message(FATAL_ERROR "Unable to find antlr tool. ANTLR4CPP_JAR_LOCATION:${ANTLR4CPP_JAR_LOCATION}")
  endif()
  set (ANTLR4CPP_GENERATED_SRC_DIR "antlr4cpp_generation_${antlr4cpp_project_namespace}")
  add_custom_target(
    "antlr4cpp_generation_${antlr4cpp_project_namespace}"
    ALL
    COMMAND
    ${CMAKE_COMMAND} -E make_directory ${ANTLR4CPP_GENERATED_SRC_DIR}
    COMMAND
    java -jar "${ANTLR4CPP_JAR_LOCATION}" -Werror -Dlanguage=Cpp -listener -visitor -o "${ANTLR4CPP_GENERATED_SRC_DIR}" -package ${antlr4cpp_project_namespace} "${antlr4cpp_grammar_parser}"
    WORKING_DIRECTORY "${CMAKE_BINARY_DIR}"
    DEPENDS "${antlr4cpp_grammar_parser}"
    )

  # Find all the input files
  FILE(GLOB generated_files ${CMAKE_CURRENT_BINARY_DIR}/${ANTLR4CPP_GENERATED_SRC_DIR}/*.cpp)

  # export generated cpp files into list
  foreach(generated_file ${generated_files})
    list(APPEND antlr4cpp_src_files_${antlr4cpp_project_namespace} ${generated_file})
    set_source_files_properties(
      ${generated_file}
      PROPERTIES
      COMPILE_FLAGS -Wno-overloaded-virtual
      )
  endforeach(generated_file)
  message(STATUS "Antlr4Cpp ${antlr4cpp_project_namespace} Generated: ${generated_files}")

  # export generated include directory
  set(antlr4cpp_include_dirs_${antlr4cpp_project_namespace} ${CMAKE_CURRENT_BINARY_DIR}/${ANTLR4CPP_GENERATED_SRC_DIR})
  message(STATUS "Antlr4Cpp ${antlr4cpp_project_namespace} include: ${ANTLR4CPP_GENERATED_SRC_DIR}")

endmacro()
