package com.yd.android_brand_mvp.model.userspace;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrangeUserInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/model/userspace/ArrangeUserInfoBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemType", "", "arrangeUserList", "", "Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", "arrangeUser", "(ILjava/util/List;Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;)V", "getArrangeUser", "()Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", "getArrangeUserList", "()Ljava/util/List;", "getItemType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ArrangeUserInfoBean implements MultiItemEntity {
    private final UserInfoListItem arrangeUser;
    private final List<UserInfoListItem> arrangeUserList;
    private final int itemType;

    public ArrangeUserInfoBean() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrangeUserInfoBean copy$default(ArrangeUserInfoBean arrangeUserInfoBean, int i, List list, UserInfoListItem userInfoListItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = arrangeUserInfoBean.getItemType();
        }
        if ((i2 & 2) != 0) {
            list = arrangeUserInfoBean.arrangeUserList;
        }
        if ((i2 & 4) != 0) {
            userInfoListItem = arrangeUserInfoBean.arrangeUser;
        }
        return arrangeUserInfoBean.copy(i, list, userInfoListItem);
    }

    public final int component1() {
        return getItemType();
    }

    public final List<UserInfoListItem> component2() {
        return this.arrangeUserList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final UserInfoListItem getArrangeUser() {
        return this.arrangeUser;
    }

    public final ArrangeUserInfoBean copy(int itemType, List<UserInfoListItem> arrangeUserList, UserInfoListItem arrangeUser) {
        Intrinsics.checkNotNullParameter(arrangeUserList, "arrangeUserList");
        Intrinsics.checkNotNullParameter(arrangeUser, "arrangeUser");
        return new ArrangeUserInfoBean(itemType, arrangeUserList, arrangeUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArrangeUserInfoBean)) {
            return false;
        }
        ArrangeUserInfoBean arrangeUserInfoBean = (ArrangeUserInfoBean) other;
        return getItemType() == arrangeUserInfoBean.getItemType() && Intrinsics.areEqual(this.arrangeUserList, arrangeUserInfoBean.arrangeUserList) && Intrinsics.areEqual(this.arrangeUser, arrangeUserInfoBean.arrangeUser);
    }

    public int hashCode() {
        return (((getItemType() * 31) + this.arrangeUserList.hashCode()) * 31) + this.arrangeUser.hashCode();
    }

    public String toString() {
        return "ArrangeUserInfoBean(itemType=" + getItemType() + ", arrangeUserList=" + this.arrangeUserList + ", arrangeUser=" + this.arrangeUser + ')';
    }

    public ArrangeUserInfoBean(int i, List<UserInfoListItem> arrangeUserList, UserInfoListItem arrangeUser) {
        Intrinsics.checkNotNullParameter(arrangeUserList, "arrangeUserList");
        Intrinsics.checkNotNullParameter(arrangeUser, "arrangeUser");
        this.itemType = i;
        this.arrangeUserList = arrangeUserList;
        this.arrangeUser = arrangeUser;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public /* synthetic */ ArrangeUserInfoBean(int i, List list, UserInfoListItem userInfoListItem, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ArrayList() : list, (i2 & 4) != 0 ? new UserInfoListItem(null, null, null, null, null, null, null, null, null, null, false, 2047, null) : userInfoListItem);
    }

    public final List<UserInfoListItem> getArrangeUserList() {
        return this.arrangeUserList;
    }

    public final UserInfoListItem getArrangeUser() {
        return this.arrangeUser;
    }
}
