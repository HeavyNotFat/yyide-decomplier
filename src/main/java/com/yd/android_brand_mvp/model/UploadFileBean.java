package com.yd.android_brand_mvp.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFileBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/model/UploadFileBean;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "status", "", "url", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getStatus", "()I", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UploadFileBean {
    private final String name;
    private final int status;
    private final String url;

    public static /* synthetic */ UploadFileBean copy$default(UploadFileBean uploadFileBean, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadFileBean.name;
        }
        if ((i2 & 2) != 0) {
            i = uploadFileBean.status;
        }
        if ((i2 & 4) != 0) {
            str2 = uploadFileBean.url;
        }
        return uploadFileBean.copy(str, i, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final UploadFileBean copy(String name, int status, String url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        return new UploadFileBean(name, status, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadFileBean)) {
            return false;
        }
        UploadFileBean uploadFileBean = (UploadFileBean) other;
        return Intrinsics.areEqual(this.name, uploadFileBean.name) && this.status == uploadFileBean.status && Intrinsics.areEqual(this.url, uploadFileBean.url);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.status) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "UploadFileBean(name=" + this.name + ", status=" + this.status + ", url=" + this.url + ')';
    }

    public UploadFileBean(String name, int i, String url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        this.name = name;
        this.status = i;
        this.url = url;
    }

    public final String getName() {
        return this.name;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }
}
