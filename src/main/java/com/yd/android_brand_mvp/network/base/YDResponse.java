package com.yd.android_brand_mvp.network.base;

import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: YDResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/network/base/YDResponse;", "", a.j, "", "(I)V", "getCode", "()I", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class YDResponse {
    private final int code;

    public YDResponse() {
        this(0, 1, null);
    }

    public YDResponse(int i) {
        this.code = i;
    }

    public /* synthetic */ YDResponse(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public final int getCode() {
        return this.code;
    }
}
