package com.yd.android_brand_mvp.landscape.message.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemMessageNoticeTemplateBinding;
import com.yd.android_brand_mvp.model.MessageItemBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: NoticeTemplateAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/NoticeTemplateAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoticeTemplateAdapter extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> implements LoadMoreModule {
    public NoticeTemplateAdapter() {
        super(R.layout.item_message_notice_template, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, MessageItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMessageNoticeTemplateBinding itemMessageNoticeTemplateBindingBind = ItemMessageNoticeTemplateBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemMessageNoticeTemplateBindingBind, "bind(holder.itemView)");
        if (item.isTop()) {
            itemMessageNoticeTemplateBindingBind.tvTop.setVisibility(0);
            TextView textView = itemMessageNoticeTemplateBindingBind.tvTitle;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("  %s", Arrays.copyOf(new Object[]{item.getTitle()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            textView.setText(str);
        } else {
            itemMessageNoticeTemplateBindingBind.tvTop.setVisibility(8);
            itemMessageNoticeTemplateBindingBind.tvTitle.setText(item.getTitle());
        }
        TextView textView2 = itemMessageNoticeTemplateBindingBind.tvDate;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("发布时间：%s", Arrays.copyOf(new Object[]{item.getTimerDate()}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        textView2.setText(str2);
    }
}
