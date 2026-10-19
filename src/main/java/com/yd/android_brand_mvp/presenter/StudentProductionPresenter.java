package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.view.StudentProductionView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionPresenter extends BasePresenter<StudentProductionView> {
    public StudentProductionPresenter(StudentProductionView studentProductionView) {
        attachView(studentProductionView);
    }

    public void getStudentWorkList(String str, int i) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
        map.put("pageSize", ConversionUtil.conditionWithSort);
        map.put("pageNo", i + "");
        addSubscription(this.dingApiStores.getNewStudentWorkList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<StudentWorkListBean>() { // from class: com.yd.android_brand_mvp.presenter.StudentProductionPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(StudentWorkListBean studentWorkListBean) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).getStudentWorkSuccess(studentWorkListBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).getStudentWorkSuccessFail(str2);
            }
        });
    }

    public void setWorkLike(String str, String str2) {
        addSubscription(this.dingApiStores.setNewWorkLike(str, str2), new ApiCallback<NewWorkCommentRsp>() { // from class: com.yd.android_brand_mvp.presenter.StudentProductionPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewWorkCommentRsp newWorkCommentRsp) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).setWorkLikeSuccess(newWorkCommentRsp);
            }
        });
    }

    public void setWorkComment(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("id", str);
        map.put("comment", str2);
        map.put("createBy", str3);
        map.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str4);
        addSubscription(this.dingApiStores.setNewWorkComment(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<NewWorkCommentRsp>() { // from class: com.yd.android_brand_mvp.presenter.StudentProductionPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewWorkCommentRsp newWorkCommentRsp) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).setWorkCommentSuccess(newWorkCommentRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str5) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).getWorkCommentSuccessFail(str5);
            }
        });
    }

    public void selectStudentInfo(String str) {
        addSubscription(this.dingApiStores.selectNewStudentInfo(str), new ApiCallback<StudentInfoBean>() { // from class: com.yd.android_brand_mvp.presenter.StudentProductionPresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(StudentInfoBean studentInfoBean) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).selectStudentInfoSuccess(studentInfoBean);
            }
        });
    }

    public void selectUserInfoByIcCard(String str) {
        ((StudentProductionView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("icCardNo", str);
        addSubscription(this.dingApiStores.selectNewUserInfoByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserIcCardBean>() { // from class: com.yd.android_brand_mvp.presenter.StudentProductionPresenter.5
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserIcCardBean userIcCardBean) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).selectUserInfoByIcCardSuccess(userIcCardBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).selectUserInfoByIcCardSuccessFail(str2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((StudentProductionView) StudentProductionPresenter.this.mvpView).hideLoading();
            }
        });
    }
}
