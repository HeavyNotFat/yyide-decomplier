package com.yd.android_brand_mvp.model.task;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyTaskListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003¢\u0006\u0002\u0010\u001bJ\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0010HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0004HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u000bHÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0004HÆ\u0003J\t\u0010P\u001a\u00020\u0004HÆ\u0003Já\u0001\u0010Q\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003HÆ\u0001J\t\u0010R\u001a\u00020\u0010HÖ\u0001J\u0013\u0010S\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\u0010HÖ\u0001J\t\u0010W\u001a\u00020\u0004HÖ\u0001J\u0019\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010!\"\u0004\b#\u0010$R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010$R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010$R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010$R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010$R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010!\"\u0004\b4\u0010$R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010!\"\u0004\b6\u0010$R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00108\"\u0004\b:\u0010;R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*¨\u0006]"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "Landroid/os/Parcelable;", "subjectIdList", "", "", "subjectList", "publishEnd", "taskDescription", "signTaskRecordList", "Lcom/yd/android_brand_mvp/model/task/SignTaskRecordListItem;", "todayHaveSign", "", "requirementList", "frequency", "publishStart", "totalSignCount", "", "alreadySignCount", "taskName", "id", "publishScopeObjList", "Lcom/yd/android_brand_mvp/model/task/PublishScopeObjListItem;", "customerOption", "todayCanSign", "status", "weekendList", "Lcom/yd/android_brand_mvp/model/task/SubjectSelectBean;", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getAlreadySignCount", "()I", "setAlreadySignCount", "(I)V", "getCustomerOption", "()Ljava/lang/String;", "getFrequency", "setFrequency", "(Ljava/lang/String;)V", "getId", "setId", "getPublishEnd", "setPublishEnd", "getPublishScopeObjList", "()Ljava/util/List;", "getPublishStart", "setPublishStart", "getRequirementList", "getSignTaskRecordList", "getStatus", "setStatus", "getSubjectIdList", "getSubjectList", "getTaskDescription", "setTaskDescription", "getTaskName", "setTaskName", "getTodayCanSign", "()Z", "getTodayHaveSign", "setTodayHaveSign", "(Z)V", "getTotalSignCount", "setTotalSignCount", "getWeekendList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyTaskListItem implements Parcelable {
    public static final Parcelable.Creator<MyTaskListItem> CREATOR = new Creator();
    private int alreadySignCount;
    private final String customerOption;
    private String frequency;
    private String id;
    private String publishEnd;
    private final List<PublishScopeObjListItem> publishScopeObjList;
    private String publishStart;
    private final List<String> requirementList;
    private final List<SignTaskRecordListItem> signTaskRecordList;
    private String status;
    private final List<String> subjectIdList;
    private final List<String> subjectList;
    private String taskDescription;
    private String taskName;
    private final boolean todayCanSign;
    private boolean todayHaveSign;
    private int totalSignCount;
    private final List<SubjectSelectBean> weekendList;

    /* JADX INFO: compiled from: MyTaskListItem.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MyTaskListItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyTaskListItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(SignTaskRecordListItem.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            boolean z = parcel.readInt() != 0;
            ArrayList<String> arrayListCreateStringArrayList3 = parcel.createStringArrayList();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            int i5 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i5);
            int i6 = 0;
            while (i6 != i5) {
                arrayList3.add(PublishScopeObjListItem.CREATOR.createFromParcel(parcel));
                i6++;
                i5 = i5;
            }
            ArrayList arrayList4 = arrayList3;
            String string7 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            String string8 = parcel.readString();
            int i7 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(i7);
            int i8 = 0;
            while (i8 != i7) {
                arrayList5.add(SubjectSelectBean.CREATOR.createFromParcel(parcel));
                i8++;
                i7 = i7;
            }
            return new MyTaskListItem(arrayListCreateStringArrayList, arrayListCreateStringArrayList2, string, string2, arrayList2, z, arrayListCreateStringArrayList3, string3, string4, i3, i4, string5, string6, arrayList4, string7, z2, string8, arrayList5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyTaskListItem[] newArray(int i) {
            return new MyTaskListItem[i];
        }
    }

    public MyTaskListItem() {
        this(null, null, null, null, null, false, null, null, null, 0, 0, null, null, null, null, false, null, null, 262143, null);
    }

    public final List<String> component1() {
        return this.subjectIdList;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getTotalSignCount() {
        return this.totalSignCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getAlreadySignCount() {
        return this.alreadySignCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<PublishScopeObjListItem> component14() {
        return this.publishScopeObjList;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCustomerOption() {
        return this.customerOption;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getTodayCanSign() {
        return this.todayCanSign;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final List<SubjectSelectBean> component18() {
        return this.weekendList;
    }

    public final List<String> component2() {
        return this.subjectList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPublishEnd() {
        return this.publishEnd;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTaskDescription() {
        return this.taskDescription;
    }

    public final List<SignTaskRecordListItem> component5() {
        return this.signTaskRecordList;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getTodayHaveSign() {
        return this.todayHaveSign;
    }

    public final List<String> component7() {
        return this.requirementList;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFrequency() {
        return this.frequency;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPublishStart() {
        return this.publishStart;
    }

    public final MyTaskListItem copy(List<String> subjectIdList, List<String> subjectList, String publishEnd, String taskDescription, List<SignTaskRecordListItem> signTaskRecordList, boolean todayHaveSign, List<String> requirementList, String frequency, String publishStart, int totalSignCount, int alreadySignCount, String taskName, String id, List<PublishScopeObjListItem> publishScopeObjList, String customerOption, boolean todayCanSign, String status, List<SubjectSelectBean> weekendList) {
        Intrinsics.checkNotNullParameter(subjectIdList, "subjectIdList");
        Intrinsics.checkNotNullParameter(subjectList, "subjectList");
        Intrinsics.checkNotNullParameter(publishEnd, "publishEnd");
        Intrinsics.checkNotNullParameter(taskDescription, "taskDescription");
        Intrinsics.checkNotNullParameter(signTaskRecordList, "signTaskRecordList");
        Intrinsics.checkNotNullParameter(requirementList, "requirementList");
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        Intrinsics.checkNotNullParameter(publishStart, "publishStart");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(publishScopeObjList, "publishScopeObjList");
        Intrinsics.checkNotNullParameter(customerOption, "customerOption");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(weekendList, "weekendList");
        return new MyTaskListItem(subjectIdList, subjectList, publishEnd, taskDescription, signTaskRecordList, todayHaveSign, requirementList, frequency, publishStart, totalSignCount, alreadySignCount, taskName, id, publishScopeObjList, customerOption, todayCanSign, status, weekendList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyTaskListItem)) {
            return false;
        }
        MyTaskListItem myTaskListItem = (MyTaskListItem) other;
        return Intrinsics.areEqual(this.subjectIdList, myTaskListItem.subjectIdList) && Intrinsics.areEqual(this.subjectList, myTaskListItem.subjectList) && Intrinsics.areEqual(this.publishEnd, myTaskListItem.publishEnd) && Intrinsics.areEqual(this.taskDescription, myTaskListItem.taskDescription) && Intrinsics.areEqual(this.signTaskRecordList, myTaskListItem.signTaskRecordList) && this.todayHaveSign == myTaskListItem.todayHaveSign && Intrinsics.areEqual(this.requirementList, myTaskListItem.requirementList) && Intrinsics.areEqual(this.frequency, myTaskListItem.frequency) && Intrinsics.areEqual(this.publishStart, myTaskListItem.publishStart) && this.totalSignCount == myTaskListItem.totalSignCount && this.alreadySignCount == myTaskListItem.alreadySignCount && Intrinsics.areEqual(this.taskName, myTaskListItem.taskName) && Intrinsics.areEqual(this.id, myTaskListItem.id) && Intrinsics.areEqual(this.publishScopeObjList, myTaskListItem.publishScopeObjList) && Intrinsics.areEqual(this.customerOption, myTaskListItem.customerOption) && this.todayCanSign == myTaskListItem.todayCanSign && Intrinsics.areEqual(this.status, myTaskListItem.status) && Intrinsics.areEqual(this.weekendList, myTaskListItem.weekendList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.subjectIdList.hashCode() * 31) + this.subjectList.hashCode()) * 31) + this.publishEnd.hashCode()) * 31) + this.taskDescription.hashCode()) * 31) + this.signTaskRecordList.hashCode()) * 31;
        boolean z = this.todayHaveSign;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((((((((((iHashCode + r1) * 31) + this.requirementList.hashCode()) * 31) + this.frequency.hashCode()) * 31) + this.publishStart.hashCode()) * 31) + this.totalSignCount) * 31) + this.alreadySignCount) * 31) + this.taskName.hashCode()) * 31) + this.id.hashCode()) * 31) + this.publishScopeObjList.hashCode()) * 31) + this.customerOption.hashCode()) * 31;
        boolean z2 = this.todayCanSign;
        return ((((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.status.hashCode()) * 31) + this.weekendList.hashCode();
    }

    public String toString() {
        return "MyTaskListItem(subjectIdList=" + this.subjectIdList + ", subjectList=" + this.subjectList + ", publishEnd=" + this.publishEnd + ", taskDescription=" + this.taskDescription + ", signTaskRecordList=" + this.signTaskRecordList + ", todayHaveSign=" + this.todayHaveSign + ", requirementList=" + this.requirementList + ", frequency=" + this.frequency + ", publishStart=" + this.publishStart + ", totalSignCount=" + this.totalSignCount + ", alreadySignCount=" + this.alreadySignCount + ", taskName=" + this.taskName + ", id=" + this.id + ", publishScopeObjList=" + this.publishScopeObjList + ", customerOption=" + this.customerOption + ", todayCanSign=" + this.todayCanSign + ", status=" + this.status + ", weekendList=" + this.weekendList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.subjectIdList);
        parcel.writeStringList(this.subjectList);
        parcel.writeString(this.publishEnd);
        parcel.writeString(this.taskDescription);
        List<SignTaskRecordListItem> list = this.signTaskRecordList;
        parcel.writeInt(list.size());
        Iterator<SignTaskRecordListItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.todayHaveSign ? 1 : 0);
        parcel.writeStringList(this.requirementList);
        parcel.writeString(this.frequency);
        parcel.writeString(this.publishStart);
        parcel.writeInt(this.totalSignCount);
        parcel.writeInt(this.alreadySignCount);
        parcel.writeString(this.taskName);
        parcel.writeString(this.id);
        List<PublishScopeObjListItem> list2 = this.publishScopeObjList;
        parcel.writeInt(list2.size());
        Iterator<PublishScopeObjListItem> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.customerOption);
        parcel.writeInt(this.todayCanSign ? 1 : 0);
        parcel.writeString(this.status);
        List<SubjectSelectBean> list3 = this.weekendList;
        parcel.writeInt(list3.size());
        Iterator<SubjectSelectBean> it4 = list3.iterator();
        while (it4.hasNext()) {
            it4.next().writeToParcel(parcel, flags);
        }
    }

    public MyTaskListItem(List<String> subjectIdList, List<String> subjectList, String publishEnd, String taskDescription, List<SignTaskRecordListItem> signTaskRecordList, boolean z, List<String> requirementList, String frequency, String publishStart, int i, int i2, String taskName, String id, List<PublishScopeObjListItem> publishScopeObjList, String customerOption, boolean z2, String status, List<SubjectSelectBean> weekendList) {
        Intrinsics.checkNotNullParameter(subjectIdList, "subjectIdList");
        Intrinsics.checkNotNullParameter(subjectList, "subjectList");
        Intrinsics.checkNotNullParameter(publishEnd, "publishEnd");
        Intrinsics.checkNotNullParameter(taskDescription, "taskDescription");
        Intrinsics.checkNotNullParameter(signTaskRecordList, "signTaskRecordList");
        Intrinsics.checkNotNullParameter(requirementList, "requirementList");
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        Intrinsics.checkNotNullParameter(publishStart, "publishStart");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(publishScopeObjList, "publishScopeObjList");
        Intrinsics.checkNotNullParameter(customerOption, "customerOption");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(weekendList, "weekendList");
        this.subjectIdList = subjectIdList;
        this.subjectList = subjectList;
        this.publishEnd = publishEnd;
        this.taskDescription = taskDescription;
        this.signTaskRecordList = signTaskRecordList;
        this.todayHaveSign = z;
        this.requirementList = requirementList;
        this.frequency = frequency;
        this.publishStart = publishStart;
        this.totalSignCount = i;
        this.alreadySignCount = i2;
        this.taskName = taskName;
        this.id = id;
        this.publishScopeObjList = publishScopeObjList;
        this.customerOption = customerOption;
        this.todayCanSign = z2;
        this.status = status;
        this.weekendList = weekendList;
    }

    public /* synthetic */ MyTaskListItem(List list, List list2, String str, String str2, List list3, boolean z, List list4, String str3, String str4, int i, int i2, String str5, String str6, List list5, String str7, boolean z2, String str8, List list6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new ArrayList() : list2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? new ArrayList() : list3, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? new ArrayList() : list4, (i3 & 128) != 0 ? "" : str3, (i3 & 256) != 0 ? "" : str4, (i3 & 512) != 0 ? 0 : i, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? "" : str5, (i3 & 4096) != 0 ? "" : str6, (i3 & 8192) != 0 ? new ArrayList() : list5, (i3 & 16384) != 0 ? "" : str7, (i3 & 32768) != 0 ? false : z2, (i3 & 65536) != 0 ? "" : str8, (i3 & 131072) != 0 ? new ArrayList() : list6);
    }

    public final List<String> getSubjectIdList() {
        return this.subjectIdList;
    }

    public final List<String> getSubjectList() {
        return this.subjectList;
    }

    public final String getPublishEnd() {
        return this.publishEnd;
    }

    public final void setPublishEnd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.publishEnd = str;
    }

    public final String getTaskDescription() {
        return this.taskDescription;
    }

    public final void setTaskDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskDescription = str;
    }

    public final List<SignTaskRecordListItem> getSignTaskRecordList() {
        return this.signTaskRecordList;
    }

    public final boolean getTodayHaveSign() {
        return this.todayHaveSign;
    }

    public final void setTodayHaveSign(boolean z) {
        this.todayHaveSign = z;
    }

    public final List<String> getRequirementList() {
        return this.requirementList;
    }

    public final String getFrequency() {
        return this.frequency;
    }

    public final void setFrequency(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.frequency = str;
    }

    public final String getPublishStart() {
        return this.publishStart;
    }

    public final void setPublishStart(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.publishStart = str;
    }

    public final int getTotalSignCount() {
        return this.totalSignCount;
    }

    public final void setTotalSignCount(int i) {
        this.totalSignCount = i;
    }

    public final int getAlreadySignCount() {
        return this.alreadySignCount;
    }

    public final void setAlreadySignCount(int i) {
        this.alreadySignCount = i;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public final void setTaskName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskName = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final List<PublishScopeObjListItem> getPublishScopeObjList() {
        return this.publishScopeObjList;
    }

    public final String getCustomerOption() {
        return this.customerOption;
    }

    public final boolean getTodayCanSign() {
        return this.todayCanSign;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final List<SubjectSelectBean> getWeekendList() {
        return this.weekendList;
    }
}
