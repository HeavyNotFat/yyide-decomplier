package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventCardBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/model/EventCardBean;", "", "id", "", "str", "", "(ILjava/lang/String;)V", "getId", "()I", "getStr", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EventCardBean {
    private final int id;
    private final String str;

    public static /* synthetic */ EventCardBean copy$default(EventCardBean eventCardBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = eventCardBean.id;
        }
        if ((i2 & 2) != 0) {
            str = eventCardBean.str;
        }
        return eventCardBean.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStr() {
        return this.str;
    }

    public final EventCardBean copy(int id, String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return new EventCardBean(id, str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventCardBean)) {
            return false;
        }
        EventCardBean eventCardBean = (EventCardBean) other;
        return this.id == eventCardBean.id && Intrinsics.areEqual(this.str, eventCardBean.str);
    }

    public int hashCode() {
        return (this.id * 31) + this.str.hashCode();
    }

    public String toString() {
        return "EventCardBean(id=" + this.id + ", str=" + this.str + ')';
    }

    public EventCardBean(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.id = i;
        this.str = str;
    }

    public final int getId() {
        return this.id;
    }

    public final String getStr() {
        return this.str;
    }
}
