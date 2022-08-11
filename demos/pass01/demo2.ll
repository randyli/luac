 define i32 @__main( i32 %argc, i8** %argv) {
 entry:
   switch  i32 %argc, label %L1 [ i32 0, label %L0
                                  i32 1, label %L1 ]
 L0:
   %x = add i32 %argc, 1
   br label %L1
 L1:
    %y = phi i32 [ %argc, %entry ], [ %x, %L0 ]
    %z = sub i32 %y, 1
   %w = udiv i32 100, %z
   ret i32 %w
 }