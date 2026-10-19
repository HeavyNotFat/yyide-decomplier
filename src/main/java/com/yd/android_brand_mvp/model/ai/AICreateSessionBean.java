package com.yd.android_brand_mvp.model.ai;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AICreateSessionBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/AICreateSessionBean;", "", "assistantId", "", "id", "model", AppMeasurementSdk.ConditionalUserProperty.NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssistantId", "()Ljava/lang/String;", "getId", "getModel", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AICreateSessionBean {
    private final String assistantId;
    private final String id;
    private final String model;
    private final String name;

    public static /* synthetic */ AICreateSessionBean copy$default(AICreateSessionBean aICreateSessionBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aICreateSessionBean.assistantId;
        }
        if ((i & 2) != 0) {
            str2 = aICreateSessionBean.id;
        }
        if ((i & 4) != 0) {
            str3 = aICreateSessionBean.model;
        }
        if ((i & 8) != 0) {
            str4 = aICreateSessionBean.name;
        }
        return aICreateSessionBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAssistantId() {
        return this.assistantId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AICreateSessionBean copy(String assistantId, String id, String model, String name) {
        Intrinsics.checkNotNullParameter(assistantId, "assistantId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AICreateSessionBean(assistantId, id, model, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AICreateSessionBean)) {
            return false;
        }
        AICreateSessionBean aICreateSessionBean = (AICreateSessionBean) other;
        return Intrinsics.areEqual(this.assistantId, aICreateSessionBean.assistantId) && Intrinsics.areEqual(this.id, aICreateSessionBean.id) && Intrinsics.areEqual(this.model, aICreateSessionBean.model) && Intrinsics.areEqual(this.name, aICreateSessionBean.name);
    }

    public int hashCode() {
        return (((((this.assistantId.hashCode() * 31) + this.id.hashCode()) * 31) + this.model.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "AICreateSessionBean(assistantId=" + this.assistantId + ", id=" + this.id + ", model=" + this.model + ", name=" + this.name + ')';
    }

    public AICreateSessionBean(String assistantId, String id, String model, String name) {
        Intrinsics.checkNotNullParameter(assistantId, "assistantId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(name, "name");
        this.assistantId = assistantId;
        this.id = id;
        this.model = model;
        this.name = name;
    }

    public final String getAssistantId() {
        return this.assistantId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }
}
