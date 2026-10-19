package com.yd.android_brand_mvp.model.customized;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomSensorBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/customized/CustomSensorBean;", "", "indicators", "", "Lcom/yd/android_brand_mvp/model/customized/CustomIndicatorBean;", "siteId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getIndicators", "()Ljava/util/List;", "getSiteId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomSensorBean {
    private final List<CustomIndicatorBean> indicators;
    private final String siteId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomSensorBean copy$default(CustomSensorBean customSensorBean, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = customSensorBean.indicators;
        }
        if ((i & 2) != 0) {
            str = customSensorBean.siteId;
        }
        return customSensorBean.copy(list, str);
    }

    public final List<CustomIndicatorBean> component1() {
        return this.indicators;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    public final CustomSensorBean copy(List<CustomIndicatorBean> indicators, String siteId) {
        Intrinsics.checkNotNullParameter(indicators, "indicators");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        return new CustomSensorBean(indicators, siteId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomSensorBean)) {
            return false;
        }
        CustomSensorBean customSensorBean = (CustomSensorBean) other;
        return Intrinsics.areEqual(this.indicators, customSensorBean.indicators) && Intrinsics.areEqual(this.siteId, customSensorBean.siteId);
    }

    public int hashCode() {
        return (this.indicators.hashCode() * 31) + this.siteId.hashCode();
    }

    public String toString() {
        return "CustomSensorBean(indicators=" + this.indicators + ", siteId=" + this.siteId + ')';
    }

    public CustomSensorBean(List<CustomIndicatorBean> indicators, String siteId) {
        Intrinsics.checkNotNullParameter(indicators, "indicators");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        this.indicators = indicators;
        this.siteId = siteId;
    }

    public final List<CustomIndicatorBean> getIndicators() {
        return this.indicators;
    }

    public final String getSiteId() {
        return this.siteId;
    }
}
