package com.yd.android_brand_mvp.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import com.yd.android_brand_mvp.dialog.BookLoadingDiallog;
import com.yd.android_brand_mvp.dialog.NomalLoadingDiallog;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.utils.ClickUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public class BaseFragment extends Fragment implements MinaListener {
    public BookLoadingDiallog bookLoadingDiallog;
    public Activity mActivity;
    private CompositeDisposable mCompositeDisposable;
    public NomalLoadingDiallog nomalLoadingDiallog;
    public OnFragmentDataListener onFragmentDataListener;

    public interface OnFragmentDataListener {
        void onFragmentData(boolean z);
    }

    public void UpdataEvent(int i) {
    }

    public void networkReconnection() {
    }

    public void setOnFragmentDataListener(OnFragmentDataListener onFragmentDataListener) {
        this.onFragmentDataListener = onFragmentDataListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this, view);
        this.mActivity = getActivity();
        this.bookLoadingDiallog = new BookLoadingDiallog(this.mActivity);
        this.nomalLoadingDiallog = new NomalLoadingDiallog(this.mActivity);
        MinaEventManager.getInstance().add(this);
    }

    public void toastShow(int i) {
        Toast.makeText(this.mActivity, i, 0).show();
    }

    public void toastShow(String str) {
        Toast.makeText(this.mActivity, str, 0).show();
    }

    public void goPermissionsActivity(Class cls) {
        if (ClickUtils.isFastClick()) {
            if (SpData.getMsgType()) {
                startActivity(new Intent(this.mActivity, (Class<?>) cls));
            } else {
                ToastUtil.showBottomView(this.mActivity, "二级页面已禁用");
            }
        }
    }

    public void goPermissionsActivity(Intent intent) {
        if (ClickUtils.isFastClick()) {
            if (SpData.getMsgType()) {
                startActivity(intent);
            } else {
                ToastUtil.showBottomView(this.mActivity, "二级页面已禁用");
            }
        }
    }

    public boolean secondaryPagePermissions() {
        if (!ClickUtils.isFastClick() || SpData.getMsgType()) {
            return true;
        }
        ToastUtil.showBottomView(this.mActivity, "二级页面已禁用");
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MinaEventManager.getInstance().remove(this);
        onUnsubscribe();
        dismissProgressDialog();
    }

    public void addSubscription(Observable observable, Observer observer) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void addSubscription(Disposable disposable) {
        CompositeDisposable compositeDisposable = this.mCompositeDisposable;
        if (compositeDisposable == null && compositeDisposable.isDisposed()) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(disposable);
    }

    public void onUnsubscribe() {
        CompositeDisposable compositeDisposable = this.mCompositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            this.mCompositeDisposable = null;
        }
    }

    public void showProgressDialog() {
        NomalLoadingDiallog nomalLoadingDiallog = this.nomalLoadingDiallog;
        if (nomalLoadingDiallog != null) {
            nomalLoadingDiallog.show();
        }
    }

    public void dismissProgressDialog() {
        NomalLoadingDiallog nomalLoadingDiallog = this.nomalLoadingDiallog;
        if (nomalLoadingDiallog == null || !nomalLoadingDiallog.isShowing()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }
}
