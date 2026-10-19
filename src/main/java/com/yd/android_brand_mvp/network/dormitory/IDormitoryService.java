package com.yd.android_brand_mvp.network.dormitory;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.dormitory.DormitoryDetailsBean;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEducationBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/* JADX INFO: compiled from: IDormitoryService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/network/dormitory/IDormitoryService;", "", "requestHomeDormitoryDetail", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryDetailsBean;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestHomeDormitoryEducation", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationBean;", "schoolId", CommentsHomeFragment.TYPE_CLASSESID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IDormitoryService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/brand/dormitory/dormitoryHomepage/detail")
    Object requestHomeDormitoryDetail(@Query("id") String str, Continuation<? super BaseResponse<DormitoryDetailsBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/moralEducationActivityBrand/dormitory")
    Object requestHomeDormitoryEducation(@Query("schoolId") String str, @Query(CommentsHomeFragment.TYPE_CLASSESID) String str2, Continuation<? super BaseResponse<DormitoryEducationBean>> continuation);
}
