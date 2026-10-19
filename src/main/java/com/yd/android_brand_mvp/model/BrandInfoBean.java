package com.yd.android_brand_mvp.model;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrandInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/BrandInfoBean;", "", "id", "", "brandName", CommentsHomeFragment.TYPE_CLASSESID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandName", "()Ljava/lang/String;", "getClassesId", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BrandInfoBean {
    private final String brandName;
    private final String classesId;
    private final String id;

    public static /* synthetic */ BrandInfoBean copy$default(BrandInfoBean brandInfoBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandInfoBean.id;
        }
        if ((i & 2) != 0) {
            str2 = brandInfoBean.brandName;
        }
        if ((i & 4) != 0) {
            str3 = brandInfoBean.classesId;
        }
        return brandInfoBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getClassesId() {
        return this.classesId;
    }

    public final BrandInfoBean copy(String id, String brandName, String classesId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        return new BrandInfoBean(id, brandName, classesId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrandInfoBean)) {
            return false;
        }
        BrandInfoBean brandInfoBean = (BrandInfoBean) other;
        return Intrinsics.areEqual(this.id, brandInfoBean.id) && Intrinsics.areEqual(this.brandName, brandInfoBean.brandName) && Intrinsics.areEqual(this.classesId, brandInfoBean.classesId);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.brandName.hashCode()) * 31) + this.classesId.hashCode();
    }

    public String toString() {
        return "BrandInfoBean(id=" + this.id + ", brandName=" + this.brandName + ", classesId=" + this.classesId + ')';
    }

    public BrandInfoBean(String id, String brandName, String classesId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        this.id = id;
        this.brandName = brandName;
        this.classesId = classesId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final String getClassesId() {
        return this.classesId;
    }
}
