---
marp: true
theme: gaia
footer: '铁板里脊123'
paginate: true
style: |
  section a {
      font-size: 30px;
  }

---

# llvm 中的 DCE(Dead code elimination)

## 无用代码清除

---

## 前提条件

* 对内存操作无效，在mem2reg之后执行

---

## 基本算法

```
alloca %l1
alloca %l2  //删除无用的栈内存分配
b0:
%x = 1 + 2 
call @print(%x)
nop  // 无用指令
jmp b1 

b1:
%y = 3 +4 //无用运算 
%z = store %l1 42  //不能删除，因为有内存操作，(side effect)
return %x
```

---

# llvm 中的算法

* DCE //普通的无用代码删除
* ADCE //激进的无用代码删除
* BDCE //bit跟踪无用代码删除

---
# DCE
```
DCE.cpp:87

```
---
# ADCE 

Aggressive Dead Code Elimination

* 默认所有指令都是无效的，除非有证据证明这条指令有效

```
1 标记所有的出口指令或者写内存指令为有效指令
2 以此为基础向上搜索其操作数指令，并标记为有效
3 没有被标记的指令就是无效指令，删除。
```
---

# BDCE 

Bit-Tracking Dead Code Elimination

确定结果中的bit完全不需要或者某些位不需要

```
%1 = add i8 3, i8 4
%2 = shl 8, %1 // $2完全不需要

```