package com.yd.android_brand_mvp.landscape.blackboard;

import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlackBoardModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardModel;", "", "subjectName", "", "time", "filePath", TUIKitConstants.Selection.LIST, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getSubjectName", "setSubjectName", "getTime", "setTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BlackBoardModel {
    private String filePath;
    private List<BlackBoardModel> list;
    private String subjectName;
    private String time;

    public BlackBoardModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlackBoardModel copy$default(BlackBoardModel blackBoardModel, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blackBoardModel.subjectName;
        }
        if ((i & 2) != 0) {
            str2 = blackBoardModel.time;
        }
        if ((i & 4) != 0) {
            str3 = blackBoardModel.filePath;
        }
        if ((i & 8) != 0) {
            list = blackBoardModel.list;
        }
        return blackBoardModel.copy(str, str2, str3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final List<BlackBoardModel> component4() {
        return this.list;
    }

    public final BlackBoardModel copy(String subjectName, String time, String filePath, List<BlackBoardModel> list) {
        return new BlackBoardModel(subjectName, time, filePath, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlackBoardModel)) {
            return false;
        }
        BlackBoardModel blackBoardModel = (BlackBoardModel) other;
        return Intrinsics.areEqual(this.subjectName, blackBoardModel.subjectName) && Intrinsics.areEqual(this.time, blackBoardModel.time) && Intrinsics.areEqual(this.filePath, blackBoardModel.filePath) && Intrinsics.areEqual(this.list, blackBoardModel.list);
    }

    public int hashCode() {
        String str = this.subjectName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.time;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.filePath;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<BlackBoardModel> list = this.list;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BlackBoardModel(subjectName=" + this.subjectName + ", time=" + this.time + ", filePath=" + this.filePath + ", list=" + this.list + ')';
    }

    public BlackBoardModel(String str, String str2, String str3, List<BlackBoardModel> list) {
        this.subjectName = str;
        this.time = str2;
        this.filePath = str3;
        this.list = list;
    }

    public /* synthetic */ BlackBoardModel(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : list);
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final List<BlackBoardModel> getList() {
        return this.list;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    public final void setList(List<BlackBoardModel> list) {
        this.list = list;
    }

    public final void setSubjectName(String str) {
        this.subjectName = str;
    }

    public final void setTime(String str) {
        this.time = str;
    }
}
