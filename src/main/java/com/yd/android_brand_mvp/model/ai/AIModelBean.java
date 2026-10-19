package com.yd.android_brand_mvp.model.ai;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.heytap.mcssdk.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIModelBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0001HÆ\u0003J\t\u0010 \u001a\u00020\u0001HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J}\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0001HÆ\u0001J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/AIModelBean;", "", "capabilities", "", "", "chatAppId", a.j, a.h, "iconUrl", "id", "isAssistantEnabled", "", "isChatEnabled", AppMeasurementSdk.ConditionalUserProperty.NAME, "ordinal", "properties", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getCapabilities", "()Ljava/util/List;", "getChatAppId", "()Ljava/lang/String;", "getCode", "getDescription", "getIconUrl", "getId", "()Z", "getName", "getOrdinal", "()Ljava/lang/Object;", "getProperties", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AIModelBean {
    private final List<String> capabilities;
    private final String chatAppId;
    private final String code;
    private final String description;
    private final String iconUrl;
    private final String id;
    private final boolean isAssistantEnabled;
    private final boolean isChatEnabled;
    private final String name;
    private final Object ordinal;
    private final Object properties;

    public final List<String> component1() {
        return this.capabilities;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Object getOrdinal() {
        return this.ordinal;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Object getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChatAppId() {
        return this.chatAppId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsAssistantEnabled() {
        return this.isAssistantEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsChatEnabled() {
        return this.isChatEnabled;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AIModelBean copy(List<String> capabilities, String chatAppId, String code, String description, String iconUrl, String id, boolean isAssistantEnabled, boolean isChatEnabled, String name, Object ordinal, Object properties) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(chatAppId, "chatAppId");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ordinal, "ordinal");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new AIModelBean(capabilities, chatAppId, code, description, iconUrl, id, isAssistantEnabled, isChatEnabled, name, ordinal, properties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIModelBean)) {
            return false;
        }
        AIModelBean aIModelBean = (AIModelBean) other;
        return Intrinsics.areEqual(this.capabilities, aIModelBean.capabilities) && Intrinsics.areEqual(this.chatAppId, aIModelBean.chatAppId) && Intrinsics.areEqual(this.code, aIModelBean.code) && Intrinsics.areEqual(this.description, aIModelBean.description) && Intrinsics.areEqual(this.iconUrl, aIModelBean.iconUrl) && Intrinsics.areEqual(this.id, aIModelBean.id) && this.isAssistantEnabled == aIModelBean.isAssistantEnabled && this.isChatEnabled == aIModelBean.isChatEnabled && Intrinsics.areEqual(this.name, aIModelBean.name) && Intrinsics.areEqual(this.ordinal, aIModelBean.ordinal) && Intrinsics.areEqual(this.properties, aIModelBean.properties);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((this.capabilities.hashCode() * 31) + this.chatAppId.hashCode()) * 31) + this.code.hashCode()) * 31) + this.description.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.id.hashCode()) * 31;
        boolean z = this.isAssistantEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isChatEnabled;
        return ((((((i + (z2 ? 1 : z2)) * 31) + this.name.hashCode()) * 31) + this.ordinal.hashCode()) * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "AIModelBean(capabilities=" + this.capabilities + ", chatAppId=" + this.chatAppId + ", code=" + this.code + ", description=" + this.description + ", iconUrl=" + this.iconUrl + ", id=" + this.id + ", isAssistantEnabled=" + this.isAssistantEnabled + ", isChatEnabled=" + this.isChatEnabled + ", name=" + this.name + ", ordinal=" + this.ordinal + ", properties=" + this.properties + ')';
    }

    public AIModelBean(List<String> capabilities, String chatAppId, String code, String description, String iconUrl, String id, boolean z, boolean z2, String name, Object ordinal, Object properties) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(chatAppId, "chatAppId");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ordinal, "ordinal");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.capabilities = capabilities;
        this.chatAppId = chatAppId;
        this.code = code;
        this.description = description;
        this.iconUrl = iconUrl;
        this.id = id;
        this.isAssistantEnabled = z;
        this.isChatEnabled = z2;
        this.name = name;
        this.ordinal = ordinal;
        this.properties = properties;
    }

    public final List<String> getCapabilities() {
        return this.capabilities;
    }

    public final String getChatAppId() {
        return this.chatAppId;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isAssistantEnabled() {
        return this.isAssistantEnabled;
    }

    public final boolean isChatEnabled() {
        return this.isChatEnabled;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getOrdinal() {
        return this.ordinal;
    }

    public final Object getProperties() {
        return this.properties;
    }
}
