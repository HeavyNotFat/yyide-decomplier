package com.yd.android_brand_mvp.model.consult;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsultLabelBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/consult/ConsultLabelBean;", "Landroid/os/Parcelable;", "briefIntroduction", "", "employeeId", "id", "labelKey", "schoolId", "sendWord", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBriefIntroduction", "()Ljava/lang/String;", "getEmployeeId", "getId", "getLabelKey", "getSchoolId", "getSendWord", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ConsultLabelBean implements Parcelable {
    public static final Parcelable.Creator<ConsultLabelBean> CREATOR = new Creator();
    private final String briefIntroduction;
    private final String employeeId;
    private final String id;
    private final String labelKey;
    private final String schoolId;
    private final String sendWord;

    /* JADX INFO: compiled from: ConsultLabelBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ConsultLabelBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsultLabelBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConsultLabelBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsultLabelBean[] newArray(int i) {
            return new ConsultLabelBean[i];
        }
    }

    public static /* synthetic */ ConsultLabelBean copy$default(ConsultLabelBean consultLabelBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consultLabelBean.briefIntroduction;
        }
        if ((i & 2) != 0) {
            str2 = consultLabelBean.employeeId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = consultLabelBean.id;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = consultLabelBean.labelKey;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = consultLabelBean.schoolId;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = consultLabelBean.sendWord;
        }
        return consultLabelBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBriefIntroduction() {
        return this.briefIntroduction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmployeeId() {
        return this.employeeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLabelKey() {
        return this.labelKey;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSendWord() {
        return this.sendWord;
    }

    public final ConsultLabelBean copy(String briefIntroduction, String employeeId, String id, String labelKey, String schoolId, String sendWord) {
        Intrinsics.checkNotNullParameter(briefIntroduction, "briefIntroduction");
        Intrinsics.checkNotNullParameter(employeeId, "employeeId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(labelKey, "labelKey");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(sendWord, "sendWord");
        return new ConsultLabelBean(briefIntroduction, employeeId, id, labelKey, schoolId, sendWord);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsultLabelBean)) {
            return false;
        }
        ConsultLabelBean consultLabelBean = (ConsultLabelBean) other;
        return Intrinsics.areEqual(this.briefIntroduction, consultLabelBean.briefIntroduction) && Intrinsics.areEqual(this.employeeId, consultLabelBean.employeeId) && Intrinsics.areEqual(this.id, consultLabelBean.id) && Intrinsics.areEqual(this.labelKey, consultLabelBean.labelKey) && Intrinsics.areEqual(this.schoolId, consultLabelBean.schoolId) && Intrinsics.areEqual(this.sendWord, consultLabelBean.sendWord);
    }

    public int hashCode() {
        return (((((((((this.briefIntroduction.hashCode() * 31) + this.employeeId.hashCode()) * 31) + this.id.hashCode()) * 31) + this.labelKey.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.sendWord.hashCode();
    }

    public String toString() {
        return "ConsultLabelBean(briefIntroduction=" + this.briefIntroduction + ", employeeId=" + this.employeeId + ", id=" + this.id + ", labelKey=" + this.labelKey + ", schoolId=" + this.schoolId + ", sendWord=" + this.sendWord + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.briefIntroduction);
        parcel.writeString(this.employeeId);
        parcel.writeString(this.id);
        parcel.writeString(this.labelKey);
        parcel.writeString(this.schoolId);
        parcel.writeString(this.sendWord);
    }

    public ConsultLabelBean(String briefIntroduction, String employeeId, String id, String labelKey, String schoolId, String sendWord) {
        Intrinsics.checkNotNullParameter(briefIntroduction, "briefIntroduction");
        Intrinsics.checkNotNullParameter(employeeId, "employeeId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(labelKey, "labelKey");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(sendWord, "sendWord");
        this.briefIntroduction = briefIntroduction;
        this.employeeId = employeeId;
        this.id = id;
        this.labelKey = labelKey;
        this.schoolId = schoolId;
        this.sendWord = sendWord;
    }

    public final String getBriefIntroduction() {
        return this.briefIntroduction;
    }

    public final String getEmployeeId() {
        return this.employeeId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabelKey() {
        return this.labelKey;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getSendWord() {
        return this.sendWord;
    }
}
