#include <stdio.h>

#define LENGTH 4

int main(int argc, char **argv) {

  int a[LENGTH];
  a[1] = 1;
  a[2] = 2;
  a[3] = 3;
  printf("zeroeth element has not been initialised\n");
  for(int i = 0; i < LENGTH; i++)
    printf("%d, ",a[i]);
  printf("\n");

  return 0;
}
