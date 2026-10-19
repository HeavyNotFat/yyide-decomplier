package com.yd.android_brand_mvp.net;

import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.BaseApplication;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.net.SocketTimeoutException;
import retrofit2.HttpException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ApiCallback<M> implements Observer<M> {
    public abstract void onFailure(String str);

    public abstract void onFinish();

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
    }

    public abstract void onSuccess(M m);

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        String message;
        th.printStackTrace();
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            int iCode = httpException.code();
            message = httpException.getMessage();
            if (iCode == 504) {
                message = "网络不给力";
            }
            if (iCode == 502 || iCode == 404) {
                message = "服务器异常，请稍后再试";
            }
        } else {
            message = th instanceof SocketTimeoutException ? "网络不给力，请求超时请重试" : th.getMessage();
        }
        if (!BaseApplication.isNetworkAvailable(BaseApplication.getInstance())) {
            message = "请检查网络连接";
        }
        if (!TextUtils.isEmpty(message)) {
            onFailure(message);
        } else {
            onFailure("异常返回");
        }
        LogUtils.e(message);
        onFinish();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(M m) {
        try {
            onSuccess(m);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof NullPointerException) {
                return;
            }
            onFailure(e.getMessage());
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        onFinish();
    }
}
