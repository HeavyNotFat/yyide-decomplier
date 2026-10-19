package com.yd.android_brand_mvp.utils;

import android.util.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.heytap.mcssdk.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: PingUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004J \u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/utils/PingUtils;", "", "()V", "ipRegex", "", "createPingCommand", "map", "Landroid/util/ArrayMap;", "domain", "createSimplePingCommand", "count", "", "timeout", "getAvgRTT", "url", "getDomain", "getIPFromUrl", "getMaxRTT", "getMdevRTT", "getMinRTT", "getPacketLoss", "getPacketLossFloat", "", "isMatch", "", TypedValues.Custom.S_STRING, "ping", a.k, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PingUtils {
    public static final PingUtils INSTANCE = new PingUtils();
    public static final String ipRegex = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";

    private PingUtils() {
    }

    public final String getIPFromUrl(String url) throws Throwable {
        Intrinsics.checkNotNullParameter(url, "url");
        String domain = getDomain(url);
        if (domain == null) {
            return null;
        }
        if (isMatch(domain)) {
            return domain;
        }
        String strPing = ping(createSimplePingCommand(1, 100, domain));
        if (strPing != null) {
            try {
                String strSubstring = strPing.substring(StringsKt.indexOf$default((CharSequence) strPing, "from", 0, false, 6, (Object) null) + 5);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                String strSubstring2 = strSubstring.substring(0, StringsKt.indexOf$default((CharSequence) strSubstring, "icmp_seq", 0, false, 6, (Object) null) - 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final int getMinRTT(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getMinRTT(url, 1, 100);
    }

    public final int getAvgRTT(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getAvgRTT(url, 1, 100);
    }

    public final int getMaxRTT(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getMaxRTT(url, 1, 100);
    }

    public final int getMdevRTT(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getMdevRTT(url, 1, 100);
    }

    public final int getMinRTT(String url, int count, int timeout) {
        String strPing;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(url, "url");
        String domain = getDomain(url);
        if (domain != null && (strPing = ping(createSimplePingCommand(count, timeout, domain))) != null) {
            try {
                String strSubstring = strPing.substring(StringsKt.indexOf$default((CharSequence) strPing, "min/avg/max/mdev", 0, false, 6, (Object) null) + 19);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(strSubstring, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Float fValueOf = Float.valueOf(((String[]) listEmptyList.toArray(new String[0]))[0]);
                Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(temps[0])");
                return Math.round(fValueOf.floatValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public final int getAvgRTT(String url, int count, int timeout) {
        String strPing;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(url, "url");
        String domain = getDomain(url);
        if (domain != null && (strPing = ping(createSimplePingCommand(count, timeout, domain))) != null) {
            try {
                String strSubstring = strPing.substring(StringsKt.indexOf$default((CharSequence) strPing, "min/avg/max/mdev", 0, false, 6, (Object) null) + 19);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(strSubstring, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Float fValueOf = Float.valueOf(((String[]) listEmptyList.toArray(new String[0]))[1]);
                Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(temps[1])");
                return Math.round(fValueOf.floatValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public final int getMaxRTT(String url, int count, int timeout) {
        String strPing;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(url, "url");
        String domain = getDomain(url);
        if (domain != null && (strPing = ping(createSimplePingCommand(count, timeout, domain))) != null) {
            try {
                String strSubstring = strPing.substring(StringsKt.indexOf$default((CharSequence) strPing, "min/avg/max/mdev", 0, false, 6, (Object) null) + 19);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(strSubstring, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Float fValueOf = Float.valueOf(((String[]) listEmptyList.toArray(new String[0]))[2]);
                Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(temps[2])");
                return Math.round(fValueOf.floatValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public final int getMdevRTT(String url, int count, int timeout) {
        String strPing;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(url, "url");
        String domain = getDomain(url);
        if (domain != null && (strPing = ping(createSimplePingCommand(count, timeout, domain))) != null) {
            try {
                String strSubstring = strPing.substring(StringsKt.indexOf$default((CharSequence) strPing, "min/avg/max/mdev", 0, false, 6, (Object) null) + 19);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(strSubstring, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Float fValueOf = Float.valueOf(StringsKt.replace$default(((String[]) listEmptyList.toArray(new String[0]))[3], " ms", "", false, 4, (Object) null));
                Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(temps[3].replace(\" ms\", \"\"))");
                return Math.round(fValueOf.floatValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public final float getPacketLossFloat(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String packetLoss = getPacketLoss(url);
        if (packetLoss == null) {
            return -1.0f;
        }
        try {
            Float fValueOf = Float.valueOf(StringsKt.replace$default(packetLoss, "%", "", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(packetLossInfo.replace(\"%\", \"\"))");
            return fValueOf.floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public final float getPacketLossFloat(String url, int count, int timeout) {
        Intrinsics.checkNotNullParameter(url, "url");
        String packetLoss = getPacketLoss(url, count, timeout);
        if (packetLoss == null) {
            return -1.0f;
        }
        try {
            Float fValueOf = Float.valueOf(StringsKt.replace$default(packetLoss, "%", "", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(packetLossInfo.replace(\"%\", \"\"))");
            return fValueOf.floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public final String getPacketLoss(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getPacketLoss(url, 1, 100);
    }

    public final String getPacketLoss(String url, int count, int timeout) {
        String strPing;
        Intrinsics.checkNotNullParameter(url, "url");
        String domain = getDomain(url);
        if (domain != null && (strPing = ping(createSimplePingCommand(count, timeout, domain))) != null) {
            try {
                String strSubstring = strPing.substring(StringsKt.indexOf$default((CharSequence) strPing, "received,", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                String strSubstring2 = strSubstring.substring(9, StringsKt.indexOf$default((CharSequence) strSubstring, "packet", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private final String getDomain(String url) {
        try {
            return URI.create(url).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean isMatch(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return Pattern.matches(ipRegex, string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.String] */
    private final String ping(String command) throws Throwable {
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(command);
            try {
                try {
                    InputStream inputStream = processExec.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    while (true) {
                        ?? line = bufferedReader.readLine();
                        objectRef.element = line;
                        if (line == 0) {
                            break;
                        }
                        sb.append((String) objectRef.element);
                        sb.append("\n");
                        th = th;
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        throw th;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    String string = sb.toString();
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                if (processExec != null) {
                    processExec.destroy();
                }
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            processExec = null;
        } catch (Throwable th3) {
            th = th3;
            processExec = null;
        }
    }

    private final String createSimplePingCommand(int count, int timeout, String domain) {
        return "/system/bin/ping -c " + count + " -w " + timeout + ' ' + domain;
    }

    private final String createPingCommand(ArrayMap<String, String> map, String domain) {
        int size = map.size();
        String str = "/system/bin/ping";
        for (int i = 0; i < size; i++) {
            str = str + ' ' + map.keyAt(i) + ' ' + map.get(map.keyAt(i));
        }
        return str + ' ' + domain;
    }
}
