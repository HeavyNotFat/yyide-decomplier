package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.StudentLeaveView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class StudentLeavePresenter extends BasePresenter<StudentLeaveView> {
    public StudentLeavePresenter(StudentLeaveView studentLeaveView) {
        attachView(studentLeaveView);
    }

    public void getAskLeaveRecordBand(int i) {
        HashMap map = new HashMap();
        map.put("pageNo", "1");
        map.put("pageSize", "20");
        map.put("userId", String.valueOf(i));
        addSubscription(this.dingApiStores.askForLeaveRecordBandList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<GetAskLeaveRecordBandRsp>() { // from class: com.yd.android_brand_mvp.presenter.StudentLeavePresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
                ((StudentLeaveView) StudentLeavePresenter.this.mvpView).GetAskLeaveRecordBandRsp(getAskLeaveRecordBandRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((StudentLeaveView) StudentLeavePresenter.this.mvpView).GetAskLeaveRecordBandRspFail(str);
            }
        });
    }
}
