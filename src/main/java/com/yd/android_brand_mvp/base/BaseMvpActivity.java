package com.yd.android_brand_mvp.base;

import android.os.Bundle;
import com.yd.android_brand_mvp.base.BasePresenter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    protected abstract P createPresenter();

    public void showLoading() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mvpPresenter = (P) createPresenter();
        super.onCreate(bundle);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        P p = this.mvpPresenter;
        if (p != null) {
            p.detachView();
        }
    }
}
