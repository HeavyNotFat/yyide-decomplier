package com.yd.android_brand_mvp.utils;

import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OrderUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/utils/OrderUtils;", "", "()V", "printStudentsInOrder", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;", "personList", "rows", "", "columns", "printStudentsInSShape", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OrderUtils {
    public static final OrderUtils INSTANCE = new OrderUtils();

    private OrderUtils() {
    }

    public final List<ExamPersonSeatBean> printStudentsInSShape(List<ExamPersonSeatBean> personList, int rows, int columns) {
        Intrinsics.checkNotNullParameter(personList, "personList");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < rows; i++) {
            for (int i2 = 0; i2 < columns; i2++) {
                int i3 = i2 % 2 == 0 ? (i2 * rows) + i : (((i2 + 1) * rows) - i) - 1;
                if (i3 < personList.size()) {
                    arrayList.add(personList.get(i3));
                }
            }
        }
        return arrayList;
    }

    public final List<ExamPersonSeatBean> printStudentsInOrder(List<ExamPersonSeatBean> personList, int rows, int columns) {
        Intrinsics.checkNotNullParameter(personList, "personList");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < rows; i++) {
            for (int i2 = 0; i2 < columns; i2++) {
                int i3 = (i2 * rows) + i;
                if (i3 < personList.size()) {
                    arrayList.add(personList.get(i3));
                }
            }
        }
        return arrayList;
    }
}
