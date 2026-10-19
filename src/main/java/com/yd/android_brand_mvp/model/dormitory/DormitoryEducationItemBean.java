package com.yd.android_brand_mvp.model.dormitory;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DormitoryEducationItemBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationItemBean;", "", "targetName", "", "goal", "targetId", "ranking", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGoal", "()Ljava/lang/String;", "getRanking", "getTargetId", "getTargetName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormitoryEducationItemBean {
    private final String goal;
    private final String ranking;
    private final String targetId;
    private final String targetName;

    public DormitoryEducationItemBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DormitoryEducationItemBean copy$default(DormitoryEducationItemBean dormitoryEducationItemBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dormitoryEducationItemBean.targetName;
        }
        if ((i & 2) != 0) {
            str2 = dormitoryEducationItemBean.goal;
        }
        if ((i & 4) != 0) {
            str3 = dormitoryEducationItemBean.targetId;
        }
        if ((i & 8) != 0) {
            str4 = dormitoryEducationItemBean.ranking;
        }
        return dormitoryEducationItemBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTargetName() {
        return this.targetName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoal() {
        return this.goal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTargetId() {
        return this.targetId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRanking() {
        return this.ranking;
    }

    public final DormitoryEducationItemBean copy(String targetName, String goal, String targetId, String ranking) {
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        Intrinsics.checkNotNullParameter(goal, "goal");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(ranking, "ranking");
        return new DormitoryEducationItemBean(targetName, goal, targetId, ranking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormitoryEducationItemBean)) {
            return false;
        }
        DormitoryEducationItemBean dormitoryEducationItemBean = (DormitoryEducationItemBean) other;
        return Intrinsics.areEqual(this.targetName, dormitoryEducationItemBean.targetName) && Intrinsics.areEqual(this.goal, dormitoryEducationItemBean.goal) && Intrinsics.areEqual(this.targetId, dormitoryEducationItemBean.targetId) && Intrinsics.areEqual(this.ranking, dormitoryEducationItemBean.ranking);
    }

    public int hashCode() {
        return (((((this.targetName.hashCode() * 31) + this.goal.hashCode()) * 31) + this.targetId.hashCode()) * 31) + this.ranking.hashCode();
    }

    public String toString() {
        return "DormitoryEducationItemBean(targetName=" + this.targetName + ", goal=" + this.goal + ", targetId=" + this.targetId + ", ranking=" + this.ranking + ')';
    }

    public DormitoryEducationItemBean(String targetName, String goal, String targetId, String ranking) {
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        Intrinsics.checkNotNullParameter(goal, "goal");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(ranking, "ranking");
        this.targetName = targetName;
        this.goal = goal;
        this.targetId = targetId;
        this.ranking = ranking;
    }

    public /* synthetic */ DormitoryEducationItemBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final String getGoal() {
        return this.goal;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final String getRanking() {
        return this.ranking;
    }
}
