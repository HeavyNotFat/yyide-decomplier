package com.yd.android_brand_mvp.adapter.consult;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemConsultDetailsHeadBinding;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsultDetailsHeadAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/adapter/consult/ConsultDetailsHeadAdapter$onBindView$1$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultDetailsHeadAdapter$onBindView$1$1 extends BaseQuickAdapter<ReservationSignListItemBean, BaseViewHolder> {
    final /* synthetic */ ConsultDetailsHeadAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConsultDetailsHeadAdapter$onBindView$1$1(List<ReservationSignListItemBean> list, ConsultDetailsHeadAdapter consultDetailsHeadAdapter) {
        super(R.layout.item_consult_details_head, list);
        this.this$0 = consultDetailsHeadAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final ReservationSignListItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemConsultDetailsHeadBinding itemConsultDetailsHeadBindingBind = ItemConsultDetailsHeadBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemConsultDetailsHeadBindingBind, "bind(holder.itemView)");
        itemConsultDetailsHeadBindingBind.tvName.setText(item.getUserName());
        if (!TextUtils.isEmpty(item.getAvatar())) {
            TextView textView = itemConsultDetailsHeadBindingBind.tvNameText;
            Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvNameText");
            SimpleUtilsKt.remove(textView);
            GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemConsultDetailsHeadBindingBind.ivHead);
        } else if (!TextUtils.isEmpty(item.getUserName()) && item.getUserName().length() > 1) {
            TextView textView2 = itemConsultDetailsHeadBindingBind.tvNameText;
            Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.tvNameText");
            SimpleUtilsKt.show(textView2);
            TextView textView3 = itemConsultDetailsHeadBindingBind.tvNameText;
            String strSubstring = item.getUserName().substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            textView3.setText(strSubstring);
        }
        ImageView imageView = itemConsultDetailsHeadBindingBind.ivHead;
        final ConsultDetailsHeadAdapter consultDetailsHeadAdapter = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.consult.-$$Lambda$ConsultDetailsHeadAdapter$onBindView$1$1$4denX9tUZDNd2sueqeNTzG0S_fQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConsultDetailsHeadAdapter$onBindView$1$1.convert$lambda$0(consultDetailsHeadAdapter, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(ConsultDetailsHeadAdapter this$0, ReservationSignListItemBean item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        ConsultDetailsHeadAdapter.OnItemClickCallback onItemClickCallback = this$0.mOnItemClickCallback;
        if (onItemClickCallback != null) {
            onItemClickCallback.itemClick(item.getUserId());
        }
    }
}
