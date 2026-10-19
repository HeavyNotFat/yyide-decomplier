package com.yd.android_brand_mvp.presenter;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.TeacherToSettingCardView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class TeacherToSettingPresenter extends BasePresenter<TeacherToSettingCardView> {
    public TeacherToSettingPresenter(TeacherToSettingCardView teacherToSettingCardView) {
        attachView(teacherToSettingCardView);
    }

    public void selectTeacherByClassesId(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("teacherId", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("icCardNo", str2);
        }
        addSubscription(this.dingApiStores.selectNewTeacherByClassesId(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<selectTeacherByClassesIdRsp>() { // from class: com.yd.android_brand_mvp.presenter.TeacherToSettingPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp) {
                ((TeacherToSettingCardView) TeacherToSettingPresenter.this.mvpView).selectTeacherByClassesIdRspSuccess(selectteacherbyclassesidrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((TeacherToSettingCardView) TeacherToSettingPresenter.this.mvpView).selectTeacherByClassesIdRspFail(str3);
            }
        });
    }
}
