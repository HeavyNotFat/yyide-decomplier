package com.yd.android_brand_mvp.model.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.heytap.mcssdk.a.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeCollectBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/HomeCollectBean;", "", "todayAlreadyDid", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", a.h, "todayGonnaDo", "id", "formId", "questionList", "", "Lcom/yd/android_brand_mvp/model/collect/QuestionListItem;", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getFormId", "getId", "getName", "getQuestionList", "()Ljava/util/List;", "getTodayAlreadyDid", "()I", "getTodayGonnaDo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeCollectBean {
    private final String description;
    private final String formId;
    private final String id;
    private final String name;
    private final List<QuestionListItem> questionList;
    private final int todayAlreadyDid;
    private final int todayGonnaDo;

    public HomeCollectBean() {
        this(0, null, null, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeCollectBean copy$default(HomeCollectBean homeCollectBean, int i, String str, String str2, int i2, String str3, String str4, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = homeCollectBean.todayAlreadyDid;
        }
        if ((i3 & 2) != 0) {
            str = homeCollectBean.name;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = homeCollectBean.description;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            i2 = homeCollectBean.todayGonnaDo;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str3 = homeCollectBean.id;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = homeCollectBean.formId;
        }
        String str8 = str4;
        if ((i3 & 64) != 0) {
            list = homeCollectBean.questionList;
        }
        return homeCollectBean.copy(i, str5, str6, i4, str7, str8, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTodayAlreadyDid() {
        return this.todayAlreadyDid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTodayGonnaDo() {
        return this.todayGonnaDo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFormId() {
        return this.formId;
    }

    public final List<QuestionListItem> component7() {
        return this.questionList;
    }

    public final HomeCollectBean copy(int todayAlreadyDid, String name, String description, int todayGonnaDo, String id, String formId, List<QuestionListItem> questionList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(formId, "formId");
        Intrinsics.checkNotNullParameter(questionList, "questionList");
        return new HomeCollectBean(todayAlreadyDid, name, description, todayGonnaDo, id, formId, questionList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeCollectBean)) {
            return false;
        }
        HomeCollectBean homeCollectBean = (HomeCollectBean) other;
        return this.todayAlreadyDid == homeCollectBean.todayAlreadyDid && Intrinsics.areEqual(this.name, homeCollectBean.name) && Intrinsics.areEqual(this.description, homeCollectBean.description) && this.todayGonnaDo == homeCollectBean.todayGonnaDo && Intrinsics.areEqual(this.id, homeCollectBean.id) && Intrinsics.areEqual(this.formId, homeCollectBean.formId) && Intrinsics.areEqual(this.questionList, homeCollectBean.questionList);
    }

    public int hashCode() {
        return (((((((((((this.todayAlreadyDid * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.todayGonnaDo) * 31) + this.id.hashCode()) * 31) + this.formId.hashCode()) * 31) + this.questionList.hashCode();
    }

    public String toString() {
        return "HomeCollectBean(todayAlreadyDid=" + this.todayAlreadyDid + ", name=" + this.name + ", description=" + this.description + ", todayGonnaDo=" + this.todayGonnaDo + ", id=" + this.id + ", formId=" + this.formId + ", questionList=" + this.questionList + ')';
    }

    public HomeCollectBean(int i, String name, String description, int i2, String id, String formId, List<QuestionListItem> questionList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(formId, "formId");
        Intrinsics.checkNotNullParameter(questionList, "questionList");
        this.todayAlreadyDid = i;
        this.name = name;
        this.description = description;
        this.todayGonnaDo = i2;
        this.id = id;
        this.formId = formId;
        this.questionList = questionList;
    }

    public final int getTodayAlreadyDid() {
        return this.todayAlreadyDid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getTodayGonnaDo() {
        return this.todayGonnaDo;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFormId() {
        return this.formId;
    }

    public /* synthetic */ HomeCollectBean(int i, String str, String str2, int i2, String str3, String str4, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str3, (i3 & 32) == 0 ? str4 : "", (i3 & 64) != 0 ? new ArrayList() : arrayList);
    }

    public final List<QuestionListItem> getQuestionList() {
        return this.questionList;
    }
}
