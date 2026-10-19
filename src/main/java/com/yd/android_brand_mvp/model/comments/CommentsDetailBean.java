package com.yd.android_brand_mvp.model.comments;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b?\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u000e¢\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u000eHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u009f\u0001\u0010H\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u000e2\b\b\u0003\u0010\u0010\u001a\u00020\u00052\b\b\u0003\u0010\u0011\u001a\u00020\u00052\b\b\u0003\u0010\u0012\u001a\u00020\u00052\b\b\u0003\u0010\u0013\u001a\u00020\u000eHÆ\u0001J\u0013\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u000eHÖ\u0001J\t\u0010L\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.¨\u0006M"}, d2 = {"Lcom/yd/android_brand_mvp/model/comments/CommentsDetailBean;", "", "anonymity", "", "content", "", "createTime", "id", "replyAvatar", "replyContent", "replyPerson", "replyPersonName", "replyTime", "status", "", "type", "userAvatar", "userId", "userName", "userType", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAnonymity", "()Z", "setAnonymity", "(Z)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "setCreateTime", "getId", "setId", "getReplyAvatar", "setReplyAvatar", "getReplyContent", "setReplyContent", "getReplyPerson", "setReplyPerson", "getReplyPersonName", "setReplyPersonName", "getReplyTime", "setReplyTime", "getStatus", "()I", "setStatus", "(I)V", "getType", "setType", "getUserAvatar", "setUserAvatar", "getUserId", "setUserId", "getUserName", "setUserName", "getUserType", "setUserType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommentsDetailBean {
    private boolean anonymity;
    private String content;
    private String createTime;
    private String id;
    private String replyAvatar;
    private String replyContent;
    private String replyPerson;
    private String replyPersonName;
    private String replyTime;
    private int status;
    private int type;
    private String userAvatar;
    private String userId;
    private String userName;
    private int userType;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAnonymity() {
        return this.anonymity;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReplyAvatar() {
        return this.replyAvatar;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReplyContent() {
        return this.replyContent;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getReplyPerson() {
        return this.replyPerson;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getReplyPersonName() {
        return this.replyPersonName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReplyTime() {
        return this.replyTime;
    }

    public final CommentsDetailBean copy(@JSONField(name = "anonymity") boolean anonymity, @JSONField(name = "content") String content, @JSONField(name = "createTime") String createTime, @JSONField(name = "id") String id, @JSONField(name = "replyAvatar") String replyAvatar, @JSONField(name = "replyContent") String replyContent, @JSONField(name = "replyPerson") String replyPerson, @JSONField(name = "replyPersonName") String replyPersonName, @JSONField(name = "replyTime") String replyTime, @JSONField(name = "status") int status, @JSONField(name = "type") int type, @JSONField(name = "userAvatar") String userAvatar, @JSONField(name = "userId") String userId, @JSONField(name = "userName") String userName, @JSONField(name = "userType") int userType) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(replyAvatar, "replyAvatar");
        Intrinsics.checkNotNullParameter(replyContent, "replyContent");
        Intrinsics.checkNotNullParameter(replyPerson, "replyPerson");
        Intrinsics.checkNotNullParameter(replyPersonName, "replyPersonName");
        Intrinsics.checkNotNullParameter(replyTime, "replyTime");
        Intrinsics.checkNotNullParameter(userAvatar, "userAvatar");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        return new CommentsDetailBean(anonymity, content, createTime, id, replyAvatar, replyContent, replyPerson, replyPersonName, replyTime, status, type, userAvatar, userId, userName, userType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentsDetailBean)) {
            return false;
        }
        CommentsDetailBean commentsDetailBean = (CommentsDetailBean) other;
        return this.anonymity == commentsDetailBean.anonymity && Intrinsics.areEqual(this.content, commentsDetailBean.content) && Intrinsics.areEqual(this.createTime, commentsDetailBean.createTime) && Intrinsics.areEqual(this.id, commentsDetailBean.id) && Intrinsics.areEqual(this.replyAvatar, commentsDetailBean.replyAvatar) && Intrinsics.areEqual(this.replyContent, commentsDetailBean.replyContent) && Intrinsics.areEqual(this.replyPerson, commentsDetailBean.replyPerson) && Intrinsics.areEqual(this.replyPersonName, commentsDetailBean.replyPersonName) && Intrinsics.areEqual(this.replyTime, commentsDetailBean.replyTime) && this.status == commentsDetailBean.status && this.type == commentsDetailBean.type && Intrinsics.areEqual(this.userAvatar, commentsDetailBean.userAvatar) && Intrinsics.areEqual(this.userId, commentsDetailBean.userId) && Intrinsics.areEqual(this.userName, commentsDetailBean.userName) && this.userType == commentsDetailBean.userType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    public int hashCode() {
        boolean z = this.anonymity;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((((((((((((r0 * 31) + this.content.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.replyAvatar.hashCode()) * 31) + this.replyContent.hashCode()) * 31) + this.replyPerson.hashCode()) * 31) + this.replyPersonName.hashCode()) * 31) + this.replyTime.hashCode()) * 31) + this.status) * 31) + this.type) * 31) + this.userAvatar.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.userType;
    }

    public String toString() {
        return "CommentsDetailBean(anonymity=" + this.anonymity + ", content=" + this.content + ", createTime=" + this.createTime + ", id=" + this.id + ", replyAvatar=" + this.replyAvatar + ", replyContent=" + this.replyContent + ", replyPerson=" + this.replyPerson + ", replyPersonName=" + this.replyPersonName + ", replyTime=" + this.replyTime + ", status=" + this.status + ", type=" + this.type + ", userAvatar=" + this.userAvatar + ", userId=" + this.userId + ", userName=" + this.userName + ", userType=" + this.userType + ')';
    }

    public CommentsDetailBean(@JSONField(name = "anonymity") boolean z, @JSONField(name = "content") String content, @JSONField(name = "createTime") String createTime, @JSONField(name = "id") String id, @JSONField(name = "replyAvatar") String replyAvatar, @JSONField(name = "replyContent") String replyContent, @JSONField(name = "replyPerson") String replyPerson, @JSONField(name = "replyPersonName") String replyPersonName, @JSONField(name = "replyTime") String replyTime, @JSONField(name = "status") int i, @JSONField(name = "type") int i2, @JSONField(name = "userAvatar") String userAvatar, @JSONField(name = "userId") String userId, @JSONField(name = "userName") String userName, @JSONField(name = "userType") int i3) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(replyAvatar, "replyAvatar");
        Intrinsics.checkNotNullParameter(replyContent, "replyContent");
        Intrinsics.checkNotNullParameter(replyPerson, "replyPerson");
        Intrinsics.checkNotNullParameter(replyPersonName, "replyPersonName");
        Intrinsics.checkNotNullParameter(replyTime, "replyTime");
        Intrinsics.checkNotNullParameter(userAvatar, "userAvatar");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.anonymity = z;
        this.content = content;
        this.createTime = createTime;
        this.id = id;
        this.replyAvatar = replyAvatar;
        this.replyContent = replyContent;
        this.replyPerson = replyPerson;
        this.replyPersonName = replyPersonName;
        this.replyTime = replyTime;
        this.status = i;
        this.type = i2;
        this.userAvatar = userAvatar;
        this.userId = userId;
        this.userName = userName;
        this.userType = i3;
    }

    public final boolean getAnonymity() {
        return this.anonymity;
    }

    public final void setAnonymity(boolean z) {
        this.anonymity = z;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.createTime = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getReplyAvatar() {
        return this.replyAvatar;
    }

    public final void setReplyAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyAvatar = str;
    }

    public final String getReplyContent() {
        return this.replyContent;
    }

    public final void setReplyContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyContent = str;
    }

    public final String getReplyPerson() {
        return this.replyPerson;
    }

    public final void setReplyPerson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyPerson = str;
    }

    public final String getReplyPersonName() {
        return this.replyPersonName;
    }

    public final void setReplyPersonName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyPersonName = str;
    }

    public final String getReplyTime() {
        return this.replyTime;
    }

    public final void setReplyTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyTime = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getUserAvatar() {
        return this.userAvatar;
    }

    public final void setUserAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userAvatar = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userName = str;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final void setUserType(int i) {
        this.userType = i;
    }
}
