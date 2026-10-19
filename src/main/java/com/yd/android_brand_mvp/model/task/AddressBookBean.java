package com.yd.android_brand_mvp.model.task;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddressBookBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/AddressBookBean;", "", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "relation", "photo", "labels", "", "Lcom/yd/android_brand_mvp/model/task/BookLabsBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getLabels", "()Ljava/util/List;", "getName", "getPhoto", "getRelation", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AddressBookBean {
    private final String id;
    private final List<BookLabsBean> labels;
    private final String name;
    private final String photo;
    private final String relation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddressBookBean copy$default(AddressBookBean addressBookBean, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addressBookBean.id;
        }
        if ((i & 2) != 0) {
            str2 = addressBookBean.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = addressBookBean.relation;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = addressBookBean.photo;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = addressBookBean.labels;
        }
        return addressBookBean.copy(str, str5, str6, str7, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRelation() {
        return this.relation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhoto() {
        return this.photo;
    }

    public final List<BookLabsBean> component5() {
        return this.labels;
    }

    public final AddressBookBean copy(String id, String name, String relation, String photo, List<BookLabsBean> labels) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(photo, "photo");
        return new AddressBookBean(id, name, relation, photo, labels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressBookBean)) {
            return false;
        }
        AddressBookBean addressBookBean = (AddressBookBean) other;
        return Intrinsics.areEqual(this.id, addressBookBean.id) && Intrinsics.areEqual(this.name, addressBookBean.name) && Intrinsics.areEqual(this.relation, addressBookBean.relation) && Intrinsics.areEqual(this.photo, addressBookBean.photo) && Intrinsics.areEqual(this.labels, addressBookBean.labels);
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.relation.hashCode()) * 31) + this.photo.hashCode()) * 31;
        List<BookLabsBean> list = this.labels;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "AddressBookBean(id=" + this.id + ", name=" + this.name + ", relation=" + this.relation + ", photo=" + this.photo + ", labels=" + this.labels + ')';
    }

    public AddressBookBean(String id, String name, String relation, String photo, List<BookLabsBean> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(photo, "photo");
        this.id = id;
        this.name = name;
        this.relation = relation;
        this.photo = photo;
        this.labels = list;
    }

    public /* synthetic */ AddressBookBean(String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : list);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRelation() {
        return this.relation;
    }

    public final String getPhoto() {
        return this.photo;
    }

    public final List<BookLabsBean> getLabels() {
        return this.labels;
    }
}
