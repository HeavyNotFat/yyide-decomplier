package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.DialogLayoutListBinding;
import com.yd.android_brand_mvp.databinding.ItemConsultHeadDialogBinding;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsultListHeadDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0011\u0018\u00002\u00020\u0001:\u0001#B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/ConsultListHeadDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "(Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;Ljava/util/List;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogLayoutListBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/DialogLayoutListBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/DialogLayoutListBinding;)V", "cb", "Lcom/yd/android_brand_mvp/dialog/ConsultListHeadDialog$CallBack;", "mAdapter", "com/yd/android_brand_mvp/dialog/ConsultListHeadDialog$mAdapter$1", "Lcom/yd/android_brand_mvp/dialog/ConsultListHeadDialog$mAdapter$1;", "initListener", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "callBack", "CallBack", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultListHeadDialog extends DialogFragment {
    public DialogLayoutListBinding binding;
    private CallBack cb;
    private ReservationRecordBean data;
    private List<ReservationSignListItemBean> list;
    private final ConsultListHeadDialog$mAdapter$1 mAdapter;

    /* JADX INFO: compiled from: ConsultListHeadDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/ConsultListHeadDialog$CallBack;", "", "clickSubmit", "", "data", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "item", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void clickSubmit(ReservationRecordBean data, ReservationSignListItemBean item);
    }

    private final void initListener() {
    }

    public final DialogLayoutListBinding getBinding() {
        DialogLayoutListBinding dialogLayoutListBinding = this.binding;
        if (dialogLayoutListBinding != null) {
            return dialogLayoutListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogLayoutListBinding dialogLayoutListBinding) {
        Intrinsics.checkNotNullParameter(dialogLayoutListBinding, "<set-?>");
        this.binding = dialogLayoutListBinding;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.dialog.ConsultListHeadDialog$mAdapter$1] */
    public ConsultListHeadDialog(ReservationRecordBean data, List<ReservationSignListItemBean> list) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(list, "list");
        this.mAdapter = new BaseQuickAdapter<ReservationSignListItemBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.dialog.ConsultListHeadDialog$mAdapter$1
            {
                super(R.layout.item_consult_head_dialog, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, ReservationSignListItemBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemConsultHeadDialogBinding itemConsultHeadDialogBindingBind = ItemConsultHeadDialogBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemConsultHeadDialogBindingBind, "bind(holder.itemView)");
                itemConsultHeadDialogBindingBind.tvName.setText(item.getUserName());
                if (!TextUtils.isEmpty(item.getAvatar())) {
                    TextView textView = itemConsultHeadDialogBindingBind.tvHeadName;
                    Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvHeadName");
                    SimpleUtilsKt.remove(textView);
                    GlideUtil.loadCircleImage(this.this$0.requireContext(), item.getAvatar(), itemConsultHeadDialogBindingBind.ivHead);
                } else if (!TextUtils.isEmpty(item.getUserName()) && item.getUserName().length() > 1) {
                    TextView textView2 = itemConsultHeadDialogBindingBind.tvHeadName;
                    Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.tvHeadName");
                    SimpleUtilsKt.show(textView2);
                    TextView textView3 = itemConsultHeadDialogBindingBind.tvHeadName;
                    String strSubstring = item.getUserName().substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView3.setText(strSubstring);
                }
                if (holder.getAdapterPosition() == 0) {
                    itemConsultHeadDialogBindingBind.getRoot().setBackgroundColor(this.this$0.getResources().getColor(R.color.color_F5F7FA));
                } else {
                    itemConsultHeadDialogBindingBind.getRoot().setBackgroundColor(this.this$0.getResources().getColor(R.color.white));
                }
            }
        };
        this.list = list;
        this.data = data;
    }

    public final void setCallBack(CallBack callBack) {
        this.cb = callBack;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogLayoutListBinding dialogLayoutListBindingInflate = DialogLayoutListBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogLayoutListBindingInflate, "inflate(inflater, container, false)");
        setBinding(dialogLayoutListBindingInflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setList(this.list);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ConsultListHeadDialog$btH7B1agDah-p67kavS8FhWoc94
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ConsultListHeadDialog.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ConsultListHeadDialog this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ReservationRecordBean reservationRecordBean = this$0.data;
        if (reservationRecordBean != null) {
            CallBack callBack = this$0.cb;
            if (callBack != null) {
                callBack.clickSubmit(reservationRecordBean, this$0.mAdapter.getItem(i));
            }
            this$0.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "it.windowManager.defaultDisplay");
            if (ScreenUtils.isLandscape()) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.4d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.5d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.62d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.3d);
            }
            window.setAttributes(attributes);
        }
    }
}
