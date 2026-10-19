package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.MMKVUtils;

/* JADX INFO: loaded from: classes4.dex */
public class SocketIPDialog extends BaseDialog {
    Context context;
    EditText edit;
    TextView qd;

    public SocketIPDialog(Context context, int i) {
        super(context, i);
    }

    public SocketIPDialog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_socket);
        this.qd = (TextView) findViewById(R.id.qd);
        this.edit = (EditText) findViewById(R.id.edit);
        String string = MMKVUtils.INSTANCE.getString(MMKVConstant.SOCKET_IP);
        if (!TextUtils.isEmpty(string)) {
            this.edit.setText(string);
        }
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$SocketIPDialog$WzUs0LqGOas8hAaU9gIt_akemOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$SocketIPDialog(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$SocketIPDialog(View view) {
        String strTrim = this.edit.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            this.edit.setError("请输入IP");
            return;
        }
        MMKVUtils.INSTANCE.put(MMKVConstant.SOCKET_IP, strTrim);
        MinaEventManager.getInstance().notifyObserver(MinaConstants.SOCKET_IP);
        LogUtils.i(strTrim);
        SoftKeyBoardUtil.hideKeyBoard(this.edit);
        cancel();
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SoftKeyBoardUtil.hideKeyBoard(this.edit);
        super.onDismiss(dialogInterface);
    }
}
