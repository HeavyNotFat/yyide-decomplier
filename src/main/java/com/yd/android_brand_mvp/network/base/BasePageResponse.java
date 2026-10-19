package com.yd.android_brand_mvp.network.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BasePageResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "total", "", "pageNo", "pageSize", TUIKitConstants.Selection.LIST, "(IIILjava/lang/Object;)V", "getList", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPageNo", "()I", "getPageSize", "getTotal", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BasePageResponse<T> {
    private final T list;
    private final int pageNo;
    private final int pageSize;
    private final int total;

    public BasePageResponse() {
        this(0, 0, 0, null, 15, null);
    }

    public BasePageResponse(int i, int i2, int i3, T t) {
        this.total = i;
        this.pageNo = i2;
        this.pageSize = i3;
        this.list = t;
    }

    public /* synthetic */ BasePageResponse(int i, int i2, int i3, Object obj, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? null : obj);
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getPageNo() {
        return this.pageNo;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final T getList() {
        return this.list;
    }
}
