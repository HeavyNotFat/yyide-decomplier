package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.verificationCodeRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface RegisterView extends BaseView {
    void verificationCode(verificationCodeRsp verificationcodersp);

    void verificationCodeFail(String str);
}
