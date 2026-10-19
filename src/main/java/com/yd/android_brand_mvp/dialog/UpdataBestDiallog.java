package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.AppUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialogTime;

/* JADX INFO: loaded from: classes4.dex */
public class UpdataBestDiallog extends BaseDialogTime {
    TextView close;
    FrameLayout content_layout;
    Context context;
    String str;
    TextView version;

    public UpdataBestDiallog(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public UpdataBestDiallog(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.str = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialogTime, com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.updata_layout);
        this.version = (TextView) findViewById(R.id.version);
        this.close = (TextView) findViewById(R.id.close);
        this.content_layout = (FrameLayout) findViewById(R.id.content_layout);
        this.close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataBestDiallog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdataBestDiallog.this.cancel();
            }
        });
        this.version.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + AppUtils.getAppVersionName());
        this.content_layout.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataBestDiallog.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                UpdataBestDiallog.this.NowTime = System.currentTimeMillis() / 1000;
                return false;
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialogTime, com.yd.android_brand_mvp.observer.observer2.TimeNoiceListener
    public void updataTime(long j) {
        super.updataTime(j);
        isout(j);
    }

    void isout(long j) {
        if (j - this.NowTime >= 60) {
            cancel();
        }
    }
}
