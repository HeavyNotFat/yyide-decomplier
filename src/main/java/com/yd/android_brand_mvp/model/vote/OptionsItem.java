package com.yd.android_brand_mvp.model.vote;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptionsItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0011HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J}\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u00065"}, d2 = {"Lcom/yd/android_brand_mvp/model/vote/OptionsItem;", "", "schoolId", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "files", "", "Lcom/yd/android_brand_mvp/model/vote/FilesItem;", "id", "sort", "", "voteId", "title", "desc", "countNum", "selectNum", "isSelect", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getCountNum", "()I", "getDesc", "()Ljava/lang/String;", "getFiles", "()Ljava/util/List;", "getId", "()Z", "setSelect", "(Z)V", "getName", "getSchoolId", "getSelectNum", "setSelectNum", "(I)V", "getSort", "getTitle", "getVoteId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OptionsItem {
    private final int countNum;
    private final String desc;
    private final List<FilesItem> files;
    private final String id;
    private boolean isSelect;
    private final String name;
    private final String schoolId;
    private int selectNum;
    private final int sort;
    private final String title;
    private final String voteId;

    public OptionsItem() {
        this(null, null, null, null, 0, null, null, null, 0, 0, false, 2047, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getSelectNum() {
        return this.selectNum;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<FilesItem> component3() {
        return this.files;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVoteId() {
        return this.voteId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getCountNum() {
        return this.countNum;
    }

    public final OptionsItem copy(String schoolId, String name, List<FilesItem> files, String id, int sort, String voteId, String title, String desc, int countNum, int selectNum, boolean isSelect) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(voteId, "voteId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new OptionsItem(schoolId, name, files, id, sort, voteId, title, desc, countNum, selectNum, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionsItem)) {
            return false;
        }
        OptionsItem optionsItem = (OptionsItem) other;
        return Intrinsics.areEqual(this.schoolId, optionsItem.schoolId) && Intrinsics.areEqual(this.name, optionsItem.name) && Intrinsics.areEqual(this.files, optionsItem.files) && Intrinsics.areEqual(this.id, optionsItem.id) && this.sort == optionsItem.sort && Intrinsics.areEqual(this.voteId, optionsItem.voteId) && Intrinsics.areEqual(this.title, optionsItem.title) && Intrinsics.areEqual(this.desc, optionsItem.desc) && this.countNum == optionsItem.countNum && this.selectNum == optionsItem.selectNum && this.isSelect == optionsItem.isSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.schoolId.hashCode() * 31) + this.name.hashCode()) * 31) + this.files.hashCode()) * 31) + this.id.hashCode()) * 31) + this.sort) * 31) + this.voteId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.countNum) * 31) + this.selectNum) * 31;
        boolean z = this.isSelect;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "OptionsItem(schoolId=" + this.schoolId + ", name=" + this.name + ", files=" + this.files + ", id=" + this.id + ", sort=" + this.sort + ", voteId=" + this.voteId + ", title=" + this.title + ", desc=" + this.desc + ", countNum=" + this.countNum + ", selectNum=" + this.selectNum + ", isSelect=" + this.isSelect + ')';
    }

    public OptionsItem(String schoolId, String name, List<FilesItem> files, String id, int i, String voteId, String title, String desc, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(voteId, "voteId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.schoolId = schoolId;
        this.name = name;
        this.files = files;
        this.id = id;
        this.sort = i;
        this.voteId = voteId;
        this.title = title;
        this.desc = desc;
        this.countNum = i2;
        this.selectNum = i3;
        this.isSelect = z;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ OptionsItem(String str, String str2, List list, String str3, int i, String str4, String str5, String str6, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? new ArrayList() : list, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? "" : str4, (i4 & 64) != 0 ? "" : str5, (i4 & 128) == 0 ? str6 : "", (i4 & 256) != 0 ? 0 : i2, (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) == 0 ? z : false);
    }

    public final List<FilesItem> getFiles() {
        return this.files;
    }

    public final String getId() {
        return this.id;
    }

    public final int getSort() {
        return this.sort;
    }

    public final String getVoteId() {
        return this.voteId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getCountNum() {
        return this.countNum;
    }

    public final int getSelectNum() {
        return this.selectNum;
    }

    public final void setSelectNum(int i) {
        this.selectNum = i;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
