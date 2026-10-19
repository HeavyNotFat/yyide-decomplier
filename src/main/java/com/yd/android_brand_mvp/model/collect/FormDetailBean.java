package com.yd.android_brand_mvp.model.collect;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/FormDetailBean;", "", "components", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "(Ljava/util/List;)V", "getComponents", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormDetailBean {
    private final List<FormBaseBean> components;

    public FormDetailBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormDetailBean copy$default(FormDetailBean formDetailBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = formDetailBean.components;
        }
        return formDetailBean.copy(list);
    }

    public final List<FormBaseBean> component1() {
        return this.components;
    }

    public final FormDetailBean copy(List<FormBaseBean> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        return new FormDetailBean(components);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FormDetailBean) && Intrinsics.areEqual(this.components, ((FormDetailBean) other).components);
    }

    public int hashCode() {
        return this.components.hashCode();
    }

    public String toString() {
        return "FormDetailBean(components=" + this.components + ')';
    }

    public FormDetailBean(List<FormBaseBean> components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
    }

    public /* synthetic */ FormDetailBean(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final List<FormBaseBean> getComponents() {
        return this.components;
    }
}
