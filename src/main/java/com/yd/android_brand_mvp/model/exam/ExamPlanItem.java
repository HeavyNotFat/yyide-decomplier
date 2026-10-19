package com.yd.android_brand_mvp.model.exam;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamPlanItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f¢\u0006\u0002\u0010 J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u000fHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u000fHÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\u0085\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u000fHÆ\u0001J\t\u0010Y\u001a\u00020\u0006HÖ\u0001J\u0013\u0010Z\u001a\u00020\u000f2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0006HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\u0019\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u001e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u001a\u0010\u001f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010?¨\u0006d"}, d2 = {"Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "Landroid/os/Parcelable;", "examinationRoomName", "", "examEndTime", "examPeopleNum", "", "siteName", "cell", "examinationId", "signInPerson", "subjectId", "totalPerson", "buildingName", "showed", "", "signIn", "siteId", "examinationPersonCount", "examStartTime", "row", "group", "", "Lcom/yd/android_brand_mvp/model/exam/ExamGroupItem;", "invigilators", "Lcom/yd/android_brand_mvp/model/exam/ExamInvigilatorBean;", "subjectName", "studentSeat", "weekDay", "startMinute", "endMinute", "isSelect", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ZZLjava/lang/String;ILjava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IIIZ)V", "getBuildingName", "()Ljava/lang/String;", "getCell", "()I", "getEndMinute", "getExamEndTime", "getExamPeopleNum", "getExamStartTime", "getExaminationId", "getExaminationPersonCount", "getExaminationRoomName", "getGroup", "()Ljava/util/List;", "getInvigilators", "()Z", "setSelect", "(Z)V", "getRow", "getShowed", "getSignIn", "getSignInPerson", "getSiteId", "getSiteName", "getStartMinute", "getStudentSeat", "getSubjectId", "getSubjectName", "getTotalPerson", "getWeekDay", "setWeekDay", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamPlanItem implements Parcelable {
    public static final Parcelable.Creator<ExamPlanItem> CREATOR = new Creator();
    private final String buildingName;
    private final int cell;
    private final int endMinute;
    private final String examEndTime;
    private final int examPeopleNum;
    private final String examStartTime;
    private final String examinationId;
    private final int examinationPersonCount;
    private final String examinationRoomName;
    private final List<ExamGroupItem> group;
    private final List<ExamInvigilatorBean> invigilators;
    private boolean isSelect;
    private final int row;
    private final boolean showed;
    private final boolean signIn;
    private final int signInPerson;
    private final String siteId;
    private final String siteName;
    private final int startMinute;
    private final String studentSeat;
    private final String subjectId;
    private final String subjectName;
    private final int totalPerson;
    private int weekDay;

    /* JADX INFO: compiled from: ExamPlanItem.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamPlanItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExamPlanItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            String string3 = parcel.readString();
            int i2 = parcel.readInt();
            String string4 = parcel.readString();
            int i3 = parcel.readInt();
            String string5 = parcel.readString();
            int i4 = parcel.readInt();
            String string6 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            String string7 = parcel.readString();
            int i5 = parcel.readInt();
            String string8 = parcel.readString();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i7);
            int i8 = 0;
            while (i8 != i7) {
                arrayList.add(ExamGroupItem.CREATOR.createFromParcel(parcel));
                i8++;
                i7 = i7;
            }
            ArrayList arrayList2 = arrayList;
            int i9 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i9);
            int i10 = 0;
            while (i10 != i9) {
                arrayList3.add(ExamInvigilatorBean.CREATOR.createFromParcel(parcel));
                i10++;
                i9 = i9;
            }
            return new ExamPlanItem(string, string2, i, string3, i2, string4, i3, string5, i4, string6, z, z2, string7, i5, string8, i6, arrayList2, arrayList3, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExamPlanItem[] newArray(int i) {
            return new ExamPlanItem[i];
        }
    }

    public ExamPlanItem() {
        this(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getExaminationRoomName() {
        return this.examinationRoomName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getBuildingName() {
        return this.buildingName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getShowed() {
        return this.showed;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getSignIn() {
        return this.signIn;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getExaminationPersonCount() {
        return this.examinationPersonCount;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getExamStartTime() {
        return this.examStartTime;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getRow() {
        return this.row;
    }

    public final List<ExamGroupItem> component17() {
        return this.group;
    }

    public final List<ExamInvigilatorBean> component18() {
        return this.invigilators;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExamEndTime() {
        return this.examEndTime;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getStudentSeat() {
        return this.studentSeat;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getWeekDay() {
        return this.weekDay;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getStartMinute() {
        return this.startMinute;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getEndMinute() {
        return this.endMinute;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getExamPeopleNum() {
        return this.examPeopleNum;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCell() {
        return this.cell;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExaminationId() {
        return this.examinationId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSignInPerson() {
        return this.signInPerson;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getTotalPerson() {
        return this.totalPerson;
    }

    public final ExamPlanItem copy(String examinationRoomName, String examEndTime, int examPeopleNum, String siteName, int cell, String examinationId, int signInPerson, String subjectId, int totalPerson, String buildingName, boolean showed, boolean signIn, String siteId, int examinationPersonCount, String examStartTime, int row, List<ExamGroupItem> group, List<ExamInvigilatorBean> invigilators, String subjectName, String studentSeat, int weekDay, int startMinute, int endMinute, boolean isSelect) {
        Intrinsics.checkNotNullParameter(examinationRoomName, "examinationRoomName");
        Intrinsics.checkNotNullParameter(examEndTime, "examEndTime");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(examStartTime, "examStartTime");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(invigilators, "invigilators");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(studentSeat, "studentSeat");
        return new ExamPlanItem(examinationRoomName, examEndTime, examPeopleNum, siteName, cell, examinationId, signInPerson, subjectId, totalPerson, buildingName, showed, signIn, siteId, examinationPersonCount, examStartTime, row, group, invigilators, subjectName, studentSeat, weekDay, startMinute, endMinute, isSelect);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamPlanItem)) {
            return false;
        }
        ExamPlanItem examPlanItem = (ExamPlanItem) other;
        return Intrinsics.areEqual(this.examinationRoomName, examPlanItem.examinationRoomName) && Intrinsics.areEqual(this.examEndTime, examPlanItem.examEndTime) && this.examPeopleNum == examPlanItem.examPeopleNum && Intrinsics.areEqual(this.siteName, examPlanItem.siteName) && this.cell == examPlanItem.cell && Intrinsics.areEqual(this.examinationId, examPlanItem.examinationId) && this.signInPerson == examPlanItem.signInPerson && Intrinsics.areEqual(this.subjectId, examPlanItem.subjectId) && this.totalPerson == examPlanItem.totalPerson && Intrinsics.areEqual(this.buildingName, examPlanItem.buildingName) && this.showed == examPlanItem.showed && this.signIn == examPlanItem.signIn && Intrinsics.areEqual(this.siteId, examPlanItem.siteId) && this.examinationPersonCount == examPlanItem.examinationPersonCount && Intrinsics.areEqual(this.examStartTime, examPlanItem.examStartTime) && this.row == examPlanItem.row && Intrinsics.areEqual(this.group, examPlanItem.group) && Intrinsics.areEqual(this.invigilators, examPlanItem.invigilators) && Intrinsics.areEqual(this.subjectName, examPlanItem.subjectName) && Intrinsics.areEqual(this.studentSeat, examPlanItem.studentSeat) && this.weekDay == examPlanItem.weekDay && this.startMinute == examPlanItem.startMinute && this.endMinute == examPlanItem.endMinute && this.isSelect == examPlanItem.isSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v47, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.examinationRoomName.hashCode() * 31) + this.examEndTime.hashCode()) * 31) + this.examPeopleNum) * 31) + this.siteName.hashCode()) * 31) + this.cell) * 31) + this.examinationId.hashCode()) * 31) + this.signInPerson) * 31) + this.subjectId.hashCode()) * 31) + this.totalPerson) * 31) + this.buildingName.hashCode()) * 31;
        boolean z = this.showed;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.signIn;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode2 = (((((((((((((((((((((((i + r2) * 31) + this.siteId.hashCode()) * 31) + this.examinationPersonCount) * 31) + this.examStartTime.hashCode()) * 31) + this.row) * 31) + this.group.hashCode()) * 31) + this.invigilators.hashCode()) * 31) + this.subjectName.hashCode()) * 31) + this.studentSeat.hashCode()) * 31) + this.weekDay) * 31) + this.startMinute) * 31) + this.endMinute) * 31;
        boolean z3 = this.isSelect;
        return iHashCode2 + (z3 ? 1 : z3);
    }

    public String toString() {
        return "ExamPlanItem(examinationRoomName=" + this.examinationRoomName + ", examEndTime=" + this.examEndTime + ", examPeopleNum=" + this.examPeopleNum + ", siteName=" + this.siteName + ", cell=" + this.cell + ", examinationId=" + this.examinationId + ", signInPerson=" + this.signInPerson + ", subjectId=" + this.subjectId + ", totalPerson=" + this.totalPerson + ", buildingName=" + this.buildingName + ", showed=" + this.showed + ", signIn=" + this.signIn + ", siteId=" + this.siteId + ", examinationPersonCount=" + this.examinationPersonCount + ", examStartTime=" + this.examStartTime + ", row=" + this.row + ", group=" + this.group + ", invigilators=" + this.invigilators + ", subjectName=" + this.subjectName + ", studentSeat=" + this.studentSeat + ", weekDay=" + this.weekDay + ", startMinute=" + this.startMinute + ", endMinute=" + this.endMinute + ", isSelect=" + this.isSelect + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.examinationRoomName);
        parcel.writeString(this.examEndTime);
        parcel.writeInt(this.examPeopleNum);
        parcel.writeString(this.siteName);
        parcel.writeInt(this.cell);
        parcel.writeString(this.examinationId);
        parcel.writeInt(this.signInPerson);
        parcel.writeString(this.subjectId);
        parcel.writeInt(this.totalPerson);
        parcel.writeString(this.buildingName);
        parcel.writeInt(this.showed ? 1 : 0);
        parcel.writeInt(this.signIn ? 1 : 0);
        parcel.writeString(this.siteId);
        parcel.writeInt(this.examinationPersonCount);
        parcel.writeString(this.examStartTime);
        parcel.writeInt(this.row);
        List<ExamGroupItem> list = this.group;
        parcel.writeInt(list.size());
        Iterator<ExamGroupItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        List<ExamInvigilatorBean> list2 = this.invigilators;
        parcel.writeInt(list2.size());
        Iterator<ExamInvigilatorBean> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.subjectName);
        parcel.writeString(this.studentSeat);
        parcel.writeInt(this.weekDay);
        parcel.writeInt(this.startMinute);
        parcel.writeInt(this.endMinute);
        parcel.writeInt(this.isSelect ? 1 : 0);
    }

    public ExamPlanItem(String examinationRoomName, String examEndTime, int i, String siteName, int i2, String examinationId, int i3, String subjectId, int i4, String buildingName, boolean z, boolean z2, String siteId, int i5, String examStartTime, int i6, List<ExamGroupItem> group, List<ExamInvigilatorBean> invigilators, String subjectName, String studentSeat, int i7, int i8, int i9, boolean z3) {
        Intrinsics.checkNotNullParameter(examinationRoomName, "examinationRoomName");
        Intrinsics.checkNotNullParameter(examEndTime, "examEndTime");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(examStartTime, "examStartTime");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(invigilators, "invigilators");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(studentSeat, "studentSeat");
        this.examinationRoomName = examinationRoomName;
        this.examEndTime = examEndTime;
        this.examPeopleNum = i;
        this.siteName = siteName;
        this.cell = i2;
        this.examinationId = examinationId;
        this.signInPerson = i3;
        this.subjectId = subjectId;
        this.totalPerson = i4;
        this.buildingName = buildingName;
        this.showed = z;
        this.signIn = z2;
        this.siteId = siteId;
        this.examinationPersonCount = i5;
        this.examStartTime = examStartTime;
        this.row = i6;
        this.group = group;
        this.invigilators = invigilators;
        this.subjectName = subjectName;
        this.studentSeat = studentSeat;
        this.weekDay = i7;
        this.startMinute = i8;
        this.endMinute = i9;
        this.isSelect = z3;
    }

    public final String getExaminationRoomName() {
        return this.examinationRoomName;
    }

    public final String getExamEndTime() {
        return this.examEndTime;
    }

    public final int getExamPeopleNum() {
        return this.examPeopleNum;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final int getCell() {
        return this.cell;
    }

    public final String getExaminationId() {
        return this.examinationId;
    }

    public final int getSignInPerson() {
        return this.signInPerson;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final int getTotalPerson() {
        return this.totalPerson;
    }

    public final String getBuildingName() {
        return this.buildingName;
    }

    public final boolean getShowed() {
        return this.showed;
    }

    public final boolean getSignIn() {
        return this.signIn;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final int getExaminationPersonCount() {
        return this.examinationPersonCount;
    }

    public final String getExamStartTime() {
        return this.examStartTime;
    }

    public final int getRow() {
        return this.row;
    }

    public /* synthetic */ ExamPlanItem(String str, String str2, int i, String str3, int i2, String str4, int i3, String str5, int i4, String str6, boolean z, boolean z2, String str7, int i5, String str8, int i6, List list, List list2, String str9, String str10, int i7, int i8, int i9, boolean z3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? 0 : i, (i10 & 8) != 0 ? "" : str3, (i10 & 16) != 0 ? 0 : i2, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? 0 : i3, (i10 & 128) != 0 ? "" : str5, (i10 & 256) != 0 ? 0 : i4, (i10 & 512) != 0 ? "" : str6, (i10 & 1024) != 0 ? false : z, (i10 & 2048) != 0 ? false : z2, (i10 & 4096) != 0 ? "" : str7, (i10 & 8192) != 0 ? 0 : i5, (i10 & 16384) != 0 ? "" : str8, (i10 & 32768) != 0 ? 0 : i6, (i10 & 65536) != 0 ? new ArrayList() : list, (i10 & 131072) != 0 ? new ArrayList() : list2, (i10 & 262144) != 0 ? "" : str9, (i10 & 524288) != 0 ? "1" : str10, (i10 & 1048576) != 0 ? 1 : i7, (i10 & 2097152) != 0 ? 0 : i8, (i10 & 4194304) != 0 ? 0 : i9, (i10 & 8388608) != 0 ? false : z3);
    }

    public final List<ExamGroupItem> getGroup() {
        return this.group;
    }

    public final List<ExamInvigilatorBean> getInvigilators() {
        return this.invigilators;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final String getStudentSeat() {
        return this.studentSeat;
    }

    public final int getWeekDay() {
        return this.weekDay;
    }

    public final void setWeekDay(int i) {
        this.weekDay = i;
    }

    public final int getStartMinute() {
        return this.startMinute;
    }

    public final int getEndMinute() {
        return this.endMinute;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
