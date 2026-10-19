package com.yd.android_brand_mvp.model.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpFileBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/UpFileBean;", "", "filePath", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "suffix", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "getName", "getSuffix", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UpFileBean {
    private final String filePath;
    private final String name;
    private final String suffix;

    public UpFileBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UpFileBean copy$default(UpFileBean upFileBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upFileBean.filePath;
        }
        if ((i & 2) != 0) {
            str2 = upFileBean.name;
        }
        if ((i & 4) != 0) {
            str3 = upFileBean.suffix;
        }
        return upFileBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    public final UpFileBean copy(String filePath, String name, String suffix) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new UpFileBean(filePath, name, suffix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpFileBean)) {
            return false;
        }
        UpFileBean upFileBean = (UpFileBean) other;
        return Intrinsics.areEqual(this.filePath, upFileBean.filePath) && Intrinsics.areEqual(this.name, upFileBean.name) && Intrinsics.areEqual(this.suffix, upFileBean.suffix);
    }

    public int hashCode() {
        return (((this.filePath.hashCode() * 31) + this.name.hashCode()) * 31) + this.suffix.hashCode();
    }

    public String toString() {
        return "UpFileBean(filePath=" + this.filePath + ", name=" + this.name + ", suffix=" + this.suffix + ')';
    }

    public UpFileBean(String filePath, String name, String suffix) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        this.filePath = filePath;
        this.name = name;
        this.suffix = suffix;
    }

    public /* synthetic */ UpFileBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSuffix() {
        return this.suffix;
    }
}
