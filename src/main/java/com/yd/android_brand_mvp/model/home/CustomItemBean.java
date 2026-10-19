package com.yd.android_brand_mvp.model.home;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomItemBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jc\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0017¨\u00065"}, d2 = {"Lcom/yd/android_brand_mvp/model/home/CustomItemBean;", "Landroid/os/Parcelable;", "content", "", "customModeId", "deviceType", "", "id", "remarks", "schoolId", TypedValues.TransitionType.S_DURATION, "type", "settingInfo", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCustomModeId", "getDeviceType", "()I", "getDuration", "setDuration", "(I)V", "getId", "getRemarks", "getSchoolId", "getSettingInfo", "setSettingInfo", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomItemBean implements Parcelable {
    public static final Parcelable.Creator<CustomItemBean> CREATOR = new Creator();
    private String content;
    private final String customModeId;
    private final int deviceType;
    private int duration;
    private final String id;
    private final String remarks;
    private final String schoolId;
    private String settingInfo;
    private int type;

    /* JADX INFO: compiled from: CustomItemBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CustomItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomItemBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomItemBean[] newArray(int i) {
            return new CustomItemBean[i];
        }
    }

    public CustomItemBean() {
        this(null, null, 0, null, null, null, 0, 0, null, 511, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCustomModeId() {
        return this.customModeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSettingInfo() {
        return this.settingInfo;
    }

    public final CustomItemBean copy(String content, String customModeId, int deviceType, String id, String remarks, String schoolId, int duration, int type, String settingInfo) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(customModeId, "customModeId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        return new CustomItemBean(content, customModeId, deviceType, id, remarks, schoolId, duration, type, settingInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomItemBean)) {
            return false;
        }
        CustomItemBean customItemBean = (CustomItemBean) other;
        return Intrinsics.areEqual(this.content, customItemBean.content) && Intrinsics.areEqual(this.customModeId, customItemBean.customModeId) && this.deviceType == customItemBean.deviceType && Intrinsics.areEqual(this.id, customItemBean.id) && Intrinsics.areEqual(this.remarks, customItemBean.remarks) && Intrinsics.areEqual(this.schoolId, customItemBean.schoolId) && this.duration == customItemBean.duration && this.type == customItemBean.type && Intrinsics.areEqual(this.settingInfo, customItemBean.settingInfo);
    }

    public int hashCode() {
        return (((((((((((((((this.content.hashCode() * 31) + this.customModeId.hashCode()) * 31) + this.deviceType) * 31) + this.id.hashCode()) * 31) + this.remarks.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.duration) * 31) + this.type) * 31) + this.settingInfo.hashCode();
    }

    public String toString() {
        return "CustomItemBean(content=" + this.content + ", customModeId=" + this.customModeId + ", deviceType=" + this.deviceType + ", id=" + this.id + ", remarks=" + this.remarks + ", schoolId=" + this.schoolId + ", duration=" + this.duration + ", type=" + this.type + ", settingInfo=" + this.settingInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.content);
        parcel.writeString(this.customModeId);
        parcel.writeInt(this.deviceType);
        parcel.writeString(this.id);
        parcel.writeString(this.remarks);
        parcel.writeString(this.schoolId);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.type);
        parcel.writeString(this.settingInfo);
    }

    public CustomItemBean(String content, String customModeId, int i, String id, String remarks, String schoolId, int i2, int i3, String settingInfo) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(customModeId, "customModeId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        this.content = content;
        this.customModeId = customModeId;
        this.deviceType = i;
        this.id = id;
        this.remarks = remarks;
        this.schoolId = schoolId;
        this.duration = i2;
        this.type = i3;
        this.settingInfo = settingInfo;
    }

    public /* synthetic */ CustomItemBean(String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? -1 : i, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) == 0 ? i3 : -1, (i4 & 256) == 0 ? str6 : "");
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final String getCustomModeId() {
        return this.customModeId;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getSettingInfo() {
        return this.settingInfo;
    }

    public final void setSettingInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.settingInfo = str;
    }
}
