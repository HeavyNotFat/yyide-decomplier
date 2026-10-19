package com.yd.android_brand_mvp.model.ai;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIInstructionsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/AIInstructionsBean;", "Landroid/os/Parcelable;", "blankReply", "", "restrictions", "role", "skills", "workflow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBlankReply", "()Ljava/lang/String;", "getRestrictions", "getRole", "getSkills", "getWorkflow", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AIInstructionsBean implements Parcelable {
    public static final Parcelable.Creator<AIInstructionsBean> CREATOR = new Creator();
    private final String blankReply;
    private final String restrictions;
    private final String role;
    private final String skills;
    private final String workflow;

    /* JADX INFO: compiled from: AIInstructionsBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AIInstructionsBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AIInstructionsBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AIInstructionsBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AIInstructionsBean[] newArray(int i) {
            return new AIInstructionsBean[i];
        }
    }

    public AIInstructionsBean() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AIInstructionsBean copy$default(AIInstructionsBean aIInstructionsBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aIInstructionsBean.blankReply;
        }
        if ((i & 2) != 0) {
            str2 = aIInstructionsBean.restrictions;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = aIInstructionsBean.role;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = aIInstructionsBean.skills;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = aIInstructionsBean.workflow;
        }
        return aIInstructionsBean.copy(str, str6, str7, str8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBlankReply() {
        return this.blankReply;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRestrictions() {
        return this.restrictions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSkills() {
        return this.skills;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getWorkflow() {
        return this.workflow;
    }

    public final AIInstructionsBean copy(String blankReply, String restrictions, String role, String skills, String workflow) {
        Intrinsics.checkNotNullParameter(blankReply, "blankReply");
        Intrinsics.checkNotNullParameter(restrictions, "restrictions");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(skills, "skills");
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        return new AIInstructionsBean(blankReply, restrictions, role, skills, workflow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIInstructionsBean)) {
            return false;
        }
        AIInstructionsBean aIInstructionsBean = (AIInstructionsBean) other;
        return Intrinsics.areEqual(this.blankReply, aIInstructionsBean.blankReply) && Intrinsics.areEqual(this.restrictions, aIInstructionsBean.restrictions) && Intrinsics.areEqual(this.role, aIInstructionsBean.role) && Intrinsics.areEqual(this.skills, aIInstructionsBean.skills) && Intrinsics.areEqual(this.workflow, aIInstructionsBean.workflow);
    }

    public int hashCode() {
        return (((((((this.blankReply.hashCode() * 31) + this.restrictions.hashCode()) * 31) + this.role.hashCode()) * 31) + this.skills.hashCode()) * 31) + this.workflow.hashCode();
    }

    public String toString() {
        return "AIInstructionsBean(blankReply=" + this.blankReply + ", restrictions=" + this.restrictions + ", role=" + this.role + ", skills=" + this.skills + ", workflow=" + this.workflow + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.blankReply);
        parcel.writeString(this.restrictions);
        parcel.writeString(this.role);
        parcel.writeString(this.skills);
        parcel.writeString(this.workflow);
    }

    public AIInstructionsBean(String blankReply, String restrictions, String role, String skills, String workflow) {
        Intrinsics.checkNotNullParameter(blankReply, "blankReply");
        Intrinsics.checkNotNullParameter(restrictions, "restrictions");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(skills, "skills");
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        this.blankReply = blankReply;
        this.restrictions = restrictions;
        this.role = role;
        this.skills = skills;
        this.workflow = workflow;
    }

    public /* synthetic */ AIInstructionsBean(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    public final String getBlankReply() {
        return this.blankReply;
    }

    public final String getRestrictions() {
        return this.restrictions;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getSkills() {
        return this.skills;
    }

    public final String getWorkflow() {
        return this.workflow;
    }
}
