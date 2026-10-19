package com.yd.android_brand_mvp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.C;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel;
import com.yd.android_brand_mvp.activity.home.viewmodel.LoginViewModel;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpActivity;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.dialog.CheackDiallog;
import com.yd.android_brand_mvp.dialog.NomalDiallog;
import com.yd.android_brand_mvp.model.AuthorizeCodeBean;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.model.BrandRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.GetSiteByUserNameRsp;
import com.yd.android_brand_mvp.model.LoginHeaderBean;
import com.yd.android_brand_mvp.model.LoginQrCodeBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.presenter.LoginPresenter;
import com.yd.android_brand_mvp.utils.Base64Utils;
import com.yd.android_brand_mvp.utils.SDcarfile;
import com.yd.android_brand_mvp.utils.SkinUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.LoginView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {
    public static String TAG = "LoginActivity";

    @BindView(R.id.AuthCode)
    TextView AuthCode;

    @BindView(R.id.activateBtn)
    TextView activateBtn;

    @BindView(R.id.activate_layout)
    LinearLayout activateLayout;
    private getRegistrationCodeRsp authorizeCodeModel;
    GetSiteByUserNameRsp bean;

    @BindView(R.id.config)
    TextView config;
    String face_code;

    @BindView(R.id.face_layout)
    LinearLayout facelayout;

    @BindView(R.id.flQRRefresh)
    FrameLayout flQRRefresh;

    @BindView(R.id.getCode)
    TextView getCode;

    @BindView(R.id.getFaceCode)
    TextView getFaceCode;

    @BindView(R.id.go2qrcode)
    TextView go2qrcode;

    @BindView(R.id.jump_to_main)
    TextView jumpToMain;
    String keyid;

    @BindView(R.id.ll_account)
    LinearLayout llAccount;

    @BindView(R.id.llQRConfirm)
    LinearLayout llQRConfirm;

    @BindView(R.id.ll_qrcode)
    LinearLayout llQrcode;
    private TimerTask loadingTask;
    private Timer loadingTimer;
    String loginName;
    private LoginViewModel loginViewModel;
    String loginname;
    String[] mPermissionList;

    @BindView(R.id.name_layout)
    LinearLayout name_layout;
    String passWord;
    String password;

    @BindView(R.id.password_layout)
    LinearLayout password_layout;

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.psd)
    EditText psd;

    @BindView(R.id.qrcode)
    ImageView qrcode;

    @BindView(R.id.register)
    EditText register;

    @BindView(R.id.registerBtn)
    TextView registerBtn;

    @BindView(R.id.register_layout)
    LinearLayout register_layout;

    @BindView(R.id.school_layout)
    FrameLayout school_layout;
    int screenOrientation;

    @BindView(R.id.showcode)
    TextView showcode;

    @BindView(R.id.tips)
    TextView tips;

    @BindView(R.id.user)
    EditText user;
    private HomeViewModel viewModel;

    @BindView(R.id.welcome)
    LinearLayout welcome;
    int loginFlag = 1;
    int stuas = 0;
    String randomId = "";
    private boolean isNotScan = true;
    Handler handler = new Handler();

    @Override // com.yd.android_brand_mvp.base.BaseView
    public void showError() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ScreenUtils.isLandscape()) {
            this.screenOrientation = 0;
            setContentView(R.layout.activity_login_land);
        } else {
            this.screenOrientation = 1;
            setContentView(R.layout.activity_login2);
        }
        ButterKnife.bind(this);
        setAutoClose(false);
        this.viewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        this.loginViewModel = (LoginViewModel) new ViewModelProvider(this).get(LoginViewModel.class);
        this.loginname = SPUtils.getInstance().getString(BaseConstant.LOGINNAME, "");
        this.password = SPUtils.getInstance().getString(BaseConstant.PASSWORD, "");
        if (ScreenUtils.isLandscape()) {
            this.stuas = 0;
        } else {
            this.stuas = 1;
        }
        this.go2qrcode.getPaint().setFlags(8);
        if (!TextUtils.isEmpty(SPUtils.getInstance().getString(BaseConstant.LOGINNAME))) {
            this.user.setText(SPUtils.getInstance().getString(BaseConstant.LOGINNAME, ""));
            this.psd.setText(SPUtils.getInstance().getString(BaseConstant.PASSWORD, ""));
            EditText editText = this.user;
            editText.setSelection(editText.getText().toString().length());
            EditText editText2 = this.psd;
            editText2.setSelection(editText2.getText().toString().length());
        }
        initData();
        if (!TextUtils.isEmpty(this.loginName)) {
            this.user.setText(this.loginName);
        }
        if (!TextUtils.isEmpty(this.passWord)) {
            this.psd.setText(this.passWord);
        }
        this.face_code = SDcarfile.read(SDcarfile.FACE_CODE);
        this.showcode.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$_Ta9WCFJTWVPZnw4qMovmb4U70I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$LoginActivity(view);
            }
        });
        this.AuthCode.setEnabled(false);
        this.getCode.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$3cctMd0HmS1Mmvy5BEFOwJoSNA0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1$LoginActivity(view);
            }
        });
        this.getFaceCode.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$e1ZPrPRvTU6TI0DUSHnnw1RWR9k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2$LoginActivity(view);
            }
        });
        permission();
        if (Build.VERSION.SDK_INT >= 23) {
            askForPermission();
        }
        this.viewModel.getHomeDeviceConfig().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$dbQc8uKoukuLOiRXSrQcE3yX-qs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onCreate$3$LoginActivity((BrandConfigBean) obj);
            }
        });
        this.loginViewModel.getCheckLoginLiveData().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$b-YtJPXcOhWggv_UQD3ZBVoTigk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onCreate$4$LoginActivity((LoginQrCodeBean) obj);
            }
        });
        this.loginViewModel.getQrCodeLiveData().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$voNoTv3RRPaicVQXeSnGANQtxH8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onCreate$5$LoginActivity((LoginQrCodeBean) obj);
            }
        });
        setTimeQrCode();
    }

    public /* synthetic */ void lambda$onCreate$0$LoginActivity(View view) {
        if (TextUtils.isEmpty(this.AuthCode.getText().toString())) {
            return;
        }
        ToastUtil.showBottomView((Activity) this, this.AuthCode.getText().toString());
    }

    public /* synthetic */ void lambda$onCreate$1$LoginActivity(View view) {
        ((LoginPresenter) this.mvpPresenter).getRegistrationBrandCode();
    }

    public /* synthetic */ void lambda$onCreate$2$LoginActivity(View view) {
        ((LoginPresenter) this.mvpPresenter).getOrBindingDevice();
        String str = SDcarfile.read2();
        if (!TextUtils.isEmpty(str)) {
            this.AuthCode.setText(str);
        } else {
            this.getFaceCode.setClickable(false);
            ((LoginPresenter) this.mvpPresenter).getOrBindingDevice();
        }
    }

    public /* synthetic */ void lambda$onCreate$3$LoginActivity(BrandConfigBean brandConfigBean) {
        SkinUtil.INSTANCE.setTheme(this, BrandConfig.INSTANCE.getThemeCode());
        ((LoginPresenter) this.mvpPresenter).getNewBrandLogin(this.user.getText().toString(), BaseApplication.getInstance().getMac(), String.valueOf(this.stuas));
    }

    public /* synthetic */ void lambda$onCreate$4$LoginActivity(LoginQrCodeBean loginQrCodeBean) {
        if (!this.llQrcode.isShown() || loginQrCodeBean == null || this.isNotScan) {
            return;
        }
        int status = loginQrCodeBean.getStatus();
        if (status == 1) {
            Log.i(TAG, "getQrCodeLiveData = 已扫码");
            this.qrcode.setImageBitmap(null);
            this.flQRRefresh.setVisibility(8);
            this.llQRConfirm.setVisibility(0);
            return;
        }
        if (status == 2) {
            Log.i(TAG, "getQrCodeLiveData = 已过期");
            this.llQRConfirm.setVisibility(8);
            this.qrcode.setImageBitmap(null);
            this.flQRRefresh.setVisibility(0);
            this.llQRConfirm.setVisibility(8);
            this.isNotScan = true;
            return;
        }
        if (status != 3) {
            if (status == 4) {
                Log.i(TAG, "getQrCodeLiveData = 取消授权");
                this.llQRConfirm.setVisibility(8);
                this.loginViewModel.getLoginQrCode();
                return;
            }
            return;
        }
        Log.i(TAG, "getQrCodeLiveData = 已授权");
        this.isNotScan = true;
        LoginHeaderBean loginHeaderBean = (LoginHeaderBean) GsonUtils.fromJson(loginQrCodeBean.getTicket(), LoginHeaderBean.class);
        if (loginHeaderBean != null) {
            this.user.setText(loginHeaderBean.getUsername());
            ((LoginPresenter) this.mvpPresenter).getToken(loginHeaderBean.getUsername(), "", loginHeaderBean.getGrant_type(), loginHeaderBean.getRandom());
        } else {
            ToastUtil.showBottomView((Activity) this, "登录信息解析错误");
        }
    }

    public /* synthetic */ void lambda$onCreate$5$LoginActivity(LoginQrCodeBean loginQrCodeBean) {
        Log.i(TAG, "getQrCodeLiveData = " + GsonUtils.toJson(loginQrCodeBean));
        if (loginQrCodeBean != null && !TextUtils.isEmpty(loginQrCodeBean.getQrcode())) {
            Bitmap bitmapStringToBitmap = Base64Utils.INSTANCE.stringToBitmap(loginQrCodeBean.getQrcode());
            this.flQRRefresh.setVisibility(8);
            this.llQRConfirm.setVisibility(8);
            this.qrcode.setImageBitmap(bitmapStringToBitmap);
            this.randomId = loginQrCodeBean.getRandom();
            this.isNotScan = false;
            return;
        }
        this.qrcode.setImageBitmap(null);
        this.flQRRefresh.setVisibility(0);
    }

    private void setTimeQrCode() {
        this.loadingTimer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.yd.android_brand_mvp.LoginActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LoginActivity.this.isNotScan || !LoginActivity.this.llQrcode.isShown()) {
                    return;
                }
                LoginActivity.this.loginViewModel.getCheckLoginQrCode(LoginActivity.this.randomId);
            }
        };
        this.loadingTask = timerTask;
        this.loadingTimer.schedule(timerTask, 0L, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public void askForPermission() {
        if (Settings.canDrawOverlays(this)) {
            return;
        }
        Toast.makeText(this, "当前无权限，请授权！", 0).show();
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 10);
    }

    private void permission() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.ACCESS_FINE_LOCATION", "android.permission.CALL_PHONE", "android.permission.READ_LOGS", "android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.SET_DEBUG_APP", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.GET_ACCOUNTS", "android.permission.WRITE_SETTINGS", "android.permission.WRITE_APN_SETTINGS", "android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
            this.mPermissionList = strArr;
            requestPermissions(strArr, 1);
        }
    }

    void initData() {
        this.loginName = SPUtils.getInstance().getString(BaseConstant.LOGINNAME, "");
        this.passWord = SPUtils.getInstance().getString(BaseConstant.PASSWORD, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        this.loadingTimer.cancel();
    }

    @OnClick({R.id.config, R.id.go2qrcode, R.id.tvAccount, R.id.registerBtn, R.id.activateBtn, R.id.jump_to_main, R.id.flQRRefresh, R.id.ivSet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activateBtn /* 2131361883 */:
                if (TextUtils.isEmpty(this.AuthCode.getText())) {
                    ToastUtil.showView(this, "请获取激活码");
                } else if (!TextUtils.isEmpty(SDcarfile.read(SDcarfile.FACE_CODE))) {
                    startActivity(new Intent(this.mActivity, (Class<?>) MainActivity.class));
                    finish();
                } else {
                    ToastUtil.showView(this, "请获取激活码");
                }
                break;
            case R.id.config /* 2131362355 */:
                if (TextUtils.isEmpty(this.user.getText())) {
                    this.tips.setText("请输入帐号");
                } else if (!TextUtils.isEmpty(this.psd.getText())) {
                    this.tips.setText("");
                    loading();
                    ((LoginPresenter) this.mvpPresenter).getToken(this.user.getText().toString(), this.psd.getText().toString(), "brand", "");
                } else {
                    this.tips.setText("请输入密码");
                }
                break;
            case R.id.flQRRefresh /* 2131362629 */:
                this.loginViewModel.getLoginQrCode();
                break;
            case R.id.go2qrcode /* 2131362718 */:
                this.loginFlag = 0;
                this.llQrcode.setVisibility(0);
                this.llAccount.setVisibility(8);
                this.llQRConfirm.setVisibility(8);
                this.loginViewModel.getLoginQrCode();
                break;
            case R.id.ivSet /* 2131362908 */:
                if (ScreenUtils.isLandscape()) {
                    Intent intent = new Intent(this.mActivity, (Class<?>) SettingActivity.class);
                    intent.putExtra("type", "isLogin");
                    startActivity(intent);
                } else {
                    Intent intent2 = new Intent(this.mActivity, (Class<?>) SettingPActivity.class);
                    intent2.putExtra("type", "isLogin");
                    startActivity(intent2);
                }
                break;
            case R.id.jump_to_main /* 2131363064 */:
                SPUtils.getInstance().put(SpData.isFaceEnable, false);
                startActivity(new Intent(this.mActivity, (Class<?>) MainActivity.class));
                finish();
                break;
            case R.id.registerBtn /* 2131363563 */:
                if (!TextUtils.isEmpty(this.register.getText().toString())) {
                    ((LoginPresenter) this.mvpPresenter).updateRegistrationCode(this.register.getText().toString());
                } else {
                    ToastUtil.showView(this, "请输入注册码");
                }
                break;
            case R.id.tvAccount /* 2131364005 */:
                this.loginFlag = 1;
                this.welcome.setVisibility(0);
                this.llAccount.setVisibility(0);
                this.llQrcode.setVisibility(8);
                break;
        }
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getdataSuccess(NewLoginRsp newLoginRsp) {
        LogUtils.i("getdataSuccess: " + JSON.toJSONString(newLoginRsp));
        if (newLoginRsp.code == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(newLoginRsp.data.tokenHead);
            sb.append(newLoginRsp.data.accessToken);
            SPUtils.getInstance().put(SpData.TOKEN, sb.toString());
            SPUtils.getInstance().put(SpData.REFRESHTOKEN, newLoginRsp.data.refreshToken);
            MMKV.defaultMMKV().encode("token", sb.toString());
            this.viewModel.getDeviceConfig();
            return;
        }
        hideLoading();
        this.progress.setVisibility(8);
        ToastUtil.showBottomView(this.mActivity, newLoginRsp.message);
    }

    private void initRegistrationView() {
        this.llAccount.setVisibility(0);
        this.name_layout.setVisibility(8);
        this.password_layout.setVisibility(8);
        this.config.setVisibility(8);
        this.go2qrcode.setVisibility(8);
        this.llQrcode.setVisibility(8);
        if (TextUtils.isEmpty(SpData.RegisterCode())) {
            this.registerBtn.setVisibility(0);
            this.register_layout.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(SDcarfile.read(SDcarfile.FACE_CODE))) {
            this.registerBtn.setVisibility(8);
            this.register_layout.setVisibility(8);
            this.activateLayout.setVisibility(0);
            this.facelayout.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(SpData.RegisterCode()) || TextUtils.isEmpty(SDcarfile.read(SDcarfile.FACE_CODE))) {
            return;
        }
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getdataFail(String str) {
        hideLoading();
        this.progress.setVisibility(8);
        LogUtils.i(str);
        if (!NetworkUtils.isConnected() || "No route to host".equals(str) || str.contains("No address associated with hostname")) {
            NomalDiallog nomalDiallog = new NomalDiallog(this, "网络异常，请检查网络");
            nomalDiallog.setOnClickLister(new NomalDiallog.WifiOnClickLister() { // from class: com.yd.android_brand_mvp.-$$Lambda$LoginActivity$8Qg6Q7pxIygycmOFbWjDK4vLRZw
                @Override // com.yd.android_brand_mvp.dialog.NomalDiallog.WifiOnClickLister
                public final void rightOnClick() {
                    this.f$0.lambda$getdataFail$6$LoginActivity();
                }
            });
            nomalDiallog.show();
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.showBottomView(this.mActivity, "登录异常");
        } else {
            ToastUtil.showBottomView(this.mActivity, str);
        }
    }

    public /* synthetic */ void lambda$getdataFail$6$LoginActivity() {
        new CheackDiallog(this).show();
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getRegiestCodeSuccess(getRegistrationCodeRsp getregistrationcodersp) {
        hideLoading();
        if (getregistrationcodersp.code == 0) {
            if (getregistrationcodersp.data != null) {
                SPUtils.getInstance().put(SpData.SCHOOLID, getregistrationcodersp.data.schoolId);
                if (!TextUtils.isEmpty(getregistrationcodersp.data.registrationCode)) {
                    SPUtils.getInstance().put(SpData.RegCode, getregistrationcodersp.data.registrationCode);
                }
                Log.e("", SPUtils.getInstance().getString(SpData.SCHOOLID));
                this.keyid = getregistrationcodersp.data.id;
            }
        } else {
            ToastUtil.showBottomView(this.mActivity, getregistrationcodersp.message);
        }
        initRegistrationView();
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getRegiestCodeFail(String str) {
        hideLoading();
        ToastUtil.showBottomView(this.mActivity, "获取注册码失败");
        initRegistrationView();
    }

    public void initauthorize() {
        if (TextUtils.isEmpty(SDcarfile.read(SDcarfile.FACE_CODE))) {
            this.name_layout.setVisibility(8);
            this.password_layout.setVisibility(8);
            this.config.setVisibility(8);
            this.register_layout.setVisibility(8);
            this.registerBtn.setVisibility(8);
            this.activateLayout.setVisibility(0);
            this.facelayout.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(SpData.RegisterCode()) || TextUtils.isEmpty(SDcarfile.read(SDcarfile.FACE_CODE))) {
            return;
        }
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void updateRegistrationCodeByCodeSuccess(getRegistrationCodeRsp getregistrationcodersp) {
        if (getregistrationcodersp.code == 0) {
            if (TextUtils.isEmpty(getregistrationcodersp.data.registrationCode)) {
                return;
            }
            LogUtils.i("注册码注册成功 = " + getregistrationcodersp.data.registrationCode);
            SPUtils.getInstance().put(SpData.RegCode, getregistrationcodersp.data.registrationCode);
            initauthorize();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, getregistrationcodersp.message);
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void updateRegistrationCodeByCodeSuccessFail(String str) {
        ToastUtil.showBottomView(this.mActivity, str);
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getOrBindingDeviceSuccess(getRegistrationCodeRsp getregistrationcodersp) {
        hideLoading();
        this.authorizeCodeModel = getregistrationcodersp;
        this.getFaceCode.setClickable(true);
        LogUtils.i("获取激活码：" + GsonUtils.toJson(getregistrationcodersp));
        if (getregistrationcodersp.code == 0 && getregistrationcodersp.data != null && !TextUtils.isEmpty(getregistrationcodersp.data.authorizeCode)) {
            AuthorizeCodeBean authorizeCodeBean = (AuthorizeCodeBean) GsonUtils.fromJson(getregistrationcodersp.data.authorizeCode, AuthorizeCodeBean.class);
            if (authorizeCodeBean != null && !TextUtils.isEmpty(authorizeCodeBean.getT())) {
                this.AuthCode.setText(authorizeCodeBean.getT());
            } else {
                this.AuthCode.setText(getregistrationcodersp.data.authorizeCode);
            }
            SDcarfile.save(SDcarfile.FACE_CODE, this.authorizeCodeModel.data.authorizeCode);
            SDcarfile.save(SDcarfile.FACE_CODE_TYPE, this.authorizeCodeModel.data.type);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, getregistrationcodersp.message);
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getOrBindingDeviceFails(String str) {
        hideLoading();
        this.getFaceCode.setClickable(true);
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getRegiestBrandCodeSuccess(BrandRegistrationCodeRsp brandRegistrationCodeRsp) {
        hideLoading();
        LogUtils.i("获取注册码：" + GsonUtils.toJson(brandRegistrationCodeRsp));
        if (brandRegistrationCodeRsp.code == 0) {
            this.register.setText(brandRegistrationCodeRsp.data.authorizeCode);
        } else {
            ToastUtil.showView(this, brandRegistrationCodeRsp.message);
        }
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getRegiestBrandCodeFails(String str) {
        hideLoading();
        ToastUtil.showView(this, str);
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getNewBrandLoginSuccess(NewBrandLoginRsp newBrandLoginRsp) {
        if (newBrandLoginRsp.code == 0) {
            SPUtils.getInstance().put(BaseConstant.LOGINNAME, newBrandLoginRsp.data.loginName);
            SPUtils.getInstance().put(BaseConstant.PASSWORD, newBrandLoginRsp.data.plaintextPassword);
            SPUtils.getInstance().put(SpData.NewBrandUser, JSON.toJSONString(newBrandLoginRsp));
            ((LoginPresenter) this.mvpPresenter).getRegistrationCode();
            return;
        }
        hideLoading();
        ToastUtil.showView(this, newBrandLoginRsp.message);
        LogUtils.e(newBrandLoginRsp.message);
        if (this.llQrcode.isShown()) {
            this.loginViewModel.getLoginQrCode();
        }
    }

    @Override // com.yd.android_brand_mvp.view.LoginView
    public void getNewBrandLoginFails(String str) {
        hideLoading();
        ToastUtil.showView(this, str);
    }
}
