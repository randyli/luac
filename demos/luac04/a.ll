; ModuleID = '../a.lua'
source_filename = "../a.lua"

%struct.LuaVar = type { i32, %union.anos }
%union.anos = type { i64 }

@0 = private unnamed_addr constant [19 x i8] c"\22this is a string\22\00", align 1

define i32 @main() {
entry:
  %a = alloca %struct.LuaVar, align 8
  %0 = getelementptr %struct.LuaVar, %struct.LuaVar* %a, i32 0, i32 0
  store i32 1, i32* %0, align 4
  %1 = getelementptr %struct.LuaVar, %struct.LuaVar* %a, i32 0, i32 1
  %2 = bitcast %union.anos* %1 to i64*
  store i64 5, i64* %2, align 4
  call void @print(%struct.LuaVar* %a)
  %b = alloca %struct.LuaVar, align 8
  %3 = getelementptr %struct.LuaVar, %struct.LuaVar* %b, i32 0, i32 0
  store i32 2, i32* %3, align 4
  %4 = getelementptr %struct.LuaVar, %struct.LuaVar* %b, i32 0, i32 1
  %5 = bitcast %union.anos* %4 to i8**
  store i8* getelementptr inbounds ([19 x i8], [19 x i8]* @0, i32 0, i32 0), i8** %5, align 8
  call void @print(%struct.LuaVar* %b)
  ret i32 0
}

declare void @print(%struct.LuaVar*)