package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.SemesterTimeRsp;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.AnnouncementView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class AnnouncementPresenter extends BasePresenter<AnnouncementView> {
    public AnnouncementPresenter(AnnouncementView announcementView) {
        attachView(announcementView);
    }

    public void getSemesterTime() {
        addSubscription(this.dingApiStores.getSemesterTime(), new ApiCallback<BaseResponse<SemesterTimeRsp>>() { // from class: com.yd.android_brand_mvp.presenter.AnnouncementPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<SemesterTimeRsp> baseResponse) {
                ((AnnouncementView) AnnouncementPresenter.this.mvpView).getSemesterTimeSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((AnnouncementView) AnnouncementPresenter.this.mvpView).getSemesterTimeFail(str);
            }
        });
    }

    public void getMyAnnouncement2(String str, int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, -7);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(5, 0);
        String str2 = simpleDateFormat.format(calendar.getTime()) + " 00:00:00";
        String str3 = simpleDateFormat2.format(calendar2.getTime());
        HashMap map = new HashMap();
        map.put("pageSize", "18");
        map.put("pageNo", Integer.valueOf(i));
        map.put("approverId", SpData.getBrandId());
        map.put("identifier", str);
        map.put("startTime", str2);
        map.put("endTime", str3);
        addSubscription(this.dingApiStores.getNewNoticeWithPag(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<getNoticeRsp>() { // from class: com.yd.android_brand_mvp.presenter.AnnouncementPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getNoticeRsp getnoticersp) {
                ((AnnouncementView) AnnouncementPresenter.this.mvpView).getNewNoticeSuccess(getnoticersp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((AnnouncementView) AnnouncementPresenter.this.mvpView).getNewNoticeFail(str4);
            }
        });
    }

    public void getAnnouncementList(String str, String str2, int i, int i2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("keyWords", str);
        map.put("pageNo", Integer.valueOf(i));
        map.put("pageSize", Integer.valueOf(i2));
        map.put("brandId", SpData.getBrandId());
        map.put("identifier", str2);
        map.put("startTime", str3);
        map.put("endTime", str4);
        addSubscription(this.dingApiStores.getNewNoticeWithPag(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<getNoticeRsp>() { // from class: com.yd.android_brand_mvp.presenter.AnnouncementPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getNoticeRsp getnoticersp) {
                ((AnnouncementView) AnnouncementPresenter.this.mvpView).getNewNoticeSuccess(getnoticersp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str5) {
                ((AnnouncementView) AnnouncementPresenter.this.mvpView).getNewNoticeFail(str5);
            }
        });
    }
}
