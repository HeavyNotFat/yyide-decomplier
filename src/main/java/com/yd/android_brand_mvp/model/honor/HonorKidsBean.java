package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.vivo.push.PushClientConstants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorKidsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorKidsBean;", "", "classId", "", PushClientConstants.TAG_CLASS_NAME, CommentsHomeFragment.TYPE_ID, "studentName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getStudentId", "setStudentId", "getStudentName", "setStudentName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorKidsBean {
    private String classId;
    private String className;
    private String studentId;
    private String studentName;

    public static /* synthetic */ HonorKidsBean copy$default(HonorKidsBean honorKidsBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorKidsBean.classId;
        }
        if ((i & 2) != 0) {
            str2 = honorKidsBean.className;
        }
        if ((i & 4) != 0) {
            str3 = honorKidsBean.studentId;
        }
        if ((i & 8) != 0) {
            str4 = honorKidsBean.studentName;
        }
        return honorKidsBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClassId() {
        return this.classId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStudentName() {
        return this.studentName;
    }

    public final HonorKidsBean copy(@JSONField(name = "classId") String classId, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String className, @JSONField(name = CommentsHomeFragment.TYPE_ID) String studentId, @JSONField(name = "studentName") String studentName) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        return new HonorKidsBean(classId, className, studentId, studentName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorKidsBean)) {
            return false;
        }
        HonorKidsBean honorKidsBean = (HonorKidsBean) other;
        return Intrinsics.areEqual(this.classId, honorKidsBean.classId) && Intrinsics.areEqual(this.className, honorKidsBean.className) && Intrinsics.areEqual(this.studentId, honorKidsBean.studentId) && Intrinsics.areEqual(this.studentName, honorKidsBean.studentName);
    }

    public int hashCode() {
        return (((((this.classId.hashCode() * 31) + this.className.hashCode()) * 31) + this.studentId.hashCode()) * 31) + this.studentName.hashCode();
    }

    public String toString() {
        return "HonorKidsBean(classId=" + this.classId + ", className=" + this.className + ", studentId=" + this.studentId + ", studentName=" + this.studentName + ')';
    }

    public HonorKidsBean(@JSONField(name = "classId") String classId, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String className, @JSONField(name = CommentsHomeFragment.TYPE_ID) String studentId, @JSONField(name = "studentName") String studentName) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        this.classId = classId;
        this.className = className;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classId = str;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentId = str;
    }

    public final String getStudentName() {
        return this.studentName;
    }

    public final void setStudentName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentName = str;
    }
}
