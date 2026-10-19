package com.yd.android_brand_mvp.model.ai;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Properties.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0001HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0001HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0001HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0001HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003JW\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/model/ai/Properties;", "", "instructions", "maxTokens", "samplePrompts", "", "", "temperature", "top_k", "top_p", "welcomeMessage", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)V", "getInstructions", "()Ljava/lang/Object;", "getMaxTokens", "getSamplePrompts", "()Ljava/util/List;", "getTemperature", "getTop_k", "getTop_p", "getWelcomeMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Properties {
    private final Object instructions;
    private final Object maxTokens;
    private final List<String> samplePrompts;
    private final Object temperature;
    private final Object top_k;
    private final Object top_p;
    private final String welcomeMessage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Properties copy$default(Properties properties, Object obj, Object obj2, List list, Object obj3, Object obj4, Object obj5, String str, int i, Object obj6) {
        if ((i & 1) != 0) {
            obj = properties.instructions;
        }
        if ((i & 2) != 0) {
            obj2 = properties.maxTokens;
        }
        Object obj7 = obj2;
        if ((i & 4) != 0) {
            list = properties.samplePrompts;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            obj3 = properties.temperature;
        }
        Object obj8 = obj3;
        if ((i & 16) != 0) {
            obj4 = properties.top_k;
        }
        Object obj9 = obj4;
        if ((i & 32) != 0) {
            obj5 = properties.top_p;
        }
        Object obj10 = obj5;
        if ((i & 64) != 0) {
            str = properties.welcomeMessage;
        }
        return properties.copy(obj, obj7, list2, obj8, obj9, obj10, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Object getInstructions() {
        return this.instructions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getMaxTokens() {
        return this.maxTokens;
    }

    public final List<String> component3() {
        return this.samplePrompts;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getTop_k() {
        return this.top_k;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getTop_p() {
        return this.top_p;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public final Properties copy(Object instructions, Object maxTokens, List<String> samplePrompts, Object temperature, Object top_k, Object top_p, String welcomeMessage) {
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        Intrinsics.checkNotNullParameter(maxTokens, "maxTokens");
        Intrinsics.checkNotNullParameter(samplePrompts, "samplePrompts");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(top_k, "top_k");
        Intrinsics.checkNotNullParameter(top_p, "top_p");
        return new Properties(instructions, maxTokens, samplePrompts, temperature, top_k, top_p, welcomeMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Properties)) {
            return false;
        }
        Properties properties = (Properties) other;
        return Intrinsics.areEqual(this.instructions, properties.instructions) && Intrinsics.areEqual(this.maxTokens, properties.maxTokens) && Intrinsics.areEqual(this.samplePrompts, properties.samplePrompts) && Intrinsics.areEqual(this.temperature, properties.temperature) && Intrinsics.areEqual(this.top_k, properties.top_k) && Intrinsics.areEqual(this.top_p, properties.top_p) && Intrinsics.areEqual(this.welcomeMessage, properties.welcomeMessage);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.instructions.hashCode() * 31) + this.maxTokens.hashCode()) * 31) + this.samplePrompts.hashCode()) * 31) + this.temperature.hashCode()) * 31) + this.top_k.hashCode()) * 31) + this.top_p.hashCode()) * 31;
        String str = this.welcomeMessage;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Properties(instructions=" + this.instructions + ", maxTokens=" + this.maxTokens + ", samplePrompts=" + this.samplePrompts + ", temperature=" + this.temperature + ", top_k=" + this.top_k + ", top_p=" + this.top_p + ", welcomeMessage=" + this.welcomeMessage + ')';
    }

    public Properties(Object instructions, Object maxTokens, List<String> samplePrompts, Object temperature, Object top_k, Object top_p, String str) {
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        Intrinsics.checkNotNullParameter(maxTokens, "maxTokens");
        Intrinsics.checkNotNullParameter(samplePrompts, "samplePrompts");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(top_k, "top_k");
        Intrinsics.checkNotNullParameter(top_p, "top_p");
        this.instructions = instructions;
        this.maxTokens = maxTokens;
        this.samplePrompts = samplePrompts;
        this.temperature = temperature;
        this.top_k = top_k;
        this.top_p = top_p;
        this.welcomeMessage = str;
    }

    public /* synthetic */ Properties(Object obj, Object obj2, List list, Object obj3, Object obj4, Object obj5, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, obj2, list, obj3, obj4, obj5, (i & 64) != 0 ? null : str);
    }

    public final Object getInstructions() {
        return this.instructions;
    }

    public final Object getMaxTokens() {
        return this.maxTokens;
    }

    public final List<String> getSamplePrompts() {
        return this.samplePrompts;
    }

    public final Object getTemperature() {
        return this.temperature;
    }

    public final Object getTop_k() {
        return this.top_k;
    }

    public final Object getTop_p() {
        return this.top_p;
    }

    public final String getWelcomeMessage() {
        return this.welcomeMessage;
    }
}
