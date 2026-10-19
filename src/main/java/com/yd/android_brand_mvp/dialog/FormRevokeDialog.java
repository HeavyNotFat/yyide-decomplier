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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yd.android_brand_mvp.databinding.DialogRevokeReasonBinding;
import com.yd.android_brand_mvp.listener.StringListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormRevokeDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/FormRevokeDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogRevokeReasonBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/listener/StringListener;", "remark", "", "tip", "title", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallBack", "cb", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormRevokeDialog extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogRevokeReasonBinding binding;
    private StringListener listener;
    private String title = "";
    private String remark = "";
    private String tip = "";

    /* JADX INFO: compiled from: FormRevokeDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/FormRevokeDialog$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/dialog/FormRevokeDialog;", "title", "", "remark", "tip", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FormRevokeDialog newInstance() {
            Bundle bundle = new Bundle();
            FormRevokeDialog formRevokeDialog = new FormRevokeDialog();
            formRevokeDialog.setArguments(bundle);
            return formRevokeDialog;
        }

        public final FormRevokeDialog newInstance(String title, String remark, String tip) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(remark, "remark");
            Intrinsics.checkNotNullParameter(tip, "tip");
            Bundle bundle = new Bundle();
            FormRevokeDialog formRevokeDialog = new FormRevokeDialog();
            bundle.putString("title", title);
            bundle.putString("remark", remark);
            bundle.putString("tip", tip);
            formRevokeDialog.setArguments(bundle);
            return formRevokeDialog;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogRevokeReasonBinding dialogRevokeReasonBindingInflate = DialogRevokeReasonBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogRevokeReasonBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogRevokeReasonBindingInflate;
        if (dialogRevokeReasonBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRevokeReasonBindingInflate = null;
        }
        ConstraintLayout root = dialogRevokeReasonBindingInflate.getRoot();
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
        Bundle arguments = getArguments();
        DialogRevokeReasonBinding dialogRevokeReasonBinding = null;
        String string = arguments != null ? arguments.getString("title") : null;
        if (string == null) {
            string = "";
        }
        this.title = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("remark") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.remark = string2;
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString("tip") : null;
        this.tip = string3 != null ? string3 : "";
        if (this.title.length() > 0) {
            DialogRevokeReasonBinding dialogRevokeReasonBinding2 = this.binding;
            if (dialogRevokeReasonBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogRevokeReasonBinding2 = null;
            }
            dialogRevokeReasonBinding2.tvDialogRevokeReasonTitle.setText(this.title);
            DialogRevokeReasonBinding dialogRevokeReasonBinding3 = this.binding;
            if (dialogRevokeReasonBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogRevokeReasonBinding3 = null;
            }
            dialogRevokeReasonBinding3.tvDialogRevokeReasonRemark.setText(this.remark);
            DialogRevokeReasonBinding dialogRevokeReasonBinding4 = this.binding;
            if (dialogRevokeReasonBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogRevokeReasonBinding4 = null;
            }
            dialogRevokeReasonBinding4.tvDialogRevokeReasonTip.setText(this.tip);
        }
        DialogRevokeReasonBinding dialogRevokeReasonBinding5 = this.binding;
        if (dialogRevokeReasonBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRevokeReasonBinding5 = null;
        }
        dialogRevokeReasonBinding5.ivDialogRevokeReasonClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$FormRevokeDialog$WtIBDPM2Jh-OtzMvlsvxLx2Cl70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormRevokeDialog.initView$lambda$0(this.f$0, view);
            }
        });
        DialogRevokeReasonBinding dialogRevokeReasonBinding6 = this.binding;
        if (dialogRevokeReasonBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRevokeReasonBinding6 = null;
        }
        dialogRevokeReasonBinding6.btnDialogRevokeReasonSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$FormRevokeDialog$nUuY2JEyPR0WiTiBnSE6TXp1IpM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormRevokeDialog.initView$lambda$1(this.f$0, view);
            }
        });
        DialogRevokeReasonBinding dialogRevokeReasonBinding7 = this.binding;
        if (dialogRevokeReasonBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogRevokeReasonBinding = dialogRevokeReasonBinding7;
        }
        dialogRevokeReasonBinding.btnDialogRevokeReasonCancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$FormRevokeDialog$GqpJx0lxKUs1oXbKxgmfCBAfoqA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormRevokeDialog.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FormRevokeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormRevokeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogRevokeReasonBinding dialogRevokeReasonBinding = this$0.binding;
        if (dialogRevokeReasonBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRevokeReasonBinding = null;
        }
        String string = StringsKt.trim((CharSequence) dialogRevokeReasonBinding.etDialogRevokeReason.getText().toString()).toString();
        StringListener stringListener = this$0.listener;
        if (stringListener != null) {
            stringListener.getStringData(string);
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(FormRevokeDialog this$0, View view) {
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
            if (ScreenUtils.isPortrait()) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.46d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.45d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.3d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.8d);
            }
            window.setAttributes(attributes);
        }
    }

    public final void setCallBack(StringListener cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.listener = cb;
    }
}
