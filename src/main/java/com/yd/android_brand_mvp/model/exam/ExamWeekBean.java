package com.yd.android_brand_mvp.model.exam;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamWeekBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/model/exam/ExamWeekBean;", "", "time", "", "weekIndex", "", "(Ljava/lang/String;I)V", "getTime", "()Ljava/lang/String;", "getWeekIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamWeekBean {
    private final String time;
    private final int weekIndex;

    public ExamWeekBean() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ExamWeekBean copy$default(ExamWeekBean examWeekBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = examWeekBean.time;
        }
        if ((i2 & 2) != 0) {
            i = examWeekBean.weekIndex;
        }
        return examWeekBean.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWeekIndex() {
        return this.weekIndex;
    }

    public final ExamWeekBean copy(String time, int weekIndex) {
        Intrinsics.checkNotNullParameter(time, "time");
        return new ExamWeekBean(time, weekIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamWeekBean)) {
            return false;
        }
        ExamWeekBean examWeekBean = (ExamWeekBean) other;
        return Intrinsics.areEqual(this.time, examWeekBean.time) && this.weekIndex == examWeekBean.weekIndex;
    }

    public int hashCode() {
        return (this.time.hashCode() * 31) + this.weekIndex;
    }

    public String toString() {
        return "ExamWeekBean(time=" + this.time + ", weekIndex=" + this.weekIndex + ')';
    }

    public ExamWeekBean(String time, int i) {
        Intrinsics.checkNotNullParameter(time, "time");
        this.time = time;
        this.weekIndex = i;
    }

    public /* synthetic */ ExamWeekBean(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getTime() {
        return this.time;
    }

    public final int getWeekIndex() {
        return this.weekIndex;
    }
}
