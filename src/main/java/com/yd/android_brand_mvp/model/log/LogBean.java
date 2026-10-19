package com.yd.android_brand_mvp.model.log;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/model/log/LogBean;", "", "model", "", "isSuccess", "", "message", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getModel", "setModel", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/yd/android_brand_mvp/model/log/LogBean;", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogBean {
    private Boolean isSuccess;
    private String message;
    private String model;

    public LogBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LogBean copy$default(LogBean logBean, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logBean.model;
        }
        if ((i & 2) != 0) {
            bool = logBean.isSuccess;
        }
        if ((i & 4) != 0) {
            str2 = logBean.message;
        }
        return logBean.copy(str, bool, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final LogBean copy(String model, Boolean isSuccess, String message) {
        return new LogBean(model, isSuccess, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogBean)) {
            return false;
        }
        LogBean logBean = (LogBean) other;
        return Intrinsics.areEqual(this.model, logBean.model) && Intrinsics.areEqual(this.isSuccess, logBean.isSuccess) && Intrinsics.areEqual(this.message, logBean.message);
    }

    public int hashCode() {
        String str = this.model;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isSuccess;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.message;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LogBean(model=" + this.model + ", isSuccess=" + this.isSuccess + ", message=" + this.message + ')';
    }

    public LogBean(String str, Boolean bool, String str2) {
        this.model = str;
        this.isSuccess = bool;
        this.message = str2;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public /* synthetic */ LogBean(String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? "" : str2);
    }

    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
