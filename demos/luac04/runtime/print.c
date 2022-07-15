#include <stdio.h>

struct LuaVar {
  int32_t type;
  union{
    int64_t ival;
    float fval;
    char* sval;
  } val;
};

void print(struct LuaVar *var) { 
    if(var->type == 1) {
      printf("this is from c runtime: %d  %d\n",var->type, var->val.ival);
    }else if (var->type == 2) {
      printf("this is from c runtime: %d  %s\n",var->type, var->val.sval);
    }


     
}