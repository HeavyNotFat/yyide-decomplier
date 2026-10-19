package com.yd.android_brand_mvp.model.vote;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Setting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018¨\u00064"}, d2 = {"Lcom/yd/android_brand_mvp/model/vote/Setting;", "", "selfSee", "", "maxOption", "hasImage", "voteId", "", "sumLimit", "accountLimit", "dayLimit", TtmlNode.ANNOTATION_POSITION_OUTSIDE, "repeat", "schoolId", "anonymous", "id", "minOption", "(IIILjava/lang/String;IIIIILjava/lang/String;ILjava/lang/String;I)V", "getAccountLimit", "()I", "getAnonymous", "getDayLimit", "getHasImage", "getId", "()Ljava/lang/String;", "getMaxOption", "getMinOption", "getOutside", "getRepeat", "getSchoolId", "getSelfSee", "getSumLimit", "getVoteId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Setting {
    private final int accountLimit;
    private final int anonymous;
    private final int dayLimit;
    private final int hasImage;
    private final String id;
    private final int maxOption;
    private final int minOption;
    private final int outside;
    private final int repeat;
    private final String schoolId;
    private final int selfSee;
    private final int sumLimit;
    private final String voteId;

    public Setting() {
        this(0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, null, 0, 8191, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSelfSee() {
        return this.selfSee;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getAnonymous() {
        return this.anonymous;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getMinOption() {
        return this.minOption;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxOption() {
        return this.maxOption;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHasImage() {
        return this.hasImage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVoteId() {
        return this.voteId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSumLimit() {
        return this.sumLimit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAccountLimit() {
        return this.accountLimit;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDayLimit() {
        return this.dayLimit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getOutside() {
        return this.outside;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getRepeat() {
        return this.repeat;
    }

    public final Setting copy(int selfSee, int maxOption, int hasImage, String voteId, int sumLimit, int accountLimit, int dayLimit, int outside, int repeat, String schoolId, int anonymous, String id, int minOption) {
        Intrinsics.checkNotNullParameter(voteId, "voteId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(id, "id");
        return new Setting(selfSee, maxOption, hasImage, voteId, sumLimit, accountLimit, dayLimit, outside, repeat, schoolId, anonymous, id, minOption);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Setting)) {
            return false;
        }
        Setting setting = (Setting) other;
        return this.selfSee == setting.selfSee && this.maxOption == setting.maxOption && this.hasImage == setting.hasImage && Intrinsics.areEqual(this.voteId, setting.voteId) && this.sumLimit == setting.sumLimit && this.accountLimit == setting.accountLimit && this.dayLimit == setting.dayLimit && this.outside == setting.outside && this.repeat == setting.repeat && Intrinsics.areEqual(this.schoolId, setting.schoolId) && this.anonymous == setting.anonymous && Intrinsics.areEqual(this.id, setting.id) && this.minOption == setting.minOption;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.selfSee * 31) + this.maxOption) * 31) + this.hasImage) * 31) + this.voteId.hashCode()) * 31) + this.sumLimit) * 31) + this.accountLimit) * 31) + this.dayLimit) * 31) + this.outside) * 31) + this.repeat) * 31) + this.schoolId.hashCode()) * 31) + this.anonymous) * 31) + this.id.hashCode()) * 31) + this.minOption;
    }

    public String toString() {
        return "Setting(selfSee=" + this.selfSee + ", maxOption=" + this.maxOption + ", hasImage=" + this.hasImage + ", voteId=" + this.voteId + ", sumLimit=" + this.sumLimit + ", accountLimit=" + this.accountLimit + ", dayLimit=" + this.dayLimit + ", outside=" + this.outside + ", repeat=" + this.repeat + ", schoolId=" + this.schoolId + ", anonymous=" + this.anonymous + ", id=" + this.id + ", minOption=" + this.minOption + ')';
    }

    public Setting(int i, int i2, int i3, String voteId, int i4, int i5, int i6, int i7, int i8, String schoolId, int i9, String id, int i10) {
        Intrinsics.checkNotNullParameter(voteId, "voteId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(id, "id");
        this.selfSee = i;
        this.maxOption = i2;
        this.hasImage = i3;
        this.voteId = voteId;
        this.sumLimit = i4;
        this.accountLimit = i5;
        this.dayLimit = i6;
        this.outside = i7;
        this.repeat = i8;
        this.schoolId = schoolId;
        this.anonymous = i9;
        this.id = id;
        this.minOption = i10;
    }

    public /* synthetic */ Setting(int i, int i2, int i3, String str, int i4, int i5, int i6, int i7, int i8, String str2, int i9, String str3, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? 0 : i2, (i11 & 4) != 0 ? 0 : i3, (i11 & 8) != 0 ? "" : str, (i11 & 16) != 0 ? 0 : i4, (i11 & 32) != 0 ? 0 : i5, (i11 & 64) != 0 ? 0 : i6, (i11 & 128) != 0 ? 0 : i7, (i11 & 256) != 0 ? 0 : i8, (i11 & 512) != 0 ? "" : str2, (i11 & 1024) != 0 ? 0 : i9, (i11 & 2048) == 0 ? str3 : "", (i11 & 4096) == 0 ? i10 : 0);
    }

    public final int getSelfSee() {
        return this.selfSee;
    }

    public final int getMaxOption() {
        return this.maxOption;
    }

    public final int getHasImage() {
        return this.hasImage;
    }

    public final String getVoteId() {
        return this.voteId;
    }

    public final int getSumLimit() {
        return this.sumLimit;
    }

    public final int getAccountLimit() {
        return this.accountLimit;
    }

    public final int getDayLimit() {
        return this.dayLimit;
    }

    public final int getOutside() {
        return this.outside;
    }

    public final int getRepeat() {
        return this.repeat;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final int getAnonymous() {
        return this.anonymous;
    }

    public final String getId() {
        return this.id;
    }

    public final int getMinOption() {
        return this.minOption;
    }
}
