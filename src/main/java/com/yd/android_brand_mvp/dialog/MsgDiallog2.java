package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class MsgDiallog2 extends BaseDialog {
    TextView cancel;
    Activity context;
    TextView msg;
    String str;

    public MsgDiallog2(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public MsgDiallog2(Activity activity, String str) {
        this(activity, R.style.shareDialog);
        this.context = activity;
        this.str = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.msg_layout2);
        this.msg = (TextView) findViewById(R.id.msg);
        this.cancel = (TextView) findViewById(R.id.cancel);
        this.msg.setText(this.str);
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$MsgDiallog2$fyGL2xgr2qYavbtjRf6ICkvgkko
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$MsgDiallog2(view);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$MsgDiallog2$PR9YWQQRmIjvfDcMHnhr4z25oG0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$onCreate$1$MsgDiallog2(dialogInterface);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$MsgDiallog2(View view) {
        cancel();
    }

    public /* synthetic */ void lambda$onCreate$1$MsgDiallog2(DialogInterface dialogInterface) {
        cancel();
        this.context.finish();
    }
}
