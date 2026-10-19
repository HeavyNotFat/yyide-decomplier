package com.yd.android_brand_mvp.presenter;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.AttencesView;
import java.util.HashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class AttcencesPresenter extends BasePresenter<AttencesView> {
    public AttcencesPresenter(AttencesView attencesView) {
        attachView(attencesView);
    }

    public void getAttencelist(String str) {
        HashMap map = new HashMap();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = RuleUtils.getInstance().isTable();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsSiteTable = RuleUtils.getInstance().isSiteTable();
        List<String> attendanceIds = RuleUtils.getInstance().getAttendanceIds();
        if (timetableListDTOIsTable != null && !TextUtils.isEmpty(timetableListDTOIsTable.id)) {
            map.put("timetableId", timetableListDTOIsTable.id);
        }
        if (attendanceIds != null) {
            map.put("attendanceTimeIds", attendanceIds);
        }
        if (timetableListDTOIsSiteTable != null) {
            map.put("siteTimetableId", timetableListDTOIsSiteTable.id);
        }
        addSubscription(this.dingApiStores.queryBrandAttendanceByAttendanceTimeId(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<AttenceNewListBean>() { // from class: com.yd.android_brand_mvp.presenter.AttcencesPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttenceNewListBean attenceNewListBean) {
                ((AttencesView) AttcencesPresenter.this.mvpView).getAttenceNewListSuccess(attenceNewListBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((AttencesView) AttcencesPresenter.this.mvpView).getAttenceListSuccessFail(str2);
            }
        });
    }

    public void getAttenceTodayList(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("attendanceTimeId", str);
        map.put("attendanceId", str2);
        map.put("type", str3);
        addSubscription(this.dingApiStores.listToDayDetail(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<AttanceTodatDetailsRsp>() { // from class: com.yd.android_brand_mvp.presenter.AttcencesPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttanceTodatDetailsRsp attanceTodatDetailsRsp) {
                ((AttencesView) AttcencesPresenter.this.mvpView).getToadyListSuccess(attanceTodatDetailsRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((AttencesView) AttcencesPresenter.this.mvpView).getToadyAttenceListFails(str4);
            }
        });
    }

    public void getTodayTable(String str) {
        addSubscription(this.dingApiStores.getAttenceKB(str), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.AttcencesPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((AttencesView) AttcencesPresenter.this.mvpView).getToadyAttenceListSuccess(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((AttencesView) AttcencesPresenter.this.mvpView).getToadyAttenceListFails(str2);
            }
        });
    }
}
