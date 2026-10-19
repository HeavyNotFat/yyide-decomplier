package com.yd.android_brand_mvp.model.vote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/vote/FilesItem;", "", "optionId", "", "id", "voteId", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getOptionId", "getUrl", "getVoteId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FilesItem {
    private final String id;
    private final String optionId;
    private final String url;
    private final String voteId;

    public FilesItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FilesItem copy$default(FilesItem filesItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filesItem.optionId;
        }
        if ((i & 2) != 0) {
            str2 = filesItem.id;
        }
        if ((i & 4) != 0) {
            str3 = filesItem.voteId;
        }
        if ((i & 8) != 0) {
            str4 = filesItem.url;
        }
        return filesItem.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOptionId() {
        return this.optionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVoteId() {
        return this.voteId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final FilesItem copy(String optionId, String id, String voteId, String url) {
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(voteId, "voteId");
        Intrinsics.checkNotNullParameter(url, "url");
        return new FilesItem(optionId, id, voteId, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilesItem)) {
            return false;
        }
        FilesItem filesItem = (FilesItem) other;
        return Intrinsics.areEqual(this.optionId, filesItem.optionId) && Intrinsics.areEqual(this.id, filesItem.id) && Intrinsics.areEqual(this.voteId, filesItem.voteId) && Intrinsics.areEqual(this.url, filesItem.url);
    }

    public int hashCode() {
        return (((((this.optionId.hashCode() * 31) + this.id.hashCode()) * 31) + this.voteId.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "FilesItem(optionId=" + this.optionId + ", id=" + this.id + ", voteId=" + this.voteId + ", url=" + this.url + ')';
    }

    public FilesItem(String optionId, String id, String voteId, String url) {
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(voteId, "voteId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.optionId = optionId;
        this.id = id;
        this.voteId = voteId;
        this.url = url;
    }

    public /* synthetic */ FilesItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getOptionId() {
        return this.optionId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getVoteId() {
        return this.voteId;
    }

    public final String getUrl() {
        return this.url;
    }
}
