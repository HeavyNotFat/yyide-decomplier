package com.yd.android_brand_mvp.model;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassesOverInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/model/ClassesOverInfoBean;", "", "afterEndTime", "", "afterSchoolLogId", "afterTime", CommentsHomeFragment.TYPE_CLASSESID, "classesName", "status", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAfterEndTime", "()Ljava/lang/String;", "getAfterSchoolLogId", "getAfterTime", "getClassesId", "getClassesName", "getStatus", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClassesOverInfoBean {
    private final String afterEndTime;
    private final String afterSchoolLogId;
    private final String afterTime;
    private final String classesId;
    private final String classesName;
    private final int status;

    public static /* synthetic */ ClassesOverInfoBean copy$default(ClassesOverInfoBean classesOverInfoBean, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = classesOverInfoBean.afterEndTime;
        }
        if ((i2 & 2) != 0) {
            str2 = classesOverInfoBean.afterSchoolLogId;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = classesOverInfoBean.afterTime;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = classesOverInfoBean.classesId;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = classesOverInfoBean.classesName;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = classesOverInfoBean.status;
        }
        return classesOverInfoBean.copy(str, str6, str7, str8, str9, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAfterEndTime() {
        return this.afterEndTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAfterSchoolLogId() {
        return this.afterSchoolLogId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAfterTime() {
        return this.afterTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClassesId() {
        return this.classesId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getClassesName() {
        return this.classesName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final ClassesOverInfoBean copy(String afterEndTime, String afterSchoolLogId, String afterTime, String classesId, String classesName, int status) {
        Intrinsics.checkNotNullParameter(afterEndTime, "afterEndTime");
        Intrinsics.checkNotNullParameter(afterSchoolLogId, "afterSchoolLogId");
        Intrinsics.checkNotNullParameter(afterTime, "afterTime");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        return new ClassesOverInfoBean(afterEndTime, afterSchoolLogId, afterTime, classesId, classesName, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassesOverInfoBean)) {
            return false;
        }
        ClassesOverInfoBean classesOverInfoBean = (ClassesOverInfoBean) other;
        return Intrinsics.areEqual(this.afterEndTime, classesOverInfoBean.afterEndTime) && Intrinsics.areEqual(this.afterSchoolLogId, classesOverInfoBean.afterSchoolLogId) && Intrinsics.areEqual(this.afterTime, classesOverInfoBean.afterTime) && Intrinsics.areEqual(this.classesId, classesOverInfoBean.classesId) && Intrinsics.areEqual(this.classesName, classesOverInfoBean.classesName) && this.status == classesOverInfoBean.status;
    }

    public int hashCode() {
        return (((((((((this.afterEndTime.hashCode() * 31) + this.afterSchoolLogId.hashCode()) * 31) + this.afterTime.hashCode()) * 31) + this.classesId.hashCode()) * 31) + this.classesName.hashCode()) * 31) + this.status;
    }

    public String toString() {
        return "ClassesOverInfoBean(afterEndTime=" + this.afterEndTime + ", afterSchoolLogId=" + this.afterSchoolLogId + ", afterTime=" + this.afterTime + ", classesId=" + this.classesId + ", classesName=" + this.classesName + ", status=" + this.status + ')';
    }

    public ClassesOverInfoBean(String afterEndTime, String afterSchoolLogId, String afterTime, String classesId, String classesName, int i) {
        Intrinsics.checkNotNullParameter(afterEndTime, "afterEndTime");
        Intrinsics.checkNotNullParameter(afterSchoolLogId, "afterSchoolLogId");
        Intrinsics.checkNotNullParameter(afterTime, "afterTime");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        this.afterEndTime = afterEndTime;
        this.afterSchoolLogId = afterSchoolLogId;
        this.afterTime = afterTime;
        this.classesId = classesId;
        this.classesName = classesName;
        this.status = i;
    }

    public final String getAfterEndTime() {
        return this.afterEndTime;
    }

    public final String getAfterSchoolLogId() {
        return this.afterSchoolLogId;
    }

    public final String getAfterTime() {
        return this.afterTime;
    }

    public final String getClassesId() {
        return this.classesId;
    }

    public final String getClassesName() {
        return this.classesName;
    }

    public final int getStatus() {
        return this.status;
    }
}
