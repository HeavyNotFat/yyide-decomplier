package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class NomalDiallog2 extends BaseDialog {
    TextView cancel;
    String content;
    Context context;
    WifiOnClickLister onClickLister;
    TextView qd;
    TextView title;

    public interface WifiOnClickLister {
        void rightOnClick();
    }

    public NomalDiallog2(Context context, int i) {
        super(context, i);
    }

    public NomalDiallog2(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.content = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_net_err2);
        this.qd = (TextView) findViewById(R.id.qd);
        this.cancel = (TextView) findViewById(R.id.cancel);
        TextView textView = (TextView) findViewById(R.id.title);
        this.title = textView;
        textView.setText(this.content);
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.NomalDiallog2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NomalDiallog2.this.onClickLister != null) {
                    NomalDiallog2.this.onClickLister.rightOnClick();
                }
                NomalDiallog2.this.cancel();
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.NomalDiallog2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NomalDiallog2.this.cancel();
            }
        });
    }

    public void setOnClickLister(WifiOnClickLister wifiOnClickLister) {
        this.onClickLister = wifiOnClickLister;
    }
}
