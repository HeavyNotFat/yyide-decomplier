package com.yd.android_brand_mvp.landscape.book.network;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.yd.android_brand_mvp.landscape.book.DecryptUtils;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes4.dex */
public class FastJsonRequest<Data> extends Request<Data> {
    private String json;
    private final TypeReference<Data> mClazz;
    private Response.Listener<Data> mListener;

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return "application/json";
    }

    public FastJsonRequest(String str, TypeReference<Data> typeReference, Response.Listener<Data> listener, Response.ErrorListener errorListener, String str2) {
        super(0, str, errorListener);
        this.mClazz = typeReference;
        this.mListener = listener;
        this.json = str2;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        return this.json.getBytes();
    }

    @Override // com.android.volley.Request
    protected Response<Data> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            Log.d("JSON", DecryptUtils.decrypt(str));
            return Response.success(JSON.parseObject(DecryptUtils.decrypt(str), this.mClazz, new Feature[0]), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        } catch (UnsupportedEncodingException e2) {
            return Response.error(new ParseError(e2));
        }
    }

    @Override // com.android.volley.Request
    protected void deliverResponse(Data data) {
        this.mListener.onResponse(data);
    }
}
