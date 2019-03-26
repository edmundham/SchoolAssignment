#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#define IDSIZE 10
#define NAMESIZE 10
#define LINESIZE 1024
#define BLOCK 2

typedef struct {
    char last[NAMESIZE];
    char first[NAMESIZE];
} name;

typedef struct {
    char id[IDSIZE];
    name name;
    int score;
} record;

/*
return 0 if value is same
return positive if p should go first
return negative if q should go first
*/

int compareScoreDescNameAscIdAsc(const void *p, const void *q) {
    const record *pp = p;
    const record *qq = q;
    int n = (qq -> score - pp -> score);
    if (n != 0) {
        return n;
    }
    n = strcmp(pp -> name.last, qq -> name.last);
    if (n != 0) {
        return n;
    }
    n = strcmp(pp -> name.first, qq -> name.first);
    if (n != 0) {
        return n;
    }
    return strcmp(pp -> id, qq -> id);
}

int compareNameAscIdDesc(const void *p, const void *q) {
    const record *pp = p;
    const record *qq = q;
    int n = strcmp(pp -> name.last, qq -> name.last);
    if (n != 0) {
        return n;
    }
    n = strcmp(pp -> name.first, qq -> name.first);
    if (n != 0) {
        return n;
    }
    return strcmp(qq -> id, pp -> id);
}

/*descending order for score*/
int compareScoreDescIdAsc(const void *p, const void *q) {
    const record *pp = p;
    const record *qq = q;
    int n = (qq -> score - pp -> score);
    if (n != 0) {
        return n;
    }
    return strcmp(pp -> id, qq -> id);
}

void sort_score_desc_id_asc(record a[], size_t n) {
    qsort(a, n, sizeof(a[0]), compareScoreDescIdAsc);
}

void sort_name_asc_id_desc(record a[], size_t n) {
    qsort(a, n, sizeof(a[0]), compareNameAscIdDesc);
}

void sort_score_desc_name_asc_id_asc(record a[], size_t n) {
    qsort(a, n, sizeof(a[0]), compareScoreDescNameAscIdAsc);
}

/*
straight copy from lab 7 with slight modification
*/
int read_record(record prec[], size_t n) {

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
        
        strcpy(prec[n].id, tempId);
        strcpy(prec[n].name.first, tempFirst);
        strcpy(prec[n].name.last, tempLast);
        prec[n].score = tempScore;
        return 1;
    }
}

void print_record(const record *prec) {
    printf("%s : %s, %s : %d\n", prec->id, prec->name.first, prec->name.last, prec->score);
}

int main(int argc, char *argv[]) {
    int i;
    record r[100];

    for (i = 0; i < 100; i++) {
        if (read_record(r, i) != 1) {
            printf("function error\n");
            return 1;
        }
    }

    if (argc == 2) {
        if (strcmp(argv[1], "s-i+") == 0) {
            sort_score_desc_id_asc(r, 100);
        } else if (strcmp(argv[1], "n+i-") == 0) {
            sort_name_asc_id_desc(r, 100);
        } else if (strcmp(argv[1], "s-n+i+") == 0) {
            sort_score_desc_name_asc_id_asc(r, 100);
        } else {
            printf("argument error\n");
            return 3;
        }
    } else {
        printf("argument error\n");
        return 2;
    }

    for (i = 0; i < 100; i++) {
        print_record(&r);
    }
    
return 0;
}
