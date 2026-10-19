package com.yd.android_brand_mvp.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DominateDetailLevelBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000eHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001J\u0013\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/DominateDetailLevelBean;", "", FirebaseAnalytics.Param.LEVEL, "", "modeType", "", "startDate", "endDate", TypedValues.TransitionType.S_DURATION, "type", "schoolId", "", "status", "autoShow", "", "isForceExit", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJIZZ)V", "getAutoShow", "()Z", "getDuration", "()I", "getEndDate", "()Ljava/lang/String;", "getLevel", "getModeType", "setModeType", "(Ljava/lang/String;)V", "getSchoolId", "()J", "getStartDate", "getStatus", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DominateDetailLevelBean {
    private final boolean autoShow;
    private final int duration;
    private final String endDate;
    private final boolean isForceExit;
    private final int level;
    private String modeType;
    private final long schoolId;
    private final String startDate;
    private final int status;
    private final int type;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsForceExit() {
        return this.isForceExit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModeType() {
        return this.modeType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAutoShow() {
        return this.autoShow;
    }

    public final DominateDetailLevelBean copy(int level, String modeType, String startDate, String endDate, int duration, int type, long schoolId, int status, boolean autoShow, boolean isForceExit) {
        Intrinsics.checkNotNullParameter(modeType, "modeType");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        return new DominateDetailLevelBean(level, modeType, startDate, endDate, duration, type, schoolId, status, autoShow, isForceExit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DominateDetailLevelBean)) {
            return false;
        }
        DominateDetailLevelBean dominateDetailLevelBean = (DominateDetailLevelBean) other;
        return this.level == dominateDetailLevelBean.level && Intrinsics.areEqual(this.modeType, dominateDetailLevelBean.modeType) && Intrinsics.areEqual(this.startDate, dominateDetailLevelBean.startDate) && Intrinsics.areEqual(this.endDate, dominateDetailLevelBean.endDate) && this.duration == dominateDetailLevelBean.duration && this.type == dominateDetailLevelBean.type && this.schoolId == dominateDetailLevelBean.schoolId && this.status == dominateDetailLevelBean.status && this.autoShow == dominateDetailLevelBean.autoShow && this.isForceExit == dominateDetailLevelBean.isForceExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.level * 31) + this.modeType.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.endDate.hashCode()) * 31) + this.duration) * 31) + this.type) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.schoolId)) * 31) + this.status) * 31;
        boolean z = this.autoShow;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isForceExit;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "DominateDetailLevelBean(level=" + this.level + ", modeType=" + this.modeType + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", duration=" + this.duration + ", type=" + this.type + ", schoolId=" + this.schoolId + ", status=" + this.status + ", autoShow=" + this.autoShow + ", isForceExit=" + this.isForceExit + ')';
    }

    public DominateDetailLevelBean(int i, String modeType, String startDate, String endDate, int i2, int i3, long j, int i4, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(modeType, "modeType");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        this.level = i;
        this.modeType = modeType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = i2;
        this.type = i3;
        this.schoolId = j;
        this.status = i4;
        this.autoShow = z;
        this.isForceExit = z2;
    }

    public /* synthetic */ DominateDetailLevelBean(int i, String str, String str2, String str3, int i2, int i3, long j, int i4, boolean z, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, str2, str3, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? 0L : j, (i5 & 128) != 0 ? 0 : i4, z, (i5 & 512) != 0 ? false : z2);
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getModeType() {
        return this.modeType;
    }

    public final void setModeType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modeType = str;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getType() {
        return this.type;
    }

    public final long getSchoolId() {
        return this.schoolId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean getAutoShow() {
        return this.autoShow;
    }

    public final boolean isForceExit() {
        return this.isForceExit;
    }
}
