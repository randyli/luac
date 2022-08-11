; ModuleID = 'demo.ll'
source_filename = "demo.c"
target datalayout = "e-m:o-i64:64-i128:128-n32:64-S128"
target triple = "arm64-apple-macosx12.0.0"

@.str = private unnamed_addr constant [10 x i8] c"|a-b|=%d\0A\00", align 1

; Function Attrs: noinline nounwind ssp uwtable
define i32 @test(i32 %arg, i32 %arg1) #0 {
bb:
  %i = alloca i32, align 4
  %i2 = alloca i32, align 4
  %i3 = alloca i32, align 4
  store i32 %arg, i32* %i2, align 4
  store i32 %arg1, i32* %i3, align 4
  %i4 = load i32, i32* %i2, align 4
  %i5 = load i32, i32* %i3, align 4
  %i6 = icmp sgt i32 %i4, %i5
  br i1 %i6, label %bb7, label %bb11

bb7:                                              ; preds = %bb
  %i8 = load i32, i32* %i2, align 4
  %i9 = load i32, i32* %i3, align 4
  %i10 = sub nsw i32 %i8, %i9
  store i32 %i10, i32* %i, align 4
  br label %bb15

bb11:                                             ; preds = %bb
  %i12 = load i32, i32* %i3, align 4
  %i13 = load i32, i32* %i2, align 4
  %i14 = sub nsw i32 %i12, %i13
  store i32 %i14, i32* %i, align 4
  br label %bb15

bb15:                                             ; preds = %bb11, %bb7
  ;%i16 = load i32, i32* %i, align 4
  %i16 = phi i32 [%i14, %bb11], [xxxxxx]
  ret i32 %i16
}

; Function Attrs: noinline nounwind ssp uwtable
define i32 @main() #0 {
bb:
  %i = alloca i32, align 4
  store i32 0, i32* %i, align 4
  %i1 = call i32 @test(i32 4, i32 5)
  %i2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([10 x i8], [10 x i8]* @.str, i64 0, i64 0), i32 %i1)
  ret i32 0
}

declare i32 @printf(i8*, ...) #1

attributes #0 = { noinline nounwind ssp uwtable "frame-pointer"="non-leaf" "min-legal-vector-width"="0" "no-trapping-math"="true" "probe-stack"="__chkstk_darwin" "stack-protector-buffer-size"="8" "target-cpu"="apple-m1" "target-features"="+aes,+crc,+crypto,+dotprod,+fp-armv8,+fp16fml,+fullfp16,+lse,+neon,+ras,+rcpc,+rdm,+sha2,+sha3,+sm4,+v8.5a,+zcm,+zcz" }
attributes #1 = { "frame-pointer"="non-leaf" "no-trapping-math"="true" "probe-stack"="__chkstk_darwin" "stack-protector-buffer-size"="8" "target-cpu"="apple-m1" "target-features"="+aes,+crc,+crypto,+dotprod,+fp-armv8,+fp16fml,+fullfp16,+lse,+neon,+ras,+rcpc,+rdm,+sha2,+sha3,+sm4,+v8.5a,+zcm,+zcz" }

!llvm.module.flags = !{!0, !1, !2, !3, !4, !5, !6, !7, !8}
!llvm.ident = !{!9}

!0 = !{i32 2, !"SDK Version", [2 x i32] [i32 12, i32 3]}
!1 = !{i32 1, !"wchar_size", i32 4}
!2 = !{i32 8, !"branch-target-enforcement", i32 0}
!3 = !{i32 8, !"sign-return-address", i32 0}
!4 = !{i32 8, !"sign-return-address-all", i32 0}
!5 = !{i32 8, !"sign-return-address-with-bkey", i32 0}
!6 = !{i32 7, !"PIC Level", i32 2}
!7 = !{i32 7, !"uwtable", i32 1}
!8 = !{i32 7, !"frame-pointer", i32 1}
!9 = !{!"Apple clang version 13.1.6 (clang-1316.0.21.2.3)"}