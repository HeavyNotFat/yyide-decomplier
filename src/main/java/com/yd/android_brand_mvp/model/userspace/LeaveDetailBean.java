package com.yd.android_brand_mvp.model.userspace;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003JÉ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0003HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0011HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006G"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "", "businessId", "", "deleteReason", "flowElementList", "", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "procFlowElementList", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementBean;", "id", "identity", "jsonData", AppMeasurementSdk.ConditionalUserProperty.NAME, "procInstId", "promoterTime", "status", "", "oldStatus", "newProcType", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "title", "type", "userId", "fromKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBusinessId", "()Ljava/lang/String;", "getDeleteReason", "getFlowElementList", "()Ljava/util/List;", "getFromKey", "getId", "getIdentity", "getJsonData", "getName", "getNewProcType", "getOldStatus", "()I", "getProcFlowElementList", "getProcInstId", "getPromoterTime", "getStatus", "getStatusCode", "getTitle", "getType", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LeaveDetailBean {
    private final String businessId;
    private final String deleteReason;
    private final List<FlowElementListItem> flowElementList;
    private final String fromKey;
    private final String id;
    private final String identity;
    private final String jsonData;
    private final String name;
    private final String newProcType;
    private final int oldStatus;
    private final List<FlowElementBean> procFlowElementList;
    private final String procInstId;
    private final String promoterTime;
    private final int status;
    private final String statusCode;
    private final String title;
    private final String type;
    private final String userId;

    public LeaveDetailBean() {
        this(null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, 262143, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBusinessId() {
        return this.businessId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPromoterTime() {
        return this.promoterTime;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getOldStatus() {
        return this.oldStatus;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getNewProcType() {
        return this.newProcType;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getFromKey() {
        return this.fromKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeleteReason() {
        return this.deleteReason;
    }

    public final List<FlowElementListItem> component3() {
        return this.flowElementList;
    }

    public final List<FlowElementBean> component4() {
        return this.procFlowElementList;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIdentity() {
        return this.identity;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getJsonData() {
        return this.jsonData;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getProcInstId() {
        return this.procInstId;
    }

    public final LeaveDetailBean copy(String businessId, String deleteReason, List<FlowElementListItem> flowElementList, List<FlowElementBean> procFlowElementList, String id, String identity, String jsonData, String name, String procInstId, String promoterTime, int status, int oldStatus, String newProcType, String statusCode, String title, String type, String userId, String fromKey) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(deleteReason, "deleteReason");
        Intrinsics.checkNotNullParameter(flowElementList, "flowElementList");
        Intrinsics.checkNotNullParameter(procFlowElementList, "procFlowElementList");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(procInstId, "procInstId");
        Intrinsics.checkNotNullParameter(promoterTime, "promoterTime");
        Intrinsics.checkNotNullParameter(newProcType, "newProcType");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(fromKey, "fromKey");
        return new LeaveDetailBean(businessId, deleteReason, flowElementList, procFlowElementList, id, identity, jsonData, name, procInstId, promoterTime, status, oldStatus, newProcType, statusCode, title, type, userId, fromKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveDetailBean)) {
            return false;
        }
        LeaveDetailBean leaveDetailBean = (LeaveDetailBean) other;
        return Intrinsics.areEqual(this.businessId, leaveDetailBean.businessId) && Intrinsics.areEqual(this.deleteReason, leaveDetailBean.deleteReason) && Intrinsics.areEqual(this.flowElementList, leaveDetailBean.flowElementList) && Intrinsics.areEqual(this.procFlowElementList, leaveDetailBean.procFlowElementList) && Intrinsics.areEqual(this.id, leaveDetailBean.id) && Intrinsics.areEqual(this.identity, leaveDetailBean.identity) && Intrinsics.areEqual(this.jsonData, leaveDetailBean.jsonData) && Intrinsics.areEqual(this.name, leaveDetailBean.name) && Intrinsics.areEqual(this.procInstId, leaveDetailBean.procInstId) && Intrinsics.areEqual(this.promoterTime, leaveDetailBean.promoterTime) && this.status == leaveDetailBean.status && this.oldStatus == leaveDetailBean.oldStatus && Intrinsics.areEqual(this.newProcType, leaveDetailBean.newProcType) && Intrinsics.areEqual(this.statusCode, leaveDetailBean.statusCode) && Intrinsics.areEqual(this.title, leaveDetailBean.title) && Intrinsics.areEqual(this.type, leaveDetailBean.type) && Intrinsics.areEqual(this.userId, leaveDetailBean.userId) && Intrinsics.areEqual(this.fromKey, leaveDetailBean.fromKey);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.businessId.hashCode() * 31) + this.deleteReason.hashCode()) * 31) + this.flowElementList.hashCode()) * 31) + this.procFlowElementList.hashCode()) * 31) + this.id.hashCode()) * 31) + this.identity.hashCode()) * 31) + this.jsonData.hashCode()) * 31) + this.name.hashCode()) * 31) + this.procInstId.hashCode()) * 31) + this.promoterTime.hashCode()) * 31) + this.status) * 31) + this.oldStatus) * 31) + this.newProcType.hashCode()) * 31) + this.statusCode.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.fromKey.hashCode();
    }

    public String toString() {
        return "LeaveDetailBean(businessId=" + this.businessId + ", deleteReason=" + this.deleteReason + ", flowElementList=" + this.flowElementList + ", procFlowElementList=" + this.procFlowElementList + ", id=" + this.id + ", identity=" + this.identity + ", jsonData=" + this.jsonData + ", name=" + this.name + ", procInstId=" + this.procInstId + ", promoterTime=" + this.promoterTime + ", status=" + this.status + ", oldStatus=" + this.oldStatus + ", newProcType=" + this.newProcType + ", statusCode=" + this.statusCode + ", title=" + this.title + ", type=" + this.type + ", userId=" + this.userId + ", fromKey=" + this.fromKey + ')';
    }

    public LeaveDetailBean(String businessId, String deleteReason, List<FlowElementListItem> flowElementList, List<FlowElementBean> procFlowElementList, String id, String identity, String jsonData, String name, String procInstId, String promoterTime, int i, int i2, String newProcType, String statusCode, String title, String type, String userId, String fromKey) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(deleteReason, "deleteReason");
        Intrinsics.checkNotNullParameter(flowElementList, "flowElementList");
        Intrinsics.checkNotNullParameter(procFlowElementList, "procFlowElementList");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(procInstId, "procInstId");
        Intrinsics.checkNotNullParameter(promoterTime, "promoterTime");
        Intrinsics.checkNotNullParameter(newProcType, "newProcType");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(fromKey, "fromKey");
        this.businessId = businessId;
        this.deleteReason = deleteReason;
        this.flowElementList = flowElementList;
        this.procFlowElementList = procFlowElementList;
        this.id = id;
        this.identity = identity;
        this.jsonData = jsonData;
        this.name = name;
        this.procInstId = procInstId;
        this.promoterTime = promoterTime;
        this.status = i;
        this.oldStatus = i2;
        this.newProcType = newProcType;
        this.statusCode = statusCode;
        this.title = title;
        this.type = type;
        this.userId = userId;
        this.fromKey = fromKey;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getDeleteReason() {
        return this.deleteReason;
    }

    public /* synthetic */ LeaveDetailBean(String str, String str2, List list, List list2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9, String str10, String str11, String str12, String str13, String str14, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? new ArrayList() : list2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? "" : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? "" : str7, (i3 & 512) != 0 ? "" : str8, (i3 & 1024) != 0 ? 0 : i, (i3 & 2048) != 0 ? -1 : i2, (i3 & 4096) != 0 ? "" : str9, (i3 & 8192) != 0 ? "" : str10, (i3 & 16384) != 0 ? "" : str11, (i3 & 32768) != 0 ? "" : str12, (i3 & 65536) != 0 ? "" : str13, (i3 & 131072) != 0 ? "" : str14);
    }

    public final List<FlowElementListItem> getFlowElementList() {
        return this.flowElementList;
    }

    public final List<FlowElementBean> getProcFlowElementList() {
        return this.procFlowElementList;
    }

    public final String getId() {
        return this.id;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getJsonData() {
        return this.jsonData;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProcInstId() {
        return this.procInstId;
    }

    public final String getPromoterTime() {
        return this.promoterTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getOldStatus() {
        return this.oldStatus;
    }

    public final String getNewProcType() {
        return this.newProcType;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getFromKey() {
        return this.fromKey;
    }
}
