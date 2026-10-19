package com.yd.android_brand_mvp.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BaseDialog extends Dialog implements DialogInterface.OnDismissListener {
    public String TAG;
    Activity activity;
    Handler claseHandler;
    int endTime;
    public boolean isTimerClost;
    Thread thread;

    public BaseDialog(Context context, int i) {
        super(context, i);
        this.endTime = 60;
        this.TAG = BaseDialog.class.getSimpleName();
        this.claseHandler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.base.BaseDialog.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (!BaseDialog.this.isTimerClost && message.what == 1) {
                    if (BaseDialog.this.endTime <= 0) {
                        BaseDialog.this.claseHandler.removeCallbacks(BaseDialog.this.thread);
                        if (BaseDialog.this.activity.isFinishing()) {
                            return;
                        }
                        BaseDialog.this.dismiss();
                        return;
                    }
                    if (BaseDialog.this.activity.isFinishing()) {
                        return;
                    }
                    BaseDialog.this.endTime--;
                    BaseDialog.this.claseHandler.postDelayed(BaseDialog.this.thread, 1000L);
                }
            }
        };
        this.thread = new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.base.BaseDialog.2
            @Override // java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = 1;
                if (BaseDialog.this.claseHandler != null) {
                    BaseDialog.this.claseHandler.sendMessage(message);
                }
            }
        });
        this.activity = (Activity) context;
    }

    public BaseDialog(Context context, String str) {
        this(context, R.style.shareDialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        window.setAttributes(attributes);
        setOnDismissListener(this);
        this.claseHandler.post(this.thread);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.endTime = 60;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        Log.i("close", "setOnDismissListener -- " + this.endTime);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Handler handler = this.claseHandler;
        if (handler != null) {
            handler.removeCallbacks(this.thread);
        }
        Log.i("close", "onDismiss -- " + this.endTime);
    }
}
