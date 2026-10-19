package com.yd.android_brand_mvp.model.log;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/model/log/LogContent;", "", "businessParam", "", "Lcom/yd/android_brand_mvp/model/log/BusinessParam;", "inParam", "Lcom/yd/android_brand_mvp/model/log/InParam;", "module", "", "outParam", "Lcom/yd/android_brand_mvp/model/log/OutParam;", "(Ljava/util/List;Lcom/yd/android_brand_mvp/model/log/InParam;Ljava/lang/String;Lcom/yd/android_brand_mvp/model/log/OutParam;)V", "getBusinessParam", "()Ljava/util/List;", "setBusinessParam", "(Ljava/util/List;)V", "getInParam", "()Lcom/yd/android_brand_mvp/model/log/InParam;", "setInParam", "(Lcom/yd/android_brand_mvp/model/log/InParam;)V", "getModule", "()Ljava/lang/String;", "setModule", "(Ljava/lang/String;)V", "getOutParam", "()Lcom/yd/android_brand_mvp/model/log/OutParam;", "setOutParam", "(Lcom/yd/android_brand_mvp/model/log/OutParam;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogContent {
    private List<BusinessParam> businessParam;
    private InParam inParam;
    private String module;
    private OutParam outParam;

    public LogContent() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogContent copy$default(LogContent logContent, List list, InParam inParam, String str, OutParam outParam, int i, Object obj) {
        if ((i & 1) != 0) {
            list = logContent.businessParam;
        }
        if ((i & 2) != 0) {
            inParam = logContent.inParam;
        }
        if ((i & 4) != 0) {
            str = logContent.module;
        }
        if ((i & 8) != 0) {
            outParam = logContent.outParam;
        }
        return logContent.copy(list, inParam, str, outParam);
    }

    public final List<BusinessParam> component1() {
        return this.businessParam;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InParam getInParam() {
        return this.inParam;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OutParam getOutParam() {
        return this.outParam;
    }

    public final LogContent copy(List<BusinessParam> businessParam, InParam inParam, String module, OutParam outParam) {
        return new LogContent(businessParam, inParam, module, outParam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogContent)) {
            return false;
        }
        LogContent logContent = (LogContent) other;
        return Intrinsics.areEqual(this.businessParam, logContent.businessParam) && Intrinsics.areEqual(this.inParam, logContent.inParam) && Intrinsics.areEqual(this.module, logContent.module) && Intrinsics.areEqual(this.outParam, logContent.outParam);
    }

    public int hashCode() {
        List<BusinessParam> list = this.businessParam;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        InParam inParam = this.inParam;
        int iHashCode2 = (iHashCode + (inParam == null ? 0 : inParam.hashCode())) * 31;
        String str = this.module;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        OutParam outParam = this.outParam;
        return iHashCode3 + (outParam != null ? outParam.hashCode() : 0);
    }

    public String toString() {
        return "LogContent(businessParam=" + this.businessParam + ", inParam=" + this.inParam + ", module=" + this.module + ", outParam=" + this.outParam + ')';
    }

    public LogContent(List<BusinessParam> list, InParam inParam, String str, OutParam outParam) {
        this.businessParam = list;
        this.inParam = inParam;
        this.module = str;
        this.outParam = outParam;
    }

    public /* synthetic */ LogContent(List list, InParam inParam, String str, OutParam outParam, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : inParam, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : outParam);
    }

    public final List<BusinessParam> getBusinessParam() {
        return this.businessParam;
    }

    public final void setBusinessParam(List<BusinessParam> list) {
        this.businessParam = list;
    }

    public final InParam getInParam() {
        return this.inParam;
    }

    public final void setInParam(InParam inParam) {
        this.inParam = inParam;
    }

    public final String getModule() {
        return this.module;
    }

    public final void setModule(String str) {
        this.module = str;
    }

    public final OutParam getOutParam() {
        return this.outParam;
    }

    public final void setOutParam(OutParam outParam) {
        this.outParam = outParam;
    }
}
