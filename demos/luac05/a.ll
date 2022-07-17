; ModuleID = '../a.lua'
source_filename = "../a.lua"

%struct.LuaVar = type { i32, %union.anos }
%union.anos = type { i64 }

@0 = private unnamed_addr constant [19 x i8] c"\22this is a string\22\00", align 1

define i32 @main() {
entry:
  %b = alloca %struct.LuaVar, align 8
  %0 = getelementptr %struct.LuaVar, %struct.LuaVar* %b, i32 0, i32 0
  store i32 2, i32* %0, align 4
  %1 = getelementptr %struct.LuaVar, %struct.LuaVar* %b, i32 0, i32 1
  %2 = bitcast %union.anos* %1 to i8**
  store i8* getelementptr inbounds ([19 x i8], [19 x i8]* @0, i32 0, i32 0), i8** %2, align 8
  br label %while.cond

while.cond:                                       ; preds = %while.body, %entry
  br i1 true, label %while.body, label %while.end

while.body:                                       ; preds = %while.cond
  call void @print(%struct.LuaVar* %b)
  br label %while.cond

while.end:                                        ; preds = %while.cond
  ret i32 0
}

declare void @print(%struct.LuaVar*)