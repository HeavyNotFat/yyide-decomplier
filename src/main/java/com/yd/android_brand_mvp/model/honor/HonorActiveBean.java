package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorActiveBean;", "", "activityTime", "", a.h, "id", "promotionalImage", "status", "", "statusTranslate", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getActivityTime", "()Ljava/lang/String;", "setActivityTime", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getId", "setId", "getPromotionalImage", "setPromotionalImage", "getStatus", "()I", "setStatus", "(I)V", "getStatusTranslate", "setStatusTranslate", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorActiveBean {
    private String activityTime;
    private String description;
    private String id;
    private String promotionalImage;
    private int status;
    private String statusTranslate;
    private String title;

    public static /* synthetic */ HonorActiveBean copy$default(HonorActiveBean honorActiveBean, String str, String str2, String str3, String str4, int i, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = honorActiveBean.activityTime;
        }
        if ((i2 & 2) != 0) {
            str2 = honorActiveBean.description;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = honorActiveBean.id;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = honorActiveBean.promotionalImage;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            i = honorActiveBean.status;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str5 = honorActiveBean.statusTranslate;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            str6 = honorActiveBean.title;
        }
        return honorActiveBean.copy(str, str7, str8, str9, i3, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityTime() {
        return this.activityTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPromotionalImage() {
        return this.promotionalImage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatusTranslate() {
        return this.statusTranslate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final HonorActiveBean copy(@JSONField(name = "activityTime") String activityTime, @JSONField(name = a.h) String description, @JSONField(name = "id") String id, @JSONField(name = "promotionalImage") String promotionalImage, @JSONField(name = "status") int status, @JSONField(name = "statusTranslate") String statusTranslate, @JSONField(name = "title") String title) {
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(promotionalImage, "promotionalImage");
        Intrinsics.checkNotNullParameter(statusTranslate, "statusTranslate");
        Intrinsics.checkNotNullParameter(title, "title");
        return new HonorActiveBean(activityTime, description, id, promotionalImage, status, statusTranslate, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorActiveBean)) {
            return false;
        }
        HonorActiveBean honorActiveBean = (HonorActiveBean) other;
        return Intrinsics.areEqual(this.activityTime, honorActiveBean.activityTime) && Intrinsics.areEqual(this.description, honorActiveBean.description) && Intrinsics.areEqual(this.id, honorActiveBean.id) && Intrinsics.areEqual(this.promotionalImage, honorActiveBean.promotionalImage) && this.status == honorActiveBean.status && Intrinsics.areEqual(this.statusTranslate, honorActiveBean.statusTranslate) && Intrinsics.areEqual(this.title, honorActiveBean.title);
    }

    public int hashCode() {
        return (((((((((((this.activityTime.hashCode() * 31) + this.description.hashCode()) * 31) + this.id.hashCode()) * 31) + this.promotionalImage.hashCode()) * 31) + this.status) * 31) + this.statusTranslate.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "HonorActiveBean(activityTime=" + this.activityTime + ", description=" + this.description + ", id=" + this.id + ", promotionalImage=" + this.promotionalImage + ", status=" + this.status + ", statusTranslate=" + this.statusTranslate + ", title=" + this.title + ')';
    }

    public HonorActiveBean(@JSONField(name = "activityTime") String activityTime, @JSONField(name = a.h) String description, @JSONField(name = "id") String id, @JSONField(name = "promotionalImage") String promotionalImage, @JSONField(name = "status") int i, @JSONField(name = "statusTranslate") String statusTranslate, @JSONField(name = "title") String title) {
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(promotionalImage, "promotionalImage");
        Intrinsics.checkNotNullParameter(statusTranslate, "statusTranslate");
        Intrinsics.checkNotNullParameter(title, "title");
        this.activityTime = activityTime;
        this.description = description;
        this.id = id;
        this.promotionalImage = promotionalImage;
        this.status = i;
        this.statusTranslate = statusTranslate;
        this.title = title;
    }

    public final String getActivityTime() {
        return this.activityTime;
    }

    public final void setActivityTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityTime = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getPromotionalImage() {
        return this.promotionalImage;
    }

    public final void setPromotionalImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.promotionalImage = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final String getStatusTranslate() {
        return this.statusTranslate;
    }

    public final void setStatusTranslate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusTranslate = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
