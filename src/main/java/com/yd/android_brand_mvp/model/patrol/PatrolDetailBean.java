package com.yd.android_brand_mvp.model.patrol;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PatrolDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J³\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0012HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006@"}, d2 = {"Lcom/yd/android_brand_mvp/model/patrol/PatrolDetailBean;", "", "siteRange", "", "finishTime", "dayProjectId", "businessId", "businessName", "typeName", "userId", "businessCode", "startAndEndTime", "executeNames", "formJson", "id", "projectName", "taskId", "status", "", "startTime", "endTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getBusinessCode", "()Ljava/lang/String;", "getBusinessId", "getBusinessName", "getDayProjectId", "getEndTime", "getExecuteNames", "getFinishTime", "getFormJson", "getId", "getProjectName", "getSiteRange", "getStartAndEndTime", "getStartTime", "getStatus", "()I", "getTaskId", "getTypeName", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PatrolDetailBean {
    private final String businessCode;
    private final String businessId;
    private final String businessName;
    private final String dayProjectId;
    private final String endTime;
    private final String executeNames;
    private final String finishTime;
    private final String formJson;
    private final String id;
    private final String projectName;
    private final String siteRange;
    private final String startAndEndTime;
    private final String startTime;
    private final int status;
    private final String taskId;
    private final String typeName;
    private final String userId;

    public PatrolDetailBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 131071, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSiteRange() {
        return this.siteRange;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getExecuteNames() {
        return this.executeNames;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getFormJson() {
        return this.formJson;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getProjectName() {
        return this.projectName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFinishTime() {
        return this.finishTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDayProjectId() {
        return this.dayProjectId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBusinessId() {
        return this.businessId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBusinessName() {
        return this.businessName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTypeName() {
        return this.typeName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBusinessCode() {
        return this.businessCode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStartAndEndTime() {
        return this.startAndEndTime;
    }

    public final PatrolDetailBean copy(String siteRange, String finishTime, String dayProjectId, String businessId, String businessName, String typeName, String userId, String businessCode, String startAndEndTime, String executeNames, String formJson, String id, String projectName, String taskId, int status, String startTime, String endTime) {
        Intrinsics.checkNotNullParameter(siteRange, "siteRange");
        Intrinsics.checkNotNullParameter(finishTime, "finishTime");
        Intrinsics.checkNotNullParameter(dayProjectId, "dayProjectId");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(businessCode, "businessCode");
        Intrinsics.checkNotNullParameter(startAndEndTime, "startAndEndTime");
        Intrinsics.checkNotNullParameter(executeNames, "executeNames");
        Intrinsics.checkNotNullParameter(formJson, "formJson");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        return new PatrolDetailBean(siteRange, finishTime, dayProjectId, businessId, businessName, typeName, userId, businessCode, startAndEndTime, executeNames, formJson, id, projectName, taskId, status, startTime, endTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatrolDetailBean)) {
            return false;
        }
        PatrolDetailBean patrolDetailBean = (PatrolDetailBean) other;
        return Intrinsics.areEqual(this.siteRange, patrolDetailBean.siteRange) && Intrinsics.areEqual(this.finishTime, patrolDetailBean.finishTime) && Intrinsics.areEqual(this.dayProjectId, patrolDetailBean.dayProjectId) && Intrinsics.areEqual(this.businessId, patrolDetailBean.businessId) && Intrinsics.areEqual(this.businessName, patrolDetailBean.businessName) && Intrinsics.areEqual(this.typeName, patrolDetailBean.typeName) && Intrinsics.areEqual(this.userId, patrolDetailBean.userId) && Intrinsics.areEqual(this.businessCode, patrolDetailBean.businessCode) && Intrinsics.areEqual(this.startAndEndTime, patrolDetailBean.startAndEndTime) && Intrinsics.areEqual(this.executeNames, patrolDetailBean.executeNames) && Intrinsics.areEqual(this.formJson, patrolDetailBean.formJson) && Intrinsics.areEqual(this.id, patrolDetailBean.id) && Intrinsics.areEqual(this.projectName, patrolDetailBean.projectName) && Intrinsics.areEqual(this.taskId, patrolDetailBean.taskId) && this.status == patrolDetailBean.status && Intrinsics.areEqual(this.startTime, patrolDetailBean.startTime) && Intrinsics.areEqual(this.endTime, patrolDetailBean.endTime);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.siteRange.hashCode() * 31) + this.finishTime.hashCode()) * 31) + this.dayProjectId.hashCode()) * 31) + this.businessId.hashCode()) * 31) + this.businessName.hashCode()) * 31) + this.typeName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.businessCode.hashCode()) * 31) + this.startAndEndTime.hashCode()) * 31) + this.executeNames.hashCode()) * 31) + this.formJson.hashCode()) * 31) + this.id.hashCode()) * 31) + this.projectName.hashCode()) * 31) + this.taskId.hashCode()) * 31) + this.status) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode();
    }

    public String toString() {
        return "PatrolDetailBean(siteRange=" + this.siteRange + ", finishTime=" + this.finishTime + ", dayProjectId=" + this.dayProjectId + ", businessId=" + this.businessId + ", businessName=" + this.businessName + ", typeName=" + this.typeName + ", userId=" + this.userId + ", businessCode=" + this.businessCode + ", startAndEndTime=" + this.startAndEndTime + ", executeNames=" + this.executeNames + ", formJson=" + this.formJson + ", id=" + this.id + ", projectName=" + this.projectName + ", taskId=" + this.taskId + ", status=" + this.status + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public PatrolDetailBean(String siteRange, String finishTime, String dayProjectId, String businessId, String businessName, String typeName, String userId, String businessCode, String startAndEndTime, String executeNames, String formJson, String id, String projectName, String taskId, int i, String startTime, String endTime) {
        Intrinsics.checkNotNullParameter(siteRange, "siteRange");
        Intrinsics.checkNotNullParameter(finishTime, "finishTime");
        Intrinsics.checkNotNullParameter(dayProjectId, "dayProjectId");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(businessCode, "businessCode");
        Intrinsics.checkNotNullParameter(startAndEndTime, "startAndEndTime");
        Intrinsics.checkNotNullParameter(executeNames, "executeNames");
        Intrinsics.checkNotNullParameter(formJson, "formJson");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.siteRange = siteRange;
        this.finishTime = finishTime;
        this.dayProjectId = dayProjectId;
        this.businessId = businessId;
        this.businessName = businessName;
        this.typeName = typeName;
        this.userId = userId;
        this.businessCode = businessCode;
        this.startAndEndTime = startAndEndTime;
        this.executeNames = executeNames;
        this.formJson = formJson;
        this.id = id;
        this.projectName = projectName;
        this.taskId = taskId;
        this.status = i;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public /* synthetic */ PatrolDetailBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, String str16, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? "" : str9, (i2 & 512) != 0 ? "" : str10, (i2 & 1024) != 0 ? "" : str11, (i2 & 2048) != 0 ? "" : str12, (i2 & 4096) != 0 ? "" : str13, (i2 & 8192) != 0 ? "" : str14, (i2 & 16384) != 0 ? 0 : i, (i2 & 32768) != 0 ? "" : str15, (i2 & 65536) != 0 ? "" : str16);
    }

    public final String getSiteRange() {
        return this.siteRange;
    }

    public final String getFinishTime() {
        return this.finishTime;
    }

    public final String getDayProjectId() {
        return this.dayProjectId;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getBusinessName() {
        return this.businessName;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getBusinessCode() {
        return this.businessCode;
    }

    public final String getStartAndEndTime() {
        return this.startAndEndTime;
    }

    public final String getExecuteNames() {
        return this.executeNames;
    }

    public final String getFormJson() {
        return this.formJson;
    }

    public final String getId() {
        return this.id;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }
}
