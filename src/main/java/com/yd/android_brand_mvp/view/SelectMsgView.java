package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.UserIcCardBean;

/* JADX INFO: loaded from: classes4.dex */
public interface SelectMsgView extends BaseView {
    void selectUserInfoByIcCard(UserIcCardBean userIcCardBean);

    void selectUserInfoByIcCardFail(String str);
}
