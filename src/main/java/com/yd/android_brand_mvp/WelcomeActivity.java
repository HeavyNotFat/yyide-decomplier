package com.yd.android_brand_mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpActivity;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.presenter.WelcomePresenter;
import com.yd.android_brand_mvp.utils.SkinUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.view.WelcomeView;

/* JADX INFO: loaded from: classes4.dex */
public class WelcomeActivity extends BaseMvpActivity<WelcomePresenter> implements WelcomeView {
    private String loginDataStr;
    private String loginName;
    private String passWord;
    int stuas = 0;
    private String TAG = WelcomeActivity.class.getSimpleName();

    @Override // com.yd.android_brand_mvp.base.BaseView
    public void showError() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.isTheme = false;
        this.isAutoClose = false;
        super.onCreate(bundle);
        if (ScreenUtils.isLandscape()) {
            this.stuas = 0;
        } else {
            this.stuas = 1;
        }
        ButterKnife.bind(this);
        initData();
        SkinUtil.INSTANCE.setTheme(this, BrandConfig.INSTANCE.getThemeCode());
        start();
    }

    private void start() {
        String strRegisterCode = SpData.RegisterCode();
        Log.i("TAG", "code: " + strRegisterCode);
        if (TextUtils.isEmpty(strRegisterCode)) {
            goLoginActivity();
        } else if (isLogining2()) {
            ((WelcomePresenter) this.mvpPresenter).getNewToken(SPUtils.getInstance().getString(BaseConstant.LOGINNAME, ""), SPUtils.getInstance().getString(BaseConstant.PASSWORD, null));
        } else {
            goLoginActivity();
        }
    }

    void initData() {
        this.loginDataStr = SPUtils.getInstance().getString(SpData.LOGINDATA, "");
        this.loginName = SPUtils.getInstance().getString(BaseConstant.LOGINNAME, "");
        this.passWord = SPUtils.getInstance().getString(BaseConstant.PASSWORD, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity
    public WelcomePresenter createPresenter() {
        return new WelcomePresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    void goLoginActivity() {
        startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        finish();
    }

    private void goMainActivity() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // com.yd.android_brand_mvp.view.WelcomeView
    public void getdataSuccess(NewLoginRsp newLoginRsp) {
        if (newLoginRsp.code == 0) {
            SPUtils.getInstance().put(SpData.TOKEN, newLoginRsp.data.tokenHead + newLoginRsp.data.accessToken);
            SPUtils.getInstance().put(SpData.REFRESHTOKEN, newLoginRsp.data.refreshToken);
            SPUtils.getInstance().put(BaseConstant.loginSuccess, true);
            ((WelcomePresenter) this.mvpPresenter).NewBrandLogin(this.loginName, BaseApplication.getInstance().getMac(), String.valueOf(this.stuas));
            return;
        }
        goMainActivity();
    }

    @Override // com.yd.android_brand_mvp.view.WelcomeView
    public void getdataFail(String str) {
        goMainActivity();
    }

    @Override // com.yd.android_brand_mvp.view.WelcomeView
    public void getBrandFail(String str) {
        if (!TextUtils.isEmpty(this.loginDataStr)) {
            SPUtils.getInstance().put(BaseConstant.loginSuccess, true);
        }
        goMainActivity();
    }

    @Override // com.yd.android_brand_mvp.view.WelcomeView
    public void getNewBrandSuccess(NewBrandLoginRsp newBrandLoginRsp) {
        if (newBrandLoginRsp.code == 0) {
            SPUtils.getInstance().put(BaseConstant.LOGINNAME, newBrandLoginRsp.data.loginName);
            SPUtils.getInstance().put(BaseConstant.PASSWORD, newBrandLoginRsp.data.plaintextPassword);
            SPUtils.getInstance().put(SpData.NewBrandUser, JSON.toJSONString(newBrandLoginRsp));
            goMainActivity();
            return;
        }
        if (newBrandLoginRsp.code == 1002073004) {
            ToastUtil.showBottomView((Activity) this, newBrandLoginRsp.message);
            goLoginActivity();
        } else {
            goMainActivity();
        }
    }

    boolean isLogining2() {
        return (TextUtils.isEmpty(this.loginName) || TextUtils.isEmpty(this.passWord)) ? false : true;
    }
}
