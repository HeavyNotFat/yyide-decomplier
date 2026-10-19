package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorGoCommentBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001c\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u001c\b\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorGoCommentBean;", "Ljava/io/Serializable;", "canScore", "", "canScoreGrade", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreGrade;", "Lkotlin/collections/ArrayList;", "canScoreStudent", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreStudent;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "getCanScore", "()Z", "setCanScore", "(Z)V", "getCanScoreGrade", "()Ljava/util/ArrayList;", "setCanScoreGrade", "(Ljava/util/ArrayList;)V", "getCanScoreStudent", "setCanScoreStudent", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorGoCommentBean implements Serializable {
    private boolean canScore;
    private ArrayList<HonorCanScoreGrade> canScoreGrade;
    private ArrayList<HonorCanScoreStudent> canScoreStudent;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HonorGoCommentBean copy$default(HonorGoCommentBean honorGoCommentBean, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = honorGoCommentBean.canScore;
        }
        if ((i & 2) != 0) {
            arrayList = honorGoCommentBean.canScoreGrade;
        }
        if ((i & 4) != 0) {
            arrayList2 = honorGoCommentBean.canScoreStudent;
        }
        return honorGoCommentBean.copy(z, arrayList, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanScore() {
        return this.canScore;
    }

    public final ArrayList<HonorCanScoreGrade> component2() {
        return this.canScoreGrade;
    }

    public final ArrayList<HonorCanScoreStudent> component3() {
        return this.canScoreStudent;
    }

    public final HonorGoCommentBean copy(@JSONField(name = "canScore") boolean canScore, @JSONField(name = "canScoreGrade") ArrayList<HonorCanScoreGrade> canScoreGrade, @JSONField(name = "canScoreStudent") ArrayList<HonorCanScoreStudent> canScoreStudent) {
        return new HonorGoCommentBean(canScore, canScoreGrade, canScoreStudent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorGoCommentBean)) {
            return false;
        }
        HonorGoCommentBean honorGoCommentBean = (HonorGoCommentBean) other;
        return this.canScore == honorGoCommentBean.canScore && Intrinsics.areEqual(this.canScoreGrade, honorGoCommentBean.canScoreGrade) && Intrinsics.areEqual(this.canScoreStudent, honorGoCommentBean.canScoreStudent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.canScore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ArrayList<HonorCanScoreGrade> arrayList = this.canScoreGrade;
        int iHashCode = (i + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<HonorCanScoreStudent> arrayList2 = this.canScoreStudent;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public String toString() {
        return "HonorGoCommentBean(canScore=" + this.canScore + ", canScoreGrade=" + this.canScoreGrade + ", canScoreStudent=" + this.canScoreStudent + ')';
    }

    public HonorGoCommentBean(@JSONField(name = "canScore") boolean z, @JSONField(name = "canScoreGrade") ArrayList<HonorCanScoreGrade> arrayList, @JSONField(name = "canScoreStudent") ArrayList<HonorCanScoreStudent> arrayList2) {
        this.canScore = z;
        this.canScoreGrade = arrayList;
        this.canScoreStudent = arrayList2;
    }

    public /* synthetic */ HonorGoCommentBean(boolean z, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : arrayList, (i & 4) != 0 ? null : arrayList2);
    }

    public final boolean getCanScore() {
        return this.canScore;
    }

    public final void setCanScore(boolean z) {
        this.canScore = z;
    }

    public final ArrayList<HonorCanScoreGrade> getCanScoreGrade() {
        return this.canScoreGrade;
    }

    public final void setCanScoreGrade(ArrayList<HonorCanScoreGrade> arrayList) {
        this.canScoreGrade = arrayList;
    }

    public final ArrayList<HonorCanScoreStudent> getCanScoreStudent() {
        return this.canScoreStudent;
    }

    public final void setCanScoreStudent(ArrayList<HonorCanScoreStudent> arrayList) {
        this.canScoreStudent = arrayList;
    }
}
