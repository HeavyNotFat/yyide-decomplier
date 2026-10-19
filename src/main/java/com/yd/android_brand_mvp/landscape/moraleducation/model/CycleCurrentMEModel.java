package com.yd.android_brand_mvp.landscape.moraleducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CycleCurrentMEModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "Landroid/os/Parcelable;", "mId", "", "mName", "mRanking", "", "mScore", "mHonorTitle", "mMedalUrl", "mWinPrize", "", "mAvatar", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getMAvatar", "()Ljava/lang/String;", "setMAvatar", "(Ljava/lang/String;)V", "getMHonorTitle", "getMId", "getMMedalUrl", "getMName", "getMRanking", "()I", "getMScore", "getMWinPrize", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CycleCurrentMEModel implements Parcelable {
    public static final Parcelable.Creator<CycleCurrentMEModel> CREATOR = new Creator();

    @SerializedName("avatar")
    private String mAvatar;

    @SerializedName("honorTitle")
    private final String mHonorTitle;

    @SerializedName("id")
    private final String mId;

    @SerializedName("medalUrl")
    private final String mMedalUrl;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private final String mName;

    @SerializedName("ranking")
    private final int mRanking;

    @SerializedName(FirebaseAnalytics.Param.SCORE)
    private final String mScore;

    @SerializedName("winPrize")
    private final boolean mWinPrize;

    /* JADX INFO: compiled from: CycleCurrentMEModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CycleCurrentMEModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CycleCurrentMEModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CycleCurrentMEModel(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CycleCurrentMEModel[] newArray(int i) {
            return new CycleCurrentMEModel[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMId() {
        return this.mId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMName() {
        return this.mName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMRanking() {
        return this.mRanking;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMScore() {
        return this.mScore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMHonorTitle() {
        return this.mHonorTitle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMMedalUrl() {
        return this.mMedalUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getMWinPrize() {
        return this.mWinPrize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMAvatar() {
        return this.mAvatar;
    }

    public final CycleCurrentMEModel copy(String mId, String mName, int mRanking, String mScore, String mHonorTitle, String mMedalUrl, boolean mWinPrize, String mAvatar) {
        Intrinsics.checkNotNullParameter(mId, "mId");
        Intrinsics.checkNotNullParameter(mName, "mName");
        Intrinsics.checkNotNullParameter(mScore, "mScore");
        Intrinsics.checkNotNullParameter(mAvatar, "mAvatar");
        return new CycleCurrentMEModel(mId, mName, mRanking, mScore, mHonorTitle, mMedalUrl, mWinPrize, mAvatar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CycleCurrentMEModel)) {
            return false;
        }
        CycleCurrentMEModel cycleCurrentMEModel = (CycleCurrentMEModel) other;
        return Intrinsics.areEqual(this.mId, cycleCurrentMEModel.mId) && Intrinsics.areEqual(this.mName, cycleCurrentMEModel.mName) && this.mRanking == cycleCurrentMEModel.mRanking && Intrinsics.areEqual(this.mScore, cycleCurrentMEModel.mScore) && Intrinsics.areEqual(this.mHonorTitle, cycleCurrentMEModel.mHonorTitle) && Intrinsics.areEqual(this.mMedalUrl, cycleCurrentMEModel.mMedalUrl) && this.mWinPrize == cycleCurrentMEModel.mWinPrize && Intrinsics.areEqual(this.mAvatar, cycleCurrentMEModel.mAvatar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = ((((((this.mId.hashCode() * 31) + this.mName.hashCode()) * 31) + this.mRanking) * 31) + this.mScore.hashCode()) * 31;
        String str = this.mHonorTitle;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mMedalUrl;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.mWinPrize;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode3 + r1) * 31) + this.mAvatar.hashCode();
    }

    public String toString() {
        return "CycleCurrentMEModel(mId=" + this.mId + ", mName=" + this.mName + ", mRanking=" + this.mRanking + ", mScore=" + this.mScore + ", mHonorTitle=" + this.mHonorTitle + ", mMedalUrl=" + this.mMedalUrl + ", mWinPrize=" + this.mWinPrize + ", mAvatar=" + this.mAvatar + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mRanking);
        parcel.writeString(this.mScore);
        parcel.writeString(this.mHonorTitle);
        parcel.writeString(this.mMedalUrl);
        parcel.writeInt(this.mWinPrize ? 1 : 0);
        parcel.writeString(this.mAvatar);
    }

    public CycleCurrentMEModel(String mId, String mName, int i, String mScore, String str, String str2, boolean z, String mAvatar) {
        Intrinsics.checkNotNullParameter(mId, "mId");
        Intrinsics.checkNotNullParameter(mName, "mName");
        Intrinsics.checkNotNullParameter(mScore, "mScore");
        Intrinsics.checkNotNullParameter(mAvatar, "mAvatar");
        this.mId = mId;
        this.mName = mName;
        this.mRanking = i;
        this.mScore = mScore;
        this.mHonorTitle = str;
        this.mMedalUrl = str2;
        this.mWinPrize = z;
        this.mAvatar = mAvatar;
    }

    public /* synthetic */ CycleCurrentMEModel(String str, String str2, int i, String str3, String str4, String str5, boolean z, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, str4, str5, (i2 & 64) != 0 ? false : z, str6);
    }

    public final String getMId() {
        return this.mId;
    }

    public final String getMName() {
        return this.mName;
    }

    public final int getMRanking() {
        return this.mRanking;
    }

    public final String getMScore() {
        return this.mScore;
    }

    public final String getMHonorTitle() {
        return this.mHonorTitle;
    }

    public final String getMMedalUrl() {
        return this.mMedalUrl;
    }

    public final boolean getMWinPrize() {
        return this.mWinPrize;
    }

    public final String getMAvatar() {
        return this.mAvatar;
    }

    public final void setMAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mAvatar = str;
    }
}
