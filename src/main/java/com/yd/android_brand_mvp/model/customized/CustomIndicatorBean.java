package com.yd.android_brand_mvp.model.customized;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomIndicatorBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/customized/CustomIndicatorBean;", "", "indicatorCode", "", "indicatorName", "indicatorValue", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIndicatorCode", "()Ljava/lang/String;", "getIndicatorName", "getIndicatorValue", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomIndicatorBean {
    private final String indicatorCode;
    private final String indicatorName;
    private final String indicatorValue;
    private final String url;

    public static /* synthetic */ CustomIndicatorBean copy$default(CustomIndicatorBean customIndicatorBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customIndicatorBean.indicatorCode;
        }
        if ((i & 2) != 0) {
            str2 = customIndicatorBean.indicatorName;
        }
        if ((i & 4) != 0) {
            str3 = customIndicatorBean.indicatorValue;
        }
        if ((i & 8) != 0) {
            str4 = customIndicatorBean.url;
        }
        return customIndicatorBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIndicatorCode() {
        return this.indicatorCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIndicatorName() {
        return this.indicatorName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIndicatorValue() {
        return this.indicatorValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final CustomIndicatorBean copy(String indicatorCode, String indicatorName, String indicatorValue, String url) {
        Intrinsics.checkNotNullParameter(indicatorCode, "indicatorCode");
        Intrinsics.checkNotNullParameter(indicatorName, "indicatorName");
        Intrinsics.checkNotNullParameter(indicatorValue, "indicatorValue");
        Intrinsics.checkNotNullParameter(url, "url");
        return new CustomIndicatorBean(indicatorCode, indicatorName, indicatorValue, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomIndicatorBean)) {
            return false;
        }
        CustomIndicatorBean customIndicatorBean = (CustomIndicatorBean) other;
        return Intrinsics.areEqual(this.indicatorCode, customIndicatorBean.indicatorCode) && Intrinsics.areEqual(this.indicatorName, customIndicatorBean.indicatorName) && Intrinsics.areEqual(this.indicatorValue, customIndicatorBean.indicatorValue) && Intrinsics.areEqual(this.url, customIndicatorBean.url);
    }

    public int hashCode() {
        return (((((this.indicatorCode.hashCode() * 31) + this.indicatorName.hashCode()) * 31) + this.indicatorValue.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "CustomIndicatorBean(indicatorCode=" + this.indicatorCode + ", indicatorName=" + this.indicatorName + ", indicatorValue=" + this.indicatorValue + ", url=" + this.url + ')';
    }

    public CustomIndicatorBean(String indicatorCode, String indicatorName, String indicatorValue, String url) {
        Intrinsics.checkNotNullParameter(indicatorCode, "indicatorCode");
        Intrinsics.checkNotNullParameter(indicatorName, "indicatorName");
        Intrinsics.checkNotNullParameter(indicatorValue, "indicatorValue");
        Intrinsics.checkNotNullParameter(url, "url");
        this.indicatorCode = indicatorCode;
        this.indicatorName = indicatorName;
        this.indicatorValue = indicatorValue;
        this.url = url;
    }

    public final String getIndicatorCode() {
        return this.indicatorCode;
    }

    public final String getIndicatorName() {
        return this.indicatorName;
    }

    public final String getIndicatorValue() {
        return this.indicatorValue;
    }

    public final String getUrl() {
        return this.url;
    }
}
