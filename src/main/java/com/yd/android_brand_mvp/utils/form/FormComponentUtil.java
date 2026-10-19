package com.yd.android_brand_mvp.utils.form;

import androidx.fragment.app.Fragment;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormDateRangeBean;
import com.yd.android_brand_mvp.model.collect.FormLocationBean;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormComponentUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/utils/form/FormComponentUtil;", "", "()V", "AutoLocation", "", "ClassPicker", "DateTime", FormComponentUtil.DateTimeRange, FormComponentUtil.DeptPicker, FormComponentUtil.LeaveType, "Location", FormComponentUtil.MultipleCascader, FormComponentUtil.MultipleSelect, FormComponentUtil.NumberID, FormComponentUtil.NumberInput, "PhoneInput", "SignaturePad", "SingleSelect", "StudentGradeGlass", FormComponentUtil.TextInput, FormComponentUtil.TextareaInput, "UploadFile", "UploadImage", "getComponentFragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", CommentsHomeFragment.TYPE_ID, "parseDataValueToShowValue", AppMeasurementSdk.ConditionalUserProperty.NAME, "dataValue", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormComponentUtil {
    public static final String AutoLocation = "Location";
    public static final String ClassPicker = "ClassesPicker";
    public static final String DateTime = "DateTime";
    public static final String DateTimeRange = "DateTimeRange";
    public static final String DeptPicker = "DeptPicker";
    public static final FormComponentUtil INSTANCE = new FormComponentUtil();
    public static final String LeaveType = "LeaveType";
    public static final String Location = "Area";
    public static final String MultipleCascader = "MultipleCascader";
    public static final String MultipleSelect = "MultipleSelect";
    public static final String NumberID = "NumberID";
    public static final String NumberInput = "NumberInput";
    public static final String PhoneInput = "Phone";
    public static final String SignaturePad = "SignName";
    public static final String SingleSelect = "SelectInput";
    public static final String StudentGradeGlass = "RollPicker";
    public static final String TextInput = "TextInput";
    public static final String TextareaInput = "TextareaInput";
    public static final String UploadFile = "FileUpload";
    public static final String UploadImage = "ImageUpload";

    private FormComponentUtil() {
    }

    public static /* synthetic */ Fragment getComponentFragment$default(FormComponentUtil formComponentUtil, FormBaseBean formBaseBean, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return formComponentUtil.getComponentFragment(formBaseBean, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
    
        return com.yd.android_brand_mvp.activity.collect.fragment.FormEditFragment.INSTANCE.newInstance(r4, r4.getName(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.TextInput) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.MultipleCascader) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.PhoneInput) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0146, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.TextareaInput) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014f, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.ClassPicker) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0168, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.NumberID) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0171, code lost:
    
        if (r0.equals(com.yd.android_brand_mvp.utils.form.FormComponentUtil.NumberInput) == false) goto L91;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.fragment.app.Fragment getComponentFragment(com.yd.android_brand_mvp.model.collect.FormBaseBean r4, java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.utils.form.FormComponentUtil.getComponentFragment(com.yd.android_brand_mvp.model.collect.FormBaseBean, java.lang.String):androidx.fragment.app.Fragment");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:101:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:104:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:109:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:129:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    /* JADX WARN: Code duplicated, block: B:35:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:90:0x0180  */
    /* JADX WARN: Code duplicated, block: B:91:0x0182  */
    /* JADX WARN: Code duplicated, block: B:93:0x0185  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String parseDataValueToShowValue(String name, String dataValue) {
        FormDateRangeBean formDateRangeBean;
        boolean z;
        List valueList;
        List list;
        StringBuilder sb;
        boolean z2;
        List valueList2;
        List list2;
        StringBuilder sb2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dataValue, "dataValue");
        boolean z3 = true;
        int i = 0;
        switch (name.hashCode()) {
            case -1768304062:
                if (!name.equals(DateTimeRange)) {
                    return dataValue;
                }
                if ((dataValue.length() > 0) && (formDateRangeBean = (FormDateRangeBean) GsonUtils.fromJson(dataValue, FormDateRangeBean.class)) != null) {
                    return formDateRangeBean.getStartTime() + (char) 33267 + formDateRangeBean.getEndTime();
                }
                return "";
            case -446447939:
                if (!name.equals(UploadFile)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    valueList = (List) GsonUtils.fromJson(dataValue, new TypeToken<List<? extends UploadFileBean>>() { // from class: com.yd.android_brand_mvp.utils.form.FormComponentUtil$parseDataValueToShowValue$valueList$3
                    }.getType());
                    list = valueList;
                    if (list != null && !list.isEmpty()) {
                        z3 = false;
                    }
                    if (z3) {
                        return "";
                    }
                    sb = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(valueList, "valueList");
                    for (Object obj : valueList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb.append(((UploadFileBean) obj).getName());
                        if (i != CollectionsKt.getLastIndex(valueList)) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i = i2;
                    }
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "showValue.toString()");
                    return string;
                }
                return "";
            case -398353636:
                if (!name.equals(UploadImage)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    valueList = (List) GsonUtils.fromJson(dataValue, new TypeToken<List<? extends UploadFileBean>>() { // from class: com.yd.android_brand_mvp.utils.form.FormComponentUtil$parseDataValueToShowValue$valueList$3
                    }.getType());
                    list = valueList;
                    if (list != null) {
                        z3 = false;
                    }
                    if (z3) {
                        return "";
                    }
                    sb = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(valueList, "valueList");
                    while (r0.hasNext()) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb.append(((UploadFileBean) obj).getName());
                        if (i != CollectionsKt.getLastIndex(valueList)) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i = i3;
                    }
                    String string2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "showValue.toString()");
                    return string2;
                }
                return "";
            case -42809524:
                if (!name.equals(MultipleSelect)) {
                    return dataValue;
                }
                ArrayList arrayList = new ArrayList();
                if (dataValue.length() > 0) {
                    List valueList3 = (List) GsonUtils.fromJson(dataValue, new TypeToken<List<? extends String>>() { // from class: com.yd.android_brand_mvp.utils.form.FormComponentUtil$parseDataValueToShowValue$valueList$2
                    }.getType());
                    Intrinsics.checkNotNullExpressionValue(valueList3, "valueList");
                    arrayList.addAll(valueList3);
                }
                StringBuilder sb3 = new StringBuilder();
                for (Object obj2 : arrayList) {
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    sb3.append((String) obj2);
                    if (i != CollectionsKt.getLastIndex(arrayList)) {
                        sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    i = i4;
                }
                String string3 = sb3.toString();
                Intrinsics.checkNotNullExpressionValue(string3, "{\n                val se….toString()\n            }");
                return string3;
            case 2049197:
                if (!name.equals(Location)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    return ((FormLocationBean) GsonUtils.fromJson(dataValue, FormLocationBean.class)).getAddress();
                }
                return "";
            case 375785992:
                if (!name.equals(SignaturePad)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    return ((UploadFileBean) GsonUtils.fromJson(dataValue, UploadFileBean.class)).getName();
                }
                return "";
            case 637996686:
                if (!name.equals(MultipleCascader)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    valueList2 = (List) GsonUtils.fromJson(dataValue, new TypeToken<List<? extends BaseArrayBean>>() { // from class: com.yd.android_brand_mvp.utils.form.FormComponentUtil$parseDataValueToShowValue$valueList$1
                    }.getType());
                    list2 = valueList2;
                    if (list2 != null && !list2.isEmpty()) {
                        z3 = false;
                    }
                    if (z3) {
                        return "";
                    }
                    sb2 = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(valueList2, "valueList");
                    for (Object obj3 : valueList2) {
                        int i5 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb2.append(((BaseArrayBean) obj3).getName());
                        if (i != CollectionsKt.getLastIndex(valueList2)) {
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i = i5;
                    }
                    String string4 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string4, "showValue.toString()");
                    return string4;
                }
                return "";
            case 1003241355:
                if (!name.equals(StudentGradeGlass)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    valueList2 = (List) GsonUtils.fromJson(dataValue, new TypeToken<List<? extends BaseArrayBean>>() { // from class: com.yd.android_brand_mvp.utils.form.FormComponentUtil$parseDataValueToShowValue$valueList$1
                    }.getType());
                    list2 = valueList2;
                    if (list2 != null) {
                        z3 = false;
                    }
                    if (z3) {
                        return "";
                    }
                    sb2 = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(valueList2, "valueList");
                    while (r0.hasNext()) {
                        int i6 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb2.append(((BaseArrayBean) obj3).getName());
                        if (i != CollectionsKt.getLastIndex(valueList2)) {
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i = i6;
                    }
                    String string5 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string5, "showValue.toString()");
                    return string5;
                }
                return "";
            case 1540507475:
                if (!name.equals(DeptPicker)) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    valueList2 = (List) GsonUtils.fromJson(dataValue, new TypeToken<List<? extends BaseArrayBean>>() { // from class: com.yd.android_brand_mvp.utils.form.FormComponentUtil$parseDataValueToShowValue$valueList$1
                    }.getType());
                    list2 = valueList2;
                    if (list2 != null) {
                        z3 = false;
                    }
                    if (z3) {
                        return "";
                    }
                    sb2 = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(valueList2, "valueList");
                    while (r0.hasNext()) {
                        int i7 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb2.append(((BaseArrayBean) obj3).getName());
                        if (i != CollectionsKt.getLastIndex(valueList2)) {
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i = i7;
                    }
                    String string6 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string6, "showValue.toString()");
                    return string6;
                }
                return "";
            case 1965687765:
                if (!name.equals("Location")) {
                    return dataValue;
                }
                if (dataValue.length() > 0) {
                    return ((FormLocationBean) GsonUtils.fromJson(dataValue, FormLocationBean.class)).getAddress();
                }
                return "";
            default:
                return dataValue;
        }
    }
}
