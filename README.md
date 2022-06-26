# luac

A test project to use mlir. It compile the lua code to a exe, and run with a `c` runtime.

## Plan

* hello world,  print("hello world")
* compile a function.
* generate some gpu operation.


## llvm compile tips 

```
 git clone https://github.com/llvm/llvm-project.git
mkdir llvm-project/build
cd llvm-project/build
cmake -G Ninja ../llvm \
   -DLLVM_ENABLE_PROJECTS=mlir \
   -DLLVM_BUILD_EXAMPLES=ON \
   -DLLVM_TARGETS_TO_BUILD="X86;NVPTX;AMDGPU" \
   -DCMAKE_BUILD_TYPE=Release \
   -DLLVM_ENABLE_ASSERTIONS=ON \
   -DCMAKE_INSTALL_PREFIX=[path to install]
#  -DCMAKE_C_COMPILER=clang -DCMAKE_CXX_COMPILER=clang++ -DLLVM_ENABLE_LLD=ON

ninja -j8
```
If you don't have permision to modify the system file,  you can add the `CMAKE_INSTALL_PREFIX` to a personal path

