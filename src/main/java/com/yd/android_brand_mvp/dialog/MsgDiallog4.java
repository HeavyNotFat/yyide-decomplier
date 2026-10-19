package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MsgDiallog4 extends BaseDialog {
    Context context;
    EditText msg;
    TextView qd;

    public MsgDiallog4(Context context, int i) {
        super(context, i);
    }

    public MsgDiallog4(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_layout4);
        this.msg = (EditText) findViewById(R.id.msg);
        TextView textView = (TextView) findViewById(R.id.qd);
        this.qd = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.MsgDiallog4.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgDiallog4.this.Identy();
            }
        });
    }

    void Identy() {
        if (TextUtils.isEmpty(this.msg.getText().toString())) {
            ToastUtil.showBottomView(getOwnerActivity(), "请输入密码");
        } else if (this.msg.getText().toString().equals(time())) {
            cancel();
            this.context.startActivity(new Intent("android.settings.SETTINGS"));
        } else {
            ToastUtil.showBottomView(getOwnerActivity(), "密码不正确");
        }
    }

    private String time() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
