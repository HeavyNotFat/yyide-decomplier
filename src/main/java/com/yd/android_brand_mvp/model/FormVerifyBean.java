package com.yd.android_brand_mvp.model;

import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormVerifyBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "", "status", "", "errorMessage", "", "sort", "", "dataValue", "dataValueBean", "", "Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;", "type", "(ZLjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDataValue", "()Ljava/lang/String;", "setDataValue", "(Ljava/lang/String;)V", "getDataValueBean", "()Ljava/util/List;", "setDataValueBean", "(Ljava/util/List;)V", "getErrorMessage", "setErrorMessage", "getSort", "()I", "setSort", "(I)V", "getStatus", "()Z", "setStatus", "(Z)V", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormVerifyBean {
    private String dataValue;
    private List<BaseArrayBean> dataValueBean;
    private String errorMessage;
    private int sort;
    private boolean status;
    private String type;

    public FormVerifyBean() {
        this(false, null, 0, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormVerifyBean copy$default(FormVerifyBean formVerifyBean, boolean z, String str, int i, String str2, List list, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = formVerifyBean.status;
        }
        if ((i2 & 2) != 0) {
            str = formVerifyBean.errorMessage;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            i = formVerifyBean.sort;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = formVerifyBean.dataValue;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            list = formVerifyBean.dataValueBean;
        }
        List list2 = list;
        if ((i2 & 32) != 0) {
            str3 = formVerifyBean.type;
        }
        return formVerifyBean.copy(z, str4, i3, str5, list2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDataValue() {
        return this.dataValue;
    }

    public final List<BaseArrayBean> component5() {
        return this.dataValueBean;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final FormVerifyBean copy(boolean status, String errorMessage, int sort, String dataValue, List<BaseArrayBean> dataValueBean, String type) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FormVerifyBean(status, errorMessage, sort, dataValue, dataValueBean, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormVerifyBean)) {
            return false;
        }
        FormVerifyBean formVerifyBean = (FormVerifyBean) other;
        return this.status == formVerifyBean.status && Intrinsics.areEqual(this.errorMessage, formVerifyBean.errorMessage) && this.sort == formVerifyBean.sort && Intrinsics.areEqual(this.dataValue, formVerifyBean.dataValue) && Intrinsics.areEqual(this.dataValueBean, formVerifyBean.dataValueBean) && Intrinsics.areEqual(this.type, formVerifyBean.type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((r0 * 31) + this.errorMessage.hashCode()) * 31) + this.sort) * 31;
        String str = this.dataValue;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<BaseArrayBean> list = this.dataValueBean;
        return ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "FormVerifyBean(status=" + this.status + ", errorMessage=" + this.errorMessage + ", sort=" + this.sort + ", dataValue=" + this.dataValue + ", dataValueBean=" + this.dataValueBean + ", type=" + this.type + ')';
    }

    public FormVerifyBean(boolean z, String errorMessage, int i, String str, List<BaseArrayBean> list, String type) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(type, "type");
        this.status = z;
        this.errorMessage = errorMessage;
        this.sort = i;
        this.dataValue = str;
        this.dataValueBean = list;
        this.type = type;
    }

    public /* synthetic */ FormVerifyBean(boolean z, String str, int i, String str2, List list, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? "必填项未填写" : str, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? null : list, (i2 & 32) != 0 ? "" : str3);
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMessage = str;
    }

    public final int getSort() {
        return this.sort;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final String getDataValue() {
        return this.dataValue;
    }

    public final void setDataValue(String str) {
        this.dataValue = str;
    }

    public final List<BaseArrayBean> getDataValueBean() {
        return this.dataValueBean;
    }

    public final void setDataValueBean(List<BaseArrayBean> list) {
        this.dataValueBean = list;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
