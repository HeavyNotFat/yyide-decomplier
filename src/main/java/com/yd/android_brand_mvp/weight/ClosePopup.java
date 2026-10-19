package com.yd.android_brand_mvp.weight;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBottemPopup;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class ClosePopup extends BaseBottemPopup {
    Handler claseHandler;
    CloseAct closeAct;
    int mTime;
    Thread thread;
    TextView tvTime;
    TextView tv_no_close;

    public interface CloseAct {
        void onCloseAct();

        void onNoCloseAct();
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.close_popup_layout;
    }

    public ClosePopup(Context context, CloseAct closeAct, int i) {
        super(context);
        this.mTime = 60;
        this.claseHandler = new Handler((Looper) Objects.requireNonNull(Looper.myLooper())) { // from class: com.yd.android_brand_mvp.weight.ClosePopup.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    int iIntValue = ((Integer) message.obj).intValue();
                    if (iIntValue > 0) {
                        ClosePopup.this.tvTime.setText(iIntValue + "");
                        ClosePopup.this.claseHandler.postDelayed(ClosePopup.this.thread, 1000L);
                        return;
                    }
                    ClosePopup.this.closeAct.onCloseAct();
                    return;
                }
                ClosePopup.this.claseHandler.removeCallbacks(ClosePopup.this.thread);
            }
        };
        this.thread = new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.weight.-$$Lambda$ClosePopup$-GFENJ0P2BupHCTQrD9v6pxmt3o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1$ClosePopup();
            }
        });
        this.closeAct = closeAct;
        this.mTime = i;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void onShow() {
        if (getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getApplicationWindowToken(), 2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBottemPopup, com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        this.tvTime = (TextView) findViewById(R.id.tv_time);
        this.tv_no_close = (TextView) findViewById(R.id.tv_no_close);
        this.tvTime.setText(this.mTime + "");
        this.tv_no_close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.weight.-$$Lambda$ClosePopup$Z24HCHlJTEKEn8CvWsAiPJO-IYU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$ClosePopup(view);
            }
        });
        this.claseHandler.postDelayed(this.thread, 1000L);
    }

    public /* synthetic */ void lambda$onCreate$0$ClosePopup(View view) {
        this.closeAct.onNoCloseAct();
        this.claseHandler.removeCallbacks(this.thread);
        dismiss();
    }

    public /* synthetic */ void lambda$new$1$ClosePopup() {
        Log.i("close", this.mTime + "-popup");
        this.mTime = this.mTime - 1;
        Message message = new Message();
        message.what = 1;
        message.obj = Integer.valueOf(this.mTime);
        this.claseHandler.sendMessage(message);
    }
}
