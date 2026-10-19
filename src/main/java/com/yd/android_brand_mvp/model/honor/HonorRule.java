package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJT\u0010$\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u0006,"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorRule;", "Ljava/io/Serializable;", "ruleDescription", "", "ruleId", "ruleItem", "", "ruleScore", "option", "count", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOption", "setOption", "getRuleDescription", "()Ljava/lang/String;", "setRuleDescription", "(Ljava/lang/String;)V", "getRuleId", "setRuleId", "getRuleItem", "()I", "setRuleItem", "(I)V", "getRuleScore", "setRuleScore", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/yd/android_brand_mvp/model/honor/HonorRule;", "equals", "", "other", "", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorRule implements Serializable {
    private Integer count;
    private Integer option;
    private String ruleDescription;
    private String ruleId;
    private int ruleItem;
    private String ruleScore;

    public static /* synthetic */ HonorRule copy$default(HonorRule honorRule, String str, String str2, int i, String str3, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = honorRule.ruleDescription;
        }
        if ((i2 & 2) != 0) {
            str2 = honorRule.ruleId;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            i = honorRule.ruleItem;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = honorRule.ruleScore;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            num = honorRule.option;
        }
        Integer num3 = num;
        if ((i2 & 32) != 0) {
            num2 = honorRule.count;
        }
        return honorRule.copy(str, str4, i3, str5, num3, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRuleDescription() {
        return this.ruleDescription;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRuleId() {
        return this.ruleId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRuleItem() {
        return this.ruleItem;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRuleScore() {
        return this.ruleScore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getOption() {
        return this.option;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    public final HonorRule copy(@JSONField(name = "ruleDescription") String ruleDescription, @JSONField(name = "ruleId") String ruleId, @JSONField(name = "ruleItem") int ruleItem, @JSONField(name = "ruleScore") String ruleScore, @JSONField(name = "option") Integer option, Integer count) {
        return new HonorRule(ruleDescription, ruleId, ruleItem, ruleScore, option, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorRule)) {
            return false;
        }
        HonorRule honorRule = (HonorRule) other;
        return Intrinsics.areEqual(this.ruleDescription, honorRule.ruleDescription) && Intrinsics.areEqual(this.ruleId, honorRule.ruleId) && this.ruleItem == honorRule.ruleItem && Intrinsics.areEqual(this.ruleScore, honorRule.ruleScore) && Intrinsics.areEqual(this.option, honorRule.option) && Intrinsics.areEqual(this.count, honorRule.count);
    }

    public int hashCode() {
        String str = this.ruleDescription;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ruleId;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.ruleItem) * 31;
        String str3 = this.ruleScore;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.option;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.count;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "HonorRule(ruleDescription=" + this.ruleDescription + ", ruleId=" + this.ruleId + ", ruleItem=" + this.ruleItem + ", ruleScore=" + this.ruleScore + ", option=" + this.option + ", count=" + this.count + ')';
    }

    public HonorRule(@JSONField(name = "ruleDescription") String str, @JSONField(name = "ruleId") String str2, @JSONField(name = "ruleItem") int i, @JSONField(name = "ruleScore") String str3, @JSONField(name = "option") Integer num, Integer num2) {
        this.ruleDescription = str;
        this.ruleId = str2;
        this.ruleItem = i;
        this.ruleScore = str3;
        this.option = num;
        this.count = num2;
    }

    public /* synthetic */ HonorRule(String str, String str2, int i, String str3, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : num2);
    }

    public final String getRuleDescription() {
        return this.ruleDescription;
    }

    public final void setRuleDescription(String str) {
        this.ruleDescription = str;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(String str) {
        this.ruleId = str;
    }

    public final int getRuleItem() {
        return this.ruleItem;
    }

    public final void setRuleItem(int i) {
        this.ruleItem = i;
    }

    public final String getRuleScore() {
        return this.ruleScore;
    }

    public final void setRuleScore(String str) {
        this.ruleScore = str;
    }

    public final Integer getOption() {
        return this.option;
    }

    public final void setOption(Integer num) {
        this.option = num;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final void setCount(Integer num) {
        this.count = num;
    }
}
