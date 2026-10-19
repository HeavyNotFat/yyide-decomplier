package com.yd.android_brand_mvp.base;

import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.ToastUtils;
import com.yd.android_brand_mvp.base.BasePresenter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P mvpPresenter;

    protected abstract P createPresenter();

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mvpPresenter = (P) createPresenter();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        P p = this.mvpPresenter;
        if (p != null) {
            p.detachView();
        }
    }

    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        dismissProgressDialog();
    }

    public void showError() {
        dismissProgressDialog();
        ToastUtils.showShort("出错啦！");
    }
}
