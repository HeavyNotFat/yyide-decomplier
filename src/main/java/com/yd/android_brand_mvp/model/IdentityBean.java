package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentityBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/IdentityBean;", "", "identityId", "", "identityName", "personType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdentityId", "()Ljava/lang/String;", "getIdentityName", "getPersonType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class IdentityBean {
    private final String identityId;
    private final String identityName;
    private final String personType;

    public IdentityBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ IdentityBean copy$default(IdentityBean identityBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = identityBean.identityId;
        }
        if ((i & 2) != 0) {
            str2 = identityBean.identityName;
        }
        if ((i & 4) != 0) {
            str3 = identityBean.personType;
        }
        return identityBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIdentityId() {
        return this.identityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIdentityName() {
        return this.identityName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPersonType() {
        return this.personType;
    }

    public final IdentityBean copy(String identityId, String identityName, String personType) {
        return new IdentityBean(identityId, identityName, personType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdentityBean)) {
            return false;
        }
        IdentityBean identityBean = (IdentityBean) other;
        return Intrinsics.areEqual(this.identityId, identityBean.identityId) && Intrinsics.areEqual(this.identityName, identityBean.identityName) && Intrinsics.areEqual(this.personType, identityBean.personType);
    }

    public int hashCode() {
        String str = this.identityId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.identityName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.personType;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "IdentityBean(identityId=" + this.identityId + ", identityName=" + this.identityName + ", personType=" + this.personType + ')';
    }

    public IdentityBean(String str, String str2, String str3) {
        this.identityId = str;
        this.identityName = str2;
        this.personType = str3;
    }

    public /* synthetic */ IdentityBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getIdentityId() {
        return this.identityId;
    }

    public final String getIdentityName() {
        return this.identityName;
    }

    public final String getPersonType() {
        return this.personType;
    }
}
