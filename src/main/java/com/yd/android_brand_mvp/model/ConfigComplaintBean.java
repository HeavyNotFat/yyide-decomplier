package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfigComplaintBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0001HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/model/ConfigComplaintBean;", "", "id", "isAnonymity", "", "schoolId", "", "type", "(Ljava/lang/Object;ZLjava/lang/String;Ljava/lang/Object;)V", "getId", "()Ljava/lang/Object;", "()Z", "getSchoolId", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ConfigComplaintBean {
    private final Object id;
    private final boolean isAnonymity;
    private final String schoolId;
    private final Object type;

    public static /* synthetic */ ConfigComplaintBean copy$default(ConfigComplaintBean configComplaintBean, Object obj, boolean z, String str, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = configComplaintBean.id;
        }
        if ((i & 2) != 0) {
            z = configComplaintBean.isAnonymity;
        }
        if ((i & 4) != 0) {
            str = configComplaintBean.schoolId;
        }
        if ((i & 8) != 0) {
            obj2 = configComplaintBean.type;
        }
        return configComplaintBean.copy(obj, z, str, obj2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAnonymity() {
        return this.isAnonymity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getType() {
        return this.type;
    }

    public final ConfigComplaintBean copy(Object id, boolean isAnonymity, String schoolId, Object type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ConfigComplaintBean(id, isAnonymity, schoolId, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigComplaintBean)) {
            return false;
        }
        ConfigComplaintBean configComplaintBean = (ConfigComplaintBean) other;
        return Intrinsics.areEqual(this.id, configComplaintBean.id) && this.isAnonymity == configComplaintBean.isAnonymity && Intrinsics.areEqual(this.schoolId, configComplaintBean.schoolId) && Intrinsics.areEqual(this.type, configComplaintBean.type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        boolean z = this.isAnonymity;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.schoolId.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ConfigComplaintBean(id=" + this.id + ", isAnonymity=" + this.isAnonymity + ", schoolId=" + this.schoolId + ", type=" + this.type + ')';
    }

    public ConfigComplaintBean(Object id, boolean z, String schoolId, Object type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.isAnonymity = z;
        this.schoolId = schoolId;
        this.type = type;
    }

    public final Object getId() {
        return this.id;
    }

    public final boolean isAnonymity() {
        return this.isAnonymity;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final Object getType() {
        return this.type;
    }
}
