package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherRsp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020(HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u00064"}, d2 = {"Lcom/yd/android_brand_mvp/model/CurrentWeatherBeanItem;", "Landroid/os/Parcelable;", "adcode", "", "city", "humidity", "humidity_float", "province", "reporttime", "temperature", "temperature_float", "weather", "winddirection", "windpower", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdcode", "()Ljava/lang/String;", "getCity", "getHumidity", "getHumidity_float", "getProvince", "getReporttime", "getTemperature", "getTemperature_float", "getWeather", "getWinddirection", "getWindpower", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CurrentWeatherBeanItem implements Parcelable {
    public static final Parcelable.Creator<CurrentWeatherBeanItem> CREATOR = new Creator();
    private final String adcode;
    private final String city;
    private final String humidity;
    private final String humidity_float;
    private final String province;
    private final String reporttime;
    private final String temperature;
    private final String temperature_float;
    private final String weather;
    private final String winddirection;
    private final String windpower;

    /* JADX INFO: compiled from: NewWeatherRsp.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CurrentWeatherBeanItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrentWeatherBeanItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CurrentWeatherBeanItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrentWeatherBeanItem[] newArray(int i) {
            return new CurrentWeatherBeanItem[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdcode() {
        return this.adcode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getWinddirection() {
        return this.winddirection;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getWindpower() {
        return this.windpower;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHumidity() {
        return this.humidity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHumidity_float() {
        return this.humidity_float;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReporttime() {
        return this.reporttime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTemperature_float() {
        return this.temperature_float;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getWeather() {
        return this.weather;
    }

    public final CurrentWeatherBeanItem copy(String adcode, String city, String humidity, String humidity_float, String province, String reporttime, String temperature, String temperature_float, String weather, String winddirection, String windpower) {
        Intrinsics.checkNotNullParameter(adcode, "adcode");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(humidity_float, "humidity_float");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(reporttime, "reporttime");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(temperature_float, "temperature_float");
        Intrinsics.checkNotNullParameter(weather, "weather");
        Intrinsics.checkNotNullParameter(winddirection, "winddirection");
        Intrinsics.checkNotNullParameter(windpower, "windpower");
        return new CurrentWeatherBeanItem(adcode, city, humidity, humidity_float, province, reporttime, temperature, temperature_float, weather, winddirection, windpower);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentWeatherBeanItem)) {
            return false;
        }
        CurrentWeatherBeanItem currentWeatherBeanItem = (CurrentWeatherBeanItem) other;
        return Intrinsics.areEqual(this.adcode, currentWeatherBeanItem.adcode) && Intrinsics.areEqual(this.city, currentWeatherBeanItem.city) && Intrinsics.areEqual(this.humidity, currentWeatherBeanItem.humidity) && Intrinsics.areEqual(this.humidity_float, currentWeatherBeanItem.humidity_float) && Intrinsics.areEqual(this.province, currentWeatherBeanItem.province) && Intrinsics.areEqual(this.reporttime, currentWeatherBeanItem.reporttime) && Intrinsics.areEqual(this.temperature, currentWeatherBeanItem.temperature) && Intrinsics.areEqual(this.temperature_float, currentWeatherBeanItem.temperature_float) && Intrinsics.areEqual(this.weather, currentWeatherBeanItem.weather) && Intrinsics.areEqual(this.winddirection, currentWeatherBeanItem.winddirection) && Intrinsics.areEqual(this.windpower, currentWeatherBeanItem.windpower);
    }

    public int hashCode() {
        return (((((((((((((((((((this.adcode.hashCode() * 31) + this.city.hashCode()) * 31) + this.humidity.hashCode()) * 31) + this.humidity_float.hashCode()) * 31) + this.province.hashCode()) * 31) + this.reporttime.hashCode()) * 31) + this.temperature.hashCode()) * 31) + this.temperature_float.hashCode()) * 31) + this.weather.hashCode()) * 31) + this.winddirection.hashCode()) * 31) + this.windpower.hashCode();
    }

    public String toString() {
        return "CurrentWeatherBeanItem(adcode=" + this.adcode + ", city=" + this.city + ", humidity=" + this.humidity + ", humidity_float=" + this.humidity_float + ", province=" + this.province + ", reporttime=" + this.reporttime + ", temperature=" + this.temperature + ", temperature_float=" + this.temperature_float + ", weather=" + this.weather + ", winddirection=" + this.winddirection + ", windpower=" + this.windpower + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.adcode);
        parcel.writeString(this.city);
        parcel.writeString(this.humidity);
        parcel.writeString(this.humidity_float);
        parcel.writeString(this.province);
        parcel.writeString(this.reporttime);
        parcel.writeString(this.temperature);
        parcel.writeString(this.temperature_float);
        parcel.writeString(this.weather);
        parcel.writeString(this.winddirection);
        parcel.writeString(this.windpower);
    }

    public CurrentWeatherBeanItem(String adcode, String city, String humidity, String humidity_float, String province, String reporttime, String temperature, String temperature_float, String weather, String winddirection, String windpower) {
        Intrinsics.checkNotNullParameter(adcode, "adcode");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(humidity_float, "humidity_float");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(reporttime, "reporttime");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(temperature_float, "temperature_float");
        Intrinsics.checkNotNullParameter(weather, "weather");
        Intrinsics.checkNotNullParameter(winddirection, "winddirection");
        Intrinsics.checkNotNullParameter(windpower, "windpower");
        this.adcode = adcode;
        this.city = city;
        this.humidity = humidity;
        this.humidity_float = humidity_float;
        this.province = province;
        this.reporttime = reporttime;
        this.temperature = temperature;
        this.temperature_float = temperature_float;
        this.weather = weather;
        this.winddirection = winddirection;
        this.windpower = windpower;
    }

    public final String getAdcode() {
        return this.adcode;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getHumidity() {
        return this.humidity;
    }

    public final String getHumidity_float() {
        return this.humidity_float;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getReporttime() {
        return this.reporttime;
    }

    public final String getTemperature() {
        return this.temperature;
    }

    public final String getTemperature_float() {
        return this.temperature_float;
    }

    public final String getWeather() {
        return this.weather;
    }

    public final String getWinddirection() {
        return this.winddirection;
    }

    public final String getWindpower() {
        return this.windpower;
    }
}
