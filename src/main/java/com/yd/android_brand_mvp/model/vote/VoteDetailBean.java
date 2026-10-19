package com.yd.android_brand_mvp.model.vote;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoteDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0002\u0010\u0017J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0004HÆ\u0003J\t\u00108\u001a\u00020\u0004HÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003Jµ\u0001\u0010<\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0007HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006B"}, d2 = {"Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "", "teacherIds", "", "", "title", "type", "", "userName", "userId", "url", "setting", "Lcom/yd/android_brand_mvp/model/vote/Setting;", "schoolId", "options", "Lcom/yd/android_brand_mvp/model/vote/OptionsItem;", "startTime", "endTime", "id", "userType", "desc", "voteDate", "status", "(Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yd/android_brand_mvp/model/vote/Setting;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getEndTime", "getId", "getOptions", "()Ljava/util/List;", "getSchoolId", "getSetting", "()Lcom/yd/android_brand_mvp/model/vote/Setting;", "getStartTime", "getStatus", "()I", "getTeacherIds", "getTitle", "getType", "getUrl", "getUserId", "getUserName", "getUserType", "getVoteDate", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VoteDetailBean {
    private final String desc;
    private final String endTime;
    private final String id;
    private final List<OptionsItem> options;
    private final String schoolId;
    private final Setting setting;
    private final String startTime;
    private final int status;
    private final List<String> teacherIds;
    private final String title;
    private final int type;
    private final String url;
    private final String userId;
    private final String userName;
    private final int userType;
    private final String voteDate;

    public final List<String> component1() {
        return this.teacherIds;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getVoteDate() {
        return this.voteDate;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Setting getSetting() {
        return this.setting;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    public final List<OptionsItem> component9() {
        return this.options;
    }

    public final VoteDetailBean copy(List<String> teacherIds, String title, int type, String userName, String userId, String url, Setting setting, String schoolId, List<OptionsItem> options, String startTime, String endTime, String id, int userType, String desc, String voteDate, int status) {
        Intrinsics.checkNotNullParameter(teacherIds, "teacherIds");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(voteDate, "voteDate");
        return new VoteDetailBean(teacherIds, title, type, userName, userId, url, setting, schoolId, options, startTime, endTime, id, userType, desc, voteDate, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoteDetailBean)) {
            return false;
        }
        VoteDetailBean voteDetailBean = (VoteDetailBean) other;
        return Intrinsics.areEqual(this.teacherIds, voteDetailBean.teacherIds) && Intrinsics.areEqual(this.title, voteDetailBean.title) && this.type == voteDetailBean.type && Intrinsics.areEqual(this.userName, voteDetailBean.userName) && Intrinsics.areEqual(this.userId, voteDetailBean.userId) && Intrinsics.areEqual(this.url, voteDetailBean.url) && Intrinsics.areEqual(this.setting, voteDetailBean.setting) && Intrinsics.areEqual(this.schoolId, voteDetailBean.schoolId) && Intrinsics.areEqual(this.options, voteDetailBean.options) && Intrinsics.areEqual(this.startTime, voteDetailBean.startTime) && Intrinsics.areEqual(this.endTime, voteDetailBean.endTime) && Intrinsics.areEqual(this.id, voteDetailBean.id) && this.userType == voteDetailBean.userType && Intrinsics.areEqual(this.desc, voteDetailBean.desc) && Intrinsics.areEqual(this.voteDate, voteDetailBean.voteDate) && this.status == voteDetailBean.status;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.teacherIds.hashCode() * 31) + this.title.hashCode()) * 31) + this.type) * 31) + this.userName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.url.hashCode()) * 31) + this.setting.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.options.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.userType) * 31) + this.desc.hashCode()) * 31) + this.voteDate.hashCode()) * 31) + this.status;
    }

    public String toString() {
        return "VoteDetailBean(teacherIds=" + this.teacherIds + ", title=" + this.title + ", type=" + this.type + ", userName=" + this.userName + ", userId=" + this.userId + ", url=" + this.url + ", setting=" + this.setting + ", schoolId=" + this.schoolId + ", options=" + this.options + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", id=" + this.id + ", userType=" + this.userType + ", desc=" + this.desc + ", voteDate=" + this.voteDate + ", status=" + this.status + ')';
    }

    public VoteDetailBean(List<String> teacherIds, String title, int i, String userName, String userId, String url, Setting setting, String schoolId, List<OptionsItem> options, String startTime, String endTime, String id, int i2, String desc, String voteDate, int i3) {
        Intrinsics.checkNotNullParameter(teacherIds, "teacherIds");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(voteDate, "voteDate");
        this.teacherIds = teacherIds;
        this.title = title;
        this.type = i;
        this.userName = userName;
        this.userId = userId;
        this.url = url;
        this.setting = setting;
        this.schoolId = schoolId;
        this.options = options;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.userType = i2;
        this.desc = desc;
        this.voteDate = voteDate;
        this.status = i3;
    }

    public /* synthetic */ VoteDetailBean(List list, String str, int i, String str2, String str3, String str4, Setting setting, String str5, List list2, String str6, String str7, String str8, int i2, String str9, String str10, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new ArrayList() : list, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? "" : str4, setting, (i4 & 128) != 0 ? "" : str5, (i4 & 256) != 0 ? new ArrayList() : list2, (i4 & 512) != 0 ? "" : str6, (i4 & 1024) != 0 ? "" : str7, (i4 & 2048) != 0 ? "" : str8, (i4 & 4096) != 0 ? 0 : i2, (i4 & 8192) != 0 ? "" : str9, (i4 & 16384) != 0 ? "" : str10, (i4 & 32768) != 0 ? 0 : i3);
    }

    public final List<String> getTeacherIds() {
        return this.teacherIds;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Setting getSetting() {
        return this.setting;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final List<OptionsItem> getOptions() {
        return this.options;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getId() {
        return this.id;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getVoteDate() {
        return this.voteDate;
    }

    public final int getStatus() {
        return this.status;
    }
}
