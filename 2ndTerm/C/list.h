#ifndef LIST_H
#define LIST_H

void list_init(record_list *plist);
void list_destroy(record_list *plist);
int list_insert(record_list *plist, const record *prec);

#endif