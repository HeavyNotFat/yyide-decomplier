package com.yd.android_brand_mvp.utils;

import com.yd.android_brand_mvp.model.TableRsp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SortList {
    public static List<TableRsp> listSorting2(List<TableRsp> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator() { // from class: com.yd.android_brand_mvp.utils.-$$Lambda$SortList$xDHeIvJisWicFhP0wVXrupScdFw
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Integer.compare(((TableRsp) obj).seletion, ((TableRsp) obj2).seletion);
                }
            });
        }
        return list;
    }
}
