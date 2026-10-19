package com.yd.android_brand_mvp.model.userspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveRecordBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\fHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/LeaveRecordBean;", "", "processInstanceId", "", "realName", "jsonData", "startTime", "endTime", "taskName", "title", "taskId", "status", "", "oldStatus", "id", "type", "createTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/String;", "getEndTime", "getId", "getJsonData", "getOldStatus", "()I", "getProcessInstanceId", "getRealName", "getStartTime", "getStatus", "getTaskId", "getTaskName", "getTitle", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LeaveRecordBean {
    private final String createTime;
    private final String endTime;
    private final String id;
    private final String jsonData;
    private final int oldStatus;
    private final String processInstanceId;
    private final String realName;
    private final String startTime;
    private final int status;
    private final String taskId;
    private final String taskName;
    private final String title;
    private final String type;

    public LeaveRecordBean() {
        this(null, null, null, null, null, null, null, null, 0, 0, null, null, null, 8191, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProcessInstanceId() {
        return this.processInstanceId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getOldStatus() {
        return this.oldStatus;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRealName() {
        return this.realName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getJsonData() {
        return this.jsonData;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final LeaveRecordBean copy(String processInstanceId, String realName, String jsonData, String startTime, String endTime, String taskName, String title, String taskId, int status, int oldStatus, String id, String type, String createTime) {
        Intrinsics.checkNotNullParameter(processInstanceId, "processInstanceId");
        Intrinsics.checkNotNullParameter(realName, "realName");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        return new LeaveRecordBean(processInstanceId, realName, jsonData, startTime, endTime, taskName, title, taskId, status, oldStatus, id, type, createTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveRecordBean)) {
            return false;
        }
        LeaveRecordBean leaveRecordBean = (LeaveRecordBean) other;
        return Intrinsics.areEqual(this.processInstanceId, leaveRecordBean.processInstanceId) && Intrinsics.areEqual(this.realName, leaveRecordBean.realName) && Intrinsics.areEqual(this.jsonData, leaveRecordBean.jsonData) && Intrinsics.areEqual(this.startTime, leaveRecordBean.startTime) && Intrinsics.areEqual(this.endTime, leaveRecordBean.endTime) && Intrinsics.areEqual(this.taskName, leaveRecordBean.taskName) && Intrinsics.areEqual(this.title, leaveRecordBean.title) && Intrinsics.areEqual(this.taskId, leaveRecordBean.taskId) && this.status == leaveRecordBean.status && this.oldStatus == leaveRecordBean.oldStatus && Intrinsics.areEqual(this.id, leaveRecordBean.id) && Intrinsics.areEqual(this.type, leaveRecordBean.type) && Intrinsics.areEqual(this.createTime, leaveRecordBean.createTime);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.processInstanceId.hashCode() * 31) + this.realName.hashCode()) * 31) + this.jsonData.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.taskName.hashCode()) * 31) + this.title.hashCode()) * 31) + this.taskId.hashCode()) * 31) + this.status) * 31) + this.oldStatus) * 31) + this.id.hashCode()) * 31) + this.type.hashCode()) * 31) + this.createTime.hashCode();
    }

    public String toString() {
        return "LeaveRecordBean(processInstanceId=" + this.processInstanceId + ", realName=" + this.realName + ", jsonData=" + this.jsonData + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", taskName=" + this.taskName + ", title=" + this.title + ", taskId=" + this.taskId + ", status=" + this.status + ", oldStatus=" + this.oldStatus + ", id=" + this.id + ", type=" + this.type + ", createTime=" + this.createTime + ')';
    }

    public LeaveRecordBean(String processInstanceId, String realName, String jsonData, String startTime, String endTime, String taskName, String title, String taskId, int i, int i2, String id, String type, String createTime) {
        Intrinsics.checkNotNullParameter(processInstanceId, "processInstanceId");
        Intrinsics.checkNotNullParameter(realName, "realName");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        this.processInstanceId = processInstanceId;
        this.realName = realName;
        this.jsonData = jsonData;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskName = taskName;
        this.title = title;
        this.taskId = taskId;
        this.status = i;
        this.oldStatus = i2;
        this.id = id;
        this.type = type;
        this.createTime = createTime;
    }

    public /* synthetic */ LeaveRecordBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9, String str10, String str11, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? 0 : i, (i3 & 512) == 0 ? i2 : 0, (i3 & 1024) != 0 ? "" : str9, (i3 & 2048) != 0 ? "0" : str10, (i3 & 4096) == 0 ? str11 : "");
    }

    public final String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public final String getRealName() {
        return this.realName;
    }

    public final String getJsonData() {
        return this.jsonData;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getOldStatus() {
        return this.oldStatus;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getCreateTime() {
        return this.createTime;
    }
}
