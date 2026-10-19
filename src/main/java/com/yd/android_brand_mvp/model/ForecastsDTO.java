package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherRsp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/ForecastsDTO;", "Landroid/os/Parcelable;", "city", "", "adcode", "province", "reporttime", "casts", "", "Lcom/yd/android_brand_mvp/model/CastsDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAdcode", "()Ljava/lang/String;", "getCasts", "()Ljava/util/List;", "getCity", "getProvince", "getReporttime", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ForecastsDTO implements Parcelable {
    public static final Parcelable.Creator<ForecastsDTO> CREATOR = new Creator();
    private final String adcode;
    private final List<CastsDTO> casts;
    private final String city;
    private final String province;
    private final String reporttime;

    /* JADX INFO: compiled from: NewWeatherRsp.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ForecastsDTO> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ForecastsDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(CastsDTO.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new ForecastsDTO(string, string2, string3, string4, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ForecastsDTO[] newArray(int i) {
            return new ForecastsDTO[i];
        }
    }

    public ForecastsDTO() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForecastsDTO copy$default(ForecastsDTO forecastsDTO, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = forecastsDTO.city;
        }
        if ((i & 2) != 0) {
            str2 = forecastsDTO.adcode;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = forecastsDTO.province;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = forecastsDTO.reporttime;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = forecastsDTO.casts;
        }
        return forecastsDTO.copy(str, str5, str6, str7, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdcode() {
        return this.adcode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getReporttime() {
        return this.reporttime;
    }

    public final List<CastsDTO> component5() {
        return this.casts;
    }

    public final ForecastsDTO copy(String city, String adcode, String province, String reporttime, List<CastsDTO> casts) {
        return new ForecastsDTO(city, adcode, province, reporttime, casts);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForecastsDTO)) {
            return false;
        }
        ForecastsDTO forecastsDTO = (ForecastsDTO) other;
        return Intrinsics.areEqual(this.city, forecastsDTO.city) && Intrinsics.areEqual(this.adcode, forecastsDTO.adcode) && Intrinsics.areEqual(this.province, forecastsDTO.province) && Intrinsics.areEqual(this.reporttime, forecastsDTO.reporttime) && Intrinsics.areEqual(this.casts, forecastsDTO.casts);
    }

    public int hashCode() {
        String str = this.city;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.adcode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.province;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.reporttime;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<CastsDTO> list = this.casts;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ForecastsDTO(city=" + this.city + ", adcode=" + this.adcode + ", province=" + this.province + ", reporttime=" + this.reporttime + ", casts=" + this.casts + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.city);
        parcel.writeString(this.adcode);
        parcel.writeString(this.province);
        parcel.writeString(this.reporttime);
        List<CastsDTO> list = this.casts;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<CastsDTO> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    public ForecastsDTO(String str, String str2, String str3, String str4, List<CastsDTO> list) {
        this.city = str;
        this.adcode = str2;
        this.province = str3;
        this.reporttime = str4;
        this.casts = list;
    }

    public /* synthetic */ ForecastsDTO(String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getAdcode() {
        return this.adcode;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getReporttime() {
        return this.reporttime;
    }

    public final List<CastsDTO> getCasts() {
        return this.casts;
    }
}
