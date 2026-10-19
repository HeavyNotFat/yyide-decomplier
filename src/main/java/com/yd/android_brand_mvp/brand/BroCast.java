package com.yd.android_brand_mvp.brand;

import ZtlApi.ZtlManager;
import android.app.smdt.SmdtManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.spirit.power.SpiritPower;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.signwaymanager.SignwayManager;
import android.os.yx.YxDeviceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.android.xhapimanager.XHApiManager;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.secure.android.common.util.LogsUtil;
import com.seewo.sdk.SDKSystemHelper;
import com.seewo.sdk.model.SDKPowerControlTask;
import com.seewo.sdk.model.SDKTimeTable;
import com.seewo.sdk.model.SDKWeekDay;
import com.seewo.udsservice.PMCallback;
import com.seewo.udsservice.PowerParams;
import com.seewo.udsservice.client.plugins.device.UDSDeviceHelper;
import com.seewo.udsservice.client.plugins.system.UDSSystemHelper;
import com.xbh.sdk4.appcomm.AppCommHelper;
import com.xbh.sdk4.device.DeviceHelper;
import com.xbh.sdk4.picture.PictureHelper;
import com.xbh.sdk4.rtctimer.RtcTimerHelper;
import com.xbh.sdk4.system.SystemHelper;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.BluetoothService;
import com.yd.android_brand_mvp.BuildConfig;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.brand.device.HuiDuDevices;
import com.yd.android_brand_mvp.model.switchlistRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ZcTools;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.youngfeel.yf_rk356x_api.YF_RK356x_API_Manager;
import com.ys.rkapi.MyManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BroCast {
    private static String TAG = BroCast.class.getSimpleName();
    private static final String XW_HIDE_BAR = "com.seewo.dock.HideSlidingLayout";
    private static final String XW_SHOW_BAR = "com.seewo.dock.ShowSlidingLayout";

    public static void unInstallApk() {
    }

    public static void reboot(Context context) {
        LogUtils.i("硬件控制", "重启 reboot");
        if (BaseConstant.MY || BaseConstant.SX) {
            context.sendBroadcast(new Intent("android.intent.action.reboot"));
            return;
        }
        if (BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            ZtlManager.GetInstance().reboot(0);
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager.getInstance(context).rebootNow();
            return;
        }
        if (BaseConstant.LK || BaseConstant.XXY) {
            cmdReboot(null);
            return;
        }
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().reboot();
            return;
        }
        if (BaseConstant.LG) {
            context.sendBroadcast(new Intent("android.intent.action.reboot"));
            return;
        }
        if (BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            new SystemHelper().reboot();
            return;
        }
        if (BaseConstant.ST) {
            ((PowerManager) context.getSystemService("power")).reboot("");
            return;
        }
        if (BaseConstant.HRA) {
            context.sendBroadcast(new Intent("com.hra.reboot"));
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager.getInstance(context).reboot();
            return;
        }
        if (BaseConstant.HUIDE) {
            HuiDuDevices.INSTANCE.reboot();
            return;
        }
        if (BaseConstant.RRKJ || BrandConfig.brandModelEnum == BrandModelEnum.YF_023D) {
            new YF_RK356x_API_Manager(context).yfReboot();
            return;
        }
        if (BaseConstant.XH) {
            new XHApiManager().XHReboot();
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context).smdtReboot("reboot");
            return;
        }
        if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            new UDSDeviceHelper().reboot();
            return;
        }
        if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            new SDKSystemHelper().reboot();
            return;
        }
        if (BrandModelEnum.SEEWO_SK05 == BrandConfig.brandModelEnum) {
            SignwayManager.getInstance(context).reboot();
            return;
        }
        if (BrandModelEnum.RK3288_BOX == BrandConfig.brandModelEnum) {
            Intent intent = new Intent();
            intent.setAction(SpiritPower.ACTION_DEVICE_POWER_STATE);
            intent.putExtra(SpiritPower.EXTRA_POWER_STATE, 1);
            context.sendBroadcast(intent);
            return;
        }
        if (BrandModelEnum.RUIYIN == BrandConfig.brandModelEnum) {
            context.sendBroadcast(new Intent("com.fise.system.reboot"));
            return;
        }
        Intent intent2 = new Intent("android.yide.intent.action.reboot");
        intent2.putExtra("enable", true);
        context.sendBroadcast(intent2);
    }

    public static void openDoor(Context context) throws Throwable {
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context).smdtSetExtrnalGpioValue(1, false);
        } else if (BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            DeviceHelper deviceHelper = new DeviceHelper();
            deviceHelper.setGpioDirection(146, 1, 1);
            deviceHelper.setGpioData(146, true);
        }
    }

    public static void closeDoor() {
        if (BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            DeviceHelper deviceHelper = new DeviceHelper();
            deviceHelper.setGpioDirection(146, 1, 1);
            deviceHelper.setGpioData(146, false);
        }
    }

    public static void systemtime(Context context, String str) {
        Intent intent = new Intent("android.yide.intent.action.systemtime");
        intent.putExtra("settime", new int[]{Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(11, 13)), Integer.parseInt(str.substring(14, 16)), Integer.parseInt(str.substring(17, 19))});
        context.sendBroadcast(intent);
    }

    public static void cmdReboot(String str) {
        String str2;
        if (str == null) {
            str2 = "reboot";
        } else {
            str2 = "reboot " + str;
        }
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(str2);
            processExec.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (processExec != null) {
                processExec.destroy();
            }
        }
    }

    public static String execRootCmd(Context context, String str, boolean z) {
        String string = "";
        if (TextUtils.isEmpty(str)) {
            return "cmd null";
        }
        try {
            Process processExec = Runtime.getRuntime().exec(str.replace("adb shell", ""));
            Log.d(TAG, "process " + processExec.toString());
            string = processExec.toString();
            if (z) {
                reboot(context);
            }
        } catch (IOException e) {
            Log.d(TAG, "exception " + e.toString());
            e.printStackTrace();
        }
        return string;
    }

    public static String execCmd(String str) {
        String string = "";
        if (TextUtils.isEmpty(str)) {
            return "cmd null";
        }
        try {
            Process processExec = Runtime.getRuntime().exec(str.replace("adb shell", ""));
            Log.d(TAG, "process " + processExec.toString());
            string = processExec.toString();
            Log.d(TAG, "process content = " + string);
            return string;
        } catch (IOException e) {
            Log.d(TAG, "exception " + e.toString());
            e.printStackTrace();
            return string;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0098 A[Catch: Exception -> 0x0094, TRY_LEAVE, TryCatch #7 {Exception -> 0x0094, blocks: (B:37:0x0090, B:41:0x0098), top: B:51:0x0090 }] */
    public static boolean executeCommand(String str, String str2) throws Throwable {
        Process processExec;
        DataOutputStream dataOutputStream = null;
        try {
            processExec = Runtime.getRuntime().exec("su");
            try {
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(processExec.getOutputStream());
                    try {
                        dataOutputStream2.writeBytes(str + "\n");
                        dataOutputStream2.writeBytes(str2 + "\n");
                        dataOutputStream2.writeBytes("exit\n");
                        dataOutputStream2.flush();
                        Log.d(TAG, "process executeCommand = " + processExec);
                        processExec.waitFor();
                        try {
                            dataOutputStream2.close();
                            if (processExec != null) {
                                processExec.destroy();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        dataOutputStream = dataOutputStream2;
                        e.printStackTrace();
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return false;
                            }
                        }
                        if (processExec == null) {
                            return false;
                        }
                        processExec.destroy();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                                if (processExec != null) {
                                    processExec.destroy();
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        } else if (processExec != null) {
                            processExec.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            processExec = null;
        } catch (Throwable th3) {
            th = th3;
            processExec = null;
        }
    }

    public static void showBar(Context context) {
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().setGestureStatusBar(true);
            ZcTools.getInitialize().setStatusBar(true);
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context).smdtSetStatusBar(context, true);
            return;
        }
        if (BaseConstant.LK) {
            Intent intent = new Intent("com.xbh.action.HIDE_NAV_BAR");
            intent.putExtra("hide", false);
            context.sendBroadcast(intent);
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager yxDeviceManager = YxDeviceManager.getInstance(context);
            yxDeviceManager.setNavBarNew(true);
            yxDeviceManager.setStaBarNew(true);
            return;
        }
        if (BaseConstant.HUIDE) {
            HuiDuDevices.INSTANCE.navigationBarStatus(true);
            return;
        }
        if (BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            PictureHelper pictureHelper = new PictureHelper();
            pictureHelper.setNavBar(true);
            pictureHelper.setStatusBar(true);
            return;
        }
        if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            new UDSSystemHelper().showStatusBar();
            return;
        }
        if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            context.sendBroadcast(new Intent(XW_SHOW_BAR));
            return;
        }
        if (BrandModelEnum.SEEWO_SK05 == BrandConfig.brandModelEnum) {
            return;
        }
        if (BrandModelEnum.RUIYIN == BrandConfig.brandModelEnum) {
            Intent intent2 = new Intent("com.fise.systemui.cus");
            intent2.putExtra("systemui", 1);
            context.sendBroadcast(intent2);
        } else if (BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            ZtlManager.GetInstance().openSystemBar(true);
        } else {
            context.sendBroadcast(new Intent("android.yide.intent.action.showbar"));
            MyManager.getInstance(context).hideNavBar(false);
        }
    }

    public static void hidebar(Context context) {
        if (BaseConstant.MY) {
            Intent intent = new Intent("com.zhsd.setting.syscmd");
            intent.putExtra("cmd", "hide_nav");
            context.sendBroadcast(intent);
            return;
        }
        if (BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            ZtlManager.GetInstance().openSystemBar(false);
            return;
        }
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().setGestureStatusBar(false);
            ZcTools.getInitialize().setStatusBar(false);
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager yxDeviceManager = YxDeviceManager.getInstance(context);
            yxDeviceManager.setNavBarNew(false);
            yxDeviceManager.setStaBarNew(false);
            return;
        }
        if (BaseConstant.LK) {
            Intent intent2 = new Intent("com.xbh.action.HIDE_NAV_BAR");
            intent2.putExtra("hide", true);
            context.sendBroadcast(intent2);
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context).smdtSetStatusBar(context, false);
            return;
        }
        if (BaseConstant.LG) {
            Intent intent3 = new Intent("com.xbh.action.HIDE_STATUS_BAR");
            intent3.putExtra("hide", true);
            context.sendBroadcast(intent3);
            return;
        }
        if (BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            PictureHelper pictureHelper = new PictureHelper();
            pictureHelper.setNavBar(false);
            pictureHelper.setStatusBar(false);
            return;
        }
        if (BaseConstant.ST) {
            Intent intent4 = new Intent();
            intent4.setAction("com.outform.hidebar");
            context.sendBroadcast(intent4);
            return;
        }
        if (BaseConstant.HRA) {
            Intent intent5 = new Intent();
            intent5.setAction("com.hra.hide");
            context.sendBroadcast(intent5);
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager myManager = MyManager.getInstance(context);
            myManager.hideNavBar(true);
            myManager.setSlideShowNavBar(false);
            myManager.setSlideShowNotificationBar(false);
            if (myManager.isSlideShowNavBarOpen()) {
                Log.e(TAG, "SlideShowNavBar open.");
            } else {
                Log.e(TAG, "SlideShowNavBar close");
            }
            if (myManager.isSlideShowNotificationBarOpen()) {
                Log.e(TAG, "isSlideShowNotificationBarOpen open.");
                return;
            } else {
                Log.e(TAG, "isSlideShowNotificationBarOpen close");
                return;
            }
        }
        if (BaseConstant.HUIDE) {
            HuiDuDevices.INSTANCE.navigationBarStatus(false);
            return;
        }
        if (BrandModelEnum.YF_023D == BrandConfig.brandModelEnum) {
            return;
        }
        if (BaseConstant.RRKJ) {
            Intent intent6 = new Intent("com.android.yf_set_navigation_bar");
            intent6.putExtra("value", 0);
            context.sendBroadcast(intent6);
            return;
        }
        if (BaseConstant.XH) {
            new XHApiManager().XHShowOrHideStatusBar(false);
            XHRootCommand("setprop persist.sys.gesshownavibar 0");
            XHRootCommand("setprop persist.sys.statusBarPull 0");
            return;
        }
        if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            new UDSSystemHelper().hideStatusBar();
            return;
        }
        if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            context.sendBroadcast(new Intent(XW_HIDE_BAR));
            return;
        }
        if (BrandModelEnum.SEEWO_SK05 == BrandConfig.brandModelEnum) {
            return;
        }
        if (BrandModelEnum.RUIYIN == BrandConfig.brandModelEnum) {
            Intent intent7 = new Intent("com.fise.systemui.cus");
            intent7.putExtra("systemui", 0);
            context.sendBroadcast(intent7);
        } else {
            context.sendBroadcast(new Intent("android.yide.intent.action.hidebar"));
            if (Build.VERSION.SDK_INT >= 23) {
                MyManager myManager2 = MyManager.getInstance(context);
                myManager2.hideNavBar(true);
                myManager2.setSlideShowNavBar(false);
            }
        }
    }

    public static void clearPowerOnOffTime(Context context) {
        Log.v(TAG, "clearPowerOnOffTime");
        if (BaseConstant.MY || BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            return;
        }
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().setGestureStatusBar(false);
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager.getInstance(context).clearPowerOnOffTime();
            return;
        }
        if (BaseConstant.LK) {
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context);
            return;
        }
        if (BaseConstant.LG) {
            return;
        }
        if (BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            new PictureHelper();
            return;
        }
        if (BaseConstant.ST || BaseConstant.HRA) {
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager.getInstance(context).clearPowerOnOffTime();
            return;
        }
        if (BaseConstant.HUIDE || BaseConstant.RRKJ) {
            return;
        }
        if (BaseConstant.XH) {
            new XHApiManager();
        } else if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            new UDSDeviceHelper().clearAllPowerOffOnTask();
        } else if (Build.VERSION.SDK_INT >= 23) {
            MyManager.getInstance(context).clearPowerOnOffTime();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007b A[Catch: Exception -> 0x0081, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0081, blocks: (B:7:0x004f, B:8:0x0052, B:9:0x0055, B:29:0x007b), top: B:48:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008a A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:35:0x0085, B:37:0x008a, B:38:0x008d), top: B:42:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static void XHRootCommand(String str) throws Throwable {
        Process processExec;
        DataOutputStream dataOutputStream;
        Exception e;
        try {
            try {
                try {
                    processExec = Runtime.getRuntime().exec("su");
                    try {
                        dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                        try {
                            dataOutputStream.writeBytes(((String) str) + "\n");
                            dataOutputStream.writeBytes("exit\n");
                            dataOutputStream.flush();
                            processExec.waitFor();
                            str = new DataInputStream(processExec.getInputStream());
                            try {
                                byte[] bArr = new byte[str.available()];
                                str.read(bArr);
                                Log.d("xinhua_eric", new String(bArr));
                                dataOutputStream.close();
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (str != 0) {
                                }
                                processExec.destroy();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = 0;
                        } catch (Throwable th) {
                            th = th;
                            str = 0;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            if (str != 0) {
                                str.close();
                            }
                            processExec.destroy();
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        dataOutputStream = null;
                        e = e;
                        str = dataOutputStream;
                        e.printStackTrace();
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (str != 0) {
                            str.close();
                        }
                        processExec.destroy();
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = null;
                        th = th;
                        str = dataOutputStream;
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (str != 0) {
                            str.close();
                        }
                        processExec.destroy();
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    processExec = null;
                    dataOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    processExec = null;
                    dataOutputStream = null;
                }
                str.close();
                processExec.destroy();
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception unused2) {
        }
    }

    public static void setpoweronoff(Context context, int[] iArr, int[] iArr2, String[] strArr, String[] strArr2, switchlistRsp.DataDTO.ItemDataDTO itemDataDTO, switchlistRsp.DataDTO.ItemDataDTO itemDataDTO2) {
        LogUtils.i("setpoweronoff:timeOn:" + GsonUtils.toJson(strArr) + " timeOff:" + GsonUtils.toJson(strArr2));
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().setPowetOnOffTime(true, iArr, iArr2);
            return;
        }
        if (BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            ZtlManager.GetInstance().setPoweronOnce(iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], true);
            ZtlManager.GetInstance().setPoweroffOnce(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], true);
            return;
        }
        if (BaseConstant.LK || BaseConstant.XXY) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.setpoweronoff");
            intent.putExtra("timeon", iArr);
            intent.putExtra("timeoff", iArr2);
            intent.putExtra("enable", true);
            context.sendBroadcast(intent);
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context).smdtSetTimingSwitchMachine(SpData.getTimePoweroff(), SpData.getTimePoweron(), "1");
            return;
        }
        if (BaseConstant.LG) {
            Intent intent2 = new Intent("android.intent.action.setpoweronoff");
            intent2.putExtra("timeon", iArr);
            intent2.putExtra("timeoff", iArr2);
            intent2.putExtra("enable", true);
            context.sendBroadcast(intent2);
            return;
        }
        if (BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            RtcTimerHelper rtcTimerHelper = new RtcTimerHelper();
            rtcTimerHelper.setPowerOnTime(iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], true);
            rtcTimerHelper.setPowerOffTime(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], true);
            return;
        }
        if (BaseConstant.ST) {
            Intent intent3 = new Intent("android.56iq.intent.action.setpoweronoff");
            intent3.putExtra("timeon", iArr);
            intent3.putExtra("timeoff", iArr2);
            intent3.putExtra("enable", true);
            context.sendBroadcast(intent3);
            return;
        }
        if (BaseConstant.HRA) {
            Intent intent4 = new Intent("com.hra.setAutoShutdown");
            intent4.putExtra("key", true);
            context.sendBroadcast(intent4);
            Intent intent5 = new Intent("com.hra.setAutoBoot");
            intent5.putExtra("key", true);
            context.sendBroadcast(intent5);
            Intent intent6 = new Intent("com.hra.setShutdownDate");
            intent6.putExtra("key", getTime(strArr2));
            context.sendBroadcast(intent6);
            Intent intent7 = new Intent("com.hra.setBootDate");
            intent7.putExtra("key", getTime(strArr));
            context.sendBroadcast(intent7);
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager.getInstance(context).setPowerOnOff(iArr, iArr2);
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager.getInstance(context).setPowerOnOff(iArr, iArr2);
            return;
        }
        if (BaseConstant.SX) {
            Intent intent8 = new Intent();
            intent8.setAction("android.intent.action.gz.setpoweronoff");
            intent8.putExtra("timeon", iArr);
            intent8.putExtra("timeoff", iArr2);
            intent8.putExtra("enable", true);
            context.sendBroadcast(intent8);
            return;
        }
        if (BaseConstant.HUIDE) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getTime(iArr[3]) + Constants.COLON_SEPARATOR + getTime(iArr[4]) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getTime(iArr2[3]) + Constants.COLON_SEPARATOR + getTime(iArr2[4]));
            HuiDuDevices.INSTANCE.setPowerDay(arrayList);
            return;
        }
        if (BrandConfig.brandModelEnum == BrandModelEnum.YF_023D) {
            new YF_RK356x_API_Manager(context).yfsetOnOffTime(iArr, iArr2, true);
            return;
        }
        if (BaseConstant.RRKJ) {
            Intent intent9 = new Intent();
            intent9.setAction("com.android.yf_set_timer_swtich");
            intent9.putExtra("timeon", iArr);
            intent9.putExtra("timeoff", iArr2);
            intent9.putExtra("enable", true);
            context.sendBroadcast(intent9);
            return;
        }
        if (BaseConstant.XH) {
            XHApiManager xHApiManager = new XHApiManager();
            String str = strArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[2] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[3] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[4];
            String str2 = strArr2[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr2[1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr2[2] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr2[3] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr2[4];
            Log.i("硬件控制", "timeOn:" + str + " timeOff:" + str2);
            xHApiManager.XHSetPowerOffOnTime(str2, str, true);
            return;
        }
        if (BrandModelEnum.SEEWO_SK05 == BrandConfig.brandModelEnum) {
            SignwayManager signwayManager = SignwayManager.getInstance(context);
            signwayManager.setTimerEnable(1);
            signwayManager.setPowerOnTime(1, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4]);
            signwayManager.setPowerOffTime(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4]);
            return;
        }
        if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            UDSDeviceHelper uDSDeviceHelper = new UDSDeviceHelper();
            int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
            int iPowerOffOnTask = uDSDeviceHelper.powerOffOnTask(generatePowerParams(strArr2, "" + (TimeUtil.getIntWeek(System.currentTimeMillis()) - 1)), generatePowerParams(strArr, "" + (intWeek + 1 != 7 ? intWeek : 0)));
            LogsUtil.d(TAG, "设置定时开关机状态 = " + iPowerOffOnTask);
            return;
        }
        if (BrandModelEnum.RUIYIN == BrandConfig.brandModelEnum) {
            String str3 = strArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[2] + " " + strArr[3] + Constants.COLON_SEPARATOR + strArr[4];
            String str4 = strArr2[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr2[1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr2[2] + " " + strArr2[3] + Constants.COLON_SEPARATOR + strArr2[4];
            Intent intent10 = new Intent("com.fise.poweron.datetime");
            intent10.putExtra("powerondatetime", str3);
            context.sendBroadcast(intent10);
            Intent intent11 = new Intent("com.fise.poweroff.datetime");
            intent11.putExtra("poweroffdatetime", str4);
            context.sendBroadcast(intent11);
            return;
        }
        Intent intent12 = new Intent("android.yide.intent.action.setpoweronoff");
        intent12.putExtra("timeOn", iArr);
        intent12.putExtra("timeOff", iArr2);
        intent12.putExtra("enable", true);
        context.sendBroadcast(intent12);
    }

    private static PowerParams generatePowerParams(String[] strArr, String str) {
        int i = Integer.parseInt(strArr[0]);
        int i2 = Integer.parseInt(strArr[1]);
        int i3 = Integer.parseInt(strArr[2]);
        int i4 = Integer.parseInt(strArr[3]);
        int i5 = Integer.parseInt(strArr[4]);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < str.length(); i6++) {
            arrayList.add(Integer.valueOf(Integer.parseInt(String.valueOf(str.charAt(i6)))));
        }
        Calendar calendar = Calendar.getInstance();
        if (i <= 0) {
            i = calendar.get(1);
        }
        int i7 = i;
        if (i2 <= 0) {
            i2 = calendar.get(2);
        }
        int i8 = i2;
        if (i3 <= 0) {
            i3 = calendar.get(5);
        }
        int i9 = i3;
        if (i4 < 0) {
            i4 = calendar.get(11);
        }
        int i10 = i4;
        if (i5 < 0) {
            i5 = calendar.get(12);
        }
        int i11 = i5;
        Log.d(TAG, "year: " + i7 + " month: " + i8 + " day: " + i9 + " hour: " + i10 + " minute: " + i11 + " week: " + str);
        return new PowerParams(i7, i8, i9, i10, i11, arrayList);
    }

    public static void setWeekPower(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        LogUtils.i("powerOnTime:" + GsonUtils.toJson(iArr) + " powerOffTime:" + GsonUtils.toJson(iArr2) + " weekdays:" + GsonUtils.toJson(iArr3));
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager.getInstance(context).setPowerOnOffWithWeekly(iArr, iArr2, iArr3);
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager.getInstance(context).setPowerOnOffWithWeekly(iArr, iArr2, iArr3);
            return;
        }
        if (BaseConstant.SX) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.gz.setpoweronoff");
            intent.putExtra("timeon", iArr);
            intent.putExtra("timeoff", iArr2);
            intent.putExtra("enable", true);
            context.sendBroadcast(intent);
            return;
        }
        if (BaseConstant.HUIDE) {
            HuiDuDevices.INSTANCE.setPowerWeek(getLists(iArr, iArr2, iArr3));
            return;
        }
        if (BaseConstant.RRKJ) {
            Intent intent2 = new Intent();
            intent2.setAction("com.android.yf_set_timer_swtich");
            intent2.putExtra("timeon", iArr);
            intent2.putExtra("timeoff", iArr2);
            intent2.putExtra("enable", true);
            context.sendBroadcast(intent2);
            return;
        }
        if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < iArr3.length; i++) {
                if (iArr3[i] > 0) {
                    switch (i) {
                        case 0:
                            arrayList.add(SDKWeekDay.MON);
                            break;
                        case 1:
                            arrayList.add(SDKWeekDay.TUES);
                            break;
                        case 2:
                            arrayList.add(SDKWeekDay.WED);
                            break;
                        case 3:
                            arrayList.add(SDKWeekDay.THUR);
                            break;
                        case 4:
                            arrayList.add(SDKWeekDay.FRI);
                            break;
                        case 5:
                            arrayList.add(SDKWeekDay.SAT);
                            break;
                        case 6:
                            arrayList.add(SDKWeekDay.SUN);
                            break;
                    }
                }
            }
            LogUtils.i("硬件控制", "希沃SK03 week = " + GsonUtils.toJson(arrayList));
            SDKTimeTable sDKTimeTableNewInstance = SDKTimeTable.newInstance(iArr[0], iArr[1], arrayList);
            SDKTimeTable sDKTimeTableNewInstance2 = SDKTimeTable.newInstance(iArr2[0], iArr2[1], arrayList);
            SDKSystemHelper sDKSystemHelper = new SDKSystemHelper();
            LogUtils.i("硬件控制", "希沃SK03 taskId = " + GsonUtils.toJson(sDKSystemHelper.getAddedPowerControlTaskIDs()));
            sDKSystemHelper.clearPowerControlTask();
            sDKSystemHelper.addPowerControlTask(new SDKPowerControlTask(sDKTimeTableNewInstance, sDKTimeTableNewInstance2));
            return;
        }
        Intent intent3 = new Intent("android.intent.action.setyspoweronoff");
        intent3.putExtra("timeon", iArr);
        intent3.putExtra("timeoff", iArr2);
        intent3.putExtra("wkdays", iArr3);
        intent3.putExtra("enable", true);
        context.sendBroadcast(intent3);
    }

    private static List<List<String>> getLists(int[] iArr, int[] iArr2, int[] iArr3) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr3) {
            ArrayList arrayList2 = new ArrayList();
            if (i == 1) {
                arrayList2.add(getTime(iArr[0]) + Constants.COLON_SEPARATOR + getTime(iArr[1]) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getTime(iArr2[0]) + Constants.COLON_SEPARATOR + getTime(iArr2[1]));
            } else {
                arrayList2.add("00:00-00:00");
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private static String getTime(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return i + "";
    }

    private static long getTime(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return TimeUtil.gettime(sb.toString(), "yyyyMMddHHmm");
    }

    public static void backlight(Context context, boolean z) {
        Intent intent = new Intent("android.yide.intent.action.backlight");
        intent.putExtra("enable", z);
        context.sendBroadcast(intent);
    }

    public static void InstallAPK(Context context, File file) {
        LogUtils.i("应用安装 InstallAPK");
        if (BaseConstant.MY) {
            Intent intent = new Intent("com.zhsd.setting.syscmd");
            intent.putExtra("cmd", "appinstall");
            intent.putExtra("parm", file.getPath());
            context.sendBroadcast(intent);
            return;
        }
        if (BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            ZtlManager.GetInstance().installAppSilent(file.getAbsolutePath());
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager.getInstance(context).silentInstallApk(file.getPath(), true);
            return;
        }
        if (BaseConstant.LK || BaseConstant.XXY || BaseConstant.LG) {
            Intent intent2 = new Intent("com.android.lango.installapp");
            intent2.setAction("com.android.lango.installapp");
            intent2.putExtra("apppath", file.getAbsolutePath());
            context.sendBroadcast(intent2);
            return;
        }
        if (BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            new AppCommHelper().silentInstallAppStart(file.getAbsolutePath(), true);
            return;
        }
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().InstallApk(file.getAbsolutePath(), true);
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            try {
                SmdtManager.create(context).smdtSilentInstall(file.getAbsolutePath(), context);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (BaseConstant.JH) {
            installApk2(context, file);
            return;
        }
        if (BaseConstant.HRA) {
            Intent intent3 = new Intent();
            intent3.setAction("com.hra.Silence.install");
            intent3.putExtra("filePath", file.getPath());
            intent3.putExtra("open", true);
            context.sendBroadcast(intent3);
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager.getInstance(context).silentInstallApk(file.getAbsolutePath(), true);
            return;
        }
        if (BaseConstant.HUIDE) {
            HuiDuDevices.INSTANCE.installApk(file.getAbsolutePath());
            return;
        }
        if (BrandModelEnum.YF_023D == BrandConfig.brandModelEnum) {
            new YF_RK356x_API_Manager(context).yfslientinstallapk(file.getPath());
            return;
        }
        if (BaseConstant.RRKJ) {
            Log.d(TAG, "InstallAPK: " + file.getAbsolutePath());
            Intent intent4 = new Intent();
            intent4.setAction("com.android.yf_slient_install");
            intent4.putExtra("path", file.getAbsolutePath());
            intent4.putExtra("isboot", true);
            context.sendBroadcast(intent4);
            return;
        }
        if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            new UDSSystemHelper().pmInstall(file.getAbsolutePath(), true, new PMCallback() { // from class: com.yd.android_brand_mvp.brand.BroCast.1
                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return null;
                }

                @Override // com.seewo.udsservice.PMCallback
                public void onCallback(boolean z) {
                }
            });
            return;
        }
        if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            new SDKSystemHelper().installAPKSilent(file.getAbsolutePath());
            return;
        }
        if (BrandModelEnum.SEEWO_SK05 == BrandConfig.brandModelEnum) {
            SignwayManager.getInstance(context).silentInstallApk(file.getAbsolutePath(), BuildConfig.APPLICATION_ID);
            return;
        }
        if (BaseConstant.XH) {
            new XHApiManager().XHInstallOnBackground(file.getAbsolutePath(), BuildConfig.APPLICATION_ID);
            return;
        }
        if (BrandModelEnum.RK3288_BOX == BrandConfig.brandModelEnum) {
            AppUtils.installApp(file.getAbsolutePath());
            return;
        }
        if (BrandModelEnum.RUIYIN == BrandConfig.brandModelEnum) {
            Intent intent5 = new Intent("com.fise.silence.install.auto.start");
            intent5.putExtra("fisepath", file.getAbsolutePath());
            intent5.putExtra("packageName", AppUtils.getAppName());
            context.sendBroadcast(intent5);
            return;
        }
        installApk2(context, file);
    }

    private static void installApk2(Context context, File file) {
        if (context == null) {
            return;
        }
        String str = context.getPackageName() + ".fileProvider";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(context, str, file);
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        LogUtils.i("APK install 升级安装应用", "installApk() startActivity(intent)");
        context.startActivity(intent);
    }

    public static void exe_cmd(Context context, String str, boolean z) {
        Log.d(TAG, "cmd==" + str);
        try {
            Process processExec = Runtime.getRuntime().exec("/system/xbin/su");
            DataOutputStream dataOutputStream = new DataOutputStream(processExec.getOutputStream());
            dataOutputStream.writeBytes(str);
            dataOutputStream.flush();
            dataOutputStream.close();
            int iWaitFor = processExec.waitFor();
            Log.d(TAG, str + "==ok==" + iWaitFor);
            if (z) {
                reboot(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String str, String str2) {
        String str3;
        StringBuilder sb;
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str4 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
                Log.d(TAG, "getProperty: " + str4);
                return str4;
            } catch (Exception e) {
                e.printStackTrace();
                str3 = TAG;
                sb = new StringBuilder();
                sb.append("getProperty: ");
                sb.append(str2);
                Log.d(str3, sb.toString());
                return str2;
            }
        } catch (Throwable unused) {
            str3 = TAG;
            sb = new StringBuilder();
            sb.append("getProperty: ");
            sb.append(str2);
            Log.d(str3, sb.toString());
            return str2;
        }
    }

    public static void setLauncher(Context context) {
        exe_cmd(context, "setprop persist.sys.default_launcher com.yd.android_brand_mvp/com.yd.android_brand_mvp.WelcomeActivity", true);
    }

    public static void cancelLauncher(Context context) {
        exe_cmd(context, "setprop persist.sys.default_launcher com.android.launcher3/com.android.launcher3.Launcher", true);
    }

    public static void shutdown(Context context) {
        LogUtils.i("硬件控制", "设备关机 shutdown");
        if (BaseConstant.MY) {
            context.sendBroadcast(new Intent("android.intent.action.gotosleep"));
            return;
        }
        if (BrandModelEnum.ZTL_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.ZLT_GreenOrange == BrandConfig.brandModelEnum) {
            ZtlManager.GetInstance().shutdown();
            return;
        }
        if (BaseConstant.HS_RK3568) {
            YxDeviceManager.getInstance(context).shutDownNow();
            return;
        }
        if (BaseConstant.ZC) {
            ZcTools.getInitialize().shutDown();
            return;
        }
        if (BaseConstant.SMT || BrandModelEnum.SMT_RK3280 == BrandConfig.brandModelEnum) {
            SmdtManager.create(context).shutDown();
            return;
        }
        if (BaseConstant.LK) {
            context.sendBroadcast(new Intent("shine.intent.action.SHUTDOWN"));
            return;
        }
        if (BaseConstant.XXY || BaseConstant.SX) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.shutdown");
            context.sendBroadcast(intent);
            return;
        }
        if (BaseConstant.LG) {
            context.sendBroadcast(new Intent("android.intent.action.shutdown"));
            return;
        }
        if (BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            new SystemHelper().powerOff();
            return;
        }
        if (BaseConstant.HRA) {
            context.sendBroadcast(new Intent("com.hra.shutdown"));
            return;
        }
        if (BaseConstant.YS || BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
            MyManager.getInstance(context).shutdown();
            return;
        }
        if (BaseConstant.HUIDE) {
            HuiDuDevices.INSTANCE.shutDown();
            return;
        }
        if (BaseConstant.RRKJ) {
            new YF_RK356x_API_Manager(context).yfShutDown();
            return;
        }
        if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            new UDSDeviceHelper().powerOff();
            return;
        }
        if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            new SDKSystemHelper().powerOff();
            return;
        }
        if (BrandModelEnum.SEEWO_SK05 == BrandConfig.brandModelEnum) {
            SignwayManager.getInstance(context).shutDown();
            return;
        }
        if (BrandModelEnum.RK3288_BOX == BrandConfig.brandModelEnum) {
            Intent intent2 = new Intent();
            intent2.setAction(SpiritPower.ACTION_DEVICE_POWER_STATE);
            intent2.putExtra(SpiritPower.EXTRA_POWER_STATE, 0);
            context.sendBroadcast(intent2);
            return;
        }
        if (BaseConstant.XH) {
            new XHApiManager().XHShutDown();
            return;
        }
        if (BrandModelEnum.RUIYIN == BrandConfig.brandModelEnum) {
            context.sendBroadcast(new Intent("com.fise.system.shutdown"));
            return;
        }
        Intent intent3 = new Intent("android.yide.intent.action.shutdown");
        intent3.putExtra("enable", true);
        Log.i("TAG", "shutdown: ");
        context.sendBroadcast(intent3);
    }

    public static void clear(Context context) {
        context.sendBroadcast(new Intent("android.intent.ClearOnOffTime"));
    }

    public static String getPowerOnTime(Context context) {
        String powerOnTime = MyManager.getInstance(context).getPowerOnTime();
        Log.i("TAG", "getPowerOnTime: " + powerOnTime);
        return powerOnTime;
    }

    public static String getPowerOffTime(Context context) {
        String powerOffTime = MyManager.getInstance(context).getPowerOffTime();
        Log.i("TAG", "getPowerOffTime: " + powerOffTime);
        return powerOffTime;
    }

    public static void open_gestureBar(Context context) {
        if (BaseConstant.LK) {
            Intent intent = new Intent("com.xbh.action.HIDE_STATUS_BAR");
            intent.putExtra("hide", false);
            context.sendBroadcast(intent);
        }
    }

    public static void close_gestureBar(Context context) {
        if (BaseConstant.LK) {
            Intent intent = new Intent("com.xbh.action.HIDE_STATUS_BAR");
            intent.putExtra("hide", true);
            context.sendBroadcast(intent);
        }
    }

    public static void reset(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BluetoothService.class);
        intent.putExtra(BaseConstant.Command, "reset");
        context.startService(intent);
    }

    public static void scan(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BluetoothService.class);
        intent.putExtra(BaseConstant.Command, "scan");
        context.startService(intent);
    }

    public static void open(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BluetoothService.class);
        intent.putExtra(BaseConstant.Command, "open");
        context.startService(intent);
    }

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BluetoothService.class);
        intent.putExtra(BaseConstant.Command, TtmlNode.START);
        context.startService(intent);
    }

    public static void refreash(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BluetoothService.class);
        intent.putExtra(BaseConstant.Command, "refresh");
        context.startService(intent);
    }

    public static void settime(Context context, String str, String str2, String str3) {
        String str4;
        switch (str3.hashCode()) {
            case 49:
                str4 = "1";
                break;
            case 50:
                str4 = "2";
                break;
            case 51:
                str4 = "3";
                break;
            case 52:
                str4 = "4";
                break;
            case 53:
                str4 = ConversionUtil.conditionWithSeriesName;
                break;
            case 54:
                str4 = ConversionUtil.conditionWithCallNumber;
                break;
            case 55:
                str4 = ConversionUtil.conditionWithBookType;
                break;
            default:
                String str5 = "{checkSwitch:true,type:0,settings:[{switch:true,wakeupTime:\"" + str + "\",sleepTime:\"" + str2 + "\",week:[\"monday\",\"tuesday\",\"wednesday\",\"thursday\",\"friday\",\"saturday\",\"sunday\"]}]}";
                Log.i("TAG", "settime: " + str5);
                Log.i("TAG", "settime: {checkSwitch:true,type:0,settings:[{switch:true,wakeupTime:\"10:05\",sleepTime:\"12:30\",week:[\"friday\",\"saturday\",\"sunday\"]}]}");
                Intent intent = new Intent("com.zhsd.setting.POWER_ON_OFF_TIMER");
                intent.putExtra("data", str5);
                intent.putExtra("owner", "0");
                context.sendBroadcast(intent);
        }
        str3.equals(str4);
        String str6 = "{checkSwitch:true,type:0,settings:[{switch:true,wakeupTime:\"" + str + "\",sleepTime:\"" + str2 + "\",week:[\"monday\",\"tuesday\",\"wednesday\",\"thursday\",\"friday\",\"saturday\",\"sunday\"]}]}";
        Log.i("TAG", "settime: " + str6);
        Log.i("TAG", "settime: {checkSwitch:true,type:0,settings:[{switch:true,wakeupTime:\"10:05\",sleepTime:\"12:30\",week:[\"friday\",\"saturday\",\"sunday\"]}]}");
        Intent intent2 = new Intent("com.zhsd.setting.POWER_ON_OFF_TIMER");
        intent2.putExtra("data", str6);
        intent2.putExtra("owner", "0");
        context.sendBroadcast(intent2);
    }
}
