package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.StudentToUserCardView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class StudentToUserPresenter extends BasePresenter<StudentToUserCardView> {
    public StudentToUserPresenter(StudentToUserCardView studentToUserCardView) {
        attachView(studentToUserCardView);
    }

    public void StudentCardByCard(String str) {
        HashMap map = new HashMap();
        map.put("icCardNo", str);
        String jSONString = JSON.toJSONString((Object) map, true);
        LogUtils.i(jSONString);
        addSubscription(this.dingApiStores.selectNewStudentByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONString)), new ApiCallback<selectNewStudentByIcCardRsp>() { // from class: com.yd.android_brand_mvp.presenter.StudentToUserPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
                ((StudentToUserCardView) StudentToUserPresenter.this.mvpView).StudentCard(selectnewstudentbyiccardrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((StudentToUserCardView) StudentToUserPresenter.this.mvpView).StudentCardFail(str2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((StudentToUserCardView) StudentToUserPresenter.this.mvpView).hideLoading();
            }
        });
    }

    public void StudentCardByFace(String str) {
        HashMap map = new HashMap();
        map.put("userId", str);
        addSubscription(this.dingApiStores.selectNewStudentByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<selectNewStudentByIcCardRsp>() { // from class: com.yd.android_brand_mvp.presenter.StudentToUserPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
                ((StudentToUserCardView) StudentToUserPresenter.this.mvpView).StudentCard(selectnewstudentbyiccardrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                if (StudentToUserPresenter.this.mvpView == 0) {
                    return;
                }
                ((StudentToUserCardView) StudentToUserPresenter.this.mvpView).StudentCardFail(str2);
            }
        });
    }
}
