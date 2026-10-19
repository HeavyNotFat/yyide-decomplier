package com.yd.android_brand_mvp.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: ConversionUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/utils/ConversionUtil;", "", "()V", "conditionWithAuthor", "", "conditionWithBookName", "conditionWithBookType", "conditionWithCallNumber", "conditionWithFull", "conditionWithISBN", "conditionWithPublishEndYear", "conditionWithPublishStartYear", "conditionWithSeriesName", "conditionWithSort", "conditionWithSource", "conditionWithYear", "recommendStatus2String", "status", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConversionUtil {
    public static final ConversionUtil INSTANCE = new ConversionUtil();
    public static final String conditionWithAuthor = "3";
    public static final String conditionWithBookName = "2";
    public static final String conditionWithBookType = "7";
    public static final String conditionWithCallNumber = "6";
    public static final String conditionWithFull = "0";
    public static final String conditionWithISBN = "1";
    public static final String conditionWithPublishEndYear = "9";
    public static final String conditionWithPublishStartYear = "8";
    public static final String conditionWithSeriesName = "5";
    public static final String conditionWithSort = "10";
    public static final String conditionWithSource = "4";
    public static final String conditionWithYear = "11";

    public final String recommendStatus2String(int status) {
        if (status == 0) {
            return "待处理";
        }
        if (status == 1) {
            return "处理中";
        }
        if (status == 2) {
            return "已拒绝";
        }
        if (status != 3) {
            return status != 4 ? "未处理" : "已取消";
        }
        return "已购买";
    }

    private ConversionUtil() {
    }
}
