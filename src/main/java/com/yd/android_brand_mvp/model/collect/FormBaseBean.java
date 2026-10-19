package com.yd.android_brand_mvp.model.collect;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormBaseBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0019HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003JÃ\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001J\u0013\u0010T\u001a\u00020\u00032\b\u0010U\u001a\u0004\u0018\u00010VHÖ\u0003J\t\u0010W\u001a\u00020\u0007HÖ\u0001J\t\u0010X\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010#\"\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010)\"\u0004\b0\u00101R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u00101R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u00101R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\"R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010@R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001c¨\u0006Y"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "isKit", "", "kitId", "", "parentSort", "", "children", "", "attribute", "valueType", AppMeasurementSdk.ConditionalUserProperty.NAME, "icon", "title", "value", "valueData", "", "Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;", "sort", "sortNum", "limitCondition", "id", "isRequestOptions", "props", "Lcom/yd/android_brand_mvp/model/collect/FormProps;", "(ZLjava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IILjava/lang/String;Ljava/lang/String;ZLcom/yd/android_brand_mvp/model/collect/FormProps;)V", "getAttribute", "()Ljava/lang/String;", "getChildren", "()Ljava/util/List;", "getIcon", "getId", "setId", "(Ljava/lang/String;)V", "()Z", "setKit", "(Z)V", "setRequestOptions", "itemType", "getItemType", "()I", "getKitId", "setKitId", "getLimitCondition", "getName", "setName", "getParentSort", "setParentSort", "(I)V", "getProps", "()Lcom/yd/android_brand_mvp/model/collect/FormProps;", "setProps", "(Lcom/yd/android_brand_mvp/model/collect/FormProps;)V", "getSort", "setSort", "getSortNum", "setSortNum", "getTitle", "setTitle", "getValue", "setValue", "getValueData", "setValueData", "(Ljava/util/List;)V", "getValueType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormBaseBean implements MultiItemEntity {
    private final String attribute;
    private final List<FormBaseBean> children;
    private final String icon;
    private String id;
    private boolean isKit;
    private boolean isRequestOptions;
    private String kitId;
    private final String limitCondition;
    private String name;
    private int parentSort;
    private FormProps props;
    private int sort;
    private int sortNum;
    private String title;
    private String value;
    private List<BaseArrayBean> valueData;
    private final String valueType;

    public FormBaseBean() {
        this(false, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, 131071, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsKit() {
        return this.isKit;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final List<BaseArrayBean> component11() {
        return this.valueData;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getSortNum() {
        return this.sortNum;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLimitCondition() {
        return this.limitCondition;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsRequestOptions() {
        return this.isRequestOptions;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final FormProps getProps() {
        return this.props;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKitId() {
        return this.kitId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getParentSort() {
        return this.parentSort;
    }

    public final List<FormBaseBean> component4() {
        return this.children;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAttribute() {
        return this.attribute;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getValueType() {
        return this.valueType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final FormBaseBean copy(boolean isKit, String kitId, int parentSort, List<FormBaseBean> children, String attribute, String valueType, String name, String icon, String title, String value, List<BaseArrayBean> valueData, int sort, int sortNum, String limitCondition, String id, boolean isRequestOptions, FormProps props) {
        Intrinsics.checkNotNullParameter(kitId, "kitId");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(limitCondition, "limitCondition");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(props, "props");
        return new FormBaseBean(isKit, kitId, parentSort, children, attribute, valueType, name, icon, title, value, valueData, sort, sortNum, limitCondition, id, isRequestOptions, props);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormBaseBean)) {
            return false;
        }
        FormBaseBean formBaseBean = (FormBaseBean) other;
        return this.isKit == formBaseBean.isKit && Intrinsics.areEqual(this.kitId, formBaseBean.kitId) && this.parentSort == formBaseBean.parentSort && Intrinsics.areEqual(this.children, formBaseBean.children) && Intrinsics.areEqual(this.attribute, formBaseBean.attribute) && Intrinsics.areEqual(this.valueType, formBaseBean.valueType) && Intrinsics.areEqual(this.name, formBaseBean.name) && Intrinsics.areEqual(this.icon, formBaseBean.icon) && Intrinsics.areEqual(this.title, formBaseBean.title) && Intrinsics.areEqual(this.value, formBaseBean.value) && Intrinsics.areEqual(this.valueData, formBaseBean.valueData) && this.sort == formBaseBean.sort && this.sortNum == formBaseBean.sortNum && Intrinsics.areEqual(this.limitCondition, formBaseBean.limitCondition) && Intrinsics.areEqual(this.id, formBaseBean.id) && this.isRequestOptions == formBaseBean.isRequestOptions && Intrinsics.areEqual(this.props, formBaseBean.props);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.isKit;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((((((((((((((r0 * 31) + this.kitId.hashCode()) * 31) + this.parentSort) * 31) + this.children.hashCode()) * 31) + this.attribute.hashCode()) * 31) + this.valueType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.value;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<BaseArrayBean> list = this.valueData;
        int iHashCode3 = (((((((((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.sort) * 31) + this.sortNum) * 31) + this.limitCondition.hashCode()) * 31) + this.id.hashCode()) * 31;
        boolean z2 = this.isRequestOptions;
        return ((iHashCode3 + (z2 ? 1 : z2)) * 31) + this.props.hashCode();
    }

    public String toString() {
        return "FormBaseBean(isKit=" + this.isKit + ", kitId=" + this.kitId + ", parentSort=" + this.parentSort + ", children=" + this.children + ", attribute=" + this.attribute + ", valueType=" + this.valueType + ", name=" + this.name + ", icon=" + this.icon + ", title=" + this.title + ", value=" + this.value + ", valueData=" + this.valueData + ", sort=" + this.sort + ", sortNum=" + this.sortNum + ", limitCondition=" + this.limitCondition + ", id=" + this.id + ", isRequestOptions=" + this.isRequestOptions + ", props=" + this.props + ')';
    }

    public FormBaseBean(boolean z, String kitId, int i, List<FormBaseBean> children, String attribute, String valueType, String name, String icon, String title, String str, List<BaseArrayBean> list, int i2, int i3, String limitCondition, String id, boolean z2, FormProps props) {
        Intrinsics.checkNotNullParameter(kitId, "kitId");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(limitCondition, "limitCondition");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(props, "props");
        this.isKit = z;
        this.kitId = kitId;
        this.parentSort = i;
        this.children = children;
        this.attribute = attribute;
        this.valueType = valueType;
        this.name = name;
        this.icon = icon;
        this.title = title;
        this.value = str;
        this.valueData = list;
        this.sort = i2;
        this.sortNum = i3;
        this.limitCondition = limitCondition;
        this.id = id;
        this.isRequestOptions = z2;
        this.props = props;
    }

    public final boolean isKit() {
        return this.isKit;
    }

    public final void setKit(boolean z) {
        this.isKit = z;
    }

    public final String getKitId() {
        return this.kitId;
    }

    public final void setKitId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.kitId = str;
    }

    public final int getParentSort() {
        return this.parentSort;
    }

    public final void setParentSort(int i) {
        this.parentSort = i;
    }

    public /* synthetic */ FormBaseBean(boolean z, String str, int i, List list, String str2, String str3, String str4, String str5, String str6, String str7, List list2, int i2, int i3, String str8, String str9, boolean z2, FormProps formProps, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? new ArrayList() : list, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? "" : str4, (i4 & 128) != 0 ? "" : str5, (i4 & 256) != 0 ? "" : str6, (i4 & 512) != 0 ? "" : str7, (i4 & 1024) != 0 ? null : list2, (i4 & 2048) != 0 ? 0 : i2, (i4 & 4096) != 0 ? 0 : i3, (i4 & 8192) != 0 ? "" : str8, (i4 & 16384) != 0 ? "" : str9, (i4 & 32768) != 0 ? false : z2, (i4 & 65536) != 0 ? new FormProps(false, false, false, null, false, false, false, null, 0, false, false, false, false, 0, false, 0, 0, null, 0, null, null, 2097151, null) : formProps);
    }

    public final List<FormBaseBean> getChildren() {
        return this.children;
    }

    public final String getAttribute() {
        return this.attribute;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final List<BaseArrayBean> getValueData() {
        return this.valueData;
    }

    public final void setValueData(List<BaseArrayBean> list) {
        this.valueData = list;
    }

    public final int getSort() {
        return this.sort;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final int getSortNum() {
        return this.sortNum;
    }

    public final void setSortNum(int i) {
        this.sortNum = i;
    }

    public final String getLimitCondition() {
        return this.limitCondition;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final boolean isRequestOptions() {
        return this.isRequestOptions;
    }

    public final void setRequestOptions(boolean z) {
        this.isRequestOptions = z;
    }

    public final FormProps getProps() {
        return this.props;
    }

    public final void setProps(FormProps formProps) {
        Intrinsics.checkNotNullParameter(formProps, "<set-?>");
        this.props = formProps;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return Intrinsics.areEqual(this.name, FormComponentUtil.DateTimeRange) ? 1 : 0;
    }
}
