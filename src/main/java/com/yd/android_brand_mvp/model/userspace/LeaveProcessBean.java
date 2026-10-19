package com.yd.android_brand_mvp.model.userspace;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveProcessBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/LeaveProcessBean;", "", "formProcessTemplatesId", "", "formKey", "flowElementList", "", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFlowElementList", "()Ljava/util/List;", "getFormKey", "()Ljava/lang/String;", "getFormProcessTemplatesId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LeaveProcessBean {
    private final List<FlowElementListItem> flowElementList;
    private final String formKey;
    private final String formProcessTemplatesId;

    public LeaveProcessBean() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LeaveProcessBean copy$default(LeaveProcessBean leaveProcessBean, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveProcessBean.formProcessTemplatesId;
        }
        if ((i & 2) != 0) {
            str2 = leaveProcessBean.formKey;
        }
        if ((i & 4) != 0) {
            list = leaveProcessBean.flowElementList;
        }
        return leaveProcessBean.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFormProcessTemplatesId() {
        return this.formProcessTemplatesId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFormKey() {
        return this.formKey;
    }

    public final List<FlowElementListItem> component3() {
        return this.flowElementList;
    }

    public final LeaveProcessBean copy(String formProcessTemplatesId, String formKey, List<FlowElementListItem> flowElementList) {
        Intrinsics.checkNotNullParameter(formProcessTemplatesId, "formProcessTemplatesId");
        Intrinsics.checkNotNullParameter(formKey, "formKey");
        Intrinsics.checkNotNullParameter(flowElementList, "flowElementList");
        return new LeaveProcessBean(formProcessTemplatesId, formKey, flowElementList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveProcessBean)) {
            return false;
        }
        LeaveProcessBean leaveProcessBean = (LeaveProcessBean) other;
        return Intrinsics.areEqual(this.formProcessTemplatesId, leaveProcessBean.formProcessTemplatesId) && Intrinsics.areEqual(this.formKey, leaveProcessBean.formKey) && Intrinsics.areEqual(this.flowElementList, leaveProcessBean.flowElementList);
    }

    public int hashCode() {
        return (((this.formProcessTemplatesId.hashCode() * 31) + this.formKey.hashCode()) * 31) + this.flowElementList.hashCode();
    }

    public String toString() {
        return "LeaveProcessBean(formProcessTemplatesId=" + this.formProcessTemplatesId + ", formKey=" + this.formKey + ", flowElementList=" + this.flowElementList + ')';
    }

    public LeaveProcessBean(String formProcessTemplatesId, String formKey, List<FlowElementListItem> flowElementList) {
        Intrinsics.checkNotNullParameter(formProcessTemplatesId, "formProcessTemplatesId");
        Intrinsics.checkNotNullParameter(formKey, "formKey");
        Intrinsics.checkNotNullParameter(flowElementList, "flowElementList");
        this.formProcessTemplatesId = formProcessTemplatesId;
        this.formKey = formKey;
        this.flowElementList = flowElementList;
    }

    public final String getFormProcessTemplatesId() {
        return this.formProcessTemplatesId;
    }

    public final String getFormKey() {
        return this.formKey;
    }

    public /* synthetic */ LeaveProcessBean(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : arrayList);
    }

    public final List<FlowElementListItem> getFlowElementList() {
        return this.flowElementList;
    }
}
