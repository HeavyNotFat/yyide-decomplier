package com.yd.android_brand_mvp.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceActiveConfigBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/FaceActiveConfigBean;", "", "content", "", "displayName", "encoding", "id", "mediaType", AppMeasurementSdk.ConditionalUserProperty.NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getDisplayName", "getEncoding", "getId", "getMediaType", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FaceActiveConfigBean {
    private final String content;
    private final String displayName;
    private final String encoding;
    private final String id;
    private final String mediaType;
    private final String name;

    public static /* synthetic */ FaceActiveConfigBean copy$default(FaceActiveConfigBean faceActiveConfigBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faceActiveConfigBean.content;
        }
        if ((i & 2) != 0) {
            str2 = faceActiveConfigBean.displayName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = faceActiveConfigBean.encoding;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = faceActiveConfigBean.id;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = faceActiveConfigBean.mediaType;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = faceActiveConfigBean.name;
        }
        return faceActiveConfigBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final FaceActiveConfigBean copy(String content, String displayName, String encoding, String id, String mediaType, String name) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(name, "name");
        return new FaceActiveConfigBean(content, displayName, encoding, id, mediaType, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceActiveConfigBean)) {
            return false;
        }
        FaceActiveConfigBean faceActiveConfigBean = (FaceActiveConfigBean) other;
        return Intrinsics.areEqual(this.content, faceActiveConfigBean.content) && Intrinsics.areEqual(this.displayName, faceActiveConfigBean.displayName) && Intrinsics.areEqual(this.encoding, faceActiveConfigBean.encoding) && Intrinsics.areEqual(this.id, faceActiveConfigBean.id) && Intrinsics.areEqual(this.mediaType, faceActiveConfigBean.mediaType) && Intrinsics.areEqual(this.name, faceActiveConfigBean.name);
    }

    public int hashCode() {
        return (((((((((this.content.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.encoding.hashCode()) * 31) + this.id.hashCode()) * 31) + this.mediaType.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "FaceActiveConfigBean(content=" + this.content + ", displayName=" + this.displayName + ", encoding=" + this.encoding + ", id=" + this.id + ", mediaType=" + this.mediaType + ", name=" + this.name + ')';
    }

    public FaceActiveConfigBean(String content, String displayName, String encoding, String id, String mediaType, String name) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(name, "name");
        this.content = content;
        this.displayName = displayName;
        this.encoding = encoding;
        this.id = id;
        this.mediaType = mediaType;
        this.name = name;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getEncoding() {
        return this.encoding;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final String getName() {
        return this.name;
    }
}
