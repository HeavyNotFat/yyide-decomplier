package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface CheackMsgView extends BaseView {
    void selectUserInfoByIcCard(UserIcCardBean userIcCardBean);

    void selectUserInfoByIcCardFail(String str);

    void selectUserInfoByIcFace(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp);

    void selectUserInfoByIcFace(selectTeacherByIcCardRsp selectteacherbyiccardrsp);
}
