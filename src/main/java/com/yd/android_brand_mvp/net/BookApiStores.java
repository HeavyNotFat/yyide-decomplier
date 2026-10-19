package com.yd.android_brand_mvp.net;

import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
public interface BookApiStores {
    public static final String API_SERVER_URL = "https://open-lcs.libsaas.com.cn/";

    @GET("opac/ctrl/{ctrlNo}")
    Observable<ctrlNoRsp> getBookMsg(@Path("ctrlNo") String str);

    @GET("opac/assets/{ctrlNo}")
    Observable<List<BookassetsRsp>> getBookMsgAssets(@Path("ctrlNo") String str);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("opac/tops/{topType}")
    Observable<List<YwBookRsp>> getTops(@Path("topType") String str, @Query("days") String str2, @Query("flag") String str3, @Query("language ") String str4, @Query("type") String str5);

    @POST("opac/search")
    Observable<SearchBookRsp> searchBook(@Body RequestBody requestBody);
}
