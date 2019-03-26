#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define IDSIZE 10
#define NAMESIZE 20
#define LINESIZE 256

typedef struct {
    char last[NAMESIZE]; /*last name (1 word), eg, "simpson"*/
    char first[NAMESIZE]; /*first name (1 word), eg, "homer"*/
} name;

typedef struct {
    char id[IDSIZE]; /*ID ('a' followed by 8 digits), eg, "A12345678"*/
    name name; /*name (as defined above)*/
    int score; /*score (between 0 and 100 inclusive), eg, 25*/
} record;

int read_record(record *prec) {

    char line[LINESIZE];
    char tempId[LINESIZE];
    char tempFirst[LINESIZE];
    char tempLast[LINESIZE];
    int tempScore;

    printf("Enter id, firstname, lastname, score with spaces between: \n");
    if (!fgets(line, LINESIZE, stdin)) {
        printf("do not read\n");
        clearerr(stdin);
        return 0;
    }
    if ((sscanf(line, "%s %s %s %d", tempId, tempFirst, tempLast, &tempScore)) >= 4) {
        int i;
        /*length validation*/
        if (strlen(tempId) != 9 || strlen(tempFirst) >= 20 || strlen(tempLast) >= 20) {
          printf("invalid length\n");
          return -1;
        } 
        /*score validation*/
        if (!(0 <= tempScore) || !(tempScore <= 100)) {
            printf("invalid score\n");
            return -1;
        }
        /*id validation*/
        if (tempId[0] != 'a' && tempId[0] != 'A') {
            printf("invalid id\n");
            return -1;
        }
        for (i = 1; i < strlen(tempId); i++) {
            if (!isdigit(tempId[i])) {
                printf("invalid id\n");
                return -1;
            }
        }
        /*change to lower case firstname*/
        for(int i = 0; i < strlen(tempFirst); i++){
            tempFirst[i] = tolower(tempFirst[i]);
        }
        /*change to lower case firstname*/
        for(int i = 0; i < strlen(tempLast); i++){
            tempLast[i] = tolower(tempLast[i]);
        }
        
        strcpy(prec->id, tempId);
        strcpy(prec->name.first, tempFirst);
        strcpy(prec->name.last, tempLast);
        prec->score = tempScore;
        return 1;
    }
}

void print_record(const record *prec) {
    printf("%s : %s, %s : %d\n", prec->id, prec->name.first, prec->name.last, prec->score);
}

int main(void) {
    
    record r;
    if (read_record(&r) != 1) {
        printf("function error\n");
        return 1;
    }

    print_record(&r);

    return 0;
}
