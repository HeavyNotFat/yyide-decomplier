package com.yd.android_brand_mvp.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class CustomProgressDialog extends ProgressDialog {
    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static CustomProgressDialog show(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(context, R.style.Custom_ProgressDialog);
        customProgressDialog.setTitle("");
        customProgressDialog.setContentView(R.layout.custom_progress_dialog);
        if (charSequence == null || charSequence.length() == 0) {
            customProgressDialog.findViewById(R.id.message).setVisibility(8);
        } else {
            ((TextView) customProgressDialog.findViewById(R.id.message)).setText(charSequence);
        }
        customProgressDialog.setCancelable(z);
        customProgressDialog.setOnCancelListener(onCancelListener);
        customProgressDialog.getWindow().getAttributes().gravity = 17;
        WindowManager.LayoutParams attributes = customProgressDialog.getWindow().getAttributes();
        attributes.dimAmount = 0.2f;
        customProgressDialog.getWindow().setAttributes(attributes);
        customProgressDialog.show();
        return customProgressDialog;
    }
}
