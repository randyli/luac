#pragma once

#include "llvm/ADT/StringRef.h"
#include "llvm/ADT/SmallVector.h"

namespace luac {
class FunctionCall {
    public:
    FunctionCall(){

    }
    private:
     llvm::StringRef name;
     llvm::SmallVector<llvm::StringRef> args;
};

class Expr {};

}  // namespace luac