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
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class CheackDiallog extends BaseDialog {
    Context context;
    EditText edit;
    TextView qd;

    public CheackDiallog(Context context, int i) {
        super(context, i);
    }

    public CheackDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_cheack);
        this.qd = (TextView) findViewById(R.id.qd);
        this.edit = (EditText) findViewById(R.id.edit);
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$CheackDiallog$SAYT2ON8Lo_rB0OeTw4CmwMoG4E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$CheackDiallog(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$CheackDiallog(View view) {
        Identy();
    }

    void Identy() {
        if (TextUtils.isEmpty(this.edit.getText().toString())) {
            this.edit.setError("请输入密码");
        } else if (this.edit.getText().toString().equals(time())) {
            cancel();
            this.context.startActivity(new Intent("android.settings.SETTINGS"));
        } else {
            this.edit.setError("密码不正确");
        }
    }

    private String time() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
