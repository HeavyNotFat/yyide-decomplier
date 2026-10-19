package com.yd.android_brand_mvp.utils;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.tencent.mmkv.MMKV;
import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MMKVUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0086\b¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"2\u0006\u0010\r\u001a\u00020\u000eJ'\u0010#\u001a\u00020\f\"\b\b\u0000\u0010\u001d*\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u0001H\u001d¢\u0006\u0002\u0010%J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u0001J\u001e\u0010#\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"Lcom/yd/android_brand_mvp/utils/MMKVUtils;", "", "()V", "mmkv", "Lcom/tencent/mmkv/MMKV;", "getMmkv", "()Lcom/tencent/mmkv/MMKV;", "setMmkv", "(Lcom/tencent/mmkv/MMKV;)V", "clearAll", "", "getBoolean", "", "key", "", "getByteArray", "", "getDouble", "", "(Ljava/lang/String;)Ljava/lang/Double;", "getFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "getInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "(Ljava/lang/String;)Landroid/os/Parcelable;", "getString", "getStringSet", "", "put", RestUrlWrapper.FIELD_T, "(Ljava/lang/String;Landroid/os/Parcelable;)Z", "value", "sets", "removeKey", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MMKVUtils {
    public static final MMKVUtils INSTANCE = new MMKVUtils();
    private static MMKV mmkv = MMKV.defaultMMKV();

    private MMKVUtils() {
    }

    public final MMKV getMmkv() {
        return mmkv;
    }

    public final void setMmkv(MMKV mmkv2) {
        mmkv = mmkv2;
    }

    public final boolean put(String key, Object value) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(key, "key");
        if (value instanceof String) {
            MMKV mmkv2 = mmkv;
            boolValueOf = mmkv2 != null ? Boolean.valueOf(mmkv2.encode(key, (String) value)) : null;
            Intrinsics.checkNotNull(boolValueOf);
            return boolValueOf.booleanValue();
        }
        if (value instanceof Float) {
            MMKV mmkv3 = mmkv;
            boolValueOf = mmkv3 != null ? Boolean.valueOf(mmkv3.encode(key, ((Number) value).floatValue())) : null;
            Intrinsics.checkNotNull(boolValueOf);
            return boolValueOf.booleanValue();
        }
        if (value instanceof Boolean) {
            MMKV mmkv4 = mmkv;
            boolValueOf = mmkv4 != null ? Boolean.valueOf(mmkv4.encode(key, ((Boolean) value).booleanValue())) : null;
            Intrinsics.checkNotNull(boolValueOf);
            return boolValueOf.booleanValue();
        }
        if (value instanceof Integer) {
            MMKV mmkv5 = mmkv;
            boolValueOf = mmkv5 != null ? Boolean.valueOf(mmkv5.encode(key, ((Number) value).intValue())) : null;
            Intrinsics.checkNotNull(boolValueOf);
            return boolValueOf.booleanValue();
        }
        if (value instanceof Long) {
            MMKV mmkv6 = mmkv;
            boolValueOf = mmkv6 != null ? Boolean.valueOf(mmkv6.encode(key, ((Number) value).longValue())) : null;
            Intrinsics.checkNotNull(boolValueOf);
            return boolValueOf.booleanValue();
        }
        if (value instanceof Double) {
            MMKV mmkv7 = mmkv;
            boolValueOf = mmkv7 != null ? Boolean.valueOf(mmkv7.encode(key, ((Number) value).doubleValue())) : null;
            Intrinsics.checkNotNull(boolValueOf);
            return boolValueOf.booleanValue();
        }
        if (!(value instanceof byte[])) {
            return false;
        }
        MMKV mmkv8 = mmkv;
        boolValueOf = mmkv8 != null ? Boolean.valueOf(mmkv8.encode(key, (byte[]) value)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    public final <T extends Parcelable> boolean put(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (t == null) {
            return false;
        }
        MMKV mmkv2 = mmkv;
        Boolean boolValueOf = mmkv2 != null ? Boolean.valueOf(mmkv2.encode(key, t)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    public final boolean put(String key, Set<String> sets) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (sets == null) {
            return false;
        }
        MMKV mmkv2 = mmkv;
        Boolean boolValueOf = mmkv2 != null ? Boolean.valueOf(mmkv2.encode(key, sets)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    public final Integer getInt(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Integer.valueOf(mmkv2.decodeInt(key, 0));
        }
        return null;
    }

    public final Double getDouble(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        return mmkv2 != null ? Double.valueOf(mmkv2.decodeDouble(key, 0.0d)) : Double.valueOf(0.0d);
    }

    public final long getLong(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.decodeLong(key, 0L);
        }
        return 0L;
    }

    public final boolean getBoolean(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.decodeBool(key, false);
        }
        return false;
    }

    public final Float getFloat(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return Float.valueOf(mmkv2.decodeFloat(key, 0.0f));
        }
        return null;
    }

    public final byte[] getByteArray(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.decodeBytes(key);
        }
        return null;
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.decodeString(key, "");
        }
        return null;
    }

    public final /* synthetic */ <T extends Parcelable> T getParcelable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = getMmkv();
        if (mmkv2 == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) mmkv2.decodeParcelable(key, Parcelable.class);
    }

    public final Set<String> getStringSet(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.decodeStringSet(key, Collections.emptySet());
        }
        return null;
    }

    public final void removeKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.removeValueForKey(key);
        }
    }

    public final void clearAll() {
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.clearAll();
        }
    }
}
