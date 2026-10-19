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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006)"}, d2 = {"Lcom/yd/android_brand_mvp/model/NewWeatherRsp;", "Landroid/os/Parcelable;", "status", "", "count", "info", "infocode", "lives", "", "Lcom/yd/android_brand_mvp/model/CurrentWeatherBeanItem;", "forecasts", "Lcom/yd/android_brand_mvp/model/ForecastsDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCount", "()Ljava/lang/String;", "getForecasts", "()Ljava/util/List;", "getInfo", "getInfocode", "getLives", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NewWeatherRsp implements Parcelable {
    public static final Parcelable.Creator<NewWeatherRsp> CREATOR = new Creator();
    private final String count;
    private final List<ForecastsDTO> forecasts;
    private final String info;
    private final String infocode;
    private final List<CurrentWeatherBeanItem> lives;
    private final String status;

    /* JADX INFO: compiled from: NewWeatherRsp.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NewWeatherRsp> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherRsp createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(CurrentWeatherBeanItem.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList3 = arrayList;
            if (parcel.readInt() != 0) {
                int i3 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList4.add(ForecastsDTO.CREATOR.createFromParcel(parcel));
                }
                arrayList2 = arrayList4;
            }
            return new NewWeatherRsp(string, string2, string3, string4, arrayList3, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherRsp[] newArray(int i) {
            return new NewWeatherRsp[i];
        }
    }

    public NewWeatherRsp() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewWeatherRsp copy$default(NewWeatherRsp newWeatherRsp, String str, String str2, String str3, String str4, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newWeatherRsp.status;
        }
        if ((i & 2) != 0) {
            str2 = newWeatherRsp.count;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = newWeatherRsp.info;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = newWeatherRsp.infocode;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = newWeatherRsp.lives;
        }
        List list3 = list;
        if ((i & 32) != 0) {
            list2 = newWeatherRsp.forecasts;
        }
        return newWeatherRsp.copy(str, str5, str6, str7, list3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInfocode() {
        return this.infocode;
    }

    public final List<CurrentWeatherBeanItem> component5() {
        return this.lives;
    }

    public final List<ForecastsDTO> component6() {
        return this.forecasts;
    }

    public final NewWeatherRsp copy(String status, String count, String info, String infocode, List<CurrentWeatherBeanItem> lives, List<ForecastsDTO> forecasts) {
        return new NewWeatherRsp(status, count, info, infocode, lives, forecasts);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewWeatherRsp)) {
            return false;
        }
        NewWeatherRsp newWeatherRsp = (NewWeatherRsp) other;
        return Intrinsics.areEqual(this.status, newWeatherRsp.status) && Intrinsics.areEqual(this.count, newWeatherRsp.count) && Intrinsics.areEqual(this.info, newWeatherRsp.info) && Intrinsics.areEqual(this.infocode, newWeatherRsp.infocode) && Intrinsics.areEqual(this.lives, newWeatherRsp.lives) && Intrinsics.areEqual(this.forecasts, newWeatherRsp.forecasts);
    }

    public int hashCode() {
        String str = this.status;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.count;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.info;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.infocode;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<CurrentWeatherBeanItem> list = this.lives;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<ForecastsDTO> list2 = this.forecasts;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "NewWeatherRsp(status=" + this.status + ", count=" + this.count + ", info=" + this.info + ", infocode=" + this.infocode + ", lives=" + this.lives + ", forecasts=" + this.forecasts + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.status);
        parcel.writeString(this.count);
        parcel.writeString(this.info);
        parcel.writeString(this.infocode);
        List<CurrentWeatherBeanItem> list = this.lives;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<CurrentWeatherBeanItem> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, flags);
            }
        }
        List<ForecastsDTO> list2 = this.forecasts;
        if (list2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list2.size());
        Iterator<ForecastsDTO> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
    }

    public NewWeatherRsp(String str, String str2, String str3, String str4, List<CurrentWeatherBeanItem> list, List<ForecastsDTO> list2) {
        this.status = str;
        this.count = str2;
        this.info = str3;
        this.infocode = str4;
        this.lives = list;
        this.forecasts = list2;
    }

    public /* synthetic */ NewWeatherRsp(String str, String str2, String str3, String str4, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2);
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getInfocode() {
        return this.infocode;
    }

    public final List<CurrentWeatherBeanItem> getLives() {
        return this.lives;
    }

    public final List<ForecastsDTO> getForecasts() {
        return this.forecasts;
    }
}
