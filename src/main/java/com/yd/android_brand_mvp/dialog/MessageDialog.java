package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.utils.SpData;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class MessageDialog extends BaseDialog implements View.OnClickListener {
    TextView cancel;
    Context context;
    private OnCallBackListener mOnCallBackListener;
    TextView msg;
    String str;
    TextView yes;

    public interface OnCallBackListener {
        void onClick();
    }

    public MessageDialog(Context context, int i) {
        super(context, i);
        this.str = "是否要切换至常规版吗？";
    }

    public MessageDialog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_message);
        this.msg = (TextView) findViewById(R.id.msg);
        this.yes = (TextView) findViewById(R.id.yes);
        TextView textView = (TextView) findViewById(R.id.cancel);
        this.cancel = textView;
        textView.setOnClickListener(this);
        this.yes.setOnClickListener(this);
        if (SpData.isNight()) {
            this.str = "确定要切换至常规版吗？";
        } else {
            this.str = "确定要切换至卡通版吗？";
        }
        this.msg.setText(this.str);
        if (SpData.isNight()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.msg.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinCompatResources.getInstance().getColor(R.color.purple2)), 6, 9, 33);
            this.msg.setText(spannableStringBuilder);
        }
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
            OnCallBackListener onCallBackListener = this.mOnCallBackListener;
            if (onCallBackListener != null) {
                onCallBackListener.onClick();
            }
            cancel();
        }
    }

    public void setOnCallBackListener(OnCallBackListener onCallBackListener) {
        this.mOnCallBackListener = onCallBackListener;
    }
}
