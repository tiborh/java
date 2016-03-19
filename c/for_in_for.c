#include <stdio.h>

int main(int argc, char **argv) {
  int i = 0;
  int j = 0;

  for (i = 0; i < 3; i++) {
    for (j = 0; j < 3; j++) {
      if (j == 1) break;
    }
  }

  printf("i: %d, j: %d\n",i,j);

  return 0;
}
