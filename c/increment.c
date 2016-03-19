#include <stdio.h>

int main(int argc, char **argv) {

  int a = 6;
  int b = 42;
  int result1 = b / ++a;
  int result2 = b / a++;

  printf("result1: %d, result2: %d\n",result1,result2);

  return 0;
}
