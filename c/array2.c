#include <stdio.h>

int q2(int [], long unsigned int);

int main(int argc, char **argv) {

  int array[] = {22, 99, 11, 99, 33};
  long unsigned int length = sizeof(array)/sizeof(array[0]);
  printf("sizeof(array): %ld\n",sizeof(array));
  printf("sizeof(array[0]): %ld\n",sizeof(array[0]));
  printf("length: %ld\n",length);
  printf("%d\n",q2(array,length));

  return 0;
}

int q2(int array[], long unsigned int length) {
  
  int index = 0;

  for (int i = 0; i < length; i++) {
    if (array[i] < array[index]) index = i;
  }
  return index;
}
