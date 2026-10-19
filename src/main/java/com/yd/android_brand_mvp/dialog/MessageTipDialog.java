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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.databinding.GankDialogMessageTipBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageTipDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/dialog/MessageTipDialog;", "Landroidx/fragment/app/DialogFragment;", "tip", "", "(Ljava/lang/String;)V", "titleNight", "(Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/GankDialogMessageTipBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/GankDialogMessageTipBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/GankDialogMessageTipBinding;)V", "cb", "Lcom/yd/android_brand_mvp/dialog/MessageTipDialog$CallBack;", "tipStr", "titleNightStr", "initListener", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "callBack", "CallBack", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageTipDialog extends DialogFragment {
    public GankDialogMessageTipBinding binding;
    private CallBack cb;
    private String tipStr;
    private String titleNightStr;

    /* JADX INFO: compiled from: MessageTipDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/MessageTipDialog$CallBack;", "", "clickSubmit", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void clickSubmit();
    }

    public final GankDialogMessageTipBinding getBinding() {
        GankDialogMessageTipBinding gankDialogMessageTipBinding = this.binding;
        if (gankDialogMessageTipBinding != null) {
            return gankDialogMessageTipBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(GankDialogMessageTipBinding gankDialogMessageTipBinding) {
        Intrinsics.checkNotNullParameter(gankDialogMessageTipBinding, "<set-?>");
        this.binding = gankDialogMessageTipBinding;
    }

    public MessageTipDialog(String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.tipStr = "";
        this.titleNightStr = "确认";
        this.tipStr = tip;
    }

    public MessageTipDialog(String tip, String titleNight) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(titleNight, "titleNight");
        this.tipStr = "";
        this.titleNightStr = "确认";
        this.tipStr = tip;
        this.titleNightStr = titleNight;
    }

    public final void setCallBack(CallBack callBack) {
        this.cb = callBack;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GankDialogMessageTipBinding gankDialogMessageTipBindingInflate = GankDialogMessageTipBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(gankDialogMessageTipBindingInflate, "inflate(inflater, container, false)");
        setBinding(gankDialogMessageTipBindingInflate);
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
        getBinding().tvDialogMessageTip.setText(this.tipStr);
        getBinding().btnDialogMessageSubmit.setText(this.titleNightStr);
    }

    private final void initListener() {
        getBinding().btnDialogMessageSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$MessageTipDialog$kus1ui8xsBKIvS_I7sdKSy52UCo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageTipDialog.initListener$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(MessageTipDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CallBack callBack = this$0.cb;
        if (callBack != null) {
            callBack.clickSubmit();
        }
        this$0.setCallBack(null);
        this$0.dismiss();
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
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.35d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.35d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.62d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.2d);
            }
            window.setAttributes(attributes);
        }
    }
}
