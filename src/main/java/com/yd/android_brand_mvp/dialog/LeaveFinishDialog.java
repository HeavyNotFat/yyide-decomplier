package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ActivityUtils;
import com.yd.android_brand_mvp.MainActivity;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class LeaveFinishDialog extends BaseDialog {
    FrameLayout back_layout;
    Context context;
    addListener mAddListener;
    TextView qd;

    public interface addListener {
        void addFinishListener();
    }

    public LeaveFinishDialog(Context context, int i) {
        super(context, i);
    }

    public LeaveFinishDialog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_leave_finish);
        this.qd = (TextView) findViewById(R.id.qd);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.back_layout);
        this.back_layout = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.LeaveFinishDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeaveFinishDialog.this.cancel();
                ActivityUtils.finishToActivity((Class<? extends Activity>) MainActivity.class, false);
            }
        });
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.LeaveFinishDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LeaveFinishDialog.this.mAddListener != null) {
                    LeaveFinishDialog.this.mAddListener.addFinishListener();
                }
                LeaveFinishDialog.this.cancel();
            }
        });
    }

    public void setFinishListener(addListener addlistener) {
        this.mAddListener = addlistener;
    }
}
