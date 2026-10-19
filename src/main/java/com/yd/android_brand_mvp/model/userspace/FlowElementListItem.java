package com.yd.android_brand_mvp.model.userspace;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlowElementListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0011HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u0083\u0001\u0010-\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001J\u0013\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u00062"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "", "children", "", "mode", "", "handler", "userSelectRange", "", "userSelectType", "userInfoList", "", "Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", AppMeasurementSdk.ConditionalUserProperty.NAME, "id", "outcome", "isNotUser", "", "flowElementType", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getChildren", "()Ljava/util/List;", "getFlowElementType", "()Ljava/lang/String;", "getHandler", "getId", "()Z", "getMode", "getName", "getOutcome", "getUserInfoList", "getUserSelectRange", "()I", "getUserSelectType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlowElementListItem {
    private final List<FlowElementListItem> children;
    private final String flowElementType;
    private final String handler;
    private final String id;
    private final boolean isNotUser;
    private final String mode;
    private final String name;
    private final String outcome;
    private final List<UserInfoListItem> userInfoList;
    private final int userSelectRange;
    private final int userSelectType;

    public FlowElementListItem() {
        this(null, null, null, 0, 0, null, null, null, null, false, null, 2047, null);
    }

    public final List<FlowElementListItem> component1() {
        return this.children;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsNotUser() {
        return this.isNotUser;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getFlowElementType() {
        return this.flowElementType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHandler() {
        return this.handler;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUserSelectRange() {
        return this.userSelectRange;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getUserSelectType() {
        return this.userSelectType;
    }

    public final List<UserInfoListItem> component6() {
        return this.userInfoList;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOutcome() {
        return this.outcome;
    }

    public final FlowElementListItem copy(List<FlowElementListItem> children, String mode, String handler, int userSelectRange, int userSelectType, List<UserInfoListItem> userInfoList, String name, String id, String outcome, boolean isNotUser, String flowElementType) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(flowElementType, "flowElementType");
        return new FlowElementListItem(children, mode, handler, userSelectRange, userSelectType, userInfoList, name, id, outcome, isNotUser, flowElementType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowElementListItem)) {
            return false;
        }
        FlowElementListItem flowElementListItem = (FlowElementListItem) other;
        return Intrinsics.areEqual(this.children, flowElementListItem.children) && Intrinsics.areEqual(this.mode, flowElementListItem.mode) && Intrinsics.areEqual(this.handler, flowElementListItem.handler) && this.userSelectRange == flowElementListItem.userSelectRange && this.userSelectType == flowElementListItem.userSelectType && Intrinsics.areEqual(this.userInfoList, flowElementListItem.userInfoList) && Intrinsics.areEqual(this.name, flowElementListItem.name) && Intrinsics.areEqual(this.id, flowElementListItem.id) && Intrinsics.areEqual(this.outcome, flowElementListItem.outcome) && this.isNotUser == flowElementListItem.isNotUser && Intrinsics.areEqual(this.flowElementType, flowElementListItem.flowElementType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((this.children.hashCode() * 31) + this.mode.hashCode()) * 31) + this.handler.hashCode()) * 31) + this.userSelectRange) * 31) + this.userSelectType) * 31) + this.userInfoList.hashCode()) * 31) + this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + this.outcome.hashCode()) * 31;
        boolean z = this.isNotUser;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.flowElementType.hashCode();
    }

    public String toString() {
        return "FlowElementListItem(children=" + this.children + ", mode=" + this.mode + ", handler=" + this.handler + ", userSelectRange=" + this.userSelectRange + ", userSelectType=" + this.userSelectType + ", userInfoList=" + this.userInfoList + ", name=" + this.name + ", id=" + this.id + ", outcome=" + this.outcome + ", isNotUser=" + this.isNotUser + ", flowElementType=" + this.flowElementType + ')';
    }

    public FlowElementListItem(List<FlowElementListItem> children, String mode, String handler, int i, int i2, List<UserInfoListItem> userInfoList, String name, String id, String outcome, boolean z, String flowElementType) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        Intrinsics.checkNotNullParameter(flowElementType, "flowElementType");
        this.children = children;
        this.mode = mode;
        this.handler = handler;
        this.userSelectRange = i;
        this.userSelectType = i2;
        this.userInfoList = userInfoList;
        this.name = name;
        this.id = id;
        this.outcome = outcome;
        this.isNotUser = z;
        this.flowElementType = flowElementType;
    }

    public /* synthetic */ FlowElementListItem(List list, String str, String str2, int i, int i2, List list2, String str3, String str4, String str5, boolean z, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? new ArrayList() : list2, (i3 & 64) != 0 ? "" : str3, (i3 & 128) != 0 ? "" : str4, (i3 & 256) != 0 ? "" : str5, (i3 & 512) == 0 ? z : false, (i3 & 1024) == 0 ? str6 : "");
    }

    public final List<FlowElementListItem> getChildren() {
        return this.children;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getHandler() {
        return this.handler;
    }

    public final int getUserSelectRange() {
        return this.userSelectRange;
    }

    public final int getUserSelectType() {
        return this.userSelectType;
    }

    public final List<UserInfoListItem> getUserInfoList() {
        return this.userInfoList;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOutcome() {
        return this.outcome;
    }

    public final boolean isNotUser() {
        return this.isNotUser;
    }

    public final String getFlowElementType() {
        return this.flowElementType;
    }
}
