package com.yd.android_brand_mvp.landscape.moraleducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScoringDetailModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailModel;", "Landroid/os/Parcelable;", "mCreateTime", "", "mFirstIndicator", "mGroupName", "mRemark", "mScore", "mSecondIndicator", "mSeq", "mStandard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMCreateTime", "()Ljava/lang/String;", "getMFirstIndicator", "getMGroupName", "getMRemark", "getMScore", "getMSecondIndicator", "getMSeq", "getMStandard", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ScoringDetailModel implements Parcelable {
    public static final Parcelable.Creator<ScoringDetailModel> CREATOR = new Creator();

    @SerializedName("createTime")
    private final String mCreateTime;

    @SerializedName("firstIndicator")
    private final String mFirstIndicator;

    @SerializedName("groupName")
    private final String mGroupName;

    @SerializedName("remark")
    private final String mRemark;

    @SerializedName(FirebaseAnalytics.Param.SCORE)
    private final String mScore;

    @SerializedName("secondIndicator")
    private final String mSecondIndicator;

    @SerializedName("seq")
    private final String mSeq;

    @SerializedName("standard")
    private final String mStandard;

    /* JADX INFO: compiled from: ScoringDetailModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ScoringDetailModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScoringDetailModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScoringDetailModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScoringDetailModel[] newArray(int i) {
            return new ScoringDetailModel[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMCreateTime() {
        return this.mCreateTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMFirstIndicator() {
        return this.mFirstIndicator;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMGroupName() {
        return this.mGroupName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMRemark() {
        return this.mRemark;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMScore() {
        return this.mScore;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMSecondIndicator() {
        return this.mSecondIndicator;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMSeq() {
        return this.mSeq;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMStandard() {
        return this.mStandard;
    }

    public final ScoringDetailModel copy(String mCreateTime, String mFirstIndicator, String mGroupName, String mRemark, String mScore, String mSecondIndicator, String mSeq, String mStandard) {
        return new ScoringDetailModel(mCreateTime, mFirstIndicator, mGroupName, mRemark, mScore, mSecondIndicator, mSeq, mStandard);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScoringDetailModel)) {
            return false;
        }
        ScoringDetailModel scoringDetailModel = (ScoringDetailModel) other;
        return Intrinsics.areEqual(this.mCreateTime, scoringDetailModel.mCreateTime) && Intrinsics.areEqual(this.mFirstIndicator, scoringDetailModel.mFirstIndicator) && Intrinsics.areEqual(this.mGroupName, scoringDetailModel.mGroupName) && Intrinsics.areEqual(this.mRemark, scoringDetailModel.mRemark) && Intrinsics.areEqual(this.mScore, scoringDetailModel.mScore) && Intrinsics.areEqual(this.mSecondIndicator, scoringDetailModel.mSecondIndicator) && Intrinsics.areEqual(this.mSeq, scoringDetailModel.mSeq) && Intrinsics.areEqual(this.mStandard, scoringDetailModel.mStandard);
    }

    public int hashCode() {
        String str = this.mCreateTime;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mFirstIndicator;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mGroupName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mRemark;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mScore;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mSecondIndicator;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mSeq;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mStandard;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "ScoringDetailModel(mCreateTime=" + this.mCreateTime + ", mFirstIndicator=" + this.mFirstIndicator + ", mGroupName=" + this.mGroupName + ", mRemark=" + this.mRemark + ", mScore=" + this.mScore + ", mSecondIndicator=" + this.mSecondIndicator + ", mSeq=" + this.mSeq + ", mStandard=" + this.mStandard + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mCreateTime);
        parcel.writeString(this.mFirstIndicator);
        parcel.writeString(this.mGroupName);
        parcel.writeString(this.mRemark);
        parcel.writeString(this.mScore);
        parcel.writeString(this.mSecondIndicator);
        parcel.writeString(this.mSeq);
        parcel.writeString(this.mStandard);
    }

    public ScoringDetailModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.mCreateTime = str;
        this.mFirstIndicator = str2;
        this.mGroupName = str3;
        this.mRemark = str4;
        this.mScore = str5;
        this.mSecondIndicator = str6;
        this.mSeq = str7;
        this.mStandard = str8;
    }

    public final String getMCreateTime() {
        return this.mCreateTime;
    }

    public final String getMFirstIndicator() {
        return this.mFirstIndicator;
    }

    public final String getMGroupName() {
        return this.mGroupName;
    }

    public final String getMRemark() {
        return this.mRemark;
    }

    public final String getMScore() {
        return this.mScore;
    }

    public final String getMSecondIndicator() {
        return this.mSecondIndicator;
    }

    public final String getMSeq() {
        return this.mSeq;
    }

    public final String getMStandard() {
        return this.mStandard;
    }
}
