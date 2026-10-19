package com.yd.android_brand_mvp.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogListMessage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/DialogBean;", "", "id", "", "mesasge", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "getId", "()Ljava/lang/String;", "getMesasge", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/yd/android_brand_mvp/dialog/DialogBean;", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DialogBean {
    private final String id;
    private final Double mesasge;

    public static /* synthetic */ DialogBean copy$default(DialogBean dialogBean, String str, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogBean.id;
        }
        if ((i & 2) != 0) {
            d = dialogBean.mesasge;
        }
        return dialogBean.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getMesasge() {
        return this.mesasge;
    }

    public final DialogBean copy(String id, Double mesasge) {
        return new DialogBean(id, mesasge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogBean)) {
            return false;
        }
        DialogBean dialogBean = (DialogBean) other;
        return Intrinsics.areEqual(this.id, dialogBean.id) && Intrinsics.areEqual((Object) this.mesasge, (Object) dialogBean.mesasge);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.mesasge;
        return iHashCode + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "DialogBean(id=" + this.id + ", mesasge=" + this.mesasge + ')';
    }

    public DialogBean(String str, Double d) {
        this.id = str;
        this.mesasge = d;
    }

    public final String getId() {
        return this.id;
    }

    public final Double getMesasge() {
        return this.mesasge;
    }
}
