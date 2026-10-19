package com.yd.android_brand_mvp.model.evaluation;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationPointBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J¹\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\rHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006B"}, d2 = {"Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointBean;", "", "createBy", "", "createTime", "evalTypeId", "convertedScore", "remainingScore", "evalTypeName", "groupNameList", "", "id", "identity", "", "personId", "personName", "schoolId", FirebaseAnalytics.Param.SCORE, "scoreFormat", "totalScore", "updateBy", "updateTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConvertedScore", "()Ljava/lang/String;", "getCreateBy", "getCreateTime", "getEvalTypeId", "getEvalTypeName", "getGroupNameList", "()Ljava/util/List;", "getId", "getIdentity", "()I", "getPersonId", "getPersonName", "getRemainingScore", "getSchoolId", "getScore", "getScoreFormat", "getTotalScore", "getUpdateBy", "getUpdateTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationPointBean {
    private final String convertedScore;
    private final String createBy;
    private final String createTime;
    private final String evalTypeId;
    private final String evalTypeName;
    private final List<String> groupNameList;
    private final String id;
    private final int identity;
    private final String personId;
    private final String personName;
    private final String remainingScore;
    private final String schoolId;
    private final String score;
    private final int scoreFormat;
    private final String totalScore;
    private final String updateBy;
    private final String updateTime;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCreateBy() {
        return this.createBy;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPersonId() {
        return this.personId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPersonName() {
        return this.personName;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getScoreFormat() {
        return this.scoreFormat;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getTotalScore() {
        return this.totalScore;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getUpdateBy() {
        return this.updateBy;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getConvertedScore() {
        return this.convertedScore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRemainingScore() {
        return this.remainingScore;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    public final List<String> component7() {
        return this.groupNameList;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getIdentity() {
        return this.identity;
    }

    public final EvaluationPointBean copy(String createBy, String createTime, String evalTypeId, String convertedScore, String remainingScore, String evalTypeName, List<String> groupNameList, String id, int identity, String personId, String personName, String schoolId, String score, int scoreFormat, String totalScore, String updateBy, String updateTime) {
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(convertedScore, "convertedScore");
        Intrinsics.checkNotNullParameter(remainingScore, "remainingScore");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        Intrinsics.checkNotNullParameter(groupNameList, "groupNameList");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(totalScore, "totalScore");
        Intrinsics.checkNotNullParameter(updateBy, "updateBy");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        return new EvaluationPointBean(createBy, createTime, evalTypeId, convertedScore, remainingScore, evalTypeName, groupNameList, id, identity, personId, personName, schoolId, score, scoreFormat, totalScore, updateBy, updateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationPointBean)) {
            return false;
        }
        EvaluationPointBean evaluationPointBean = (EvaluationPointBean) other;
        return Intrinsics.areEqual(this.createBy, evaluationPointBean.createBy) && Intrinsics.areEqual(this.createTime, evaluationPointBean.createTime) && Intrinsics.areEqual(this.evalTypeId, evaluationPointBean.evalTypeId) && Intrinsics.areEqual(this.convertedScore, evaluationPointBean.convertedScore) && Intrinsics.areEqual(this.remainingScore, evaluationPointBean.remainingScore) && Intrinsics.areEqual(this.evalTypeName, evaluationPointBean.evalTypeName) && Intrinsics.areEqual(this.groupNameList, evaluationPointBean.groupNameList) && Intrinsics.areEqual(this.id, evaluationPointBean.id) && this.identity == evaluationPointBean.identity && Intrinsics.areEqual(this.personId, evaluationPointBean.personId) && Intrinsics.areEqual(this.personName, evaluationPointBean.personName) && Intrinsics.areEqual(this.schoolId, evaluationPointBean.schoolId) && Intrinsics.areEqual(this.score, evaluationPointBean.score) && this.scoreFormat == evaluationPointBean.scoreFormat && Intrinsics.areEqual(this.totalScore, evaluationPointBean.totalScore) && Intrinsics.areEqual(this.updateBy, evaluationPointBean.updateBy) && Intrinsics.areEqual(this.updateTime, evaluationPointBean.updateTime);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.createBy.hashCode() * 31) + this.createTime.hashCode()) * 31) + this.evalTypeId.hashCode()) * 31) + this.convertedScore.hashCode()) * 31) + this.remainingScore.hashCode()) * 31) + this.evalTypeName.hashCode()) * 31) + this.groupNameList.hashCode()) * 31) + this.id.hashCode()) * 31) + this.identity) * 31) + this.personId.hashCode()) * 31) + this.personName.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.score.hashCode()) * 31) + this.scoreFormat) * 31) + this.totalScore.hashCode()) * 31) + this.updateBy.hashCode()) * 31) + this.updateTime.hashCode();
    }

    public String toString() {
        return "EvaluationPointBean(createBy=" + this.createBy + ", createTime=" + this.createTime + ", evalTypeId=" + this.evalTypeId + ", convertedScore=" + this.convertedScore + ", remainingScore=" + this.remainingScore + ", evalTypeName=" + this.evalTypeName + ", groupNameList=" + this.groupNameList + ", id=" + this.id + ", identity=" + this.identity + ", personId=" + this.personId + ", personName=" + this.personName + ", schoolId=" + this.schoolId + ", score=" + this.score + ", scoreFormat=" + this.scoreFormat + ", totalScore=" + this.totalScore + ", updateBy=" + this.updateBy + ", updateTime=" + this.updateTime + ')';
    }

    public EvaluationPointBean(String createBy, String createTime, String evalTypeId, String convertedScore, String remainingScore, String evalTypeName, List<String> groupNameList, String id, int i, String personId, String personName, String schoolId, String score, int i2, String totalScore, String updateBy, String updateTime) {
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(convertedScore, "convertedScore");
        Intrinsics.checkNotNullParameter(remainingScore, "remainingScore");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        Intrinsics.checkNotNullParameter(groupNameList, "groupNameList");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(totalScore, "totalScore");
        Intrinsics.checkNotNullParameter(updateBy, "updateBy");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        this.createBy = createBy;
        this.createTime = createTime;
        this.evalTypeId = evalTypeId;
        this.convertedScore = convertedScore;
        this.remainingScore = remainingScore;
        this.evalTypeName = evalTypeName;
        this.groupNameList = groupNameList;
        this.id = id;
        this.identity = i;
        this.personId = personId;
        this.personName = personName;
        this.schoolId = schoolId;
        this.score = score;
        this.scoreFormat = i2;
        this.totalScore = totalScore;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public final String getCreateBy() {
        return this.createBy;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    public final String getConvertedScore() {
        return this.convertedScore;
    }

    public final String getRemainingScore() {
        return this.remainingScore;
    }

    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    public final List<String> getGroupNameList() {
        return this.groupNameList;
    }

    public final String getId() {
        return this.id;
    }

    public final int getIdentity() {
        return this.identity;
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

    public final int getScoreFormat() {
        return this.scoreFormat;
    }

    public final String getTotalScore() {
        return this.totalScore;
    }

    public final String getUpdateBy() {
        return this.updateBy;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }
}
