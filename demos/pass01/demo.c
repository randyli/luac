#include <stdio.h>
int test(int a, int b) {
    a = xxx
    if(a > b) {
        return a - b;
    }
    return b - a;
}

int main() {
  printf("|a-b|=%d\n", test(4, 5));
  return 0;
}
