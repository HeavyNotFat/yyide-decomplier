package com.yd.android_brand_mvp.model.userspace;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlowElementBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/FlowElementBean;", "", "flowElementList", "", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "currentApprNum", "", "procType", "updateReason", "", "(Ljava/util/List;IILjava/lang/String;)V", "getCurrentApprNum", "()I", "getFlowElementList", "()Ljava/util/List;", "getProcType", "getUpdateReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlowElementBean {
    private final int currentApprNum;
    private final List<FlowElementListItem> flowElementList;
    private final int procType;
    private final String updateReason;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FlowElementBean copy$default(FlowElementBean flowElementBean, List list, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = flowElementBean.flowElementList;
        }
        if ((i3 & 2) != 0) {
            i = flowElementBean.currentApprNum;
        }
        if ((i3 & 4) != 0) {
            i2 = flowElementBean.procType;
        }
        if ((i3 & 8) != 0) {
            str = flowElementBean.updateReason;
        }
        return flowElementBean.copy(list, i, i2, str);
    }

    public final List<FlowElementListItem> component1() {
        return this.flowElementList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCurrentApprNum() {
        return this.currentApprNum;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getProcType() {
        return this.procType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUpdateReason() {
        return this.updateReason;
    }

    public final FlowElementBean copy(List<FlowElementListItem> flowElementList, int currentApprNum, int procType, String updateReason) {
        Intrinsics.checkNotNullParameter(flowElementList, "flowElementList");
        Intrinsics.checkNotNullParameter(updateReason, "updateReason");
        return new FlowElementBean(flowElementList, currentApprNum, procType, updateReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowElementBean)) {
            return false;
        }
        FlowElementBean flowElementBean = (FlowElementBean) other;
        return Intrinsics.areEqual(this.flowElementList, flowElementBean.flowElementList) && this.currentApprNum == flowElementBean.currentApprNum && this.procType == flowElementBean.procType && Intrinsics.areEqual(this.updateReason, flowElementBean.updateReason);
    }

    public int hashCode() {
        return (((((this.flowElementList.hashCode() * 31) + this.currentApprNum) * 31) + this.procType) * 31) + this.updateReason.hashCode();
    }

    public String toString() {
        return "FlowElementBean(flowElementList=" + this.flowElementList + ", currentApprNum=" + this.currentApprNum + ", procType=" + this.procType + ", updateReason=" + this.updateReason + ')';
    }

    public FlowElementBean(List<FlowElementListItem> flowElementList, int i, int i2, String updateReason) {
        Intrinsics.checkNotNullParameter(flowElementList, "flowElementList");
        Intrinsics.checkNotNullParameter(updateReason, "updateReason");
        this.flowElementList = flowElementList;
        this.currentApprNum = i;
        this.procType = i2;
        this.updateReason = updateReason;
    }

    public final List<FlowElementListItem> getFlowElementList() {
        return this.flowElementList;
    }

    public final int getCurrentApprNum() {
        return this.currentApprNum;
    }

    public final int getProcType() {
        return this.procType;
    }

    public final String getUpdateReason() {
        return this.updateReason;
    }
}
