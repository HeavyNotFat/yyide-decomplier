package com.yd.android_brand_mvp.utils;

import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TimeUtil {
    public static String allTimeFormat = "yyyy-MM-dd HH:mm:ss";
    public static String chDateMDFormat = "MM月dd日";
    public static String chDateYMDFormat = "yyyy年MM月dd日";
    public static String dateYFormat = "yyyy";
    public static String dateYMDFormat = "yyyy-MM-dd";
    public static String dateYMDFormat2 = "yyyy.MM.dd";
    public static String dateYMFormat = "yyyy-MM";
    public static String hoursMinuteTimeFormat = "HH:mm";
    public static String notSecondFormat = "yyyy-MM-dd HH:mm";
    public static String notSecondFormat2 = "yyyy.MM.dd HH:mm";

    public static boolean isDate(String str) {
        return stampToDate(System.currentTimeMillis()).equals(str);
    }

    public static boolean forRemindTime(String str, String str2) {
        long j = gettime99(str);
        long j2 = gettime99(str2);
        long j3 = gettime99(stampToDate2(System.currentTimeMillis()));
        return j3 >= j && j3 < j2;
    }

    public static boolean isTableCountdown(String str, String str2) {
        long j = gettime99(str);
        gettime99(str2);
        long j2 = gettime99(stampToDate2(System.currentTimeMillis()));
        return j2 >= j - 130000 && j2 <= j - 115000;
    }

    public static boolean isTime(String str, String str2) {
        long j = gettime2(str);
        long j2 = gettime2(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis > j && jCurrentTimeMillis < j2;
    }

    public static boolean isTable(String str, String str2) {
        long j = gettime99(str);
        gettime99(str2);
        return j >= gettime99(stampToDate2(System.currentTimeMillis()));
    }

    public static boolean isvoice(int i, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long j = gettime99(str);
        long j2 = gettime99(stampToDate2(System.currentTimeMillis()));
        long j3 = j - ((((long) i2) * 6000) * 10);
        long j4 = (((long) i) * 6000 * 10) + j3;
        return (j4 > j2 && j2 >= j3) || j4 == j3;
    }

    public static boolean isvoice2(int i, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long j = gettime99(str);
        long j2 = gettime99(stampToDate2(System.currentTimeMillis()));
        long j3 = j + (((long) i2) * 6000 * 10);
        long j4 = (((long) i) * 6000 * 10) + j3;
        return (j4 > j2 && j2 >= j3) || j4 == j3;
    }

    public static boolean isBelong(String str, String str2) {
        Date date;
        Date date2;
        if (com.blankj.utilcode.util.StringUtils.isEmpty(str) || com.blankj.utilcode.util.StringUtils.isEmpty(str2)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date3 = null;
        try {
            date2 = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            try {
                date = simpleDateFormat.parse(str);
                try {
                    date3 = simpleDateFormat.parse(str2);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                date = null;
            }
        } catch (Exception e3) {
            e = e3;
            date = null;
            date2 = null;
        }
        return belongCalendar(date2, date, date3);
    }

    private static boolean belongCalendar(Date date, Date date2, Date date3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        return calendar.after(calendar2) && calendar.before(calendar3);
    }

    public static boolean isCurrentInTimeScope(int i, int i2, int i3, int i4) {
        long jCurrentTimeMillis = System.currentTimeMillis() + 600000;
        Time time = new Time();
        time.set(jCurrentTimeMillis);
        Time time2 = new Time();
        time2.set(jCurrentTimeMillis);
        time2.hour = i;
        time2.minute = i2;
        Time time3 = new Time();
        time3.set(jCurrentTimeMillis);
        time3.hour = i3;
        time3.minute = i4;
        boolean z = false;
        if (!time2.before(time3)) {
            time2.set(time2.toMillis(true) - 86400000);
            if (!time.before(time2) && !time.after(time3)) {
                z = true;
            }
            Time time4 = new Time();
            time4.set(time2.toMillis(true) + 86400000);
            if (!time.before(time4)) {
                return true;
            }
        } else if (!time.before(time2) && !time.after(time3)) {
            z = true;
        }
        return z;
    }

    public static boolean isDateOver(String str) {
        try {
            return new Date().before(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isDateOver2(String str) {
        try {
            return new Date().before(new SimpleDateFormat("hh:mm:selectClassesInfoRsp").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long gettime(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime22(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime10(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime11(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime55(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static String getTargetTime(String str, String str2, String str3) {
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

    public static String stampToDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }

    public static String stampToDate2(long j) {
        return new SimpleDateFormat("HH:mm").format(new Date(j));
    }

    public static String stampToDate3(long j) {
        return new SimpleDateFormat("MM-dd").format(new Date(j));
    }

    public static String stampToDate4(long j) {
        return new SimpleDateFormat("yyyy年MM月").format(new Date(j));
    }

    public static String stampToDate6(long j) {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(j));
    }

    public static String stampToDate7(long j) {
        return new SimpleDateFormat("HH:mm").format(new Date(j));
    }

    public static String stampToDate18(long j) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
    }

    public static String stampToDate5(long j) {
        return new SimpleDateFormat("MM月-dd日").format(new Date(j));
    }

    public static String stampToDate8(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(j));
    }

    public static String stampToDate9(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static String stampToDate11(long j) {
        return new SimpleDateFormat("dd日").format(new Date(j));
    }

    public static String stampToDate12(long j) {
        return new SimpleDateFormat("dd").format(new Date(j));
    }

    public static String stampToDate13(long j) {
        return new SimpleDateFormat("MM月").format(new Date(j));
    }

    public static String stampToDate14(long j) {
        return new SimpleDateFormat("yyyy-MM").format(new Date(j));
    }

    public static String stampToDate15(long j) {
        return new SimpleDateFormat("yyyy").format(new Date(j));
    }

    public static String stampToDate16(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }

    public static String stampToDate17(long j) {
        return new SimpleDateFormat("MM").format(new Date(j));
    }

    public static List<WeekDay> getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            calendar.set(7, firstDayOfWeek + i);
            WeekDay weekDay = new WeekDay();
            weekDay.week = calendar.getDisplayName(7, 2, Locale.CHINA);
            weekDay.day = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
            arrayList.add(weekDay);
        }
        return arrayList;
    }

    public static String stampToDate10(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:selectClassesInfoRsp").format(new Date(j));
    }

    public static String getWeek(Date date) {
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7) - 1;
        if (i < 0) {
            i = 0;
        }
        return strArr[i];
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

    public static boolean isTimeOut(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:selectClassesInfoRsp").parse(str).after(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isTimeOut2(String str) {
        Log.e("TAG", "isTimeOut2: " + str);
        try {
            return new SimpleDateFormat("hh:mm:selectClassesInfoRsp").parse(str).after(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static class WeekDay {
        public String day;
        public String week;

        public String toString() {
            return this.day;
        }
    }

    public static long gettime2(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime3(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:selectClassesInfoRsp");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long date2TimeStamp(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long dateToStamp(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String stampToDate(Long l) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l.longValue()));
    }

    public static String getWeek(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        switch (calendar.get(7)) {
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
            default:
                return "周六";
        }
    }

    public static String getWeekStr(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        switch (calendar.get(7)) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            default:
                return "星期六";
        }
    }

    public static int getIntWeek(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        return calendar.get(7);
    }

    public static int getIntWeekDay(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        int i = calendar.get(7);
        if (1 == i) {
            return 7;
        }
        if (2 == i) {
            return 1;
        }
        if (3 == i) {
            return 2;
        }
        if (4 == i) {
            return 3;
        }
        if (5 == i) {
            return 4;
        }
        if (6 == i) {
            return 5;
        }
        if (7 == i) {
            return 6;
        }
        return i;
    }

    public static boolean isBelong3(String str, String str2) {
        long j = gettime66(str);
        long j2 = gettime66(str2);
        long j3 = gettime66(stampToDate(System.currentTimeMillis()));
        return j <= j3 && j3 <= j2;
    }

    public static long gettime99(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long getTimeHHmmss(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime999(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static long gettime66(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (str != null) {
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static int getDateYear(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(1);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getDateMonth(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(2) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getDateDay(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(5);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getWeek2(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        switch (calendar.get(7)) {
            case 1:
                return ConversionUtil.conditionWithBookType;
            case 2:
                return "1";
            case 3:
                return "2";
            case 4:
                return "3";
            case 5:
                return "4";
            case 6:
                return ConversionUtil.conditionWithSeriesName;
            default:
                return ConversionUtil.conditionWithCallNumber;
        }
    }

    public static Map<String, String> reMonSun(Date date, int i, int i2) {
        HashMap map = new HashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(2);
        calendar.add(4, i);
        int i3 = calendar.get(7);
        if (i3 == 1) {
            i3 = 8;
        }
        calendar.add(5, calendar.getFirstDayOfWeek() - i3);
        simpleDateFormat.format(calendar.getTime());
        calendar.add(5, i2 - 1);
        String str = simpleDateFormat.format(calendar.getTime());
        map.put("startTime", str + ":00:00:00");
        map.put("endTime", str + ":23:59:59");
        return map;
    }

    public static String getSplitTime(String str) {
        return com.blankj.utilcode.util.StringUtils.isEmpty(str) ? "" : stampToDate2(dateToStamp(str));
    }

    public static String getCurrentTime2() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrentTimeStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrent(String str, long j) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(System.currentTimeMillis() + j));
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrentyyyyMMdd() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static String getCurrentTimeHHMM() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static boolean isAfterSpecificTimeOfToday(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
        boolean z = System.currentTimeMillis() > calendar.getTimeInMillis();
        Log.i("isAfter", "isAfter = " + z);
        return z;
    }
}
