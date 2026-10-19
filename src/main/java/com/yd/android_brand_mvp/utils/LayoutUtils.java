package com.yd.android_brand_mvp.utils;

import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/utils/LayoutUtils;", "", "()V", "getLayoutCustomData", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$DataBean$LayoutClassSignDetailsEntityListBean;", RemoteMessageConst.Notification.TAG, "", "isLayoutExist", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutUtils {
    public static final LayoutUtils INSTANCE = new LayoutUtils();

    private LayoutUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    public final boolean isLayoutExist(String tag) {
        boolean z;
        Intrinsics.checkNotNullParameter(tag, "tag");
        List<LayoutListRsp.DataBean> list = SpData.HomeIndexData().data;
        if (list == null) {
            return false;
        }
        List<LayoutListRsp.DataBean> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            List<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> layoutClassSignDetailsEntityList = ((LayoutListRsp.DataBean) it2.next()).layoutClassSignDetailsEntityList;
            if (layoutClassSignDetailsEntityList == null) {
                z = false;
                break;
                break;
            }
            Intrinsics.checkNotNullExpressionValue(layoutClassSignDetailsEntityList, "layoutClassSignDetailsEntityList");
            List<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> list3 = layoutClassSignDetailsEntityList;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it3 = list3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = false;
                        break;
                    }
                    if (Intrinsics.areEqual(((LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean) it3.next()).tag, tag)) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
                break;
                break;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean getLayoutCustomData(String tag) {
        LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean layoutClassSignDetailsEntityListBean;
        Object next;
        Intrinsics.checkNotNullParameter(tag, "tag");
        LayoutListRsp layoutListRspHomeIndexData = SpData.HomeIndexData();
        Log.i("HomeIndexData", "getLayoutCustomData：" + GsonUtils.toJson(layoutListRspHomeIndexData));
        List<LayoutListRsp.DataBean> list = layoutListRspHomeIndexData.data;
        if (list == null) {
            return null;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            List<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> layoutClassSignDetailsEntityList = ((LayoutListRsp.DataBean) it2.next()).layoutClassSignDetailsEntityList;
            if (layoutClassSignDetailsEntityList != null) {
                Intrinsics.checkNotNullExpressionValue(layoutClassSignDetailsEntityList, "layoutClassSignDetailsEntityList");
                Iterator<T> it3 = layoutClassSignDetailsEntityList.iterator();
                do {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                } while (!Intrinsics.areEqual(((LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean) next).tag, tag));
                layoutClassSignDetailsEntityListBean = (LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean) next;
            } else {
                layoutClassSignDetailsEntityListBean = null;
            }
            if (layoutClassSignDetailsEntityListBean != null) {
                return layoutClassSignDetailsEntityListBean;
            }
        }
        return null;
    }
}
