#include <stdio.h>
#include <assert.h>

#define CHECK(PRED) printf("%s...%s\n", (PRED) ? "passed" : "FAILED", #PRED)

int arr_min(const int a[], size_t n);
size_t arr_index_of_first_min(const int a[], size_t n);
size_t arr_index_of_last_min(const int a[], size_t n);
size_t arr_count_min(const int a[], size_t n);

int main(void) {
    int a[] = {2, 5, 2, 4, 2, 7};
    CHECK(arr_min(a, 6) == 2);
    CHECK(arr_index_of_first_min(a, 6) == 0);
    CHECK(arr_index_of_last_min(a, 6) == 4);
    CHECK(arr_count_min(a, 6) == 3);

    return 0;
}

/* returns the value of the smallest integer in the integer array a of n elements,
 i.e, returns the minimum value of the array
 precondition: n >= 1 */
int arr_min(const int a[], size_t n) {

    size_t i;
    int min = a[0];

    for (i = 0; i < n; i++) {
        if (a[i] < min) {
            min = a[i];
        }
    }
    return min;
}

/* returns the index of the minimum value in the integer array a of n elements; 
if the minimum value occurs more than once in the array, returns the index of its last occurences
precondition: n >= 1 
restriction: loop through the array at most once*/
size_t arr_index_of_first_min(const int a[], size_t n) {
    size_t i;
    int min = a[0];
    size_t index = 0;

    for (i = 0; i < n; i++) {
        if (a[i] < min) {
            min = a[i];
            index = i;
        }
    }
    return index;
}

/* returns the index of the minimum value in the integer array a of n elements;
if the minimum value occurs more than once in the array, returns the index of its last occurrence
precondition: n >= 1
restriction: loop through the array at most once*/

size_t arr_index_of_last_min(const int a[], size_t n) {
    size_t i;
    int min = a[0];
    size_t index = 0;

    for (i = 0; i < n; i++) {
        if (a[i] <= min) {
            min = a[i];
            index = i;
        }
    }
    return index;
}

/* returns the number of times the minimum value occurs in the integer array a of n elements
precondition: n >= 1
restroction loop through the array at most once
*/
size_t arr_count_min(const int a[], size_t n) {
    size_t i;
    int min = a[0];
    size_t mincount = 0;

    for (i = 0; i < n; i++) {
        if (a[i] == min) {
            mincount++;
        } else if (a[i] < min) {
            mincount = 1;
            min = a[i];
        }
    }
    return mincount;

}