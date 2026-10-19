package com.yd.android_brand_mvp.base;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VBViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/base/VBViewHolder;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "view", "Landroid/view/View;", "binding", "(Landroid/view/View;Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VBViewHolder<VB extends ViewBinding> extends BaseViewHolder {
    private final VB binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VBViewHolder(View view) {
        this(view, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VBViewHolder(View view, VB vb) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.binding = vb;
    }

    public /* synthetic */ VBViewHolder(View view, ViewBinding viewBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? null : viewBinding);
    }

    public final VB getBinding() {
        return this.binding;
    }
}
