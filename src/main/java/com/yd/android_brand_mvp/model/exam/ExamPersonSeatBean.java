package com.yd.android_brand_mvp.model.exam;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamPersonSeatBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u0095\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014¨\u00069"}, d2 = {"Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;", "", "signInType", "", "examineNumber", "", "groupId", "siteName", "examinationId", "classesName", "personName", "seat", CommentsHomeFragment.TYPE_CLASSESID, "groupName", "signInTime", "schoolId", "siteId", "personId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassesId", "()Ljava/lang/String;", "getClassesName", "getExaminationId", "getExamineNumber", "getGroupId", "getGroupName", "getPersonId", "getPersonName", "getSchoolId", "getSeat", "setSeat", "(Ljava/lang/String;)V", "getSignInTime", "getSignInType", "()I", "getSiteId", "getSiteName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamPersonSeatBean {
    private final String classesId;
    private final String classesName;
    private final String examinationId;
    private final String examineNumber;
    private final String groupId;
    private final String groupName;
    private final String personId;
    private final String personName;
    private final String schoolId;
    private String seat;
    private final String signInTime;
    private final int signInType;
    private final String siteId;
    private final String siteName;

    public ExamPersonSeatBean() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSignInType() {
        return this.signInType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSignInTime() {
        return this.signInTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPersonId() {
        return this.personId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExamineNumber() {
        return this.examineNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getExaminationId() {
        return this.examinationId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getClassesName() {
        return this.classesName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPersonName() {
        return this.personName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSeat() {
        return this.seat;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getClassesId() {
        return this.classesId;
    }

    public final ExamPersonSeatBean copy(int signInType, String examineNumber, String groupId, String siteName, String examinationId, String classesName, String personName, String seat, String classesId, String groupName, String signInTime, String schoolId, String siteId, String personId) {
        Intrinsics.checkNotNullParameter(examineNumber, "examineNumber");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(signInTime, "signInTime");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(personId, "personId");
        return new ExamPersonSeatBean(signInType, examineNumber, groupId, siteName, examinationId, classesName, personName, seat, classesId, groupName, signInTime, schoolId, siteId, personId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamPersonSeatBean)) {
            return false;
        }
        ExamPersonSeatBean examPersonSeatBean = (ExamPersonSeatBean) other;
        return this.signInType == examPersonSeatBean.signInType && Intrinsics.areEqual(this.examineNumber, examPersonSeatBean.examineNumber) && Intrinsics.areEqual(this.groupId, examPersonSeatBean.groupId) && Intrinsics.areEqual(this.siteName, examPersonSeatBean.siteName) && Intrinsics.areEqual(this.examinationId, examPersonSeatBean.examinationId) && Intrinsics.areEqual(this.classesName, examPersonSeatBean.classesName) && Intrinsics.areEqual(this.personName, examPersonSeatBean.personName) && Intrinsics.areEqual(this.seat, examPersonSeatBean.seat) && Intrinsics.areEqual(this.classesId, examPersonSeatBean.classesId) && Intrinsics.areEqual(this.groupName, examPersonSeatBean.groupName) && Intrinsics.areEqual(this.signInTime, examPersonSeatBean.signInTime) && Intrinsics.areEqual(this.schoolId, examPersonSeatBean.schoolId) && Intrinsics.areEqual(this.siteId, examPersonSeatBean.siteId) && Intrinsics.areEqual(this.personId, examPersonSeatBean.personId);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.signInType * 31) + this.examineNumber.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.siteName.hashCode()) * 31) + this.examinationId.hashCode()) * 31) + this.classesName.hashCode()) * 31) + this.personName.hashCode()) * 31) + this.seat.hashCode()) * 31) + this.classesId.hashCode()) * 31) + this.groupName.hashCode()) * 31) + this.signInTime.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.siteId.hashCode()) * 31) + this.personId.hashCode();
    }

    public String toString() {
        return "ExamPersonSeatBean(signInType=" + this.signInType + ", examineNumber=" + this.examineNumber + ", groupId=" + this.groupId + ", siteName=" + this.siteName + ", examinationId=" + this.examinationId + ", classesName=" + this.classesName + ", personName=" + this.personName + ", seat=" + this.seat + ", classesId=" + this.classesId + ", groupName=" + this.groupName + ", signInTime=" + this.signInTime + ", schoolId=" + this.schoolId + ", siteId=" + this.siteId + ", personId=" + this.personId + ')';
    }

    public ExamPersonSeatBean(int i, String examineNumber, String groupId, String siteName, String examinationId, String classesName, String personName, String seat, String classesId, String groupName, String signInTime, String schoolId, String siteId, String personId) {
        Intrinsics.checkNotNullParameter(examineNumber, "examineNumber");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(seat, "seat");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(signInTime, "signInTime");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(personId, "personId");
        this.signInType = i;
        this.examineNumber = examineNumber;
        this.groupId = groupId;
        this.siteName = siteName;
        this.examinationId = examinationId;
        this.classesName = classesName;
        this.personName = personName;
        this.seat = seat;
        this.classesId = classesId;
        this.groupName = groupName;
        this.signInTime = signInTime;
        this.schoolId = schoolId;
        this.siteId = siteId;
        this.personId = personId;
    }

    public /* synthetic */ ExamPersonSeatBean(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) != 0 ? "" : str10, (i2 & 2048) != 0 ? "" : str11, (i2 & 4096) != 0 ? "" : str12, (i2 & 8192) == 0 ? str13 : "");
    }

    public final int getSignInType() {
        return this.signInType;
    }

    public final String getExamineNumber() {
        return this.examineNumber;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final String getExaminationId() {
        return this.examinationId;
    }

    public final String getClassesName() {
        return this.classesName;
    }

    public final String getPersonName() {
        return this.personName;
    }

    public final String getSeat() {
        return this.seat;
    }

    public final void setSeat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.seat = str;
    }

    public final String getClassesId() {
        return this.classesId;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getSignInTime() {
        return this.signInTime;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final String getPersonId() {
        return this.personId;
    }
}
