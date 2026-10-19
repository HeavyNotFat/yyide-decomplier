package com.yd.android_brand_mvp.landscape.moraleducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScoringDetailCycleModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0085\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020(HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020(HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00064"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "Landroid/os/Parcelable;", "mCycle", "", "mCycleId", "mDate", "mLineList", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailModel;", "mScore", "mTargetId", "mTotalAddScore", "mTotalScore", "mTotalSubtractScore", "mWeek", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMCycle", "()Ljava/lang/String;", "getMCycleId", "getMDate", "getMLineList", "()Ljava/util/List;", "getMScore", "getMTargetId", "getMTotalAddScore", "getMTotalScore", "getMTotalSubtractScore", "getMWeek", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ScoringDetailCycleModel implements Parcelable {
    public static final Parcelable.Creator<ScoringDetailCycleModel> CREATOR = new Creator();

    @SerializedName("cycle")
    private final String mCycle;

    @SerializedName("cycleId")
    private final String mCycleId;

    @SerializedName("date")
    private final String mDate;

    @SerializedName("lineList")
    private final List<ScoringDetailModel> mLineList;

    @SerializedName(FirebaseAnalytics.Param.SCORE)
    private final String mScore;

    @SerializedName("targetId")
    private final String mTargetId;

    @SerializedName("totalAddScore")
    private final String mTotalAddScore;

    @SerializedName("totalScore")
    private final String mTotalScore;

    @SerializedName("totalSubtractScore")
    private final String mTotalSubtractScore;

    @SerializedName("week")
    private final String mWeek;

    /* JADX INFO: compiled from: ScoringDetailCycleModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ScoringDetailCycleModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScoringDetailCycleModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(ScoringDetailModel.CREATOR.createFromParcel(parcel));
            }
            return new ScoringDetailCycleModel(string, string2, string3, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScoringDetailCycleModel[] newArray(int i) {
            return new ScoringDetailCycleModel[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMCycle() {
        return this.mCycle;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMWeek() {
        return this.mWeek;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMCycleId() {
        return this.mCycleId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMDate() {
        return this.mDate;
    }

    public final List<ScoringDetailModel> component4() {
        return this.mLineList;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMScore() {
        return this.mScore;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMTargetId() {
        return this.mTargetId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMTotalAddScore() {
        return this.mTotalAddScore;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMTotalScore() {
        return this.mTotalScore;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMTotalSubtractScore() {
        return this.mTotalSubtractScore;
    }

    public final ScoringDetailCycleModel copy(String mCycle, String mCycleId, String mDate, List<ScoringDetailModel> mLineList, String mScore, String mTargetId, String mTotalAddScore, String mTotalScore, String mTotalSubtractScore, String mWeek) {
        Intrinsics.checkNotNullParameter(mLineList, "mLineList");
        return new ScoringDetailCycleModel(mCycle, mCycleId, mDate, mLineList, mScore, mTargetId, mTotalAddScore, mTotalScore, mTotalSubtractScore, mWeek);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScoringDetailCycleModel)) {
            return false;
        }
        ScoringDetailCycleModel scoringDetailCycleModel = (ScoringDetailCycleModel) other;
        return Intrinsics.areEqual(this.mCycle, scoringDetailCycleModel.mCycle) && Intrinsics.areEqual(this.mCycleId, scoringDetailCycleModel.mCycleId) && Intrinsics.areEqual(this.mDate, scoringDetailCycleModel.mDate) && Intrinsics.areEqual(this.mLineList, scoringDetailCycleModel.mLineList) && Intrinsics.areEqual(this.mScore, scoringDetailCycleModel.mScore) && Intrinsics.areEqual(this.mTargetId, scoringDetailCycleModel.mTargetId) && Intrinsics.areEqual(this.mTotalAddScore, scoringDetailCycleModel.mTotalAddScore) && Intrinsics.areEqual(this.mTotalScore, scoringDetailCycleModel.mTotalScore) && Intrinsics.areEqual(this.mTotalSubtractScore, scoringDetailCycleModel.mTotalSubtractScore) && Intrinsics.areEqual(this.mWeek, scoringDetailCycleModel.mWeek);
    }

    public int hashCode() {
        String str = this.mCycle;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mCycleId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mDate;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.mLineList.hashCode()) * 31;
        String str4 = this.mScore;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mTargetId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mTotalAddScore;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mTotalScore;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mTotalSubtractScore;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.mWeek;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "ScoringDetailCycleModel(mCycle=" + this.mCycle + ", mCycleId=" + this.mCycleId + ", mDate=" + this.mDate + ", mLineList=" + this.mLineList + ", mScore=" + this.mScore + ", mTargetId=" + this.mTargetId + ", mTotalAddScore=" + this.mTotalAddScore + ", mTotalScore=" + this.mTotalScore + ", mTotalSubtractScore=" + this.mTotalSubtractScore + ", mWeek=" + this.mWeek + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mCycle);
        parcel.writeString(this.mCycleId);
        parcel.writeString(this.mDate);
        List<ScoringDetailModel> list = this.mLineList;
        parcel.writeInt(list.size());
        Iterator<ScoringDetailModel> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.mScore);
        parcel.writeString(this.mTargetId);
        parcel.writeString(this.mTotalAddScore);
        parcel.writeString(this.mTotalScore);
        parcel.writeString(this.mTotalSubtractScore);
        parcel.writeString(this.mWeek);
    }

    public ScoringDetailCycleModel(String str, String str2, String str3, List<ScoringDetailModel> mLineList, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(mLineList, "mLineList");
        this.mCycle = str;
        this.mCycleId = str2;
        this.mDate = str3;
        this.mLineList = mLineList;
        this.mScore = str4;
        this.mTargetId = str5;
        this.mTotalAddScore = str6;
        this.mTotalScore = str7;
        this.mTotalSubtractScore = str8;
        this.mWeek = str9;
    }

    public /* synthetic */ ScoringDetailCycleModel(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, str8, (i & 512) != 0 ? null : str9);
    }

    public final String getMCycle() {
        return this.mCycle;
    }

    public final String getMCycleId() {
        return this.mCycleId;
    }

    public final String getMDate() {
        return this.mDate;
    }

    public final List<ScoringDetailModel> getMLineList() {
        return this.mLineList;
    }

    public final String getMScore() {
        return this.mScore;
    }

    public final String getMTargetId() {
        return this.mTargetId;
    }

    public final String getMTotalAddScore() {
        return this.mTotalAddScore;
    }

    public final String getMTotalScore() {
        return this.mTotalScore;
    }

    public final String getMTotalSubtractScore() {
        return this.mTotalSubtractScore;
    }

    public final String getMWeek() {
        return this.mWeek;
    }
}
