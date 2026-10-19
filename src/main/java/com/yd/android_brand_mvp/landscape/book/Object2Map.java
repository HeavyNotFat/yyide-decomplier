package com.yd.android_brand_mvp.landscape.book;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Object2Map {
    public static Map<String, String> object2Map(Object obj) {
        Set<Map.Entry<String, Object>> setEntrySet = ((JSONObject) JSON.toJSON(obj)).entrySet();
        HashMap map = new HashMap();
        for (Map.Entry<String, Object> entry : setEntrySet) {
            map.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }
}
