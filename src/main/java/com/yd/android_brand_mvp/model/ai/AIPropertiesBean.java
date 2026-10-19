package com.yd.android_brand_mvp.model.ai;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIPropertiesBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/AIPropertiesBean;", "Landroid/os/Parcelable;", "instructions", "Lcom/yd/android_brand_mvp/model/ai/AIInstructionsBean;", "maxTokens", "", "temperature", "top_k", "top_p", "welcomeMessage", "(Lcom/yd/android_brand_mvp/model/ai/AIInstructionsBean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInstructions", "()Lcom/yd/android_brand_mvp/model/ai/AIInstructionsBean;", "getMaxTokens", "()Ljava/lang/String;", "getTemperature", "getTop_k", "getTop_p", "getWelcomeMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AIPropertiesBean implements Parcelable {
    public static final Parcelable.Creator<AIPropertiesBean> CREATOR = new Creator();
    private final AIInstructionsBean instructions;
    private final String maxTokens;
    private final String temperature;
    private final String top_k;
    private final String top_p;
    private final String welcomeMessage;

    /* JADX INFO: compiled from: AIPropertiesBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AIPropertiesBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AIPropertiesBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AIPropertiesBean(parcel.readInt() == 0 ? null : AIInstructionsBean.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AIPropertiesBean[] newArray(int i) {
            return new AIPropertiesBean[i];
        }
    }

    public AIPropertiesBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ AIPropertiesBean copy$default(AIPropertiesBean aIPropertiesBean, AIInstructionsBean aIInstructionsBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            aIInstructionsBean = aIPropertiesBean.instructions;
        }
        if ((i & 2) != 0) {
            str = aIPropertiesBean.maxTokens;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = aIPropertiesBean.temperature;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = aIPropertiesBean.top_k;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = aIPropertiesBean.top_p;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = aIPropertiesBean.welcomeMessage;
        }
        return aIPropertiesBean.copy(aIInstructionsBean, str6, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AIInstructionsBean getInstructions() {
        return this.instructions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMaxTokens() {
        return this.maxTokens;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTop_k() {
        return this.top_k;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTop_p() {
        return this.top_p;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public final AIPropertiesBean copy(AIInstructionsBean instructions, String maxTokens, String temperature, String top_k, String top_p, String welcomeMessage) {
        Intrinsics.checkNotNullParameter(maxTokens, "maxTokens");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(top_k, "top_k");
        Intrinsics.checkNotNullParameter(top_p, "top_p");
        Intrinsics.checkNotNullParameter(welcomeMessage, "welcomeMessage");
        return new AIPropertiesBean(instructions, maxTokens, temperature, top_k, top_p, welcomeMessage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIPropertiesBean)) {
            return false;
        }
        AIPropertiesBean aIPropertiesBean = (AIPropertiesBean) other;
        return Intrinsics.areEqual(this.instructions, aIPropertiesBean.instructions) && Intrinsics.areEqual(this.maxTokens, aIPropertiesBean.maxTokens) && Intrinsics.areEqual(this.temperature, aIPropertiesBean.temperature) && Intrinsics.areEqual(this.top_k, aIPropertiesBean.top_k) && Intrinsics.areEqual(this.top_p, aIPropertiesBean.top_p) && Intrinsics.areEqual(this.welcomeMessage, aIPropertiesBean.welcomeMessage);
    }

    public int hashCode() {
        AIInstructionsBean aIInstructionsBean = this.instructions;
        return ((((((((((aIInstructionsBean == null ? 0 : aIInstructionsBean.hashCode()) * 31) + this.maxTokens.hashCode()) * 31) + this.temperature.hashCode()) * 31) + this.top_k.hashCode()) * 31) + this.top_p.hashCode()) * 31) + this.welcomeMessage.hashCode();
    }

    public String toString() {
        return "AIPropertiesBean(instructions=" + this.instructions + ", maxTokens=" + this.maxTokens + ", temperature=" + this.temperature + ", top_k=" + this.top_k + ", top_p=" + this.top_p + ", welcomeMessage=" + this.welcomeMessage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        AIInstructionsBean aIInstructionsBean = this.instructions;
        if (aIInstructionsBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            aIInstructionsBean.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.maxTokens);
        parcel.writeString(this.temperature);
        parcel.writeString(this.top_k);
        parcel.writeString(this.top_p);
        parcel.writeString(this.welcomeMessage);
    }

    public AIPropertiesBean(AIInstructionsBean aIInstructionsBean, String maxTokens, String temperature, String top_k, String top_p, String welcomeMessage) {
        Intrinsics.checkNotNullParameter(maxTokens, "maxTokens");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(top_k, "top_k");
        Intrinsics.checkNotNullParameter(top_p, "top_p");
        Intrinsics.checkNotNullParameter(welcomeMessage, "welcomeMessage");
        this.instructions = aIInstructionsBean;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.top_k = top_k;
        this.top_p = top_p;
        this.welcomeMessage = welcomeMessage;
    }

    public /* synthetic */ AIPropertiesBean(AIInstructionsBean aIInstructionsBean, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aIInstructionsBean, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) == 0 ? str5 : "");
    }

    public final AIInstructionsBean getInstructions() {
        return this.instructions;
    }

    public final String getMaxTokens() {
        return this.maxTokens;
    }

    public final String getTemperature() {
        return this.temperature;
    }

    public final String getTop_k() {
        return this.top_k;
    }

    public final String getTop_p() {
        return this.top_p;
    }

    public final String getWelcomeMessage() {
        return this.welcomeMessage;
    }
}
