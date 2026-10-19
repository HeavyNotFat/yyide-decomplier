package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.text.TextUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.yd.android_brand_mvp.R;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class GetWeekIndex {
    public static int WeekIndex(Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.weekStr_7);
        for (int i = 0; i < stringArray.length; i++) {
            if (TextUtils.equals(stringArray[i], TimeUtils.getChineseWeek(new Date()))) {
                return i + 1;
            }
        }
        return -1;
    }
}
