package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherRsp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020+HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020+HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u00067"}, d2 = {"Lcom/yd/android_brand_mvp/model/CastsDTO;", "Landroid/os/Parcelable;", "date", "", "week", "dayweather", "nightweather", "daytemp", "nighttemp", "daywind", "nightwind", "daypower", "nightpower", "daytemp_float", "nighttemp_float", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDaypower", "getDaytemp", "getDaytemp_float", "getDayweather", "getDaywind", "getNightpower", "getNighttemp", "getNighttemp_float", "getNightweather", "getNightwind", "getWeek", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CastsDTO implements Parcelable {
    public static final Parcelable.Creator<CastsDTO> CREATOR = new Creator();
    private final String date;
    private final String daypower;
    private final String daytemp;
    private final String daytemp_float;
    private final String dayweather;
    private final String daywind;
    private final String nightpower;
    private final String nighttemp;
    private final String nighttemp_float;
    private final String nightweather;
    private final String nightwind;
    private final String week;

    /* JADX INFO: compiled from: NewWeatherRsp.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CastsDTO> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CastsDTO createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CastsDTO(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CastsDTO[] newArray(int i) {
            return new CastsDTO[i];
        }
    }

    public CastsDTO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getNightpower() {
        return this.nightpower;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDaytemp_float() {
        return this.daytemp_float;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getNighttemp_float() {
        return this.nighttemp_float;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getWeek() {
        return this.week;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDayweather() {
        return this.dayweather;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNightweather() {
        return this.nightweather;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDaytemp() {
        return this.daytemp;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNighttemp() {
        return this.nighttemp;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDaywind() {
        return this.daywind;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNightwind() {
        return this.nightwind;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDaypower() {
        return this.daypower;
    }

    public final CastsDTO copy(String date, String week, String dayweather, String nightweather, String daytemp, String nighttemp, String daywind, String nightwind, String daypower, String nightpower, String daytemp_float, String nighttemp_float) {
        return new CastsDTO(date, week, dayweather, nightweather, daytemp, nighttemp, daywind, nightwind, daypower, nightpower, daytemp_float, nighttemp_float);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CastsDTO)) {
            return false;
        }
        CastsDTO castsDTO = (CastsDTO) other;
        return Intrinsics.areEqual(this.date, castsDTO.date) && Intrinsics.areEqual(this.week, castsDTO.week) && Intrinsics.areEqual(this.dayweather, castsDTO.dayweather) && Intrinsics.areEqual(this.nightweather, castsDTO.nightweather) && Intrinsics.areEqual(this.daytemp, castsDTO.daytemp) && Intrinsics.areEqual(this.nighttemp, castsDTO.nighttemp) && Intrinsics.areEqual(this.daywind, castsDTO.daywind) && Intrinsics.areEqual(this.nightwind, castsDTO.nightwind) && Intrinsics.areEqual(this.daypower, castsDTO.daypower) && Intrinsics.areEqual(this.nightpower, castsDTO.nightpower) && Intrinsics.areEqual(this.daytemp_float, castsDTO.daytemp_float) && Intrinsics.areEqual(this.nighttemp_float, castsDTO.nighttemp_float);
    }

    public int hashCode() {
        String str = this.date;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.week;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dayweather;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nightweather;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.daytemp;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.nighttemp;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.daywind;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.nightwind;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.daypower;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.nightpower;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.daytemp_float;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.nighttemp_float;
        return iHashCode11 + (str12 != null ? str12.hashCode() : 0);
    }

    public String toString() {
        return "CastsDTO(date=" + this.date + ", week=" + this.week + ", dayweather=" + this.dayweather + ", nightweather=" + this.nightweather + ", daytemp=" + this.daytemp + ", nighttemp=" + this.nighttemp + ", daywind=" + this.daywind + ", nightwind=" + this.nightwind + ", daypower=" + this.daypower + ", nightpower=" + this.nightpower + ", daytemp_float=" + this.daytemp_float + ", nighttemp_float=" + this.nighttemp_float + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.date);
        parcel.writeString(this.week);
        parcel.writeString(this.dayweather);
        parcel.writeString(this.nightweather);
        parcel.writeString(this.daytemp);
        parcel.writeString(this.nighttemp);
        parcel.writeString(this.daywind);
        parcel.writeString(this.nightwind);
        parcel.writeString(this.daypower);
        parcel.writeString(this.nightpower);
        parcel.writeString(this.daytemp_float);
        parcel.writeString(this.nighttemp_float);
    }

    public CastsDTO(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.date = str;
        this.week = str2;
        this.dayweather = str3;
        this.nightweather = str4;
        this.daytemp = str5;
        this.nighttemp = str6;
        this.daywind = str7;
        this.nightwind = str8;
        this.daypower = str9;
        this.nightpower = str10;
        this.daytemp_float = str11;
        this.nighttemp_float = str12;
    }

    public /* synthetic */ CastsDTO(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) == 0 ? str12 : null);
    }

    public final String getDate() {
        return this.date;
    }

    public final String getWeek() {
        return this.week;
    }

    public final String getDayweather() {
        return this.dayweather;
    }

    public final String getNightweather() {
        return this.nightweather;
    }

    public final String getDaytemp() {
        return this.daytemp;
    }

    public final String getNighttemp() {
        return this.nighttemp;
    }

    public final String getDaywind() {
        return this.daywind;
    }

    public final String getNightwind() {
        return this.nightwind;
    }

    public final String getDaypower() {
        return this.daypower;
    }

    public final String getNightpower() {
        return this.nightpower;
    }

    public final String getDaytemp_float() {
        return this.daytemp_float;
    }

    public final String getNighttemp_float() {
        return this.nighttemp_float;
    }
}
