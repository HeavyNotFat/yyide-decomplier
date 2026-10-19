package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorCommentResultBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorResultBean;", "", "id", "", "ranking", FirebaseAnalytics.Param.SCORE, AppMeasurementSdk.ConditionalUserProperty.NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getRanking", "setRanking", "getScore", "setScore", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorResultBean {
    private String id;
    private String name;
    private String ranking;
    private String score;

    public static /* synthetic */ HonorResultBean copy$default(HonorResultBean honorResultBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorResultBean.id;
        }
        if ((i & 2) != 0) {
            str2 = honorResultBean.ranking;
        }
        if ((i & 4) != 0) {
            str3 = honorResultBean.score;
        }
        if ((i & 8) != 0) {
            str4 = honorResultBean.name;
        }
        return honorResultBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRanking() {
        return this.ranking;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final HonorResultBean copy(@JSONField(name = "id") String id, @JSONField(name = "ranking") String ranking, @JSONField(name = FirebaseAnalytics.Param.SCORE) String score, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(ranking, "ranking");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(name, "name");
        return new HonorResultBean(id, ranking, score, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorResultBean)) {
            return false;
        }
        HonorResultBean honorResultBean = (HonorResultBean) other;
        return Intrinsics.areEqual(this.id, honorResultBean.id) && Intrinsics.areEqual(this.ranking, honorResultBean.ranking) && Intrinsics.areEqual(this.score, honorResultBean.score) && Intrinsics.areEqual(this.name, honorResultBean.name);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.ranking.hashCode()) * 31) + this.score.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "HonorResultBean(id=" + this.id + ", ranking=" + this.ranking + ", score=" + this.score + ", name=" + this.name + ')';
    }

    public HonorResultBean(@JSONField(name = "id") String id, @JSONField(name = "ranking") String ranking, @JSONField(name = FirebaseAnalytics.Param.SCORE) String score, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(ranking, "ranking");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.ranking = ranking;
        this.score = score;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getRanking() {
        return this.ranking;
    }

    public final void setRanking(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ranking = str;
    }

    public final String getScore() {
        return this.score;
    }

    public final void setScore(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.score = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }
}
