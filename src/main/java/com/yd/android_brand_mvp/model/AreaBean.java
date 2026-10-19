package com.yd.android_brand_mvp.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AreaBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/model/AreaBean;", "", "area", "", "Lcom/yd/android_brand_mvp/model/AreaItem;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "pid", "", "id", "(Ljava/util/List;Ljava/lang/String;II)V", "getArea", "()Ljava/util/List;", "getId", "()I", "getName", "()Ljava/lang/String;", "getPid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AreaBean {
    private final List<AreaItem> area;
    private final int id;
    private final String name;
    private final int pid;

    public AreaBean() {
        this(null, null, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AreaBean copy$default(AreaBean areaBean, List list, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = areaBean.area;
        }
        if ((i3 & 2) != 0) {
            str = areaBean.name;
        }
        if ((i3 & 4) != 0) {
            i = areaBean.pid;
        }
        if ((i3 & 8) != 0) {
            i2 = areaBean.id;
        }
        return areaBean.copy(list, str, i, i2);
    }

    public final List<AreaItem> component1() {
        return this.area;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPid() {
        return this.pid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final AreaBean copy(List<AreaItem> area, String name, int pid, int id) {
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AreaBean(area, name, pid, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AreaBean)) {
            return false;
        }
        AreaBean areaBean = (AreaBean) other;
        return Intrinsics.areEqual(this.area, areaBean.area) && Intrinsics.areEqual(this.name, areaBean.name) && this.pid == areaBean.pid && this.id == areaBean.id;
    }

    public int hashCode() {
        return (((((this.area.hashCode() * 31) + this.name.hashCode()) * 31) + this.pid) * 31) + this.id;
    }

    public String toString() {
        return "AreaBean(area=" + this.area + ", name=" + this.name + ", pid=" + this.pid + ", id=" + this.id + ')';
    }

    public AreaBean(List<AreaItem> area, String name, int i, int i2) {
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(name, "name");
        this.area = area;
        this.name = name;
        this.pid = i;
        this.id = i2;
    }

    public /* synthetic */ AreaBean(ArrayList arrayList, String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final List<AreaItem> getArea() {
        return this.area;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPid() {
        return this.pid;
    }

    public final int getId() {
        return this.id;
    }
}
