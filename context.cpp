#include "context.h"

namespace luac {

int Context::getOptimizatioLevel() {
  if (targetPhase <= CompilationPhase::NoOptimization) {
    return 0;
  }

  if (targetPhase == CompilationPhase::O1) {
    return 1;
  }
  if (targetPhase == CompilationPhase::O2) {
    return 2;
  }
  return 3;
}

std::unique_ptr<Context> makeContext() { return std::make_unique<Context>(); };

}  // namespace luac