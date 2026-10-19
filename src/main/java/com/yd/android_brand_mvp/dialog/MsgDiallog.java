package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class MsgDiallog extends BaseDialog {
    Context context;
    TextView msg;
    String str;

    public MsgDiallog(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public MsgDiallog(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.str = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_layout);
        this.msg = (TextView) findViewById(R.id.msg);
    }
}
