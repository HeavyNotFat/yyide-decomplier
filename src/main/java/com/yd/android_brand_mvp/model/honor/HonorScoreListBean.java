package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.C$r8$backportedMethods$utility$Double$1$hashCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorScoreListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017JB\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorScoreListBean;", "", "maxScore", "", "minScore", "projectName", "", "ruleId", "writeScore", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getMaxScore", "()D", "setMaxScore", "(D)V", "getMinScore", "setMinScore", "getProjectName", "()Ljava/lang/String;", "setProjectName", "(Ljava/lang/String;)V", "getRuleId", "setRuleId", "getWriteScore", "()Ljava/lang/Double;", "setWriteScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "copy", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/yd/android_brand_mvp/model/honor/HonorScoreListBean;", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorScoreListBean {
    private double maxScore;
    private double minScore;
    private String projectName;
    private String ruleId;
    private Double writeScore;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getMaxScore() {
        return this.maxScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getMinScore() {
        return this.minScore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProjectName() {
        return this.projectName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRuleId() {
        return this.ruleId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getWriteScore() {
        return this.writeScore;
    }

    public final HonorScoreListBean copy(@JSONField(name = "maxScore") double maxScore, @JSONField(name = "minScore") double minScore, @JSONField(name = "projectName") String projectName, @JSONField(name = "ruleId") String ruleId, @JSONField(name = "writeScore") Double writeScore) {
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(ruleId, "ruleId");
        return new HonorScoreListBean(maxScore, minScore, projectName, ruleId, writeScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorScoreListBean)) {
            return false;
        }
        HonorScoreListBean honorScoreListBean = (HonorScoreListBean) other;
        return Double.compare(this.maxScore, honorScoreListBean.maxScore) == 0 && Double.compare(this.minScore, honorScoreListBean.minScore) == 0 && Intrinsics.areEqual(this.projectName, honorScoreListBean.projectName) && Intrinsics.areEqual(this.ruleId, honorScoreListBean.ruleId) && Intrinsics.areEqual((Object) this.writeScore, (Object) honorScoreListBean.writeScore);
    }

    public int hashCode() {
        int iHashCode = ((((((C$r8$backportedMethods$utility$Double$1$hashCode.hashCode(this.maxScore) * 31) + C$r8$backportedMethods$utility$Double$1$hashCode.hashCode(this.minScore)) * 31) + this.projectName.hashCode()) * 31) + this.ruleId.hashCode()) * 31;
        Double d = this.writeScore;
        return iHashCode + (d == null ? 0 : d.hashCode());
    }

    public String toString() {
        return "HonorScoreListBean(maxScore=" + this.maxScore + ", minScore=" + this.minScore + ", projectName=" + this.projectName + ", ruleId=" + this.ruleId + ", writeScore=" + this.writeScore + ')';
    }

    public HonorScoreListBean(@JSONField(name = "maxScore") double d, @JSONField(name = "minScore") double d2, @JSONField(name = "projectName") String projectName, @JSONField(name = "ruleId") String ruleId, @JSONField(name = "writeScore") Double d3) {
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(ruleId, "ruleId");
        this.maxScore = d;
        this.minScore = d2;
        this.projectName = projectName;
        this.ruleId = ruleId;
        this.writeScore = d3;
    }

    public final double getMaxScore() {
        return this.maxScore;
    }

    public final void setMaxScore(double d) {
        this.maxScore = d;
    }

    public final double getMinScore() {
        return this.minScore;
    }

    public final void setMinScore(double d) {
        this.minScore = d;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final void setProjectName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.projectName = str;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ruleId = str;
    }

    public final Double getWriteScore() {
        return this.writeScore;
    }

    public final void setWriteScore(Double d) {
        this.writeScore = d;
    }
}
