; ModuleID = '../a.lua'
source_filename = "../a.lua"

%struct.LuaVar = type { i32, i32 }

define i32 @main() {
entry:
  %a = alloca %struct.LuaVar, align 8
  %0 = getelementptr %struct.LuaVar, %struct.LuaVar* %a, i32 0, i32 0
  store i32 1, i32* %0, align 4
  %1 = getelementptr %struct.LuaVar, %struct.LuaVar* %a, i32 0, i32 1
  store i32 5, i32* %1, align 4
  call void @print(%struct.LuaVar* %a)
  ret i32 0
}

declare void @print(%struct.LuaVar*)