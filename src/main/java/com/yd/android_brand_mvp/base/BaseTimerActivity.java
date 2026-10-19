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
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.EventTimerBean;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.NetWorkManager;
import com.yd.android_brand_mvp.observer.NetWorkStaus;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.ActivityTool;
import com.yd.android_brand_mvp.utils.ClickUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.weight.PunchCardPopup;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.autosize.internal.CustomAdapt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import retrofit2.Call;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseTimerActivity extends AppCompatActivity implements ObserverListener, NetWorkStaus, CustomAdapt {
    private static final String TAG = BaseTimerActivity.class.getSimpleName();
    public static String timer = "card";
    private List<Call> calls;
    public FragmentEventListener listener;
    public Activity mActivity;
    private CompositeDisposable mCompositeDisposable;
    OnHintClose onHintClose;
    public ProgressDialog progressDialog;
    int countDown = 60;
    int endTime = 60;
    boolean isAutoClose = true;
    int type = -1;
    Handler claseHandler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.base.BaseTimerActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                BaseTimerActivity.this.claseHandler.removeCallbacks(BaseTimerActivity.this.thread);
                KeyboardUtils.hideSoftInput(BaseTimerActivity.this.mActivity);
                BaseTimerActivity.this.finish();
            } else {
                if (message.what != 2 || BaseTimerActivity.this.onHintClose == null) {
                    return;
                }
                BaseTimerActivity.this.onHintClose.hintClose();
            }
        }
    };
    Thread thread = new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.base.BaseTimerActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (BaseTimerActivity.this.claseHandler != null) {
                BaseTimerActivity.this.claseHandler.postDelayed(this, 1000L);
            }
            BaseTimerActivity.this.endTime--;
            Message message = new Message();
            if (BaseTimerActivity.this.endTime <= 0) {
                message.what = 1;
            } else if (BaseTimerActivity.this.onHintClose != null && BaseTimerActivity.this.endTime == 10) {
                message.what = 2;
            }
            if (BaseTimerActivity.this.claseHandler != null) {
                BaseTimerActivity.this.claseHandler.sendMessage(message);
            }
        }
    });
    boolean fGet = true;
    String keyContent = "";

    public interface OnHintClose {
        void hintClose();
    }

    public char GetCharByKeyCode(int i) {
        char c = (i <= 6 || i >= 17) ? (char) 0 : (char) ((i - 7) + 48);
        return (i <= 28 || i >= 55) ? c : (char) ((i - 29) + 65);
    }

    @Override // com.yd.android_brand_mvp.observer.NetWorkStaus
    public void getWork(boolean z) {
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return true;
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 66) {
            if (!TextUtils.isEmpty(this.keyContent) && this.keyContent.length() > 0) {
                Log.i(TAG, "usb 键盘输入卡号=" + this.keyContent);
                String strReplaceAll = this.keyContent.replaceAll("^(0+)", "");
                Log.i(TAG, "usb 键盘输入卡号 去掉前缀为0=" + strReplaceAll);
                ObserverManager.getInstance().notifyObserver(strReplaceAll);
            }
            this.keyContent = "";
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (this.fGet) {
                this.keyContent += GetCharByKeyCode(keyCode);
                this.fGet = false;
            } else {
                this.fGet = true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return ScreenUtils.isLandscape() ? 1920.0f : 1080.0f;
    }

    public void setAcountDown(int i) {
        this.endTime = i;
    }

    public void setOnHintClose(OnHintClose onHintClose) {
        this.onHintClose = onHintClose;
    }

    public void setKeyeventListener(FragmentEventListener fragmentEventListener) {
        this.listener = fragmentEventListener;
    }

    public void goActivity(Class cls) {
        if (AppUtils.isAppDebug()) {
            startActivity(new Intent(this.mActivity, (Class<?>) cls));
        } else if (SpData.getMsgType()) {
            startActivity(new Intent(this.mActivity, (Class<?>) cls));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.countDown = getIntent().getIntExtra("time", 60);
        EventBus.getDefault().register(this);
        ActivityTool.getInstance().addActivity(this);
        this.mActivity = this;
        if (Build.VERSION.SDK_INT >= 26) {
            getWindow().clearFlags(134217728);
            getWindow().setStatusBarColor(SkinCompatResources.getInstance().getColor(R.color.white));
            getWindow().setNavigationBarColor(SkinCompatResources.getInstance().getColor(R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192 | 16);
        }
        NetWorkManager.getInstance().add(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(View.inflate(this, i, null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ClickUtils.clear();
        if (this.isAutoClose) {
            this.isAutoClose = false;
            this.endTime = this.countDown;
            if (this.thread.isAlive()) {
                return;
            }
            this.thread.start();
        }
    }

    public void setAutoClose(boolean z) {
        this.isAutoClose = z;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
        Handler handler = this.claseHandler;
        if (handler != null) {
            handler.removeCallbacks(this.thread);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        callCancel();
        onUnsubscribe();
        NetWorkManager.getInstance().remove(this);
        ActivityTool.getInstance().finishActivity(this);
        super.onDestroy();
        this.claseHandler.removeCallbacks(this.thread);
        this.claseHandler = null;
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void thread(EventTimerBean eventTimerBean) {
        setAcountDown(60);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Log.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
    }

    public void addCalls(Call call) {
        if (this.calls == null) {
            this.calls = new ArrayList();
        }
        this.calls.add(call);
    }

    private void callCancel() {
        List<Call> list = this.calls;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Call call : this.calls) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
        this.calls.clear();
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

    public void toastShow(int i) {
        Toast.makeText(this.mActivity, i, 0).show();
    }

    public void toastShow(String str) {
        Toast.makeText(this.mActivity, str, 0).show();
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

    public void showCard(GeneralBean generalBean) {
        new XPopup.Builder(this).asCustom(new PunchCardPopup(this, generalBean)).show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (isShouldHideInput(currentFocus, motionEvent)) {
                hideSoftInput(currentFocus.getWindowToken());
            }
            this.endTime = this.countDown;
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
