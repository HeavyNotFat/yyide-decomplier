package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.BrandRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface LoginView extends BaseView {
    void getNewBrandLoginFails(String str);

    void getNewBrandLoginSuccess(NewBrandLoginRsp newBrandLoginRsp);

    void getOrBindingDeviceFails(String str);

    void getOrBindingDeviceSuccess(getRegistrationCodeRsp getregistrationcodersp);

    void getRegiestBrandCodeFails(String str);

    void getRegiestBrandCodeSuccess(BrandRegistrationCodeRsp brandRegistrationCodeRsp);

    void getRegiestCodeFail(String str);

    void getRegiestCodeSuccess(getRegistrationCodeRsp getregistrationcodersp);

    void getdataFail(String str);

    void getdataSuccess(NewLoginRsp newLoginRsp);

    void updateRegistrationCodeByCodeSuccess(getRegistrationCodeRsp getregistrationcodersp);

    void updateRegistrationCodeByCodeSuccessFail(String str);
}
