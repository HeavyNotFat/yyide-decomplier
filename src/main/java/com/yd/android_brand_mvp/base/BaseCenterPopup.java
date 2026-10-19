package com.yd.android_brand_mvp.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCenterPopup extends CenterPopupView {
    Handler claseHandler;
    int endTime;
    Thread thread;

    public BaseCenterPopup(Context context) {
        super(context);
        this.endTime = 60;
        this.claseHandler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.base.BaseCenterPopup.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (BaseCenterPopup.this.endTime <= 0) {
                        BaseCenterPopup.this.claseHandler.removeCallbacks(BaseCenterPopup.this.thread);
                        BaseCenterPopup.this.dismiss();
                    } else {
                        BaseCenterPopup.this.endTime--;
                        BaseCenterPopup.this.claseHandler.postDelayed(BaseCenterPopup.this.thread, 1000L);
                    }
                }
            }
        };
        this.thread = new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.base.BaseCenterPopup.2
            @Override // java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = 1;
                if (BaseCenterPopup.this.claseHandler != null) {
                    BaseCenterPopup.this.claseHandler.sendMessage(message);
                }
            }
        });
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        super.onCreate();
        this.claseHandler.post(this.thread);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void onDismiss() {
        super.onDismiss();
        Log.i("colse", "onDismiss" + this.endTime);
        Handler handler = this.claseHandler;
        if (handler != null) {
            handler.removeCallbacks(this.thread);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.endTime = 60;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
