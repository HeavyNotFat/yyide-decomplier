package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.ApproverListRsp;
import com.yd.android_brand_mvp.model.BaseContentRsp;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface LeaveView extends BaseView {
    void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp);

    void GetAskLeaveRecordBandRspFail(String str);

    void addLeaveSuccess(BaseContentRsp baseContentRsp);

    void delectFail(String str);

    void delectSuccess(BaseContentRsp baseContentRsp);

    void getApproverInfoSuccess(ApproverInfoRsp approverInfoRsp);

    void getApproverListSuccess(ApproverListRsp approverListRsp);

    void getSuccessFail(String str);
}
