package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface StudentToUserCardView extends BaseView {
    void StudentCard(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp);

    void StudentCardFail(String str);
}
