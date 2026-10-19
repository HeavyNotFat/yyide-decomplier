package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.ClassInfoView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoPresenter extends BasePresenter<ClassInfoView> {
    public ClassInfoPresenter(ClassInfoView classInfoView) {
        attachView(classInfoView);
    }

    public void selectClassesInfo(long j) {
        addSubscription(this.dingApiStores.selectClassesInfo(SPUtils.getInstance().getString(BaseConstant.LOGINNAME)), new ApiCallback<selectClassesInfoRsp>() { // from class: com.yd.android_brand_mvp.presenter.ClassInfoPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectClassesInfoRsp selectclassesinforsp) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((ClassInfoView) ClassInfoPresenter.this.mvpView).getFail(str);
            }
        });
    }

    public void selectNewClassesInfo() {
        addSubscription(this.dingApiStores.selectNewClassesInfo(SpData.getClassesId()), new ApiCallback<NewClassInfoRsp>() { // from class: com.yd.android_brand_mvp.presenter.ClassInfoPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewClassInfoRsp newClassInfoRsp) {
                ((ClassInfoView) ClassInfoPresenter.this.mvpView).getDataSuccess(newClassInfoRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((ClassInfoView) ClassInfoPresenter.this.mvpView).getFail(str);
            }
        });
    }

    public void getWatchWord(String str) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
        addSubscription(this.dingApiStores.getWatchWord(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<NewWatchWordRsp>() { // from class: com.yd.android_brand_mvp.presenter.ClassInfoPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewWatchWordRsp newWatchWordRsp) {
                ((ClassInfoView) ClassInfoPresenter.this.mvpView).getWatchWordSuccess(newWatchWordRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                if (ClassInfoPresenter.this.mvpView != 0) {
                    ((ClassInfoView) ClassInfoPresenter.this.mvpView).getFail1(str2);
                }
            }
        });
    }

    public void getClassesInfo(String str) {
        addSubscription(this.dingApiStores.getClassesInfo(!StringUtils.isEmpty(str) ? Long.parseLong(str) : 0L), new ApiCallback<ClassesInfoBean>() { // from class: com.yd.android_brand_mvp.presenter.ClassInfoPresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(ClassesInfoBean classesInfoBean) {
                ((ClassInfoView) ClassInfoPresenter.this.mvpView).getDataSuccess1(classesInfoBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((ClassInfoView) ClassInfoPresenter.this.mvpView).getFail1(str2);
            }
        });
    }
}
