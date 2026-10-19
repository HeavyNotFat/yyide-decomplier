package com.yd.android_brand_mvp.model.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseArrayBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;", "", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "check", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCheck", "()Z", "setCheck", "(Z)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BaseArrayBean {
    private boolean check;
    private final String id;
    private final String name;

    public BaseArrayBean() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ BaseArrayBean copy$default(BaseArrayBean baseArrayBean, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = baseArrayBean.id;
        }
        if ((i & 2) != 0) {
            str2 = baseArrayBean.name;
        }
        if ((i & 4) != 0) {
            z = baseArrayBean.check;
        }
        return baseArrayBean.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCheck() {
        return this.check;
    }

    public final BaseArrayBean copy(String id, String name, boolean check) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new BaseArrayBean(id, name, check);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseArrayBean)) {
            return false;
        }
        BaseArrayBean baseArrayBean = (BaseArrayBean) other;
        return Intrinsics.areEqual(this.id, baseArrayBean.id) && Intrinsics.areEqual(this.name, baseArrayBean.name) && this.check == baseArrayBean.check;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        boolean z = this.check;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "BaseArrayBean(id=" + this.id + ", name=" + this.name + ", check=" + this.check + ')';
    }

    public BaseArrayBean(String id, String name, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.check = z;
    }

    public /* synthetic */ BaseArrayBean(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getCheck() {
        return this.check;
    }

    public final void setCheck(boolean z) {
        this.check = z;
    }
}
