package com.yd.android_brand_mvp.base;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.net.AppClient;
import com.yd.android_brand_mvp.net.BookApiStores;
import com.yd.android_brand_mvp.net.DingApiStores;
import com.yd.android_brand_mvp.net.LocalApiStores;
import com.yd.android_brand_mvp.net.WeatherApiStores;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public class BasePresenter<V extends BaseView> {
    protected BookApiStores bookApiStores;
    protected DingApiStores dingApiStores;
    protected LocalApiStores localApiStores;
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<BaseView> mReferenceView;
    public V mvpView;
    protected WeatherApiStores weatherApiStores;

    public void attachView(V v) {
        this.mReferenceView = new WeakReference<>(v);
        this.mvpView = (V) Proxy.newProxyInstance(v.getClass().getClassLoader(), v.getClass().getInterfaces(), new InvocationHandler() { // from class: com.yd.android_brand_mvp.base.-$$Lambda$BasePresenter$drbJ46aMMk3C_GkbgpH8Sp-pjv4
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.f$0.lambda$attachView$0$BasePresenter(obj, method, objArr);
            }
        });
        this.dingApiStores = (DingApiStores) AppClient.getDingRetrofit().create(DingApiStores.class);
        this.bookApiStores = (BookApiStores) AppClient.getBookRetrofit().create(BookApiStores.class);
        this.weatherApiStores = (WeatherApiStores) AppClient.getWeatherRetrofit().create(WeatherApiStores.class);
        this.localApiStores = (LocalApiStores) AppClient.getLocalRetrofit().create(LocalApiStores.class);
    }

    public /* synthetic */ Object lambda$attachView$0$BasePresenter(Object obj, Method method, Object[] objArr) throws Throwable {
        WeakReference<BaseView> weakReference = this.mReferenceView;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return method.invoke(this.mReferenceView.get(), objArr);
    }

    public void detachView() {
        onUnsubscribe();
        WeakReference<BaseView> weakReference = this.mReferenceView;
        if (weakReference != null) {
            weakReference.clear();
            this.mReferenceView = null;
        }
    }

    public void onUnsubscribe() {
        CompositeDisposable compositeDisposable = this.mCompositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            this.mCompositeDisposable = null;
        }
    }

    public void addSubscription(Observable observable, Observer observer) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
