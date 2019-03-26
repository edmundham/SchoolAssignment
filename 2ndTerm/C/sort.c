#include "list.h"
#include "sort.h"

static int compareScoreDescNameAscIdAsc(const void *p, const void *q) {
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

static int compareNameAscIdDesc(const void *p, const void *q) {
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
static int compareScoreDescIdAsc(const void *p, const void *q) {
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