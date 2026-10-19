package com.yd.android_brand_mvp.base;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.observer.observer2.TimeManager;
import com.yd.android_brand_mvp.observer.observer2.TimeNoiceListener;

/* JADX INFO: loaded from: classes4.dex */
public class BaseDialogTime extends BaseDialog implements TimeNoiceListener {
    public long NowTime;

    @Override // com.yd.android_brand_mvp.observer.observer2.TimeNoiceListener
    public void updataTime(long j) {
    }

    public BaseDialogTime(Context context, int i) {
        super(context, i);
    }

    public BaseDialogTime(Context context, String str) {
        this(context, R.style.shareDialog);
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.NowTime = System.currentTimeMillis() / 1000;
        TimeManager.getInstance().add(this);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yd.android_brand_mvp.base.BaseDialogTime.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                TimeManager.getInstance().remove(BaseDialogTime.this);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.yd.android_brand_mvp.base.BaseDialogTime.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TimeManager.getInstance().remove(BaseDialogTime.this);
            }
        });
    }
}
