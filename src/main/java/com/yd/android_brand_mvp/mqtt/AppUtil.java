package com.yd.android_brand_mvp.mqtt;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.heytap.mcssdk.a.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.model.log.Device;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/AppUtil;", "", "()V", "screenShotPath", "", "getScreenShotPath", "()Ljava/lang/String;", "getAvailMemory", "getAvailableSize", "", "getCpuName", "getCpuUsed", "", "getDeviceInfo", "getDeviceRunStatusInfo", "getMemoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "context", "Landroid/content/Context;", "getNetWorkIsAvailable", "", "getScreenShotByAdb", "getTotalMemory", "getTotalSize", "runAdbCommand", "", a.k, "sampleMemory", "NetworkTypeEnum", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppUtil {
    public static final AppUtil INSTANCE = new AppUtil();
    private static final String screenShotPath = Environment.getExternalStorageDirectory().toString() + File.separator + "/screenShot.png";

    /* JADX INFO: compiled from: AppUtil.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/AppUtil$NetworkTypeEnum;", "", "(Ljava/lang/String;I)V", "Unknown", "Ethernet", "Wifi", "NotAvailable", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum NetworkTypeEnum {
        Unknown,
        Ethernet,
        Wifi,
        NotAvailable
    }

    /* JADX INFO: compiled from: AppUtil.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkUtils.NetworkType.values().length];
            try {
                iArr[NetworkUtils.NetworkType.NETWORK_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkUtils.NetworkType.NETWORK_ETHERNET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkUtils.NetworkType.NETWORK_WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AppUtil() {
    }

    public final String getScreenShotPath() {
        return screenShotPath;
    }

    public final void runAdbCommand(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        try {
            Process processExec = Runtime.getRuntime().exec("su");
            DataOutputStream dataOutputStream = new DataOutputStream(processExec.getOutputStream());
            dataOutputStream.writeBytes(command);
            dataOutputStream.flush();
            dataOutputStream.close();
            processExec.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String getScreenShotByAdb() {
        runAdbCommand("screencap -p " + screenShotPath);
        File file = new File(screenShotPath);
        if (!file.exists()) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "shotFile.absolutePath");
        return absolutePath;
    }

    public final boolean getNetWorkIsAvailable() {
        return NetworkUtils.isConnected();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    public final String getCpuName() {
        String str;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str2 = "";
            try {
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        str2 = line;
                    } else {
                        line = null;
                    }
                    if (line == null) {
                        str = "";
                        break;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArr = (String[]) new Regex(":\\s+").split(str2, 2).toArray(new String[0]);
                        String str3 = strArr[0];
                        int length = str3.length() - 1;
                        int i = 0;
                        boolean z = false;
                        while (i <= length) {
                            boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length--;
                            } else if (z2) {
                                i++;
                            } else {
                                z = true;
                            }
                        }
                        if (TextUtils.equals(str3.subSequence(i, length + 1).toString(), "Hardware")) {
                            str = strArr[1];
                            break;
                        }
                        e.printStackTrace();
                        if (str == null) {
                            return "";
                        }
                        return str;
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e = e2;
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final String getTotalMemory() {
        List listEmptyList;
        long jIntValue = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String line = bufferedReader.readLine();
            Intrinsics.checkNotNullExpressionValue(line, "localBufferedReader.readLine()");
            List<String> listSplit = new Regex("\\s+").split(line, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            for (String str : strArr) {
                Log.i(line, str + '\t');
            }
            jIntValue = ((long) Integer.valueOf(strArr[1]).intValue()) * ((long) 1024);
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return Formatter.formatFileSize(Utils.getApp(), jIntValue);
    }

    public final String getAvailMemory() {
        Object systemService = Utils.getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(Utils.getApp(), memoryInfo.availMem);
    }

    private final String sampleMemory() {
        double d;
        int totalPss;
        ActivityManager activityManager = (ActivityManager) Utils.getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        try {
            Intrinsics.checkNotNull(activityManager);
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            Intrinsics.checkNotNullExpressionValue(processMemoryInfo, "activityManager!!.getPro…ArrayOf(Process.myPid()))");
            d = (!(true ^ (processMemoryInfo.length == 0)) || (totalPss = processMemoryInfo[0].getTotalPss()) < 0) ? 0.0d : ((double) totalPss) / 1024.0d;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf((int) d);
    }

    public final long getTotalSize() {
        Context applicationContext = Utils.getApp().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApp().applicationContext");
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(applicationContext);
        return ((memoryInfo != null ? memoryInfo.totalMem : 0L) * 1) / ((long) 1048576);
    }

    public final ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public final long getAvailableSize() {
        Context applicationContext = Utils.getApp().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApp().applicationContext");
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(applicationContext);
        return ((memoryInfo != null ? memoryInfo.availMem : 0L) * 1) / ((long) 1048576);
    }

    public final float getCpuUsed() {
        List listEmptyList;
        List listEmptyList2;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            String load = randomAccessFile.readLine();
            Intrinsics.checkNotNullExpressionValue(load, "load");
            List<String> listSplit = new Regex(" ").split(load, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            long j = Long.parseLong(strArr[5]);
            long j2 = Long.parseLong(strArr[2]) + Long.parseLong(strArr[3]) + Long.parseLong(strArr[4]) + Long.parseLong(strArr[6]) + Long.parseLong(strArr[7]) + Long.parseLong(strArr[8]);
            try {
                Thread.sleep(360L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            randomAccessFile.seek(0L);
            String load2 = randomAccessFile.readLine();
            randomAccessFile.close();
            Intrinsics.checkNotNullExpressionValue(load2, "load");
            List<String> listSplit2 = new Regex(" ").split(load2, 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        if (!(listIterator2.previous().length() == 0)) {
                            listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                        break;
                    }
                }
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
                break;
            }
            String[] strArr2 = (String[]) listEmptyList2.toArray(new String[0]);
            long j3 = Long.parseLong(strArr2[5]);
            long j4 = Long.parseLong(strArr2[2]) + Long.parseLong(strArr2[3]) + Long.parseLong(strArr2[4]) + Long.parseLong(strArr2[6]) + Long.parseLong(strArr2[7]) + Long.parseLong(strArr2[8]);
            return (j4 - j2) / ((j4 + j3) - (j2 + j));
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public final String getDeviceRunStatusInfo() {
        DeviceRunInfoBean deviceRunInfoBean = new DeviceRunInfoBean(null, null, null, null, null, 31, null);
        SystemInformationBean systemInformationBean = new SystemInformationBean(0, null, null, null, null, null, null, 127, null);
        String mac = BaseApplication.getInstance().getMac();
        Intrinsics.checkNotNullExpressionValue(mac, "getInstance().mac");
        deviceRunInfoBean.setDeviceNo(mac);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        deviceRunInfoBean.setMsgId(StringsKt.replace$default(string, Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null));
        deviceRunInfoBean.setSemaphore("10015");
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        deviceRunInfoBean.setSchoolId(schoolId);
        systemInformationBean.setInternalMemory(getAvailableSize() + "MB");
        systemInformationBean.setCpu((int) getCpuUsed());
        systemInformationBean.setCpuName(getCpuName());
        systemInformationBean.setAppMemory(sampleMemory());
        systemInformationBean.setRunMemoryTotal(getTotalMemory() + "");
        systemInformationBean.setRunMemory(getAvailMemory() + "");
        systemInformationBean.setMemoryTotal(getTotalSize() + "MB");
        deviceRunInfoBean.setMessageContent(systemInformationBean);
        String json = GsonUtils.toJson(deviceRunInfoBean);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(mDeviceInfoBean)");
        return json;
    }

    public final String getDeviceInfo() {
        String str;
        NetworkUtils.NetworkType networkType = NetworkUtils.getNetworkType();
        int i = networkType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[networkType.ordinal()];
        if (i == 1 || i == 2) {
            str = "有线";
        } else {
            str = i != 3 ? "无网络" : "WIFI";
        }
        Device device = new Device(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
        device.setDeviceNo(BaseApplication.getInstance().getMac());
        device.setAppVersion(AppUtils.getAppVersionName());
        device.setMainBoard(BrandConfig.INSTANCE.getBrandName());
        device.setNetworkStatus(str);
        device.setDeviceName("班牌");
        device.setDeviceType("2");
        device.setWeakNetwork("");
        device.setVersionType(BaseConstant.isCustomMade ? "1" : "2");
        device.setSysVersion(Build.VERSION.RELEASE);
        device.setModel(DeviceUtils.getModel());
        device.setFirmwareVersion(BrandConfig.INSTANCE.getFirmwareVersion());
        device.setIp(NetworkUtils.getIPAddress(true));
        DeviceInfoBean deviceInfoBean = new DeviceInfoBean(null, null, null, null, null, null, 63, null);
        String mac = BaseApplication.getInstance().getMac();
        Intrinsics.checkNotNullExpressionValue(mac, "getInstance().mac");
        deviceInfoBean.setDeviceNo(mac);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        deviceInfoBean.setMsgId(StringsKt.replace$default(string, Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null));
        deviceInfoBean.setSemaphore("10014");
        deviceInfoBean.setDeviceType("2");
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        deviceInfoBean.setSchoolId(schoolId);
        deviceInfoBean.setMessageContent(GsonUtils.toJson(device));
        String json = GsonUtils.toJson(deviceInfoBean);
        LogUtils.i("应用信息 ：" + json);
        Intrinsics.checkNotNullExpressionValue(json, "json");
        return json;
    }
}
