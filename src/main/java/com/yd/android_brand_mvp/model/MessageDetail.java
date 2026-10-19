package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/model/MessageDetail;", "Ljava/io/Serializable;", "contentImg", "", "coverImg", "height", "", "id", "width", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getContentImg", "()Ljava/lang/String;", "setContentImg", "(Ljava/lang/String;)V", "getCoverImg", "setCoverImg", "getHeight", "()I", "setHeight", "(I)V", "getId", "setId", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MessageDetail implements Serializable {
    private String contentImg;
    private String coverImg;
    private int height;
    private String id;
    private int width;

    public MessageDetail() {
        this(null, null, 0, null, 0, 31, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageDetail(@JSONField(name = "contentImg") String contentImg) {
        this(contentImg, null, 0, null, 0, 30, null);
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageDetail(@JSONField(name = "contentImg") String contentImg, @JSONField(name = "coverImg") String coverImg) {
        this(contentImg, coverImg, 0, null, 0, 28, null);
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageDetail(@JSONField(name = "contentImg") String contentImg, @JSONField(name = "coverImg") String coverImg, @JSONField(name = "height") int i) {
        this(contentImg, coverImg, i, null, 0, 24, null);
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageDetail(@JSONField(name = "contentImg") String contentImg, @JSONField(name = "coverImg") String coverImg, @JSONField(name = "height") int i, @JSONField(name = "id") String id) {
        this(contentImg, coverImg, i, id, 0, 16, null);
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public static /* synthetic */ MessageDetail copy$default(MessageDetail messageDetail, String str, String str2, int i, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = messageDetail.contentImg;
        }
        if ((i3 & 2) != 0) {
            str2 = messageDetail.coverImg;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            i = messageDetail.height;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str3 = messageDetail.id;
        }
        String str5 = str3;
        if ((i3 & 16) != 0) {
            i2 = messageDetail.width;
        }
        return messageDetail.copy(str, str4, i4, str5, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContentImg() {
        return this.contentImg;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final MessageDetail copy(@JSONField(name = "contentImg") String contentImg, @JSONField(name = "coverImg") String coverImg, @JSONField(name = "height") int height, @JSONField(name = "id") String id, @JSONField(name = "width") int width) {
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        return new MessageDetail(contentImg, coverImg, height, id, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageDetail)) {
            return false;
        }
        MessageDetail messageDetail = (MessageDetail) other;
        return Intrinsics.areEqual(this.contentImg, messageDetail.contentImg) && Intrinsics.areEqual(this.coverImg, messageDetail.coverImg) && this.height == messageDetail.height && Intrinsics.areEqual(this.id, messageDetail.id) && this.width == messageDetail.width;
    }

    public int hashCode() {
        return (((((((this.contentImg.hashCode() * 31) + this.coverImg.hashCode()) * 31) + this.height) * 31) + this.id.hashCode()) * 31) + this.width;
    }

    public String toString() {
        return "MessageDetail(contentImg=" + this.contentImg + ", coverImg=" + this.coverImg + ", height=" + this.height + ", id=" + this.id + ", width=" + this.width + ')';
    }

    public MessageDetail(@JSONField(name = "contentImg") String contentImg, @JSONField(name = "coverImg") String coverImg, @JSONField(name = "height") int i, @JSONField(name = "id") String id, @JSONField(name = "width") int i2) {
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        this.contentImg = contentImg;
        this.coverImg = coverImg;
        this.height = i;
        this.id = id;
        this.width = i2;
    }

    public /* synthetic */ MessageDetail(String str, String str2, int i, String str3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) == 0 ? str3 : "", (i3 & 16) != 0 ? 0 : i2);
    }

    public final String getContentImg() {
        return this.contentImg;
    }

    public final void setContentImg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentImg = str;
    }

    public final String getCoverImg() {
        return this.coverImg;
    }

    public final void setCoverImg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverImg = str;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }
}
