package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorKidsLIstBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorKidsLIstBean;", "", "activityId", "", "activityTitle", PushClientConstants.TAG_CLASS_NAME, "honorTitle", "medalUrl", "obtainTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getActivityTitle", "setActivityTitle", "getClassName", "setClassName", "getHonorTitle", "setHonorTitle", "getMedalUrl", "setMedalUrl", "getObtainTime", "setObtainTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorKidsLIstBean {
    private String activityId;
    private String activityTitle;
    private String className;
    private String honorTitle;
    private String medalUrl;
    private String obtainTime;

    public static /* synthetic */ HonorKidsLIstBean copy$default(HonorKidsLIstBean honorKidsLIstBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorKidsLIstBean.activityId;
        }
        if ((i & 2) != 0) {
            str2 = honorKidsLIstBean.activityTitle;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = honorKidsLIstBean.className;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = honorKidsLIstBean.honorTitle;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = honorKidsLIstBean.medalUrl;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = honorKidsLIstBean.obtainTime;
        }
        return honorKidsLIstBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHonorTitle() {
        return this.honorTitle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getObtainTime() {
        return this.obtainTime;
    }

    public final HonorKidsLIstBean copy(@JSONField(name = "activityId") String activityId, @JSONField(name = "activityTitle") String activityTitle, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String className, @JSONField(name = "honorTitle") String honorTitle, @JSONField(name = "medalUrl") String medalUrl, @JSONField(name = "obtainTime") String obtainTime) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(honorTitle, "honorTitle");
        Intrinsics.checkNotNullParameter(medalUrl, "medalUrl");
        Intrinsics.checkNotNullParameter(obtainTime, "obtainTime");
        return new HonorKidsLIstBean(activityId, activityTitle, className, honorTitle, medalUrl, obtainTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorKidsLIstBean)) {
            return false;
        }
        HonorKidsLIstBean honorKidsLIstBean = (HonorKidsLIstBean) other;
        return Intrinsics.areEqual(this.activityId, honorKidsLIstBean.activityId) && Intrinsics.areEqual(this.activityTitle, honorKidsLIstBean.activityTitle) && Intrinsics.areEqual(this.className, honorKidsLIstBean.className) && Intrinsics.areEqual(this.honorTitle, honorKidsLIstBean.honorTitle) && Intrinsics.areEqual(this.medalUrl, honorKidsLIstBean.medalUrl) && Intrinsics.areEqual(this.obtainTime, honorKidsLIstBean.obtainTime);
    }

    public int hashCode() {
        return (((((((((this.activityId.hashCode() * 31) + this.activityTitle.hashCode()) * 31) + this.className.hashCode()) * 31) + this.honorTitle.hashCode()) * 31) + this.medalUrl.hashCode()) * 31) + this.obtainTime.hashCode();
    }

    public String toString() {
        return "HonorKidsLIstBean(activityId=" + this.activityId + ", activityTitle=" + this.activityTitle + ", className=" + this.className + ", honorTitle=" + this.honorTitle + ", medalUrl=" + this.medalUrl + ", obtainTime=" + this.obtainTime + ')';
    }

    public HonorKidsLIstBean(@JSONField(name = "activityId") String activityId, @JSONField(name = "activityTitle") String activityTitle, @JSONField(name = PushClientConstants.TAG_CLASS_NAME) String className, @JSONField(name = "honorTitle") String honorTitle, @JSONField(name = "medalUrl") String medalUrl, @JSONField(name = "obtainTime") String obtainTime) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(honorTitle, "honorTitle");
        Intrinsics.checkNotNullParameter(medalUrl, "medalUrl");
        Intrinsics.checkNotNullParameter(obtainTime, "obtainTime");
        this.activityId = activityId;
        this.activityTitle = activityTitle;
        this.className = className;
        this.honorTitle = honorTitle;
        this.medalUrl = medalUrl;
        this.obtainTime = obtainTime;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityId = str;
    }

    public final String getActivityTitle() {
        return this.activityTitle;
    }

    public final void setActivityTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityTitle = str;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    public final String getHonorTitle() {
        return this.honorTitle;
    }

    public final void setHonorTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.honorTitle = str;
    }

    public final String getMedalUrl() {
        return this.medalUrl;
    }

    public final void setMedalUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.medalUrl = str;
    }

    public final String getObtainTime() {
        return this.obtainTime;
    }

    public final void setObtainTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.obtainTime = str;
    }
}
