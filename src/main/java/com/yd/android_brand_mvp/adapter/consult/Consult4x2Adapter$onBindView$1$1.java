package com.yd.android_brand_mvp.adapter.consult;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemConsultHeadBinding;
import com.yd.android_brand_mvp.model.consult.ConsultTeacherBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Consult4x2Adapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/adapter/consult/Consult4x2Adapter$onBindView$1$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/consult/ConsultTeacherBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Consult4x2Adapter$onBindView$1$1 extends BaseQuickAdapter<ConsultTeacherBean, BaseViewHolder> {
    final /* synthetic */ Consult4x2Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Consult4x2Adapter$onBindView$1$1(List<ConsultTeacherBean> list, Consult4x2Adapter consult4x2Adapter) {
        super(R.layout.item_consult_head, list);
        this.this$0 = consult4x2Adapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final ConsultTeacherBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemConsultHeadBinding itemConsultHeadBindingBind = ItemConsultHeadBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemConsultHeadBindingBind, "bind(holder.itemView)");
        itemConsultHeadBindingBind.tvName.setText(item.getName());
        if (!TextUtils.isEmpty(item.getAvatar())) {
            GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemConsultHeadBindingBind.ivHead);
        } else if (!TextUtils.isEmpty(item.getName())) {
            TextView textView = itemConsultHeadBindingBind.tvNameText;
            String strSubstring = item.getName().substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            textView.setText(strSubstring);
        }
        ImageView imageView = itemConsultHeadBindingBind.ivHead;
        final Consult4x2Adapter consult4x2Adapter = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.consult.-$$Lambda$Consult4x2Adapter$onBindView$1$1$k7GqgumWERSfqM4oMzagxqnPHO8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Consult4x2Adapter$onBindView$1$1.convert$lambda$0(consult4x2Adapter, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(Consult4x2Adapter this$0, ConsultTeacherBean item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Consult4x2Adapter.OnItemClickCallback onItemClickCallback = this$0.mOnItemClickCallback;
        if (onItemClickCallback != null) {
            onItemClickCallback.itemClick(item.getId());
        }
    }
}
