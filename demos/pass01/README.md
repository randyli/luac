# pass 的写法

## 代码
```
#include "llvm/ADT/Statistic.h"
#include "llvm/IR/Function.h"
#include "llvm/Pass.h"
#include "llvm/Support/raw_ostream.h"
using namespace llvm;

#define DEBUG_TYPE "hello"

STATISTIC(HelloCounter, "Counts number of functions greeted");

namespace {
  // Hello - The first implementation, without getAnalysisUsage.
  struct Hello : public FunctionPass {
    static char ID; // Pass identification, replacement for typeid
    Hello() : FunctionPass(ID) {}

    bool runOnFunction(Function &F) override {
      ++HelloCounter;
      errs() << "Hello: ";
      errs().write_escaped(F.getName()) << '\n';
      return false;
    }
  };
}

char Hello::ID = 0;
static RegisterPass<Hello> X("hello", "Hello World Pass");

```

## cmake
```
add_llvm_library( LLVMHello MODULE BUILDTREE_ONLY
  Hello.cpp

  DEPENDS
  intrinsics_gen
  PLUGIN_TOOL
  opt
  )

```

## 注册机制

```
静态变量 registry

```

## demo

```
/Users/randyli/Documents/dev/llvm-main/build/bin/opt -mem2reg ../luac06/a.ll -S
```

```
/Users/randyli/Documents/dev/llvm-main/build/bin/opt -load=/Users/randyli/Documents/dev/llvm-main/build/lib/LLVMHello.dylib  -hello ../luac06/a.ll  -enable-new-pm=0 -S
```

# mem2reg pass 

## 目标
消除冗余的 alloca store load 
生成ssa 
define i32 @add(i32 %0, i32 %1) #0 {
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  store i32 %0, i32* %3, align 4
  store i32 %1, i32* %4, align 4
  %5 = load i32, i32* %3, align 4
  %6 = load i32, i32* %4, align 4
  %7 = add nsw i32 %5, %6
  ret i32 %7
}

## phi 节点

来自不同分支的值的汇合
%y = phi i32 [ %argc, %entry ], [ %x, %L0 ]

## tips 把ll变量转换为有名字的
opt -instnamer -S demo.ll

## 基本原理
用phi节点替换

去除多余phi节点
1 只在一个BasicBlock中store，这个Block所Dominate的Block中的load就直接替换掉即可
2 store和load只在同一个Block中（大部分情况），线性扫描一下替换即可
3 计算支配边界，在Block的开头加入phi节点

对于内存直接操作无效

## 基本操作

### 指令删除 
I->eraseFromParent() 删除所有引用

I->removeFromParent() 只从列表中删除，但是不删除引用，用在需要重新放回去的情况

### 获取参数

LI->getOperand(0)