package com.yd.android_brand_mvp.websocket;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class EventBusUtils {
    public static void register(Object obj) {
        if (EventBus.getDefault().isRegistered(obj)) {
            return;
        }
        EventBus.getDefault().register(obj);
    }

    public static void unRegister(Object obj) {
        if (EventBus.getDefault().isRegistered(obj)) {
            EventBus.getDefault().unregister(obj);
        }
    }

    public static void postEvent(EventBean eventBean) {
        EventBus.getDefault().post(eventBean);
    }

    public static void postErrorEvent(String str, int i, String str2) {
        EventBean eventBean = new EventBean();
        eventBean.setSuccess(false);
        eventBean.setOrigin(str);
        eventBean.setCode(i);
        eventBean.setMessage(str2);
        postEvent(eventBean);
    }

    public static void postSuccessEvent(String str, String str2, Object obj) {
        EventBean eventBean = new EventBean();
        eventBean.setSuccess(true);
        eventBean.setOrigin(str);
        eventBean.setObject(obj);
        eventBean.setRequest(str2);
        postEvent(eventBean);
    }

    public static void postSuccessEvent(String str, Object obj) {
        EventBean eventBean = new EventBean();
        eventBean.setSuccess(true);
        eventBean.setOrigin(str);
        eventBean.setObject(obj);
        postEvent(eventBean);
    }
}
