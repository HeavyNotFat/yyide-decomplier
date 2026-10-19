package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.vivo.push.PushClientConstants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J[\u0010%\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006,"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreStudent;", "Ljava/io/Serializable;", "classId", "", CommentsHomeFragment.TYPE_ID, "studentName", PushClientConstants.TAG_CLASS_NAME, "gradeId", "gradeName", "checked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getGradeId", "setGradeId", "getGradeName", "setGradeName", "getStudentId", "setStudentId", "getStudentName", "setStudentName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorCanScoreStudent implements Serializable {
    private boolean checked;
    private String classId;
    private String className;
    private String gradeId;
    private String gradeName;
    private String studentId;
    private String studentName;

    public static /* synthetic */ HonorCanScoreStudent copy$default(HonorCanScoreStudent honorCanScoreStudent, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorCanScoreStudent.classId;
        }
        if ((i & 2) != 0) {
            str2 = honorCanScoreStudent.studentId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = honorCanScoreStudent.studentName;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = honorCanScoreStudent.className;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = honorCanScoreStudent.gradeId;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = honorCanScoreStudent.gradeName;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            z = honorCanScoreStudent.checked;
        }
        return honorCanScoreStudent.copy(str, str7, str8, str9, str10, str11, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClassId() {
        return this.classId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStudentName() {
        return this.studentName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGradeId() {
        return this.gradeId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGradeName() {
        return this.gradeName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    public final HonorCanScoreStudent copy(@JSONField(name = "classId") String classId, @JSONField(name = CommentsHomeFragment.TYPE_ID) String studentId, @JSONField(name = "studentName") String studentName, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String className, @JSONField(name = "gradeId") String gradeId, @JSONField(name = "gradeName") String gradeName, boolean checked) {
        return new HonorCanScoreStudent(classId, studentId, studentName, className, gradeId, gradeName, checked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorCanScoreStudent)) {
            return false;
        }
        HonorCanScoreStudent honorCanScoreStudent = (HonorCanScoreStudent) other;
        return Intrinsics.areEqual(this.classId, honorCanScoreStudent.classId) && Intrinsics.areEqual(this.studentId, honorCanScoreStudent.studentId) && Intrinsics.areEqual(this.studentName, honorCanScoreStudent.studentName) && Intrinsics.areEqual(this.className, honorCanScoreStudent.className) && Intrinsics.areEqual(this.gradeId, honorCanScoreStudent.gradeId) && Intrinsics.areEqual(this.gradeName, honorCanScoreStudent.gradeName) && this.checked == honorCanScoreStudent.checked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.classId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.studentId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.studentName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.className;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gradeId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.gradeName;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.checked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode6 + r1;
    }

    public String toString() {
        return "HonorCanScoreStudent(classId=" + this.classId + ", studentId=" + this.studentId + ", studentName=" + this.studentName + ", className=" + this.className + ", gradeId=" + this.gradeId + ", gradeName=" + this.gradeName + ", checked=" + this.checked + ')';
    }

    public HonorCanScoreStudent(@JSONField(name = "classId") String str, @JSONField(name = CommentsHomeFragment.TYPE_ID) String str2, @JSONField(name = "studentName") String str3, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String str4, @JSONField(name = "gradeId") String str5, @JSONField(name = "gradeName") String str6, boolean z) {
        this.classId = str;
        this.studentId = str2;
        this.studentName = str3;
        this.className = str4;
        this.gradeId = str5;
        this.gradeName = str6;
        this.checked = z;
    }

    public /* synthetic */ HonorCanScoreStudent(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? false : z);
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        this.classId = str;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(String str) {
        this.studentId = str;
    }

    public final String getStudentName() {
        return this.studentName;
    }

    public final void setStudentName(String str) {
        this.studentName = str;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final String getGradeId() {
        return this.gradeId;
    }

    public final void setGradeId(String str) {
        this.gradeId = str;
    }

    public final String getGradeName() {
        return this.gradeName;
    }

    public final void setGradeName(String str) {
        this.gradeName = str;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }
}
