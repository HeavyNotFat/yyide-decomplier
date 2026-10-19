package com.yd.android_brand_mvp.model.collect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UpdateFormStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/UpdateFormStatus;", "", "sortInt", "", "isGone", "", "(IZ)V", "()Z", "getSortInt", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UpdateFormStatus {
    private final boolean isGone;
    private final int sortInt;

    public UpdateFormStatus() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ UpdateFormStatus copy$default(UpdateFormStatus updateFormStatus, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = updateFormStatus.sortInt;
        }
        if ((i2 & 2) != 0) {
            z = updateFormStatus.isGone;
        }
        return updateFormStatus.copy(i, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSortInt() {
        return this.sortInt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsGone() {
        return this.isGone;
    }

    public final UpdateFormStatus copy(int sortInt, boolean isGone) {
        return new UpdateFormStatus(sortInt, isGone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateFormStatus)) {
            return false;
        }
        UpdateFormStatus updateFormStatus = (UpdateFormStatus) other;
        return this.sortInt == updateFormStatus.sortInt && this.isGone == updateFormStatus.isGone;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int i = this.sortInt * 31;
        boolean z = this.isGone;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return i + r1;
    }

    public String toString() {
        return "UpdateFormStatus(sortInt=" + this.sortInt + ", isGone=" + this.isGone + ')';
    }

    public UpdateFormStatus(int i, boolean z) {
        this.sortInt = i;
        this.isGone = z;
    }

    public /* synthetic */ UpdateFormStatus(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? false : z);
    }

    public final int getSortInt() {
        return this.sortInt;
    }

    public final boolean isGone() {
        return this.isGone;
    }
}
