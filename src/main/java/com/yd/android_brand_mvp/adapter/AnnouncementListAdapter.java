package com.yd.android_brand_mvp.adapter;

import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemMessageListNewsBinding;
import com.yd.android_brand_mvp.databinding.LayoutAnnouncementItemBinding;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: compiled from: AnnouncementListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "data", "", "(Ljava/util/List;)V", FirebaseAnalytics.Param.INDEX, "", "convert", "", "holder", "item", "setIndex", "position", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnnouncementListAdapter extends BaseMultiItemQuickAdapter<MessageItemBean, BaseViewHolder> implements LoadMoreModule {
    private int index;

    public AnnouncementListAdapter(List<MessageItemBean> list) {
        super(list);
        addItemType(1, R.layout.layout_announcement_item);
        addItemType(2, R.layout.item_message_list_news);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, MessageItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (holder.getItemViewType() == 1) {
            LayoutAnnouncementItemBinding layoutAnnouncementItemBindingBind = LayoutAnnouncementItemBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(layoutAnnouncementItemBindingBind, "bind(holder.itemView)");
            layoutAnnouncementItemBindingBind.tvTitle.setText(item.getTitle());
            layoutAnnouncementItemBindingBind.tvTime.setText(DateUtils.formatTime(item.getTimerDate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
            if (holder.getAdapterPosition() == this.index) {
                layoutAnnouncementItemBindingBind.llItem2.setBackgroundResource(R.color.purple4);
                layoutAnnouncementItemBindingBind.tvTitle.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                layoutAnnouncementItemBindingBind.tvTime.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                layoutAnnouncementItemBindingBind.dian.setBackgroundResource(R.drawable.bg_dots_shape2);
                return;
            }
            layoutAnnouncementItemBindingBind.llItem2.setBackgroundResource(R.color.white);
            layoutAnnouncementItemBindingBind.tvTitle.setTextColor(getContext().getResources().getColor(R.color.black9));
            layoutAnnouncementItemBindingBind.tvTime.setTextColor(getContext().getResources().getColor(R.color.black9));
            layoutAnnouncementItemBindingBind.dian.setBackgroundResource(R.drawable.bg_dots_shape);
            return;
        }
        ItemMessageListNewsBinding itemMessageListNewsBindingBind = ItemMessageListNewsBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemMessageListNewsBindingBind, "bind(holder.itemView)");
        itemMessageListNewsBindingBind.tvTitle.setText(item.getTitle());
        itemMessageListNewsBindingBind.tvTime.setText(DateUtils.formatTime(item.getTimerDate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
        int messType = item.getMessType();
        if (messType == 2) {
            GlideUtil.loadImageRadius(getContext(), item.getCoverImg(), itemMessageListNewsBindingBind.ivImg, R.drawable.icon_bp_message_nes_bg, SizeUtils.dp2px(10.0f));
        } else if (messType == 5) {
            GlideUtil.loadImageRadius(getContext(), item.getCoverImg(), itemMessageListNewsBindingBind.ivImg, R.drawable.icon_message_campus_defualt, SizeUtils.dp2px(10.0f));
        } else {
            GlideUtil.loadImageRadius(getContext(), item.getCoverImg(), itemMessageListNewsBindingBind.ivImg, R.drawable.icon_img_defulat, SizeUtils.dp2px(10.0f));
        }
        if (holder.getAdapterPosition() == this.index) {
            itemMessageListNewsBindingBind.clItem.setBackgroundResource(R.color.purple4);
            itemMessageListNewsBindingBind.tvTitle.setTextColor(getContext().getResources().getColor(R.color.purple2));
            itemMessageListNewsBindingBind.tvTime.setTextColor(getContext().getResources().getColor(R.color.purple2));
        } else {
            itemMessageListNewsBindingBind.clItem.setBackgroundResource(R.color.white);
            itemMessageListNewsBindingBind.tvTitle.setTextColor(getContext().getResources().getColor(R.color.black9));
            itemMessageListNewsBindingBind.tvTime.setTextColor(getContext().getResources().getColor(R.color.black9));
        }
    }

    public final void setIndex(int position) {
        this.index = position;
        notifyDataSetChanged();
    }
}
