#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {

  if (argc < 3) {
    printf("Usage: %s <base> <power>\n",argv[0]);
    exit(1);
  }

  unsigned long long product = 1;
  int counter = 1;
  int base = atoi(argv[1]);
  int power = atoi(argv[2]);

  if (power < 0) {
    printf("Less than zero power value is not implemented.\n");
    exit(1);
  }

  if (power != 0) {
    do {
      product *= base;
      counter += 1;
    } while (counter <= power);
  }

  if ((base != 0 && product == 0) || (base > 0 && product < 0)) {
    printf("the product is too large to store\n");
    exit(2);
  }
  printf("%d on the power of %d is %lld\n",base,power,product);

  return 0;
}
