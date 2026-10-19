package com.yd.android_brand_mvp.landscape.evaluation;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemEvaluationMedalBinding;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationMedalFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"com/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationMedalFragment$mAdapter$1 extends BaseQuickAdapter<EvaluationMedalBean, BaseViewHolder> implements LoadMoreModule {
    final /* synthetic */ EvaluationMedalFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EvaluationMedalFragment$mAdapter$1(EvaluationMedalFragment evaluationMedalFragment) {
        super(R.layout.item_evaluation_medal, null, 2, null);
        this.this$0 = evaluationMedalFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, EvaluationMedalBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemEvaluationMedalBinding itemEvaluationMedalBindingBind = ItemEvaluationMedalBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemEvaluationMedalBindingBind, "bind(holder.itemView)");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        if (!item.getOwned()) {
            itemEvaluationMedalBindingBind.tvName.setTextColor(getContext().getResources().getColor(R.color.black11));
            itemEvaluationMedalBindingBind.ivIcon.setColorFilter(colorMatrixColorFilter);
            GlideUtil.loadImage(this.this$0.requireContext(), item.getMedalIconUrl(), itemEvaluationMedalBindingBind.ivIcon);
        } else {
            itemEvaluationMedalBindingBind.ivIcon.setColorFilter((ColorFilter) null);
            GlideUtil.loadImage(this.this$0.requireContext(), item.getMedalIconUrl(), itemEvaluationMedalBindingBind.ivIcon);
            itemEvaluationMedalBindingBind.tvName.setTextColor(getContext().getResources().getColor(R.color.black9));
        }
        itemEvaluationMedalBindingBind.tvName.setText(item.getMedalName());
    }
}
