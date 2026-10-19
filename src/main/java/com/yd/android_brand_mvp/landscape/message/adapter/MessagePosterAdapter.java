package com.yd.android_brand_mvp.landscape.message.adapter;

import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemMessageCampusBinding;
import com.yd.android_brand_mvp.model.MessageDetail;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessagePosterAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessagePosterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mItemClick", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessagePosterAdapter$ItemClick;", "convert", "", "holder", "item", "setItemClick", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessagePosterAdapter extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> {
    private ItemClick mItemClick;

    /* JADX INFO: compiled from: MessagePosterAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessagePosterAdapter$ItemClick;", "", "onItemClick", "", "mMessageItemBean", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick(MessageItemBean mMessageItemBean);
    }

    public MessagePosterAdapter() {
        super(R.layout.item_message_campus, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final MessageItemBean item) {
        MessageDetail messageDetail;
        String coverImg;
        MessageDetail messageDetail2;
        String coverImg2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMessageCampusBinding itemMessageCampusBindingBind = ItemMessageCampusBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemMessageCampusBindingBind, "bind(holder.itemView)");
        List<MessageDetail> details = item.getDetails();
        if (details != null && (details.isEmpty() ^ true)) {
            String str = "";
            if (ScreenUtils.isLandscape()) {
                List<MessageDetail> details2 = item.getDetails();
                Integer numValueOf = details2 != null ? Integer.valueOf(details2.size()) : null;
                Intrinsics.checkNotNull(numValueOf);
                if (numValueOf.intValue() > 1) {
                    Context context = getContext();
                    List<MessageDetail> details3 = item.getDetails();
                    if (details3 != null && (messageDetail2 = details3.get(1)) != null && (coverImg2 = messageDetail2.getCoverImg()) != null) {
                        str = coverImg2;
                    }
                    GlideUtil.loadImageRadius(context, str, itemMessageCampusBindingBind.ivImg, -1, SizeUtils.dp2px(10.0f));
                }
            } else {
                Context context2 = getContext();
                List<MessageDetail> details4 = item.getDetails();
                if (details4 != null && (messageDetail = details4.get(0)) != null && (coverImg = messageDetail.getCoverImg()) != null) {
                    str = coverImg;
                }
                GlideUtil.loadImageRadius(context2, str, itemMessageCampusBindingBind.ivImg, -1, SizeUtils.dp2px(10.0f));
            }
        }
        itemMessageCampusBindingBind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.adapter.-$$Lambda$MessagePosterAdapter$ZXV0BqKWA-EmLE8VODk5pcDVZCw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessagePosterAdapter.convert$lambda$0(this.f$0, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(MessagePosterAdapter this$0, MessageItemBean item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        ItemClick itemClick = this$0.mItemClick;
        if (itemClick != null) {
            itemClick.onItemClick(item);
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }
}
