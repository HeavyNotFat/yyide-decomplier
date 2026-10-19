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
public class RebootDiallog extends BaseDialog implements View.OnClickListener {
    TextView cancel;
    Context context;
    TextView msg;
    String str;
    TextView yes;

    public RebootDiallog(Context context, int i) {
        super(context, i);
        this.str = "请确定重新重启班牌？";
    }

    public RebootDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_reboot);
        this.msg = (TextView) findViewById(R.id.msg);
        this.yes = (TextView) findViewById(R.id.yes);
        TextView textView = (TextView) findViewById(R.id.cancel);
        this.cancel = textView;
        textView.setOnClickListener(this);
        this.yes.setOnClickListener(this);
        this.msg.setText(this.str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.msg.getText().toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinCompatResources.getInstance().getColor(R.color.purple2)), 3, 7, 33);
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
            BroCast.reboot(this.context);
            cancel();
        }
    }
}
