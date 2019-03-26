#include <stdio.h>
#include <ctype.h>

// to check
#define CHECK(PRED) printf ("%s...%s\n", (PRED) ? "passed" : "FAILED", #PRED)

// int c;
// while ((c = getchar()) != EOF)
//     putchar(c);

void uppercase_first(void);
void uppercase_last(void);
void squeeze_spaces(void);

int main(void) {

    

    return 0;
}

// uppercase_first basically echoes back what it reads but with the first chararcter of each word printed in uppercase (if it is an alphabet) & the rest of  the cahracters in the word unchaged. Except fot the very first character in the input, we regard a character (that is not a whitespace) as the first character of a word if it immediately follows a whitespace. (note: A whitespace is a character that tests true by the isspace function) Note that if the input begins with an alphabet, that alphabet is displayed in uppercase as well.
void uppercase_first(void) {
    int c;
    while ((c = getchar()) != EOF) {
        if (!isspace(c)) {
            putchar(toupper(c + 1));
        }
    }
}

// uppercase_last is similar to uppercase_first except that the last character of a word is echoed back in uppercase; the rest is unchaged. For simplicity, except for the very last character of the input, we regard a character (that is not a whitespace) as the last character of a word if it is immediately followed by a whitespace. Note that if the input ends with an alphabet, that alphabet is displayed in uppercase as well.
void uppercase_last(void) {
    int c;
    while ((c = getchar()) != EOF) {
        if (!isspace(c)) {
            putchar(toupper(c - 1));
        }
    }
}

// For the squeeze_spaces function, a consecutive sequence of the space characters in the output will result in a single instance of the space character in the output. All other characters are achoed back unchanged.
void squeeze_spaces(void) {
    int c;
    while ((c = getchar()) != EOF) {
        if (!isspace(c) && !isspace(c + 1)) {
            c + 1 = '\0'
        }
    }
}