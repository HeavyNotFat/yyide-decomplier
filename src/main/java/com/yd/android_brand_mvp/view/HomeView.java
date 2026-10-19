package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.AttenceUser;
import com.yd.android_brand_mvp.model.AttencelistRsp2;
import com.yd.android_brand_mvp.model.DominateDetailLevelBean;
import com.yd.android_brand_mvp.model.GeneralBean2;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.NewRemindRsp;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.model.NewWeatherListBean;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;
import com.yd.android_brand_mvp.model.SiteAttendanceBean;
import com.yd.android_brand_mvp.model.StudentCenterRsp;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.model.switchlistRsp;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface HomeView extends BaseView {
    void KBDataFail(String str);

    void NewestVersionFail(String str);

    void NewestVersionSuccess(getNewestVersionRsp getnewestversionrsp);

    void SchoolSytlFail(String str);

    void SchoolSytlSuccess(SchoolStytleRsp schoolStytleRsp);

    void StudentCenterRsp(StudentCenterRsp studentCenterRsp);

    void allStudents(AllstudentRsp allstudentRsp);

    void allStudentsFail(String str);

    void getAttendanceSuccess(GeneralBean2 generalBean2);

    void getAttendanceSuccessFail(String str);

    void getBrandLoginFails(String str);

    void getBrandLoginSuccess(NewBrandLoginRsp newBrandLoginRsp);

    void getCDKBData(KBRsp2 kBRsp2);

    void getClassKBSuccess(KBRsp2 kBRsp2);

    void getDataAttenceSuccess(AttencelistRsp2 attencelistRsp2);

    void getDataAttenceSuccessFail(String str);

    void getDataAttenceUserFail(String str);

    void getDataAttenceUserSuccess(AttenceUser attenceUser);

    void getDataSuccess(LayoutListRsp layoutListRsp);

    void getDominateLevelFail(String str);

    void getDominateLevelSuccess(BaseResponse<List<DominateDetailLevelBean>> baseResponse);

    void getFail(String str);

    void getHomeNoticeFail(String str);

    void getHomeNoticeSuccess(BaseResponse<MessageCaptionBean> baseResponse);

    void getMessageDominate(BaseResponse<List<MessageItemBean>> baseResponse);

    void getMessageDominateFail(String str);

    void getNewTokenFails(String str);

    void getNewTokenSuccess(NewLoginRsp newLoginRsp);

    void getSiteAttendanceSuccess(BaseResponse<List<SiteAttendanceBean>> baseResponse);

    void getSiteKBSuccess(KBRsp2 kBRsp2);

    void getSystemSigFail(String str);

    void getSystemSigSuccess(BaseResponse<String> baseResponse);

    void getWeatherDaySuccess(BaseResponse<NewWeatherBean> baseResponse);

    void getWeatherFail(String str);

    void getWeatherSuccess(BaseResponse<NewWeatherListBean> baseResponse);

    void getremindFail(String str);

    void getremindSuccess(NewRemindRsp newRemindRsp);

    void selectTeacherByClassesIdRspFail(String str);

    void selectTeacherByClassesIdRspSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp);

    void switchlist(switchlistRsp switchlistrsp);

    void switchlistFail(String str);

    void uploadLogFail(String str);

    void uploadLogSuccess(BaseResponse<UploadFileBean> baseResponse);
}
