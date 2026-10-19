package com.yd.android_brand_mvp.model.duty;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/duty/DutyStudent;", "", "beginTime", "", "endTime", "id", "studentAvatar", CommentsHomeFragment.TYPE_ID, "studentName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBeginTime", "()Ljava/lang/String;", "getEndTime", "getId", "getStudentAvatar", "getStudentId", "getStudentName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DutyStudent {
    private final String beginTime;
    private final String endTime;
    private final String id;
    private final String studentAvatar;
    private final String studentId;
    private final String studentName;

    public static /* synthetic */ DutyStudent copy$default(DutyStudent dutyStudent, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dutyStudent.beginTime;
        }
        if ((i & 2) != 0) {
            str2 = dutyStudent.endTime;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = dutyStudent.id;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = dutyStudent.studentAvatar;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = dutyStudent.studentId;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = dutyStudent.studentName;
        }
        return dutyStudent.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBeginTime() {
        return this.beginTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStudentAvatar() {
        return this.studentAvatar;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStudentName() {
        return this.studentName;
    }

    public final DutyStudent copy(String beginTime, String endTime, String id, String studentAvatar, String studentId, String studentName) {
        Intrinsics.checkNotNullParameter(beginTime, "beginTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentAvatar, "studentAvatar");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        return new DutyStudent(beginTime, endTime, id, studentAvatar, studentId, studentName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyStudent)) {
            return false;
        }
        DutyStudent dutyStudent = (DutyStudent) other;
        return Intrinsics.areEqual(this.beginTime, dutyStudent.beginTime) && Intrinsics.areEqual(this.endTime, dutyStudent.endTime) && Intrinsics.areEqual(this.id, dutyStudent.id) && Intrinsics.areEqual(this.studentAvatar, dutyStudent.studentAvatar) && Intrinsics.areEqual(this.studentId, dutyStudent.studentId) && Intrinsics.areEqual(this.studentName, dutyStudent.studentName);
    }

    public int hashCode() {
        return (((((((((this.beginTime.hashCode() * 31) + this.endTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.studentAvatar.hashCode()) * 31) + this.studentId.hashCode()) * 31) + this.studentName.hashCode();
    }

    public String toString() {
        return "DutyStudent(beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", id=" + this.id + ", studentAvatar=" + this.studentAvatar + ", studentId=" + this.studentId + ", studentName=" + this.studentName + ')';
    }

    public DutyStudent(String beginTime, String endTime, String id, String studentAvatar, String studentId, String studentName) {
        Intrinsics.checkNotNullParameter(beginTime, "beginTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentAvatar, "studentAvatar");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.id = id;
        this.studentAvatar = studentAvatar;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public final String getBeginTime() {
        return this.beginTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStudentAvatar() {
        return this.studentAvatar;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final String getStudentName() {
        return this.studentName;
    }
}
