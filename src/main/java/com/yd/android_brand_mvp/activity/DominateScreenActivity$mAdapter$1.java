package com.yd.android_brand_mvp.activity;

import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemDominateMessageBinding;
import com.yd.android_brand_mvp.model.MessageDetail;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DominateScreenActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/activity/DominateScreenActivity$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DominateScreenActivity$mAdapter$1 extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$0(View view) {
        return true;
    }

    DominateScreenActivity$mAdapter$1() {
        super(R.layout.item_dominate_message, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, MessageItemBean item) {
        Integer numValueOf;
        MessageDetail messageDetail;
        String coverImg;
        MessageDetail messageDetail2;
        String coverImg2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemDominateMessageBinding itemDominateMessageBindingBind = ItemDominateMessageBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemDominateMessageBindingBind, "bind(holder.itemView)");
        if (item.getContentType() == 1) {
            itemDominateMessageBindingBind.webView.setVisibility(8);
            if (item.getDetails() != null) {
                List<MessageDetail> details = item.getDetails();
                Integer numValueOf2 = details != null ? Integer.valueOf(details.size()) : null;
                Intrinsics.checkNotNull(numValueOf2);
                if (numValueOf2.intValue() > 0) {
                    String str = "";
                    if (ScreenUtils.isLandscape()) {
                        List<MessageDetail> details2 = item.getDetails();
                        numValueOf = details2 != null ? Integer.valueOf(details2.size()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        if (numValueOf.intValue() > 1) {
                            Context context = getContext();
                            List<MessageDetail> details3 = item.getDetails();
                            if (details3 != null && (messageDetail2 = details3.get(1)) != null && (coverImg2 = messageDetail2.getCoverImg()) != null) {
                                str = coverImg2;
                            }
                            GlideUtil.loadNomalImage(context, str, itemDominateMessageBindingBind.ivContent);
                            return;
                        }
                        return;
                    }
                    List<MessageDetail> details4 = item.getDetails();
                    numValueOf = details4 != null ? Integer.valueOf(details4.size()) : null;
                    Intrinsics.checkNotNull(numValueOf);
                    if (numValueOf.intValue() > 0) {
                        Context context2 = getContext();
                        List<MessageDetail> details5 = item.getDetails();
                        if (details5 != null && (messageDetail = details5.get(0)) != null && (coverImg = messageDetail.getCoverImg()) != null) {
                            str = coverImg;
                        }
                        GlideUtil.loadNomalImage(context2, str, itemDominateMessageBindingBind.ivContent);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (item.getMessType() == 6) {
            itemDominateMessageBindingBind.webView.setVisibility(8);
            GlideUtil.loadNomalImage(getContext(), item.getContentImg(), itemDominateMessageBindingBind.ivContent);
        } else {
            itemDominateMessageBindingBind.webView.setVisibility(0);
            itemDominateMessageBindingBind.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$DominateScreenActivity$mAdapter$1$W7OdnpohtH4RHNlMadYCl33LOek
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return DominateScreenActivity$mAdapter$1.convert$lambda$0(view);
                }
            });
            itemDominateMessageBindingBind.webView.loadDataWithBaseURL(null, StringUtils.formatHtmlData(item.getContent()), "text/html", "utf-8", null);
        }
    }
}
