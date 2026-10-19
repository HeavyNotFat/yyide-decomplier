package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bh\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u0083\u0002\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\t\u0010k\u001a\u00020lHÖ\u0001J\u0013\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020lHÖ\u0001J\t\u0010r\u001a\u00020\u0003HÖ\u0001J\u0019\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020lHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010 R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001e\"\u0004\bL\u0010 R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001e\"\u0004\bN\u0010 R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010 ¨\u0006x"}, d2 = {"Lcom/yd/android_brand_mvp/model/NewWeatherBean;", "Landroid/os/Parcelable;", "aqi", "", "area", "areaid", "date", "highest", "humidity", "lowest", "moondown", "moonrise", "pcpn", "province", "quality", "real", "sunrise", "sunset", "tips", "uv_index", "vis", "weather", "weathercode", "weatherimg", "week", "wind", "windsc", "windspeed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAqi", "()Ljava/lang/String;", "setAqi", "(Ljava/lang/String;)V", "getArea", "setArea", "getAreaid", "setAreaid", "getDate", "setDate", "getHighest", "setHighest", "getHumidity", "setHumidity", "getLowest", "setLowest", "getMoondown", "setMoondown", "getMoonrise", "setMoonrise", "getPcpn", "setPcpn", "getProvince", "setProvince", "getQuality", "setQuality", "getReal", "setReal", "getSunrise", "setSunrise", "getSunset", "setSunset", "getTips", "setTips", "getUv_index", "setUv_index", "getVis", "setVis", "getWeather", "setWeather", "getWeathercode", "setWeathercode", "getWeatherimg", "setWeatherimg", "getWeek", "setWeek", "getWind", "setWind", "getWindsc", "setWindsc", "getWindspeed", "setWindspeed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NewWeatherBean implements Parcelable {
    public static final Parcelable.Creator<NewWeatherBean> CREATOR = new Creator();
    private String aqi;
    private String area;
    private String areaid;
    private String date;
    private String highest;
    private String humidity;
    private String lowest;
    private String moondown;
    private String moonrise;
    private String pcpn;
    private String province;
    private String quality;
    private String real;
    private String sunrise;
    private String sunset;
    private String tips;
    private String uv_index;
    private String vis;
    private String weather;
    private String weathercode;
    private String weatherimg;
    private String week;
    private String wind;
    private String windsc;
    private String windspeed;

    /* JADX INFO: compiled from: NewWeatherBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NewWeatherBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NewWeatherBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherBean[] newArray(int i) {
            return new NewWeatherBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAqi() {
        return this.aqi;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPcpn() {
        return this.pcpn;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getReal() {
        return this.real;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSunrise() {
        return this.sunrise;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSunset() {
        return this.sunset;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getUv_index() {
        return this.uv_index;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getVis() {
        return this.vis;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getWeather() {
        return this.weather;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getWeathercode() {
        return this.weathercode;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getWeatherimg() {
        return this.weatherimg;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getWeek() {
        return this.week;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getWind() {
        return this.wind;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getWindsc() {
        return this.windsc;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getWindspeed() {
        return this.windspeed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAreaid() {
        return this.areaid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getHighest() {
        return this.highest;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getHumidity() {
        return this.humidity;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLowest() {
        return this.lowest;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMoondown() {
        return this.moondown;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMoonrise() {
        return this.moonrise;
    }

    public final NewWeatherBean copy(String aqi, String area, String areaid, String date, String highest, String humidity, String lowest, String moondown, String moonrise, String pcpn, String province, String quality, String real, String sunrise, String sunset, String tips, String uv_index, String vis, String weather, String weathercode, String weatherimg, String week, String wind, String windsc, String windspeed) {
        Intrinsics.checkNotNullParameter(aqi, "aqi");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(areaid, "areaid");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(highest, "highest");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(lowest, "lowest");
        Intrinsics.checkNotNullParameter(moondown, "moondown");
        Intrinsics.checkNotNullParameter(moonrise, "moonrise");
        Intrinsics.checkNotNullParameter(pcpn, "pcpn");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(real, "real");
        Intrinsics.checkNotNullParameter(sunrise, "sunrise");
        Intrinsics.checkNotNullParameter(sunset, "sunset");
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(uv_index, "uv_index");
        Intrinsics.checkNotNullParameter(vis, "vis");
        Intrinsics.checkNotNullParameter(weather, "weather");
        Intrinsics.checkNotNullParameter(weathercode, "weathercode");
        Intrinsics.checkNotNullParameter(weatherimg, "weatherimg");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(wind, "wind");
        Intrinsics.checkNotNullParameter(windsc, "windsc");
        Intrinsics.checkNotNullParameter(windspeed, "windspeed");
        return new NewWeatherBean(aqi, area, areaid, date, highest, humidity, lowest, moondown, moonrise, pcpn, province, quality, real, sunrise, sunset, tips, uv_index, vis, weather, weathercode, weatherimg, week, wind, windsc, windspeed);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewWeatherBean)) {
            return false;
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) other;
        return Intrinsics.areEqual(this.aqi, newWeatherBean.aqi) && Intrinsics.areEqual(this.area, newWeatherBean.area) && Intrinsics.areEqual(this.areaid, newWeatherBean.areaid) && Intrinsics.areEqual(this.date, newWeatherBean.date) && Intrinsics.areEqual(this.highest, newWeatherBean.highest) && Intrinsics.areEqual(this.humidity, newWeatherBean.humidity) && Intrinsics.areEqual(this.lowest, newWeatherBean.lowest) && Intrinsics.areEqual(this.moondown, newWeatherBean.moondown) && Intrinsics.areEqual(this.moonrise, newWeatherBean.moonrise) && Intrinsics.areEqual(this.pcpn, newWeatherBean.pcpn) && Intrinsics.areEqual(this.province, newWeatherBean.province) && Intrinsics.areEqual(this.quality, newWeatherBean.quality) && Intrinsics.areEqual(this.real, newWeatherBean.real) && Intrinsics.areEqual(this.sunrise, newWeatherBean.sunrise) && Intrinsics.areEqual(this.sunset, newWeatherBean.sunset) && Intrinsics.areEqual(this.tips, newWeatherBean.tips) && Intrinsics.areEqual(this.uv_index, newWeatherBean.uv_index) && Intrinsics.areEqual(this.vis, newWeatherBean.vis) && Intrinsics.areEqual(this.weather, newWeatherBean.weather) && Intrinsics.areEqual(this.weathercode, newWeatherBean.weathercode) && Intrinsics.areEqual(this.weatherimg, newWeatherBean.weatherimg) && Intrinsics.areEqual(this.week, newWeatherBean.week) && Intrinsics.areEqual(this.wind, newWeatherBean.wind) && Intrinsics.areEqual(this.windsc, newWeatherBean.windsc) && Intrinsics.areEqual(this.windspeed, newWeatherBean.windspeed);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((this.aqi.hashCode() * 31) + this.area.hashCode()) * 31) + this.areaid.hashCode()) * 31) + this.date.hashCode()) * 31) + this.highest.hashCode()) * 31) + this.humidity.hashCode()) * 31) + this.lowest.hashCode()) * 31) + this.moondown.hashCode()) * 31) + this.moonrise.hashCode()) * 31) + this.pcpn.hashCode()) * 31) + this.province.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.real.hashCode()) * 31) + this.sunrise.hashCode()) * 31) + this.sunset.hashCode()) * 31) + this.tips.hashCode()) * 31) + this.uv_index.hashCode()) * 31) + this.vis.hashCode()) * 31) + this.weather.hashCode()) * 31) + this.weathercode.hashCode()) * 31) + this.weatherimg.hashCode()) * 31) + this.week.hashCode()) * 31) + this.wind.hashCode()) * 31) + this.windsc.hashCode()) * 31) + this.windspeed.hashCode();
    }

    public String toString() {
        return "NewWeatherBean(aqi=" + this.aqi + ", area=" + this.area + ", areaid=" + this.areaid + ", date=" + this.date + ", highest=" + this.highest + ", humidity=" + this.humidity + ", lowest=" + this.lowest + ", moondown=" + this.moondown + ", moonrise=" + this.moonrise + ", pcpn=" + this.pcpn + ", province=" + this.province + ", quality=" + this.quality + ", real=" + this.real + ", sunrise=" + this.sunrise + ", sunset=" + this.sunset + ", tips=" + this.tips + ", uv_index=" + this.uv_index + ", vis=" + this.vis + ", weather=" + this.weather + ", weathercode=" + this.weathercode + ", weatherimg=" + this.weatherimg + ", week=" + this.week + ", wind=" + this.wind + ", windsc=" + this.windsc + ", windspeed=" + this.windspeed + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.aqi);
        parcel.writeString(this.area);
        parcel.writeString(this.areaid);
        parcel.writeString(this.date);
        parcel.writeString(this.highest);
        parcel.writeString(this.humidity);
        parcel.writeString(this.lowest);
        parcel.writeString(this.moondown);
        parcel.writeString(this.moonrise);
        parcel.writeString(this.pcpn);
        parcel.writeString(this.province);
        parcel.writeString(this.quality);
        parcel.writeString(this.real);
        parcel.writeString(this.sunrise);
        parcel.writeString(this.sunset);
        parcel.writeString(this.tips);
        parcel.writeString(this.uv_index);
        parcel.writeString(this.vis);
        parcel.writeString(this.weather);
        parcel.writeString(this.weathercode);
        parcel.writeString(this.weatherimg);
        parcel.writeString(this.week);
        parcel.writeString(this.wind);
        parcel.writeString(this.windsc);
        parcel.writeString(this.windspeed);
    }

    public NewWeatherBean(String aqi, String area, String areaid, String date, String highest, String humidity, String lowest, String moondown, String moonrise, String pcpn, String province, String quality, String real, String sunrise, String sunset, String tips, String uv_index, String vis, String weather, String weathercode, String weatherimg, String week, String wind, String windsc, String windspeed) {
        Intrinsics.checkNotNullParameter(aqi, "aqi");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(areaid, "areaid");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(highest, "highest");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(lowest, "lowest");
        Intrinsics.checkNotNullParameter(moondown, "moondown");
        Intrinsics.checkNotNullParameter(moonrise, "moonrise");
        Intrinsics.checkNotNullParameter(pcpn, "pcpn");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(real, "real");
        Intrinsics.checkNotNullParameter(sunrise, "sunrise");
        Intrinsics.checkNotNullParameter(sunset, "sunset");
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(uv_index, "uv_index");
        Intrinsics.checkNotNullParameter(vis, "vis");
        Intrinsics.checkNotNullParameter(weather, "weather");
        Intrinsics.checkNotNullParameter(weathercode, "weathercode");
        Intrinsics.checkNotNullParameter(weatherimg, "weatherimg");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(wind, "wind");
        Intrinsics.checkNotNullParameter(windsc, "windsc");
        Intrinsics.checkNotNullParameter(windspeed, "windspeed");
        this.aqi = aqi;
        this.area = area;
        this.areaid = areaid;
        this.date = date;
        this.highest = highest;
        this.humidity = humidity;
        this.lowest = lowest;
        this.moondown = moondown;
        this.moonrise = moonrise;
        this.pcpn = pcpn;
        this.province = province;
        this.quality = quality;
        this.real = real;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.tips = tips;
        this.uv_index = uv_index;
        this.vis = vis;
        this.weather = weather;
        this.weathercode = weathercode;
        this.weatherimg = weatherimg;
        this.week = week;
        this.wind = wind;
        this.windsc = windsc;
        this.windspeed = windspeed;
    }

    public final String getAqi() {
        return this.aqi;
    }

    public final void setAqi(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aqi = str;
    }

    public final String getArea() {
        return this.area;
    }

    public final void setArea(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.area = str;
    }

    public final String getAreaid() {
        return this.areaid;
    }

    public final void setAreaid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.areaid = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getHighest() {
        return this.highest;
    }

    public final void setHighest(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.highest = str;
    }

    public final String getHumidity() {
        return this.humidity;
    }

    public final void setHumidity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.humidity = str;
    }

    public final String getLowest() {
        return this.lowest;
    }

    public final void setLowest(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lowest = str;
    }

    public final String getMoondown() {
        return this.moondown;
    }

    public final void setMoondown(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.moondown = str;
    }

    public final String getMoonrise() {
        return this.moonrise;
    }

    public final void setMoonrise(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.moonrise = str;
    }

    public final String getPcpn() {
        return this.pcpn;
    }

    public final void setPcpn(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pcpn = str;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setProvince(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.province = str;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final void setQuality(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quality = str;
    }

    public final String getReal() {
        return this.real;
    }

    public final void setReal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.real = str;
    }

    public final String getSunrise() {
        return this.sunrise;
    }

    public final void setSunrise(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sunrise = str;
    }

    public final String getSunset() {
        return this.sunset;
    }

    public final void setSunset(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sunset = str;
    }

    public final String getTips() {
        return this.tips;
    }

    public final void setTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tips = str;
    }

    public final String getUv_index() {
        return this.uv_index;
    }

    public final void setUv_index(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uv_index = str;
    }

    public final String getVis() {
        return this.vis;
    }

    public final void setVis(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vis = str;
    }

    public final String getWeather() {
        return this.weather;
    }

    public final void setWeather(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.weather = str;
    }

    public final String getWeathercode() {
        return this.weathercode;
    }

    public final void setWeathercode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.weathercode = str;
    }

    public final String getWeatherimg() {
        return this.weatherimg;
    }

    public final void setWeatherimg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.weatherimg = str;
    }

    public final String getWeek() {
        return this.week;
    }

    public final void setWeek(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.week = str;
    }

    public final String getWind() {
        return this.wind;
    }

    public final void setWind(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wind = str;
    }

    public final String getWindsc() {
        return this.windsc;
    }

    public final void setWindsc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.windsc = str;
    }

    public final String getWindspeed() {
        return this.windspeed;
    }

    public final void setWindspeed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.windspeed = str;
    }
}
