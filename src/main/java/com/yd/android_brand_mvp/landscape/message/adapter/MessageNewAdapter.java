package com.yd.android_brand_mvp.landscape.message.adapter;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemMessageNewsBinding;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageNewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageNewAdapter extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> {
    public MessageNewAdapter() {
        super(R.layout.item_message_news, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, MessageItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMessageNewsBinding itemMessageNewsBindingBind = ItemMessageNewsBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemMessageNewsBindingBind, "bind(holder.itemView)");
        itemMessageNewsBindingBind.tvTitle.setText(item.getTitle());
        if (ScreenUtils.isLandscape()) {
            GlideUtil.loadImageRadius(getContext(), item.getCoverImg(), itemMessageNewsBindingBind.ivImg, R.drawable.icon_bp_message_nes_bg, SizeUtils.dp2px(20.0f));
        } else {
            GlideUtil.loadImageRadius(getContext(), item.getCoverImg(), itemMessageNewsBindingBind.ivImg, R.drawable.icon_bp_message_news_sb_bg, SizeUtils.dp2px(20.0f));
        }
    }
}
