package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.insetVersionUpdatedSchoolRsp;
import com.yd.android_brand_mvp.model.manageListRsp;
import com.yd.android_brand_mvp.model.queryClassificListRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface SettingView extends BaseView {
    void ManageListFail(String str);

    void ManageListSuccess(manageListRsp managelistrsp);

    void NewestVersionFail(String str);

    void NewestVersionSuccess(getNewestVersionRsp getnewestversionrsp);

    void insetVersionUpdatedSchoolFail(String str);

    void insetVersionUpdatedSchoolRsp(insetVersionUpdatedSchoolRsp insetversionupdatedschoolrsp);

    void queryClassificListFail(String str);

    void queryClassificListRsp(queryClassificListRsp queryclassificlistrsp);
}
