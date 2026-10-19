package com.yd.android_brand_mvp.mqtt;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageSyncBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/StatusEnum;", "", "(Ljava/lang/String;I)V", "value", "", "STATUS_RECEIVE", "STATUS_SUCCESS", "STATUS_FAIL", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum StatusEnum {
    STATUS_RECEIVE { // from class: com.yd.android_brand_mvp.mqtt.StatusEnum.STATUS_RECEIVE
        @Override // com.yd.android_brand_mvp.mqtt.StatusEnum
        public int value() {
            return 1;
        }
    },
    STATUS_SUCCESS { // from class: com.yd.android_brand_mvp.mqtt.StatusEnum.STATUS_SUCCESS
        @Override // com.yd.android_brand_mvp.mqtt.StatusEnum
        public int value() {
            return 2;
        }
    },
    STATUS_FAIL { // from class: com.yd.android_brand_mvp.mqtt.StatusEnum.STATUS_FAIL
        @Override // com.yd.android_brand_mvp.mqtt.StatusEnum
        public int value() {
            return -2;
        }
    };

    /* synthetic */ StatusEnum(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int value();
}
