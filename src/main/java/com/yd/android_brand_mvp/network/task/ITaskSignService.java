package com.yd.android_brand_mvp.network.task;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.task.AddressBookBean;
import com.yd.android_brand_mvp.model.task.MyTaskListBean;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.model.task.TaskDetailBean;
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

/* JADX INFO: compiled from: ITaskSignService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/network/task/ITaskSignService;", "", "getAddressBook", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/task/AddressBookBean;", CommentsHomeFragment.TYPE_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAddTask", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeleteTask", "requestMyTaskList", "Lcom/yd/android_brand_mvp/model/task/MyTaskListBean;", "requestSignTask", "requestTaskDetail", "Lcom/yd/android_brand_mvp/model/task/TaskDetailBean;", "requestTaskList", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "requestUpdateTask", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ITaskSignService {
    @GET("/cloud/address/book/student")
    Object getAddressBook(@Query(CommentsHomeFragment.TYPE_ID) String str, Continuation<? super BaseResponse<List<AddressBookBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/app/add")
    Object requestAddTask(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/app/delete")
    Object requestDeleteTask(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/brand/list")
    Object requestMyTaskList(@Body RequestBody requestBody, Continuation<? super BaseResponse<MyTaskListBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/brand/sign")
    Object requestSignTask(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/brand/get")
    Object requestTaskDetail(@Body RequestBody requestBody, Continuation<? super BaseResponse<TaskDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/brand/brandBillBoard")
    Object requestTaskList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<MyTaskListItem>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/attendanceSignTask/app/update")
    Object requestUpdateTask(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);
}
