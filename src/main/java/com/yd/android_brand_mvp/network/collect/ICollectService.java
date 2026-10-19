package com.yd.android_brand_mvp.network.collect;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.collect.CollectListBean;
import com.yd.android_brand_mvp.model.collect.CollectSituationBean;
import com.yd.android_brand_mvp.model.collect.DeptListBean;
import com.yd.android_brand_mvp.model.collect.FormDetailBean;
import com.yd.android_brand_mvp.model.collect.HomeCollectBean;
import com.yd.android_brand_mvp.model.collect.StudentClassesBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ICollectService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ-\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ1\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/network/collect/ICollectService;", "", "requestCollectList", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCollectSituation", "Lcom/yd/android_brand_mvp/model/collect/CollectSituationBean;", "requestFormDetail", "Lcom/yd/android_brand_mvp/model/collect/FormDetailBean;", "requestHomeCollectList", "Lcom/yd/android_brand_mvp/model/collect/HomeCollectBean;", "requestStudentClasses", "Lcom/yd/android_brand_mvp/model/collect/StudentClassesBean;", CommentsHomeFragment.TYPE_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSubmitFormContent", "", "requestTeacherDeptList", "Lcom/yd/android_brand_mvp/model/collect/DeptListBean;", "shcoolId", "employeeId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ICollectService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/collectTableBrand/overview")
    Object requestCollectList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<CollectListBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/collectTableBrand/lookOver")
    Object requestCollectSituation(@Body RequestBody requestBody, Continuation<? super BaseResponse<CollectSituationBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/collectTableBrand/check")
    Object requestFormDetail(@Body RequestBody requestBody, Continuation<? super BaseResponse<FormDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/collectTableComponent/brand")
    Object requestHomeCollectList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<HomeCollectBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/student/selectClassByStudentId")
    Object requestStudentClasses(@Query(CommentsHomeFragment.TYPE_ID) String str, Continuation<? super BaseResponse<StudentClassesBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/collectTableBrand/write")
    Object requestSubmitFormContent(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/employee/getDeptById")
    Object requestTeacherDeptList(@Query("shcoolId") String str, @Query("employeeId") String str2, Continuation<? super BaseResponse<List<DeptListBean>>> continuation);
}
