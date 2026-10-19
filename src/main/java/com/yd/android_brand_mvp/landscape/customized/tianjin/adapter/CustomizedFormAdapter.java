package com.yd.android_brand_mvp.landscape.customized.tianjin.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemCustomizedRecyclerFormsBinding;
import com.yd.android_brand_mvp.model.custom.FormContentItemBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomizedFormAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/adapter/CustomizedFormAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemCustomizedRecyclerFormsBinding;", "Lcom/yd/android_brand_mvp/model/custom/FormContentItemBean;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomizedFormAdapter extends BaseBindingAdapter<ItemCustomizedRecyclerFormsBinding, FormContentItemBean> {
    public CustomizedFormAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FormContentItemBean formContentItemBean) {
        convertPlus2((VBViewHolder<ItemCustomizedRecyclerFormsBinding>) vBViewHolder, formContentItemBean);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemCustomizedRecyclerFormsBinding> holder, FormContentItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemCustomizedRecyclerFormsBinding itemCustomizedRecyclerFormsBinding = (ItemCustomizedRecyclerFormsBinding) holder.getBinding();
        if (itemCustomizedRecyclerFormsBinding != null) {
            itemCustomizedRecyclerFormsBinding.tvItemCustomRecyclerFormsTitle.setText(item.getName());
            itemCustomizedRecyclerFormsBinding.tvItemCustomRecyclerFormsContent.setText(item.getValue());
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemCustomizedRecyclerFormsBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemCustomizedRecyclerFormsBinding itemCustomizedRecyclerFormsBindingInflate = ItemCustomizedRecyclerFormsBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemCustomizedRecyclerFormsBindingInflate, "inflate(inflater, parent, false)");
        return itemCustomizedRecyclerFormsBindingInflate;
    }
}
