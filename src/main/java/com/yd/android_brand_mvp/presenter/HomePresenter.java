package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.adapter.attence.PostAttenceBean;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BasePresenter;
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
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.model.switchlistRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.HomeView;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class HomePresenter extends BasePresenter<HomeView> {
    public HomePresenter(HomeView homeView) {
        attachView(homeView);
    }

    public void layoutList(String str) {
        HashMap map = new HashMap();
        map.put("id", str);
        map.put("showType", Integer.valueOf(SPUtils.getInstance().getBoolean(SpData.SKIN) ? 1 : 0));
        map.put("deviceType", "2");
        addSubscription(this.dingApiStores.getNewLayoutList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<LayoutListRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(LayoutListRsp layoutListRsp) {
                ((HomeView) HomePresenter.this.mvpView).getDataSuccess(layoutListRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).getFail(str2);
            }
        });
    }

    public void getMessageDominateList() {
        HashMap map = new HashMap();
        map.put("brandId", SpData.getBrandId());
        addSubscription(this.dingApiStores.getMessageDominateScreenList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<BaseResponse<List<MessageItemBean>>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<List<MessageItemBean>> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getMessageDominate(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getMessageDominateFail(str);
            }
        });
    }

    public void getNewWeatherList() {
        addSubscription(this.dingApiStores.getNewWeatherList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) new HashMap(), true))), new ApiCallback<BaseResponse<NewWeatherListBean>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<NewWeatherListBean> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getWeatherSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getWeatherFail(str);
            }
        });
    }

    public void getNewWeather() {
        addSubscription(this.dingApiStores.getNewWeather(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) new HashMap(), true))), new ApiCallback<BaseResponse<NewWeatherBean>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<NewWeatherBean> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getWeatherDaySuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getWeatherFail(str);
            }
        });
    }

    public void SchoolStyle() {
        addSubscription(this.dingApiStores.SchoolStyle(), new ApiCallback<SchoolStytleRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.5
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(SchoolStytleRsp schoolStytleRsp) {
                ((HomeView) HomePresenter.this.mvpView).SchoolSytlSuccess(schoolStytleRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).SchoolSytlFail(str);
            }
        });
    }

    public void switchlist() {
        addSubscription(this.dingApiStores.switchNewList(SpData.getBrandId()), new ApiCallback<switchlistRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.6
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(switchlistRsp switchlistrsp) {
                ((HomeView) HomePresenter.this.mvpView).switchlist(switchlistrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).switchlistFail(str);
            }
        });
    }

    public void getNewestVersion(String str) {
        HashMap map = new HashMap();
        map.put("schoolId", str);
        map.put("versionType", Integer.valueOf(BaseConstant.isCustomMade ? 1 : 2));
        map.put("deviceType", "2");
        addSubscription(this.dingApiStores.getNewestVersion(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<getNewestVersionRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.7
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getNewestVersionRsp getnewestversionrsp) {
                ((HomeView) HomePresenter.this.mvpView).NewestVersionSuccess(getnewestversionrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).NewestVersionFail(str2);
            }
        });
    }

    public void Attencelist() {
        addSubscription(this.dingApiStores.Attendlist(BaseApplication.getInstance().getMac()), new ApiCallback<AttencelistRsp2>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.8
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttencelistRsp2 attencelistRsp2) {
                ((HomeView) HomePresenter.this.mvpView).getDataAttenceSuccess(attencelistRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getDataAttenceSuccessFail(str);
            }
        });
    }

    public void getBrandAttendanceUser(String str) {
        addSubscription(this.dingApiStores.getBrandAttendanceUser(str), new ApiCallback<AttenceUser>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.9
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttenceUser attenceUser) {
                ((HomeView) HomePresenter.this.mvpView).getDataAttenceUserSuccess(attenceUser);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).getDataAttenceUserFail(str2);
            }
        });
    }

    public void uploadLog(File file) {
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData(IDataSource.SCHEME_FILE_TAG, file.getName(), RequestBody.create(MediaType.parse(MultipartFormDataBody.CONTENT_TYPE), file));
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("path", "libBrand");
        builder.addPart(partCreateFormData);
        addSubscription(this.dingApiStores.uploadLogFile(builder.build()), new ApiCallback<BaseResponse<UploadFileBean>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.10
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<UploadFileBean> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).uploadLogSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).uploadLogFail(str);
            }
        });
    }

    public void selectTeacherByClassesId(String str, String str2) {
        HashMap map = new HashMap();
        map.put("teacherId", str);
        map.put("icCardNo", str2);
        addSubscription(this.dingApiStores.selectNewTeacherByClassesId(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<selectTeacherByClassesIdRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.11
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp) {
                ((HomeView) HomePresenter.this.mvpView).selectTeacherByClassesIdRspSuccess(selectteacherbyclassesidrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((HomeView) HomePresenter.this.mvpView).selectTeacherByClassesIdRspFail(str3);
            }
        });
    }

    public void newBrandLogin(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("loginName", str);
        map.put("no", str2);
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str3);
        String jSONString = JSON.toJSONString((Object) map, true);
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONString);
        RequestBody.create(MediaType.get("application/json; charset=utf-8"), jSONString);
        addSubscription(this.dingApiStores.getBrandObtain(requestBodyCreate), new ApiCallback<NewBrandLoginRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.12
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewBrandLoginRsp newBrandLoginRsp) {
                ((HomeView) HomePresenter.this.mvpView).getBrandLoginSuccess(newBrandLoginRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((HomeView) HomePresenter.this.mvpView).getBrandLoginFails(str4);
            }
        });
    }

    public void remind() {
        addSubscription(this.dingApiStores.newRemind(SpData.getBrandId()), new ApiCallback<NewRemindRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.13
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewRemindRsp newRemindRsp) {
                ((HomeView) HomePresenter.this.mvpView).getremindSuccess(newRemindRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                if (HomePresenter.this.mvpView != 0) {
                    ((HomeView) HomePresenter.this.mvpView).getremindFail(str);
                }
            }
        });
    }

    public void getSystemSig() {
        addSubscription(this.dingApiStores.getSystemSign(), new ApiCallback<BaseResponse<String>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.14
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<String> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getSystemSigSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getSystemSigFail(str);
            }
        });
    }

    public void attendance3(List<PostAttenceBean> list) {
        addSubscription(this.dingApiStores.brandAttendanceClock(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) list, true))), new ApiCallback<GeneralBean2>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.15
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(GeneralBean2 generalBean2) {
                ((HomeView) HomePresenter.this.mvpView).getAttendanceSuccess(generalBean2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                if (HomePresenter.this.mvpView != 0) {
                    ((HomeView) HomePresenter.this.mvpView).getAttendanceSuccessFail(str);
                }
            }
        });
    }

    public void getToken() {
        addSubscription(this.dingApiStores.newLogin(SPUtils.getInstance().getString(BaseConstant.LOGINNAME, ""), SPUtils.getInstance().getString(BaseConstant.PASSWORD, ""), "yide-cloud", "brand", "__SEC_CLIENT_SECRET_68B09CCF__", ""), new ApiCallback<NewLoginRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.16
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewLoginRsp newLoginRsp) {
                ((HomeView) HomePresenter.this.mvpView).getNewTokenSuccess(newLoginRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getNewTokenFails(str);
            }
        });
    }

    public void getCDKB(String str) {
        addSubscription(this.dingApiStores.getAttenceKB(str), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.17
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((HomeView) HomePresenter.this.mvpView).getCDKBData(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).KBDataFail(str2);
            }
        });
    }

    public void allStudents(String str) {
        HashMap map = new HashMap();
        map.put("id", str);
        map.put("type", 4);
        map.put("pageNo", 1);
        map.put("pageSize", 100);
        map.put("key", "classes");
        addSubscription(this.dingApiStores.allStudents(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<AllstudentRsp>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.18
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AllstudentRsp allstudentRsp) {
                ((HomeView) HomePresenter.this.mvpView).allStudents(allstudentRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).allStudentsFail(str2);
            }
        });
    }

    public void updateAppVersionNumber() {
        HashMap map = new HashMap();
        map.put("id", SpData.getBrandId());
        map.put("apkVersion", AppUtils.getAppVersionName());
        addSubscription(this.dingApiStores.updateApkVersion(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.19
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(Object obj) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                LogUtils.i("应用更新接口请求失败");
            }
        });
    }

    public void getKB(String str) {
        HashMap map = new HashMap();
        map.put("type", "1");
        map.put("typeId", String.valueOf(str));
        map.put("weekTime", "");
        addSubscription(this.dingApiStores.getCDKB(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.20
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((HomeView) HomePresenter.this.mvpView).getClassKBSuccess(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).KBDataFail(str2);
            }
        });
    }

    public void getSiteKB(String str) {
        HashMap map = new HashMap();
        map.put("type", "2");
        map.put("typeId", str);
        addSubscription(this.dingApiStores.getCDKB(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.21
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((HomeView) HomePresenter.this.mvpView).getSiteKBSuccess(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((HomeView) HomePresenter.this.mvpView).KBDataFail(str2);
            }
        });
    }

    public void getAttendanceSiteTimetable(List<String> list) {
        HashMap map = new HashMap();
        map.put("timetableIds", list);
        addSubscription(this.dingApiStores.getAttendanceSiteTimetable(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<BaseResponse<List<SiteAttendanceBean>>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.22
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<List<SiteAttendanceBean>> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getSiteAttendanceSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).KBDataFail(str);
            }
        });
    }

    public void requestDominateLevel() {
        addSubscription(this.dingApiStores.requestDominateScreenLevel(SpData.getBrandId()), new ApiCallback<BaseResponse<List<DominateDetailLevelBean>>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.23
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<List<DominateDetailLevelBean>> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getDominateLevelSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getDominateLevelFail("霸屏类型 = " + str);
            }
        });
    }

    public void getHomeCaptionsNoticeInfo() {
        addSubscription(this.dingApiStores.getCaptionsNoticeInfo(SpData.getSchoolId(), SpData.getBrandId()), new ApiCallback<BaseResponse<MessageCaptionBean>>() { // from class: com.yd.android_brand_mvp.presenter.HomePresenter.24
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<MessageCaptionBean> baseResponse) {
                ((HomeView) HomePresenter.this.mvpView).getHomeNoticeSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((HomeView) HomePresenter.this.mvpView).getHomeNoticeFail("首页字幕 = " + str);
            }
        });
    }
}
