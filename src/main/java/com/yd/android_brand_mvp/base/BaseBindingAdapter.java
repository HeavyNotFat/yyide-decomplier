package com.yd.android_brand_mvp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VBViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0004B\u0017\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\f\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\rJ#\u0010\u000e\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\rJ\u001d\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0014¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "VB", "Landroidx/viewbinding/ViewBinding;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "(Lcom/yd/android_brand_mvp/base/VBViewHolder;Ljava/lang/Object;)V", "convertPlus", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "onCreateDefViewHolder", "viewType", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseBindingAdapter<VB extends ViewBinding, T> extends BaseQuickAdapter<T, VBViewHolder<VB>> {
    public BaseBindingAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void convertPlus(VBViewHolder<VB> holder, T item);

    public abstract VB createViewBinding(LayoutInflater inflater, ViewGroup parent);

    public BaseBindingAdapter(List<T> list) {
        super(0, list);
    }

    public /* synthetic */ BaseBindingAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(VBViewHolder<VB> holder, T item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        convertPlus(holder, item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public VBViewHolder<VB> onCreateDefViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(parent.context)");
        ViewBinding viewBindingCreateViewBinding = createViewBinding(layoutInflaterFrom, parent);
        View root = viewBindingCreateViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new VBViewHolder<>(root, viewBindingCreateViewBinding);
    }
}
