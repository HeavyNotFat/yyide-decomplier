package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteAttendanceBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/SiteAttendanceBean;", "", "icCardNo", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "personId", "timetableId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcCardNo", "()Ljava/lang/String;", "setIcCardNo", "(Ljava/lang/String;)V", "getName", "setName", "getPersonId", "setPersonId", "getTimetableId", "setTimetableId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SiteAttendanceBean {
    private String icCardNo;
    private String name;
    private String personId;
    private String timetableId;

    public SiteAttendanceBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SiteAttendanceBean copy$default(SiteAttendanceBean siteAttendanceBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = siteAttendanceBean.icCardNo;
        }
        if ((i & 2) != 0) {
            str2 = siteAttendanceBean.name;
        }
        if ((i & 4) != 0) {
            str3 = siteAttendanceBean.personId;
        }
        if ((i & 8) != 0) {
            str4 = siteAttendanceBean.timetableId;
        }
        return siteAttendanceBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIcCardNo() {
        return this.icCardNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPersonId() {
        return this.personId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTimetableId() {
        return this.timetableId;
    }

    public final SiteAttendanceBean copy(@JSONField(name = "icCardNo") String icCardNo, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "personId") String personId, @JSONField(name = "timetableId") String timetableId) {
        Intrinsics.checkNotNullParameter(icCardNo, "icCardNo");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(timetableId, "timetableId");
        return new SiteAttendanceBean(icCardNo, name, personId, timetableId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteAttendanceBean)) {
            return false;
        }
        SiteAttendanceBean siteAttendanceBean = (SiteAttendanceBean) other;
        return Intrinsics.areEqual(this.icCardNo, siteAttendanceBean.icCardNo) && Intrinsics.areEqual(this.name, siteAttendanceBean.name) && Intrinsics.areEqual(this.personId, siteAttendanceBean.personId) && Intrinsics.areEqual(this.timetableId, siteAttendanceBean.timetableId);
    }

    public int hashCode() {
        return (((((this.icCardNo.hashCode() * 31) + this.name.hashCode()) * 31) + this.personId.hashCode()) * 31) + this.timetableId.hashCode();
    }

    public String toString() {
        return "SiteAttendanceBean(icCardNo=" + this.icCardNo + ", name=" + this.name + ", personId=" + this.personId + ", timetableId=" + this.timetableId + ')';
    }

    public SiteAttendanceBean(@JSONField(name = "icCardNo") String icCardNo, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "personId") String personId, @JSONField(name = "timetableId") String timetableId) {
        Intrinsics.checkNotNullParameter(icCardNo, "icCardNo");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(timetableId, "timetableId");
        this.icCardNo = icCardNo;
        this.name = name;
        this.personId = personId;
        this.timetableId = timetableId;
    }

    public /* synthetic */ SiteAttendanceBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getIcCardNo() {
        return this.icCardNo;
    }

    public final void setIcCardNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icCardNo = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPersonId() {
        return this.personId;
    }

    public final void setPersonId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.personId = str;
    }

    public final String getTimetableId() {
        return this.timetableId;
    }

    public final void setTimetableId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timetableId = str;
    }
}
