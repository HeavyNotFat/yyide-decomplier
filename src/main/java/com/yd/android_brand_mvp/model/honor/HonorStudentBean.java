package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorStudentBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorStudentBean;", "", "avatar", "", "honorList", "", "Lcom/yd/android_brand_mvp/model/honor/HonorItemBean;", CommentsHomeFragment.TYPE_ID, "studentName", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getHonorList", "()Ljava/util/List;", "setHonorList", "(Ljava/util/List;)V", "getStudentId", "setStudentId", "getStudentName", "setStudentName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorStudentBean {
    private String avatar;
    private List<HonorItemBean> honorList;
    private String studentId;
    private String studentName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HonorStudentBean copy$default(HonorStudentBean honorStudentBean, String str, List list, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = honorStudentBean.avatar;
        }
        if ((i & 2) != 0) {
            list = honorStudentBean.honorList;
        }
        if ((i & 4) != 0) {
            str2 = honorStudentBean.studentId;
        }
        if ((i & 8) != 0) {
            str3 = honorStudentBean.studentName;
        }
        return honorStudentBean.copy(str, list, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    public final List<HonorItemBean> component2() {
        return this.honorList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStudentName() {
        return this.studentName;
    }

    public final HonorStudentBean copy(@JSONField(name = "avatar") String avatar, @JSONField(name = "honorList") List<HonorItemBean> honorList, @JSONField(name = CommentsHomeFragment.TYPE_ID) String studentId, @JSONField(name = "studentName") String studentName) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(honorList, "honorList");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        return new HonorStudentBean(avatar, honorList, studentId, studentName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorStudentBean)) {
            return false;
        }
        HonorStudentBean honorStudentBean = (HonorStudentBean) other;
        return Intrinsics.areEqual(this.avatar, honorStudentBean.avatar) && Intrinsics.areEqual(this.honorList, honorStudentBean.honorList) && Intrinsics.areEqual(this.studentId, honorStudentBean.studentId) && Intrinsics.areEqual(this.studentName, honorStudentBean.studentName);
    }

    public int hashCode() {
        return (((((this.avatar.hashCode() * 31) + this.honorList.hashCode()) * 31) + this.studentId.hashCode()) * 31) + this.studentName.hashCode();
    }

    public String toString() {
        return "HonorStudentBean(avatar=" + this.avatar + ", honorList=" + this.honorList + ", studentId=" + this.studentId + ", studentName=" + this.studentName + ')';
    }

    public HonorStudentBean(@JSONField(name = "avatar") String avatar, @JSONField(name = "honorList") List<HonorItemBean> honorList, @JSONField(name = CommentsHomeFragment.TYPE_ID) String studentId, @JSONField(name = "studentName") String studentName) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(honorList, "honorList");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        this.avatar = avatar;
        this.honorList = honorList;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final List<HonorItemBean> getHonorList() {
        return this.honorList;
    }

    public final void setHonorList(List<HonorItemBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.honorList = list;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentId = str;
    }

    public final String getStudentName() {
        return this.studentName;
    }

    public final void setStudentName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentName = str;
    }
}
