package com.yd.android_brand_mvp.model.ai;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIProblemBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003JÓ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0003HÆ\u0001J\u0013\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010#R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010#R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006I"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/AIProblemBean;", "", "bannerUrl", "", a.j, "createBy", "createTime", a.h, "externalId", "iconUrl", "id", "isOfficial", "", "isPublic", "model", AppMeasurementSdk.ConditionalUserProperty.NAME, "properties", "Lcom/yd/android_brand_mvp/model/ai/Properties;", "subType", "tenantId", "type", "updateBy", "updateTime", "userId", "workspaceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lcom/yd/android_brand_mvp/model/ai/Properties;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBannerUrl", "()Ljava/lang/String;", "getCode", "getCreateBy", "getCreateTime", "getDescription", "getExternalId", "getIconUrl", "getId", "()Z", "getModel", "getName", "getProperties", "()Lcom/yd/android_brand_mvp/model/ai/Properties;", "getSubType", "getTenantId", "getType", "getUpdateBy", "getUpdateTime", "getUserId", "getWorkspaceId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AIProblemBean {
    private final String bannerUrl;
    private final String code;
    private final String createBy;
    private final String createTime;
    private final String description;
    private final String externalId;
    private final String iconUrl;
    private final String id;
    private final boolean isOfficial;
    private final boolean isPublic;
    private final String model;
    private final String name;
    private final Properties properties;
    private final String subType;
    private final String tenantId;
    private final String type;
    private final String updateBy;
    private final String updateTime;
    private final String userId;
    private final String workspaceId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Properties getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getUpdateBy() {
        return this.updateBy;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getWorkspaceId() {
        return this.workspaceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreateBy() {
        return this.createBy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsOfficial() {
        return this.isOfficial;
    }

    public final AIProblemBean copy(String bannerUrl, String code, String createBy, String createTime, String description, String externalId, String iconUrl, String id, boolean isOfficial, boolean isPublic, String model, String name, Properties properties, String subType, String tenantId, String type, String updateBy, String updateTime, String userId, String workspaceId) {
        Intrinsics.checkNotNullParameter(bannerUrl, "bannerUrl");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(updateBy, "updateBy");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(workspaceId, "workspaceId");
        return new AIProblemBean(bannerUrl, code, createBy, createTime, description, externalId, iconUrl, id, isOfficial, isPublic, model, name, properties, subType, tenantId, type, updateBy, updateTime, userId, workspaceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIProblemBean)) {
            return false;
        }
        AIProblemBean aIProblemBean = (AIProblemBean) other;
        return Intrinsics.areEqual(this.bannerUrl, aIProblemBean.bannerUrl) && Intrinsics.areEqual(this.code, aIProblemBean.code) && Intrinsics.areEqual(this.createBy, aIProblemBean.createBy) && Intrinsics.areEqual(this.createTime, aIProblemBean.createTime) && Intrinsics.areEqual(this.description, aIProblemBean.description) && Intrinsics.areEqual(this.externalId, aIProblemBean.externalId) && Intrinsics.areEqual(this.iconUrl, aIProblemBean.iconUrl) && Intrinsics.areEqual(this.id, aIProblemBean.id) && this.isOfficial == aIProblemBean.isOfficial && this.isPublic == aIProblemBean.isPublic && Intrinsics.areEqual(this.model, aIProblemBean.model) && Intrinsics.areEqual(this.name, aIProblemBean.name) && Intrinsics.areEqual(this.properties, aIProblemBean.properties) && Intrinsics.areEqual(this.subType, aIProblemBean.subType) && Intrinsics.areEqual(this.tenantId, aIProblemBean.tenantId) && Intrinsics.areEqual(this.type, aIProblemBean.type) && Intrinsics.areEqual(this.updateBy, aIProblemBean.updateBy) && Intrinsics.areEqual(this.updateTime, aIProblemBean.updateTime) && Intrinsics.areEqual(this.userId, aIProblemBean.userId) && Intrinsics.areEqual(this.workspaceId, aIProblemBean.workspaceId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.bannerUrl.hashCode() * 31) + this.code.hashCode()) * 31) + this.createBy.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.description.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.id.hashCode()) * 31;
        boolean z = this.isOfficial;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isPublic;
        int iHashCode2 = (((((i + (z2 ? 1 : z2)) * 31) + this.model.hashCode()) * 31) + this.name.hashCode()) * 31;
        Properties properties = this.properties;
        return ((((((((((((((iHashCode2 + (properties == null ? 0 : properties.hashCode())) * 31) + this.subType.hashCode()) * 31) + this.tenantId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.updateBy.hashCode()) * 31) + this.updateTime.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.workspaceId.hashCode();
    }

    public String toString() {
        return "AIProblemBean(bannerUrl=" + this.bannerUrl + ", code=" + this.code + ", createBy=" + this.createBy + ", createTime=" + this.createTime + ", description=" + this.description + ", externalId=" + this.externalId + ", iconUrl=" + this.iconUrl + ", id=" + this.id + ", isOfficial=" + this.isOfficial + ", isPublic=" + this.isPublic + ", model=" + this.model + ", name=" + this.name + ", properties=" + this.properties + ", subType=" + this.subType + ", tenantId=" + this.tenantId + ", type=" + this.type + ", updateBy=" + this.updateBy + ", updateTime=" + this.updateTime + ", userId=" + this.userId + ", workspaceId=" + this.workspaceId + ')';
    }

    public AIProblemBean(String bannerUrl, String code, String createBy, String createTime, String description, String externalId, String iconUrl, String id, boolean z, boolean z2, String model, String name, Properties properties, String subType, String tenantId, String type, String updateBy, String updateTime, String userId, String workspaceId) {
        Intrinsics.checkNotNullParameter(bannerUrl, "bannerUrl");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(updateBy, "updateBy");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(workspaceId, "workspaceId");
        this.bannerUrl = bannerUrl;
        this.code = code;
        this.createBy = createBy;
        this.createTime = createTime;
        this.description = description;
        this.externalId = externalId;
        this.iconUrl = iconUrl;
        this.id = id;
        this.isOfficial = z;
        this.isPublic = z2;
        this.model = model;
        this.name = name;
        this.properties = properties;
        this.subType = subType;
        this.tenantId = tenantId;
        this.type = type;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.userId = userId;
        this.workspaceId = workspaceId;
    }

    public /* synthetic */ AIProblemBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, Properties properties, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, (i & 4096) != 0 ? null : properties, str11, str12, str13, str14, str15, str16, str17);
    }

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCreateBy() {
        return this.createBy;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isOfficial() {
        return this.isOfficial;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final Properties getProperties() {
        return this.properties;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUpdateBy() {
        return this.updateBy;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getWorkspaceId() {
        return this.workspaceId;
    }
}
