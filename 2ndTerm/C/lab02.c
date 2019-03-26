#include <stdio.h>
// to use strcmp()
#include <string.h>
// to use isalpha()
#include <ctype.h>

// to check
#define CHECK(PRED) printf ("%s...%s\n", (PRED) ? "passed" : "FAILED", #PRED)

size_t str_find_last(const char s[], int c);
size_t str_replace_all(char s[], int oldc, int newc);
int str_all_alphas(const char s[]);
int str_equal(const char s[], const char t[]);

int main(void) {
    char bcit[] = "British Columbia Institute of Technology";
    char ubc[] = "University of British Columbia";
    char onlyAlpha[] = "IAmAlphabetString";

    // y is the last index of the string
    CHECK(str_find_last(bcit, 'y') == 39);
    // U is the first index of the string
    CHECK(str_find_last(ubc, 'U') == 0);
    // the string doesn't contain Z
    CHECK(str_find_last(onlyAlpha, 'Z') == -1);

    // change i to a
    CHECK(str_replace_all(bcit, 'i', 'a') == 4);
    // change o to b
    CHECK(str_replace_all(ubc, 'o', 'b') == 2);
    // change Z to c, but string doesn't contain Z
    CHECK(str_replace_all(onlyAlpha, 'Z', 'c') == 0);

    // have spaces
    CHECK(str_all_alphas(bcit) == 0);
    // have spaces
    CHECK(str_all_alphas(ubc) == 0);
    // should be same
    CHECK(str_all_alphas(onlyAlpha) == 1);

    // same, so should be 1
    CHECK(str_equal(bcit, "Bratash Columbaa Instatute of Technology") == 1);
    // different, so should be 0
    CHECK(str_equal(ubc, "University bf British Cblumbi") == 0);
    // different, so should be 0
    CHECK(str_equal(onlyAlpha, "IAmAlphabetStrcng") == 0);

    /**
     * TO CHECK MY str_equal function WORKS PROPERLY
     */

    // same, so should be 0
    CHECK(strcmp(bcit, "Bratash Columbaa Instatute of Technology") == 0);
    // same, so should be 0
    CHECK(strcmp(ubc, "University bf British Cblumbia") == 0);
    // different, so should not be 0
    CHECK(strcmp(onlyAlpha, "IAmAlphabetStrcng") != 0);

    return 0;
}

// returns the index of the last occurrences of the character (specified by) c in the string s, 
// or returns -1 if the string does not contain c
size_t str_find_last(const char s[], int c) {

    size_t i;
    size_t indexOfLast = -1;

    for (i = 0; s[i] != '\0'; i++) {
        if(s[i] == c) {
            indexOfLast = i;
        }
    }

    return indexOfLast;

}

// replaces all occurrences of the character oldc in the string s by the character newc
// returns the number of replacements
size_t str_replace_all(char s[], int oldc, int newc) {

    size_t i;
    size_t counter = 0;

    for (i = 0; s[i] != '\0'; i++) {
        if (s[i] == oldc) {
            s[i] = newc;
            counter++;
        }
    }

    return counter;

}

// returns 1 if the string s consists only of alphabets; otherwise, returns 0;
int str_all_alphas(const char s[]) {

    int i;

    for(i = 0; s[i] != '\0'; i++) {
        if (!isalpha(s[i])) {
            return 0;
        }
    }

    return 1;

}

// returns 1 if the strings s & t have the same sequence of characters; otherwise, 
// returns 0
int str_equal(const char s[], const char t[]) {

    int i;

    for (i = 0; (s[i] != '\0') || (t[i] != '\0'); i++) {
        if (s[i] != t[i]) {
            return 0;
        }
    }

    return 1;

}