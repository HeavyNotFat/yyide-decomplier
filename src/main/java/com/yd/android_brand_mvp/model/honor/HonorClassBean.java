package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorClassBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorClassBean;", "", "activityId", "", "activityTime", "medalUrl", "promotionalImage", "ranking", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getActivityTime", "setActivityTime", "getMedalUrl", "setMedalUrl", "getPromotionalImage", "setPromotionalImage", "getRanking", "setRanking", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorClassBean {
    private String activityId;
    private String activityTime;
    private String medalUrl;
    private String promotionalImage;
    private String ranking;
    private String title;

    public static /* synthetic */ HonorClassBean copy$default(HonorClassBean honorClassBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorClassBean.activityId;
        }
        if ((i & 2) != 0) {
            str2 = honorClassBean.activityTime;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = honorClassBean.medalUrl;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = honorClassBean.promotionalImage;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = honorClassBean.ranking;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = honorClassBean.title;
        }
        return honorClassBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityTime() {
        return this.activityTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPromotionalImage() {
        return this.promotionalImage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRanking() {
        return this.ranking;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final HonorClassBean copy(@JSONField(name = "activityId") String activityId, @JSONField(name = "activityTime") String activityTime, @JSONField(name = "medalUrl") String medalUrl, @JSONField(name = "promotionalImage") String promotionalImage, @JSONField(name = "ranking") String ranking, @JSONField(name = "title") String title) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(medalUrl, "medalUrl");
        Intrinsics.checkNotNullParameter(promotionalImage, "promotionalImage");
        Intrinsics.checkNotNullParameter(ranking, "ranking");
        Intrinsics.checkNotNullParameter(title, "title");
        return new HonorClassBean(activityId, activityTime, medalUrl, promotionalImage, ranking, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorClassBean)) {
            return false;
        }
        HonorClassBean honorClassBean = (HonorClassBean) other;
        return Intrinsics.areEqual(this.activityId, honorClassBean.activityId) && Intrinsics.areEqual(this.activityTime, honorClassBean.activityTime) && Intrinsics.areEqual(this.medalUrl, honorClassBean.medalUrl) && Intrinsics.areEqual(this.promotionalImage, honorClassBean.promotionalImage) && Intrinsics.areEqual(this.ranking, honorClassBean.ranking) && Intrinsics.areEqual(this.title, honorClassBean.title);
    }

    public int hashCode() {
        return (((((((((this.activityId.hashCode() * 31) + this.activityTime.hashCode()) * 31) + this.medalUrl.hashCode()) * 31) + this.promotionalImage.hashCode()) * 31) + this.ranking.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "HonorClassBean(activityId=" + this.activityId + ", activityTime=" + this.activityTime + ", medalUrl=" + this.medalUrl + ", promotionalImage=" + this.promotionalImage + ", ranking=" + this.ranking + ", title=" + this.title + ')';
    }

    public HonorClassBean(@JSONField(name = "activityId") String activityId, @JSONField(name = "activityTime") String activityTime, @JSONField(name = "medalUrl") String medalUrl, @JSONField(name = "promotionalImage") String promotionalImage, @JSONField(name = "ranking") String ranking, @JSONField(name = "title") String title) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(medalUrl, "medalUrl");
        Intrinsics.checkNotNullParameter(promotionalImage, "promotionalImage");
        Intrinsics.checkNotNullParameter(ranking, "ranking");
        Intrinsics.checkNotNullParameter(title, "title");
        this.activityId = activityId;
        this.activityTime = activityTime;
        this.medalUrl = medalUrl;
        this.promotionalImage = promotionalImage;
        this.ranking = ranking;
        this.title = title;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityId = str;
    }

    public final String getActivityTime() {
        return this.activityTime;
    }

    public final void setActivityTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityTime = str;
    }

    public final String getMedalUrl() {
        return this.medalUrl;
    }

    public final void setMedalUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.medalUrl = str;
    }

    public final String getPromotionalImage() {
        return this.promotionalImage;
    }

    public final void setPromotionalImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.promotionalImage = str;
    }

    public final String getRanking() {
        return this.ranking;
    }

    public final void setRanking(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ranking = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
