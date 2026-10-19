package com.yd.android_brand_mvp.model.duty;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/duty/DutyInfo;", "", "beginTime", "", "endTime", "students", "", "Lcom/yd/android_brand_mvp/model/duty/DutyStudent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBeginTime", "()Ljava/lang/String;", "getEndTime", "getStudents", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DutyInfo {
    private final String beginTime;
    private final String endTime;
    private final List<DutyStudent> students;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DutyInfo copy$default(DutyInfo dutyInfo, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dutyInfo.beginTime;
        }
        if ((i & 2) != 0) {
            str2 = dutyInfo.endTime;
        }
        if ((i & 4) != 0) {
            list = dutyInfo.students;
        }
        return dutyInfo.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBeginTime() {
        return this.beginTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    public final List<DutyStudent> component3() {
        return this.students;
    }

    public final DutyInfo copy(String beginTime, String endTime, List<DutyStudent> students) {
        Intrinsics.checkNotNullParameter(beginTime, "beginTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(students, "students");
        return new DutyInfo(beginTime, endTime, students);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyInfo)) {
            return false;
        }
        DutyInfo dutyInfo = (DutyInfo) other;
        return Intrinsics.areEqual(this.beginTime, dutyInfo.beginTime) && Intrinsics.areEqual(this.endTime, dutyInfo.endTime) && Intrinsics.areEqual(this.students, dutyInfo.students);
    }

    public int hashCode() {
        return (((this.beginTime.hashCode() * 31) + this.endTime.hashCode()) * 31) + this.students.hashCode();
    }

    public String toString() {
        return "DutyInfo(beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", students=" + this.students + ')';
    }

    public DutyInfo(String beginTime, String endTime, List<DutyStudent> students) {
        Intrinsics.checkNotNullParameter(beginTime, "beginTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(students, "students");
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.students = students;
    }

    public final String getBeginTime() {
        return this.beginTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final List<DutyStudent> getStudents() {
        return this.students;
    }
}
