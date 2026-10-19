package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogSignatureBinding implements ViewBinding {
    public final TextView btnDialogSignatureCancel;
    public final TextView btnDialogSignatureConfirm;
    private final ConstraintLayout rootView;
    public final SignaturePad signaturePadDialogSignature;
    public final TextView tvDialogSignatureTip;
    public final TextView tvDialogSignatureTitle;

    private DialogSignatureBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, SignaturePad signaturePad, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnDialogSignatureCancel = textView;
        this.btnDialogSignatureConfirm = textView2;
        this.signaturePadDialogSignature = signaturePad;
        this.tvDialogSignatureTip = textView3;
        this.tvDialogSignatureTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogSignatureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSignatureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_signature, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSignatureBinding bind(View view) {
        int i = R.id.btn_dialog_signature_cancel;
        TextView textView = (TextView) view.findViewById(R.id.btn_dialog_signature_cancel);
        if (textView != null) {
            i = R.id.btn_dialog_signature_confirm;
            TextView textView2 = (TextView) view.findViewById(R.id.btn_dialog_signature_confirm);
            if (textView2 != null) {
                i = R.id.signaturePad_dialog_signature;
                SignaturePad signaturePad = (SignaturePad) view.findViewById(R.id.signaturePad_dialog_signature);
                if (signaturePad != null) {
                    i = R.id.tv_dialog_signature_tip;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_signature_tip);
                    if (textView3 != null) {
                        i = R.id.tv_dialog_signature_title;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_signature_title);
                        if (textView4 != null) {
                            return new DialogSignatureBinding((ConstraintLayout) view, textView, textView2, signaturePad, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
