package com.yd.android_brand_mvp.brand;

import ZtlApi.ZtlManager;
import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.brand.device.SMTDevices;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.ys.rkapi.MyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BrandConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u000fR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/brand/BrandConfig;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "brandModelEnum", "Lcom/yd/android_brand_mvp/brand/BrandModelEnum;", "firmwareVersion", "getFirmwareVersion", "setFirmwareVersion", "(Ljava/lang/String;)V", "isCustom", "", "model", "versionCode", "getBrandName", "getCameraRotation", "", "getDeviceBoard", "getFacePreviewRotation", "getThemeCode", "isDeviceCard", "isFaceMore", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrandConfig {
    public static final BrandConfig INSTANCE;
    private static final String TAG;
    public static BrandModelEnum brandModelEnum;
    private static String firmwareVersion;
    public static boolean isCustom;

    private BrandConfig() {
    }

    static {
        BrandConfig brandConfig = new BrandConfig();
        INSTANCE = brandConfig;
        TAG = brandConfig.getClass().getSimpleName();
        firmwareVersion = "";
    }

    public final String getTAG() {
        return TAG;
    }

    public final String getFirmwareVersion() {
        return firmwareVersion;
    }

    public final void setFirmwareVersion(String str) {
        firmwareVersion = str;
    }

    public final BrandModelEnum getDeviceBoard() {
        String model = DeviceUtils.getModel();
        LogUtils.i("getDeviceBoard = " + model);
        MyManager myManager = MyManager.getInstance(BaseApplication.getInstance().getApplicationContext());
        LogUtils.i("manager.firmwareVersion=" + myManager.getFirmwareVersion());
        LogUtils.i("SW kernel Version=" + myManager.getKernelVersion());
        LogUtils.i("SWAndroidDisplay=" + myManager.getAndroidDisplay());
        LogUtils.i("manager.getFirmwareDate=" + myManager.getFirmwareDate());
        String versionCode = myManager.getAndroidDisplay();
        firmwareVersion = versionCode;
        Intrinsics.checkNotNullExpressionValue(model, "model");
        Intrinsics.checkNotNullExpressionValue(versionCode, "versionCode");
        brandModelEnum = brandModelEnum(model, versionCode);
        LogUtils.i("brandName = " + getBrandName());
        LogUtils.i("modelEnum = " + GsonUtils.toJson(brandModelEnum));
        BrandModelEnum brandModelEnum2 = brandModelEnum;
        Intrinsics.checkNotNull(brandModelEnum2, "null cannot be cast to non-null type com.yd.android_brand_mvp.brand.BrandModelEnum");
        return brandModelEnum2;
    }

    private final BrandModelEnum brandModelEnum(String model, String versionCode) {
        String str = model;
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.YD_RK3288.getModel())) {
            return BrandModelEnum.YD_RK3288;
        }
        String str2 = versionCode;
        if (!TextUtils.isEmpty(str2) && Intrinsics.areEqual(versionCode, BrandModelEnum.ZTL_RK3568.getModel())) {
            isCustom = true;
            ZtlManager.GetInstance().setContext(BaseApplication.getInstance().getApplicationContext());
            return BrandModelEnum.ZTL_RK3568;
        }
        if (StringsKt.contains$default((CharSequence) BrandModelEnum.LG_U202.getModel(), (CharSequence) str, false, 2, (Object) null)) {
            isCustom = true;
            BaseConstant.LK = true;
            return BrandModelEnum.LG_U202;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.LG_RK3568.getModel(), (CharSequence) str2, false, 2, (Object) null)) {
            isCustom = true;
            return BrandModelEnum.LG_RK3568;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.YS_RK3568.getModel(), (CharSequence) str2, false, 2, (Object) null)) {
            isCustom = true;
            BaseConstant.YS = true;
            return BrandModelEnum.YS_RK3568;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.LG_RK3399_XMS2381D.getModel(), (CharSequence) str, false, 2, (Object) null)) {
            isCustom = true;
            return BrandModelEnum.LG_RK3399_XMS2381D;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.HUIDU_RK3288.getModel(), (CharSequence) str2, false, 2, (Object) null)) {
            isCustom = true;
            BaseConstant.HUIDE = true;
            return BrandModelEnum.HUIDU_RK3288;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.YS_RK3288.getModel(), (CharSequence) str2, false, 2, (Object) null)) {
            isCustom = true;
            return BrandModelEnum.YS_RK3288;
        }
        if ((!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.YD_M5612.getModel())) || ((!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.YX_M585.getModel())) || ((!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.HS_rk3568_d.getModel(), (CharSequence) str2, false, 2, (Object) null)) || (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.HS_rk3568_d.getModelName()))))) {
            isCustom = true;
            BaseConstant.HS_RK3568 = true;
            return BrandModelEnum.YD_M5612;
        }
        if (!TextUtils.isEmpty(str) && StringsKt.contains$default((CharSequence) BrandModelEnum.ZC_RK3568.getModel(), (CharSequence) str, false, 2, (Object) null)) {
            isCustom = true;
            BaseConstant.ZC = true;
            return BrandModelEnum.ZC_RK3568;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.YD_M565.getModel())) {
            isCustom = true;
            BaseConstant.HS_RK3568 = true;
            BaseConstant.HS_RK565 = true;
            return BrandModelEnum.YD_M565;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.LK_RK3568.getModel())) {
            isCustom = true;
            BaseConstant.LK = true;
            return BrandModelEnum.LK_RK3568;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.LG_XM_R3288.getModel(), (CharSequence) str2, false, 2, (Object) null)) {
            isCustom = true;
            BaseConstant.LG = true;
            return BrandModelEnum.LG_XM_R3288;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.LG_RK3566.getModel())) {
            isCustom = true;
            return BrandModelEnum.LG_RK3566;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.JH_rk3288.getModel())) {
            isCustom = true;
            return BrandModelEnum.JH_rk3288;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.SMT_RK3280.getModel())) {
            isCustom = true;
            return BrandModelEnum.SMT_RK3280;
        }
        if (!TextUtils.isEmpty(str) && StringsKt.contains$default((CharSequence) BrandModelEnum.SMT.getModel(), (CharSequence) str, false, 2, (Object) null)) {
            isCustom = true;
            BaseConstant.SMT = true;
            SMTDevices sMTDevices = SMTDevices.INSTANCE;
            Application app = Utils.getApp();
            Intrinsics.checkNotNullExpressionValue(app, "getApp()");
            sMTDevices.initUSB(app);
            return BrandModelEnum.SMT;
        }
        if (!TextUtils.isEmpty(str) && StringsKt.contains$default((CharSequence) BrandModelEnum.SEEWO_SK06C_BON072A_E.getModel(), (CharSequence) str, false, 2, (Object) null)) {
            isCustom = true;
            return BrandModelEnum.SEEWO_SK06C_BON072A_E;
        }
        if (!TextUtils.isEmpty(str) && StringsKt.contains$default((CharSequence) BrandModelEnum.YF_023D.getModel(), (CharSequence) str, false, 2, (Object) null)) {
            isCustom = true;
            return BrandModelEnum.YF_023D;
        }
        if (!TextUtils.isEmpty(str2) && StringsKt.contains$default((CharSequence) BrandModelEnum.RK3288_BOX_G.getModel(), (CharSequence) str2, false, 2, (Object) null)) {
            isCustom = true;
            return BrandModelEnum.RK3288_BOX_G;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.RK3288_BOX.getModel())) {
            isCustom = true;
            return BrandModelEnum.RK3288_BOX;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.SEEWO_SK03C_D.getModel())) {
            isCustom = true;
            return BrandModelEnum.SEEWO_SK03C_D;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.RUIYIN.getModel())) {
            isCustom = true;
            return BrandModelEnum.RUIYIN;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.ZLT_GreenOrange.getModel())) {
            isCustom = true;
            ZtlManager.GetInstance().setContext(BaseApplication.getInstance().getApplicationContext());
            return BrandModelEnum.ZLT_GreenOrange;
        }
        if (!TextUtils.isEmpty(str) && Intrinsics.areEqual(model, BrandModelEnum.SEEWO_SK05.getModel())) {
            isCustom = true;
            BaseConstant.isCustomMade = true;
            return BrandModelEnum.SEEWO_SK05;
        }
        return BrandModelEnum.YD_RK3288;
    }

    public final String getBrandName() {
        String str = "嘉禾";
        if (BaseConstant.HRA) {
            str = "华瑞安";
        } else if (BaseConstant.MY) {
            str = "美弈";
        } else if (BaseConstant.ZC) {
            str = "卓策";
        } else if (BaseConstant.SMT) {
            str = "视美泰";
        } else if (BaseConstant.LK) {
            str = "众永和";
        } else if (BaseConstant.YS) {
            str = "亿晟";
        } else if (!BaseConstant.JH) {
            if (BaseConstant.LG) {
                str = "郎囯";
            } else if (brandModelEnum != BrandModelEnum.JH_rk3288) {
                if (BaseConstant.LG_ZYH) {
                    str = "郎囯-众永和";
                } else if (BaseConstant.NEW_LG) {
                    str = "郎囯-飞利浦";
                } else if (BaseConstant.ST) {
                    str = "汕头";
                } else if (BaseConstant.XXY) {
                    str = "向学云";
                } else if (BaseConstant.LN || BaseConstant.LC || BaseConstant.PXZX) {
                    str = "昱显";
                } else if (BaseConstant.SX) {
                    str = "视新";
                } else if (BaseConstant.HUIDE) {
                    str = "灰度";
                } else if (BaseConstant.RRKJ || brandModelEnum == BrandModelEnum.YF_023D) {
                    str = "容仁科技";
                } else if (brandModelEnum == BrandModelEnum.SEEWO_SK03C_D || brandModelEnum == BrandModelEnum.SEEWO_SK06C_BON072A_E || brandModelEnum == BrandModelEnum.SEEWO_SK05) {
                    str = "希沃—seewo";
                } else if (brandModelEnum == BrandModelEnum.RK3288_BOX || brandModelEnum == BrandModelEnum.RK3288_BOX_G) {
                    str = "智微智能-华三";
                } else if (BaseConstant.XH) {
                    str = "芯华";
                } else if (brandModelEnum == BrandModelEnum.LG_RK3568) {
                    str = "鸿合";
                } else {
                    str = brandModelEnum == BrandModelEnum.RUIYIN ? "睿碒" : "翰视";
                }
            }
        }
        Log.i("brandName", "device brandName = " + str);
        return str;
    }

    public final boolean isDeviceCard(int model) {
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        return brandConfigBean != null && brandConfigBean.getCardReaderBrand() == model;
    }

    public final int getCameraRotation() {
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        if (brandConfigBean == null || TextUtils.isEmpty(brandConfigBean.getCameraAngleCode()) || Integer.parseInt(brandConfigBean.getCameraAngleCode()) <= 0) {
            return -1;
        }
        return Integer.parseInt(brandConfigBean.getCameraAngleCode());
    }

    public final int getFacePreviewRotation() {
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        if (brandConfigBean == null || TextUtils.isEmpty(brandConfigBean.getCameraPreviewCode()) || Integer.parseInt(brandConfigBean.getCameraPreviewCode()) <= 0) {
            return -1;
        }
        return Integer.parseInt(brandConfigBean.getCameraPreviewCode());
    }

    public final String getThemeCode() {
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        return (brandConfigBean == null || TextUtils.isEmpty(brandConfigBean.getThemeCode())) ? "" : brandConfigBean.getThemeCode();
    }

    public final boolean isFaceMore() {
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        if (brandConfigBean != null) {
            return brandConfigBean.getFaceStatus();
        }
        return false;
    }
}
