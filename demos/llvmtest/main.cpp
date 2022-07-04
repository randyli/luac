#include "llvm/Support/raw_ostream.h"

int main() { 
  llvm::errs() << "hello llvm!";
  return 0;
}