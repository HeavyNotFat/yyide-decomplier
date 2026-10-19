package com.yd.android_brand_mvp.landscape.moraleducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubAppraisalScoreParamModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/SubAppraisalScoreParamModel;", "Landroid/os/Parcelable;", "standardId", "", "scoreValue", "remark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRemark", "()Ljava/lang/String;", "setRemark", "(Ljava/lang/String;)V", "getScoreValue", "setScoreValue", "getStandardId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubAppraisalScoreParamModel implements Parcelable {
    public static final Parcelable.Creator<SubAppraisalScoreParamModel> CREATOR = new Creator();
    private String remark;
    private String scoreValue;
    private final String standardId;

    /* JADX INFO: compiled from: SubAppraisalScoreParamModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubAppraisalScoreParamModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubAppraisalScoreParamModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubAppraisalScoreParamModel(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubAppraisalScoreParamModel[] newArray(int i) {
            return new SubAppraisalScoreParamModel[i];
        }
    }

    public static /* synthetic */ SubAppraisalScoreParamModel copy$default(SubAppraisalScoreParamModel subAppraisalScoreParamModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subAppraisalScoreParamModel.standardId;
        }
        if ((i & 2) != 0) {
            str2 = subAppraisalScoreParamModel.scoreValue;
        }
        if ((i & 4) != 0) {
            str3 = subAppraisalScoreParamModel.remark;
        }
        return subAppraisalScoreParamModel.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStandardId() {
        return this.standardId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScoreValue() {
        return this.scoreValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    public final SubAppraisalScoreParamModel copy(String standardId, String scoreValue, String remark) {
        Intrinsics.checkNotNullParameter(standardId, "standardId");
        Intrinsics.checkNotNullParameter(scoreValue, "scoreValue");
        Intrinsics.checkNotNullParameter(remark, "remark");
        return new SubAppraisalScoreParamModel(standardId, scoreValue, remark);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubAppraisalScoreParamModel)) {
            return false;
        }
        SubAppraisalScoreParamModel subAppraisalScoreParamModel = (SubAppraisalScoreParamModel) other;
        return Intrinsics.areEqual(this.standardId, subAppraisalScoreParamModel.standardId) && Intrinsics.areEqual(this.scoreValue, subAppraisalScoreParamModel.scoreValue) && Intrinsics.areEqual(this.remark, subAppraisalScoreParamModel.remark);
    }

    public int hashCode() {
        return (((this.standardId.hashCode() * 31) + this.scoreValue.hashCode()) * 31) + this.remark.hashCode();
    }

    public String toString() {
        return "SubAppraisalScoreParamModel(standardId=" + this.standardId + ", scoreValue=" + this.scoreValue + ", remark=" + this.remark + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.standardId);
        parcel.writeString(this.scoreValue);
        parcel.writeString(this.remark);
    }

    public SubAppraisalScoreParamModel(String standardId, String scoreValue, String remark) {
        Intrinsics.checkNotNullParameter(standardId, "standardId");
        Intrinsics.checkNotNullParameter(scoreValue, "scoreValue");
        Intrinsics.checkNotNullParameter(remark, "remark");
        this.standardId = standardId;
        this.scoreValue = scoreValue;
        this.remark = remark;
    }

    public final String getStandardId() {
        return this.standardId;
    }

    public final String getScoreValue() {
        return this.scoreValue;
    }

    public final void setScoreValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scoreValue = str;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final void setRemark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remark = str;
    }
}
