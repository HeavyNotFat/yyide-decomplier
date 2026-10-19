package com.yd.android_brand_mvp.model;

import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RemainingBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/RemainingBean;", "", "day", "", "hours", "min", "second", "(JJJJ)V", "getDay", "()J", "setDay", "(J)V", "getHours", "setHours", "getMin", "setMin", "getSecond", "setSecond", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RemainingBean {
    private long day;
    private long hours;
    private long min;
    private long second;

    public RemainingBean() {
        this(0L, 0L, 0L, 0L, 15, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getHours() {
        return this.hours;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSecond() {
        return this.second;
    }

    public final RemainingBean copy(long day, long hours, long min, long second) {
        return new RemainingBean(day, hours, min, second);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemainingBean)) {
            return false;
        }
        RemainingBean remainingBean = (RemainingBean) other;
        return this.day == remainingBean.day && this.hours == remainingBean.hours && this.min == remainingBean.min && this.second == remainingBean.second;
    }

    public int hashCode() {
        return (((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.day) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.hours)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.min)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.second);
    }

    public String toString() {
        return "RemainingBean(day=" + this.day + ", hours=" + this.hours + ", min=" + this.min + ", second=" + this.second + ')';
    }

    public RemainingBean(long j, long j2, long j3, long j4) {
        this.day = j;
        this.hours = j2;
        this.min = j3;
        this.second = j4;
    }

    public /* synthetic */ RemainingBean(long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) == 0 ? j4 : 0L);
    }

    public final long getDay() {
        return this.day;
    }

    public final void setDay(long j) {
        this.day = j;
    }

    public final long getHours() {
        return this.hours;
    }

    public final void setHours(long j) {
        this.hours = j;
    }

    public final long getMin() {
        return this.min;
    }

    public final void setMin(long j) {
        this.min = j;
    }

    public final long getSecond() {
        return this.second;
    }

    public final void setSecond(long j) {
        this.second = j;
    }
}
