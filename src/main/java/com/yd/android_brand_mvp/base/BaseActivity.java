package com.yd.android_brand_mvp.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.dialog.NomalLoadingDiallog;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.NetWorkManager;
import com.yd.android_brand_mvp.observer.NetWorkStaus;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.utils.ActivityTool;
import com.yd.android_brand_mvp.utils.ClickUtils;
import com.yd.android_brand_mvp.utils.FontsUtils;
import com.yd.android_brand_mvp.utils.GPIOUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.NetworkChangeReceiver;
import com.yd.android_brand_mvp.weight.ClosePopup;
import com.yd.android_brand_mvp.weight.PunchCardPopup;
import com.ys.rkapi.Utils.Utils;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import me.jessyan.autosize.internal.CustomAdapt;
import skin.support.app.SkinCompatActivity;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseActivity extends SkinCompatActivity implements ObserverListener, NetWorkStaus, CustomAdapt, NetworkChangeReceiver.NetStateChangeObserver {
    private static final String TAG = BaseActivity.class.getSimpleName();
    public FragmentEventListener listener;
    public Activity mActivity;
    private CompositeDisposable mCompositeDisposable;
    public NomalLoadingDiallog nomalLoadingDiallog;
    OnHintClose onHintClose;
    public ProgressDialog progressDialog;
    Thread thread;
    private int countDown = BaseConstant.exitTime;
    public boolean isAutoClose = true;
    public boolean isSecondLevel = true;
    public boolean isTheme = true;
    private boolean isCountDown = true;
    public Handler claseHandler = new Handler(Looper.getMainLooper()) { // from class: com.yd.android_brand_mvp.base.BaseActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                BaseActivity.this.claseHandler.removeCallbacks(BaseActivity.this.thread);
                BaseActivity.this.finish();
            } else {
                if (message.what != 2 || BaseActivity.this.onHintClose == null) {
                    return;
                }
                BaseActivity.this.onHintClose.hintClose();
            }
        }
    };

    public interface OnHintClose {
        void hintClose();
    }

    public void getWork(boolean z) {
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return true;
    }

    public void observerUpData(String str) {
    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(65536);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    public void setKeyeventListener(FragmentEventListener fragmentEventListener) {
        this.listener = fragmentEventListener;
    }

    public void onDisconnect() {
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN_CLOSE());
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED());
    }

    public void onMobileConnect() {
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED_CLOSE());
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN());
    }

    public void onWifiConnect() {
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED_CLOSE());
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN());
    }

    public void onReticleConnect() {
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED_CLOSE());
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN());
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return ScreenUtils.isLandscape() ? 1920.0f : 1080.0f;
    }

    public void startThread() {
        Thread thread = new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.base.BaseActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (BaseActivity.this.claseHandler != null && BaseActivity.this.isSecondLevel) {
                    BaseActivity.this.claseHandler.postDelayed(this, 1000L);
                }
                if (BaseActivity.this.isCountDown) {
                    BaseConstant.exitOutTime--;
                }
                Log.d(BaseActivity.TAG, "二级页面关闭倒计时剩余：" + BaseConstant.exitOutTime + "秒");
                Message message = new Message();
                if (BaseConstant.exitOutTime <= 0) {
                    message.what = 1;
                } else if (BaseActivity.this.onHintClose != null && BaseConstant.exitOutTime == 10) {
                    message.what = 2;
                }
                if (BaseActivity.this.claseHandler != null) {
                    BaseActivity.this.claseHandler.sendMessage(message);
                }
            }
        });
        this.thread = thread;
        thread.start();
    }

    public void removeCallHandler() {
        Handler handler = this.claseHandler;
        if (handler != null) {
            handler.removeCallbacks(this.thread);
        }
    }

    public void setAcountDown(int i) {
        BaseConstant.exitOutTime = i;
    }

    public void setOnHintClose(OnHintClose onHintClose) {
        this.onHintClose = onHintClose;
    }

    public void goActivity(Class cls) {
        if (AppUtils.isAppDebug()) {
            startActivity(new Intent(this.mActivity, (Class<?>) cls));
        } else if (SpData.getMsgType()) {
            startActivity(new Intent(this.mActivity, (Class<?>) cls));
        } else {
            ToastUtil.showBottomView(this.mActivity, "二级页面已禁用");
        }
    }

    @Override // skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = SPUtils.getInstance().getBoolean(SpData.SKIN);
        Log.i("BaseActivity", "是否是动画版本：" + z);
        if (z) {
            FontsUtils.INSTANCE.replaceSystemDefaultFont(this, FontsUtils.fontPath);
            if (this.isTheme) {
                setTheme(R.style.NoTitleFullscreen);
            }
        } else {
            FontsUtils.INSTANCE.typeFaceDefault();
        }
        int intExtra = getIntent().getIntExtra("time", BaseConstant.exitTime);
        this.countDown = intExtra;
        if (intExtra <= 0) {
            this.countDown = BaseConstant.exitTime;
        }
        ActivityTool.getInstance().addActivity(this);
        Utils.setValueToProp("persist.sys.statebarslide", "0");
        this.mActivity = this;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(134217728);
            getWindow().setStatusBarColor(SkinCompatResources.getInstance().getColor(R.color.white));
            getWindow().setNavigationBarColor(SkinCompatResources.getInstance().getColor(R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192 | 16);
        }
        if (BaseApplication.isNetworkAvailable(this)) {
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED_CLOSE());
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN());
        } else {
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN_CLOSE());
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED());
        }
        this.nomalLoadingDiallog = new NomalLoadingDiallog(this.mActivity);
        NetWorkManager.getInstance().add(this);
        setOnHintClose(new OnHintClose() { // from class: com.yd.android_brand_mvp.base.-$$Lambda$BaseActivity$GsWcmnKAk0g3-XlFjBUGzF_CKFc
            @Override // com.yd.android_brand_mvp.base.BaseActivity.OnHintClose
            public final void hintClose() {
                this.f$0.lambda$onCreate$0$BaseActivity();
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$BaseActivity() {
        XPopup.Builder builderEnableDrag = new XPopup.Builder(this).enableDrag(false);
        ClosePopup.CloseAct closeAct = new ClosePopup.CloseAct() { // from class: com.yd.android_brand_mvp.base.BaseActivity.3
            @Override // com.yd.android_brand_mvp.weight.ClosePopup.CloseAct
            public void onCloseAct() {
                BaseActivity.this.finish();
            }

            @Override // com.yd.android_brand_mvp.weight.ClosePopup.CloseAct
            public void onNoCloseAct() {
                BaseActivity baseActivity = BaseActivity.this;
                baseActivity.setAcountDown(baseActivity.countDown);
            }
        };
        int i = this.countDown;
        builderEnableDrag.asCustom(new ClosePopup(this, closeAct, i - (i - 10))).show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(View.inflate(this, i, null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ClickUtils.clear();
        this.isSecondLevel = true;
        if (this.isAutoClose) {
            BaseConstant.exitOutTime = this.countDown;
            startThread();
        }
    }

    public void setAutoClose(boolean z) {
        this.isAutoClose = z;
    }

    public void setTempCountDownStatus(boolean z) {
        this.isCountDown = z;
        if (z) {
            return;
        }
        BaseConstant.exitOutTime = BaseConstant.exitTime;
    }

    public void setNoShowTime() {
        setOnHintClose(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
        this.isSecondLevel = false;
        this.claseHandler.removeCallbacks(this.thread);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override // skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        onUnsubscribe();
        NetWorkManager.getInstance().remove(this);
        ActivityTool.getInstance().finishActivity(this);
        super.onDestroy();
        this.claseHandler.removeCallbacks(this.thread);
        this.claseHandler = null;
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN_CLOSE());
        GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_RED_CLOSE());
        BaseConstant.exitOutTime = BaseConstant.exitTime;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Log.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
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
        Log.d(TAG, "onUnsubscribe");
        CompositeDisposable compositeDisposable = this.mCompositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            this.mCompositeDisposable = null;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public ProgressDialog showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this.mActivity);
        this.progressDialog = progressDialog;
        progressDialog.setMessage("加载中");
        this.progressDialog.show();
        return this.progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence charSequence) {
        ProgressDialog progressDialog = new ProgressDialog(this.mActivity);
        this.progressDialog = progressDialog;
        progressDialog.setMessage(charSequence);
        this.progressDialog.show();
        return this.progressDialog;
    }

    public void dismissProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    public void loading() {
        NomalLoadingDiallog nomalLoadingDiallog = this.nomalLoadingDiallog;
        if (nomalLoadingDiallog != null) {
            nomalLoadingDiallog.show();
        }
    }

    public void hideLoading() {
        NomalLoadingDiallog nomalLoadingDiallog = this.nomalLoadingDiallog;
        if (nomalLoadingDiallog == null || !nomalLoadingDiallog.isShowing()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }

    public void showCard(GeneralBean generalBean) {
        new XPopup.Builder(this).asCustom(new PunchCardPopup(this, generalBean)).show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 2)) {
            View currentFocus = getCurrentFocus();
            if (isShouldHideInput(currentFocus, motionEvent)) {
                hideSoftInput(currentFocus.getWindowToken());
            }
            BaseConstant.exitOutTime = this.countDown;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    private void hideSoftInput(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        }
    }
}
