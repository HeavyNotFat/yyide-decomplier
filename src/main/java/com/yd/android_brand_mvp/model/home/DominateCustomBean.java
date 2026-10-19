package com.yd.android_brand_mvp.model.home;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DominateCustomBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u009d\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0001J\t\u00106\u001a\u00020\tHÖ\u0001J\u0013\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\tHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0019\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006A"}, d2 = {"Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;", "Landroid/os/Parcelable;", "endDate", "", "schoolId", "id", "title", "brandIds", FirebaseAnalytics.Param.LEVEL, "", "url", "type", "startDate", "status", "modeType", TypedValues.TransitionType.S_DURATION, "isForceExit", "", "groups", "", "Lcom/yd/android_brand_mvp/model/home/CustomItemBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/List;)V", "getBrandIds", "()Ljava/lang/String;", "getDuration", "()I", "getEndDate", "getGroups", "()Ljava/util/List;", "getId", "()Z", "getLevel", "getModeType", "getSchoolId", "getStartDate", "getStatus", "getTitle", "getType", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DominateCustomBean implements Parcelable {
    public static final Parcelable.Creator<DominateCustomBean> CREATOR = new Creator();
    private final String brandIds;
    private final int duration;
    private final String endDate;
    private final List<CustomItemBean> groups;
    private final String id;
    private final boolean isForceExit;
    private final int level;
    private final String modeType;
    private final String schoolId;
    private final String startDate;
    private final String status;
    private final String title;
    private final int type;
    private final String url;

    /* JADX INFO: compiled from: DominateCustomBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DominateCustomBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DominateCustomBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            int i = parcel.readInt();
            String string6 = parcel.readString();
            int i2 = parcel.readInt();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            int i3 = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i4 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i4);
                int i5 = 0;
                while (i5 != i4) {
                    arrayList2.add(CustomItemBean.CREATOR.createFromParcel(parcel));
                    i5++;
                    i4 = i4;
                }
                arrayList = arrayList2;
            }
            return new DominateCustomBean(string, string2, string3, string4, string5, i, string6, i2, string7, string8, string9, i3, z, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DominateCustomBean[] newArray(int i) {
            return new DominateCustomBean[i];
        }
    }

    public DominateCustomBean() {
        this(null, null, null, null, null, 0, null, 0, null, null, null, 0, false, null, 16383, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getModeType() {
        return this.modeType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsForceExit() {
        return this.isForceExit;
    }

    public final List<CustomItemBean> component14() {
        return this.groups;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBrandIds() {
        return this.brandIds;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    public final DominateCustomBean copy(String endDate, String schoolId, String id, String title, String brandIds, int level, String url, int type, String startDate, String status, String modeType, int duration, boolean isForceExit, List<CustomItemBean> groups) {
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(brandIds, "brandIds");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(modeType, "modeType");
        return new DominateCustomBean(endDate, schoolId, id, title, brandIds, level, url, type, startDate, status, modeType, duration, isForceExit, groups);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DominateCustomBean)) {
            return false;
        }
        DominateCustomBean dominateCustomBean = (DominateCustomBean) other;
        return Intrinsics.areEqual(this.endDate, dominateCustomBean.endDate) && Intrinsics.areEqual(this.schoolId, dominateCustomBean.schoolId) && Intrinsics.areEqual(this.id, dominateCustomBean.id) && Intrinsics.areEqual(this.title, dominateCustomBean.title) && Intrinsics.areEqual(this.brandIds, dominateCustomBean.brandIds) && this.level == dominateCustomBean.level && Intrinsics.areEqual(this.url, dominateCustomBean.url) && this.type == dominateCustomBean.type && Intrinsics.areEqual(this.startDate, dominateCustomBean.startDate) && Intrinsics.areEqual(this.status, dominateCustomBean.status) && Intrinsics.areEqual(this.modeType, dominateCustomBean.modeType) && this.duration == dominateCustomBean.duration && this.isForceExit == dominateCustomBean.isForceExit && Intrinsics.areEqual(this.groups, dominateCustomBean.groups);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((this.endDate.hashCode() * 31) + this.schoolId.hashCode()) * 31) + this.id.hashCode()) * 31) + this.title.hashCode()) * 31) + this.brandIds.hashCode()) * 31) + this.level) * 31) + this.url.hashCode()) * 31) + this.type) * 31) + this.startDate.hashCode()) * 31) + this.status.hashCode()) * 31) + this.modeType.hashCode()) * 31) + this.duration) * 31;
        boolean z = this.isForceExit;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        List<CustomItemBean> list = this.groups;
        return i + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "DominateCustomBean(endDate=" + this.endDate + ", schoolId=" + this.schoolId + ", id=" + this.id + ", title=" + this.title + ", brandIds=" + this.brandIds + ", level=" + this.level + ", url=" + this.url + ", type=" + this.type + ", startDate=" + this.startDate + ", status=" + this.status + ", modeType=" + this.modeType + ", duration=" + this.duration + ", isForceExit=" + this.isForceExit + ", groups=" + this.groups + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.endDate);
        parcel.writeString(this.schoolId);
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.brandIds);
        parcel.writeInt(this.level);
        parcel.writeString(this.url);
        parcel.writeInt(this.type);
        parcel.writeString(this.startDate);
        parcel.writeString(this.status);
        parcel.writeString(this.modeType);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.isForceExit ? 1 : 0);
        List<CustomItemBean> list = this.groups;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<CustomItemBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    public DominateCustomBean(String endDate, String schoolId, String id, String title, String brandIds, int i, String url, int i2, String startDate, String status, String modeType, int i3, boolean z, List<CustomItemBean> list) {
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(brandIds, "brandIds");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(modeType, "modeType");
        this.endDate = endDate;
        this.schoolId = schoolId;
        this.id = id;
        this.title = title;
        this.brandIds = brandIds;
        this.level = i;
        this.url = url;
        this.type = i2;
        this.startDate = startDate;
        this.status = status;
        this.modeType = modeType;
        this.duration = i3;
        this.isForceExit = z;
        this.groups = list;
    }

    public /* synthetic */ DominateCustomBean(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, String str7, String str8, String str9, int i3, boolean z, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? "" : str4, (i4 & 16) != 0 ? "" : str5, (i4 & 32) != 0 ? 0 : i, (i4 & 64) != 0 ? "" : str6, (i4 & 128) != 0 ? 0 : i2, (i4 & 256) != 0 ? "" : str7, (i4 & 512) != 0 ? "" : str8, (i4 & 1024) == 0 ? str9 : "", (i4 & 2048) != 0 ? 0 : i3, (i4 & 4096) == 0 ? z : false, (i4 & 8192) != 0 ? null : list);
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBrandIds() {
        return this.brandIds;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getType() {
        return this.type;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getModeType() {
        return this.modeType;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean isForceExit() {
        return this.isForceExit;
    }

    public final List<CustomItemBean> getGroups() {
        return this.groups;
    }
}
