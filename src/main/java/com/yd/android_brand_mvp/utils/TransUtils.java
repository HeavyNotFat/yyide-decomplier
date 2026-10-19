package com.yd.android_brand_mvp.utils;

import com.blankj.utilcode.util.ScreenUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: TransUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012J\u000e\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004J\u000e\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004J\n\u00105\u001a\u00020\u0004*\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/yd/android_brand_mvp/utils/TransUtils;", "", "()V", "DOC", "", "DOCX", "MIME_ALL", "MIME_AUDIO", "MIME_IMAGE", "MIME_TEXT", "MIME_VIDEO", "PDF", "PPT", "PPTX", "XLS", "XLSX", "convertToChinese", "number", "", "docStrToImageInt", "str", "getCollectBackgroundImageByDataPosition", "position", "getCollectBackgroundImageByDataPosition2", "getCollectBtnColorByDataPosition", "mode", "getFileTypeByName", "fileName", "getLeaveModeSteByLeaveMode", "getLeaveNodeTipLogoByLeaveOutcome", "outcome", "(Ljava/lang/String;)Ljava/lang/Integer;", "getLeaveStatusSteByLeaveOutcome", "getShowTimeToRightFormat", IjkMediaMeta.IJKM_KEY_FORMAT, "getShowTimeTypeArray", "", "getVoteTypeIfSingleSelect", "", "type", "transClassTypeToStrType", "transHonorLevelToStr", FirebaseAnalytics.Param.LEVEL, "transIntToString", "transSiteBookingTypeCodeToBackground", "content", "transSiteBookingTypeCodeToBackground24", "transSiteBookingTypeCodeToBackgroundMax", "transTaskFrequencyToChinese", "frequency", "transTaskStatusToChinese", "status", "transTaskStatusToColors", "toChineseNumber", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransUtils {
    public static final String DOC = "application/msword";
    public static final String DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final TransUtils INSTANCE = new TransUtils();
    public static final String MIME_ALL = "*/*";
    public static final String MIME_AUDIO = "audio/*";
    public static final String MIME_IMAGE = "image/*";
    public static final String MIME_TEXT = "text/*";
    public static final String MIME_VIDEO = "video/*";
    public static final String PDF = "application/pdf";
    public static final String PPT = "application/vnd.ms-powerpoint";
    public static final String PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    public static final String XLS = "application/vnd.ms-excel application/x-excel";
    public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public final boolean getVoteTypeIfSingleSelect(int type) {
        return type == 1 || type == 3;
    }

    public final String transClassTypeToStrType(int type) {
        if (type == 1) {
            return "campus";
        }
        if (type == 2) {
            return "academics";
        }
        if (type != 3) {
            return type != 4 ? "school" : "class";
        }
        return "grade";
    }

    public final String transHonorLevelToStr(int level) {
        if (level == 1) {
            return "校级";
        }
        if (level != 2) {
            return level != 3 ? "其他" : "国家级";
        }
        return "省级";
    }

    public final int transSiteBookingTypeCodeToBackground(int content) {
        if (content == 1) {
            return R.mipmap.bg_reserve_meeting;
        }
        if (content != 2) {
            return content != 3 ? R.mipmap.bg_reserve_other : R.mipmap.bg_reserve_activity;
        }
        return R.mipmap.bg_reserve_classroom;
    }

    public final int transSiteBookingTypeCodeToBackground24(int content) {
        if (content == 1) {
            return R.mipmap.bg_reserve_meeting_24;
        }
        if (content != 2) {
            return content != 3 ? R.mipmap.bg_reserve_other_24 : R.mipmap.bg_reserve_activity_24;
        }
        return R.mipmap.bg_reserve_classroom_24;
    }

    public final int transSiteBookingTypeCodeToBackgroundMax(int content) {
        if (content == 1) {
            return R.mipmap.bg_reserve_meeting_max;
        }
        if (content != 2) {
            return content != 3 ? R.mipmap.bg_reserve_other_max : R.mipmap.bg_reserve_activity_max;
        }
        return R.mipmap.bg_reserve_classroom_max;
    }

    private TransUtils() {
    }

    public final String transIntToString(int number) {
        String strValueOf = String.valueOf(number);
        if (strValueOf.length() != 1) {
            return strValueOf;
        }
        return '0' + strValueOf;
    }

    public final String transTaskStatusToChinese(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (Intrinsics.areEqual(status, "not_start")) {
            return "未开始";
        }
        return Intrinsics.areEqual(status, "end") ? "已结束" : "进行中";
    }

    public final String transTaskFrequencyToChinese(String frequency) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        return (!Intrinsics.areEqual(frequency, "single") && Intrinsics.areEqual(frequency, "custom")) ? "自定义" : "单次打卡";
    }

    public final String transTaskStatusToColors(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (Intrinsics.areEqual(status, "not_start")) {
            return "未开始";
        }
        return Intrinsics.areEqual(status, "end") ? "已结束" : "进行中";
    }

    public final String getFileTypeByName(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = fileName;
        if ((str.length() == 0) || StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null) == -1) {
            return "";
        }
        String strSubstring = fileName.substring(StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final int docStrToImageInt(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (StringsKt.startsWith$default(str, "xlsx", false, 2, (Object) null)) {
            return R.mipmap.icon_file_xls;
        }
        if (StringsKt.startsWith$default(str, "ppt", false, 2, (Object) null)) {
            return R.mipmap.icon_file_pdf;
        }
        if (StringsKt.startsWith$default(str, "doc", false, 2, (Object) null)) {
            return R.mipmap.icon_file_word;
        }
        return StringsKt.startsWith$default(str, "pdf", false, 2, (Object) null) ? R.mipmap.icon_file_pdf : R.mipmap.icon_file_image;
    }

    public final int getCollectBtnColorByDataPosition(int position, int mode) {
        int i = position % (mode == 1 ? 3 : 4);
        if (mode == 1) {
            if (i != 0) {
                return (i == 1 || i != 2) ? R.drawable.bg_btn_origin10 : R.drawable.bg_btn_green10_12ddb6;
            }
            return R.drawable.bg_btn_blue10_81a4e6;
        }
        if (i == 0) {
            return R.drawable.bg_btn_blue10_81a4e6;
        }
        if (i != 1) {
            if (i == 2) {
                return R.drawable.bg_btn_origin10;
            }
            if (i == 3) {
                return R.drawable.bg_btn_green10_12ddb6;
            }
        }
        return R.drawable.bg_purple20;
    }

    public final int getCollectBackgroundImageByDataPosition(int position) {
        int i = position % 3;
        if (ScreenUtils.isPortrait()) {
            if (i != 0) {
                return (i == 1 || i != 2) ? R.mipmap.bg_collect_yellow_p : R.mipmap.bg_collect_green_p;
            }
            return R.mipmap.bg_collect_blue_p;
        }
        if (i != 0) {
            return (i == 1 || i != 2) ? R.mipmap.bg_collect_yellow : R.mipmap.bg_collect_green;
        }
        return R.mipmap.bg_collect_blue;
    }

    public final int getCollectBackgroundImageByDataPosition2(int position) {
        int i = position % 4;
        if (ScreenUtils.isPortrait()) {
            if (i == 0) {
                return R.mipmap.bg_collect_blue2_p;
            }
            if (i == 1) {
                return R.mipmap.bg_collect_purple2_p;
            }
            if (i != 2) {
                return i != 3 ? R.mipmap.bg_collect_purple2_p : R.mipmap.bg_collect_green2_p;
            }
            return R.mipmap.bg_collect_origin2_p;
        }
        if (i == 0) {
            return R.mipmap.bg_collect_blue2;
        }
        if (i == 1) {
            return R.mipmap.bg_collect_purple2;
        }
        if (i != 2) {
            return i != 3 ? R.mipmap.bg_collect_purple2 : R.mipmap.bg_collect_green2;
        }
        return R.mipmap.bg_collect_yellow2;
    }

    public final boolean[] getShowTimeTypeArray(String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (Intrinsics.areEqual(format, TimeUtil.allTimeFormat)) {
            return new boolean[]{true, true, true, true, true, true};
        }
        if (Intrinsics.areEqual(format, TimeUtil.dateYMDFormat)) {
            return new boolean[]{true, true, true, false, false, false};
        }
        if (Intrinsics.areEqual(format, TimeUtil.dateYMFormat)) {
            return new boolean[]{true, true, false, false, false, false};
        }
        if (Intrinsics.areEqual(format, TimeUtil.dateYFormat)) {
            return new boolean[]{true, false, false, false, false, false};
        }
        if (!Intrinsics.areEqual(format, "YYYY-MM-DD HH:mm") && Intrinsics.areEqual(format, "YYYY-MM-DD")) {
            return new boolean[]{true, true, true, false, false, false};
        }
        return new boolean[]{true, true, true, true, true, false};
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String getShowTimeToRightFormat(String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        switch (format.hashCode()) {
            case -1485584326:
                if (format.equals("YYYY-MM-DD HH:mm")) {
                    String str = TimeUtil.notSecondFormat;
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                TimeUt…econdFormat\n            }");
                    return str;
                }
                break;
            case -1172057030:
                if (format.equals("yyyy-MM-dd HH:mm")) {
                    String str2 = TimeUtil.notSecondFormat;
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n                TimeUt…econdFormat\n            }");
                    return str2;
                }
                break;
            case -159776256:
                if (format.equals("yyyy-MM-dd")) {
                    String str3 = TimeUtil.dateYMDFormat;
                    Intrinsics.checkNotNullExpressionValue(str3, "{\n                TimeUt…teYMDFormat\n            }");
                    return str3;
                }
                break;
            case 1271985664:
                if (format.equals("YYYY-MM-DD")) {
                    String str4 = TimeUtil.dateYMDFormat;
                    Intrinsics.checkNotNullExpressionValue(str4, "{\n                TimeUt…teYMDFormat\n            }");
                    return str4;
                }
                break;
        }
        String str5 = TimeUtil.allTimeFormat;
        Intrinsics.checkNotNullExpressionValue(str5, "{\n                TimeUt…lTimeFormat\n            }");
        return str5;
    }

    public final String getLeaveModeSteByLeaveMode(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int iHashCode = mode.hashCode();
        if (iHashCode == 2531) {
            return !mode.equals("OR") ? "会签" : "或签";
        }
        if (iHashCode != 64951) {
            return (iHashCode == 2392819 && mode.equals("NEXT")) ? "依次审批" : "会签";
        }
        mode.equals("AND");
        return "会签";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[ORIG_RETURN, RETURN] */
    public final String getLeaveStatusSteByLeaveOutcome(String outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        switch (outcome) {
            case "0":
                return "(拒绝)";
            case "1":
                return "(审批中)";
            case "2":
                return "(通过)";
            default:
                return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Integer getLeaveNodeTipLogoByLeaveOutcome(String outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        switch (outcome.hashCode()) {
            case 48:
                if (outcome.equals("0")) {
                    return Integer.valueOf(R.drawable.icon_leave_refuse);
                }
                return null;
            case 49:
                if (outcome.equals("1")) {
                    return Integer.valueOf(R.drawable.icon_leave_ing);
                }
                return null;
            case 50:
                if (outcome.equals("2")) {
                    return Integer.valueOf(R.drawable.icon_leave_pass);
                }
                return null;
            default:
                return null;
        }
    }

    public final String convertToChinese(int number) {
        String[] strArr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        boolean z = false;
        if (number >= 0 && number < 10) {
            z = true;
        }
        return z ? strArr[number] : String.valueOf(number);
    }

    public final String toChineseNumber(int i) {
        String[] strArr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String strValueOf = String.valueOf(i);
        ArrayList arrayList = new ArrayList(strValueOf.length());
        for (int i2 = 0; i2 < strValueOf.length(); i2++) {
            arrayList.add(strArr[Integer.parseInt(String.valueOf(strValueOf.charAt(i2)))]);
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
    }
}
