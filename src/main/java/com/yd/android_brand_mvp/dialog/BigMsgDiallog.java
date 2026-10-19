package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class BigMsgDiallog extends BaseDialog {
    Context context;
    EditText msg;
    String str;

    public BigMsgDiallog(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public BigMsgDiallog(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.str = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.big_msg_layout);
        EditText editText = (EditText) findViewById(R.id.msg);
        this.msg = editText;
        editText.setText(this.str);
    }
}
