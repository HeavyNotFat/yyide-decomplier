package com.yd.android_brand_mvp.network.userspace;

import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveFormBean;
import com.yd.android_brand_mvp.model.userspace.LeaveProcessBean;
import com.yd.android_brand_mvp.model.userspace.LeaveRecordBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
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

/* JADX INFO: compiled from: IUserSpaceService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J-\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J'\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ-\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/network/userspace/IUserSpaceService;", "", "requestFormModify", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLeaveDetail", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLeaveLength", "requestLeaveRecord", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveRecordBean;", "requestLeaveTypeOption", "Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "type", "requestOldLeaveDetail", "Lcom/yd/android_brand_mvp/model/ApproverInfoRsp$DataDTO;", "requestOldRevokeLeave", "requestRepairForm", "Lcom/yd/android_brand_mvp/model/userspace/LeaveFormBean;", "formKey", "requestRepairList", "requestRevokeLeave", "requestStudentLeaveForm", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestStudentLeaveProcess", "Lcom/yd/android_brand_mvp/model/userspace/LeaveProcessBean;", "requestSubmitStudentLeave", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IUserSpaceService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/v2/proc/updateApprovalProc")
    Object requestFormModify(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/userAppr/v2/getInfo")
    Object requestLeaveDetail(@Query("id") String str, Continuation<? super BaseResponse<LeaveDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/actLeaveVacation/calculateLeaveDays")
    Object requestLeaveLength(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/v2/proc/pageTask")
    Object requestLeaveRecord(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<LeaveRecordBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/actLeaveVacation/list")
    Object requestLeaveTypeOption(@Query("type") String str, Continuation<? super BaseResponse<List<LeaveTypeBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/app/userAppr/getInfo")
    Object requestOldLeaveDetail(@Query("id") String str, Continuation<? super BaseResponse<ApproverInfoRsp.DataDTO>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/app/procAppr/deleteInstance")
    Object requestOldRevokeLeave(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/formProcessTemplates/getByKey")
    Object requestRepairForm(@Query("formKey") String str, Continuation<? super BaseResponse<LeaveFormBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/userAppr/pageDeviceAppr")
    Object requestRepairList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<LeaveRecordBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/v2/proc/deleteInstance")
    Object requestRevokeLeave(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/formProcessTemplates/getDefaultStudentLeave")
    Object requestStudentLeaveForm(Continuation<? super BaseResponse<LeaveFormBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/v2/proc/getFlowElements")
    Object requestStudentLeaveProcess(@Body RequestBody requestBody, Continuation<? super BaseResponse<LeaveProcessBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/v2/proc/startInstance")
    Object requestSubmitStudentLeave(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);
}
