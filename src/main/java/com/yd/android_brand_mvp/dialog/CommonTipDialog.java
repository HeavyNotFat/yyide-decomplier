package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yd.android_brand_mvp.databinding.DialogCommonTipBinding;
import com.yd.android_brand_mvp.listener.TipListener;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonTipDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/CommonTipDialog;", "Landroidx/fragment/app/DialogFragment;", "showContent", "", "positiveText", "isShowNegative", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogCommonTipBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/listener/TipListener;", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "cb", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonTipDialog extends DialogFragment {
    private DialogCommonTipBinding binding;
    private final boolean isShowNegative;
    private TipListener listener;
    private final String positiveText;
    private final String showContent;

    public CommonTipDialog(String showContent, String positiveText, boolean z) {
        Intrinsics.checkNotNullParameter(showContent, "showContent");
        Intrinsics.checkNotNullParameter(positiveText, "positiveText");
        this.showContent = showContent;
        this.positiveText = positiveText;
        this.isShowNegative = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogCommonTipBinding dialogCommonTipBindingInflate = DialogCommonTipBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogCommonTipBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogCommonTipBindingInflate;
        if (dialogCommonTipBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogCommonTipBindingInflate = null;
        }
        ConstraintLayout root = dialogCommonTipBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        DialogCommonTipBinding dialogCommonTipBinding = null;
        if (!this.isShowNegative) {
            DialogCommonTipBinding dialogCommonTipBinding2 = this.binding;
            if (dialogCommonTipBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogCommonTipBinding2 = null;
            }
            TextView textView = dialogCommonTipBinding2.btnDialogCommonTipNegative;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.btnDialogCommonTipNegative");
            SimpleUtilsKt.remove(textView);
        }
        DialogCommonTipBinding dialogCommonTipBinding3 = this.binding;
        if (dialogCommonTipBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogCommonTipBinding3 = null;
        }
        dialogCommonTipBinding3.tvDialogCommonTip.setText(this.showContent);
        DialogCommonTipBinding dialogCommonTipBinding4 = this.binding;
        if (dialogCommonTipBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogCommonTipBinding4 = null;
        }
        dialogCommonTipBinding4.btnDialogCommonTipPositive.setText(this.positiveText);
        DialogCommonTipBinding dialogCommonTipBinding5 = this.binding;
        if (dialogCommonTipBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogCommonTipBinding5 = null;
        }
        dialogCommonTipBinding5.btnDialogCommonTipPositive.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$CommonTipDialog$lPXafZX5uGzzjt6i998mQTb4Y9o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonTipDialog.initView$lambda$0(this.f$0, view);
            }
        });
        DialogCommonTipBinding dialogCommonTipBinding6 = this.binding;
        if (dialogCommonTipBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogCommonTipBinding = dialogCommonTipBinding6;
        }
        dialogCommonTipBinding.btnDialogCommonTipNegative.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$CommonTipDialog$7NeWOkKa_iELFp830AHa6O3Mh7U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonTipDialog.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CommonTipDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TipListener tipListener = this$0.listener;
        if (tipListener != null) {
            tipListener.setOnPositive("");
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CommonTipDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TipListener tipListener = this$0.listener;
        if (tipListener != null) {
            tipListener.setOnNegative("");
        }
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "it.windowManager.defaultDisplay");
            if (ScreenUtils.isPortrait()) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.54d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.15d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.3d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.26d);
            }
            window.setAttributes(attributes);
        }
    }

    public final void setCallBack(TipListener cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.listener = cb;
    }
}
