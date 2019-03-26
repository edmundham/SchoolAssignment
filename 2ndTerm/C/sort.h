#ifndef SORT_H
#define SORT_H

static int compareScoreDescNameAscIdAsc(const void *p, const void *q);
static int compareNameAscIdDesc(const void *p, const void *q);
static int compareScoreDescIdAsc(const void *p, const void *q);
void sort_score_desc_id_asc(record a[], size_t n);
void sort_name_asc_id_desc(record a[], size_t n);
void sort_score_desc_name_asc_id_asc(record a[], size_t n);

#endif