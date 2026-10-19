package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.utils.SpData;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class CheackLongDiallog extends BaseDialog {
    Context context;
    EditText edit;
    TextView qd;

    public CheackLongDiallog(Context context, int i) {
        super(context, i);
    }

    public CheackLongDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_cheack2);
        LogUtils.i("进入设置页面, 进入系统验证弹窗");
        this.qd = (TextView) findViewById(R.id.qd);
        this.edit = (EditText) findViewById(R.id.edit);
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.CheackLongDiallog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheackLongDiallog.this.Identy();
            }
        });
    }

    void Identy() {
        if (TextUtils.isEmpty(this.edit.getText().toString())) {
            this.edit.setError("请输入密码");
            return;
        }
        if (this.edit.getText().toString().equals(BaseConstant.IN_SETTING_PWD)) {
            cancel();
            LogUtils.i("进入设置页面, 进入系统设置页面");
            this.context.startActivity(new Intent("android.settings.SETTINGS"));
        } else {
            this.edit.setError("密码不正确");
            SPUtils.getInstance().put(SpData.historyNum, SpData.gethistoryPower() + 1);
        }
    }

    private String time() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
