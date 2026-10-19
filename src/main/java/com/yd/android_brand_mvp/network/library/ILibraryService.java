package com.yd.android_brand_mvp.network.library;

import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.model.library.LibraryCollectBookSituationBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.model.library.LibraryTypeBean;
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

/* JADX INFO: compiled from: ILibraryService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\n0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ'\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\n0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ'\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/network/library/ILibraryService;", "", "requestHotList", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLibraryBookSituation", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "Lcom/yd/android_brand_mvp/model/library/LibraryCollectBookSituationBean;", "requestLibraryClassifyList", "Lcom/yd/android_brand_mvp/model/library/LibraryTypeBean;", "requestLibraryList", "Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "requestLibraryNewList", "requestLibrarySearch", "requestLibraryTypeList", "libraryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ILibraryService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/rfid/class-board/rank/hot-circulation-rank")
    Object requestHotList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<LibraryItemBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/rfid/class-board/opac/bookDetail")
    Object requestLibraryBookSituation(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<LibraryCollectBookSituationBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/rfid/class-board/category/list")
    Object requestLibraryClassifyList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<LibraryTypeBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/rfid/hm-board/library/list")
    Object requestLibraryList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<LibraryBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/rfid/class-board/rank/new-book-recommend")
    Object requestLibraryNewList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<LibraryItemBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/rfid/class-board/opac/book")
    Object requestLibrarySearch(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<LibraryItemBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/rfid/class-board/opac/itemTypeList")
    Object requestLibraryTypeList(@Query("libraryId") String str, Continuation<? super BaseResponse<List<LibraryTypeBean>>> continuation);
}
