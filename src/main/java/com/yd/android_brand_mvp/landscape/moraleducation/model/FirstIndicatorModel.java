package com.yd.android_brand_mvp.landscape.moraleducation.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirstIndicatorModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/FirstIndicatorModel;", "", "mFirstIndicatorId", "", "mFirstIndicatorName", "mIndicatorDetailList", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/SecondIndicatorModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMFirstIndicatorId", "()Ljava/lang/String;", "getMFirstIndicatorName", "getMIndicatorDetailList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FirstIndicatorModel {

    @SerializedName("firstIndicatorId")
    private final String mFirstIndicatorId;

    @SerializedName("firstIndicatorName")
    private final String mFirstIndicatorName;

    @SerializedName("indicatorDetailList")
    private final List<SecondIndicatorModel> mIndicatorDetailList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirstIndicatorModel copy$default(FirstIndicatorModel firstIndicatorModel, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firstIndicatorModel.mFirstIndicatorId;
        }
        if ((i & 2) != 0) {
            str2 = firstIndicatorModel.mFirstIndicatorName;
        }
        if ((i & 4) != 0) {
            list = firstIndicatorModel.mIndicatorDetailList;
        }
        return firstIndicatorModel.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMFirstIndicatorId() {
        return this.mFirstIndicatorId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMFirstIndicatorName() {
        return this.mFirstIndicatorName;
    }

    public final List<SecondIndicatorModel> component3() {
        return this.mIndicatorDetailList;
    }

    public final FirstIndicatorModel copy(String mFirstIndicatorId, String mFirstIndicatorName, List<SecondIndicatorModel> mIndicatorDetailList) {
        Intrinsics.checkNotNullParameter(mFirstIndicatorId, "mFirstIndicatorId");
        Intrinsics.checkNotNullParameter(mFirstIndicatorName, "mFirstIndicatorName");
        Intrinsics.checkNotNullParameter(mIndicatorDetailList, "mIndicatorDetailList");
        return new FirstIndicatorModel(mFirstIndicatorId, mFirstIndicatorName, mIndicatorDetailList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirstIndicatorModel)) {
            return false;
        }
        FirstIndicatorModel firstIndicatorModel = (FirstIndicatorModel) other;
        return Intrinsics.areEqual(this.mFirstIndicatorId, firstIndicatorModel.mFirstIndicatorId) && Intrinsics.areEqual(this.mFirstIndicatorName, firstIndicatorModel.mFirstIndicatorName) && Intrinsics.areEqual(this.mIndicatorDetailList, firstIndicatorModel.mIndicatorDetailList);
    }

    public int hashCode() {
        return (((this.mFirstIndicatorId.hashCode() * 31) + this.mFirstIndicatorName.hashCode()) * 31) + this.mIndicatorDetailList.hashCode();
    }

    public String toString() {
        return "FirstIndicatorModel(mFirstIndicatorId=" + this.mFirstIndicatorId + ", mFirstIndicatorName=" + this.mFirstIndicatorName + ", mIndicatorDetailList=" + this.mIndicatorDetailList + ')';
    }

    public FirstIndicatorModel(String mFirstIndicatorId, String mFirstIndicatorName, List<SecondIndicatorModel> mIndicatorDetailList) {
        Intrinsics.checkNotNullParameter(mFirstIndicatorId, "mFirstIndicatorId");
        Intrinsics.checkNotNullParameter(mFirstIndicatorName, "mFirstIndicatorName");
        Intrinsics.checkNotNullParameter(mIndicatorDetailList, "mIndicatorDetailList");
        this.mFirstIndicatorId = mFirstIndicatorId;
        this.mFirstIndicatorName = mFirstIndicatorName;
        this.mIndicatorDetailList = mIndicatorDetailList;
    }

    public final String getMFirstIndicatorId() {
        return this.mFirstIndicatorId;
    }

    public final String getMFirstIndicatorName() {
        return this.mFirstIndicatorName;
    }

    public final List<SecondIndicatorModel> getMIndicatorDetailList() {
        return this.mIndicatorDetailList;
    }
}
