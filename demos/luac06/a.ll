; ModuleID = '../a.lua'
source_filename = "../a.lua"
target triple = "arm64-apple-darwin21.4.0"

%struct.LuaVar = type { i64, %union.anos }
%union.anos = type { i64 }

@0 = common global %struct.LuaVar zeroinitializer
@1 = private unnamed_addr constant [8 x i8] c"\22hello\22\00", align 1
@2 = common global %struct.LuaVar zeroinitializer
@3 = private unnamed_addr constant [8 x i8] c"\22world\22\00", align 1

define i32 @main() {
entry:
  %a = alloca %struct.LuaVar, align 8
  store i64 2, i64* getelementptr inbounds (%struct.LuaVar, %struct.LuaVar* @0, i32 0, i32 0), align 4
  store i8* getelementptr inbounds ([8 x i8], [8 x i8]* @1, i32 0, i32 0), i8** bitcast (%union.anos* getelementptr inbounds (%struct.LuaVar, %struct.LuaVar* @0, i32 0, i32 1) to i8**), align 8
  %0 = bitcast %struct.LuaVar* %a to i8*
  call void @llvm.memcpy.p0i8.p0i8.i64(i8* %0, i8* bitcast (%struct.LuaVar* @0 to i8*), i64 16, i1 false)
  %b = alloca %struct.LuaVar, align 8
  store i64 2, i64* getelementptr inbounds (%struct.LuaVar, %struct.LuaVar* @2, i32 0, i32 0), align 4
  store i8* getelementptr inbounds ([8 x i8], [8 x i8]* @3, i32 0, i32 0), i8** bitcast (%union.anos* getelementptr inbounds (%struct.LuaVar, %struct.LuaVar* @2, i32 0, i32 1) to i8**), align 8
  %tmp = alloca %struct.LuaVar, align 8
  call void @lua_add(%struct.LuaVar* %a, %struct.LuaVar* @2, %struct.LuaVar* %tmp)
  %1 = bitcast %struct.LuaVar* %b to i8*
  %2 = bitcast %struct.LuaVar* %tmp to i8*
  call void @llvm.memcpy.p0i8.p0i8.i64(i8* %1, i8* %2, i64 16, i1 false)
  call void @print(%struct.LuaVar* %b)
  %print = alloca %struct.LuaVar, align 8
  ret i32 0
}

; Function Attrs: argmemonly nofree nounwind willreturn
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg) #0

declare void @lua_add(%struct.LuaVar*, %struct.LuaVar*, %struct.LuaVar*)

declare void @print(%struct.LuaVar*)

attributes #0 = { argmemonly nofree nounwind willreturn }