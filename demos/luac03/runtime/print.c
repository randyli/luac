#include <stdio.h>

struct LuaVar {
  int32_t type;
  int32_t data;
};

void print(struct LuaVar *var) { 
    printf("this is from c runtime: %d  %d\n",var->type, var->data); 
}