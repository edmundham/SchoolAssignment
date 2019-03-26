#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#define IDSIZE 10
#define NAMESIZE 10
#define LINESIZE 1024
#include "record.h"
#include "io.h"

FILE *fp;

int read_record(FILE *fp, record *prec) {

    char line[LINESIZE];
    char tempId[LINESIZE];
    char tempFirst[LINESIZE];
    char tempLast[LINESIZE];
    int tempScore;

    if (!fgets(line, LINESIZE, fp)) {
        printf("do not read\n");
        clearerr(fp);
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

void print_record(FILE *fp, const record *prec) {
    fprintf(fp, "%s : %s, %s : %d\n", prec->id, prec->name.first, prec->name.last, prec->score);
}