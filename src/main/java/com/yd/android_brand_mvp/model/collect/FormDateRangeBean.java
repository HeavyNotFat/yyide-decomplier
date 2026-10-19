package com.yd.android_brand_mvp.model.collect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormDateRangeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/FormDateRangeBean;", "", "startTime", "", "endTime", "timeLength", "unit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "getStartTime", "getTimeLength", "getUnit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormDateRangeBean {
    private final String endTime;
    private final String startTime;
    private final String timeLength;
    private final String unit;

    public FormDateRangeBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FormDateRangeBean copy$default(FormDateRangeBean formDateRangeBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formDateRangeBean.startTime;
        }
        if ((i & 2) != 0) {
            str2 = formDateRangeBean.endTime;
        }
        if ((i & 4) != 0) {
            str3 = formDateRangeBean.timeLength;
        }
        if ((i & 8) != 0) {
            str4 = formDateRangeBean.unit;
        }
        return formDateRangeBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTimeLength() {
        return this.timeLength;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    public final FormDateRangeBean copy(String startTime, String endTime, String timeLength, String unit) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(timeLength, "timeLength");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new FormDateRangeBean(startTime, endTime, timeLength, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormDateRangeBean)) {
            return false;
        }
        FormDateRangeBean formDateRangeBean = (FormDateRangeBean) other;
        return Intrinsics.areEqual(this.startTime, formDateRangeBean.startTime) && Intrinsics.areEqual(this.endTime, formDateRangeBean.endTime) && Intrinsics.areEqual(this.timeLength, formDateRangeBean.timeLength) && Intrinsics.areEqual(this.unit, formDateRangeBean.unit);
    }

    public int hashCode() {
        return (((((this.startTime.hashCode() * 31) + this.endTime.hashCode()) * 31) + this.timeLength.hashCode()) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "FormDateRangeBean(startTime=" + this.startTime + ", endTime=" + this.endTime + ", timeLength=" + this.timeLength + ", unit=" + this.unit + ')';
    }

    public FormDateRangeBean(String startTime, String endTime, String timeLength, String unit) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(timeLength, "timeLength");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeLength = timeLength;
        this.unit = unit;
    }

    public /* synthetic */ FormDateRangeBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "天" : str4);
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getTimeLength() {
        return this.timeLength;
    }

    public final String getUnit() {
        return this.unit;
    }
}
