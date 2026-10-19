package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.LayoutLeaveItemBinding;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: compiled from: NewLeaveListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/NewLeaveListAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/LayoutLeaveItemBinding;", "Lcom/yd/android_brand_mvp/model/GetAskLeaveRecordBandRsp$RecordBean;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewLeaveListAdapter extends BaseBindingAdapter<LayoutLeaveItemBinding, GetAskLeaveRecordBandRsp.RecordBean> implements LoadMoreModule {
    public NewLeaveListAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, GetAskLeaveRecordBandRsp.RecordBean recordBean) {
        convertPlus2((VBViewHolder<LayoutLeaveItemBinding>) vBViewHolder, recordBean);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<LayoutLeaveItemBinding> holder, GetAskLeaveRecordBandRsp.RecordBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        LayoutLeaveItemBinding layoutLeaveItemBinding = (LayoutLeaveItemBinding) holder.getBinding();
        if (layoutLeaveItemBinding != null) {
            layoutLeaveItemBinding.reason.setText(item.title);
            int i = item.status;
            if (i == 0) {
                layoutLeaveItemBinding.type.setText("已拒绝");
                layoutLeaveItemBinding.type.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
                return;
            }
            if (i == 1) {
                layoutLeaveItemBinding.type.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_1);
                layoutLeaveItemBinding.type.setText("审批中");
            } else if (i == 2) {
                layoutLeaveItemBinding.type.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape);
                layoutLeaveItemBinding.type.setText("已通过");
            } else {
                if (i == 3) {
                    layoutLeaveItemBinding.type.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
                    layoutLeaveItemBinding.type.setBackgroundResource(R.drawable.ask_for_leave_status_gary_shape);
                    layoutLeaveItemBinding.type.setText("已撤销");
                    return;
                }
                layoutLeaveItemBinding.type.setBackgroundResource(R.drawable.ask_for_leave_status_gary_shape);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public LayoutLeaveItemBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutLeaveItemBinding layoutLeaveItemBindingInflate = LayoutLeaveItemBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutLeaveItemBindingInflate, "inflate(inflater, parent, false)");
        return layoutLeaveItemBindingInflate;
    }
}
