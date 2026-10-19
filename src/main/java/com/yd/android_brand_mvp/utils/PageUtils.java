package com.yd.android_brand_mvp.utils;

import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.model.active.ActiveEnrollSubBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PageUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/utils/PageUtils;", "", "()V", "doCalculatePageNumber", "", InnerConstant.Db.size, "total", "(ILjava/lang/Integer;)I", "splitList", "", "Lcom/yd/android_brand_mvp/model/active/ActiveEnrollSubBean;", TUIKitConstants.Selection.LIST, "groupSize", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PageUtils {
    public static final PageUtils INSTANCE = new PageUtils();

    private PageUtils() {
    }

    public final int doCalculatePageNumber(int size, Integer total) {
        if (total == null) {
            return 0;
        }
        int iIntValue = total.intValue() / size;
        return total.intValue() % size != 0 ? iIntValue + 1 : iIntValue;
    }

    public final List<List<ActiveEnrollSubBean>> splitList(List<ActiveEnrollSubBean> list, int groupSize) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = ((size + groupSize) - 1) / groupSize;
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 * groupSize;
            i2++;
            arrayList.add(list.subList(i3, RangesKt.coerceAtMost(i2 * groupSize, size)));
        }
        return arrayList;
    }
}
