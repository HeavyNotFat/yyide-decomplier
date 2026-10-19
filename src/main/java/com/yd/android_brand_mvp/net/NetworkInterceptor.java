package com.yd.android_brand_mvp.net;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkInterceptor implements Interceptor {
    private static Logger LOGGER = LoggerFactory.getLogger((Class<?>) NetworkInterceptor.class);

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        String str;
        String requestBody;
        String strString;
        Response responseProceed;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = null;
        try {
            Request request = chain.request();
            String url = request.url().getUrl();
            try {
                requestBody = getRequestBody(request);
                try {
                    try {
                        responseProceed = chain.proceed(request);
                        try {
                            strString = responseProceed.body().string();
                            try {
                                strValueOf = String.valueOf(responseProceed.code());
                                Response responseBuild = responseProceed.newBuilder().body(ResponseBody.create(responseProceed.body().get$contentType(), strString)).build();
                                LOGGER.info("responseTime= {}, requestUrl= {}, params={}, responseCode= {}, result= {}", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), url, requestBody, strValueOf, strString);
                                return responseBuild;
                            } catch (Exception e) {
                                e = e;
                                str = strValueOf;
                                strValueOf = url;
                                try {
                                    LOGGER.error(e.getMessage());
                                    LOGGER.info("responseTime= {}, requestUrl= {}, params={}, responseCode= {}, result= {}", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), strValueOf, requestBody, str, strString);
                                    return responseProceed;
                                } catch (Throwable th) {
                                    th = th;
                                    LOGGER.info("responseTime= {}, requestUrl= {}, params={}, responseCode= {}, result= {}", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), strValueOf, requestBody, str, strString);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                str = strValueOf;
                                strValueOf = url;
                                LOGGER.info("responseTime= {}, requestUrl= {}, params={}, responseCode= {}, result= {}", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), strValueOf, requestBody, str, strString);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = null;
                            strString = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = null;
                        responseProceed = null;
                        strString = responseProceed;
                        strValueOf = url;
                        LOGGER.error(e.getMessage());
                        LOGGER.info("responseTime= {}, requestUrl= {}, params={}, responseCode= {}, result= {}", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), strValueOf, requestBody, str, strString);
                        return responseProceed;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = null;
                    strString = null;
                }
            } catch (Exception e4) {
                e = e4;
                str = null;
                requestBody = null;
                responseProceed = null;
            } catch (Throwable th4) {
                th = th4;
                str = null;
                requestBody = null;
                strString = null;
            }
        } catch (Exception e5) {
            e = e5;
            str = null;
            requestBody = null;
            responseProceed = null;
            strString = null;
        } catch (Throwable th5) {
            th = th5;
            str = null;
            requestBody = null;
            strString = null;
        }
    }

    private String getRequestBody(Request request) {
        RequestBody requestBodyBody;
        if (request == null || (requestBodyBody = request.body()) == null) {
            return "";
        }
        try {
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            return buffer.readString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
