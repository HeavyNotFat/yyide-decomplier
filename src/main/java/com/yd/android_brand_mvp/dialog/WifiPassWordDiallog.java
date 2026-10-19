package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class WifiPassWordDiallog extends BaseDialog {
    TextView cancel;
    String content;
    Context context;
    EditText edit;
    WifiOnClickLister onClickLister;
    TextView qd;

    public interface WifiOnClickLister {
        void rightOnClick();
    }

    public WifiPassWordDiallog(Context context, int i) {
        super(context, i);
    }

    public WifiPassWordDiallog(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.content = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_wifi);
        this.qd = (TextView) findViewById(R.id.qd);
        this.cancel = (TextView) findViewById(R.id.cancel);
        EditText editText = (EditText) findViewById(R.id.edit);
        this.edit = editText;
        editText.setHint(this.content.toString());
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.WifiPassWordDiallog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WifiPassWordDiallog.this.onClickLister != null) {
                    WifiPassWordDiallog.this.onClickLister.rightOnClick();
                }
                WifiPassWordDiallog.this.cancel();
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.WifiPassWordDiallog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WifiPassWordDiallog.this.cancel();
            }
        });
    }

    public String getEditString() {
        return this.edit.getText().toString();
    }

    public void setOnClickLister(WifiOnClickLister wifiOnClickLister) {
        this.onClickLister = wifiOnClickLister;
    }
}
