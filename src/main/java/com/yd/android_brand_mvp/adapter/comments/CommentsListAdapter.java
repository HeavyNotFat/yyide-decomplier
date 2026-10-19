package com.yd.android_brand_mvp.adapter.comments;

import android.text.Html;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemCommentsBinding;
import com.yd.android_brand_mvp.model.comments.CommentsDetailBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentsListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/comments/CommentsListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/comments/CommentsDetailBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommentsListAdapter extends BaseQuickAdapter<CommentsDetailBean, BaseViewHolder> implements LoadMoreModule {
    public CommentsListAdapter() {
        super(R.layout.item_comments, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, CommentsDetailBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemCommentsBinding itemCommentsBindingBind = ItemCommentsBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemCommentsBindingBind, "bind(holder.itemView)");
        itemCommentsBindingBind.tvName.setText(item.getUserName());
        itemCommentsBindingBind.tvContent.setText(item.getContent());
        itemCommentsBindingBind.tvTime.setText(item.getCreateTime());
        GlideUtil.loadCircleImage(getContext(), item.getUserAvatar(), itemCommentsBindingBind.ivImg);
        if (item.getStatus() == 0) {
            itemCommentsBindingBind.tvReply.setVisibility(0);
            itemCommentsBindingBind.tvReply.setText(Html.fromHtml("<font color='#999999'> 回复：</font>" + item.getReplyContent()));
            return;
        }
        itemCommentsBindingBind.tvReply.setVisibility(8);
    }
}
