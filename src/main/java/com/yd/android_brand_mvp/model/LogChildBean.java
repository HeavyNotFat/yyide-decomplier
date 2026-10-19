package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/LogChildBean;", "", "time", "", "module", "traceId", "operation_content", "operation_status", "logLevel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLogLevel", "()Ljava/lang/String;", "getModule", "getOperation_content", "getOperation_status", "getTime", "getTraceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogChildBean {
    private final String logLevel;
    private final String module;
    private final String operation_content;
    private final String operation_status;
    private final String time;
    private final String traceId;

    public static /* synthetic */ LogChildBean copy$default(LogChildBean logChildBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logChildBean.time;
        }
        if ((i & 2) != 0) {
            str2 = logChildBean.module;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = logChildBean.traceId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = logChildBean.operation_content;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = logChildBean.operation_status;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = logChildBean.logLevel;
        }
        return logChildBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOperation_content() {
        return this.operation_content;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOperation_status() {
        return this.operation_status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLogLevel() {
        return this.logLevel;
    }

    public final LogChildBean copy(String time, String module, String traceId, String operation_content, String operation_status, String logLevel) {
        return new LogChildBean(time, module, traceId, operation_content, operation_status, logLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogChildBean)) {
            return false;
        }
        LogChildBean logChildBean = (LogChildBean) other;
        return Intrinsics.areEqual(this.time, logChildBean.time) && Intrinsics.areEqual(this.module, logChildBean.module) && Intrinsics.areEqual(this.traceId, logChildBean.traceId) && Intrinsics.areEqual(this.operation_content, logChildBean.operation_content) && Intrinsics.areEqual(this.operation_status, logChildBean.operation_status) && Intrinsics.areEqual(this.logLevel, logChildBean.logLevel);
    }

    public int hashCode() {
        String str = this.time;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.module;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.traceId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.operation_content;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.operation_status;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.logLevel;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "LogChildBean(time=" + this.time + ", module=" + this.module + ", traceId=" + this.traceId + ", operation_content=" + this.operation_content + ", operation_status=" + this.operation_status + ", logLevel=" + this.logLevel + ')';
    }

    public LogChildBean(String str, String str2, String str3, String str4, String str5, String str6) {
        this.time = str;
        this.module = str2;
        this.traceId = str3;
        this.operation_content = str4;
        this.operation_status = str5;
        this.logLevel = str6;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getOperation_content() {
        return this.operation_content;
    }

    public final String getOperation_status() {
        return this.operation_status;
    }

    public final String getLogLevel() {
        return this.logLevel;
    }
}
