package com.yd.android_brand_mvp.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: WebSocketDominateParamBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/model/WebSocketDominateParamBean;", "", ErrorBundle.DETAIL_ENTRY, "", "Lcom/yd/android_brand_mvp/model/DominateDetailLevelBean;", TypedValues.TransitionType.S_DURATION, "", "schoolId", "", "(Ljava/util/List;IJ)V", "getDetails", "()Ljava/util/List;", "getDuration", "()I", "getSchoolId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebSocketDominateParamBean {
    private final List<DominateDetailLevelBean> details;
    private final int duration;
    private final long schoolId;

    public WebSocketDominateParamBean() {
        this(null, 0, 0L, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebSocketDominateParamBean copy$default(WebSocketDominateParamBean webSocketDominateParamBean, List list, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = webSocketDominateParamBean.details;
        }
        if ((i2 & 2) != 0) {
            i = webSocketDominateParamBean.duration;
        }
        if ((i2 & 4) != 0) {
            j = webSocketDominateParamBean.schoolId;
        }
        return webSocketDominateParamBean.copy(list, i, j);
    }

    public final List<DominateDetailLevelBean> component1() {
        return this.details;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSchoolId() {
        return this.schoolId;
    }

    public final WebSocketDominateParamBean copy(List<DominateDetailLevelBean> details, int duration, long schoolId) {
        Intrinsics.checkNotNullParameter(details, "details");
        return new WebSocketDominateParamBean(details, duration, schoolId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketDominateParamBean)) {
            return false;
        }
        WebSocketDominateParamBean webSocketDominateParamBean = (WebSocketDominateParamBean) other;
        return Intrinsics.areEqual(this.details, webSocketDominateParamBean.details) && this.duration == webSocketDominateParamBean.duration && this.schoolId == webSocketDominateParamBean.schoolId;
    }

    public int hashCode() {
        return (((this.details.hashCode() * 31) + this.duration) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.schoolId);
    }

    public String toString() {
        return "WebSocketDominateParamBean(details=" + this.details + ", duration=" + this.duration + ", schoolId=" + this.schoolId + ')';
    }

    public WebSocketDominateParamBean(List<DominateDetailLevelBean> details, int i, long j) {
        Intrinsics.checkNotNullParameter(details, "details");
        this.details = details;
        this.duration = i;
        this.schoolId = j;
    }

    public /* synthetic */ WebSocketDominateParamBean(List list, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0L : j);
    }

    public final List<DominateDetailLevelBean> getDetails() {
        return this.details;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final long getSchoolId() {
        return this.schoolId;
    }
}
