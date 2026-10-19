package com.yd.android_brand_mvp.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebSocketDataParamsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/model/WebSocketDataParamsBean;", "", "deviceNos", "", "", RemoteMessageConst.MessageBody.PARAM, "(Ljava/util/List;Ljava/lang/String;)V", "getDeviceNos", "()Ljava/util/List;", "getParam", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebSocketDataParamsBean {
    private final List<String> deviceNos;
    private final String param;

    public WebSocketDataParamsBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebSocketDataParamsBean copy$default(WebSocketDataParamsBean webSocketDataParamsBean, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = webSocketDataParamsBean.deviceNos;
        }
        if ((i & 2) != 0) {
            str = webSocketDataParamsBean.param;
        }
        return webSocketDataParamsBean.copy(list, str);
    }

    public final List<String> component1() {
        return this.deviceNos;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getParam() {
        return this.param;
    }

    public final WebSocketDataParamsBean copy(List<String> deviceNos, String param) {
        Intrinsics.checkNotNullParameter(deviceNos, "deviceNos");
        Intrinsics.checkNotNullParameter(param, "param");
        return new WebSocketDataParamsBean(deviceNos, param);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketDataParamsBean)) {
            return false;
        }
        WebSocketDataParamsBean webSocketDataParamsBean = (WebSocketDataParamsBean) other;
        return Intrinsics.areEqual(this.deviceNos, webSocketDataParamsBean.deviceNos) && Intrinsics.areEqual(this.param, webSocketDataParamsBean.param);
    }

    public int hashCode() {
        return (this.deviceNos.hashCode() * 31) + this.param.hashCode();
    }

    public String toString() {
        return "WebSocketDataParamsBean(deviceNos=" + this.deviceNos + ", param=" + this.param + ')';
    }

    public WebSocketDataParamsBean(List<String> deviceNos, String param) {
        Intrinsics.checkNotNullParameter(deviceNos, "deviceNos");
        Intrinsics.checkNotNullParameter(param, "param");
        this.deviceNos = deviceNos;
        this.param = param;
    }

    public /* synthetic */ WebSocketDataParamsBean(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? "" : str);
    }

    public final List<String> getDeviceNos() {
        return this.deviceNos;
    }

    public final String getParam() {
        return this.param;
    }
}
