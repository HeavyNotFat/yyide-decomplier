package com.yd.android_brand_mvp.model.honor;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorWallItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorWallItem;", "", "honorType", "", FirebaseAnalytics.Param.LEVEL, "winnerNames", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "id", "imgPaths", "createTime", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/String;", "getHonorType", "()I", "getId", "getImgPaths", "getLevel", "getName", "setName", "(Ljava/lang/String;)V", "getWinnerNames", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorWallItem {
    private final String createTime;
    private final int honorType;
    private final String id;
    private final String imgPaths;
    private final int level;
    private String name;
    private final String winnerNames;

    public HonorWallItem() {
        this(0, 0, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ HonorWallItem copy$default(HonorWallItem honorWallItem, int i, int i2, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = honorWallItem.honorType;
        }
        if ((i3 & 2) != 0) {
            i2 = honorWallItem.level;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = honorWallItem.winnerNames;
        }
        String str6 = str;
        if ((i3 & 8) != 0) {
            str2 = honorWallItem.name;
        }
        String str7 = str2;
        if ((i3 & 16) != 0) {
            str3 = honorWallItem.id;
        }
        String str8 = str3;
        if ((i3 & 32) != 0) {
            str4 = honorWallItem.imgPaths;
        }
        String str9 = str4;
        if ((i3 & 64) != 0) {
            str5 = honorWallItem.createTime;
        }
        return honorWallItem.copy(i, i4, str6, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHonorType() {
        return this.honorType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWinnerNames() {
        return this.winnerNames;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImgPaths() {
        return this.imgPaths;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    public final HonorWallItem copy(int honorType, int level, String winnerNames, String name, String id, String imgPaths, String createTime) {
        Intrinsics.checkNotNullParameter(winnerNames, "winnerNames");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(imgPaths, "imgPaths");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        return new HonorWallItem(honorType, level, winnerNames, name, id, imgPaths, createTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorWallItem)) {
            return false;
        }
        HonorWallItem honorWallItem = (HonorWallItem) other;
        return this.honorType == honorWallItem.honorType && this.level == honorWallItem.level && Intrinsics.areEqual(this.winnerNames, honorWallItem.winnerNames) && Intrinsics.areEqual(this.name, honorWallItem.name) && Intrinsics.areEqual(this.id, honorWallItem.id) && Intrinsics.areEqual(this.imgPaths, honorWallItem.imgPaths) && Intrinsics.areEqual(this.createTime, honorWallItem.createTime);
    }

    public int hashCode() {
        return (((((((((((this.honorType * 31) + this.level) * 31) + this.winnerNames.hashCode()) * 31) + this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + this.imgPaths.hashCode()) * 31) + this.createTime.hashCode();
    }

    public String toString() {
        return "HonorWallItem(honorType=" + this.honorType + ", level=" + this.level + ", winnerNames=" + this.winnerNames + ", name=" + this.name + ", id=" + this.id + ", imgPaths=" + this.imgPaths + ", createTime=" + this.createTime + ')';
    }

    public HonorWallItem(int i, int i2, String winnerNames, String name, String id, String imgPaths, String createTime) {
        Intrinsics.checkNotNullParameter(winnerNames, "winnerNames");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(imgPaths, "imgPaths");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        this.honorType = i;
        this.level = i2;
        this.winnerNames = winnerNames;
        this.name = name;
        this.id = id;
        this.imgPaths = imgPaths;
        this.createTime = createTime;
    }

    public /* synthetic */ HonorWallItem(int i, int i2, String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? "" : str5);
    }

    public final int getHonorType() {
        return this.honorType;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getWinnerNames() {
        return this.winnerNames;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImgPaths() {
        return this.imgPaths;
    }

    public final String getCreateTime() {
        return this.createTime;
    }
}
