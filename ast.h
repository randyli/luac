#pragma once

#include <iostream>

#include "llvm/ADT/SmallVector.h"
#include "llvm/ADT/StringRef.h"

namespace luac {

class Stat {
 public:
  virtual void dump() = 0;
  virtual ~Stat() {}
};

class FunctionCall : public Stat {
 public:
  FunctionCall() {}

  void dump() override { std::cout << "function call: " << name << std::endl; }

 public:
  std::string name;
  llvm::SmallVector<std::string> args;
};

class IfStat : public Stat {
 public:
  void dump() override {}
};

class DoStat : public Stat {
 public:
  void dump() override {}
};

class AstContext final {
 public:
  AstContext(const AstContext &) = delete;
  void operator=(const AstContext &) = delete;
  AstContext() {}
  void AddStat(std::unique_ptr<Stat> f) { stats.push_back(std::move(f)); }

 public:
  llvm::SmallVector<std::unique_ptr<Stat>> stats;
};

}  // namespace luac