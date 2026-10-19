package com.yd.android_brand_mvp.net;

import com.yd.android_brand_mvp.model.GetSiteByUserNameRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.LeaveCommitRsp;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.model.listSwkRsp;
import com.yd.android_brand_mvp.model.saveSwkRsp;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
public interface LocalApiStores {
    @POST("/leave-server/cloud-leave/student/addStudentLeaveByStudentUserId")
    Observable<LeaveCommitRsp> LeaveCommit(@Body RequestBody requestBody);

    @POST("/cloud/app/timetable/getWeekTime")
    Observable<KBRsp2> getCDKB(@Body RequestBody requestBody);

    @POST("/backstage/cloud-backstage/kf/application/getNewestVersion")
    Observable<getNewestVersionRsp> getNewestVersion(@Body RequestBody requestBody);

    @POST("/brand/class-brand-management/app/loginCheck/getSiteByUserName")
    Observable<GetSiteByUserNameRsp> getSiteByUserName(@Query("equipmentSerialNumber") String str);

    @POST("/management/cloud-system/im/getUserSigByUserId")
    Observable<getUserSigByUserIdRsp> getUserSigByUserId(@Body RequestBody requestBody);

    @POST("/api/lock/listSwk.html")
    Observable<listSwkRsp> listSwk(@Body RequestBody requestBody);

    @POST("/api/lock/saveSwk")
    Observable<saveSwkRsp> saveSwk(@Body RequestBody requestBody);
}
