package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;

/* JADX INFO: loaded from: classes4.dex */
public interface StudentProductionView extends BaseView {
    void getProductionSuccessFail(String str);

    void getStudentWorkSuccess(StudentWorkListBean studentWorkListBean);

    void getStudentWorkSuccessFail(String str);

    void getWorkCommentSuccessFail(String str);

    void getWorkLikeSuccessFail(String str);

    void selectStudentInfoSuccess(StudentInfoBean studentInfoBean);

    void selectUserInfoByIcCardSuccess(UserIcCardBean userIcCardBean);

    void selectUserInfoByIcCardSuccessFail(String str);

    void setWorkCommentSuccess(NewWorkCommentRsp newWorkCommentRsp);

    void setWorkLikeSuccess(NewWorkCommentRsp newWorkCommentRsp);
}
