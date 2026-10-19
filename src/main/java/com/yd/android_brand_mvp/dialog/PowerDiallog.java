package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.brand.BroCast;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class PowerDiallog extends BaseDialog implements View.OnClickListener {
    TextView cancel;
    Context context;
    TextView msg;
    String str;
    TextView yes;

    public PowerDiallog(Context context, int i) {
        super(context, i);
        this.str = "确定要关机吗？";
    }

    public PowerDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_msg_layout);
        this.msg = (TextView) findViewById(R.id.msg);
        this.yes = (TextView) findViewById(R.id.yes);
        TextView textView = (TextView) findViewById(R.id.cancel);
        this.cancel = textView;
        textView.setOnClickListener(this);
        this.yes.setOnClickListener(this);
        this.msg.setText(this.str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.msg.getText().toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinCompatResources.getInstance().getColor(R.color.purple2)), 3, 5, 33);
        this.msg.setText(spannableStringBuilder);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel) {
            cancel();
        } else {
            if (id != R.id.yes) {
                return;
            }
            BroCast.shutdown(this.context);
            cancel();
        }
    }
}
