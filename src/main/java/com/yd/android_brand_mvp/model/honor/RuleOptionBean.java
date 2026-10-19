package com.yd.android_brand_mvp.model.honor;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.yaoxiaowen.download.config.InnerConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RuleOptionBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J&\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0018H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "ruleScore", "", "ruleId", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getRuleId", "()Ljava/lang/String;", "setRuleId", "(Ljava/lang/String;)V", "getRuleScore", "()Ljava/lang/Double;", "setRuleScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RuleOptionBean implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String ruleId;
    private Double ruleScore;

    public static /* synthetic */ RuleOptionBean copy$default(RuleOptionBean ruleOptionBean, Double d, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = ruleOptionBean.ruleScore;
        }
        if ((i & 2) != 0) {
            str = ruleOptionBean.ruleId;
        }
        return ruleOptionBean.copy(d, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getRuleScore() {
        return this.ruleScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRuleId() {
        return this.ruleId;
    }

    public final RuleOptionBean copy(@JSONField(name = "ruleScore") Double ruleScore, @JSONField(name = "ruleId") String ruleId) {
        return new RuleOptionBean(ruleScore, ruleId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleOptionBean)) {
            return false;
        }
        RuleOptionBean ruleOptionBean = (RuleOptionBean) other;
        return Intrinsics.areEqual((Object) this.ruleScore, (Object) ruleOptionBean.ruleScore) && Intrinsics.areEqual(this.ruleId, ruleOptionBean.ruleId);
    }

    public int hashCode() {
        Double d = this.ruleScore;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        String str = this.ruleId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "RuleOptionBean(ruleScore=" + this.ruleScore + ", ruleId=" + this.ruleId + ')';
    }

    public RuleOptionBean(@JSONField(name = "ruleScore") Double d, @JSONField(name = "ruleId") String str) {
        this.ruleScore = d;
        this.ruleId = str;
    }

    public final Double getRuleScore() {
        return this.ruleScore;
    }

    public final void setRuleScore(Double d) {
        this.ruleScore = d;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(String str) {
        this.ruleId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RuleOptionBean(Parcel parcel) {
        this(Double.valueOf(parcel.readDouble()), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Double d = this.ruleScore;
        Intrinsics.checkNotNull(d);
        parcel.writeDouble(d.doubleValue());
        parcel.writeString(this.ruleId);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.model.honor.RuleOptionBean$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: RuleOptionBean.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", InnerConstant.Db.size, "", "(I)[Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<RuleOptionBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RuleOptionBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RuleOptionBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RuleOptionBean[] newArray(int size) {
            return new RuleOptionBean[size];
        }
    }
}
