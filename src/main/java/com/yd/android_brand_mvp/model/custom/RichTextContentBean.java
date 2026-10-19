package com.yd.android_brand_mvp.model.custom;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J_\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;", "Landroid/os/Parcelable;", "content", "", "firstTitle", "images", "", "layoutType", "", "secondTitle", "showContent", "", "showFirstTitle", "showSecondTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZZZ)V", "getContent", "()Ljava/lang/String;", "getFirstTitle", "getImages", "()Ljava/util/List;", "getLayoutType", "()I", "getSecondTitle", "getShowContent", "()Z", "getShowFirstTitle", "getShowSecondTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RichTextContentBean implements Parcelable {
    public static final Parcelable.Creator<RichTextContentBean> CREATOR = new Creator();
    private final String content;
    private final String firstTitle;
    private final List<String> images;
    private final int layoutType;
    private final String secondTitle;
    private final boolean showContent;
    private final boolean showFirstTitle;
    private final boolean showSecondTitle;

    /* JADX INFO: compiled from: CustomJsonGroupBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RichTextContentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RichTextContentBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RichTextContentBean(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RichTextContentBean[] newArray(int i) {
            return new RichTextContentBean[i];
        }
    }

    public RichTextContentBean() {
        this(null, null, null, 0, null, false, false, false, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstTitle() {
        return this.firstTitle;
    }

    public final List<String> component3() {
        return this.images;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLayoutType() {
        return this.layoutType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSecondTitle() {
        return this.secondTitle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowContent() {
        return this.showContent;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowFirstTitle() {
        return this.showFirstTitle;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowSecondTitle() {
        return this.showSecondTitle;
    }

    public final RichTextContentBean copy(String content, String firstTitle, List<String> images, int layoutType, String secondTitle, boolean showContent, boolean showFirstTitle, boolean showSecondTitle) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(firstTitle, "firstTitle");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(secondTitle, "secondTitle");
        return new RichTextContentBean(content, firstTitle, images, layoutType, secondTitle, showContent, showFirstTitle, showSecondTitle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RichTextContentBean)) {
            return false;
        }
        RichTextContentBean richTextContentBean = (RichTextContentBean) other;
        return Intrinsics.areEqual(this.content, richTextContentBean.content) && Intrinsics.areEqual(this.firstTitle, richTextContentBean.firstTitle) && Intrinsics.areEqual(this.images, richTextContentBean.images) && this.layoutType == richTextContentBean.layoutType && Intrinsics.areEqual(this.secondTitle, richTextContentBean.secondTitle) && this.showContent == richTextContentBean.showContent && this.showFirstTitle == richTextContentBean.showFirstTitle && this.showSecondTitle == richTextContentBean.showSecondTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.content.hashCode() * 31) + this.firstTitle.hashCode()) * 31) + this.images.hashCode()) * 31) + this.layoutType) * 31) + this.secondTitle.hashCode()) * 31;
        boolean z = this.showContent;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.showFirstTitle;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.showSecondTitle;
        return i2 + (z3 ? 1 : z3);
    }

    public String toString() {
        return "RichTextContentBean(content=" + this.content + ", firstTitle=" + this.firstTitle + ", images=" + this.images + ", layoutType=" + this.layoutType + ", secondTitle=" + this.secondTitle + ", showContent=" + this.showContent + ", showFirstTitle=" + this.showFirstTitle + ", showSecondTitle=" + this.showSecondTitle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.content);
        parcel.writeString(this.firstTitle);
        parcel.writeStringList(this.images);
        parcel.writeInt(this.layoutType);
        parcel.writeString(this.secondTitle);
        parcel.writeInt(this.showContent ? 1 : 0);
        parcel.writeInt(this.showFirstTitle ? 1 : 0);
        parcel.writeInt(this.showSecondTitle ? 1 : 0);
    }

    public RichTextContentBean(String content, String firstTitle, List<String> images, int i, String secondTitle, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(firstTitle, "firstTitle");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(secondTitle, "secondTitle");
        this.content = content;
        this.firstTitle = firstTitle;
        this.images = images;
        this.layoutType = i;
        this.secondTitle = secondTitle;
        this.showContent = z;
        this.showFirstTitle = z2;
        this.showSecondTitle = z3;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFirstTitle() {
        return this.firstTitle;
    }

    public /* synthetic */ RichTextContentBean(String str, String str2, List list, int i, String str3, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? 0 : i, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? true : z2, (i2 & 128) == 0 ? z3 : true);
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final int getLayoutType() {
        return this.layoutType;
    }

    public final String getSecondTitle() {
        return this.secondTitle;
    }

    public final boolean getShowContent() {
        return this.showContent;
    }

    public final boolean getShowFirstTitle() {
        return this.showFirstTitle;
    }

    public final boolean getShowSecondTitle() {
        return this.showSecondTitle;
    }
}
