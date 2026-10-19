package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/model/SiteTeacherBean;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "peopleId", "siteId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPeopleId", "setPeopleId", "getSiteId", "setSiteId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SiteTeacherBean {
    private String name;
    private String peopleId;
    private String siteId;

    public SiteTeacherBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SiteTeacherBean copy$default(SiteTeacherBean siteTeacherBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = siteTeacherBean.name;
        }
        if ((i & 2) != 0) {
            str2 = siteTeacherBean.peopleId;
        }
        if ((i & 4) != 0) {
            str3 = siteTeacherBean.siteId;
        }
        return siteTeacherBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPeopleId() {
        return this.peopleId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    public final SiteTeacherBean copy(@JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "peopleId") String peopleId, @JSONField(name = "siteId") String siteId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peopleId, "peopleId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        return new SiteTeacherBean(name, peopleId, siteId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteTeacherBean)) {
            return false;
        }
        SiteTeacherBean siteTeacherBean = (SiteTeacherBean) other;
        return Intrinsics.areEqual(this.name, siteTeacherBean.name) && Intrinsics.areEqual(this.peopleId, siteTeacherBean.peopleId) && Intrinsics.areEqual(this.siteId, siteTeacherBean.siteId);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.peopleId.hashCode()) * 31) + this.siteId.hashCode();
    }

    public String toString() {
        return "SiteTeacherBean(name=" + this.name + ", peopleId=" + this.peopleId + ", siteId=" + this.siteId + ')';
    }

    public SiteTeacherBean(@JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "peopleId") String peopleId, @JSONField(name = "siteId") String siteId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peopleId, "peopleId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        this.name = name;
        this.peopleId = peopleId;
        this.siteId = siteId;
    }

    public /* synthetic */ SiteTeacherBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPeopleId() {
        return this.peopleId;
    }

    public final void setPeopleId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.peopleId = str;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final void setSiteId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.siteId = str;
    }
}
