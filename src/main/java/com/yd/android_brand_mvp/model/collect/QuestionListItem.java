package com.yd.android_brand_mvp.model.collect;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0010HÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/QuestionListItem;", "", "componentType", "", "showRule", "", "relationshipList", "", "Lcom/yd/android_brand_mvp/model/collect/HomeCollectRelationBean;", "optionList", "Lcom/yd/android_brand_mvp/model/collect/OptionListItem;", "showExpression", "id", "sort", "title", "required", "", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Z)V", "getComponentType", "()Ljava/lang/String;", "getId", "()I", "getOptionList", "()Ljava/util/List;", "getRelationshipList", "getRequired", "()Z", "getShowExpression", "getShowRule", "getSort", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class QuestionListItem {
    private final String componentType;
    private final int id;
    private final List<OptionListItem> optionList;
    private final List<HomeCollectRelationBean> relationshipList;
    private final boolean required;
    private final String showExpression;
    private final int showRule;
    private final int sort;
    private final String title;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getComponentType() {
        return this.componentType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getShowRule() {
        return this.showRule;
    }

    public final List<HomeCollectRelationBean> component3() {
        return this.relationshipList;
    }

    public final List<OptionListItem> component4() {
        return this.optionList;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getShowExpression() {
        return this.showExpression;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    public final QuestionListItem copy(String componentType, int showRule, List<HomeCollectRelationBean> relationshipList, List<OptionListItem> optionList, String showExpression, int id, int sort, String title, boolean required) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(relationshipList, "relationshipList");
        Intrinsics.checkNotNullParameter(showExpression, "showExpression");
        Intrinsics.checkNotNullParameter(title, "title");
        return new QuestionListItem(componentType, showRule, relationshipList, optionList, showExpression, id, sort, title, required);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionListItem)) {
            return false;
        }
        QuestionListItem questionListItem = (QuestionListItem) other;
        return Intrinsics.areEqual(this.componentType, questionListItem.componentType) && this.showRule == questionListItem.showRule && Intrinsics.areEqual(this.relationshipList, questionListItem.relationshipList) && Intrinsics.areEqual(this.optionList, questionListItem.optionList) && Intrinsics.areEqual(this.showExpression, questionListItem.showExpression) && this.id == questionListItem.id && this.sort == questionListItem.sort && Intrinsics.areEqual(this.title, questionListItem.title) && this.required == questionListItem.required;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public int hashCode() {
        int iHashCode = ((((this.componentType.hashCode() * 31) + this.showRule) * 31) + this.relationshipList.hashCode()) * 31;
        List<OptionListItem> list = this.optionList;
        int iHashCode2 = (((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.showExpression.hashCode()) * 31) + this.id) * 31) + this.sort) * 31) + this.title.hashCode()) * 31;
        boolean z = this.required;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        return "QuestionListItem(componentType=" + this.componentType + ", showRule=" + this.showRule + ", relationshipList=" + this.relationshipList + ", optionList=" + this.optionList + ", showExpression=" + this.showExpression + ", id=" + this.id + ", sort=" + this.sort + ", title=" + this.title + ", required=" + this.required + ')';
    }

    public QuestionListItem(String componentType, int i, List<HomeCollectRelationBean> relationshipList, List<OptionListItem> list, String showExpression, int i2, int i3, String title, boolean z) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(relationshipList, "relationshipList");
        Intrinsics.checkNotNullParameter(showExpression, "showExpression");
        Intrinsics.checkNotNullParameter(title, "title");
        this.componentType = componentType;
        this.showRule = i;
        this.relationshipList = relationshipList;
        this.optionList = list;
        this.showExpression = showExpression;
        this.id = i2;
        this.sort = i3;
        this.title = title;
        this.required = z;
    }

    public final String getComponentType() {
        return this.componentType;
    }

    public final int getShowRule() {
        return this.showRule;
    }

    public /* synthetic */ QuestionListItem(String str, int i, List list, List list2, String str2, int i2, int i3, String str3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? new ArrayList() : list, list2, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) != 0 ? 0 : i3, (i4 & 128) != 0 ? "" : str3, (i4 & 256) != 0 ? false : z);
    }

    public final List<HomeCollectRelationBean> getRelationshipList() {
        return this.relationshipList;
    }

    public final List<OptionListItem> getOptionList() {
        return this.optionList;
    }

    public final String getShowExpression() {
        return this.showExpression;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSort() {
        return this.sort;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getRequired() {
        return this.required;
    }
}
