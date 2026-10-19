package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherItemBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b?\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003JÑ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020CHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\u0019\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020CHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019¨\u0006O"}, d2 = {"Lcom/yd/android_brand_mvp/model/NewWeatherItemBean;", "Landroid/os/Parcelable;", "date", "", "highest", "humidity", "lowest", "moondown", "moonrise", "pcpn", "real", "sunrise", "sunset", "tips", "uv_index", "vis", "weather", "weathercode", "weatherimg", "week", "wind", "windsc", "windspeed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHighest", "getHumidity", "getLowest", "getMoondown", "getMoonrise", "getPcpn", "getReal", "getSunrise", "getSunset", "getTips", "getUv_index", "getVis", "getWeather", "getWeathercode", "getWeatherimg", "getWeek", "getWind", "getWindsc", "getWindspeed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NewWeatherItemBean implements Parcelable {
    public static final Parcelable.Creator<NewWeatherItemBean> CREATOR = new Creator();
    private final String date;
    private final String highest;
    private final String humidity;
    private final String lowest;
    private final String moondown;
    private final String moonrise;
    private final String pcpn;
    private final String real;
    private final String sunrise;
    private final String sunset;
    private final String tips;
    private final String uv_index;
    private final String vis;
    private final String weather;
    private final String weathercode;
    private final String weatherimg;
    private final String week;
    private final String wind;
    private final String windsc;
    private final String windspeed;

    /* JADX INFO: compiled from: NewWeatherItemBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NewWeatherItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NewWeatherItemBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherItemBean[] newArray(int i) {
            return new NewWeatherItemBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSunset() {
        return this.sunset;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getUv_index() {
        return this.uv_index;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getVis() {
        return this.vis;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getWeather() {
        return this.weather;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getWeathercode() {
        return this.weathercode;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getWeatherimg() {
        return this.weatherimg;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getWeek() {
        return this.week;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getWind() {
        return this.wind;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getWindsc() {
        return this.windsc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHighest() {
        return this.highest;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getWindspeed() {
        return this.windspeed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHumidity() {
        return this.humidity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLowest() {
        return this.lowest;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMoondown() {
        return this.moondown;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMoonrise() {
        return this.moonrise;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPcpn() {
        return this.pcpn;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getReal() {
        return this.real;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSunrise() {
        return this.sunrise;
    }

    public final NewWeatherItemBean copy(String date, String highest, String humidity, String lowest, String moondown, String moonrise, String pcpn, String real, String sunrise, String sunset, String tips, String uv_index, String vis, String weather, String weathercode, String weatherimg, String week, String wind, String windsc, String windspeed) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(highest, "highest");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(lowest, "lowest");
        Intrinsics.checkNotNullParameter(moondown, "moondown");
        Intrinsics.checkNotNullParameter(moonrise, "moonrise");
        Intrinsics.checkNotNullParameter(pcpn, "pcpn");
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
        return new NewWeatherItemBean(date, highest, humidity, lowest, moondown, moonrise, pcpn, real, sunrise, sunset, tips, uv_index, vis, weather, weathercode, weatherimg, week, wind, windsc, windspeed);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewWeatherItemBean)) {
            return false;
        }
        NewWeatherItemBean newWeatherItemBean = (NewWeatherItemBean) other;
        return Intrinsics.areEqual(this.date, newWeatherItemBean.date) && Intrinsics.areEqual(this.highest, newWeatherItemBean.highest) && Intrinsics.areEqual(this.humidity, newWeatherItemBean.humidity) && Intrinsics.areEqual(this.lowest, newWeatherItemBean.lowest) && Intrinsics.areEqual(this.moondown, newWeatherItemBean.moondown) && Intrinsics.areEqual(this.moonrise, newWeatherItemBean.moonrise) && Intrinsics.areEqual(this.pcpn, newWeatherItemBean.pcpn) && Intrinsics.areEqual(this.real, newWeatherItemBean.real) && Intrinsics.areEqual(this.sunrise, newWeatherItemBean.sunrise) && Intrinsics.areEqual(this.sunset, newWeatherItemBean.sunset) && Intrinsics.areEqual(this.tips, newWeatherItemBean.tips) && Intrinsics.areEqual(this.uv_index, newWeatherItemBean.uv_index) && Intrinsics.areEqual(this.vis, newWeatherItemBean.vis) && Intrinsics.areEqual(this.weather, newWeatherItemBean.weather) && Intrinsics.areEqual(this.weathercode, newWeatherItemBean.weathercode) && Intrinsics.areEqual(this.weatherimg, newWeatherItemBean.weatherimg) && Intrinsics.areEqual(this.week, newWeatherItemBean.week) && Intrinsics.areEqual(this.wind, newWeatherItemBean.wind) && Intrinsics.areEqual(this.windsc, newWeatherItemBean.windsc) && Intrinsics.areEqual(this.windspeed, newWeatherItemBean.windspeed);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.date.hashCode() * 31) + this.highest.hashCode()) * 31) + this.humidity.hashCode()) * 31) + this.lowest.hashCode()) * 31) + this.moondown.hashCode()) * 31) + this.moonrise.hashCode()) * 31) + this.pcpn.hashCode()) * 31) + this.real.hashCode()) * 31) + this.sunrise.hashCode()) * 31) + this.sunset.hashCode()) * 31) + this.tips.hashCode()) * 31) + this.uv_index.hashCode()) * 31) + this.vis.hashCode()) * 31) + this.weather.hashCode()) * 31) + this.weathercode.hashCode()) * 31) + this.weatherimg.hashCode()) * 31) + this.week.hashCode()) * 31) + this.wind.hashCode()) * 31) + this.windsc.hashCode()) * 31) + this.windspeed.hashCode();
    }

    public String toString() {
        return "NewWeatherItemBean(date=" + this.date + ", highest=" + this.highest + ", humidity=" + this.humidity + ", lowest=" + this.lowest + ", moondown=" + this.moondown + ", moonrise=" + this.moonrise + ", pcpn=" + this.pcpn + ", real=" + this.real + ", sunrise=" + this.sunrise + ", sunset=" + this.sunset + ", tips=" + this.tips + ", uv_index=" + this.uv_index + ", vis=" + this.vis + ", weather=" + this.weather + ", weathercode=" + this.weathercode + ", weatherimg=" + this.weatherimg + ", week=" + this.week + ", wind=" + this.wind + ", windsc=" + this.windsc + ", windspeed=" + this.windspeed + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.date);
        parcel.writeString(this.highest);
        parcel.writeString(this.humidity);
        parcel.writeString(this.lowest);
        parcel.writeString(this.moondown);
        parcel.writeString(this.moonrise);
        parcel.writeString(this.pcpn);
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

    public NewWeatherItemBean(String date, String highest, String humidity, String lowest, String moondown, String moonrise, String pcpn, String real, String sunrise, String sunset, String tips, String uv_index, String vis, String weather, String weathercode, String weatherimg, String week, String wind, String windsc, String windspeed) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(highest, "highest");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(lowest, "lowest");
        Intrinsics.checkNotNullParameter(moondown, "moondown");
        Intrinsics.checkNotNullParameter(moonrise, "moonrise");
        Intrinsics.checkNotNullParameter(pcpn, "pcpn");
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
        this.date = date;
        this.highest = highest;
        this.humidity = humidity;
        this.lowest = lowest;
        this.moondown = moondown;
        this.moonrise = moonrise;
        this.pcpn = pcpn;
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

    public final String getDate() {
        return this.date;
    }

    public final String getHighest() {
        return this.highest;
    }

    public final String getHumidity() {
        return this.humidity;
    }

    public final String getLowest() {
        return this.lowest;
    }

    public final String getMoondown() {
        return this.moondown;
    }

    public final String getMoonrise() {
        return this.moonrise;
    }

    public final String getPcpn() {
        return this.pcpn;
    }

    public final String getReal() {
        return this.real;
    }

    public final String getSunrise() {
        return this.sunrise;
    }

    public final String getSunset() {
        return this.sunset;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getUv_index() {
        return this.uv_index;
    }

    public final String getVis() {
        return this.vis;
    }

    public final String getWeather() {
        return this.weather;
    }

    public final String getWeathercode() {
        return this.weathercode;
    }

    public final String getWeatherimg() {
        return this.weatherimg;
    }

    public final String getWeek() {
        return this.week;
    }

    public final String getWind() {
        return this.wind;
    }

    public final String getWindsc() {
        return this.windsc;
    }

    public final String getWindspeed() {
        return this.windspeed;
    }
}
