package com.yd.android_brand_mvp.landscape.moraleducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurrentMEModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010$\u001a\u00020\u000fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0090\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u000200HÖ\u0001J\u0013\u00101\u001a\u00020\u000f2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000200HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000200HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "Landroid/os/Parcelable;", "mAvatar", "", "mHonorTitle", "mId", "mMedal", "mMedalUrl", "mName", "mCycle", "mSort", "mRanking", "mScore", "", "mWinPrize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Z)V", "getMAvatar", "()Ljava/lang/String;", "getMCycle", "getMHonorTitle", "getMId", "getMMedal", "getMMedalUrl", "getMName", "getMRanking", "setMRanking", "(Ljava/lang/String;)V", "getMScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMSort", "getMWinPrize", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Z)Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CurrentMEModel implements Parcelable {
    public static final Parcelable.Creator<CurrentMEModel> CREATOR = new Creator();

    @SerializedName("avatar")
    private final String mAvatar;

    @SerializedName("cycle")
    private final String mCycle;

    @SerializedName("honorTitle")
    private final String mHonorTitle;

    @SerializedName("id")
    private final String mId;

    @SerializedName("medal")
    private final String mMedal;

    @SerializedName("medalUrl")
    private final String mMedalUrl;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private final String mName;

    @SerializedName("ranking")
    private String mRanking;

    @SerializedName(FirebaseAnalytics.Param.SCORE)
    private final Float mScore;

    @SerializedName("sort")
    private final String mSort;

    @SerializedName("winPrize")
    private final boolean mWinPrize;

    /* JADX INFO: compiled from: CurrentMEModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CurrentMEModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrentMEModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CurrentMEModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrentMEModel[] newArray(int i) {
            return new CurrentMEModel[i];
        }
    }

    public CurrentMEModel() {
        this(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMAvatar() {
        return this.mAvatar;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Float getMScore() {
        return this.mScore;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getMWinPrize() {
        return this.mWinPrize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMHonorTitle() {
        return this.mHonorTitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMId() {
        return this.mId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMMedal() {
        return this.mMedal;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMMedalUrl() {
        return this.mMedalUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMName() {
        return this.mName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMCycle() {
        return this.mCycle;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMSort() {
        return this.mSort;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMRanking() {
        return this.mRanking;
    }

    public final CurrentMEModel copy(String mAvatar, String mHonorTitle, String mId, String mMedal, String mMedalUrl, String mName, String mCycle, String mSort, String mRanking, Float mScore, boolean mWinPrize) {
        return new CurrentMEModel(mAvatar, mHonorTitle, mId, mMedal, mMedalUrl, mName, mCycle, mSort, mRanking, mScore, mWinPrize);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentMEModel)) {
            return false;
        }
        CurrentMEModel currentMEModel = (CurrentMEModel) other;
        return Intrinsics.areEqual(this.mAvatar, currentMEModel.mAvatar) && Intrinsics.areEqual(this.mHonorTitle, currentMEModel.mHonorTitle) && Intrinsics.areEqual(this.mId, currentMEModel.mId) && Intrinsics.areEqual(this.mMedal, currentMEModel.mMedal) && Intrinsics.areEqual(this.mMedalUrl, currentMEModel.mMedalUrl) && Intrinsics.areEqual(this.mName, currentMEModel.mName) && Intrinsics.areEqual(this.mCycle, currentMEModel.mCycle) && Intrinsics.areEqual(this.mSort, currentMEModel.mSort) && Intrinsics.areEqual(this.mRanking, currentMEModel.mRanking) && Intrinsics.areEqual((Object) this.mScore, (Object) currentMEModel.mScore) && this.mWinPrize == currentMEModel.mWinPrize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.mAvatar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mHonorTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mMedal;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mMedalUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mName;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mCycle;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mSort;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.mRanking;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Float f = this.mScore;
        int iHashCode10 = (iHashCode9 + (f != null ? f.hashCode() : 0)) * 31;
        boolean z = this.mWinPrize;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode10 + r1;
    }

    public String toString() {
        return "CurrentMEModel(mAvatar=" + this.mAvatar + ", mHonorTitle=" + this.mHonorTitle + ", mId=" + this.mId + ", mMedal=" + this.mMedal + ", mMedalUrl=" + this.mMedalUrl + ", mName=" + this.mName + ", mCycle=" + this.mCycle + ", mSort=" + this.mSort + ", mRanking=" + this.mRanking + ", mScore=" + this.mScore + ", mWinPrize=" + this.mWinPrize + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mAvatar);
        parcel.writeString(this.mHonorTitle);
        parcel.writeString(this.mId);
        parcel.writeString(this.mMedal);
        parcel.writeString(this.mMedalUrl);
        parcel.writeString(this.mName);
        parcel.writeString(this.mCycle);
        parcel.writeString(this.mSort);
        parcel.writeString(this.mRanking);
        Float f = this.mScore;
        if (f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        }
        parcel.writeInt(this.mWinPrize ? 1 : 0);
    }

    public CurrentMEModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Float f, boolean z) {
        this.mAvatar = str;
        this.mHonorTitle = str2;
        this.mId = str3;
        this.mMedal = str4;
        this.mMedalUrl = str5;
        this.mName = str6;
        this.mCycle = str7;
        this.mSort = str8;
        this.mRanking = str9;
        this.mScore = f;
        this.mWinPrize = z;
    }

    public final String getMAvatar() {
        return this.mAvatar;
    }

    public final String getMHonorTitle() {
        return this.mHonorTitle;
    }

    public final String getMId() {
        return this.mId;
    }

    public final String getMMedal() {
        return this.mMedal;
    }

    public final String getMMedalUrl() {
        return this.mMedalUrl;
    }

    public final String getMName() {
        return this.mName;
    }

    public final String getMCycle() {
        return this.mCycle;
    }

    public final String getMSort() {
        return this.mSort;
    }

    public final String getMRanking() {
        return this.mRanking;
    }

    public final void setMRanking(String str) {
        this.mRanking = str;
    }

    public /* synthetic */ CurrentMEModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) == 0 ? str9 : "", (i & 512) != 0 ? Float.valueOf(0.0f) : f, (i & 1024) != 0 ? false : z);
    }

    public final Float getMScore() {
        return this.mScore;
    }

    public final boolean getMWinPrize() {
        return this.mWinPrize;
    }
}
