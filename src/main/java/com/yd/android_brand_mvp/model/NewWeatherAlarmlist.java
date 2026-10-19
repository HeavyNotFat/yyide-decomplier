package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherAlarmlist.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/NewWeatherAlarmlist;", "Landroid/os/Parcelable;", "city", "", "content", FirebaseAnalytics.Param.LEVEL, "ovince", "time", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "getContent", "getLevel", "getOvince", "getTime", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NewWeatherAlarmlist implements Parcelable {
    public static final Parcelable.Creator<NewWeatherAlarmlist> CREATOR = new Creator();
    private final String city;
    private final String content;
    private final String level;
    private final String ovince;
    private final String time;
    private final String type;

    /* JADX INFO: compiled from: NewWeatherAlarmlist.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NewWeatherAlarmlist> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherAlarmlist createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NewWeatherAlarmlist(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherAlarmlist[] newArray(int i) {
            return new NewWeatherAlarmlist[i];
        }
    }

    public static /* synthetic */ NewWeatherAlarmlist copy$default(NewWeatherAlarmlist newWeatherAlarmlist, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newWeatherAlarmlist.city;
        }
        if ((i & 2) != 0) {
            str2 = newWeatherAlarmlist.content;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = newWeatherAlarmlist.level;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = newWeatherAlarmlist.ovince;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = newWeatherAlarmlist.time;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = newWeatherAlarmlist.type;
        }
        return newWeatherAlarmlist.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOvince() {
        return this.ovince;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final NewWeatherAlarmlist copy(String city, String content, String level, String ovince, String time, String type) {
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(ovince, "ovince");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(type, "type");
        return new NewWeatherAlarmlist(city, content, level, ovince, time, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewWeatherAlarmlist)) {
            return false;
        }
        NewWeatherAlarmlist newWeatherAlarmlist = (NewWeatherAlarmlist) other;
        return Intrinsics.areEqual(this.city, newWeatherAlarmlist.city) && Intrinsics.areEqual(this.content, newWeatherAlarmlist.content) && Intrinsics.areEqual(this.level, newWeatherAlarmlist.level) && Intrinsics.areEqual(this.ovince, newWeatherAlarmlist.ovince) && Intrinsics.areEqual(this.time, newWeatherAlarmlist.time) && Intrinsics.areEqual(this.type, newWeatherAlarmlist.type);
    }

    public int hashCode() {
        return (((((((((this.city.hashCode() * 31) + this.content.hashCode()) * 31) + this.level.hashCode()) * 31) + this.ovince.hashCode()) * 31) + this.time.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "NewWeatherAlarmlist(city=" + this.city + ", content=" + this.content + ", level=" + this.level + ", ovince=" + this.ovince + ", time=" + this.time + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.city);
        parcel.writeString(this.content);
        parcel.writeString(this.level);
        parcel.writeString(this.ovince);
        parcel.writeString(this.time);
        parcel.writeString(this.type);
    }

    public NewWeatherAlarmlist(String city, String content, String level, String ovince, String time, String type) {
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(ovince, "ovince");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(type, "type");
        this.city = city;
        this.content = content;
        this.level = level;
        this.ovince = ovince;
        this.time = time;
        this.type = type;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getOvince() {
        return this.ovince;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }
}
