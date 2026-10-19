package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.utils.OpenAndCloseTimeUtils;
import com.yd.android_brand_mvp.utils.SpData;

/* JADX INFO: loaded from: classes4.dex */
public class TimeDialog extends BaseDialog {
    TextView cancel;
    TextView close;
    String content;
    Context context;
    TextView open;
    TextView qd;

    public TimeDialog(Context context, int i) {
        super(context, i);
    }

    public TimeDialog(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.content = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_time);
        this.qd = (TextView) findViewById(R.id.qd);
        this.open = (TextView) findViewById(R.id.open);
        this.close = (TextView) findViewById(R.id.close);
        this.cancel = (TextView) findViewById(R.id.cancel);
        String closeTime = OpenAndCloseTimeUtils.getInstance().getCloseTime(SpData.getTime());
        String openTime = OpenAndCloseTimeUtils.getInstance().getOpenTime(SpData.getTime());
        if (SpData.getTime() != null) {
            TextView textView = this.open;
            if (TextUtils.isEmpty(openTime)) {
                openTime = "无";
            }
            textView.setText(openTime);
        }
        if (SpData.getTime() != null) {
            TextView textView2 = this.close;
            if (TextUtils.isEmpty(closeTime)) {
                closeTime = "无";
            }
            textView2.setText(closeTime);
        }
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$TimeDialog$ykKsoDF2XVefNvwuyY_PVMm2jqM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$TimeDialog(view);
            }
        });
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$TimeDialog$W9pFagnxZLVIxadxp3uE6vEKEak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1$TimeDialog(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$TimeDialog(View view) {
        cancel();
    }

    public /* synthetic */ void lambda$onCreate$1$TimeDialog(View view) {
        cancel();
    }
}
