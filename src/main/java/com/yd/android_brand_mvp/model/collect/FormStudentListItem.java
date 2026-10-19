package com.yd.android_brand_mvp.model.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormStudentListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/FormStudentListItem;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "id", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormStudentListItem {
    private final String avatar;
    private final String id;
    private final String name;

    public FormStudentListItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FormStudentListItem copy$default(FormStudentListItem formStudentListItem, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formStudentListItem.name;
        }
        if ((i & 2) != 0) {
            str2 = formStudentListItem.id;
        }
        if ((i & 4) != 0) {
            str3 = formStudentListItem.avatar;
        }
        return formStudentListItem.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    public final FormStudentListItem copy(String name, String id, String avatar) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        return new FormStudentListItem(name, id, avatar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormStudentListItem)) {
            return false;
        }
        FormStudentListItem formStudentListItem = (FormStudentListItem) other;
        return Intrinsics.areEqual(this.name, formStudentListItem.name) && Intrinsics.areEqual(this.id, formStudentListItem.id) && Intrinsics.areEqual(this.avatar, formStudentListItem.avatar);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + this.avatar.hashCode();
    }

    public String toString() {
        return "FormStudentListItem(name=" + this.name + ", id=" + this.id + ", avatar=" + this.avatar + ')';
    }

    public FormStudentListItem(String name, String id, String avatar) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        this.name = name;
        this.id = id;
        this.avatar = avatar;
    }

    public /* synthetic */ FormStudentListItem(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAvatar() {
        return this.avatar;
    }
}
