package com.yd.android_brand_mvp.model;

import com.heytap.mcssdk.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/LogBean;", "", "id", "", a.p, "", "Lcom/yd/android_brand_mvp/model/LogChildBean;", "sys_config", "Lcom/yd/android_brand_mvp/model/SysConfig;", "version", "(Ljava/lang/String;Ljava/util/List;Lcom/yd/android_brand_mvp/model/SysConfig;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getParams", "()Ljava/util/List;", "getSys_config", "()Lcom/yd/android_brand_mvp/model/SysConfig;", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogBean {
    private final String id;
    private final List<LogChildBean> params;
    private final SysConfig sys_config;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogBean copy$default(LogBean logBean, String str, List list, SysConfig sysConfig, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logBean.id;
        }
        if ((i & 2) != 0) {
            list = logBean.params;
        }
        if ((i & 4) != 0) {
            sysConfig = logBean.sys_config;
        }
        if ((i & 8) != 0) {
            str2 = logBean.version;
        }
        return logBean.copy(str, list, sysConfig, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<LogChildBean> component2() {
        return this.params;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SysConfig getSys_config() {
        return this.sys_config;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final LogBean copy(String id, List<LogChildBean> params, SysConfig sys_config, String version) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(sys_config, "sys_config");
        Intrinsics.checkNotNullParameter(version, "version");
        return new LogBean(id, params, sys_config, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogBean)) {
            return false;
        }
        LogBean logBean = (LogBean) other;
        return Intrinsics.areEqual(this.id, logBean.id) && Intrinsics.areEqual(this.params, logBean.params) && Intrinsics.areEqual(this.sys_config, logBean.sys_config) && Intrinsics.areEqual(this.version, logBean.version);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.params.hashCode()) * 31) + this.sys_config.hashCode()) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "LogBean(id=" + this.id + ", params=" + this.params + ", sys_config=" + this.sys_config + ", version=" + this.version + ')';
    }

    public LogBean(String id, List<LogChildBean> params, SysConfig sys_config, String version) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(sys_config, "sys_config");
        Intrinsics.checkNotNullParameter(version, "version");
        this.id = id;
        this.params = params;
        this.sys_config = sys_config;
        this.version = version;
    }

    public final String getId() {
        return this.id;
    }

    public final List<LogChildBean> getParams() {
        return this.params;
    }

    public final SysConfig getSys_config() {
        return this.sys_config;
    }

    public final String getVersion() {
        return this.version;
    }
}
