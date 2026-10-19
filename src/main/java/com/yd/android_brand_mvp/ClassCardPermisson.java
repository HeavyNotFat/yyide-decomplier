package com.yd.android_brand_mvp;

import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class ClassCardPermisson {
    public static ClassCardPermisson rule;

    public static ClassCardPermisson getInstance() {
        if (rule == null) {
            synchronized (ClassCardPermisson.class) {
                if (rule == null) {
                    rule = new ClassCardPermisson();
                }
            }
        }
        return rule;
    }

    public boolean Cheack(String str) {
        if (SpData.NewUser() == null || SpData.NewUser().data == null || SpData.NewUser().data.verify == null) {
            return false;
        }
        Iterator<NewBrandLoginRsp.DataBean.VerifyBean> it2 = SpData.NewUser().data.verify.iterator();
        while (it2.hasNext()) {
            if (it2.next().name.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
