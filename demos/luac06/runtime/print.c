#include <stdio.h>
#include <memory.h>
#include <stdlib.h>

struct LuaVar {
  int64_t type;
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
      printf("this is from c runtime: %d %d\n",sizeof(struct LuaVar), var->type);
      printf("result: %s\n", var->val.sval);
    }
}

void lua_add(struct LuaVar* a, struct LuaVar*b , struct LuaVar* result) {
    if(a->type == 1 && b->type == 1) {
      result->type = 1;
      result->val.ival = a->val.ival + b->val.ival;
      return;
    }

    if(a->type == 2 && b->type == 2) {
      result->type = 2;
      char* r = malloc(strlen(a->val.sval) + strlen(b->val.sval) + 1);
      result->val.sval = r;
      memcpy(r, a->val.sval, strlen(a->val.sval));
      r += strlen(a->val.sval);
      memcpy(r, b->val.sval, strlen(b->val.sval));
      r += strlen(b->val.sval);
      *r = '\0';
    }
}