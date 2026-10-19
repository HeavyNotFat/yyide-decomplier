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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.databinding.GankDialogInputTitleTipBinding;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UpdateTitleDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/dialog/UpdateTitleDialog;", "Landroidx/fragment/app/DialogFragment;", RemoteMessageConst.Notification.TAG, "", "tip", "(Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/GankDialogInputTitleTipBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/GankDialogInputTitleTipBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/GankDialogInputTitleTipBinding;)V", "cb", "Lcom/yd/android_brand_mvp/dialog/UpdateTitleDialog$CallBack;", "tagKey", "tipStr", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "callBack", "CallBack", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UpdateTitleDialog extends DialogFragment {
    public GankDialogInputTitleTipBinding binding;
    private CallBack cb;
    private String tagKey;
    private String tipStr;

    /* JADX INFO: compiled from: UpdateTitleDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/UpdateTitleDialog$CallBack;", "", "clickSubmit", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void clickSubmit();
    }

    public final GankDialogInputTitleTipBinding getBinding() {
        GankDialogInputTitleTipBinding gankDialogInputTitleTipBinding = this.binding;
        if (gankDialogInputTitleTipBinding != null) {
            return gankDialogInputTitleTipBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(GankDialogInputTitleTipBinding gankDialogInputTitleTipBinding) {
        Intrinsics.checkNotNullParameter(gankDialogInputTitleTipBinding, "<set-?>");
        this.binding = gankDialogInputTitleTipBinding;
    }

    public UpdateTitleDialog(String str, String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.tipStr = "";
        this.tagKey = "";
        this.tipStr = tip;
        this.tagKey = str;
    }

    public final void setCallBack(CallBack callBack) {
        this.cb = callBack;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GankDialogInputTitleTipBinding gankDialogInputTitleTipBindingInflate = GankDialogInputTitleTipBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(gankDialogInputTitleTipBindingInflate, "inflate(inflater, container, false)");
        setBinding(gankDialogInputTitleTipBindingInflate);
        ConstraintLayout root = getBinding().getRoot();
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
        getBinding().etDialogInputTitle.setText(this.tipStr);
        getBinding().etDialogInputTitle.setSelection(this.tipStr.length());
        getBinding().btnDialogMessageSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$UpdateTitleDialog$5x3f1tNS4N6Zy9I6y6QWdTEXVI8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpdateTitleDialog.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().btnDialogMessageCancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$UpdateTitleDialog$ANqOLTodvHb6UsPXttOhTUTymfY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpdateTitleDialog.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UpdateTitleDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = StringsKt.trim((CharSequence) this$0.getBinding().etDialogInputTitle.getText().toString()).toString();
        if (TextUtils.isEmpty(string)) {
            this$0.getBinding().etDialogInputTitle.setError("请输入别名");
            return;
        }
        MMKVUtils mMKVUtils = MMKVUtils.INSTANCE;
        String str = this$0.tagKey;
        if (str == null) {
            str = "tagKey";
        }
        mMKVUtils.put(str, string);
        CallBack callBack = this$0.cb;
        if (callBack != null) {
            callBack.clickSubmit();
        }
        this$0.setCallBack(null);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UpdateTitleDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
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
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.3d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.3d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.4d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.2d);
            }
            window.setAttributes(attributes);
        }
    }
}
