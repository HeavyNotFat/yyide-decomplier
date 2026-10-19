package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreClass;", "Ljava/io/Serializable;", "classId", "", PushClientConstants.TAG_CLASS_NAME, "scored", "", "checked", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getChecked", "()Z", "setChecked", "(Z)V", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getScored", "setScored", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorCanScoreClass implements Serializable {
    private boolean checked;
    private String classId;
    private String className;
    private boolean scored;

    public static /* synthetic */ HonorCanScoreClass copy$default(HonorCanScoreClass honorCanScoreClass, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorCanScoreClass.classId;
        }
        if ((i & 2) != 0) {
            str2 = honorCanScoreClass.className;
        }
        if ((i & 4) != 0) {
            z = honorCanScoreClass.scored;
        }
        if ((i & 8) != 0) {
            z2 = honorCanScoreClass.checked;
        }
        return honorCanScoreClass.copy(str, str2, z, z2);
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
    public final boolean getScored() {
        return this.scored;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    public final HonorCanScoreClass copy(@JSONField(name = "classId") String classId, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String className, @JSONField(name = "scored") boolean scored, boolean checked) {
        return new HonorCanScoreClass(classId, className, scored, checked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorCanScoreClass)) {
            return false;
        }
        HonorCanScoreClass honorCanScoreClass = (HonorCanScoreClass) other;
        return Intrinsics.areEqual(this.classId, honorCanScoreClass.classId) && Intrinsics.areEqual(this.className, honorCanScoreClass.className) && this.scored == honorCanScoreClass.scored && this.checked == honorCanScoreClass.checked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        String str = this.classId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.className;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.scored;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.checked;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "HonorCanScoreClass(classId=" + this.classId + ", className=" + this.className + ", scored=" + this.scored + ", checked=" + this.checked + ')';
    }

    public HonorCanScoreClass(@JSONField(name = "classId") String str, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String str2, @JSONField(name = "scored") boolean z, boolean z2) {
        this.classId = str;
        this.className = str2;
        this.scored = z;
        this.checked = z2;
    }

    public /* synthetic */ HonorCanScoreClass(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i & 8) != 0 ? false : z2);
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        this.classId = str;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final boolean getScored() {
        return this.scored;
    }

    public final void setScored(boolean z) {
        this.scored = z;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }
}
