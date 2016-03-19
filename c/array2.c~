#include <stdio.h>

void init_array();
void print_array();

int main(int argc, char **argv) {
  //char an_array[] = {'春','夏','秋','冬'};
  int an_array[] = {0,1,2,3};
  int another_array[10];
  long unsigned int another_array_length = sizeof(another_array)/sizeof(another_array[0]);

  printf("size of array: %ld\n",sizeof(an_array));
  printf("size of array/size of first element: %ld\n",sizeof(an_array)/sizeof(an_array[0]));
  printf("size of array: %ld\n",sizeof(another_array));
  printf("size of array/size of first element: %ld\n",another_array_length);

  printf("Before initialisation:\n");
  print_array(another_array,another_array_length);
  init_array(another_array,another_array_length);
  printf("After initialisation:\n");
  print_array(another_array,another_array_length);

  return 0;
}

void init_array(int *in_array, long unsigned int array_length) {

  for(long unsigned int i=0; i<array_length; i++)
    in_array[i] = 0;

  return;
}

void print_array(int *in_array, long unsigned int array_length) {

  for(long unsigned int i=0; i<array_length; i++)
    printf("[%ld]: %d\n",i,in_array[i]);

  return;
}
