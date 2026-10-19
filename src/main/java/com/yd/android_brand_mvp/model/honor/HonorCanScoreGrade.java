package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreGrade;", "Ljava/io/Serializable;", "classList", "", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreClass;", "gradeId", "", "gradeName", "checked", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "getClassList", "()Ljava/util/List;", "setClassList", "(Ljava/util/List;)V", "getGradeId", "()Ljava/lang/String;", "setGradeId", "(Ljava/lang/String;)V", "getGradeName", "setGradeName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorCanScoreGrade implements Serializable {
    private boolean checked;
    private List<HonorCanScoreClass> classList;
    private String gradeId;
    private String gradeName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HonorCanScoreGrade copy$default(HonorCanScoreGrade honorCanScoreGrade, List list, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = honorCanScoreGrade.classList;
        }
        if ((i & 2) != 0) {
            str = honorCanScoreGrade.gradeId;
        }
        if ((i & 4) != 0) {
            str2 = honorCanScoreGrade.gradeName;
        }
        if ((i & 8) != 0) {
            z = honorCanScoreGrade.checked;
        }
        return honorCanScoreGrade.copy(list, str, str2, z);
    }

    public final List<HonorCanScoreClass> component1() {
        return this.classList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGradeId() {
        return this.gradeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGradeName() {
        return this.gradeName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    public final HonorCanScoreGrade copy(@JSONField(name = "classList") List<HonorCanScoreClass> classList, @JSONField(name = "gradeId") String gradeId, @JSONField(name = "gradeName") String gradeName, boolean checked) {
        Intrinsics.checkNotNullParameter(classList, "classList");
        Intrinsics.checkNotNullParameter(gradeId, "gradeId");
        Intrinsics.checkNotNullParameter(gradeName, "gradeName");
        return new HonorCanScoreGrade(classList, gradeId, gradeName, checked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorCanScoreGrade)) {
            return false;
        }
        HonorCanScoreGrade honorCanScoreGrade = (HonorCanScoreGrade) other;
        return Intrinsics.areEqual(this.classList, honorCanScoreGrade.classList) && Intrinsics.areEqual(this.gradeId, honorCanScoreGrade.gradeId) && Intrinsics.areEqual(this.gradeName, honorCanScoreGrade.gradeName) && this.checked == honorCanScoreGrade.checked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.classList.hashCode() * 31) + this.gradeId.hashCode()) * 31) + this.gradeName.hashCode()) * 31;
        boolean z = this.checked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "HonorCanScoreGrade(classList=" + this.classList + ", gradeId=" + this.gradeId + ", gradeName=" + this.gradeName + ", checked=" + this.checked + ')';
    }

    public HonorCanScoreGrade(@JSONField(name = "classList") List<HonorCanScoreClass> classList, @JSONField(name = "gradeId") String gradeId, @JSONField(name = "gradeName") String gradeName, boolean z) {
        Intrinsics.checkNotNullParameter(classList, "classList");
        Intrinsics.checkNotNullParameter(gradeId, "gradeId");
        Intrinsics.checkNotNullParameter(gradeName, "gradeName");
        this.classList = classList;
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.checked = z;
    }

    public /* synthetic */ HonorCanScoreGrade(List list, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, (i & 8) != 0 ? false : z);
    }

    public final List<HonorCanScoreClass> getClassList() {
        return this.classList;
    }

    public final void setClassList(List<HonorCanScoreClass> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.classList = list;
    }

    public final String getGradeId() {
        return this.gradeId;
    }

    public final void setGradeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gradeId = str;
    }

    public final String getGradeName() {
        return this.gradeName;
    }

    public final void setGradeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gradeName = str;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }
}
