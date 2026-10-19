package com.yd.android_brand_mvp.model.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/model/log/InParam;", "", "json", "", "(Ljava/lang/String;)V", "getJson", "()Ljava/lang/String;", "setJson", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InParam {
    private String json;

    public static /* synthetic */ InParam copy$default(InParam inParam, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inParam.json;
        }
        return inParam.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getJson() {
        return this.json;
    }

    public final InParam copy(String json) {
        return new InParam(json);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InParam) && Intrinsics.areEqual(this.json, ((InParam) other).json);
    }

    public int hashCode() {
        String str = this.json;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "InParam(json=" + this.json + ')';
    }

    public InParam(String str) {
        this.json = str;
    }

    public final String getJson() {
        return this.json;
    }

    public final void setJson(String str) {
        this.json = str;
    }
}
