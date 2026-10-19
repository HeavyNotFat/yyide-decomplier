package com.yd.android_brand_mvp.model.userspace;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserInfoListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011¨\u00062"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", "", "sex", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "avatar", "id", "type", "userId", "outcome", "comment", "apprTime", "mode", "selected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getApprTime", "()Ljava/lang/String;", "getAvatar", "getComment", "getId", "getMode", "setMode", "(Ljava/lang/String;)V", "getName", "getOutcome", "getSelected", "()Z", "setSelected", "(Z)V", "getSex", "getType", "getUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserInfoListItem {
    private final String apprTime;
    private final String avatar;
    private final String comment;
    private final String id;
    private String mode;
    private final String name;
    private final String outcome;
    private boolean selected;
    private final String sex;
    private final String type;
    private final String userId;

    public UserInfoListItem() {
        this(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSex() {
        return this.sex;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOutcome() {
        return this.outcome;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getApprTime() {
        return this.apprTime;
    }

    public final UserInfoListItem copy(String sex, String name, String avatar, String id, String type, String userId, String outcome, String comment, String apprTime, String mode, boolean selected) {
        Intrinsics.checkNotNullParameter(sex, "sex");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(apprTime, "apprTime");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new UserInfoListItem(sex, name, avatar, id, type, userId, outcome, comment, apprTime, mode, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoListItem)) {
            return false;
        }
        UserInfoListItem userInfoListItem = (UserInfoListItem) other;
        return Intrinsics.areEqual(this.sex, userInfoListItem.sex) && Intrinsics.areEqual(this.name, userInfoListItem.name) && Intrinsics.areEqual(this.avatar, userInfoListItem.avatar) && Intrinsics.areEqual(this.id, userInfoListItem.id) && Intrinsics.areEqual(this.type, userInfoListItem.type) && Intrinsics.areEqual(this.userId, userInfoListItem.userId) && Intrinsics.areEqual(this.outcome, userInfoListItem.outcome) && Intrinsics.areEqual(this.comment, userInfoListItem.comment) && Intrinsics.areEqual(this.apprTime, userInfoListItem.apprTime) && Intrinsics.areEqual(this.mode, userInfoListItem.mode) && this.selected == userInfoListItem.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.sex.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.id.hashCode()) * 31) + this.type.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.outcome.hashCode()) * 31) + this.comment.hashCode()) * 31) + this.apprTime.hashCode()) * 31) + this.mode.hashCode()) * 31;
        boolean z = this.selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "UserInfoListItem(sex=" + this.sex + ", name=" + this.name + ", avatar=" + this.avatar + ", id=" + this.id + ", type=" + this.type + ", userId=" + this.userId + ", outcome=" + this.outcome + ", comment=" + this.comment + ", apprTime=" + this.apprTime + ", mode=" + this.mode + ", selected=" + this.selected + ')';
    }

    public UserInfoListItem(String sex, String name, String avatar, String id, String type, String userId, String outcome, String comment, String apprTime, String mode, boolean z) {
        Intrinsics.checkNotNullParameter(sex, "sex");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(apprTime, "apprTime");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.sex = sex;
        this.name = name;
        this.avatar = avatar;
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.outcome = outcome;
        this.comment = comment;
        this.apprTime = apprTime;
        this.mode = mode;
        this.selected = z;
    }

    public /* synthetic */ UserInfoListItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) == 0 ? str10 : "", (i & 1024) != 0 ? false : z);
    }

    public final String getSex() {
        return this.sex;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getOutcome() {
        return this.outcome;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getApprTime() {
        return this.apprTime;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mode = str;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }
}
