package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class LockDialog extends Dialog {
    Context context;

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    public LockDialog(Context context, int i) {
        super(context, i);
    }

    public LockDialog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_lock_dialog);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        window.setAttributes(attributes);
        getWindow().setType(2005);
    }
}
