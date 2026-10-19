package com.yd.android_brand_mvp.model.customized;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomSiteInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/model/customized/CustomSiteInfoBean;", "", "extInfo", "Lcom/yd/android_brand_mvp/model/customized/CustomExtInfoBean;", "id", "", "images", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "roomNum", "siteId", "(Lcom/yd/android_brand_mvp/model/customized/CustomExtInfoBean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtInfo", "()Lcom/yd/android_brand_mvp/model/customized/CustomExtInfoBean;", "getId", "()Ljava/lang/String;", "getImages", "()Ljava/util/List;", "getName", "getRoomNum", "getSiteId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomSiteInfoBean {
    private final CustomExtInfoBean extInfo;
    private final String id;
    private final List<String> images;
    private final String name;
    private final String roomNum;
    private final String siteId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomSiteInfoBean copy$default(CustomSiteInfoBean customSiteInfoBean, CustomExtInfoBean customExtInfoBean, String str, List list, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            customExtInfoBean = customSiteInfoBean.extInfo;
        }
        if ((i & 2) != 0) {
            str = customSiteInfoBean.id;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            list = customSiteInfoBean.images;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            str2 = customSiteInfoBean.name;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = customSiteInfoBean.roomNum;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = customSiteInfoBean.siteId;
        }
        return customSiteInfoBean.copy(customExtInfoBean, str5, list2, str6, str7, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CustomExtInfoBean getExtInfo() {
        return this.extInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component3() {
        return this.images;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRoomNum() {
        return this.roomNum;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    public final CustomSiteInfoBean copy(CustomExtInfoBean extInfo, String id, List<String> images, String name, String roomNum, String siteId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        return new CustomSiteInfoBean(extInfo, id, images, name, roomNum, siteId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomSiteInfoBean)) {
            return false;
        }
        CustomSiteInfoBean customSiteInfoBean = (CustomSiteInfoBean) other;
        return Intrinsics.areEqual(this.extInfo, customSiteInfoBean.extInfo) && Intrinsics.areEqual(this.id, customSiteInfoBean.id) && Intrinsics.areEqual(this.images, customSiteInfoBean.images) && Intrinsics.areEqual(this.name, customSiteInfoBean.name) && Intrinsics.areEqual(this.roomNum, customSiteInfoBean.roomNum) && Intrinsics.areEqual(this.siteId, customSiteInfoBean.siteId);
    }

    public int hashCode() {
        CustomExtInfoBean customExtInfoBean = this.extInfo;
        int iHashCode = (((customExtInfoBean == null ? 0 : customExtInfoBean.hashCode()) * 31) + this.id.hashCode()) * 31;
        List<String> list = this.images;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.roomNum.hashCode()) * 31) + this.siteId.hashCode();
    }

    public String toString() {
        return "CustomSiteInfoBean(extInfo=" + this.extInfo + ", id=" + this.id + ", images=" + this.images + ", name=" + this.name + ", roomNum=" + this.roomNum + ", siteId=" + this.siteId + ')';
    }

    public CustomSiteInfoBean(CustomExtInfoBean customExtInfoBean, String id, List<String> list, String name, String roomNum, String siteId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        this.extInfo = customExtInfoBean;
        this.id = id;
        this.images = list;
        this.name = name;
        this.roomNum = roomNum;
        this.siteId = siteId;
    }

    public final CustomExtInfoBean getExtInfo() {
        return this.extInfo;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoomNum() {
        return this.roomNum;
    }

    public final String getSiteId() {
        return this.siteId;
    }
}
