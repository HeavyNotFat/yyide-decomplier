package com.yd.android_brand_mvp.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class UpdataProgressDialog extends ProgressDialog {
    public UpdataProgressDialog(Context context) {
        super(context);
    }

    public UpdataProgressDialog(Context context, int i) {
        super(context, i);
    }

    public UpdataProgressDialog(Context context, String str) {
        this(context, R.style.shareDialog);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public UpdataProgressDialog showProgress(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        UpdataProgressDialog updataProgressDialog = new UpdataProgressDialog(context, R.style.Custom_ProgressDialog);
        updataProgressDialog.setTitle("");
        updataProgressDialog.setContentView(R.layout.updata_progress);
        if (charSequence == null || charSequence.length() == 0) {
            updataProgressDialog.findViewById(R.id.message).setVisibility(8);
        } else {
            ((TextView) updataProgressDialog.findViewById(R.id.message)).setText("软件更新中..." + ((Object) charSequence));
        }
        updataProgressDialog.setCancelable(z);
        updataProgressDialog.setOnCancelListener(onCancelListener);
        updataProgressDialog.getWindow().getAttributes().gravity = 17;
        WindowManager.LayoutParams attributes = updataProgressDialog.getWindow().getAttributes();
        attributes.dimAmount = 0.2f;
        updataProgressDialog.getWindow().setAttributes(attributes);
        updataProgressDialog.show();
        return updataProgressDialog;
    }
}
