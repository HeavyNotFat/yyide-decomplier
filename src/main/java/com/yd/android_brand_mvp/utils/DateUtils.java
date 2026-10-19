package com.yd.android_brand_mvp.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.RoomDatabase;
import com.blankj.utilcode.util.LogUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.yd.android_brand_mvp.model.RemainingBean;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/* JADX INFO: loaded from: classes4.dex */
public class DateUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "DateUtils";

    public static String getWeek(int i) {
        switch (i) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            case 8:
                return "周日";
            default:
                return "";
        }
    }

    public static boolean isToday(Long l) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l.longValue());
        return calendar2.get(1) == calendar.get(1) && calendar.get(6) - calendar2.get(6) == 0;
    }

    public static boolean isYesterday(Long l) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l.longValue());
        return calendar2.get(1) == calendar.get(1) && calendar.get(6) - calendar2.get(6) == 1;
    }

    public static String stampToDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(j));
    }

    public static String stampToDate(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static String getDate(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j + 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDate(long j, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(j + 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDate2(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j + 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date getBeginDayOfLastWeek() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7);
        if (i == 1) {
            i += 7;
        }
        calendar.add(5, (2 - i) - 7);
        return getDayStartTime(calendar.getTime());
    }

    public static Date getEndDayOfLastWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getBeginDayOfLastWeek());
        calendar.add(7, 6);
        return getDayEndTime(calendar.getTime());
    }

    public static String getDate(DateTime dateTime, String str) {
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            return new SimpleDateFormat(str, Locale.getDefault()).format(dateTime);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDate(Date date, String str) {
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            return new SimpleDateFormat(str, Locale.getDefault()).format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDayEndDate(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 23);
        gregorianCalendar.set(12, 59);
        gregorianCalendar.set(13, 59);
        gregorianCalendar.set(14, 0);
        return getDate(gregorianCalendar.getTime().getTime());
    }

    public static String getWeekStartDate(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.set(7, 2);
        calendar.getTime();
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDayBegin() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        return getDate(gregorianCalendar.getTime().getTime());
    }

    public static String getWeekEndDate(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.set(7, calendar.getActualMaximum(7) + 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7);
        if (i == 1) {
            i += 7;
        }
        calendar.add(5, 2 - i);
        return getDayStartTime(calendar.getTime());
    }

    public static Date getBeginDayOfWeek2() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7);
        if (i == 1) {
            i += 7;
        }
        calendar.add(5, 2 - i);
        return getDayStartTime(calendar.getTime());
    }

    public static Date getEndDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getBeginDayOfWeek());
        calendar.add(7, 6);
        return getDayEndTime(calendar.getTime());
    }

    public static Date getEndDayOfWeek2() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getBeginDayOfWeek2());
        calendar.add(7, 6);
        return getDayEndTime(calendar.getTime());
    }

    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear().intValue(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    public static Date getBeginDayOfMonth2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear().intValue(), getNowMonth() - 2, 1);
        return getDayStartTime(calendar.getTime());
    }

    public static Timestamp getDayStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(14, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear().intValue(), getNowMonth() - 1, 1);
        calendar.set(getNowYear().intValue(), getNowMonth() - 1, calendar.getActualMaximum(5));
        return getDayEndTime(calendar.getTime());
    }

    public static Date getEndDayOfMonth2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear().intValue(), getNowMonth() - 2, 1);
        calendar.set(getNowYear().intValue(), getNowMonth() - 2, calendar.getActualMaximum(5));
        return getDayEndTime(calendar.getTime());
    }

    public static Timestamp getDayEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        calendar.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance();
        gregorianCalendar.setTime(date);
        return Integer.valueOf(gregorianCalendar.get(1));
    }

    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance();
        gregorianCalendar.setTime(date);
        return gregorianCalendar.get(2) + 1;
    }

    public static String getOldDate(int i) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.set(5, calendar.get(5) + i);
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        LogUtils.i("前7天==" + simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }

    public static String getMonthEndDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.getActualMaximum(5));
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getMonthStartDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.getTime();
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String switchCreateTime(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new SimpleDateFormat(str2).format(new Date(Long.parseLong(str) * 1000));
    }

    public static String switchTime(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String switchTime(Date date, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }

    public static long formatTime(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    public static String formatTime(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "MM.dd HH:mm";
        }
        try {
            Date date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            return date != null ? new SimpleDateFormat(str3, Locale.getDefault()).format(date) : com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        } catch (ParseException e) {
            e.printStackTrace();
            return "--";
        }
    }

    public static String formatTime(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "MM月dd日";
        }
        if (z) {
            try {
                Date date = new SimpleDateFormat(str2).parse(str);
                if (date != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(date.getTime()));
                    return formatTime(str, str2, str3) + " " + getWeek(calendar.get(7));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return formatTime(str, str2, str3);
    }

    public static DateTime simplifiedDataTime(DateTime dateTime) {
        return DateTime.parse(dateTime.toString("yyyy-MM-dd"), DateTimeFormat.forPattern("yyyy-MM-dd"));
    }

    public static String getWeek(DateTime dateTime, boolean z) {
        DateTime dateTimeNow = DateTime.now();
        int dayOfWeek = dateTime.getDayOfWeek() % 7;
        if (z && dateTimeNow.toString("yyyy-MM-dd").equals(dateTime.toString("yyyy-MM-dd"))) {
            return "今天";
        }
        switch (dayOfWeek) {
            case 0:
                return "周日";
            case 1:
                return "周一";
            case 2:
                return "周二";
            case 3:
                return "周三";
            case 4:
                return "周四";
            case 5:
                return "周五";
            case 6:
                return "周六";
            default:
                return "";
        }
    }

    public static long parseTimestamp(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getWhenPoint(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long[] dateDiff(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long time = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime() - simpleDateFormat.parse(str).getTime();
            if (time >= 0) {
                Log.e("dateDiff", "dateDiff: 倒计时过期");
                return new long[0];
            }
            long jAbs = Math.abs(time);
            long j = jAbs / 86400000;
            long j2 = (jAbs % 86400000) / 3600000;
            long j3 = ((jAbs % 86400000) % 3600000) / 60000;
            long j4 = (((jAbs % 86400000) % 3600000) % 60000) / 1000;
            Log.e("dateDiff", "dateDiff: " + j + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + j2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + j3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + j4);
            return new long[]{j, j2, j3, j4};
        } catch (ParseException e) {
            e.printStackTrace();
            return new long[0];
        }
    }

    public static String[] getFirstDayAndLastDayByMonthWeek(int i, int i2, int i3) {
        Log.e(TAG, "year=" + i + ",month=" + i2 + ",week=" + i3);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(3, i3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] strArr = {"", ""};
        if (Build.VERSION.SDK_INT >= 26) {
            LocalDate localDate = LocalDate.parse(simpleDateFormat.format(calendar.getTime()));
            LocalDate localDateWith = localDate.with((TemporalAdjuster) DayOfWeek.MONDAY);
            LocalDate localDateWith2 = localDate.with((TemporalAdjuster) DayOfWeek.SUNDAY);
            Log.e(TAG, "beginDayOfWeek: " + localDateWith.toString() + ",endDayOfWeek：" + localDateWith2.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(localDateWith.getMonthValue());
            sb.append(".");
            sb.append(localDateWith.getDayOfMonth());
            strArr[0] = sb.toString();
            strArr[1] = localDateWith2.getMonthValue() + "." + localDateWith2.getDayOfMonth();
        } else {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM.dd");
            calendar.setFirstDayOfWeek(2);
            calendar.set(7, calendar.getFirstDayOfWeek());
            String str = simpleDateFormat2.format(calendar.getTime());
            calendar.set(7, calendar.getFirstDayOfWeek() + 6);
            String str2 = simpleDateFormat2.format(calendar.getTime());
            Log.e(TAG, "getFirstDayAndLastDayByMonthWeek: date1 " + str + ", date2 " + str2);
            strArr[0] = str;
            strArr[1] = str2;
        }
        return strArr;
    }

    public static String sectionUppercase(int i) {
        switch (i) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            default:
                return "" + i;
        }
    }

    public static String convert(int i) {
        String[] strArr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] strArr2 = {"", "十", "百", "千", "万", "亿"};
        StringBuilder sb = new StringBuilder();
        int[] iArr = {100000000, 10000, 1000, 100, 10};
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < 5; i4++) {
            int i5 = iArr[i4];
            int i6 = i / i5;
            i %= i5;
            if (sb.length() != 0 || i6 != 0) {
                if (i6 > 9) {
                    sb.append(convert(i6));
                } else {
                    if (i2 != 0 || i6 != 0) {
                        sb.append(strArr[i6]);
                    }
                    i2 = i6;
                }
                if (i6 != 0) {
                    sb.append(strArr2[5 - i3]);
                }
            }
            i3++;
        }
        if (i != 0) {
            sb.append(strArr[i]);
        }
        String string = sb.toString();
        if (string.length() == 0) {
            return "零";
        }
        if ("零".equals(String.valueOf(string.charAt(string.length() - 1)))) {
            string = string.substring(0, string.length() - 1);
        }
        if (sb.length() < 2 || sb.charAt(0) != 19968 || sb.charAt(1) != 21313) {
            return string;
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public static boolean minMonth(String str, int i) {
        try {
            return i <= Integer.parseInt(formatTime(str, null, "MM"));
        } catch (Exception unused) {
        }
    }

    public static boolean minWeek(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM.dd");
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat2.parse(str2);
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            calendar.setTime(date2);
            calendar.set(1, i);
            Date time = calendar.getTime();
            Log.e(TAG, "minWeek: " + calendar.toString());
            return date.getTime() >= time.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean dateExpired(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
            return date != null && new Date().getTime() - date.getTime() > 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean compareDate(String str, String str2, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault());
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            if (z) {
                return date.getTime() == date2.getTime();
            }
            return date.before(date2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean compareDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();
            return new Date(calendar.get(1) + (-1900), calendar.get(2), calendar.get(5)).compareTo(simpleDateFormat.parse(str)) < 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isToday(String str) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis())).equals(str);
    }

    public static boolean isSameDay(String str, String str2) {
        return formatTime(str, "", "yyyy-MM-dd").equals(formatTime(str2, "", "yyyy-MM-dd"));
    }

    public static String judgeIsNeedAddZero(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.length() != 1) {
            return str;
        }
        return 0 + str;
    }

    public static Long getRangeLimitStart(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(2, -i);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static Long getRangeLimitEnd(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(2, i);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static String getTodayStr(String str) {
        if (str.isEmpty()) {
            str = "yyyy-MM-dd";
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }

    public static long getTimestamp(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str2.isEmpty()) {
            str2 = TimeUtil.allTimeFormat;
        }
        try {
            Date date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static Date getTimeDate(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2.isEmpty()) {
            str2 = TimeUtil.allTimeFormat;
        }
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNextTime(String str, String str2) {
        return new Date().before(getTimeDate(str, str2));
    }

    public static long disparitySecondToTarget(String str, String str2) {
        Date timeDate = getTimeDate(str, str2);
        Date date = new Date();
        if (timeDate == null) {
            return 0L;
        }
        long time = timeDate.getTime() - date.getTime();
        if (time < 0) {
            return 0L;
        }
        return time;
    }

    public static boolean isTiming(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Date timeDate = getTimeDate(str, str3);
        Date timeDate2 = getTimeDate(str2, str3);
        Date date = new Date();
        return date.after(timeDate) && date.before(timeDate2);
    }

    public static boolean isTiming(String str, String str2, int i, int i2) {
        Date timeDate = getTimeDate(str, TimeUtil.allTimeFormat);
        Date timeDate2 = getTimeDate(str2, TimeUtil.allTimeFormat);
        if (timeDate == null || timeDate2 == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeDate);
        calendar.add(12, -i);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(timeDate2);
        Calendar calendar3 = Calendar.getInstance();
        return calendar3.after(calendar) && calendar3.before(calendar2);
    }

    public static RemainingBean getTimeRemaining(String str) {
        long timestamp = getTimestamp(str, TimeUtil.allTimeFormat) - System.currentTimeMillis();
        RemainingBean remainingBean = new RemainingBean();
        if (timestamp > 0) {
            long j = timestamp / 1000;
            long j2 = j / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
            long j3 = 24 * j2;
            long j4 = (j / 3600) - j3;
            long j5 = j3 * 60;
            long j6 = j4 * 60;
            long j7 = ((j / 60) - j5) - j6;
            remainingBean.setDay(j2);
            remainingBean.setHours(j4);
            remainingBean.setMin(j7);
            remainingBean.setSecond(((j - (j5 * 60)) - (j6 * 60)) - (60 * j7));
        }
        return remainingBean;
    }
}
