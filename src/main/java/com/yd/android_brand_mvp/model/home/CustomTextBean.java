package com.yd.android_brand_mvp.model.home;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTextBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\bHÖ\u0001R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006,"}, d2 = {"Lcom/yd/android_brand_mvp/model/home/CustomTextBean;", "Landroid/os/Parcelable;", "text", "", TtmlNode.ATTR_TTS_FONT_SIZE, "isBold", "", "rowPitch", "", "showLogo", "background", "typeSetting", "(Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/lang/String;)V", "getBackground", "()Ljava/lang/String;", "setBackground", "(Ljava/lang/String;)V", "getFontSize", "()Z", "getRowPitch", "()I", "getShowLogo", "getText", "setText", "getTypeSetting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomTextBean implements Parcelable {
    public static final Parcelable.Creator<CustomTextBean> CREATOR = new Creator();
    private String background;
    private final String fontSize;
    private final boolean isBold;
    private final int rowPitch;
    private final boolean showLogo;
    private String text;
    private final String typeSetting;

    /* JADX INFO: compiled from: CustomTextBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CustomTextBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomTextBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomTextBean(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomTextBean[] newArray(int i) {
            return new CustomTextBean[i];
        }
    }

    public CustomTextBean() {
        this(null, null, false, 0, false, null, null, 127, null);
    }

    public static /* synthetic */ CustomTextBean copy$default(CustomTextBean customTextBean, String str, String str2, boolean z, int i, boolean z2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = customTextBean.text;
        }
        if ((i2 & 2) != 0) {
            str2 = customTextBean.fontSize;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            z = customTextBean.isBold;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            i = customTextBean.rowPitch;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z2 = customTextBean.showLogo;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            str3 = customTextBean.background;
        }
        String str6 = str3;
        if ((i2 & 64) != 0) {
            str4 = customTextBean.typeSetting;
        }
        return customTextBean.copy(str, str5, z3, i3, z4, str6, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsBold() {
        return this.isBold;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRowPitch() {
        return this.rowPitch;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowLogo() {
        return this.showLogo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTypeSetting() {
        return this.typeSetting;
    }

    public final CustomTextBean copy(String text, String fontSize, boolean isBold, int rowPitch, boolean showLogo, String background, String typeSetting) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(typeSetting, "typeSetting");
        return new CustomTextBean(text, fontSize, isBold, rowPitch, showLogo, background, typeSetting);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomTextBean)) {
            return false;
        }
        CustomTextBean customTextBean = (CustomTextBean) other;
        return Intrinsics.areEqual(this.text, customTextBean.text) && Intrinsics.areEqual(this.fontSize, customTextBean.fontSize) && this.isBold == customTextBean.isBold && this.rowPitch == customTextBean.rowPitch && this.showLogo == customTextBean.showLogo && Intrinsics.areEqual(this.background, customTextBean.background) && Intrinsics.areEqual(this.typeSetting, customTextBean.typeSetting);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.text.hashCode() * 31) + this.fontSize.hashCode()) * 31;
        boolean z = this.isBold;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (((iHashCode + r1) * 31) + this.rowPitch) * 31;
        boolean z2 = this.showLogo;
        return ((((i + (z2 ? 1 : z2)) * 31) + this.background.hashCode()) * 31) + this.typeSetting.hashCode();
    }

    public String toString() {
        return "CustomTextBean(text=" + this.text + ", fontSize=" + this.fontSize + ", isBold=" + this.isBold + ", rowPitch=" + this.rowPitch + ", showLogo=" + this.showLogo + ", background=" + this.background + ", typeSetting=" + this.typeSetting + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.text);
        parcel.writeString(this.fontSize);
        parcel.writeInt(this.isBold ? 1 : 0);
        parcel.writeInt(this.rowPitch);
        parcel.writeInt(this.showLogo ? 1 : 0);
        parcel.writeString(this.background);
        parcel.writeString(this.typeSetting);
    }

    public CustomTextBean(String text, String fontSize, boolean z, int i, boolean z2, String background, String typeSetting) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(typeSetting, "typeSetting");
        this.text = text;
        this.fontSize = fontSize;
        this.isBold = z;
        this.rowPitch = i;
        this.showLogo = z2;
        this.background = background;
        this.typeSetting = typeSetting;
    }

    public /* synthetic */ CustomTextBean(String str, String str2, boolean z, int i, boolean z2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? "" : str4);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getFontSize() {
        return this.fontSize;
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public final int getRowPitch() {
        return this.rowPitch;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public final String getBackground() {
        return this.background;
    }

    public final void setBackground(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.background = str;
    }

    public final String getTypeSetting() {
        return this.typeSetting;
    }
}
