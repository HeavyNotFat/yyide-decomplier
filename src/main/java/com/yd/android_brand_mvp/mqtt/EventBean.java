package com.yd.android_brand_mvp.mqtt;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/EventBean;", "", "ids", "", "", "(Ljava/util/List;)V", "getIds", "()Ljava/util/List;", "setIds", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EventBean {
    private List<String> ids;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventBean copy$default(EventBean eventBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = eventBean.ids;
        }
        return eventBean.copy(list);
    }

    public final List<String> component1() {
        return this.ids;
    }

    public final EventBean copy(List<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return new EventBean(ids);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EventBean) && Intrinsics.areEqual(this.ids, ((EventBean) other).ids);
    }

    public int hashCode() {
        return this.ids.hashCode();
    }

    public String toString() {
        return "EventBean(ids=" + this.ids + ')';
    }

    public EventBean(List<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.ids = ids;
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public final void setIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.ids = list;
    }
}
