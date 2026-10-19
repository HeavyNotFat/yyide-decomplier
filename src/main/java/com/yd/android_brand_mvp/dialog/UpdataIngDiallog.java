package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.finalteam.okhttpfinal.FileDownloadCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.model.UpdateDialogIsTimeEventBean;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class UpdataIngDiallog extends BaseDialog {
    String appUrl;
    Context context;
    DownLoadLister downLoadLister;
    Handler handler;
    public boolean isdown;
    TextView message;
    TextView pause;
    ProgressBar progressBar;

    public interface DownLoadLister {
        void loadfinish();
    }

    public UpdataIngDiallog(Context context, int i) {
        super(context, i);
        this.isdown = true;
        this.handler = new Handler() { // from class: com.yd.android_brand_mvp.dialog.UpdataIngDiallog.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    UpdataIngDiallog.this.progressBar.setProgress(message.arg1);
                }
            }
        };
    }

    public UpdataIngDiallog(Context context, String str) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.appUrl = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.updata_progress);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.update_progress);
        this.progressBar = progressBar;
        progressBar.setMax(100);
        this.message = (TextView) findViewById(R.id.message);
        TextView textView = (TextView) findViewById(R.id.pause);
        this.pause = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.UpdataIngDiallog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NomalDiallog2 nomalDiallog2 = new NomalDiallog2(UpdataIngDiallog.this.context, "");
                nomalDiallog2.setOnClickLister(new NomalDiallog2.WifiOnClickLister() { // from class: com.yd.android_brand_mvp.dialog.UpdataIngDiallog.1.1
                    @Override // com.yd.android_brand_mvp.dialog.NomalDiallog2.WifiOnClickLister
                    public void rightOnClick() {
                        HttpRequest.cancel(UpdataIngDiallog.this.appUrl);
                        UpdataIngDiallog.this.cancel();
                        UpdataIngDiallog.this.isdown = false;
                    }
                });
                nomalDiallog2.show();
            }
        });
        this.isTimerClost = true;
        download(this.appUrl);
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        EventBus.getDefault().post(new UpdateDialogIsTimeEventBean(2));
    }

    void download(String str) {
        final File file = new File("/sdcard/rootexplorer_140220.apk");
        HttpRequest.download(str, file, new FileDownloadCallback() { // from class: com.yd.android_brand_mvp.dialog.UpdataIngDiallog.2
            @Override // cn.finalteam.okhttpfinal.FileDownloadCallback
            public void onStart() {
                super.onStart();
            }

            @Override // cn.finalteam.okhttpfinal.FileDownloadCallback
            public void onProgress(int i, long j) {
                super.onProgress(i, j);
                UpdataIngDiallog.this.progressBar.setProgress(i);
                UpdataIngDiallog.this.message.setText("软件更新中..." + i + "%");
            }

            @Override // cn.finalteam.okhttpfinal.FileDownloadCallback
            public void onFailure() {
                super.onFailure();
                Toast.makeText(UpdataIngDiallog.this.context, "下载失败", 0).show();
                UpdataIngDiallog.this.cancel();
            }

            @Override // cn.finalteam.okhttpfinal.FileDownloadCallback
            public void onDone() {
                super.onDone();
                if (UpdataIngDiallog.this.isdown) {
                    Toast.makeText(UpdataIngDiallog.this.context, "下载成功", 0).show();
                    Log.e("TAG", "onDone: ");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    UpdataIngDiallog.this.context.startActivity(intent);
                    UpdataIngDiallog.this.cancel();
                    if (UpdataIngDiallog.this.downLoadLister != null) {
                        UpdataIngDiallog.this.downLoadLister.loadfinish();
                    }
                }
            }
        });
    }

    public void setDownloadLister(DownLoadLister downLoadLister) {
        this.downLoadLister = this.downLoadLister;
    }
}
