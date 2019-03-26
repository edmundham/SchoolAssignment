#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#define IDSIZE 10
#define NAMESIZE 10
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

typedef struct record_list record_list;
struct record_list {
    record *data;
    size_t nalloc;
    size_t nused;
};

void list_init(record_list *plist) {
    plist -> nalloc = 0;
    plist -> nused = 0;
    plist -> data = 0;
}

void list_destroy(record_list *plist) {
    free(plist->data);
    list_init(&plist);
}

int list_insert(record_list *plist, const record *prec) {
    if (plist->nused == plist->nalloc) {
        record *temp = realloc(plist->data, (plist->nalloc + BLOCK) * sizeof(record));
        if (temp == 0) {
            fprintf(stderr, "fail");
            return 0;
        }
        plist->data = temp;
        plist->nalloc += BLOCK;
    }
    plist->data[plist->nused] = *prec;
    plist->nused++;
    return 1;
}

int main(void) {

    record rec;
    record_list list;
    strcpy(rec.id, "a00979841");
    strcpy(rec.name.first, "Homer");
    strcpy(rec.name.last, "Simpson");
    rec.score = 100;
    
    list_init(&list);
    list_insert(&list, &rec);
    
    printf("%s %s %s %d", list.data[0].id, list.data[0].name.first, list.data[0].name.last, list.data[0].score);
    

return 0;
}