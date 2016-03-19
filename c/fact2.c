#include <stdio.h>

void print_results(int,int);
long long fact2(int,int);

int main(int argc, char **argv) {

  int n1,n2;
  n1 = 3, n2 = 5;
  print_results(n1,n2);
  n1 = 4, n2 = 2;
  print_results(n1,n2);
  n1 = -2, n2 = 2;
  print_results(n1,n2);

  return 0;
}

void print_results(int n1, int n2) {
  printf("%d %d = %lld\n",n1,n2,fact2(n1,n2));
  return;
}

long long fact2(int n1, int n2) {
  unsigned long long int t = 1; // initialize t to 1       
  for (int counter = n1; counter <= n2; counter++) {
    t = t * counter;
  }
  return t;
}
