package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorRuleGroup;", "Ljava/io/Serializable;", "maxScore", "", "minScore", "projectName", "", "ruleId", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getMaxScore", "()Ljava/lang/Double;", "setMaxScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMinScore", "setMinScore", "getProjectName", "()Ljava/lang/String;", "setProjectName", "(Ljava/lang/String;)V", "getRuleId", "setRuleId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/yd/android_brand_mvp/model/honor/HonorRuleGroup;", "equals", "", "other", "", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorRuleGroup implements Serializable {
    private Double maxScore;
    private Double minScore;
    private String projectName;
    private String ruleId;

    public static /* synthetic */ HonorRuleGroup copy$default(HonorRuleGroup honorRuleGroup, Double d, Double d2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = honorRuleGroup.maxScore;
        }
        if ((i & 2) != 0) {
            d2 = honorRuleGroup.minScore;
        }
        if ((i & 4) != 0) {
            str = honorRuleGroup.projectName;
        }
        if ((i & 8) != 0) {
            str2 = honorRuleGroup.ruleId;
        }
        return honorRuleGroup.copy(d, d2, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getMaxScore() {
        return this.maxScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getMinScore() {
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

    public final HonorRuleGroup copy(@JSONField(name = "maxScore") Double maxScore, @JSONField(name = "minScore") Double minScore, @JSONField(name = "projectName") String projectName, @JSONField(name = "ruleId") String ruleId) {
        return new HonorRuleGroup(maxScore, minScore, projectName, ruleId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorRuleGroup)) {
            return false;
        }
        HonorRuleGroup honorRuleGroup = (HonorRuleGroup) other;
        return Intrinsics.areEqual((Object) this.maxScore, (Object) honorRuleGroup.maxScore) && Intrinsics.areEqual((Object) this.minScore, (Object) honorRuleGroup.minScore) && Intrinsics.areEqual(this.projectName, honorRuleGroup.projectName) && Intrinsics.areEqual(this.ruleId, honorRuleGroup.ruleId);
    }

    public int hashCode() {
        Double d = this.maxScore;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.minScore;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str = this.projectName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ruleId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HonorRuleGroup(maxScore=" + this.maxScore + ", minScore=" + this.minScore + ", projectName=" + this.projectName + ", ruleId=" + this.ruleId + ')';
    }

    public HonorRuleGroup(@JSONField(name = "maxScore") Double d, @JSONField(name = "minScore") Double d2, @JSONField(name = "projectName") String str, @JSONField(name = "ruleId") String str2) {
        this.maxScore = d;
        this.minScore = d2;
        this.projectName = str;
        this.ruleId = str2;
    }

    public final Double getMaxScore() {
        return this.maxScore;
    }

    public final void setMaxScore(Double d) {
        this.maxScore = d;
    }

    public final Double getMinScore() {
        return this.minScore;
    }

    public final void setMinScore(Double d) {
        this.minScore = d;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final void setProjectName(String str) {
        this.projectName = str;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(String str) {
        this.ruleId = str;
    }
}
