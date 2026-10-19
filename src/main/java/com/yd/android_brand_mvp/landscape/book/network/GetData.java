package com.yd.android_brand_mvp.landscape.book.network;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.book.AuthcodeTwo;
import com.yd.android_brand_mvp.landscape.book.BaseBeanReq;
import com.yd.android_brand_mvp.landscape.book.MyHashMap;
import com.yd.android_brand_mvp.landscape.book.Object2Map;
import java.net.URLEncoder;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class GetData {
    public static String BIp = ":800/yide_manager/";
    public static final int PORT = 9123;
    public static final String URL_IP = "120.76.189.190";
    public static final String URL_KEY = "24ca8a8a8a8888439b926572b5fb6233fb";
    public static final String getFaceUrl = "http://120.76.189.190:8099/java-external-docking";
    public static final String minaFaceUrl = "http://120.76.189.190:8099/java-external-docking";
    public static final String url2 = "http://120.76.189.190";

    public static String url() {
        return "http://" + SPUtils.getInstance().getString(BaseConstant.NUMBER, URL_IP);
    }

    public static String imageUrl() {
        return "http://" + SPUtils.getInstance().getString(BaseConstant.NUMBER, URL_IP) + MqttTopic.TOPIC_LEVEL_SEPARATOR;
    }

    public static String YydUrl() {
        return "http://" + SPUtils.getInstance().getString(BaseConstant.NUMBER, URL_IP) + BIp;
    }

    public static String uploadUrl() {
        return "http://" + SPUtils.getInstance().getString(BaseConstant.NUMBER, URL_IP) + "/api/upload/photo.html";
    }

    public static <T> String requestUrl(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = url() + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON", str);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrlHRFace(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = "http://120.76.189.190:8099/java-external-docking" + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON2", str);
            Log.d("JSON2", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestFaceUrl(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = "http://120.76.189.190:8099/java-external-docking" + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON", str);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrlBend(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = "http://192.168.3.105:8777" + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON", str);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrlNoJM(BaseBeanReq<T> baseBeanReq, String str) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str2 = url() + baseBeanReq.myAddr() + "?" + str + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON", str2);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrlYydUrl(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = YydUrl() + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON190", str);
            Log.d("JSON190", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrl130(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = "http://192.168.3.102:8777" + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON130", str);
            Log.d("JSON130", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrl190(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = url() + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON190", str);
            Log.d("JSON190", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrl2(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = url2 + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON", str);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestUrlupdateDnamicPassword(BaseBeanReq<T> baseBeanReq) {
        try {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
            String str = url() + baseBeanReq.myAddr() + "?input=" + URLEncoder.encode(AuthcodeTwo.authcodeEncode(myHashMap.toString(), URL_KEY), "UTF-8");
            Log.d("JSON", "1111:" + str);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestMinaPostFaceUrl(BaseBeanReq<T> baseBeanReq) {
        try {
            new MyHashMap().putAll(Object2Map.object2Map(baseBeanReq));
            String str = "http://120.76.189.190:8099/java-external-docking" + baseBeanReq.myAddr();
            Log.d("JSON", str);
            Log.d("JSON", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String requestFacePostUrl(BaseBeanReq<T> baseBeanReq) {
        try {
            new MyHashMap().putAll(Object2Map.object2Map(baseBeanReq));
            String str = "http://120.76.189.190:8099/java-external-docking" + baseBeanReq.myAddr();
            Log.d("JSON2", str);
            Log.d("JSON2", JSON.toJSONString(baseBeanReq));
            return str;
        } catch (Exception unused) {
            return null;
        }
    }
}
