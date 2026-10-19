package com.yd.android_brand_mvp.presenter;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.ApproverAdapterBean;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.ApproverListRsp;
import com.yd.android_brand_mvp.model.BaseContentRsp;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.RequestJsonData;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.LeaveView;
import java.util.HashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class LeavePresenter extends BasePresenter<LeaveView> {
    public LeavePresenter(LeaveView leaveView) {
        attachView(leaveView);
    }

    public void getAskLeaveRecordBand(long j, int i) {
        HashMap map = new HashMap();
        map.put("pageNo", i + "");
        map.put("pageSize", "20");
        map.put("userId", String.valueOf(j));
        addSubscription(this.dingApiStores.askForLeaveRecordBandList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<GetAskLeaveRecordBandRsp>() { // from class: com.yd.android_brand_mvp.presenter.LeavePresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
                ((LeaveView) LeavePresenter.this.mvpView).GetAskLeaveRecordBandRsp(getAskLeaveRecordBandRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((LeaveView) LeavePresenter.this.mvpView).GetAskLeaveRecordBandRspFail(str);
            }
        });
    }

    public void getApproverList(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("startDate", str2);
        map.put("endDate", str3);
        map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
        map.put("identity", "0");
        map.put(CommentsHomeFragment.TYPE_ID, str4);
        addSubscription(this.dingApiStores.getApprover(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<ApproverListRsp>() { // from class: com.yd.android_brand_mvp.presenter.LeavePresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(ApproverListRsp approverListRsp) {
                ((LeaveView) LeavePresenter.this.mvpView).getApproverListSuccess(approverListRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str5) {
                ((LeaveView) LeavePresenter.this.mvpView).getSuccessFail(str5);
            }
        });
    }

    public void addLeave(RequestJsonData requestJsonData, List<ApproverAdapterBean.RequestParam> list, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap map = new HashMap();
        map.put("jsonData", requestJsonData);
        map.put("procId", str);
        map.put("dept", str3);
        map.put("isBack", Boolean.valueOf(z));
        map.put("deptName", str4);
        map.put("apprs", list);
        map.put("ccIds", str5);
        map.put("sponsorType", "0");
        map.put("identityUserId", str6);
        String jSONString = JSON.toJSONString((Object) map, true);
        Log.e("addLeave", jSONString);
        addSubscription(this.dingApiStores.addLeave(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONString)), new ApiCallback<BaseContentRsp>() { // from class: com.yd.android_brand_mvp.presenter.LeavePresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str7) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseContentRsp baseContentRsp) {
                ((LeaveView) LeavePresenter.this.mvpView).addLeaveSuccess(baseContentRsp);
            }
        });
    }

    public void getApproverInfo(String str) {
        addSubscription(this.dingApiStores.getApproverInfo(str), new ApiCallback<ApproverInfoRsp>() { // from class: com.yd.android_brand_mvp.presenter.LeavePresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(ApproverInfoRsp approverInfoRsp) {
                ((LeaveView) LeavePresenter.this.mvpView).getApproverInfoSuccess(approverInfoRsp);
            }
        });
    }

    public void deleteInstance(String str) {
        HashMap map = new HashMap();
        map.put("processInstanceId", str);
        map.put("deleteReason", "");
        addSubscription(this.dingApiStores.deleteInstance(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<BaseContentRsp>() { // from class: com.yd.android_brand_mvp.presenter.LeavePresenter.5
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseContentRsp baseContentRsp) {
                ((LeaveView) LeavePresenter.this.mvpView).delectSuccess(baseContentRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((LeaveView) LeavePresenter.this.mvpView).delectFail(str2);
            }
        });
    }
}
