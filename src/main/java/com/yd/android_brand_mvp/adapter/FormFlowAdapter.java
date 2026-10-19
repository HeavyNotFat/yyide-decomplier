package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.userspace.LeaveDetailProcessAdapter;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemFormProcessBinding;
import com.yd.android_brand_mvp.model.userspace.FlowElementBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormFlowAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/FormFlowAdapter;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemFormProcessBinding;", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementBean;", "()V", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormFlowAdapter extends BaseBindingAdapter<ItemFormProcessBinding, FlowElementBean> {
    public FormFlowAdapter() {
        super(null, 1, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FlowElementBean flowElementBean) {
        convertPlus2((VBViewHolder<ItemFormProcessBinding>) vBViewHolder, flowElementBean);
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<ItemFormProcessBinding> holder, FlowElementBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final ItemFormProcessBinding itemFormProcessBinding = (ItemFormProcessBinding) holder.getBinding();
        if (itemFormProcessBinding != null) {
            int procType = item.getProcType();
            if (procType == 1) {
                itemFormProcessBinding.tvDialogLeaveDetailProcessTitle.setText("修改流程");
            } else if (procType == 2) {
                itemFormProcessBinding.tvDialogLeaveDetailProcessTitle.setText("撤销流程");
            } else {
                itemFormProcessBinding.tvDialogLeaveDetailProcessTitle.setText("原有流程");
            }
            LeaveDetailProcessAdapter leaveDetailProcessAdapter = new LeaveDetailProcessAdapter();
            itemFormProcessBinding.rvDialogLeaveDetailProcess.setActivated(true);
            itemFormProcessBinding.rvDialogLeaveDetailProcess.setLayoutManager(new LinearLayoutManager(getContext()));
            itemFormProcessBinding.rvDialogLeaveDetailProcess.setAdapter(leaveDetailProcessAdapter);
            leaveDetailProcessAdapter.setList(item.getFlowElementList());
            itemFormProcessBinding.llOriginalProcess.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$FormFlowAdapter$UWA9-Q6ArOGA76n0osIVDkGDfww
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormFlowAdapter.convertPlus$lambda$1$lambda$0(itemFormProcessBinding, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convertPlus$lambda$1$lambda$0(ItemFormProcessBinding binding, View view) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        if (!binding.rvDialogLeaveDetailProcess.isActivated()) {
            binding.rvDialogLeaveDetailProcess.setActivated(true);
            binding.ivOriginal.setImageResource(R.drawable.rl_up_btn);
            RecyclerView recyclerView = binding.rvDialogLeaveDetailProcess;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDialogLeaveDetailProcess");
            SimpleUtilsKt.show(recyclerView);
            return;
        }
        binding.rvDialogLeaveDetailProcess.setActivated(false);
        binding.ivOriginal.setImageResource(R.drawable.rl_next_btn);
        RecyclerView recyclerView2 = binding.rvDialogLeaveDetailProcess;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDialogLeaveDetailProcess");
        SimpleUtilsKt.remove(recyclerView2);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public ItemFormProcessBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemFormProcessBinding itemFormProcessBindingInflate = ItemFormProcessBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemFormProcessBindingInflate, "inflate(inflater, parent, false)");
        return itemFormProcessBindingInflate;
    }
}
