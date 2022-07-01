#pragma once

#include "llvm/ADT/SmallVector.h"
#include "llvm/ADT/StringRef.h"

namespace luac {

class Stat {

};

class FunctionCall :public Stat {
 public:
  FunctionCall() {}

 public:
  std::string name;
  llvm::SmallVector<std::string> args;
};

class IfStat : public Stat {};

class DoStat : public Stat {};

class AstContext final {
 public:
  AstContext(const AstContext &) = delete;
  void operator=(const AstContext &) = delete;
  AstContext() {}
  void AddStat(std::unique_ptr<Stat> f) {
    stats.push_back(std::move(f));
  }

 public:
  llvm::SmallVector<std::unique_ptr<Stat>> stats;
};

}  // namespace luac