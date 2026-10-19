package com.yd.android_brand_mvp.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrainingDeviceBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/model/TrainingDeviceBean;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "number", "", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getNumber", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TrainingDeviceBean {
    private final String name;
    private final int number;

    public static /* synthetic */ TrainingDeviceBean copy$default(TrainingDeviceBean trainingDeviceBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = trainingDeviceBean.name;
        }
        if ((i2 & 2) != 0) {
            i = trainingDeviceBean.number;
        }
        return trainingDeviceBean.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    public final TrainingDeviceBean copy(String name, int number) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new TrainingDeviceBean(name, number);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrainingDeviceBean)) {
            return false;
        }
        TrainingDeviceBean trainingDeviceBean = (TrainingDeviceBean) other;
        return Intrinsics.areEqual(this.name, trainingDeviceBean.name) && this.number == trainingDeviceBean.number;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.number;
    }

    public String toString() {
        return "TrainingDeviceBean(name=" + this.name + ", number=" + this.number + ')';
    }

    public TrainingDeviceBean(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.number = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumber() {
        return this.number;
    }
}
