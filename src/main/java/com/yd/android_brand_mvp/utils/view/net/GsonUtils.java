package com.yd.android_brand_mvp.utils.view.net;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class GsonUtils {
    private static final String TAG = GsonUtils.class.getSimpleName();
    private static final Gson TO_GSON = createGson(true).create();
    private static final Gson FROM_GSON = createGson(true).create();
    private static final Gson INDENT_GSON = createGson(true).setPrettyPrinting().create();

    public static String toGson(Map<String, String> map) {
        String jSONString = JSON.toJSONString((Object) map, true);
        map.clear();
        map.put("encryptionStr", RsaUtil.encrypt(jSONString));
        return JSON.toJSONString((Object) map, true);
    }

    public static String toJson(Object obj) {
        return toJson(obj, TO_GSON);
    }

    public static String toJson(Object obj, Gson gson) {
        if (gson == null) {
            return null;
        }
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(String str, Class cls) {
        return (T) fromJson(str, cls, FROM_GSON);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) fromJson(str, type, FROM_GSON);
    }

    public static <T> T fromJson(String str, Type type, Gson gson) {
        if (gson == null) {
            return null;
        }
        try {
            return (T) gson.fromJson(str, type);
        } catch (Exception unused) {
            Log.e(TAG, "fromJson");
            return null;
        }
    }

    public static boolean isJSON(String str) {
        try {
            JsonElement jsonElement = new JsonParser().parse(str);
            return jsonElement != null && jsonElement.isJsonObject();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String toJsonIndent(String str) {
        return toJsonIndent(str, INDENT_GSON);
    }

    public static String toJsonIndent(String str, Gson gson) {
        if (gson == null) {
            return null;
        }
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(true);
            return gson.toJson(new JsonParser().parse(jsonReader));
        } catch (Exception e) {
            Log.e(TAG, "toJsonIndent" + e.getMessage());
            return null;
        }
    }

    public static String toJsonIndent(Object obj) {
        return toJsonIndent(obj, INDENT_GSON);
    }

    public static String toJsonIndent(Object obj, Gson gson) {
        if (gson == null) {
            return null;
        }
        try {
            return gson.toJson(obj);
        } catch (Exception unused) {
            Log.e(TAG, "toJsonIndent");
            return null;
        }
    }

    public static GsonBuilder createGson(boolean z) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (z) {
            gsonBuilder.serializeNulls();
        }
        return gsonBuilder;
    }

    public static GsonBuilder createGsonExcludeFields(GsonBuilder gsonBuilder, int... iArr) {
        if (gsonBuilder != null) {
            return gsonBuilder.excludeFieldsWithModifiers(iArr);
        }
        return null;
    }

    public static Type getArrayType(Type type) {
        return TypeToken.get(type).getType();
    }

    public static Type getListType(Type type) {
        return TypeToken.get(type).getType();
    }

    public static Type getSetType(Type type) {
        return TypeToken.get(type).getType();
    }
}
