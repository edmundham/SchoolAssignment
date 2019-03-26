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

typedef struct node node;
struct node {
    record data;
    node *next;
};
typedef node *record_list;

void list_init(record_list *list) {
    *list = NULL;
}

void list_destroy(record_list *list) {
    node *p, *q;
    for (p = *list; p != 0; p = q) {
        q = p -> next;
        free(p);
    }
    *list = NULL;
}

int list_insert(record_list *list, const record *rec) {
    node *temp = malloc(sizeof(node));
    if (temp == 0) {
        return 0;
    }
    temp -> data = *rec;
    temp -> next = *list;
    *list = temp;
    return 1; 
}

int read_record(record prec[], size_t n) {

    char line[LINESIZE];
    char tempId[LINESIZE];
    char tempFirst[LINESIZE];
    char tempLast[LINESIZE];
    int tempScore;
    size_t i;

    printf("Enter id, firstname, lastname, score with spaces between: \n");
    if (!fgets(line, LINESIZE, stdin)) {
        printf("do not read\n");
        clearerr(stdin);
        return 0;
    }
    if ((sscanf(line, "%s %s %s %d", tempId, tempFirst, tempLast, &tempScore)) >= 4) {
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
        for(i = 0; i < strlen(tempFirst); i++){
            tempFirst[i] = tolower(tempFirst[i]);
        }
        /*change to lower case firstname*/
        for(i = 0; i < strlen(tempLast); i++){
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

int main(void) {

    int i;
    record r[100];
    record_list recordList; 
    list_init(&recordList);
    for (i = 0; i < 100; i++) {
        if (read_record(r, i) != 1) {
            printf("function error\n");
            return 1;
        }
        list_insert(&recordList, r);
    }



    for (i = 0; i < 100; i++) {
        print_record(&r);
    }

return 0;
}
