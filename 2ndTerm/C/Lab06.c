#include <stdio.h>

/* pre-condition: n >= 1 */
void min_max(const int a[], size_t n, int *pmin, int *pmax) {
	size_t i;
	*pmin = a[0];
	*pmax = a[0];
	
	for (i = 0; i < n; i++) {
		if (*pmin < a[i]) {
			*pmin = a[i];
		}
		if (*pmax > a[i]) {
			*pmax = a[i];
		}
	}
	
}

unsigned num_digits(unsigned long n) {
	unsigned counter = 0;
	unsigned divide = 1;
	do {
		divide *= 10;
		counter++;
	} while (n / divide != 0);
	return counter;
}

/* pre-condition: n % 10 != 0 */
unsigned long reverse(unsigned long n) {
	unsigned tempVal = 0;
	unsigned returnVal = 0;
	while(n != 0) {
		tempVal = n % 10;
		n = n / 10;
		returnVal = returnVal * 10 + tempVal;
	}
	return returnVal;
}

int main(void) {
	int a[] = {3, 4, 3, 4, 1, 5, 6, 5, 6};
	size_t n = 9;
	int pmin = 0;
	int pmax = 0;
	unsigned long random1 = 42153;
	unsigned long random2 = 987654321;
	unsigned long random3 = 12345;
	
	min_max(a, n, &pmin, &pmax);
	printf("%d %d\n", pmin, pmax);

	printf("%d %d\n", num_digits(0), num_digits(random2));
	
	printf("%d", reverse(random3));
	
	
	
	return 0;
}