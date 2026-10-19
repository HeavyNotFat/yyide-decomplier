package com.yd.android_brand_mvp.landscape.ai;

import android.content.Intent;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.AIJuniorAssistantActivity;
import com.yd.android_brand_mvp.databinding.ItemAiHomeBinding;
import com.yd.android_brand_mvp.model.ai.AIIntellectHomeBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIFragmentFull.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/landscape/ai/AIFragmentFull$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/ai/AIIntellectHomeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIFragmentFull$mAdapter$1 extends BaseQuickAdapter<AIIntellectHomeBean, BaseViewHolder> {
    final /* synthetic */ AIFragmentFull this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AIFragmentFull$mAdapter$1(AIFragmentFull aIFragmentFull) {
        super(R.layout.item_ai_home, null, 2, null);
        this.this$0 = aIFragmentFull;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final AIIntellectHomeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemAiHomeBinding itemAiHomeBindingBind = ItemAiHomeBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemAiHomeBindingBind, "bind(holder.itemView)");
        itemAiHomeBindingBind.tvTitle.setText(item.getName());
        itemAiHomeBindingBind.tvDescription.setText(item.getDescription());
        GlideUtil.loadAIImage(getContext(), item.getIconUrl(), itemAiHomeBindingBind.ivAvatar, 10);
        CardView cardView = itemAiHomeBindingBind.cvItem;
        final AIFragmentFull aIFragmentFull = this.this$0;
        cardView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ai.-$$Lambda$AIFragmentFull$mAdapter$1$LEGbeuESE5ALRZhXlgtY87XXUic
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIFragmentFull$mAdapter$1.convert$lambda$0(aIFragmentFull, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(AIFragmentFull this$0, AIIntellectHomeBean item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) AIJuniorAssistantActivity.class);
        intent.putExtra("title", item.getName());
        intent.putExtra("data", item);
        intent.putExtra("isNotDefault", true);
        this$0.goPermissionsActivity(intent);
    }
}
