package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.DeviceUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.BrandRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.utils.view.net.NetWorkUtil;
import com.yd.android_brand_mvp.view.LoginView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class LoginPresenter extends BasePresenter<LoginView> {
    public LoginPresenter(LoginView loginView) {
        attachView(loginView);
    }

    public void getToken(String str, String str2, String str3, String str4) {
        addSubscription(this.dingApiStores.newLogin(str, str2, "yide-cloud", str3, "__SEC_CLIENT_SECRET_68B09CCF__", str4), new ApiCallback<NewLoginRsp>() { // from class: com.yd.android_brand_mvp.presenter.LoginPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewLoginRsp newLoginRsp) {
                ((LoginView) LoginPresenter.this.mvpView).getdataSuccess(newLoginRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str5) {
                ((LoginView) LoginPresenter.this.mvpView).getdataFail(str5);
            }
        });
    }

    public void getNewBrandLogin(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("loginName", str);
        map.put("no", str2);
        map.put("wlanMac", NetWorkUtil.getMacAddressByWifiInfo());
        map.put("seriaNo", "__SEC_ANDROID_ID_PUT_9FC4DBAF__");
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str3);
        addSubscription(this.dingApiStores.getBrandObtain(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<NewBrandLoginRsp>() { // from class: com.yd.android_brand_mvp.presenter.LoginPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewBrandLoginRsp newBrandLoginRsp) {
                ((LoginView) LoginPresenter.this.mvpView).getNewBrandLoginSuccess(newBrandLoginRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((LoginView) LoginPresenter.this.mvpView).getNewBrandLoginFails(str4);
            }
        });
    }

    public void updateRegistrationCode(String str) {
        ((LoginView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("no", BaseApplication.getInstance().getMac());
        map.put("registrationCode", str);
        map.put("deviceType", "2");
        if (SpData.NewUser() != null && SpData.NewUser().data != null) {
            map.put("schoolId", SpData.getSchoolId());
        }
        addSubscription(this.dingApiStores.updateNewRegistrationCodeByCode(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.toGson(map))), new ApiCallback<getRegistrationCodeRsp>() { // from class: com.yd.android_brand_mvp.presenter.LoginPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getRegistrationCodeRsp getregistrationcodersp) {
                ((LoginView) LoginPresenter.this.mvpView).hideLoading();
                ((LoginView) LoginPresenter.this.mvpView).updateRegistrationCodeByCodeSuccess(getregistrationcodersp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((LoginView) LoginPresenter.this.mvpView).hideLoading();
                ((LoginView) LoginPresenter.this.mvpView).updateRegistrationCodeByCodeSuccessFail(str2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((LoginView) LoginPresenter.this.mvpView).hideLoading();
            }
        });
    }

    public void getRegistrationCode() {
        HashMap map = new HashMap();
        map.put("no", BaseApplication.getInstance().getMac());
        map.put("deviceType", "2");
        if (SpData.NewUser() != null && SpData.NewUser().data != null) {
            map.put("schoolId", SpData.getSchoolId());
        }
        addSubscription(this.dingApiStores.getRegistrationCode(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.toGson(map))), new ApiCallback<getRegistrationCodeRsp>() { // from class: com.yd.android_brand_mvp.presenter.LoginPresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getRegistrationCodeRsp getregistrationcodersp) {
                ((LoginView) LoginPresenter.this.mvpView).getRegiestCodeSuccess(getregistrationcodersp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((LoginView) LoginPresenter.this.mvpView).getRegiestCodeFail(str);
            }
        });
    }

    public void getOrBindingDevice() {
        HashMap map = new HashMap();
        map.put("no", BaseApplication.getInstance().getMac());
        map.put("deviceType", "2");
        map.put("type", "3");
        if (SpData.NewUser() != null && SpData.NewUser().data != null) {
            map.put("schoolId", SpData.getSchoolId());
        }
        addSubscription(this.dingApiStores.getOrBindingDevice(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.toGson(map))), new ApiCallback<getRegistrationCodeRsp>() { // from class: com.yd.android_brand_mvp.presenter.LoginPresenter.5
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getRegistrationCodeRsp getregistrationcodersp) {
                ((LoginView) LoginPresenter.this.mvpView).getOrBindingDeviceSuccess(getregistrationcodersp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((LoginView) LoginPresenter.this.mvpView).getOrBindingDeviceFails(str);
            }
        });
    }

    public void getRegistrationBrandCode() {
        HashMap map = new HashMap();
        map.put("deviceNo", BaseApplication.getInstance().getMac());
        map.put("deviceType", "2");
        addSubscription(this.dingApiStores.getBrandRegistrationCode(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<BrandRegistrationCodeRsp>() { // from class: com.yd.android_brand_mvp.presenter.LoginPresenter.6
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BrandRegistrationCodeRsp brandRegistrationCodeRsp) {
                ((LoginView) LoginPresenter.this.mvpView).getRegiestBrandCodeSuccess(brandRegistrationCodeRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((LoginView) LoginPresenter.this.mvpView).getRegiestBrandCodeFails(str);
            }
        });
    }
}
