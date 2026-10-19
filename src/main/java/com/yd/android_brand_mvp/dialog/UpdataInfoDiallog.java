package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialogTime;

/* JADX INFO: loaded from: classes4.dex */
public class UpdataInfoDiallog extends BaseDialogTime {
    String Verson;
    TextView cancel;
    TextView close;
    FrameLayout content_layout;
    Activity context;
    OnclickListener onclickListener;
    TextView qd;
    TextView version;

    public interface OnclickListener {
        void onclick();
    }

    public UpdataInfoDiallog(Context context, int i) {
        super(context, i);
        this.Verson = "";
    }

    public UpdataInfoDiallog(Activity activity, String str) {
        this(activity, R.style.shareDialog);
        this.context = activity;
        this.Verson = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialogTime, com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.updata_info_layout);
        this.version = (TextView) findViewById(R.id.version);
        this.close = (TextView) findViewById(R.id.close);
        this.cancel = (TextView) findViewById(R.id.cancel);
        this.qd = (TextView) findViewById(R.id.qd);
        this.content_layout = (FrameLayout) findViewById(R.id.content_layout);
        this.close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataInfoDiallog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdataInfoDiallog.this.cancel();
            }
        });
        this.version.setText(this.Verson + "");
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataInfoDiallog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdataInfoDiallog.this.onclickListener != null) {
                    UpdataInfoDiallog.this.onclickListener.onclick();
                    UpdataInfoDiallog.this.cancel();
                }
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataInfoDiallog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdataInfoDiallog.this.cancel();
            }
        });
        this.content_layout.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataInfoDiallog.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                UpdataInfoDiallog.this.NowTime = System.currentTimeMillis() / 1000;
                return false;
            }
        });
    }

    public void setonclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialogTime, com.yd.android_brand_mvp.observer.observer2.TimeNoiceListener
    public void updataTime(long j) {
        super.updataTime(j);
        isout(j);
    }

    void isout(long j) {
        if (j - this.NowTime < 60 || this.context.isDestroyed()) {
            return;
        }
        cancel();
    }
}
