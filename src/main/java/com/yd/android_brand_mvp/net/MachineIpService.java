package com.yd.android_brand_mvp.net;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MachineIpService {
    public static Map<String, String> getVideo(String str, String str2, String str3, String str4, String str5, Handler handler) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put(CommentsHomeFragment.TYPE_CLASSESID, (Object) str2);
            jSONObject.put("kind", (Object) str3);
            jSONObject.put("type", (Object) str5);
            String strString = HttpUtils.post("https://api.yyide.com/brand/brand/album/list", jSONObject + "").body().string();
            Message message = new Message();
            message.obj = strString;
            handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, String> getVideo2(String str, String str2, String str3, String str4, Handler handler) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("kind", (Object) str2);
            jSONObject.put("type", (Object) str4);
            String strString = HttpUtils.post("https://api.yyide.com/brand/brand/album/list", jSONObject + "").body().string();
            Message message = new Message();
            message.obj = strString;
            handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void getPhone(String str, String str2, String str3, String str4, Handler handler) {
        JSONObject jSONObject = new JSONObject();
        new HashMap();
        try {
            if ("1".equals(str2)) {
                jSONObject.put(CommentsHomeFragment.TYPE_CLASSESID, (Object) str);
            }
            jSONObject.put("kind", (Object) str2);
            Log.i("stringTemp3", JSON.toJSONString(jSONObject) + "");
            String strString = HttpUtils.post("https://api.yyide.com/brand/brand/album/listDetail", jSONObject + "").body().string();
            Log.i("stringTemp", strString);
            Message message = new Message();
            message.obj = strString;
            handler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
