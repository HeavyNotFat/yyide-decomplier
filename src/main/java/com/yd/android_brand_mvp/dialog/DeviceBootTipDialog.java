package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceBootTipDialog extends BaseDialog {
    Context context;

    public DeviceBootTipDialog(Context context, int i) {
        super(context, i);
    }

    public DeviceBootTipDialog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_boot_tip);
        findViewById(R.id.btnConfirm).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.DeviceBootTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceBootTipDialog.this.dismiss();
            }
        });
    }
}
