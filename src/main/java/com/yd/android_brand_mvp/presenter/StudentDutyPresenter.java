package com.yd.android_brand_mvp.presenter;

import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.StudentDutyView;

/* JADX INFO: loaded from: classes4.dex */
public class StudentDutyPresenter extends BasePresenter<StudentDutyView> {
    public StudentDutyPresenter(StudentDutyView studentDutyView) {
        attachView(studentDutyView);
    }

    public void studentDutylist(String str) {
        addSubscription(this.dingApiStores.getStudentDuty(str), new ApiCallback<StudenDutyBean>() { // from class: com.yd.android_brand_mvp.presenter.StudentDutyPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(StudenDutyBean studenDutyBean) {
            }
        });
    }

    public void newStudentDutyList() {
        addSubscription(this.dingApiStores.getNewStudentDuty(), new ApiCallback<StudenDutyBean>() { // from class: com.yd.android_brand_mvp.presenter.StudentDutyPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(StudenDutyBean studenDutyBean) {
                ((StudentDutyView) StudentDutyPresenter.this.mvpView).getStudentDutySuccess(studenDutyBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((StudentDutyView) StudentDutyPresenter.this.mvpView).getSuccessFail(str);
            }
        });
    }
}
