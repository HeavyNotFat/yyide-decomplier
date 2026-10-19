package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogRevokeReasonBinding implements ViewBinding {
    public final Button btnDialogRevokeReasonCancel;
    public final Button btnDialogRevokeReasonSubmit;
    public final EditText etDialogRevokeReason;
    public final ImageView ivDialogRevokeReasonClose;
    private final ConstraintLayout rootView;
    public final TextView tvDialogRevokeReasonRemark;
    public final TextView tvDialogRevokeReasonTip;
    public final TextView tvDialogRevokeReasonTitle;

    private DialogRevokeReasonBinding(ConstraintLayout constraintLayout, Button button, Button button2, EditText editText, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnDialogRevokeReasonCancel = button;
        this.btnDialogRevokeReasonSubmit = button2;
        this.etDialogRevokeReason = editText;
        this.ivDialogRevokeReasonClose = imageView;
        this.tvDialogRevokeReasonRemark = textView;
        this.tvDialogRevokeReasonTip = textView2;
        this.tvDialogRevokeReasonTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogRevokeReasonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogRevokeReasonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_revoke_reason, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogRevokeReasonBinding bind(View view) {
        int i = R.id.btn_dialog_revoke_reason_cancel;
        Button button = (Button) view.findViewById(R.id.btn_dialog_revoke_reason_cancel);
        if (button != null) {
            i = R.id.btn_dialog_revoke_reason_submit;
            Button button2 = (Button) view.findViewById(R.id.btn_dialog_revoke_reason_submit);
            if (button2 != null) {
                i = R.id.et_dialog_revoke_reason;
                EditText editText = (EditText) view.findViewById(R.id.et_dialog_revoke_reason);
                if (editText != null) {
                    i = R.id.iv_dialog_revoke_reason_close;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_dialog_revoke_reason_close);
                    if (imageView != null) {
                        i = R.id.tv_dialog_revoke_reason_remark;
                        TextView textView = (TextView) view.findViewById(R.id.tv_dialog_revoke_reason_remark);
                        if (textView != null) {
                            i = R.id.tv_dialog_revoke_reason_tip;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_revoke_reason_tip);
                            if (textView2 != null) {
                                i = R.id.tv_dialog_revoke_reason_title;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_revoke_reason_title);
                                if (textView3 != null) {
                                    return new DialogRevokeReasonBinding((ConstraintLayout) view, button, button2, editText, imageView, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
