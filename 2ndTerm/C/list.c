#include "io.h"
#include "list.h"

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