; ModuleID = '../a.lua'
source_filename = "../a.lua"

@0 = private unnamed_addr constant [13 x i8] c"\22hello llvm\22\00", align 1
@1 = private unnamed_addr constant [25 x i8] c"\22this is another string\22\00", align 1
@2 = private unnamed_addr constant [25 x i8] c"\22this is another string\22\00", align 1

define i32 @main() {
entry:
  call void @print(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @0, i32 0, i32 0))
  call void @print(i8* getelementptr inbounds ([25 x i8], [25 x i8]* @1, i32 0, i32 0))
  call void @print(i8* getelementptr inbounds ([25 x i8], [25 x i8]* @2, i32 0, i32 0))
  ret i32 0
}

declare void @print(i8*)