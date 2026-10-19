package com.yd.android_brand_mvp.utils;

import com.yd.android_brand_mvp.db.Attendance;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Sort {
    public static void sort(List<Attendance> list, final String str, final String str2) {
        Collections.sort(list, new Comparator<Attendance>() { // from class: com.yd.android_brand_mvp.utils.Sort.1
            @Override // java.util.Comparator
            public int compare(Attendance attendance, Attendance attendance2) {
                int iCompareTo;
                try {
                    Method method = attendance.getClass().getMethod(str, new Class[0]);
                    Method method2 = attendance2.getClass().getMethod(str, new Class[0]);
                    if (str2 != null && "desc".equals(str2)) {
                        iCompareTo = method2.invoke(attendance2, new Object[0]).toString().compareTo(method.invoke(attendance, new Object[0]).toString());
                    } else {
                        iCompareTo = method.invoke(attendance, new Object[0]).toString().compareTo(method2.invoke(attendance2, new Object[0]).toString());
                    }
                    return iCompareTo;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return 0;
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                    return 0;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return 0;
                }
            }
        });
    }
}
