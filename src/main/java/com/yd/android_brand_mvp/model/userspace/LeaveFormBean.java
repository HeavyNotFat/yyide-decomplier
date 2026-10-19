package com.yd.android_brand_mvp.model.userspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveFormBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J©\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u0006:"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/LeaveFormBean;", "", "settings", "", "process", "isStop", "", "promoterType", "fromKey", "icon", "remark", "isNew", "formGroupId", "isDefault", "formItems", "background", "formName", "schoolId", "id", "kitKey", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackground", "()Ljava/lang/String;", "getFormGroupId", "getFormItems", "getFormName", "getFromKey", "getIcon", "getId", "()Z", "getKitKey", "getProcess", "getPromoterType", "getRemark", "getSchoolId", "getSettings", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LeaveFormBean {
    private final String background;
    private final String formGroupId;
    private final String formItems;
    private final String formName;
    private final String fromKey;
    private final String icon;
    private final String id;
    private final boolean isDefault;
    private final boolean isNew;
    private final boolean isStop;
    private final String kitKey;
    private final String process;
    private final String promoterType;
    private final String remark;
    private final String schoolId;
    private final String settings;

    public LeaveFormBean() {
        this(null, null, false, null, null, null, null, false, null, false, null, null, null, null, null, null, 65535, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSettings() {
        return this.settings;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getFormItems() {
        return this.formItems;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFormName() {
        return this.formName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getKitKey() {
        return this.kitKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProcess() {
        return this.process;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsStop() {
        return this.isStop;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPromoterType() {
        return this.promoterType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFromKey() {
        return this.fromKey;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsNew() {
        return this.isNew;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFormGroupId() {
        return this.formGroupId;
    }

    public final LeaveFormBean copy(String settings, String process, boolean isStop, String promoterType, String fromKey, String icon, String remark, boolean isNew, String formGroupId, boolean isDefault, String formItems, String background, String formName, String schoolId, String id, String kitKey) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(promoterType, "promoterType");
        Intrinsics.checkNotNullParameter(fromKey, "fromKey");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(formGroupId, "formGroupId");
        Intrinsics.checkNotNullParameter(formItems, "formItems");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(formName, "formName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(kitKey, "kitKey");
        return new LeaveFormBean(settings, process, isStop, promoterType, fromKey, icon, remark, isNew, formGroupId, isDefault, formItems, background, formName, schoolId, id, kitKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveFormBean)) {
            return false;
        }
        LeaveFormBean leaveFormBean = (LeaveFormBean) other;
        return Intrinsics.areEqual(this.settings, leaveFormBean.settings) && Intrinsics.areEqual(this.process, leaveFormBean.process) && this.isStop == leaveFormBean.isStop && Intrinsics.areEqual(this.promoterType, leaveFormBean.promoterType) && Intrinsics.areEqual(this.fromKey, leaveFormBean.fromKey) && Intrinsics.areEqual(this.icon, leaveFormBean.icon) && Intrinsics.areEqual(this.remark, leaveFormBean.remark) && this.isNew == leaveFormBean.isNew && Intrinsics.areEqual(this.formGroupId, leaveFormBean.formGroupId) && this.isDefault == leaveFormBean.isDefault && Intrinsics.areEqual(this.formItems, leaveFormBean.formItems) && Intrinsics.areEqual(this.background, leaveFormBean.background) && Intrinsics.areEqual(this.formName, leaveFormBean.formName) && Intrinsics.areEqual(this.schoolId, leaveFormBean.schoolId) && Intrinsics.areEqual(this.id, leaveFormBean.id) && Intrinsics.areEqual(this.kitKey, leaveFormBean.kitKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.settings.hashCode() * 31) + this.process.hashCode()) * 31;
        boolean z = this.isStop;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((iHashCode + r1) * 31) + this.promoterType.hashCode()) * 31) + this.fromKey.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.remark.hashCode()) * 31;
        boolean z2 = this.isNew;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r2) * 31) + this.formGroupId.hashCode()) * 31;
        boolean z3 = this.isDefault;
        return ((((((((((((iHashCode3 + (z3 ? 1 : z3)) * 31) + this.formItems.hashCode()) * 31) + this.background.hashCode()) * 31) + this.formName.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.id.hashCode()) * 31) + this.kitKey.hashCode();
    }

    public String toString() {
        return "LeaveFormBean(settings=" + this.settings + ", process=" + this.process + ", isStop=" + this.isStop + ", promoterType=" + this.promoterType + ", fromKey=" + this.fromKey + ", icon=" + this.icon + ", remark=" + this.remark + ", isNew=" + this.isNew + ", formGroupId=" + this.formGroupId + ", isDefault=" + this.isDefault + ", formItems=" + this.formItems + ", background=" + this.background + ", formName=" + this.formName + ", schoolId=" + this.schoolId + ", id=" + this.id + ", kitKey=" + this.kitKey + ')';
    }

    public LeaveFormBean(String settings, String process, boolean z, String promoterType, String fromKey, String icon, String remark, boolean z2, String formGroupId, boolean z3, String formItems, String background, String formName, String schoolId, String id, String kitKey) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(promoterType, "promoterType");
        Intrinsics.checkNotNullParameter(fromKey, "fromKey");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(formGroupId, "formGroupId");
        Intrinsics.checkNotNullParameter(formItems, "formItems");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(formName, "formName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(kitKey, "kitKey");
        this.settings = settings;
        this.process = process;
        this.isStop = z;
        this.promoterType = promoterType;
        this.fromKey = fromKey;
        this.icon = icon;
        this.remark = remark;
        this.isNew = z2;
        this.formGroupId = formGroupId;
        this.isDefault = z3;
        this.formItems = formItems;
        this.background = background;
        this.formName = formName;
        this.schoolId = schoolId;
        this.id = id;
        this.kitKey = kitKey;
    }

    public /* synthetic */ LeaveFormBean(String str, String str2, boolean z, String str3, String str4, String str5, String str6, boolean z2, String str7, boolean z3, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? "" : str7, (i & 512) == 0 ? z3 : false, (i & 1024) != 0 ? "" : str8, (i & 2048) != 0 ? "" : str9, (i & 4096) != 0 ? "" : str10, (i & 8192) != 0 ? "" : str11, (i & 16384) != 0 ? "" : str12, (i & 32768) != 0 ? "" : str13);
    }

    public final String getSettings() {
        return this.settings;
    }

    public final String getProcess() {
        return this.process;
    }

    public final boolean isStop() {
        return this.isStop;
    }

    public final String getPromoterType() {
        return this.promoterType;
    }

    public final String getFromKey() {
        return this.fromKey;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final String getFormGroupId() {
        return this.formGroupId;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final String getFormItems() {
        return this.formItems;
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getFormName() {
        return this.formName;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getKitKey() {
        return this.kitKey;
    }
}
