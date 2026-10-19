package com.yd.android_brand_mvp.model.ai;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIChatMessageBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003Jc\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001dR\u0014\u0010\r\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u00062"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/AIChatMessageBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "id", "", "currentIndex", "icon", "", "title", "content", "isUser", "", "isShow", a.j, "itemType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZII)V", "getCode", "()I", "setCode", "(I)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCurrentIndex", "setCurrentIndex", "getIcon", "setIcon", "getId", "setId", "()Z", "setShow", "(Z)V", "getItemType", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AIChatMessageBean implements MultiItemEntity {
    private int code;
    private String content;
    private int currentIndex;
    private String icon;
    private int id;
    private boolean isShow;
    private final boolean isUser;
    private final int itemType;
    private String title;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsUser() {
        return this.isUser;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final int component9() {
        return getItemType();
    }

    public final AIChatMessageBean copy(int id, int currentIndex, String icon, String title, String content, boolean isUser, boolean isShow, int code, int itemType) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return new AIChatMessageBean(id, currentIndex, icon, title, content, isUser, isShow, code, itemType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIChatMessageBean)) {
            return false;
        }
        AIChatMessageBean aIChatMessageBean = (AIChatMessageBean) other;
        return this.id == aIChatMessageBean.id && this.currentIndex == aIChatMessageBean.currentIndex && Intrinsics.areEqual(this.icon, aIChatMessageBean.icon) && Intrinsics.areEqual(this.title, aIChatMessageBean.title) && Intrinsics.areEqual(this.content, aIChatMessageBean.content) && this.isUser == aIChatMessageBean.isUser && this.isShow == aIChatMessageBean.isShow && this.code == aIChatMessageBean.code && getItemType() == aIChatMessageBean.getItemType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.id * 31) + this.currentIndex) * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31;
        boolean z = this.isUser;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isShow;
        return ((((i + (z2 ? 1 : z2)) * 31) + this.code) * 31) + getItemType();
    }

    public String toString() {
        return "AIChatMessageBean(id=" + this.id + ", currentIndex=" + this.currentIndex + ", icon=" + this.icon + ", title=" + this.title + ", content=" + this.content + ", isUser=" + this.isUser + ", isShow=" + this.isShow + ", code=" + this.code + ", itemType=" + getItemType() + ')';
    }

    public AIChatMessageBean(int i, int i2, String icon, String title, String content, boolean z, boolean z2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = i;
        this.currentIndex = i2;
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.isUser = z;
        this.isShow = z2;
        this.code = i3;
        this.itemType = i4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AIChatMessageBean(int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int i6;
        int i7 = (i5 & 2) != 0 ? 0 : i2;
        boolean z3 = (i5 & 64) != 0 ? false : z2;
        int i8 = (i5 & 128) != 0 ? 0 : i3;
        if ((i5 & 256) != 0) {
            i6 = z ? 1 : 2;
        } else {
            i6 = i4;
        }
        this(i, i7, str, str2, str3, z, z3, i8, i6);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final boolean isUser() {
        return this.isUser;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final void setCode(int i) {
        this.code = i;
    }
}
