package com.yd.android_brand_mvp.dialog.collect;

import android.app.Dialog;
import android.graphics.Bitmap;
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
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yd.android_brand_mvp.databinding.DialogSignatureBinding;
import com.yd.android_brand_mvp.listener.BitmapListener;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignatureDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/collect/SignatureDialog;", "Landroidx/fragment/app/DialogFragment;", "portrait", "", "(Z)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogSignatureBinding;", "bitmapListener", "Lcom/yd/android_brand_mvp/listener/BitmapListener;", "isPortrait", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignatureDialog extends DialogFragment {
    private DialogSignatureBinding binding;
    private BitmapListener bitmapListener;
    private boolean isPortrait;

    public SignatureDialog(boolean z) {
        this.isPortrait = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogSignatureBinding dialogSignatureBindingInflate = DialogSignatureBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogSignatureBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogSignatureBindingInflate;
        if (dialogSignatureBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogSignatureBindingInflate = null;
        }
        ConstraintLayout root = dialogSignatureBindingInflate.getRoot();
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
        DialogSignatureBinding dialogSignatureBinding = this.binding;
        DialogSignatureBinding dialogSignatureBinding2 = null;
        if (dialogSignatureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogSignatureBinding = null;
        }
        dialogSignatureBinding.signaturePadDialogSignature.setOnSignedListener(new SignaturePad.OnSignedListener() { // from class: com.yd.android_brand_mvp.dialog.collect.SignatureDialog.initView.1
            @Override // com.github.gcacace.signaturepad.views.SignaturePad.OnSignedListener
            public void onSigned() {
            }

            @Override // com.github.gcacace.signaturepad.views.SignaturePad.OnSignedListener
            public void onStartSigning() {
                DialogSignatureBinding dialogSignatureBinding3 = SignatureDialog.this.binding;
                if (dialogSignatureBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogSignatureBinding3 = null;
                }
                TextView textView = dialogSignatureBinding3.tvDialogSignatureTip;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDialogSignatureTip");
                SimpleUtilsKt.hide(textView);
            }

            @Override // com.github.gcacace.signaturepad.views.SignaturePad.OnSignedListener
            public void onClear() {
                DialogSignatureBinding dialogSignatureBinding3 = SignatureDialog.this.binding;
                if (dialogSignatureBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogSignatureBinding3 = null;
                }
                TextView textView = dialogSignatureBinding3.tvDialogSignatureTip;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDialogSignatureTip");
                SimpleUtilsKt.show(textView);
            }
        });
        DialogSignatureBinding dialogSignatureBinding3 = this.binding;
        if (dialogSignatureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogSignatureBinding3 = null;
        }
        dialogSignatureBinding3.btnDialogSignatureCancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.collect.-$$Lambda$SignatureDialog$v5YlbGq-UdmGkceFx_kvAt9bRpk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignatureDialog.initView$lambda$0(this.f$0, view);
            }
        });
        DialogSignatureBinding dialogSignatureBinding4 = this.binding;
        if (dialogSignatureBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogSignatureBinding2 = dialogSignatureBinding4;
        }
        dialogSignatureBinding2.btnDialogSignatureConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.collect.-$$Lambda$SignatureDialog$Se73bflp5xTIB5ybJXEjnHtoK9w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignatureDialog.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SignatureDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SignatureDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogSignatureBinding dialogSignatureBinding = this$0.binding;
        if (dialogSignatureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogSignatureBinding = null;
        }
        Bitmap bitmap = dialogSignatureBinding.signaturePadDialogSignature.getSignatureBitmap();
        BitmapListener bitmapListener = this$0.bitmapListener;
        if (bitmapListener != null) {
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            bitmapListener.getBitmapData(bitmap);
        }
        this$0.dismiss();
    }

    public final void setListener(BitmapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.bitmapListener = listener;
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
            if (this.isPortrait) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.82d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.27d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.46d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.48d);
            }
            window.setAttributes(attributes);
        }
    }
}
