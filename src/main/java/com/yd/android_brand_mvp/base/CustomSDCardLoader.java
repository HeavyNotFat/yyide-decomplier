package com.yd.android_brand_mvp.base;

import android.content.Context;
import java.io.File;
import skin.support.load.SkinSDCardLoader;
import skin.support.utils.SkinFileUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CustomSDCardLoader extends SkinSDCardLoader {
    public static final int SKIN_LOADER_STRATEGY_SDCARD = Integer.MAX_VALUE;

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public int getType() {
        return Integer.MAX_VALUE;
    }

    @Override // skin.support.load.SkinSDCardLoader
    protected String getSkinPath(Context context, String str) {
        return new File(SkinFileUtils.getSkinDir(context), str).getAbsolutePath();
    }
}
