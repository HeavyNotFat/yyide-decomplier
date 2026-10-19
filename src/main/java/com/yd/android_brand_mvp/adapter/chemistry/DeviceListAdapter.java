package com.yd.android_brand_mvp.adapter.chemistry;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemChemistryDeviceBinding;
import com.yd.android_brand_mvp.model.BaseBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/chemistry/DeviceListAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemChemistryDeviceBinding;", "Lcom/yd/android_brand_mvp/model/BaseBean;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceListAdapter extends BaseBindingAdapter<ItemChemistryDeviceBinding, BaseBean> {
    public DeviceListAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, BaseBean baseBean) {
        convertPlus2((VBViewHolder<ItemChemistryDeviceBinding>) vBViewHolder, baseBean);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemChemistryDeviceBinding> holder, BaseBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemChemistryDeviceBinding itemChemistryDeviceBinding = (ItemChemistryDeviceBinding) holder.getBinding();
        if (itemChemistryDeviceBinding != null) {
            itemChemistryDeviceBinding.tvItemChemistryDeviceTitle.setText(item.getName());
            itemChemistryDeviceBinding.tvItemChemistryDeviceSubTitle.setText(item.getRemark());
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemChemistryDeviceBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemChemistryDeviceBinding itemChemistryDeviceBindingInflate = ItemChemistryDeviceBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemChemistryDeviceBindingInflate, "inflate(inflater, parent, false)");
        return itemChemistryDeviceBindingInflate;
    }
}
