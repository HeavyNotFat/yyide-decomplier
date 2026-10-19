package com.yd.android_brand_mvp.utils;

import com.yd.android_brand_mvp.BaseApplication;
import com.zcapi;

/* JADX INFO: loaded from: classes4.dex */
public class ZcTools {
    private static zcapi zc;

    public static zcapi getInitialize() {
        if (zc == null) {
            zcapi zcapiVar = new zcapi();
            zc = zcapiVar;
            zcapiVar.getContext(BaseApplication.getInstance());
        }
        return zc;
    }
}
