package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.yd.android_brand_mvp.model.DayWeekBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class Tool {
    public static byte[] IntToBytes(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 0) & 255)};
    }

    public static Configuration getScreenConfiguration(Activity activity) {
        return activity.getResources().getConfiguration();
    }

    public static String[] stringInArrays(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] strArrSplit = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        String str2 = strArrSplit[0];
        strArrSplit[0] = str2.substring(str2.indexOf("[") + 1);
        String str3 = strArrSplit[strArrSplit.length - 1];
        strArrSplit[strArrSplit.length - 1] = str3.substring(0, str3.indexOf("]"));
        return strArrSplit;
    }

    public static String BytesToHexString(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String hexStr2Str(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i2]) * 16) + "0123456789ABCDEF".indexOf(charArray[i2 + 1])) & 255);
        }
        return new String(bArr);
    }

    public static String dateToStamp4(String str) throws ParseException {
        return String.valueOf(new SimpleDateFormat("HH:mm").parse(str).getTime());
    }

    public static String timeStamp2Date(String str, String str2) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        if (str2 == null || str2.isEmpty()) {
            str2 = "yyyy-MM-dd";
        }
        return new SimpleDateFormat(str2).format(new Date(Long.valueOf(str + "000").longValue()));
    }

    public static byte[] HexStringToBytes(String str) throws Exception {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase(Locale.getDefault());
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static String HexStringToBytes1(String str) throws Exception {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase(Locale.getDefault());
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
            stringBuffer.append(Integer.toHexString(bArr[i] & 255));
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static int BytesToInt(byte[] bArr) {
        if (bArr.length != 4) {
            return 0;
        }
        int i = (bArr[0] & 255) << 24;
        int i2 = (bArr[1] & 255) << 16;
        return i | i2 | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    public static int BytesToInt2(byte[] bArr) {
        if (bArr.length == 2) {
            return (bArr[0] & 255) | ((bArr[1] & 255) << 8);
        }
        return 0;
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

    public static String ms2HMS(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = i2 % 60;
        String strValueOf = String.valueOf(i3);
        if (i3 < 10) {
            strValueOf = "0" + strValueOf;
        }
        String strValueOf2 = String.valueOf(i4);
        if (i4 < 10) {
            strValueOf2 = "0" + strValueOf2;
        }
        String strValueOf3 = String.valueOf(i5);
        if (i5 < 10) {
            strValueOf3 = "0" + strValueOf3;
        }
        return strValueOf + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + strValueOf2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + strValueOf3;
    }

    public static String formatTime(Long l) {
        Integer num = 1000;
        Integer numValueOf = Integer.valueOf(num.intValue() * 60);
        Integer numValueOf2 = Integer.valueOf(numValueOf.intValue() * 60);
        Integer numValueOf3 = Integer.valueOf(numValueOf2.intValue() * 24);
        Long lValueOf = Long.valueOf(l.longValue() / ((long) numValueOf3.intValue()));
        Long lValueOf2 = Long.valueOf((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) / ((long) numValueOf2.intValue()));
        Long lValueOf3 = Long.valueOf(((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) - (lValueOf2.longValue() * ((long) numValueOf2.intValue()))) / ((long) numValueOf.intValue()));
        Long.valueOf((((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) - (lValueOf2.longValue() * ((long) numValueOf2.intValue()))) - (lValueOf3.longValue() * ((long) numValueOf.intValue()))) / ((long) num.intValue()));
        StringBuilder sb = new StringBuilder();
        if (lValueOf.longValue() > 0) {
            sb.append(lValueOf + "天");
        }
        if (lValueOf2.longValue() > 0) {
            sb.append(lValueOf2 + "时");
        }
        if (lValueOf3.longValue() > 0) {
            sb.append(lValueOf3 + "分");
        }
        return sb.toString();
    }

    public static String formattime(Long l, int i) {
        Integer num = 1000;
        Integer numValueOf = Integer.valueOf(num.intValue() * 60);
        Integer numValueOf2 = Integer.valueOf(numValueOf.intValue() * 60);
        Integer numValueOf3 = Integer.valueOf(numValueOf2.intValue() * 24);
        Long lValueOf = Long.valueOf(l.longValue() / ((long) numValueOf3.intValue()));
        Long lValueOf2 = Long.valueOf((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) / ((long) numValueOf2.intValue()));
        Long lValueOf3 = Long.valueOf(((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) - (lValueOf2.longValue() * ((long) numValueOf2.intValue()))) / ((long) numValueOf.intValue()));
        if (i == 1) {
            return lValueOf + "天";
        }
        if (i == 2) {
            return lValueOf2 + "时";
        }
        if (i != 3) {
            return null;
        }
        return lValueOf3 + "分";
    }

    public static String formattime2(Long l, int i) {
        String str;
        Integer num = 1000;
        Integer numValueOf = Integer.valueOf(num.intValue() * 60);
        Integer numValueOf2 = Integer.valueOf(numValueOf.intValue() * 60);
        Integer numValueOf3 = Integer.valueOf(numValueOf2.intValue() * 24);
        Long lValueOf = Long.valueOf(l.longValue() / ((long) numValueOf3.intValue()));
        Long lValueOf2 = Long.valueOf((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) / ((long) numValueOf2.intValue()));
        Long lValueOf3 = Long.valueOf(((l.longValue() - (lValueOf.longValue() * ((long) numValueOf3.intValue()))) - (lValueOf2.longValue() * ((long) numValueOf2.intValue()))) / ((long) numValueOf.intValue()));
        if (i == 1) {
            str = lValueOf + "天";
        } else if (i == 2) {
            str = lValueOf2 + " : " + lValueOf3;
        } else {
            str = null;
        }
        Log.e("TAG", "formattime2: " + str);
        return str;
    }

    public static Date transForDate(Integer num) {
        if (num == null) {
            num = 0;
        }
        long jIntValue = ((long) num.intValue()) * 1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-HH-mm");
        if (num == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(jIntValue)));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dataOne(String str) {
        try {
            return String.valueOf(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(str).getTime()).substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getnowtimenob() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public static class WeekDay {
        public String day;
        public String week;

        public String toString() {
            return this.day;
        }
    }

    public static File File_dir(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String dateToStamp(String str) throws ParseException {
        return String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime());
    }

    public static String dateToStamp3(String str) throws ParseException {
        return String.valueOf(new SimpleDateFormat("HH:mm:ss").parse(str).getTime());
    }

    public static String dateToStamp2(String str) throws ParseException {
        return String.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime());
    }

    public static String stampToDate(String str) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(new Long(str).longValue()));
    }

    public static int ceilInt(double d) {
        return (int) Math.ceil(d);
    }

    public static String getWeek(long j) {
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

    public static String getWeek3(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        switch (calendar.get(7)) {
            case 1:
                return "每周日";
            case 2:
                return "每周一";
            case 3:
                return "每周二";
            case 4:
                return "每周三";
            case 5:
                return "每周四";
            case 6:
                return "每周五";
            default:
                return "每周六";
        }
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String byteToHex(byte b) {
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() >= 2) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static void closeKeybord(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static int ReadIO(int i) {
        FileInputStream fileInputStream;
        String line = null;
        try {
            if (i == 1) {
                try {
                    fileInputStream = new FileInputStream("/proc/yx_gpio/gpio_io1");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    fileInputStream = null;
                }
            } else {
                fileInputStream = null;
            }
            try {
                line = new BufferedReader(new InputStreamReader(fileInputStream)).readLine();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            fileInputStream.close();
            Log.d("rrrr====", "****************\n");
            Log.d("rrrr====", "read====" + line);
            Log.d("rrrr====", "****************\n");
            if (line.equals("1")) {
                return 1;
            }
            return line.equals("0") ? 0 : -1;
        } catch (IOException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public static String ReadTxtFile(String str) {
        File file = new File(str);
        String str2 = "";
        if (file.isDirectory()) {
            Log.d("TestFile", "The File doesn't not exist.");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    str2 = str2 + line + "\n";
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
                Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e) {
                Log.d("TestFile", e.getMessage());
            }
        }
        return str2;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static float bytes2mb(long j) {
        return new BigDecimal(j).divide(new BigDecimal(1048576), 2, 0).floatValue();
    }

    public static String getSerialNumber() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Long stringToLong(String str, String str2) throws ParseException {
        if (str != null) {
            return Long.valueOf(new SimpleDateFormat(str2).parse(str).getTime());
        }
        return null;
    }

    public static String getMacAddress() {
        try {
            return loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String loadFileAsString(String str) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(1000);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        char[] cArr = new char[1024];
        while (true) {
            int i = bufferedReader.read(cArr);
            if (i != -1) {
                stringBuffer.append(String.valueOf(cArr, 0, i));
            } else {
                bufferedReader.close();
                return stringBuffer.toString();
            }
        }
    }

    public static long hexToLong(String str, boolean z) {
        long j = 0;
        if (!isBlank(str)) {
            String strTrim = str.trim();
            if (!z && strTrim.matches("^\\d{1,}$")) {
                return Long.parseLong(strTrim);
            }
            if (!isHex(strTrim)) {
                return 0L;
            }
            String upperCase = strTrim.toUpperCase();
            if (upperCase.length() > 2 && upperCase.charAt(0) == '0' && upperCase.charAt(1) == 'X') {
                upperCase = upperCase.substring(2);
            }
            int length = upperCase.length();
            for (int i = 0; i < length; i++) {
                try {
                    long hex = getHex(upperCase.charAt((length - i) - 1));
                    long power = getPower(16, i);
                    Long.signum(hex);
                    j += hex * power;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return j;
    }

    private static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isHex(String str) {
        int i = 2;
        if (str.length() <= 2 || str.charAt(0) != '0' || (str.charAt(1) != 'X' && str.charAt(1) != 'x')) {
            i = 0;
        }
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'F') && (cCharAt < 'a' || cCharAt > 'f'))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static int getHex(char c) throws Exception {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new Exception("error param");
            }
        }
        return (c - c2) + 10;
    }

    private static long getPower(int i, int i2) throws Exception {
        if (i2 < 0) {
            throw new Exception("nCount can't small than 1!");
        }
        long j = 1;
        if (i2 == 0) {
            return 1L;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            j *= (long) i;
        }
        return j;
    }

    public static long hexToLong(String str) {
        return hexToLong(str, false);
    }

    public static String convertHexToString(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i < str.length() - 1) {
            int i2 = i + 2;
            int i3 = Integer.parseInt(str.substring(i, i2), 16);
            sb.append((char) i3);
            sb2.append(i3);
            i = i2;
        }
        return sb.toString();
    }

    public static boolean isConnect() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("ping www.baidu.com").getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            System.out.println("返回值为:" + ((Object) stringBuffer));
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
            return !stringBuffer.toString().equals("") && stringBuffer.toString().indexOf("TTL") > 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bitmap stringtoBitmap(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static NetworkInfo getNetworkAvailableTypeName(Activity activity) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                    return allNetworkInfo[i];
                }
            }
        }
        return null;
    }

    public static int obtainWifiInfo(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo.getBSSID() == null) {
            return 0;
        }
        int iCalculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5);
        connectionInfo.getLinkSpeed();
        connectionInfo.getSSID();
        return iCalculateSignalLevel;
    }

    public static void CloseAndOpenWiFi(Context context, boolean z) {
        ((WifiManager) context.getSystemService("wifi")).setWifiEnabled(z);
    }

    public static String getFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            int iLastIndexOf = str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            int iLastIndexOf2 = str.lastIndexOf(".");
            if (iLastIndexOf != -1 && iLastIndexOf2 != -1) {
                return str.substring(iLastIndexOf + 1, iLastIndexOf2);
            }
        }
        return null;
    }

    public static String conversionTime(String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '.') {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static String getTextHtoV(String str) {
        String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length;
        char[][] cArr = new char[length][];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int length2 = strArrSplit[i2].length();
            if (length2 > i) {
                i = length2;
            }
            cArr[i2] = strArrSplit[i2].toCharArray();
        }
        String str2 = "";
        int i3 = 0;
        while (i3 < i) {
            for (int i4 = 0; i4 < length; i4++) {
                str2 = str2 + String.valueOf(i3 < cArr[i4].length ? cArr[i4][i3] : (char) 12288);
                if (i4 < length - 1) {
                    str2 = str2 + " ";
                }
            }
            str2 = str2 + "\n";
            i3++;
        }
        return str2;
    }

    public static List<DayWeekBean> getWeekDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(7) != 2) {
            calendar.add(7, -1);
        }
        Date[] dateArr = new Date[7];
        int i = 0;
        for (int i2 = 0; i2 < 7; i2++) {
            dateArr[i2] = calendar.getTime();
            calendar.add(5, 1);
        }
        while (i < 7) {
            DayWeekBean dayWeekBean = new DayWeekBean();
            dayWeekBean.day = simpleDateFormat.format(dateArr[i]);
            i++;
            dayWeekBean.week = i;
            arrayList.add(dayWeekBean);
        }
        return arrayList;
    }

    public static List<DayWeekBean> getNextWeekDay(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -1);
            calendar.set(7, 1);
            calendar.add(3, 1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str));
            calendar2.add(7, 1);
            if (1 == calendar2.get(7)) {
                calendar2.add(5, -1);
            }
            calendar2.setFirstDayOfWeek(2);
            calendar2.add(5, calendar2.getFirstDayOfWeek() - calendar2.get(7));
            Date[] dateArr = new Date[7];
            int i = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                dateArr[i2] = calendar2.getTime();
                calendar2.add(5, 1);
            }
            while (i < 7) {
                DayWeekBean dayWeekBean = new DayWeekBean();
                dayWeekBean.day = simpleDateFormat.format(dateArr[i]);
                i++;
                dayWeekBean.week = i;
                arrayList.add(dayWeekBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getDays(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            calendar2.add(5, 1);
            while (calendar.before(calendar2)) {
                arrayList.add(simpleDateFormat.format(calendar.getTime()));
                calendar.add(6, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getMotth(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            calendar2.add(5, 1);
            while (calendar.before(calendar2)) {
                arrayList.add(simpleDateFormat.format(calendar.getTime()));
                calendar.add(6, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getMonth(String str, String str2) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            Date date = new SimpleDateFormat("yyyy-MM").parse(str);
            Date date2 = new SimpleDateFormat("yyyy-MM").parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int i2 = calendar.get(1);
            int i3 = calendar.get(2);
            calendar.setTime(date2);
            int i4 = calendar.get(1);
            int i5 = calendar.get(2);
            int i6 = i2;
            while (true) {
                i = 0;
                if (i6 > i4) {
                    break;
                }
                if (i2 == i4) {
                    for (int i7 = i3; i7 <= i5; i7++) {
                        arrayList.add(i7 < 9 ? i6 + "-0" + (i7 + 1) : i6 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (i7 + 1));
                    }
                } else if (i6 == i2) {
                    for (int i8 = i3; i8 < 12; i8++) {
                        arrayList.add(i8 < 9 ? i6 + "-0" + (i8 + 1) : i6 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (i8 + 1));
                    }
                } else if (i6 == i4) {
                    while (i <= i5) {
                        arrayList.add(i < 9 ? i6 + "-0" + (i + 1) : i6 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (i + 1));
                        i++;
                    }
                } else {
                    while (i < 12) {
                        arrayList.add(i < 9 ? i6 + "-0" + (i + 1) : i6 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (i + 1));
                        i++;
                    }
                }
                i6++;
            }
            while (i < arrayList.size()) {
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getAllMonthDays(String str) {
        int i = Integer.parseInt(str.substring(0, 4));
        int i2 = Integer.parseInt(str.substring(5));
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2 - 1);
        calendar.set(5, 1);
        calendar.roll(5, -1);
        int i3 = calendar.get(5);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 1; i4 <= i3; i4++) {
            arrayList.add(i4 < 10 ? String.valueOf(i) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(i2) + "-0" + String.valueOf(i4) : String.valueOf(i) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(i2) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(i4));
        }
        return arrayList;
    }

    public static List<String> getMonthBetween(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(str));
            calendar.set(calendar.get(1), calendar.get(2), 1);
            calendar2.setTime(simpleDateFormat.parse(str2));
            calendar2.set(calendar2.get(1), calendar2.get(2), 2);
            while (calendar.before(calendar2)) {
                arrayList.add(simpleDateFormat.format(calendar.getTime()));
                calendar.add(2, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static Date getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(5, 1);
        calendar.add(2, 0);
        return calendar.getTime();
    }
}
