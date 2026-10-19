package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class ExitSystemDiallog extends BaseDialog implements View.OnClickListener {
    TextView cancel;
    Context context;
    TextView msg;
    OnExitSystem onExitSystem;
    TextView yes;

    public interface OnExitSystem {
        void onExitSystem();
    }

    public ExitSystemDiallog(Context context, int i) {
        super(context, i);
    }

    public ExitSystemDiallog(Context context, OnExitSystem onExitSystem) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.onExitSystem = onExitSystem;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.exit_system_layout);
        this.yes = (TextView) findViewById(R.id.yes);
        TextView textView = (TextView) findViewById(R.id.cancel);
        this.cancel = textView;
        textView.setOnClickListener(this);
        this.yes.setOnClickListener(this);
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
            cancel();
            this.onExitSystem.onExitSystem();
        }
    }
}
