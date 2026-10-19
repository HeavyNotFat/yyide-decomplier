package com.yd.android_brand_mvp.model.custom;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonParamBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/CustomJsonParamBean;", "", "groupContent", "Lcom/yd/android_brand_mvp/model/custom/CustomJsonGroupBean;", "(Lcom/yd/android_brand_mvp/model/custom/CustomJsonGroupBean;)V", "getGroupContent", "()Lcom/yd/android_brand_mvp/model/custom/CustomJsonGroupBean;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomJsonParamBean {
    private final CustomJsonGroupBean groupContent;

    public CustomJsonParamBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomJsonParamBean copy$default(CustomJsonParamBean customJsonParamBean, CustomJsonGroupBean customJsonGroupBean, int i, Object obj) {
        if ((i & 1) != 0) {
            customJsonGroupBean = customJsonParamBean.groupContent;
        }
        return customJsonParamBean.copy(customJsonGroupBean);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CustomJsonGroupBean getGroupContent() {
        return this.groupContent;
    }

    public final CustomJsonParamBean copy(CustomJsonGroupBean groupContent) {
        Intrinsics.checkNotNullParameter(groupContent, "groupContent");
        return new CustomJsonParamBean(groupContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CustomJsonParamBean) && Intrinsics.areEqual(this.groupContent, ((CustomJsonParamBean) other).groupContent);
    }

    public int hashCode() {
        return this.groupContent.hashCode();
    }

    public String toString() {
        return "CustomJsonParamBean(groupContent=" + this.groupContent + ')';
    }

    public CustomJsonParamBean(CustomJsonGroupBean groupContent) {
        Intrinsics.checkNotNullParameter(groupContent, "groupContent");
        this.groupContent = groupContent;
    }

    public /* synthetic */ CustomJsonParamBean(CustomJsonGroupBean customJsonGroupBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CustomJsonGroupBean(0, null, null, null, null, null, 63, null) : customJsonGroupBean);
    }

    public final CustomJsonGroupBean getGroupContent() {
        return this.groupContent;
    }
}
