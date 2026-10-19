package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.work.WorkRequest;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class ShutDownDialog extends BaseDialog {
    Context context;
    CountDown countDown;
    ShutDownDialog dialog;
    TextView tx;

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    public ShutDownDialog(Context context, int i) {
        super(context, i);
    }

    public ShutDownDialog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.dialog = this;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_shutdown_dialog);
        setCanceledOnTouchOutside(false);
        getWindow().setType(2003);
        this.tx = (TextView) findViewById(R.id.countdown);
        CountDown countDown = new CountDown(WorkRequest.MIN_BACKOFF_MILLIS, 1000L);
        this.countDown = countDown;
        countDown.start();
    }

    private class CountDown extends CountDownTimer {
        public CountDown(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            ShutDownDialog.this.tx.setText("" + (j / 500));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ShutDownDialog.this.dialog.cancel();
        }
    }
}
