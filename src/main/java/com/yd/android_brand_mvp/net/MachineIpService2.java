package com.yd.android_brand_mvp.net;

import android.os.Handler;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MachineIpService2 {
    public static Map<String, String> getVideo(String str, String str2, String str3, String str4, String str5, Handler handler) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put(CommentsHomeFragment.TYPE_CLASSESID, (Object) str2);
            jSONObject.put("kind", (Object) "1");
            jSONObject.put("type", (Object) str5);
            HttpUtils2.post("https://api.yyide.com/brand/brand/album/list", JSON.toJSONString((Object) jSONObject, true), handler);
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
            HttpUtils2.post("https://api.yyide.com/brand/brand/album/list", jSONObject + "", handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void getPhone(String str, String str2, String str3, String str4, Handler handler) {
        JSONObject jSONObject = new JSONObject();
        new HashMap();
        try {
            if (!StringUtils.isEmpty(str) && !"0".equals(str) && !"2".equals(str2)) {
                jSONObject.put(CommentsHomeFragment.TYPE_CLASSESID, (Object) str);
            }
            jSONObject.put("interior", (Object) "1");
            jSONObject.put("kind", (Object) str2);
            jSONObject.put("schoolId", (Object) str3);
            jSONObject.put("type", (Object) str4);
            HttpUtils2.post("https://api.yyide.com/brand/class-brand-management/android/videoalbum/list", jSONObject + "", handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
