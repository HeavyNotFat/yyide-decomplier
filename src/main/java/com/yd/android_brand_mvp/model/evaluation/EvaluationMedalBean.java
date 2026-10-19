package com.yd.android_brand_mvp.model.evaluation;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationMedalBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0011HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\u0087\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00064"}, d2 = {"Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalBean;", "", "evalTypeId", "", "evalTypeName", "getTime", "groupNameList", "", "issuanceMethod", "", "medalCode", "medalIconUrl", "medalName", "medalScore", "personName", "schoolId", "owned", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getEvalTypeId", "()Ljava/lang/String;", "getEvalTypeName", "getGetTime", "getGroupNameList", "()Ljava/util/List;", "getIssuanceMethod", "()I", "getMedalCode", "getMedalIconUrl", "getMedalName", "getMedalScore", "getOwned", "()Z", "getPersonName", "getSchoolId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationMedalBean {
    private final String evalTypeId;
    private final String evalTypeName;
    private final String getTime;
    private final List<String> groupNameList;
    private final int issuanceMethod;
    private final String medalCode;
    private final String medalIconUrl;
    private final String medalName;
    private final int medalScore;
    private final boolean owned;
    private final String personName;
    private final String schoolId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPersonName() {
        return this.personName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getOwned() {
        return this.owned;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGetTime() {
        return this.getTime;
    }

    public final List<String> component4() {
        return this.groupNameList;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getIssuanceMethod() {
        return this.issuanceMethod;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMedalCode() {
        return this.medalCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMedalIconUrl() {
        return this.medalIconUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMedalName() {
        return this.medalName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getMedalScore() {
        return this.medalScore;
    }

    public final EvaluationMedalBean copy(String evalTypeId, String evalTypeName, String getTime, List<String> groupNameList, int issuanceMethod, String medalCode, String medalIconUrl, String medalName, int medalScore, String personName, String schoolId, boolean owned) {
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        Intrinsics.checkNotNullParameter(getTime, "getTime");
        Intrinsics.checkNotNullParameter(groupNameList, "groupNameList");
        Intrinsics.checkNotNullParameter(medalCode, "medalCode");
        Intrinsics.checkNotNullParameter(medalIconUrl, "medalIconUrl");
        Intrinsics.checkNotNullParameter(medalName, "medalName");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        return new EvaluationMedalBean(evalTypeId, evalTypeName, getTime, groupNameList, issuanceMethod, medalCode, medalIconUrl, medalName, medalScore, personName, schoolId, owned);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationMedalBean)) {
            return false;
        }
        EvaluationMedalBean evaluationMedalBean = (EvaluationMedalBean) other;
        return Intrinsics.areEqual(this.evalTypeId, evaluationMedalBean.evalTypeId) && Intrinsics.areEqual(this.evalTypeName, evaluationMedalBean.evalTypeName) && Intrinsics.areEqual(this.getTime, evaluationMedalBean.getTime) && Intrinsics.areEqual(this.groupNameList, evaluationMedalBean.groupNameList) && this.issuanceMethod == evaluationMedalBean.issuanceMethod && Intrinsics.areEqual(this.medalCode, evaluationMedalBean.medalCode) && Intrinsics.areEqual(this.medalIconUrl, evaluationMedalBean.medalIconUrl) && Intrinsics.areEqual(this.medalName, evaluationMedalBean.medalName) && this.medalScore == evaluationMedalBean.medalScore && Intrinsics.areEqual(this.personName, evaluationMedalBean.personName) && Intrinsics.areEqual(this.schoolId, evaluationMedalBean.schoolId) && this.owned == evaluationMedalBean.owned;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.evalTypeId.hashCode() * 31) + this.evalTypeName.hashCode()) * 31) + this.getTime.hashCode()) * 31) + this.groupNameList.hashCode()) * 31) + this.issuanceMethod) * 31) + this.medalCode.hashCode()) * 31) + this.medalIconUrl.hashCode()) * 31) + this.medalName.hashCode()) * 31) + this.medalScore) * 31) + this.personName.hashCode()) * 31) + this.schoolId.hashCode()) * 31;
        boolean z = this.owned;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "EvaluationMedalBean(evalTypeId=" + this.evalTypeId + ", evalTypeName=" + this.evalTypeName + ", getTime=" + this.getTime + ", groupNameList=" + this.groupNameList + ", issuanceMethod=" + this.issuanceMethod + ", medalCode=" + this.medalCode + ", medalIconUrl=" + this.medalIconUrl + ", medalName=" + this.medalName + ", medalScore=" + this.medalScore + ", personName=" + this.personName + ", schoolId=" + this.schoolId + ", owned=" + this.owned + ')';
    }

    public EvaluationMedalBean(String evalTypeId, String evalTypeName, String getTime, List<String> groupNameList, int i, String medalCode, String medalIconUrl, String medalName, int i2, String personName, String schoolId, boolean z) {
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        Intrinsics.checkNotNullParameter(getTime, "getTime");
        Intrinsics.checkNotNullParameter(groupNameList, "groupNameList");
        Intrinsics.checkNotNullParameter(medalCode, "medalCode");
        Intrinsics.checkNotNullParameter(medalIconUrl, "medalIconUrl");
        Intrinsics.checkNotNullParameter(medalName, "medalName");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        this.evalTypeId = evalTypeId;
        this.evalTypeName = evalTypeName;
        this.getTime = getTime;
        this.groupNameList = groupNameList;
        this.issuanceMethod = i;
        this.medalCode = medalCode;
        this.medalIconUrl = medalIconUrl;
        this.medalName = medalName;
        this.medalScore = i2;
        this.personName = personName;
        this.schoolId = schoolId;
        this.owned = z;
    }

    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    public final String getGetTime() {
        return this.getTime;
    }

    public final List<String> getGroupNameList() {
        return this.groupNameList;
    }

    public final int getIssuanceMethod() {
        return this.issuanceMethod;
    }

    public final String getMedalCode() {
        return this.medalCode;
    }

    public final String getMedalIconUrl() {
        return this.medalIconUrl;
    }

    public final String getMedalName() {
        return this.medalName;
    }

    public final int getMedalScore() {
        return this.medalScore;
    }

    public final String getPersonName() {
        return this.personName;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final boolean getOwned() {
        return this.owned;
    }
}
