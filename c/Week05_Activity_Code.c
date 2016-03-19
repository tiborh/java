#include <stdio.h>

#define NUMBER_OF_FLOORS 8

void print_building();
void print_floor(int);

int main(int argc, char **argv) {
  print_building();
  return 0;
}

void print_building() {
  for(int i=0;i<6;i++)
    printf(" ");
  for(int i=0;i<19;i++)
    printf("_");
  printf("\n");

  int current_floor = NUMBER_OF_FLOORS;
  do {
    if (current_floor > NUMBER_OF_FLOORS/2 - 1)
      print_floor(current_floor + 1);
    else
      print_floor(current_floor);
    current_floor--;
  } while (current_floor > 0);

  return;
}

/* void print_floor(int floor) { */
/*   printf("%d\n",floor); */
/*   return; */
/* } */

void print_floor(int floor) {
  printf("%d/F  ",floor);
  char *symbol = "_";

  // divisible by 2 and 3 => @
  // divisible only by 3 => ?
  // divisible only by 2 => $
  if (floor % 2 == 0 && floor % 3 == 0)
    symbol = "@";
  if (floor % 3 == 0)
    symbol = "?";
  if (floor % 2 == 0)
    symbol = "$";

  for (int i = 0; i < 5; i++) {
    printf("|_%s_",symbol);
  }

  printf("|\n");
  return;
}
