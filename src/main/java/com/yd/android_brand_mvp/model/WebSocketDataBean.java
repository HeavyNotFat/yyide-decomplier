package com.yd.android_brand_mvp.model;

import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebSocketDataBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/WebSocketDataBean;", "", "eventCode", "", "interfaceVersion", a.p, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventCode", "()Ljava/lang/String;", "getInterfaceVersion", "getParams", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebSocketDataBean {
    private final String eventCode;
    private final String interfaceVersion;
    private final String params;

    public WebSocketDataBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ WebSocketDataBean copy$default(WebSocketDataBean webSocketDataBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webSocketDataBean.eventCode;
        }
        if ((i & 2) != 0) {
            str2 = webSocketDataBean.interfaceVersion;
        }
        if ((i & 4) != 0) {
            str3 = webSocketDataBean.params;
        }
        return webSocketDataBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventCode() {
        return this.eventCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInterfaceVersion() {
        return this.interfaceVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final WebSocketDataBean copy(String eventCode, String interfaceVersion, String params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(interfaceVersion, "interfaceVersion");
        Intrinsics.checkNotNullParameter(params, "params");
        return new WebSocketDataBean(eventCode, interfaceVersion, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketDataBean)) {
            return false;
        }
        WebSocketDataBean webSocketDataBean = (WebSocketDataBean) other;
        return Intrinsics.areEqual(this.eventCode, webSocketDataBean.eventCode) && Intrinsics.areEqual(this.interfaceVersion, webSocketDataBean.interfaceVersion) && Intrinsics.areEqual(this.params, webSocketDataBean.params);
    }

    public int hashCode() {
        return (((this.eventCode.hashCode() * 31) + this.interfaceVersion.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "WebSocketDataBean(eventCode=" + this.eventCode + ", interfaceVersion=" + this.interfaceVersion + ", params=" + this.params + ')';
    }

    public WebSocketDataBean(String eventCode, String interfaceVersion, String params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(interfaceVersion, "interfaceVersion");
        Intrinsics.checkNotNullParameter(params, "params");
        this.eventCode = eventCode;
        this.interfaceVersion = interfaceVersion;
        this.params = params;
    }

    public /* synthetic */ WebSocketDataBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getEventCode() {
        return this.eventCode;
    }

    public final String getInterfaceVersion() {
        return this.interfaceVersion;
    }

    public final String getParams() {
        return this.params;
    }
}
