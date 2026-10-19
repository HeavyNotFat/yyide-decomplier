package com.yd.android_brand_mvp.model.userspace;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveTypeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006*"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "", "durationRounding", "", "schoolId", "", AppMeasurementSdk.ConditionalUserProperty.NAME, SessionDescription.ATTR_RANGE, "durationWay", "id", "durationType", "isSelect", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZ)V", "getDurationRounding", "()I", "getDurationType", "getDurationWay", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setSelect", "(Z)V", "getName", "setName", "getRange", "getSchoolId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LeaveTypeBean {
    private final int durationRounding;
    private final int durationType;
    private final int durationWay;
    private String id;
    private boolean isSelect;
    private String name;
    private final String range;
    private final String schoolId;

    public LeaveTypeBean() {
        this(0, null, null, null, 0, null, 0, false, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDurationRounding() {
        return this.durationRounding;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRange() {
        return this.range;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDurationWay() {
        return this.durationWay;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDurationType() {
        return this.durationType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final LeaveTypeBean copy(int durationRounding, String schoolId, String name, String range, int durationWay, String id, int durationType, boolean isSelect) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(id, "id");
        return new LeaveTypeBean(durationRounding, schoolId, name, range, durationWay, id, durationType, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveTypeBean)) {
            return false;
        }
        LeaveTypeBean leaveTypeBean = (LeaveTypeBean) other;
        return this.durationRounding == leaveTypeBean.durationRounding && Intrinsics.areEqual(this.schoolId, leaveTypeBean.schoolId) && Intrinsics.areEqual(this.name, leaveTypeBean.name) && Intrinsics.areEqual(this.range, leaveTypeBean.range) && this.durationWay == leaveTypeBean.durationWay && Intrinsics.areEqual(this.id, leaveTypeBean.id) && this.durationType == leaveTypeBean.durationType && this.isSelect == leaveTypeBean.isSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.durationRounding * 31) + this.schoolId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.range.hashCode()) * 31) + this.durationWay) * 31) + this.id.hashCode()) * 31) + this.durationType) * 31;
        boolean z = this.isSelect;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "LeaveTypeBean(durationRounding=" + this.durationRounding + ", schoolId=" + this.schoolId + ", name=" + this.name + ", range=" + this.range + ", durationWay=" + this.durationWay + ", id=" + this.id + ", durationType=" + this.durationType + ", isSelect=" + this.isSelect + ')';
    }

    public LeaveTypeBean(int i, String schoolId, String name, String range, int i2, String id, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(id, "id");
        this.durationRounding = i;
        this.schoolId = schoolId;
        this.name = name;
        this.range = range;
        this.durationWay = i2;
        this.id = id;
        this.durationType = i3;
        this.isSelect = z;
    }

    public /* synthetic */ LeaveTypeBean(int i, String str, String str2, String str3, int i2, String str4, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) == 0 ? str4 : "", (i4 & 64) != 0 ? 0 : i3, (i4 & 128) == 0 ? z : false);
    }

    public final int getDurationRounding() {
        return this.durationRounding;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getRange() {
        return this.range;
    }

    public final int getDurationWay() {
        return this.durationWay;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final int getDurationType() {
        return this.durationType;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
