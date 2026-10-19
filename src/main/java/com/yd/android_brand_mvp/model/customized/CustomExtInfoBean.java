package com.yd.android_brand_mvp.model.customized;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomExtInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003JW\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/model/customized/CustomExtInfoBean;", "", "belongingCollege", "", "belongingMajor", "emergencyContact", "emergencyContactPhone", "siteLevel", "managerName", "belongingCategories", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBelongingCategories", "()Ljava/util/List;", "getBelongingCollege", "()Ljava/lang/String;", "getBelongingMajor", "getEmergencyContact", "getEmergencyContactPhone", "getManagerName", "getSiteLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomExtInfoBean {
    private final List<String> belongingCategories;
    private final String belongingCollege;
    private final String belongingMajor;
    private final String emergencyContact;
    private final String emergencyContactPhone;
    private final String managerName;
    private final String siteLevel;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomExtInfoBean copy$default(CustomExtInfoBean customExtInfoBean, String str, String str2, String str3, String str4, String str5, String str6, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customExtInfoBean.belongingCollege;
        }
        if ((i & 2) != 0) {
            str2 = customExtInfoBean.belongingMajor;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = customExtInfoBean.emergencyContact;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = customExtInfoBean.emergencyContactPhone;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = customExtInfoBean.siteLevel;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = customExtInfoBean.managerName;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            list = customExtInfoBean.belongingCategories;
        }
        return customExtInfoBean.copy(str, str7, str8, str9, str10, str11, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBelongingCollege() {
        return this.belongingCollege;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBelongingMajor() {
        return this.belongingMajor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmergencyContact() {
        return this.emergencyContact;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmergencyContactPhone() {
        return this.emergencyContactPhone;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSiteLevel() {
        return this.siteLevel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getManagerName() {
        return this.managerName;
    }

    public final List<String> component7() {
        return this.belongingCategories;
    }

    public final CustomExtInfoBean copy(String belongingCollege, String belongingMajor, String emergencyContact, String emergencyContactPhone, String siteLevel, String managerName, List<String> belongingCategories) {
        Intrinsics.checkNotNullParameter(belongingCollege, "belongingCollege");
        Intrinsics.checkNotNullParameter(belongingMajor, "belongingMajor");
        Intrinsics.checkNotNullParameter(emergencyContact, "emergencyContact");
        Intrinsics.checkNotNullParameter(emergencyContactPhone, "emergencyContactPhone");
        Intrinsics.checkNotNullParameter(siteLevel, "siteLevel");
        Intrinsics.checkNotNullParameter(managerName, "managerName");
        return new CustomExtInfoBean(belongingCollege, belongingMajor, emergencyContact, emergencyContactPhone, siteLevel, managerName, belongingCategories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomExtInfoBean)) {
            return false;
        }
        CustomExtInfoBean customExtInfoBean = (CustomExtInfoBean) other;
        return Intrinsics.areEqual(this.belongingCollege, customExtInfoBean.belongingCollege) && Intrinsics.areEqual(this.belongingMajor, customExtInfoBean.belongingMajor) && Intrinsics.areEqual(this.emergencyContact, customExtInfoBean.emergencyContact) && Intrinsics.areEqual(this.emergencyContactPhone, customExtInfoBean.emergencyContactPhone) && Intrinsics.areEqual(this.siteLevel, customExtInfoBean.siteLevel) && Intrinsics.areEqual(this.managerName, customExtInfoBean.managerName) && Intrinsics.areEqual(this.belongingCategories, customExtInfoBean.belongingCategories);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.belongingCollege.hashCode() * 31) + this.belongingMajor.hashCode()) * 31) + this.emergencyContact.hashCode()) * 31) + this.emergencyContactPhone.hashCode()) * 31) + this.siteLevel.hashCode()) * 31) + this.managerName.hashCode()) * 31;
        List<String> list = this.belongingCategories;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "CustomExtInfoBean(belongingCollege=" + this.belongingCollege + ", belongingMajor=" + this.belongingMajor + ", emergencyContact=" + this.emergencyContact + ", emergencyContactPhone=" + this.emergencyContactPhone + ", siteLevel=" + this.siteLevel + ", managerName=" + this.managerName + ", belongingCategories=" + this.belongingCategories + ')';
    }

    public CustomExtInfoBean(String belongingCollege, String belongingMajor, String emergencyContact, String emergencyContactPhone, String siteLevel, String managerName, List<String> list) {
        Intrinsics.checkNotNullParameter(belongingCollege, "belongingCollege");
        Intrinsics.checkNotNullParameter(belongingMajor, "belongingMajor");
        Intrinsics.checkNotNullParameter(emergencyContact, "emergencyContact");
        Intrinsics.checkNotNullParameter(emergencyContactPhone, "emergencyContactPhone");
        Intrinsics.checkNotNullParameter(siteLevel, "siteLevel");
        Intrinsics.checkNotNullParameter(managerName, "managerName");
        this.belongingCollege = belongingCollege;
        this.belongingMajor = belongingMajor;
        this.emergencyContact = emergencyContact;
        this.emergencyContactPhone = emergencyContactPhone;
        this.siteLevel = siteLevel;
        this.managerName = managerName;
        this.belongingCategories = list;
    }

    public /* synthetic */ CustomExtInfoBean(String str, String str2, String str3, String str4, String str5, String str6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? null : list);
    }

    public final String getBelongingCollege() {
        return this.belongingCollege;
    }

    public final String getBelongingMajor() {
        return this.belongingMajor;
    }

    public final String getEmergencyContact() {
        return this.emergencyContact;
    }

    public final String getEmergencyContactPhone() {
        return this.emergencyContactPhone;
    }

    public final String getSiteLevel() {
        return this.siteLevel;
    }

    public final String getManagerName() {
        return this.managerName;
    }

    public final List<String> getBelongingCategories() {
        return this.belongingCategories;
    }
}
