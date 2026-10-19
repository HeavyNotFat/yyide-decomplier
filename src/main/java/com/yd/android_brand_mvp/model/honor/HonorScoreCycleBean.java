package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorScoreListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorScoreCycleBean;", "", "endTime", "", "id", "seq", "startTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getId", "setId", "getSeq", "setSeq", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorScoreCycleBean {
    private String endTime;
    private String id;
    private String seq;
    private String startTime;

    public static /* synthetic */ HonorScoreCycleBean copy$default(HonorScoreCycleBean honorScoreCycleBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorScoreCycleBean.endTime;
        }
        if ((i & 2) != 0) {
            str2 = honorScoreCycleBean.id;
        }
        if ((i & 4) != 0) {
            str3 = honorScoreCycleBean.seq;
        }
        if ((i & 8) != 0) {
            str4 = honorScoreCycleBean.startTime;
        }
        return honorScoreCycleBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeq() {
        return this.seq;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    public final HonorScoreCycleBean copy(@JSONField(name = "endTime") String endTime, @JSONField(name = "id") String id, @JSONField(name = "seq") String seq, @JSONField(name = "startTime") String startTime) {
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        return new HonorScoreCycleBean(endTime, id, seq, startTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorScoreCycleBean)) {
            return false;
        }
        HonorScoreCycleBean honorScoreCycleBean = (HonorScoreCycleBean) other;
        return Intrinsics.areEqual(this.endTime, honorScoreCycleBean.endTime) && Intrinsics.areEqual(this.id, honorScoreCycleBean.id) && Intrinsics.areEqual(this.seq, honorScoreCycleBean.seq) && Intrinsics.areEqual(this.startTime, honorScoreCycleBean.startTime);
    }

    public int hashCode() {
        return (((((this.endTime.hashCode() * 31) + this.id.hashCode()) * 31) + this.seq.hashCode()) * 31) + this.startTime.hashCode();
    }

    public String toString() {
        return "HonorScoreCycleBean(endTime=" + this.endTime + ", id=" + this.id + ", seq=" + this.seq + ", startTime=" + this.startTime + ')';
    }

    public HonorScoreCycleBean(@JSONField(name = "endTime") String endTime, @JSONField(name = "id") String id, @JSONField(name = "seq") String seq, @JSONField(name = "startTime") String startTime) {
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(seq, "seq");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        this.endTime = endTime;
        this.id = id;
        this.seq = seq;
        this.startTime = startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endTime = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getSeq() {
        return this.seq;
    }

    public final void setSeq(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.seq = str;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startTime = str;
    }
}
