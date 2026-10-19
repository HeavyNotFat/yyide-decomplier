package com.yd.android_brand_mvp.utils;

import android.content.Context;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.p000enum.ThemeTStyleEnum;
import com.yyide.facepass.AppExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import skin.support.SkinCompatManager;

/* JADX INFO: compiled from: SkinUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/utils/SkinUtil;", "", "()V", "setTheme", "", "context", "Landroid/content/Context;", "key", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SkinUtil {
    public static final SkinUtil INSTANCE = new SkinUtil();

    private SkinUtil() {
    }

    public final void setTheme(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        LogUtils.i("setTheme = " + key);
        if (Intrinsics.areEqual(key, ThemeTStyleEnum.SKYWORTH.getKey())) {
            SPUtils.getInstance().put(SpData.SKIN, false);
            SkinCompatManager.getInstance().loadSkin("skyworth.skin", 0);
            FontsUtils.INSTANCE.typeFaceDefault();
        } else {
            if (Intrinsics.areEqual(key, ThemeTStyleEnum.ANIMATION.getKey())) {
                AppExtKt.logd(this, "setTheme = 动画");
                SPUtils.getInstance().put(SpData.SKIN, true);
                SkinCompatManager.getInstance().loadSkin("animation.skin", 0);
                FontsUtils.INSTANCE.replaceSystemDefaultFont(context, FontsUtils.fontPath);
                return;
            }
            if (Intrinsics.areEqual(key, ThemeTStyleEnum.NORMAL.getKey())) {
                AppExtKt.logd(this, "setTheme = 默认");
                SPUtils.getInstance().put(SpData.SKIN, false);
                SkinCompatManager.getInstance().restoreDefaultTheme();
                FontsUtils.INSTANCE.typeFaceDefault();
            }
        }
    }
}
