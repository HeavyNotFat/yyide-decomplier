package com.yd.android_brand_mvp.mqtt;

import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.LogUtils;
import com.heytap.mcssdk.a.a;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MQTTMessageQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTMessageQueue;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMessage", "Lcom/yd/android_brand_mvp/mqtt/MQTTEventBean;", "getMessageCount", "", "remove", "", "bean", a.j, "removePush", "saveMessage", "eventBean", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MQTTMessageQueue {
    public static final MQTTMessageQueue INSTANCE = new MQTTMessageQueue();
    private static final String TAG = "MQTTMessageQueue";

    private MQTTMessageQueue() {
    }

    public final String getTAG() {
        return TAG;
    }

    public final synchronized void saveMessage(String code, MQTTEventBean eventBean) {
        Log.d(TAG, "eventBean =  " + GsonUtils.toJson(eventBean));
        if (!TextUtils.isEmpty(code) && !MQTTEventBean.INSTANCE.filterCode(code)) {
            ArrayList arrayList = (List) Hawk.get(BaseHawk.MQTT_MAP);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (eventBean != null) {
                arrayList.add(eventBean);
                Hawk.put(BaseHawk.MQTT_MAP, arrayList);
            }
        }
    }

    public final MQTTEventBean getMessage() {
        List list = (List) Hawk.get(BaseHawk.MQTT_MAP);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (MQTTEventBean) CollectionsKt.last(list);
    }

    public final int getMessageCount() {
        List list = (List) Hawk.get(BaseHawk.MQTT_MAP);
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return list.size();
    }

    public final void remove(MQTTEventBean bean) {
        removePush(bean);
    }

    public final void remove(String code) {
        MQTTEventBean mQTTEventBean = new MQTTEventBean();
        mQTTEventBean.setEventCode(code);
        removePush(mQTTEventBean);
    }

    private final synchronized void removePush(MQTTEventBean bean) {
        if (bean != null) {
            List<MQTTEventBean> list = (List) Hawk.get(BaseHawk.MQTT_MAP);
            if (list != null && list.size() > 0) {
                for (MQTTEventBean mQTTEventBean : list) {
                    if (Intrinsics.areEqual(mQTTEventBean != null ? mQTTEventBean.getEventCode() : null, bean.getEventCode())) {
                        if (Intrinsics.areEqual(mQTTEventBean != null ? mQTTEventBean.getId() : null, bean.getId())) {
                            LogUtils.i("remove eventCode = " + bean.getEventCode());
                            list.remove(mQTTEventBean);
                            Hawk.put(BaseHawk.MQTT_MAP, list);
                            MQTTClient.OnMessageCallBack mOnMessageCallBack = MQTTClient.INSTANCE.getMOnMessageCallBack();
                            if (mOnMessageCallBack != null) {
                                mOnMessageCallBack.onMessage(getMessage());
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
