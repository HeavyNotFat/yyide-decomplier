package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface UserTableView extends BaseView {
    void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp);

    void GetAskLeaveRecordBandRspFail(String str);

    void UserTableData(UserTableRsp userTableRsp);

    void UserTableDataFail(String str);

    void getCDKBData(KBRsp2 kBRsp2);

    void getUserSigByUserId(getUserSigByUserIdRsp getusersigbyuseridrsp);

    void getUserSigByUserIdFail(String str);
}
