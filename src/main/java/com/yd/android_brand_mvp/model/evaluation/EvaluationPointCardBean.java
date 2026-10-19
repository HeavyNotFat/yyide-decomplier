package com.yd.android_brand_mvp.model.evaluation;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationPointCardBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0012HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J¯\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0012HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006?"}, d2 = {"Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardBean;", "", "evalTypeId", "", "evalTypeName", "groupNameList", "", "personId", "personName", "schoolId", FirebaseAnalytics.Param.SCORE, "medalCode", "medalIconUrl", "medalName", "scoreCardId", "scoreCardName", "scoreCardIconUrl", "writeOffStatus", "", "writeOffTime", "issuanceTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEvalTypeId", "()Ljava/lang/String;", "getEvalTypeName", "getGroupNameList", "()Ljava/util/List;", "getIssuanceTime", "getMedalCode", "getMedalIconUrl", "getMedalName", "getPersonId", "getPersonName", "getSchoolId", "getScore", "getScoreCardIconUrl", "getScoreCardId", "getScoreCardName", "getWriteOffStatus", "()I", "getWriteOffTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationPointCardBean {
    private final String evalTypeId;
    private final String evalTypeName;
    private final List<String> groupNameList;
    private final String issuanceTime;
    private final String medalCode;
    private final String medalIconUrl;
    private final String medalName;
    private final String personId;
    private final String personName;
    private final String schoolId;
    private final String score;
    private final String scoreCardIconUrl;
    private final String scoreCardId;
    private final String scoreCardName;
    private final int writeOffStatus;
    private final String writeOffTime;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMedalName() {
        return this.medalName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getScoreCardId() {
        return this.scoreCardId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getScoreCardName() {
        return this.scoreCardName;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getScoreCardIconUrl() {
        return this.scoreCardIconUrl;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getWriteOffStatus() {
        return this.writeOffStatus;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getWriteOffTime() {
        return this.writeOffTime;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getIssuanceTime() {
        return this.issuanceTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    public final List<String> component3() {
        return this.groupNameList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPersonId() {
        return this.personId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPersonName() {
        return this.personName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMedalCode() {
        return this.medalCode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMedalIconUrl() {
        return this.medalIconUrl;
    }

    public final EvaluationPointCardBean copy(String evalTypeId, String evalTypeName, List<String> groupNameList, String personId, String personName, String schoolId, String score, String medalCode, String medalIconUrl, String medalName, String scoreCardId, String scoreCardName, String scoreCardIconUrl, int writeOffStatus, String writeOffTime, String issuanceTime) {
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        Intrinsics.checkNotNullParameter(groupNameList, "groupNameList");
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(medalCode, "medalCode");
        Intrinsics.checkNotNullParameter(medalIconUrl, "medalIconUrl");
        Intrinsics.checkNotNullParameter(medalName, "medalName");
        Intrinsics.checkNotNullParameter(scoreCardId, "scoreCardId");
        Intrinsics.checkNotNullParameter(scoreCardName, "scoreCardName");
        Intrinsics.checkNotNullParameter(scoreCardIconUrl, "scoreCardIconUrl");
        Intrinsics.checkNotNullParameter(writeOffTime, "writeOffTime");
        Intrinsics.checkNotNullParameter(issuanceTime, "issuanceTime");
        return new EvaluationPointCardBean(evalTypeId, evalTypeName, groupNameList, personId, personName, schoolId, score, medalCode, medalIconUrl, medalName, scoreCardId, scoreCardName, scoreCardIconUrl, writeOffStatus, writeOffTime, issuanceTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationPointCardBean)) {
            return false;
        }
        EvaluationPointCardBean evaluationPointCardBean = (EvaluationPointCardBean) other;
        return Intrinsics.areEqual(this.evalTypeId, evaluationPointCardBean.evalTypeId) && Intrinsics.areEqual(this.evalTypeName, evaluationPointCardBean.evalTypeName) && Intrinsics.areEqual(this.groupNameList, evaluationPointCardBean.groupNameList) && Intrinsics.areEqual(this.personId, evaluationPointCardBean.personId) && Intrinsics.areEqual(this.personName, evaluationPointCardBean.personName) && Intrinsics.areEqual(this.schoolId, evaluationPointCardBean.schoolId) && Intrinsics.areEqual(this.score, evaluationPointCardBean.score) && Intrinsics.areEqual(this.medalCode, evaluationPointCardBean.medalCode) && Intrinsics.areEqual(this.medalIconUrl, evaluationPointCardBean.medalIconUrl) && Intrinsics.areEqual(this.medalName, evaluationPointCardBean.medalName) && Intrinsics.areEqual(this.scoreCardId, evaluationPointCardBean.scoreCardId) && Intrinsics.areEqual(this.scoreCardName, evaluationPointCardBean.scoreCardName) && Intrinsics.areEqual(this.scoreCardIconUrl, evaluationPointCardBean.scoreCardIconUrl) && this.writeOffStatus == evaluationPointCardBean.writeOffStatus && Intrinsics.areEqual(this.writeOffTime, evaluationPointCardBean.writeOffTime) && Intrinsics.areEqual(this.issuanceTime, evaluationPointCardBean.issuanceTime);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.evalTypeId.hashCode() * 31) + this.evalTypeName.hashCode()) * 31) + this.groupNameList.hashCode()) * 31) + this.personId.hashCode()) * 31) + this.personName.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.score.hashCode()) * 31) + this.medalCode.hashCode()) * 31) + this.medalIconUrl.hashCode()) * 31) + this.medalName.hashCode()) * 31) + this.scoreCardId.hashCode()) * 31) + this.scoreCardName.hashCode()) * 31) + this.scoreCardIconUrl.hashCode()) * 31) + this.writeOffStatus) * 31) + this.writeOffTime.hashCode()) * 31) + this.issuanceTime.hashCode();
    }

    public String toString() {
        return "EvaluationPointCardBean(evalTypeId=" + this.evalTypeId + ", evalTypeName=" + this.evalTypeName + ", groupNameList=" + this.groupNameList + ", personId=" + this.personId + ", personName=" + this.personName + ", schoolId=" + this.schoolId + ", score=" + this.score + ", medalCode=" + this.medalCode + ", medalIconUrl=" + this.medalIconUrl + ", medalName=" + this.medalName + ", scoreCardId=" + this.scoreCardId + ", scoreCardName=" + this.scoreCardName + ", scoreCardIconUrl=" + this.scoreCardIconUrl + ", writeOffStatus=" + this.writeOffStatus + ", writeOffTime=" + this.writeOffTime + ", issuanceTime=" + this.issuanceTime + ')';
    }

    public EvaluationPointCardBean(String evalTypeId, String evalTypeName, List<String> groupNameList, String personId, String personName, String schoolId, String score, String medalCode, String medalIconUrl, String medalName, String scoreCardId, String scoreCardName, String scoreCardIconUrl, int i, String writeOffTime, String issuanceTime) {
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        Intrinsics.checkNotNullParameter(groupNameList, "groupNameList");
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(medalCode, "medalCode");
        Intrinsics.checkNotNullParameter(medalIconUrl, "medalIconUrl");
        Intrinsics.checkNotNullParameter(medalName, "medalName");
        Intrinsics.checkNotNullParameter(scoreCardId, "scoreCardId");
        Intrinsics.checkNotNullParameter(scoreCardName, "scoreCardName");
        Intrinsics.checkNotNullParameter(scoreCardIconUrl, "scoreCardIconUrl");
        Intrinsics.checkNotNullParameter(writeOffTime, "writeOffTime");
        Intrinsics.checkNotNullParameter(issuanceTime, "issuanceTime");
        this.evalTypeId = evalTypeId;
        this.evalTypeName = evalTypeName;
        this.groupNameList = groupNameList;
        this.personId = personId;
        this.personName = personName;
        this.schoolId = schoolId;
        this.score = score;
        this.medalCode = medalCode;
        this.medalIconUrl = medalIconUrl;
        this.medalName = medalName;
        this.scoreCardId = scoreCardId;
        this.scoreCardName = scoreCardName;
        this.scoreCardIconUrl = scoreCardIconUrl;
        this.writeOffStatus = i;
        this.writeOffTime = writeOffTime;
        this.issuanceTime = issuanceTime;
    }

    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    public final List<String> getGroupNameList() {
        return this.groupNameList;
    }

    public final String getPersonId() {
        return this.personId;
    }

    public final String getPersonName() {
        return this.personName;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getScore() {
        return this.score;
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

    public final String getScoreCardId() {
        return this.scoreCardId;
    }

    public final String getScoreCardName() {
        return this.scoreCardName;
    }

    public final String getScoreCardIconUrl() {
        return this.scoreCardIconUrl;
    }

    public final int getWriteOffStatus() {
        return this.writeOffStatus;
    }

    public final String getWriteOffTime() {
        return this.writeOffTime;
    }

    public final String getIssuanceTime() {
        return this.issuanceTime;
    }
}
