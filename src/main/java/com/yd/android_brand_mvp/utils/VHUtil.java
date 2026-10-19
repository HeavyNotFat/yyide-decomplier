package com.yd.android_brand_mvp.utils;

import android.util.SparseArray;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class VHUtil {

    public static class ViewHolder {
        public static <T extends View> T get(View view, int i) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                view.setTag(sparseArray);
            }
            T t = (T) sparseArray.get(i);
            if (t != null) {
                return t;
            }
            T t2 = (T) view.findViewById(i);
            sparseArray.put(i, t2);
            return t2;
        }
    }
}
