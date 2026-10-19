package com.yd.android_brand_mvp.model.collect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormLocationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/FormLocationBean;", "", "chain", "", "address", "geo", "lat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getChain", "setChain", "getGeo", "setGeo", "getLat", "setLat", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormLocationBean {
    private String address;
    private String chain;
    private String geo;
    private String lat;

    public FormLocationBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FormLocationBean copy$default(FormLocationBean formLocationBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formLocationBean.chain;
        }
        if ((i & 2) != 0) {
            str2 = formLocationBean.address;
        }
        if ((i & 4) != 0) {
            str3 = formLocationBean.geo;
        }
        if ((i & 8) != 0) {
            str4 = formLocationBean.lat;
        }
        return formLocationBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChain() {
        return this.chain;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGeo() {
        return this.geo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLat() {
        return this.lat;
    }

    public final FormLocationBean copy(String chain, String address, String geo, String lat) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(geo, "geo");
        Intrinsics.checkNotNullParameter(lat, "lat");
        return new FormLocationBean(chain, address, geo, lat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormLocationBean)) {
            return false;
        }
        FormLocationBean formLocationBean = (FormLocationBean) other;
        return Intrinsics.areEqual(this.chain, formLocationBean.chain) && Intrinsics.areEqual(this.address, formLocationBean.address) && Intrinsics.areEqual(this.geo, formLocationBean.geo) && Intrinsics.areEqual(this.lat, formLocationBean.lat);
    }

    public int hashCode() {
        return (((((this.chain.hashCode() * 31) + this.address.hashCode()) * 31) + this.geo.hashCode()) * 31) + this.lat.hashCode();
    }

    public String toString() {
        return "FormLocationBean(chain=" + this.chain + ", address=" + this.address + ", geo=" + this.geo + ", lat=" + this.lat + ')';
    }

    public FormLocationBean(String chain, String address, String geo, String lat) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(geo, "geo");
        Intrinsics.checkNotNullParameter(lat, "lat");
        this.chain = chain;
        this.address = address;
        this.geo = geo;
        this.lat = lat;
    }

    public /* synthetic */ FormLocationBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getChain() {
        return this.chain;
    }

    public final void setChain(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.chain = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final String getGeo() {
        return this.geo;
    }

    public final void setGeo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.geo = str;
    }

    public final String getLat() {
        return this.lat;
    }

    public final void setLat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }
}
