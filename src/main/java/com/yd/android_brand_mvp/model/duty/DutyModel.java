package com.yd.android_brand_mvp.model.duty;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/model/duty/DutyModel;", "", "dutyType", "", "id", "", "infoList", "", "Lcom/yd/android_brand_mvp/model/duty/DutyInfo;", "week", "students", "Lcom/yd/android_brand_mvp/model/duty/DutyStudent;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getDutyType", "()I", "getId", "()Ljava/lang/String;", "getInfoList", "()Ljava/util/List;", "getStudents", "getWeek", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DutyModel {
    private final int dutyType;
    private final String id;
    private final List<DutyInfo> infoList;
    private final List<DutyStudent> students;
    private final String week;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DutyModel copy$default(DutyModel dutyModel, int i, String str, List list, String str2, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dutyModel.dutyType;
        }
        if ((i2 & 2) != 0) {
            str = dutyModel.id;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            list = dutyModel.infoList;
        }
        List list3 = list;
        if ((i2 & 8) != 0) {
            str2 = dutyModel.week;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            list2 = dutyModel.students;
        }
        return dutyModel.copy(i, str3, list3, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDutyType() {
        return this.dutyType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<DutyInfo> component3() {
        return this.infoList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getWeek() {
        return this.week;
    }

    public final List<DutyStudent> component5() {
        return this.students;
    }

    public final DutyModel copy(int dutyType, String id, List<DutyInfo> infoList, String week, List<DutyStudent> students) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(students, "students");
        return new DutyModel(dutyType, id, infoList, week, students);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyModel)) {
            return false;
        }
        DutyModel dutyModel = (DutyModel) other;
        return this.dutyType == dutyModel.dutyType && Intrinsics.areEqual(this.id, dutyModel.id) && Intrinsics.areEqual(this.infoList, dutyModel.infoList) && Intrinsics.areEqual(this.week, dutyModel.week) && Intrinsics.areEqual(this.students, dutyModel.students);
    }

    public int hashCode() {
        return (((((((this.dutyType * 31) + this.id.hashCode()) * 31) + this.infoList.hashCode()) * 31) + this.week.hashCode()) * 31) + this.students.hashCode();
    }

    public String toString() {
        return "DutyModel(dutyType=" + this.dutyType + ", id=" + this.id + ", infoList=" + this.infoList + ", week=" + this.week + ", students=" + this.students + ')';
    }

    public DutyModel(int i, String id, List<DutyInfo> infoList, String week, List<DutyStudent> students) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(students, "students");
        this.dutyType = i;
        this.id = id;
        this.infoList = infoList;
        this.week = week;
        this.students = students;
    }

    public final int getDutyType() {
        return this.dutyType;
    }

    public final String getId() {
        return this.id;
    }

    public final List<DutyInfo> getInfoList() {
        return this.infoList;
    }

    public final String getWeek() {
        return this.week;
    }

    public final List<DutyStudent> getStudents() {
        return this.students;
    }
}
