package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeatherListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/model/NewWeatherListBean;", "Landroid/os/Parcelable;", "area", "", "areaid", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/NewWeatherItemBean;", "province", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getArea", "()Ljava/lang/String;", "getAreaid", "getList", "()Ljava/util/List;", "getProvince", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NewWeatherListBean implements Parcelable {
    public static final Parcelable.Creator<NewWeatherListBean> CREATOR = new Creator();
    private final String area;
    private final String areaid;
    private final List<NewWeatherItemBean> list;
    private final String province;

    /* JADX INFO: compiled from: NewWeatherListBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NewWeatherListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherListBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(NewWeatherItemBean.CREATOR.createFromParcel(parcel));
            }
            return new NewWeatherListBean(string, string2, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewWeatherListBean[] newArray(int i) {
            return new NewWeatherListBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewWeatherListBean copy$default(NewWeatherListBean newWeatherListBean, String str, String str2, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newWeatherListBean.area;
        }
        if ((i & 2) != 0) {
            str2 = newWeatherListBean.areaid;
        }
        if ((i & 4) != 0) {
            list = newWeatherListBean.list;
        }
        if ((i & 8) != 0) {
            str3 = newWeatherListBean.province;
        }
        return newWeatherListBean.copy(str, str2, list, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAreaid() {
        return this.areaid;
    }

    public final List<NewWeatherItemBean> component3() {
        return this.list;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    public final NewWeatherListBean copy(String area, String areaid, List<NewWeatherItemBean> list, String province) {
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(areaid, "areaid");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(province, "province");
        return new NewWeatherListBean(area, areaid, list, province);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewWeatherListBean)) {
            return false;
        }
        NewWeatherListBean newWeatherListBean = (NewWeatherListBean) other;
        return Intrinsics.areEqual(this.area, newWeatherListBean.area) && Intrinsics.areEqual(this.areaid, newWeatherListBean.areaid) && Intrinsics.areEqual(this.list, newWeatherListBean.list) && Intrinsics.areEqual(this.province, newWeatherListBean.province);
    }

    public int hashCode() {
        return (((((this.area.hashCode() * 31) + this.areaid.hashCode()) * 31) + this.list.hashCode()) * 31) + this.province.hashCode();
    }

    public String toString() {
        return "NewWeatherListBean(area=" + this.area + ", areaid=" + this.areaid + ", list=" + this.list + ", province=" + this.province + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.area);
        parcel.writeString(this.areaid);
        List<NewWeatherItemBean> list = this.list;
        parcel.writeInt(list.size());
        Iterator<NewWeatherItemBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.province);
    }

    public NewWeatherListBean(String area, String areaid, List<NewWeatherItemBean> list, String province) {
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(areaid, "areaid");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(province, "province");
        this.area = area;
        this.areaid = areaid;
        this.list = list;
        this.province = province;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getAreaid() {
        return this.areaid;
    }

    public final List<NewWeatherItemBean> getList() {
        return this.list;
    }

    public final String getProvince() {
        return this.province;
    }
}
