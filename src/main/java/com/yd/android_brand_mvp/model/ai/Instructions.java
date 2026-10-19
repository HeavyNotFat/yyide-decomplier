package com.yd.android_brand_mvp.model.ai;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Instructions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/Instructions;", "", "blankReply", "", "restrictions", "role", "skills", "workflow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBlankReply", "()Ljava/lang/String;", "getRestrictions", "getRole", "getSkills", "getWorkflow", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Instructions {
    private final String blankReply;
    private final String restrictions;
    private final String role;
    private final String skills;
    private final String workflow;

    public static /* synthetic */ Instructions copy$default(Instructions instructions, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = instructions.blankReply;
        }
        if ((i & 2) != 0) {
            str2 = instructions.restrictions;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = instructions.role;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = instructions.skills;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = instructions.workflow;
        }
        return instructions.copy(str, str6, str7, str8, str5);
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

    public final Instructions copy(String blankReply, String restrictions, String role, String skills, String workflow) {
        Intrinsics.checkNotNullParameter(blankReply, "blankReply");
        Intrinsics.checkNotNullParameter(restrictions, "restrictions");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(skills, "skills");
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        return new Instructions(blankReply, restrictions, role, skills, workflow);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Instructions)) {
            return false;
        }
        Instructions instructions = (Instructions) other;
        return Intrinsics.areEqual(this.blankReply, instructions.blankReply) && Intrinsics.areEqual(this.restrictions, instructions.restrictions) && Intrinsics.areEqual(this.role, instructions.role) && Intrinsics.areEqual(this.skills, instructions.skills) && Intrinsics.areEqual(this.workflow, instructions.workflow);
    }

    public int hashCode() {
        return (((((((this.blankReply.hashCode() * 31) + this.restrictions.hashCode()) * 31) + this.role.hashCode()) * 31) + this.skills.hashCode()) * 31) + this.workflow.hashCode();
    }

    public String toString() {
        return "Instructions(blankReply=" + this.blankReply + ", restrictions=" + this.restrictions + ", role=" + this.role + ", skills=" + this.skills + ", workflow=" + this.workflow + ')';
    }

    public Instructions(String blankReply, String restrictions, String role, String skills, String workflow) {
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
