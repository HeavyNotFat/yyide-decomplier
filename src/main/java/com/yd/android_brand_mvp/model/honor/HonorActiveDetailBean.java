package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001c\b\u0003\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001c\b\u0003\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\t\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\u001c\b\u0003\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\t\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0014HÆ\u0003J\t\u0010@\u001a\u00020\u0014HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u001d\u0010D\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010E\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\tHÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u001d\u0010J\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\tHÆ\u0003Jå\u0001\u0010K\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u001c\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0003\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0003\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\t2\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\u001c\b\u0003\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\t2\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u0015\u001a\u00020\u00142\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0014HÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0015\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001c¨\u0006Q"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "Ljava/io/Serializable;", "activityTime", "", "canScore", "", "canScoreGrade", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreGrade;", "Lkotlin/collections/ArrayList;", "gradeList", "canScoreStudent", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreStudent;", a.h, "id", "promotionalImage", "ruleList", "Lcom/yd/android_brand_mvp/model/honor/HonorRuleGroup;", "schoolId", "scoringMethod", "", "status", "statusTranslate", "title", "(Ljava/lang/String;ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getActivityTime", "()Ljava/lang/String;", "setActivityTime", "(Ljava/lang/String;)V", "getCanScore", "()Z", "setCanScore", "(Z)V", "getCanScoreGrade", "()Ljava/util/ArrayList;", "setCanScoreGrade", "(Ljava/util/ArrayList;)V", "getCanScoreStudent", "setCanScoreStudent", "getDescription", "setDescription", "getGradeList", "setGradeList", "getId", "setId", "getPromotionalImage", "setPromotionalImage", "getRuleList", "setRuleList", "getSchoolId", "setSchoolId", "getScoringMethod", "()I", "setScoringMethod", "(I)V", "getStatus", "setStatus", "getStatusTranslate", "setStatusTranslate", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorActiveDetailBean implements Serializable {
    private String activityTime;
    private boolean canScore;
    private ArrayList<HonorCanScoreGrade> canScoreGrade;
    private ArrayList<HonorCanScoreStudent> canScoreStudent;
    private String description;
    private ArrayList<HonorCanScoreGrade> gradeList;
    private String id;
    private String promotionalImage;
    private ArrayList<HonorRuleGroup> ruleList;
    private String schoolId;
    private int scoringMethod;
    private int status;
    private String statusTranslate;
    private String title;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityTime() {
        return this.activityTime;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getScoringMethod() {
        return this.scoringMethod;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getStatusTranslate() {
        return this.statusTranslate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanScore() {
        return this.canScore;
    }

    public final ArrayList<HonorCanScoreGrade> component3() {
        return this.canScoreGrade;
    }

    public final ArrayList<HonorCanScoreGrade> component4() {
        return this.gradeList;
    }

    public final ArrayList<HonorCanScoreStudent> component5() {
        return this.canScoreStudent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPromotionalImage() {
        return this.promotionalImage;
    }

    public final ArrayList<HonorRuleGroup> component9() {
        return this.ruleList;
    }

    public final HonorActiveDetailBean copy(@JSONField(name = "activityTime") String activityTime, @JSONField(name = "canScore") boolean canScore, @JSONField(name = "canScoreGrade") ArrayList<HonorCanScoreGrade> canScoreGrade, @JSONField(name = "gradeList") ArrayList<HonorCanScoreGrade> gradeList, @JSONField(name = "canScoreStudent") ArrayList<HonorCanScoreStudent> canScoreStudent, @JSONField(name = a.h) String description, @JSONField(name = "id") String id, @JSONField(name = "promotionalImage") String promotionalImage, @JSONField(name = "ruleGroupList") ArrayList<HonorRuleGroup> ruleList, @JSONField(name = "schoolId") String schoolId, @JSONField(name = "scoringMethod") int scoringMethod, @JSONField(name = "status") int status, @JSONField(name = "statusTranslate") String statusTranslate, @JSONField(name = "title") String title) {
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(promotionalImage, "promotionalImage");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(statusTranslate, "statusTranslate");
        Intrinsics.checkNotNullParameter(title, "title");
        return new HonorActiveDetailBean(activityTime, canScore, canScoreGrade, gradeList, canScoreStudent, description, id, promotionalImage, ruleList, schoolId, scoringMethod, status, statusTranslate, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorActiveDetailBean)) {
            return false;
        }
        HonorActiveDetailBean honorActiveDetailBean = (HonorActiveDetailBean) other;
        return Intrinsics.areEqual(this.activityTime, honorActiveDetailBean.activityTime) && this.canScore == honorActiveDetailBean.canScore && Intrinsics.areEqual(this.canScoreGrade, honorActiveDetailBean.canScoreGrade) && Intrinsics.areEqual(this.gradeList, honorActiveDetailBean.gradeList) && Intrinsics.areEqual(this.canScoreStudent, honorActiveDetailBean.canScoreStudent) && Intrinsics.areEqual(this.description, honorActiveDetailBean.description) && Intrinsics.areEqual(this.id, honorActiveDetailBean.id) && Intrinsics.areEqual(this.promotionalImage, honorActiveDetailBean.promotionalImage) && Intrinsics.areEqual(this.ruleList, honorActiveDetailBean.ruleList) && Intrinsics.areEqual(this.schoolId, honorActiveDetailBean.schoolId) && this.scoringMethod == honorActiveDetailBean.scoringMethod && this.status == honorActiveDetailBean.status && Intrinsics.areEqual(this.statusTranslate, honorActiveDetailBean.statusTranslate) && Intrinsics.areEqual(this.title, honorActiveDetailBean.title);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    public int hashCode() {
        int iHashCode = this.activityTime.hashCode() * 31;
        boolean z = this.canScore;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        ArrayList<HonorCanScoreGrade> arrayList = this.canScoreGrade;
        int iHashCode2 = (i + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<HonorCanScoreGrade> arrayList2 = this.gradeList;
        int iHashCode3 = (iHashCode2 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<HonorCanScoreStudent> arrayList3 = this.canScoreStudent;
        int iHashCode4 = (((((((iHashCode3 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31) + this.description.hashCode()) * 31) + this.id.hashCode()) * 31) + this.promotionalImage.hashCode()) * 31;
        ArrayList<HonorRuleGroup> arrayList4 = this.ruleList;
        return ((((((((((iHashCode4 + (arrayList4 != null ? arrayList4.hashCode() : 0)) * 31) + this.schoolId.hashCode()) * 31) + this.scoringMethod) * 31) + this.status) * 31) + this.statusTranslate.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "HonorActiveDetailBean(activityTime=" + this.activityTime + ", canScore=" + this.canScore + ", canScoreGrade=" + this.canScoreGrade + ", gradeList=" + this.gradeList + ", canScoreStudent=" + this.canScoreStudent + ", description=" + this.description + ", id=" + this.id + ", promotionalImage=" + this.promotionalImage + ", ruleList=" + this.ruleList + ", schoolId=" + this.schoolId + ", scoringMethod=" + this.scoringMethod + ", status=" + this.status + ", statusTranslate=" + this.statusTranslate + ", title=" + this.title + ')';
    }

    public HonorActiveDetailBean(@JSONField(name = "activityTime") String activityTime, @JSONField(name = "canScore") boolean z, @JSONField(name = "canScoreGrade") ArrayList<HonorCanScoreGrade> arrayList, @JSONField(name = "gradeList") ArrayList<HonorCanScoreGrade> arrayList2, @JSONField(name = "canScoreStudent") ArrayList<HonorCanScoreStudent> arrayList3, @JSONField(name = a.h) String description, @JSONField(name = "id") String id, @JSONField(name = "promotionalImage") String promotionalImage, @JSONField(name = "ruleGroupList") ArrayList<HonorRuleGroup> arrayList4, @JSONField(name = "schoolId") String schoolId, @JSONField(name = "scoringMethod") int i, @JSONField(name = "status") int i2, @JSONField(name = "statusTranslate") String statusTranslate, @JSONField(name = "title") String title) {
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(promotionalImage, "promotionalImage");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(statusTranslate, "statusTranslate");
        Intrinsics.checkNotNullParameter(title, "title");
        this.activityTime = activityTime;
        this.canScore = z;
        this.canScoreGrade = arrayList;
        this.gradeList = arrayList2;
        this.canScoreStudent = arrayList3;
        this.description = description;
        this.id = id;
        this.promotionalImage = promotionalImage;
        this.ruleList = arrayList4;
        this.schoolId = schoolId;
        this.scoringMethod = i;
        this.status = i2;
        this.statusTranslate = statusTranslate;
        this.title = title;
    }

    public /* synthetic */ HonorActiveDetailBean(String str, boolean z, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, String str2, String str3, String str4, ArrayList arrayList4, String str5, int i, int i2, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i3 & 4) != 0 ? null : arrayList, (i3 & 8) != 0 ? null : arrayList2, (i3 & 16) != 0 ? null : arrayList3, str2, str3, str4, (i3 & 256) != 0 ? null : arrayList4, str5, i, i2, str6, str7);
    }

    public final String getActivityTime() {
        return this.activityTime;
    }

    public final void setActivityTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityTime = str;
    }

    public final boolean getCanScore() {
        return this.canScore;
    }

    public final void setCanScore(boolean z) {
        this.canScore = z;
    }

    public final ArrayList<HonorCanScoreGrade> getCanScoreGrade() {
        return this.canScoreGrade;
    }

    public final void setCanScoreGrade(ArrayList<HonorCanScoreGrade> arrayList) {
        this.canScoreGrade = arrayList;
    }

    public final ArrayList<HonorCanScoreGrade> getGradeList() {
        return this.gradeList;
    }

    public final void setGradeList(ArrayList<HonorCanScoreGrade> arrayList) {
        this.gradeList = arrayList;
    }

    public final ArrayList<HonorCanScoreStudent> getCanScoreStudent() {
        return this.canScoreStudent;
    }

    public final void setCanScoreStudent(ArrayList<HonorCanScoreStudent> arrayList) {
        this.canScoreStudent = arrayList;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getPromotionalImage() {
        return this.promotionalImage;
    }

    public final void setPromotionalImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.promotionalImage = str;
    }

    public final ArrayList<HonorRuleGroup> getRuleList() {
        return this.ruleList;
    }

    public final void setRuleList(ArrayList<HonorRuleGroup> arrayList) {
        this.ruleList = arrayList;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final void setSchoolId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolId = str;
    }

    public final int getScoringMethod() {
        return this.scoringMethod;
    }

    public final void setScoringMethod(int i) {
        this.scoringMethod = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final String getStatusTranslate() {
        return this.statusTranslate;
    }

    public final void setStatusTranslate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusTranslate = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
