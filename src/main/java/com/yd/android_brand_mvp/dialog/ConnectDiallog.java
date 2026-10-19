package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.brand.BroCast;

/* JADX INFO: loaded from: classes4.dex */
public class ConnectDiallog extends Dialog {
    Context context;
    TextView msg;
    TextView qd;
    TextView qx;
    String str;

    public ConnectDiallog(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public ConnectDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_msg_layout2);
        this.qx = (TextView) findViewById(R.id.cancel);
        this.qd = (TextView) findViewById(R.id.yes);
        TextView textView = (TextView) findViewById(R.id.msg);
        this.msg = textView;
        textView.setText("确定解绑?");
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ConnectDiallog$H192ZHBdeMhMTSb5x5GiWzS-VNs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$ConnectDiallog(view);
            }
        });
        this.qx.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$ConnectDiallog$A-NjX7UYOF80NQvqsXUPq3UfQQU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1$ConnectDiallog(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ConnectDiallog(View view) {
        BroCast.reset(this.context);
        cancel();
    }

    public /* synthetic */ void lambda$onCreate$1$ConnectDiallog(View view) {
        cancel();
    }
}
