package com.yd.android_brand_mvp.landscape.task;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemHonorKidsBinding;
import com.yd.android_brand_mvp.model.honor.HonorKidsLIstBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorSingleFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"com/yd/android_brand_mvp/landscape/task/HonorSingleFragment$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorKidsLIstBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorSingleFragment$mAdapter$1 extends BaseQuickAdapter<HonorKidsLIstBean, BaseViewHolder> implements LoadMoreModule {
    HonorSingleFragment$mAdapter$1() {
        super(R.layout.item_honor_kids, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, HonorKidsLIstBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemHonorKidsBinding itemHonorKidsBindingBind = ItemHonorKidsBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemHonorKidsBindingBind, "bind(holder.itemView)");
        if (holder.getAdapterPosition() == 0) {
            itemHonorKidsBindingBind.viewTop.setVisibility(4);
        }
        GlideUtil.loadImage(getContext(), item.getMedalUrl(), itemHonorKidsBindingBind.ivCoverLab);
        itemHonorKidsBindingBind.tvTimeClass.setText(item.getObtainTime() + "  " + item.getClassName());
        itemHonorKidsBindingBind.tvRanking.setText(item.getHonorTitle());
        itemHonorKidsBindingBind.tvTime.setText(item.getActivityTitle());
    }
}
