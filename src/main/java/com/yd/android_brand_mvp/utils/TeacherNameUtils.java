package com.yd.android_brand_mvp.utils;

import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.model.KBRsp2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TeacherNameUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/utils/TeacherNameUtils;", "", "()V", "getStringByList", "", TUIKitConstants.Selection.LIST, "", "getTeacherNameByList", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO$TeacherListDTO;", "getTeacherNameList", "teacherName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TeacherNameUtils {
    public static final TeacherNameUtils INSTANCE = new TeacherNameUtils();

    private TeacherNameUtils() {
    }

    public final String getTeacherNameList(String teacherName) {
        Intrinsics.checkNotNullParameter(teacherName, "teacherName");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : (String[]) StringsKt.split$default((CharSequence) teacherName, new String[]{com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null).toArray(new String[0])) {
            if (str.length() <= 4) {
                if (str.length() == 0) {
                    stringBuffer.append(str);
                    stringBuffer.append("无");
                } else {
                    stringBuffer.append(str);
                    stringBuffer.append("  ");
                }
            } else {
                String strSubstring = str.substring(0, 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                stringBuffer.append(strSubstring);
                stringBuffer.append("…  ");
            }
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public final String getTeacherNameByList(List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO teacherListDTO : list) {
            int i2 = i + 1;
            if (teacherListDTO.name.length() <= 4) {
                String str = teacherListDTO.name;
                Intrinsics.checkNotNullExpressionValue(str, "teacher.name");
                if (str.length() == 0) {
                    stringBuffer.append(teacherListDTO.name);
                    stringBuffer.append("无");
                } else if (i == list.size() - 1) {
                    stringBuffer.append(teacherListDTO.name);
                    stringBuffer.append("");
                } else {
                    stringBuffer.append(teacherListDTO.name);
                    stringBuffer.append(" ，");
                }
            } else {
                stringBuffer.append(teacherListDTO.name);
            }
            i = i2;
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public final String getStringByList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            if (i == list.size() - 1) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append(str);
                stringBuffer.append("\n");
            }
            i = i2;
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }
}
