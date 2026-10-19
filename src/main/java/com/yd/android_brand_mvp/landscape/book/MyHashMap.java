package com.yd.android_brand_mvp.landscape.book;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MyHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = 1;

    @Override // java.util.AbstractMap
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(size() * 28);
        Iterator<Map.Entry<String, String>> it2 = entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> next = it2.next();
            String key = next.getKey();
            if (key != this) {
                sb.append((Object) key);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            String value = next.getValue();
            if (value != this) {
                sb.append((Object) value);
            } else {
                sb.append("(this Map)");
            }
            if (it2.hasNext()) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb.toString();
    }
}
