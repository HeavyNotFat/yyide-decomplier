package com.yd.android_brand_mvp.model.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTaskBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/EventTaskBean;", "", "type", "", "itemId", "", "(ILjava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EventTaskBean {
    private final String itemId;
    private final int type;

    public static /* synthetic */ EventTaskBean copy$default(EventTaskBean eventTaskBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = eventTaskBean.type;
        }
        if ((i2 & 2) != 0) {
            str = eventTaskBean.itemId;
        }
        return eventTaskBean.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    public final EventTaskBean copy(int type, String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return new EventTaskBean(type, itemId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTaskBean)) {
            return false;
        }
        EventTaskBean eventTaskBean = (EventTaskBean) other;
        return this.type == eventTaskBean.type && Intrinsics.areEqual(this.itemId, eventTaskBean.itemId);
    }

    public int hashCode() {
        return (this.type * 31) + this.itemId.hashCode();
    }

    public String toString() {
        return "EventTaskBean(type=" + this.type + ", itemId=" + this.itemId + ')';
    }

    public EventTaskBean(int i, String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.type = i;
        this.itemId = itemId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getItemId() {
        return this.itemId;
    }
}
