#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define LINESIZE 1024

int get_word(const char prompt[], char word[], size_t n);
int is_valid_id(const char s[]);
int get_int(const char prompt[], int *p);
int is_valid_score(const int i);
int get_id(char id[]);
int get_score(int *i);

int main(void) {

    char studentId[10];
    int grade = 0;
    int *gradeP = &grade;
    FILE *fp;

    /*open the file*/
    if ((fp = fopen("lab05.txt", "w")) == 0) {
        perror("fopen");
        return 1;
    }
    
    while(get_id(studentId) && get_score(gradeP)) {    
        
        studentId[0] = 'a';
        fprintf(fp, "%s %3d ", studentId, grade);
        
    }
    
    /*close the file*/
    if (fclose(fp) != 0) {
        perror("fclose");
        return 1;
    }

    return 0;
}

/*
    If a word of length strictly less than n is successfully read from stdin, it is stored in the array word & the function return 1; if the user presses the end-of-file key, the function returns 0 (see details below) 
*/
int get_word(const char prompt[], char word[], size_t n) {
    char line[LINESIZE];
    char temp[LINESIZE];

    while(1) {
        printf("%s", prompt);
        if(!fgets(line, LINESIZE, stdin)) {
            clearerr(stdin);
            return 0;
        }
        if((sscanf(line, "%s", temp) == 1) && (strlen(temp) < n)) {
            strcpy(word, temp);
            return 1;
        }
    }

}

/*
    returns 1 if s is a valid ID; otherwise returns 0 (see details below)
*/
/*check the length
check the first char
check the 1-8*/
int is_valid_id(const char s[]) {
    
    int i = 0;

    if (strlen(s) != 9) {
        return 0;
    }
    
    if (s[0] != 'a' && s[0] != 'A') {
        return 0;
    }
    
    for (i = 1; i < 9; i++) {
        if (!isdigit(s[i])) {
            return 0;
        }
    }
    return 1;
}

/*
if an integer is successfuly read from stdin, it is passed back to the caller via the pointer p & the function returns 1; if the user presses the end-of-file key, the function returns 0
*/
int get_int(const char prompt[], int *p) {
    char line[LINESIZE];
    int tempInt = 0;

    while(1) {
        printf("%s", prompt);
        if(!fgets(line, LINESIZE, stdin)) {
            clearerr(stdin);
            return 0;
        }
        if((sscanf(line, "%d", &tempInt) == 1)) {
            *p = tempInt;
            return 1;
        }
    }
}

/*
returns 1 if score is valid
*/
int is_valid_score(const int i) {
    
    if (i >= 0 && i <= 100) {
        return 1;
    }
    return 0;
}

int get_id(char id[]) {

    while (get_word("Enter the student ID: ", id, 10)) {
        if (is_valid_id(id)) {
            return 1;
        }
    }
    return 0;
}

int get_score(int *i) {
    
    while (get_int("Enter the grades of the student: ", i)) {
        if (is_valid_score(*i)) {
            return 1;
        }
    }
    return 0;
}

/*
The second program opens the file for reading & then repeatedly prompts the user for an integer that specifies the number of the record to display. (use get_int to read this number from the user.)
Records in the file are regarded as numbered, starting from 1. So the first pair of ID & score in the file has recod number 1. If the user enters an invalid record number (e.g., a negative integer or an integer bigger than the record number of the last record), it is simply ignored. The program terminates when the user presses the "end-of-file" key.
You must use a seek operation to jump to the record you want to read. Use a suitable output format when displaying the record
*/


