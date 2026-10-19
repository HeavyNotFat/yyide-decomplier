package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemesterTimeRsp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/model/SemesterTimeRsp;", "", "endDate", "", "id", AppMeasurementSdk.ConditionalUserProperty.NAME, "startDate", "yearName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndDate", "()Ljava/lang/String;", "setEndDate", "(Ljava/lang/String;)V", "getId", "setId", "getName", "setName", "getStartDate", "setStartDate", "getYearName", "setYearName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SemesterTimeRsp {
    private String endDate;
    private String id;
    private String name;
    private String startDate;
    private String yearName;

    public static /* synthetic */ SemesterTimeRsp copy$default(SemesterTimeRsp semesterTimeRsp, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = semesterTimeRsp.endDate;
        }
        if ((i & 2) != 0) {
            str2 = semesterTimeRsp.id;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = semesterTimeRsp.name;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = semesterTimeRsp.startDate;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = semesterTimeRsp.yearName;
        }
        return semesterTimeRsp.copy(str, str6, str7, str8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getYearName() {
        return this.yearName;
    }

    public final SemesterTimeRsp copy(@JSONField(name = "endDate") String endDate, @JSONField(name = "id") String id, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "startDate") String startDate, @JSONField(name = "yearName") String yearName) {
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(yearName, "yearName");
        return new SemesterTimeRsp(endDate, id, name, startDate, yearName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemesterTimeRsp)) {
            return false;
        }
        SemesterTimeRsp semesterTimeRsp = (SemesterTimeRsp) other;
        return Intrinsics.areEqual(this.endDate, semesterTimeRsp.endDate) && Intrinsics.areEqual(this.id, semesterTimeRsp.id) && Intrinsics.areEqual(this.name, semesterTimeRsp.name) && Intrinsics.areEqual(this.startDate, semesterTimeRsp.startDate) && Intrinsics.areEqual(this.yearName, semesterTimeRsp.yearName);
    }

    public int hashCode() {
        return (((((((this.endDate.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.yearName.hashCode();
    }

    public String toString() {
        return "SemesterTimeRsp(endDate=" + this.endDate + ", id=" + this.id + ", name=" + this.name + ", startDate=" + this.startDate + ", yearName=" + this.yearName + ')';
    }

    public SemesterTimeRsp(@JSONField(name = "endDate") String endDate, @JSONField(name = "id") String id, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "startDate") String startDate, @JSONField(name = "yearName") String yearName) {
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(yearName, "yearName");
        this.endDate = endDate;
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.yearName = yearName;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final void setEndDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endDate = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final void setStartDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startDate = str;
    }

    public final String getYearName() {
        return this.yearName;
    }

    public final void setYearName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.yearName = str;
    }
}
