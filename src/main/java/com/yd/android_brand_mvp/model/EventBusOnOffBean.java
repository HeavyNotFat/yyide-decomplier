package com.yd.android_brand_mvp.model;

import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventBusOnOffBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/model/EventBusOnOffBean;", "", "shutDownMilliSecond", "", "shutDownTime", "", "openOnTime", "timeFormat", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOpenOnTime", "()Ljava/lang/String;", "getShutDownMilliSecond", "()J", "getShutDownTime", "getTimeFormat", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EventBusOnOffBean {
    private final String openOnTime;
    private final long shutDownMilliSecond;
    private final String shutDownTime;
    private final String timeFormat;

    public EventBusOnOffBean() {
        this(0L, null, null, null, 15, null);
    }

    public static /* synthetic */ EventBusOnOffBean copy$default(EventBusOnOffBean eventBusOnOffBean, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = eventBusOnOffBean.shutDownMilliSecond;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = eventBusOnOffBean.shutDownTime;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = eventBusOnOffBean.openOnTime;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = eventBusOnOffBean.timeFormat;
        }
        return eventBusOnOffBean.copy(j2, str4, str5, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getShutDownMilliSecond() {
        return this.shutDownMilliSecond;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShutDownTime() {
        return this.shutDownTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOpenOnTime() {
        return this.openOnTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTimeFormat() {
        return this.timeFormat;
    }

    public final EventBusOnOffBean copy(long shutDownMilliSecond, String shutDownTime, String openOnTime, String timeFormat) {
        Intrinsics.checkNotNullParameter(shutDownTime, "shutDownTime");
        Intrinsics.checkNotNullParameter(openOnTime, "openOnTime");
        Intrinsics.checkNotNullParameter(timeFormat, "timeFormat");
        return new EventBusOnOffBean(shutDownMilliSecond, shutDownTime, openOnTime, timeFormat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventBusOnOffBean)) {
            return false;
        }
        EventBusOnOffBean eventBusOnOffBean = (EventBusOnOffBean) other;
        return this.shutDownMilliSecond == eventBusOnOffBean.shutDownMilliSecond && Intrinsics.areEqual(this.shutDownTime, eventBusOnOffBean.shutDownTime) && Intrinsics.areEqual(this.openOnTime, eventBusOnOffBean.openOnTime) && Intrinsics.areEqual(this.timeFormat, eventBusOnOffBean.timeFormat);
    }

    public int hashCode() {
        return (((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.shutDownMilliSecond) * 31) + this.shutDownTime.hashCode()) * 31) + this.openOnTime.hashCode()) * 31) + this.timeFormat.hashCode();
    }

    public String toString() {
        return "EventBusOnOffBean(shutDownMilliSecond=" + this.shutDownMilliSecond + ", shutDownTime=" + this.shutDownTime + ", openOnTime=" + this.openOnTime + ", timeFormat=" + this.timeFormat + ')';
    }

    public EventBusOnOffBean(long j, String shutDownTime, String openOnTime, String timeFormat) {
        Intrinsics.checkNotNullParameter(shutDownTime, "shutDownTime");
        Intrinsics.checkNotNullParameter(openOnTime, "openOnTime");
        Intrinsics.checkNotNullParameter(timeFormat, "timeFormat");
        this.shutDownMilliSecond = j;
        this.shutDownTime = shutDownTime;
        this.openOnTime = openOnTime;
        this.timeFormat = timeFormat;
    }

    public /* synthetic */ EventBusOnOffBean(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final long getShutDownMilliSecond() {
        return this.shutDownMilliSecond;
    }

    public final String getShutDownTime() {
        return this.shutDownTime;
    }

    public final String getOpenOnTime() {
        return this.openOnTime;
    }

    public final String getTimeFormat() {
        return this.timeFormat;
    }
}
