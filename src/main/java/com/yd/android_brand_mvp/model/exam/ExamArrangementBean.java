package com.yd.android_brand_mvp.model.exam;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamArrangementBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/model/exam/ExamArrangementBean;", "", "dateTime", "", "examPlan", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "weekDay", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getDateTime", "()Ljava/lang/String;", "getExamPlan", "()Ljava/util/List;", "getWeekDay", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamArrangementBean {
    private final String dateTime;
    private final List<ExamPlanItem> examPlan;
    private final int weekDay;

    public ExamArrangementBean() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamArrangementBean copy$default(ExamArrangementBean examArrangementBean, String str, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = examArrangementBean.dateTime;
        }
        if ((i2 & 2) != 0) {
            list = examArrangementBean.examPlan;
        }
        if ((i2 & 4) != 0) {
            i = examArrangementBean.weekDay;
        }
        return examArrangementBean.copy(str, list, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDateTime() {
        return this.dateTime;
    }

    public final List<ExamPlanItem> component2() {
        return this.examPlan;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWeekDay() {
        return this.weekDay;
    }

    public final ExamArrangementBean copy(String dateTime, List<ExamPlanItem> examPlan, int weekDay) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        Intrinsics.checkNotNullParameter(examPlan, "examPlan");
        return new ExamArrangementBean(dateTime, examPlan, weekDay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamArrangementBean)) {
            return false;
        }
        ExamArrangementBean examArrangementBean = (ExamArrangementBean) other;
        return Intrinsics.areEqual(this.dateTime, examArrangementBean.dateTime) && Intrinsics.areEqual(this.examPlan, examArrangementBean.examPlan) && this.weekDay == examArrangementBean.weekDay;
    }

    public int hashCode() {
        return (((this.dateTime.hashCode() * 31) + this.examPlan.hashCode()) * 31) + this.weekDay;
    }

    public String toString() {
        return "ExamArrangementBean(dateTime=" + this.dateTime + ", examPlan=" + this.examPlan + ", weekDay=" + this.weekDay + ')';
    }

    public ExamArrangementBean(String dateTime, List<ExamPlanItem> examPlan, int i) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        Intrinsics.checkNotNullParameter(examPlan, "examPlan");
        this.dateTime = dateTime;
        this.examPlan = examPlan;
        this.weekDay = i;
    }

    public final String getDateTime() {
        return this.dateTime;
    }

    public /* synthetic */ ExamArrangementBean(String str, ArrayList arrayList, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new ArrayList() : arrayList, (i2 & 4) != 0 ? 0 : i);
    }

    public final List<ExamPlanItem> getExamPlan() {
        return this.examPlan;
    }

    public final int getWeekDay() {
        return this.weekDay;
    }
}
