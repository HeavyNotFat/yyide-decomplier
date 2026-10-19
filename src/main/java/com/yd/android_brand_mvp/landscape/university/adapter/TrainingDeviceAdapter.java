package com.yd.android_brand_mvp.landscape.university.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemTrainingBinding;
import com.yd.android_brand_mvp.model.TrainingDeviceBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrainingDeviceAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/adapter/TrainingDeviceAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/TrainingDeviceBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrainingDeviceAdapter extends BaseQuickAdapter<TrainingDeviceBean, BaseViewHolder> {
    public TrainingDeviceAdapter() {
        super(R.layout.item_training, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, TrainingDeviceBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTrainingBinding itemTrainingBindingBind = ItemTrainingBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemTrainingBindingBind, "bind(holder.itemView)");
        itemTrainingBindingBind.tvTitle.setText(item.getName());
        TextView textView = itemTrainingBindingBind.tvNumber;
        StringBuilder sb = new StringBuilder();
        sb.append(item.getNumber());
        sb.append((char) 21488);
        textView.setText(sb.toString());
    }
}
