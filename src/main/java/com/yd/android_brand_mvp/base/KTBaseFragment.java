package com.yd.android_brand_mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KTBaseFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\bH\u0014J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\n\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR+\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "bindingBlock", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getBindingBlock", "()Lkotlin/jvm/functions/Function3;", "needControlTopTitleShow", "onCreateView", "Landroid/view/View;", "inflater", TtmlNode.RUBY_CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class KTBaseFragment<VB extends ViewBinding> extends BaseFragment {
    private VB _binding;
    private final Function3<LayoutInflater, ViewGroup, Boolean, VB> bindingBlock;

    protected boolean needControlTopTitleShow() {
        return false;
    }

    public final Function3<LayoutInflater, ViewGroup, Boolean, VB> getBindingBlock() {
        return this.bindingBlock;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KTBaseFragment(Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VB> bindingBlock) {
        Intrinsics.checkNotNullParameter(bindingBlock, "bindingBlock");
        this.bindingBlock = bindingBlock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VB getBinding() {
        VB vb = this._binding;
        if (vb != null) {
            return vb;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_binding");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VB vbInvoke = this.bindingBlock.invoke(inflater, container, false);
        this._binding = vbInvoke;
        if (vbInvoke == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_binding");
            vbInvoke = null;
        }
        return vbInvoke.getRoot();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (needControlTopTitleShow()) {
            Bundle arguments = getArguments();
            if (arguments != null ? arguments.getBoolean("showTopTile") : true) {
                return;
            }
            VB vb = this._binding;
            if (vb == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_binding");
                vb = null;
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) vb.getRoot().findViewById(R.id.top_fragment_title);
            if (constraintLayout == null) {
                return;
            }
            constraintLayout.setVisibility(8);
        }
    }
}
