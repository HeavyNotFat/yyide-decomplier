package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemHonorSelectBinding;
import com.yd.android_brand_mvp.databinding.PopupItemSelectBinding;
import com.yd.android_brand_mvp.model.honor.HonorCanScoreClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import razerdp.basepopup.BasePopupWindow;

/* JADX INFO: compiled from: TableClassPopUp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005*\u0001\f\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/TableClassPopUp;", "Lrazerdp/basepopup/BasePopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/PopupItemSelectBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/PopupItemSelectBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/PopupItemSelectBinding;)V", "mAdapter", "com/yd/android_brand_mvp/dialog/TableClassPopUp$mAdapter$1", "Lcom/yd/android_brand_mvp/dialog/TableClassPopUp$mAdapter$1;", "mHonorCanScoreClass", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreClass;", "mSubmitCallback", "Lcom/yd/android_brand_mvp/dialog/TableClassPopUp$SubmitCallBack;", "onViewCreated", "", "contentView", "Landroid/view/View;", "setData", "data", "", "select", "setSubmitCallBack", "callBack", "SubmitCallBack", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TableClassPopUp extends BasePopupWindow {
    public PopupItemSelectBinding binding;
    private final TableClassPopUp$mAdapter$1 mAdapter;
    private HonorCanScoreClass mHonorCanScoreClass;
    private SubmitCallBack mSubmitCallback;

    /* JADX INFO: compiled from: TableClassPopUp.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/TableClassPopUp$SubmitCallBack;", "", "getSubmitData", "", "data", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreClass;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitCallBack {
        void getSubmitData(HonorCanScoreClass data);
    }

    public final PopupItemSelectBinding getBinding() {
        PopupItemSelectBinding popupItemSelectBinding = this.binding;
        if (popupItemSelectBinding != null) {
            return popupItemSelectBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(PopupItemSelectBinding popupItemSelectBinding) {
        Intrinsics.checkNotNullParameter(popupItemSelectBinding, "<set-?>");
        this.binding = popupItemSelectBinding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.yd.android_brand_mvp.dialog.TableClassPopUp$mAdapter$1] */
    public TableClassPopUp(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(R.layout.popup_item_select);
        setBackground(0);
        setPopupGravity(80);
        this.mAdapter = new BaseQuickAdapter<HonorCanScoreClass, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.dialog.TableClassPopUp$mAdapter$1
            {
                super(R.layout.item_honor_select, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, HonorCanScoreClass item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemHonorSelectBinding itemHonorSelectBindingBind = ItemHonorSelectBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemHonorSelectBindingBind, "bind(holder.itemView)");
                itemHonorSelectBindingBind.tvName.setText(item.getClassName());
                String classId = item.getClassId();
                HonorCanScoreClass honorCanScoreClass = this.this$0.mHonorCanScoreClass;
                if (Intrinsics.areEqual(classId, honorCanScoreClass != null ? honorCanScoreClass.getClassId() : null)) {
                    itemHonorSelectBindingBind.clContent.setBackgroundColor(getContext().getResources().getColor(R.color.color_F5F7FA));
                } else {
                    itemHonorSelectBindingBind.clContent.setBackgroundColor(getContext().getResources().getColor(R.color.white));
                }
            }
        };
    }

    @Override // razerdp.basepopup.BasePopupWindow
    public void onViewCreated(View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        PopupItemSelectBinding popupItemSelectBindingBind = PopupItemSelectBinding.bind(contentView);
        Intrinsics.checkNotNullExpressionValue(popupItemSelectBindingBind, "bind(contentView)");
        setBinding(popupItemSelectBindingBind);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
    }

    public final void setData(List<HonorCanScoreClass> data, HonorCanScoreClass select) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mHonorCanScoreClass = select;
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setList(data);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$TableClassPopUp$4kka_m62-PLvLIvx-rhw1vmPynE
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                TableClassPopUp.setData$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$0(TableClassPopUp this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        SubmitCallBack submitCallBack = this$0.mSubmitCallback;
        if (submitCallBack != null) {
            submitCallBack.getSubmitData(this$0.mAdapter.getItem(i));
        }
        this$0.dismiss();
    }

    public final void setSubmitCallBack(SubmitCallBack callBack) {
        this.mSubmitCallback = callBack;
    }
}
