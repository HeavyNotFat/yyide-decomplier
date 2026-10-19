package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;

/* JADX INFO: loaded from: classes4.dex */
public class BookLoadingDiallog extends BaseDialog {
    Activity context;
    ImageView img;

    public BookLoadingDiallog(Context context, int i) {
        super(context, i);
    }

    public BookLoadingDiallog(Activity activity) {
        this(activity, R.style.shareDialog);
        this.context = activity;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pd_loading);
        this.img = (ImageView) findViewById(R.id.img);
        Activity activity = this.context;
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        Glide.with(this.context).load(Integer.valueOf(R.drawable.icon_book)).into(this.img);
    }
}
