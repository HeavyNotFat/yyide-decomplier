package com.yd.android_brand_mvp.model.consult;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsultTeacherBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006*"}, d2 = {"Lcom/yd/android_brand_mvp/model/consult/ConsultTeacherBean;", "Landroid/os/Parcelable;", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "avatar", "briefIntroduction", "sendWord", "labelList", "", "Lcom/yd/android_brand_mvp/model/consult/ConsultLabelBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "getBriefIntroduction", "getId", "getLabelList", "()Ljava/util/List;", "getName", "setName", "(Ljava/lang/String;)V", "getSendWord", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ConsultTeacherBean implements Parcelable {
    public static final Parcelable.Creator<ConsultTeacherBean> CREATOR = new Creator();
    private final String avatar;
    private final String briefIntroduction;
    private final String id;
    private final List<ConsultLabelBean> labelList;
    private String name;
    private final String sendWord;

    /* JADX INFO: compiled from: ConsultTeacherBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ConsultTeacherBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsultTeacherBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(ConsultLabelBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new ConsultTeacherBean(string, string2, string3, string4, string5, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsultTeacherBean[] newArray(int i) {
            return new ConsultTeacherBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultTeacherBean copy$default(ConsultTeacherBean consultTeacherBean, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consultTeacherBean.id;
        }
        if ((i & 2) != 0) {
            str2 = consultTeacherBean.name;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = consultTeacherBean.avatar;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = consultTeacherBean.briefIntroduction;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = consultTeacherBean.sendWord;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            list = consultTeacherBean.labelList;
        }
        return consultTeacherBean.copy(str, str6, str7, str8, str9, list);
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
    public final String getAvatar() {
        return this.avatar;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBriefIntroduction() {
        return this.briefIntroduction;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSendWord() {
        return this.sendWord;
    }

    public final List<ConsultLabelBean> component6() {
        return this.labelList;
    }

    public final ConsultTeacherBean copy(String id, String name, String avatar, String briefIntroduction, String sendWord, List<ConsultLabelBean> labelList) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(briefIntroduction, "briefIntroduction");
        Intrinsics.checkNotNullParameter(sendWord, "sendWord");
        return new ConsultTeacherBean(id, name, avatar, briefIntroduction, sendWord, labelList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsultTeacherBean)) {
            return false;
        }
        ConsultTeacherBean consultTeacherBean = (ConsultTeacherBean) other;
        return Intrinsics.areEqual(this.id, consultTeacherBean.id) && Intrinsics.areEqual(this.name, consultTeacherBean.name) && Intrinsics.areEqual(this.avatar, consultTeacherBean.avatar) && Intrinsics.areEqual(this.briefIntroduction, consultTeacherBean.briefIntroduction) && Intrinsics.areEqual(this.sendWord, consultTeacherBean.sendWord) && Intrinsics.areEqual(this.labelList, consultTeacherBean.labelList);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.briefIntroduction.hashCode()) * 31) + this.sendWord.hashCode()) * 31;
        List<ConsultLabelBean> list = this.labelList;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "ConsultTeacherBean(id=" + this.id + ", name=" + this.name + ", avatar=" + this.avatar + ", briefIntroduction=" + this.briefIntroduction + ", sendWord=" + this.sendWord + ", labelList=" + this.labelList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.briefIntroduction);
        parcel.writeString(this.sendWord);
        List<ConsultLabelBean> list = this.labelList;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<ConsultLabelBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    public ConsultTeacherBean(String id, String name, String avatar, String briefIntroduction, String sendWord, List<ConsultLabelBean> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(briefIntroduction, "briefIntroduction");
        Intrinsics.checkNotNullParameter(sendWord, "sendWord");
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.briefIntroduction = briefIntroduction;
        this.sendWord = sendWord;
        this.labelList = list;
    }

    public /* synthetic */ ConsultTeacherBean(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : list);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBriefIntroduction() {
        return this.briefIntroduction;
    }

    public final String getSendWord() {
        return this.sendWord;
    }

    public final List<ConsultLabelBean> getLabelList() {
        return this.labelList;
    }
}
