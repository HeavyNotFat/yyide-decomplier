package com.yd.android_brand_mvp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.serialport.SerialPort;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.multidex.MultiDex;
import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import com.android.dex.DexFormat;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.module.LoadMoreModuleConfig;
import com.heytap.msp.push.HeytapPushManager;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.push.HmsMessaging;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.orhanobut.hawk.Hawk;
import com.seewo.sdk.OpenSDK;
import com.seewo.udsservice.client.core.UDSSDK;
import com.shuyu.gsyvideoplayer.player.IjkPlayerManager;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.mmkv.MMKV;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IMEventListener;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.vise.xsnow.http.ViseHttp;
import com.vivo.push.PushClient;
import com.xbh.sdk4.client.UserAPI;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.CustomSDCardLoader;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.brand.BrandCardEnum;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.brand.BrandModelEnum;
import com.yd.android_brand_mvp.brand.device.HuiDuDevices;
import com.yd.android_brand_mvp.landscape.book.AuthcodeTwo;
import com.yd.android_brand_mvp.landscape.book.BaseBeanReq;
import com.yd.android_brand_mvp.landscape.book.MyHashMap;
import com.yd.android_brand_mvp.landscape.book.Object2Map;
import com.yd.android_brand_mvp.landscape.book.network.FastJsonRequest;
import com.yd.android_brand_mvp.landscape.book.network.GetData;
import com.yd.android_brand_mvp.manager.ActivityManager;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.CardUtils;
import com.yd.android_brand_mvp.utils.CardUtils55;
import com.yd.android_brand_mvp.utils.GetVersionUtils;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SDcarfile;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StringUtils;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.CustomLoadMoreView;
import com.ys.rkapi.MyManager;
import com.yyide.im.chat.DemoApplication;
import com.yyide.im.chat.helper.ConfigHelper;
import com.yyide.im.chat.signature.GenerateTestUserSig;
import com.yyide.im.chat.thirdpush.HUAWEIHmsMessageService;
import com.yyide.im.chat.utils.BrandUtil;
import com.yyide.im.chat.utils.DemoLog;
import com.yyide.im.chat.utils.MessageNotification;
import demo.model.AccountInfo;
import demo.model.LockObj;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import me.jessyan.autosize.AutoAdaptStrategy;
import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;
import skin.support.SkinCompatManager;
import skin.support.app.SkinAppCompatViewInflater;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/* JADX INFO: loaded from: classes4.dex */
public class BaseApplication extends DemoApplication {
    private static BaseApplication instance;
    private AccountInfo accountInfo;
    private InputStream mInputStream;
    private volatile ReadThread mReadThread;
    public RequestQueue queue;
    PendingIntent restartIntent;
    private static final String TAG = BaseApplication.class.getSimpleName();
    public static String logFilePath = Environment.getExternalStorageDirectory() + File.separator + "yide_log";
    private final Handler cardHandler = new Handler();
    public Thread.UncaughtExceptionHandler restartHandler = new Thread.UncaughtExceptionHandler() { // from class: com.yd.android_brand_mvp.BaseApplication.2
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            ((AlarmManager) BaseApplication.this.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 1000, BaseApplication.this.restartIntent);
            LogUtils.e("uncaughtException: " + th.getMessage());
            ActivityUtils.finishAllActivities();
            Process.killProcess(Process.myPid());
            BaseApplication.this.startActivity(new Intent(BaseApplication.this.getApplicationContext(), (Class<?>) MainActivity.class));
        }
    };

    @Override // com.yyide.im.chat.DemoApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        MMKV.initialize(this);
        GetVersionUtils.INSTANCE.getApkVersionName(this);
        SkinCompatManager.withoutActivity(this).addStrategy(new CustomSDCardLoader()).addInflater(new SkinAppCompatViewInflater()).addInflater(new SkinMaterialViewInflater()).addInflater(new SkinConstraintViewInflater()).addInflater(new SkinCardViewInflater()).setSkinStatusBarColorEnable(false).setSkinWindowBackgroundEnable(false).loadSkin();
        this.queue = Volley.newRequestQueue(this, new HurlStack());
        Utils.init((Application) this);
        LogUtils.getConfig().setLogSwitch(true).setConsoleSwitch(true).setLog2FileSwitch(true).setGlobalTag(null).setLogHeadSwitch(false).setDir(logFilePath).setFilePrefix("yide").setBorderSwitch(false).setConsoleFilter(2).setFileFilter(2).setSaveDays(7).setStackDeep(1);
        BrandConfig.INSTANCE.getDeviceBoard();
        LogUtils.i("设备厂商类型 = " + GsonUtils.toJson(BrandConfig.brandModelEnum));
        initDevice();
        if (SPUtils.getInstance().getBoolean(SpData.SKIN)) {
            SkinCompatManager.getInstance().loadSkin("animation.skin", 0);
        }
        IjkPlayerManager.setLogLevel(8);
        ViseHttp.init(this);
        OkHttpFinal.getInstance().init(new OkHttpFinalConfiguration.Builder().build());
        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(getApplicationContext());
        userStrategy.setAppVersion(AppUtils.getAppVersionName());
        CrashReport.initCrashReport(getApplicationContext(), "c984940bea", true, userStrategy);
        Thread.setDefaultUncaughtExceptionHandler(new BuglyCrashHandler(Thread.getDefaultUncaughtExceptionHandler()));
        if (!BaseConstant.MNQ) {
            TXLiveBase.getInstance().setLicence(instance, "", "");
        }
        Hawk.init(this).build();
        TUIKit.init(this, GenerateTestUserSig.SDKAPPID, new ConfigHelper().getConfigs(this));
        HeytapPushManager.init(this, true);
        if (BrandUtil.isBrandXiaoMi()) {
            MiPushClient.registerPush(this, "", "");
        } else if (BrandUtil.isBrandHuawei()) {
            HmsMessaging.getInstance(this).turnOnPush().addOnCompleteListener(new OnCompleteListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$BaseApplication$pOrLZbEMcCj8mcnXF5pDTrUWlZM
                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    BaseApplication.lambda$onCreate$0(task);
                }
            });
        } else if (MzSystemUtils.isBrandMeizu(this)) {
            PushManager.register(this, "", "");
        } else if (BrandUtil.isBrandVivo()) {
            PushClient.getInstance(getApplicationContext()).initialize();
        } else if (!HeytapPushManager.isSupportPush()) {
            BrandUtil.isGoogleServiceSupport();
        }
        registerActivityLifecycleCallbacks(new StatisticActivityLifecycleCallback());
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
        QbSdk.setDownloadWithoutWifi(true);
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() { // from class: com.yd.android_brand_mvp.BaseApplication.1
            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onCoreInitFinished() {
            }

            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onViewInitFinished(boolean z) {
                Log.d(BaseApplication.TAG, "onViewInitFinished: isEnableX5" + z);
            }
        });
        LoadMoreModuleConfig.setDefLoadMoreView(new CustomLoadMoreView());
    }

    static /* synthetic */ void lambda$onCreate$0(Task task) {
        if (task.isSuccessful()) {
            DemoLog.i(TAG, "huawei turnOnPush Complete");
            return;
        }
        DemoLog.e(TAG, "huawei turnOnPush failed: ret=" + task.getException().getMessage());
    }

    public class CustomAdaptStrategy implements AutoAdaptStrategy {
        public CustomAdaptStrategy() {
        }

        @Override // me.jessyan.autosize.AutoAdaptStrategy
        public void applyAdapt(Object obj, Activity activity) {
            if (AutoSizeConfig.getInstance().getScreenWidth() / AutoSizeConfig.getInstance().getScreenHeight() < 1.7777778f) {
                AutoSize.autoConvertDensity(activity, 1750.0f, true);
            } else {
                AutoSize.autoConvertDensity(activity, 1920.0f, false);
            }
        }
    }

    public <T> void requestData(Object obj, BaseBeanReq<T> baseBeanReq, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.putAll(Object2Map.object2Map(baseBeanReq));
        FastJsonRequest fastJsonRequest = new FastJsonRequest(GetData.requestUrl(baseBeanReq), baseBeanReq.myTypeReference(), listener, errorListener, AuthcodeTwo.authcodeEncode(myHashMap.toString(), GetData.URL_KEY));
        fastJsonRequest.setShouldCache(true);
        fastJsonRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
        fastJsonRequest.setTag(obj);
        this.queue.add(fastJsonRequest);
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public void initDevice() {
        if (BaseConstant.NEW_LG || BaseConstant.LG_ZYH || BrandModelEnum.LG_RK3568 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum || BrandModelEnum.LG_RK3399_XMS2381D == BrandConfig.brandModelEnum) {
            UserAPI.getInstance().init(getApplicationContext());
        } else if (BrandModelEnum.SEEWO_SK06C_BON072A_E == BrandConfig.brandModelEnum) {
            UDSSDK.INSTANCE.init(this);
        } else if (BrandModelEnum.SEEWO_SK03C_D == BrandConfig.brandModelEnum) {
            OpenSDK.getInstance().connect(this);
        } else if (BrandModelEnum.HUIDU_RK3288 == BrandConfig.brandModelEnum) {
            HuiDuDevices.INSTANCE.initUtil();
        }
        initReadCard();
    }

    public String getMac() {
        // 还原版：固定为真实班牌 MAC，保证 /brand/obtain 与考勤上报使用同一设备身份。
        return "__SEC_MAC_LITERAL_E8635151__";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0060 A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:7:0x0017, B:9:0x0021, B:11:0x002b, B:13:0x0078, B:15:0x0082, B:12:0x0060), top: B:20:0x0017 }] */
    private void initReadCard() {
        SerialPort serialPort;
        if (BaseConstant.MNQ) {
            return;
        }
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        if (brandConfigBean != null) {
            try {
                if (!TextUtils.isEmpty(brandConfigBean.getCardReaderSerialPortCode()) && !TextUtils.isEmpty(brandConfigBean.getCardReaderFrequencyCode())) {
                    int i = Integer.parseInt(brandConfigBean.getCardReaderFrequencyCode());
                    String cardReaderSerialPortCode = brandConfigBean.getCardReaderSerialPortCode();
                    Log.i(TAG, "baudrate = " + i + " serialPort = " + cardReaderSerialPortCode);
                    serialPort = new SerialPort(new File(cardReaderSerialPortCode), i);
                } else {
                    serialPort = new SerialPort(new File(SPUtils.getInstance().getString("serialPort", BaseConstant.SPORT3)), BaseConstant.IBAUDRATE9600);
                }
            } catch (Exception e) {
                LogUtils.i("初始化串口异常 = " + e.getMessage());
                e.printStackTrace();
                return;
            }
        } else {
            try {
                serialPort = new SerialPort(new File(SPUtils.getInstance().getString("serialPort", BaseConstant.SPORT3)), BaseConstant.IBAUDRATE9600);
            } catch (java.io.IOException e) {
                LogUtils.i("串口不可用: " + e.getMessage());
                return;
            }
        }
        this.mInputStream = serialPort.getInputStream();
        if (this.mReadThread == null) {
            this.mReadThread = new ReadThread();
            this.mReadThread.start();
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        MultiDex.install(this);
        super.attachBaseContext(context);
        new Handler(getMainLooper()).post(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$BaseApplication$wIHVYYRWv_MzTFkEPCkBV7IuY1E
            @Override // java.lang.Runnable
            public final void run() {
                BaseApplication.lambda$attachBaseContext$1();
            }
        });
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    static /* synthetic */ void lambda$attachBaseContext$1() {
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th) {
                LogUtils.e(BuglyCrashHandler.getInstance().getStackTraceInfo(th));
                CrashReport.postCatchedException(th);
            }
        }
    }

    private final class ReadThread extends Thread {
        private ReadThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while (BaseApplication.this.mInputStream != null && BaseApplication.this.mReadThread == Thread.currentThread()) {
                try {
                    byte[] bArr = (BaseConstant.LK || BaseConstant.LN || BaseConstant.HS_RK565) ? new byte[12] : new byte[64];
                    int i = BaseApplication.this.mInputStream.read(bArr);
                    StringBuilder sb3 = new StringBuilder();
                    if (i > 0) {
                        Log.i(BaseApplication.TAG, "cardHEX: " + Tool.bytesToHex(bArr));
                        if (BaseConstant.HS_RK565) {
                            String strBytesToHex = Tool.bytesToHex(bArr);
                            if (!TextUtils.isEmpty(strBytesToHex)) {
                                char[] charArray = strBytesToHex.substring(0, strBytesToHex.lastIndexOf("0d0a")).toCharArray();
                                for (int i2 = 0; i2 < charArray.length; i2++) {
                                    if (i2 % 2 != 0) {
                                        sb3.append(charArray[i2]);
                                    }
                                }
                            }
                        } else {
                            if (BaseConstant.HS_RK3568 || BaseConstant.LN || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_1_HS_RK3568_LN.getType())) {
                                sb = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[3], bArr[4], bArr[5], bArr[6]}), 16).toString());
                            } else if (BaseConstant.NEW_LG || BaseConstant.RRKJ || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_2_NEW_LG_RRKJ.getType()) || BrandConfig.brandModelEnum == BrandModelEnum.YF_023D) {
                                sb = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[10], bArr[9], bArr[8], bArr[7]}), 16).toString());
                            } else if (BaseConstant.PXZX || BaseConstant.JW || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_3_PXZX_JW.getType()) || BrandConfig.brandModelEnum == BrandModelEnum.ZLT_GreenOrange) {
                                sb = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[3], bArr[2], bArr[1], bArr[0]}), 16).toString());
                            } else if (BaseConstant.ZC || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_4_ZC.getType())) {
                                String strBytesToHex2 = Tool.bytesToHex(bArr);
                                int iLastIndexOf = strBytesToHex2.lastIndexOf("0d0a03");
                                if (iLastIndexOf > 0) {
                                    sb3 = new StringBuilder(new BigInteger(Tool.hexStr2Str(strBytesToHex2.substring(2, iLastIndexOf)).trim(), 16).toString());
                                }
                            } else {
                                if (BaseConstant.LK || BaseConstant.XXY || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_5_LK_XXY.getType())) {
                                    sb2 = new StringBuilder(new StringBuilder(new String(bArr).replaceAll("^(0+)", "")).toString().replaceAll("\r|\n", ""));
                                } else if (BaseConstant.HRA || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_6_HRA.getType())) {
                                    sb3 = new StringBuilder(CardUtils55.getInstance().getCardNo(bArr, 0, i));
                                } else if (BaseConstant.XH || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_7_XH.getType())) {
                                    String strBytesToHex3 = Tool.bytesToHex(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]});
                                    if (!TextUtils.isEmpty(strBytesToHex3) && strBytesToHex3.endsWith("0") && BrandModelEnum.YS_RK3288 == BrandConfig.brandModelEnum) {
                                        strBytesToHex3 = strBytesToHex3.substring(0, strBytesToHex3.length() - 1);
                                    }
                                    Log.i(BaseApplication.TAG, "toHex: " + strBytesToHex3);
                                    sb2 = new StringBuilder(new BigInteger(strBytesToHex3, 16).toString());
                                } else if (BaseConstant.YXS || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_8_YXS.getType())) {
                                    sb = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[9], bArr[8], bArr[7], bArr[6]}), 16).toString());
                                } else if (BaseConstant.HXW523U || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.HXW523U.getType())) {
                                    sb = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[6], bArr[5], bArr[4], bArr[3]}), 16).toString());
                                } else if (BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_9_YS.getType())) {
                                    sb3 = new StringBuilder(new String(bArr).replaceAll("^(0+)", "").replaceAll(DexFormat.MAGIC_SUFFIX, "").replaceAll("\r|\n", ""));
                                    if (!StringUtils.isNumeric(sb3.toString())) {
                                        sb3 = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[11], bArr[10], bArr[9], bArr[8]}), 16).toString());
                                    }
                                } else if (BaseConstant.LG_ZYH || BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.CARD_10_LG_ZYH.getType()) || BrandModelEnum.SMT == BrandConfig.brandModelEnum) {
                                    int i3 = i - 2;
                                    byte[] bArr2 = new byte[i3];
                                    System.arraycopy(bArr, 0, bArr2, 0, i3);
                                    sb = new StringBuilder(new String(bArr2));
                                } else if (BrandConfig.INSTANCE.isDeviceCard(BrandCardEnum.HH3568D_NFC.getType())) {
                                    sb = new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{bArr[5], bArr[4], bArr[3], bArr[2]}), 16).toString());
                                } else {
                                    sb3 = new StringBuilder(CardUtils.getInstance().getCardNo(bArr, 0, i));
                                }
                                sb3 = sb2;
                            }
                            sb3 = sb;
                        }
                        Log.i(BaseApplication.TAG, "cardNo: " + ((Object) sb3));
                    }
                    if (!TextUtils.isEmpty(sb3.toString())) {
                        String strReplaceAll = sb3.toString().replaceAll("^(0+)", "");
                        LogUtils.i("push cardNo: " + strReplaceAll);
                        BaseApplication.this.sendCard(strReplaceAll);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.i("cardNo: 卡号解析异常");
                }
            }
        }
    }

    public void sendCard(String str) {
        this.cardHandler.post(new CardBroadcast(str));
    }

    private static class CardBroadcast implements Runnable {
        private final String cardNo;

        private CardBroadcast(String str) {
            this.cardNo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObserverManager.getInstance().notifyObserver(this.cardNo);
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    class StatisticActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        private boolean isChangingConfiguration;
        private int foregroundActivities = 0;
        private IMEventListener mIMEventListener = new IMEventListener() { // from class: com.yd.android_brand_mvp.BaseApplication.StatisticActivityLifecycleCallback.1
            @Override // com.tencent.qcloud.tim.uikit.base.IMEventListener
            public void onNewMessage(V2TIMMessage v2TIMMessage) {
            }
        };
        private ConversationManagerKit.MessageUnreadWatcher mUnreadWatcher = new ConversationManagerKit.MessageUnreadWatcher() { // from class: com.yd.android_brand_mvp.BaseApplication.StatisticActivityLifecycleCallback.2
            @Override // com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit.MessageUnreadWatcher
            public void updateUnread(int i) {
                HUAWEIHmsMessageService.updateBadge(BaseApplication.this, i);
            }
        };

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        StatisticActivityLifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            DemoLog.i(BaseApplication.TAG, "onActivityCreated bundle: " + bundle);
            if (bundle != null) {
                Intent intent = new Intent(activity, (Class<?>) WelcomeActivity.class);
                intent.setFlags(268435456);
                BaseApplication.this.startActivity(intent);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i = this.foregroundActivities + 1;
            this.foregroundActivities = i;
            if (i == 1 && !this.isChangingConfiguration) {
                DemoLog.i(BaseApplication.TAG, "application enter foreground");
                V2TIMManager.getOfflinePushManager().doForeground(new V2TIMCallback() { // from class: com.yd.android_brand_mvp.BaseApplication.StatisticActivityLifecycleCallback.3
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i2, String str) {
                        DemoLog.e(BaseApplication.TAG, "doForeground err = " + i2 + ", desc = " + str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        DemoLog.i(BaseApplication.TAG, "doForeground success");
                    }
                });
                TUIKit.removeIMEventListener(this.mIMEventListener);
                ConversationManagerKit.getInstance().removeUnreadWatcher(this.mUnreadWatcher);
                MessageNotification.getInstance().cancelTimeout();
            }
            this.isChangingConfiguration = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ActivityManager.INSTANCE.setCurrentActivity(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i = this.foregroundActivities - 1;
            this.foregroundActivities = i;
            if (i == 0) {
                DemoLog.i(BaseApplication.TAG, "application enter background");
                V2TIMManager.getOfflinePushManager().doBackground(ConversationManagerKit.getInstance().getUnreadTotal(), new V2TIMCallback() { // from class: com.yd.android_brand_mvp.BaseApplication.StatisticActivityLifecycleCallback.4
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i2, String str) {
                        DemoLog.e(BaseApplication.TAG, "doBackground err = " + i2 + ", desc = " + str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        DemoLog.i(BaseApplication.TAG, "doBackground success");
                    }
                });
                TUIKit.addIMEventListener(this.mIMEventListener);
                ConversationManagerKit.getInstance().addUnreadWatcher(this.mUnreadWatcher);
            }
            this.isChangingConfiguration = activity.isChangingConfigurations();
        }
    }

    private void reStartByCrash() {
        Intent intent = new Intent();
        intent.setClassName(BuildConfig.APPLICATION_ID, "com.yd.android_brand_mvp.MainActivity");
        this.restartIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 268435456);
        Thread.setDefaultUncaughtExceptionHandler(this.restartHandler);
    }

    public AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void saveChoosedLock(LockObj lockObj) {
        SDcarfile.save("bluetooth_lock", GsonUtils.toJson(lockObj));
    }

    public LockObj getChoosedLock() {
        return (LockObj) GsonUtils.fromJson(SDcarfile.read("bluetooth_lock"), LockObj.class);
    }
}
