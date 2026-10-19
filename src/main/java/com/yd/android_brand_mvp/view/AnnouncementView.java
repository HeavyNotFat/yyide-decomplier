package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.SemesterTimeRsp;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.network.base.BaseResponse;

/* JADX INFO: loaded from: classes4.dex */
public interface AnnouncementView extends BaseView {
    void getNewNoticeFail(String str);

    void getNewNoticeSuccess(getNoticeRsp getnoticersp);

    void getSemesterTimeFail(String str);

    void getSemesterTimeSuccess(BaseResponse<SemesterTimeRsp> baseResponse);
}
