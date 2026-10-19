package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.yd.android_brand_mvp.BaseApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class Utils {
    public static final int REQ_PERMISSION_CODE = 256;
    private static final String TAG = Utils.class.getSimpleName();

    public static boolean checkPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), "android.permission.CAMERA") != 0) {
                arrayList.add("android.permission.CAMERA");
            }
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), "android.permission.RECORD_AUDIO") != 0) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), "android.permission.READ_PHONE_STATE") != 0) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
            if (ActivityCompat.checkSelfPermission(BaseApplication.getInstance(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (arrayList.size() != 0) {
                ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[1]), 256);
                return false;
            }
        }
        return true;
    }
}
