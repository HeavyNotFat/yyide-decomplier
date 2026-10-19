package com.yd.android_brand_mvp.activity.fragment.honor;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemHonorCommentBinding;
import com.yd.android_brand_mvp.dialog.DialogBean;
import com.yd.android_brand_mvp.dialog.DialogListMessage;
import com.yd.android_brand_mvp.model.honor.HonorScoreListBean;
import com.yd.android_brand_mvp.utils.StringUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorCommentFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/activity/fragment/honor/HonorCommentFragment$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorCommentFragment$mAdapter$1 extends BaseQuickAdapter<HonorScoreListBean, BaseViewHolder> {
    final /* synthetic */ HonorCommentFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HonorCommentFragment$mAdapter$1(HonorCommentFragment honorCommentFragment) {
        super(R.layout.item_honor_comment, null, 2, null);
        this.this$0 = honorCommentFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final HonorScoreListBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final ItemHonorCommentBinding itemHonorCommentBindingBind = ItemHonorCommentBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemHonorCommentBindingBind, "bind(holder.itemView)");
        itemHonorCommentBindingBind.tvContent.setText((holder.getAdapterPosition() + 1) + '.' + item.getProjectName());
        itemHonorCommentBindingBind.tvScore.setText('(' + StringUtils.subZeroAndDot(String.valueOf(item.getMinScore())) + " - " + StringUtils.subZeroAndDot(String.valueOf(item.getMaxScore())) + "分)");
        if (item.getWriteScore() != null) {
            TextView textView = itemHonorCommentBindingBind.tvSelectScore;
            StringBuilder sb = new StringBuilder();
            sb.append(item.getWriteScore());
            sb.append((char) 20998);
            textView.setText(sb.toString());
        } else {
            itemHonorCommentBindingBind.tvSelectScore.setText("");
        }
        TextView textView2 = itemHonorCommentBindingBind.tvSelectScore;
        final HonorCommentFragment honorCommentFragment = this.this$0;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$mAdapter$1$TtZbBCnGiu4-14qsba-jvKb14I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorCommentFragment$mAdapter$1.convert$lambda$0(honorCommentFragment, item, itemHonorCommentBindingBind, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(final HonorCommentFragment this$0, final HonorScoreListBean item, final ItemHonorCommentBinding itemBinding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(itemBinding, "$itemBinding");
        DialogListMessage dialogListMessage = new DialogListMessage();
        dialogListMessage.setOnDialogCallback(new DialogListMessage.DialogCallback() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment$mAdapter$1$convert$1$1
            @Override // com.yd.android_brand_mvp.dialog.DialogListMessage.DialogCallback
            public void onDialogCancel() {
            }

            @Override // com.yd.android_brand_mvp.dialog.DialogListMessage.DialogCallback
            public void onDialogConfirm(DialogBean selectItem) {
                this$0.select = selectItem;
                DialogBean dialogBean = this$0.select;
                if ((dialogBean != null ? dialogBean.getMesasge() : null) != null) {
                    TextView textView = itemBinding.tvSelectScore;
                    StringBuilder sb = new StringBuilder();
                    DialogBean dialogBean2 = this$0.select;
                    sb.append(dialogBean2 != null ? dialogBean2.getMesasge() : null);
                    sb.append((char) 20998);
                    textView.setText(sb.toString());
                    HonorScoreListBean honorScoreListBean = item;
                    DialogBean dialogBean3 = this$0.select;
                    Double mesasge = dialogBean3 != null ? dialogBean3.getMesasge() : null;
                    Intrinsics.checkNotNull(mesasge);
                    honorScoreListBean.setWriteScore(mesasge);
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this$0.getValue(item.getMinScore(), item.getMaxScore()));
        DialogBean dialogBean = this$0.select;
        if (Intrinsics.areEqual(dialogBean != null ? dialogBean.getId() : null, item.getRuleId())) {
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            dialogListMessage.showDialog(contextRequireContext, arrayList, this$0.select);
        } else {
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            dialogListMessage.showDialog(contextRequireContext2, arrayList, null);
        }
    }
}
