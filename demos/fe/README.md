# antlr4 install

# antlr lua grammar show

antlr实现的各种语法
https://github.com/antlr/grammars-v4

```
antlr4 Lua.g4
javac Lua*.java

grun Lua chunk -gui

输入一些lua代码

control-D

```

# 生成c++代码

```
antlr4 -Werror -Dlanguage=Cpp -listener -visitor -package luac  -o ./ Lua.g4

clan++  *.cpp -std=c++17 -lantlr4-runtime -I/usr/local/include/antlr4-runtime
```