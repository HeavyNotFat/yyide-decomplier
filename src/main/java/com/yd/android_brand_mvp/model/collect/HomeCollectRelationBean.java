package com.yd.android_brand_mvp.model.collect;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeCollectRelationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/HomeCollectRelationBean;", "", "questionId", "", FirebaseAnalytics.Param.LEVEL, "id", "expectValue", "", "collectTableId", "(IIILjava/lang/String;I)V", "getCollectTableId", "()I", "getExpectValue", "()Ljava/lang/String;", "getId", "getLevel", "getQuestionId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeCollectRelationBean {
    private final int collectTableId;
    private final String expectValue;
    private final int id;
    private final int level;
    private final int questionId;

    public HomeCollectRelationBean() {
        this(0, 0, 0, null, 0, 31, null);
    }

    public static /* synthetic */ HomeCollectRelationBean copy$default(HomeCollectRelationBean homeCollectRelationBean, int i, int i2, int i3, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = homeCollectRelationBean.questionId;
        }
        if ((i5 & 2) != 0) {
            i2 = homeCollectRelationBean.level;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = homeCollectRelationBean.id;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            str = homeCollectRelationBean.expectValue;
        }
        String str2 = str;
        if ((i5 & 16) != 0) {
            i4 = homeCollectRelationBean.collectTableId;
        }
        return homeCollectRelationBean.copy(i, i6, i7, str2, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getQuestionId() {
        return this.questionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExpectValue() {
        return this.expectValue;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCollectTableId() {
        return this.collectTableId;
    }

    public final HomeCollectRelationBean copy(int questionId, int level, int id, String expectValue, int collectTableId) {
        Intrinsics.checkNotNullParameter(expectValue, "expectValue");
        return new HomeCollectRelationBean(questionId, level, id, expectValue, collectTableId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeCollectRelationBean)) {
            return false;
        }
        HomeCollectRelationBean homeCollectRelationBean = (HomeCollectRelationBean) other;
        return this.questionId == homeCollectRelationBean.questionId && this.level == homeCollectRelationBean.level && this.id == homeCollectRelationBean.id && Intrinsics.areEqual(this.expectValue, homeCollectRelationBean.expectValue) && this.collectTableId == homeCollectRelationBean.collectTableId;
    }

    public int hashCode() {
        return (((((((this.questionId * 31) + this.level) * 31) + this.id) * 31) + this.expectValue.hashCode()) * 31) + this.collectTableId;
    }

    public String toString() {
        return "HomeCollectRelationBean(questionId=" + this.questionId + ", level=" + this.level + ", id=" + this.id + ", expectValue=" + this.expectValue + ", collectTableId=" + this.collectTableId + ')';
    }

    public HomeCollectRelationBean(int i, int i2, int i3, String expectValue, int i4) {
        Intrinsics.checkNotNullParameter(expectValue, "expectValue");
        this.questionId = i;
        this.level = i2;
        this.id = i3;
        this.expectValue = expectValue;
        this.collectTableId = i4;
    }

    public /* synthetic */ HomeCollectRelationBean(int i, int i2, int i3, String str, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? "" : str, (i5 & 16) != 0 ? 0 : i4);
    }

    public final int getQuestionId() {
        return this.questionId;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getId() {
        return this.id;
    }

    public final String getExpectValue() {
        return this.expectValue;
    }

    public final int getCollectTableId() {
        return this.collectTableId;
    }
}
