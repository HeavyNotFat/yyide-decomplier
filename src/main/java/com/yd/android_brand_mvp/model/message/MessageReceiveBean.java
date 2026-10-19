package com.yd.android_brand_mvp.model.message;

import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageReceiveBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/message/MessageReceiveBean;", "", "lossLocation", "", "contactPerson", "lossItems", "lossTime", "", "contactPhone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getContactPerson", "()Ljava/lang/String;", "getContactPhone", "getLossItems", "getLossLocation", "getLossTime", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MessageReceiveBean {
    private final String contactPerson;
    private final String contactPhone;
    private final String lossItems;
    private final String lossLocation;
    private final long lossTime;

    public MessageReceiveBean() {
        this(null, null, null, 0L, null, 31, null);
    }

    public static /* synthetic */ MessageReceiveBean copy$default(MessageReceiveBean messageReceiveBean, String str, String str2, String str3, long j, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageReceiveBean.lossLocation;
        }
        if ((i & 2) != 0) {
            str2 = messageReceiveBean.contactPerson;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = messageReceiveBean.lossItems;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            j = messageReceiveBean.lossTime;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str4 = messageReceiveBean.contactPhone;
        }
        return messageReceiveBean.copy(str, str5, str6, j2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLossLocation() {
        return this.lossLocation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContactPerson() {
        return this.contactPerson;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLossItems() {
        return this.lossItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getLossTime() {
        return this.lossTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContactPhone() {
        return this.contactPhone;
    }

    public final MessageReceiveBean copy(String lossLocation, String contactPerson, String lossItems, long lossTime, String contactPhone) {
        Intrinsics.checkNotNullParameter(lossLocation, "lossLocation");
        Intrinsics.checkNotNullParameter(contactPerson, "contactPerson");
        Intrinsics.checkNotNullParameter(lossItems, "lossItems");
        Intrinsics.checkNotNullParameter(contactPhone, "contactPhone");
        return new MessageReceiveBean(lossLocation, contactPerson, lossItems, lossTime, contactPhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReceiveBean)) {
            return false;
        }
        MessageReceiveBean messageReceiveBean = (MessageReceiveBean) other;
        return Intrinsics.areEqual(this.lossLocation, messageReceiveBean.lossLocation) && Intrinsics.areEqual(this.contactPerson, messageReceiveBean.contactPerson) && Intrinsics.areEqual(this.lossItems, messageReceiveBean.lossItems) && this.lossTime == messageReceiveBean.lossTime && Intrinsics.areEqual(this.contactPhone, messageReceiveBean.contactPhone);
    }

    public int hashCode() {
        return (((((((this.lossLocation.hashCode() * 31) + this.contactPerson.hashCode()) * 31) + this.lossItems.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.lossTime)) * 31) + this.contactPhone.hashCode();
    }

    public String toString() {
        return "MessageReceiveBean(lossLocation=" + this.lossLocation + ", contactPerson=" + this.contactPerson + ", lossItems=" + this.lossItems + ", lossTime=" + this.lossTime + ", contactPhone=" + this.contactPhone + ')';
    }

    public MessageReceiveBean(String lossLocation, String contactPerson, String lossItems, long j, String contactPhone) {
        Intrinsics.checkNotNullParameter(lossLocation, "lossLocation");
        Intrinsics.checkNotNullParameter(contactPerson, "contactPerson");
        Intrinsics.checkNotNullParameter(lossItems, "lossItems");
        Intrinsics.checkNotNullParameter(contactPhone, "contactPhone");
        this.lossLocation = lossLocation;
        this.contactPerson = contactPerson;
        this.lossItems = lossItems;
        this.lossTime = j;
        this.contactPhone = contactPhone;
    }

    public /* synthetic */ MessageReceiveBean(String str, String str2, String str3, long j, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? "" : str4);
    }

    public final String getLossLocation() {
        return this.lossLocation;
    }

    public final String getContactPerson() {
        return this.contactPerson;
    }

    public final String getLossItems() {
        return this.lossItems;
    }

    public final long getLossTime() {
        return this.lossTime;
    }

    public final String getContactPhone() {
        return this.contactPhone;
    }
}
