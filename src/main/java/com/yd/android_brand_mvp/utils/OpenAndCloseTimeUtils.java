package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.brand.BrandModelEnum;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.model.DayWeekBean;
import com.yd.android_brand_mvp.model.switchlistRsp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OpenAndCloseTimeUtils {
    public static volatile OpenAndCloseTimeUtils openAndCloseTimeUtils;
    private switchlistRsp.DataDTO.ItemDataDTO closebean;
    private switchlistRsp.DataDTO.ItemDataDTO openbean;

    public static OpenAndCloseTimeUtils getInstance() {
        if (openAndCloseTimeUtils == null) {
            synchronized (OpenAndCloseTimeUtils.class) {
                if (openAndCloseTimeUtils == null) {
                    openAndCloseTimeUtils = new OpenAndCloseTimeUtils();
                }
            }
        }
        return openAndCloseTimeUtils;
    }

    public void setTimePower(Context context, switchlistRsp switchlistrsp) {
        if (switchlistrsp.data != null && switchlistrsp.data.openType == 2) {
            setWeekTime(context, switchlistrsp);
        } else {
            setDayPower(context, switchlistrsp);
        }
    }

    private void setDayPower(Context context, switchlistRsp switchlistrsp) {
        switchlistRsp.DataDTO.ItemDataDTO openTimeBean = getOpenTimeBean(switchlistrsp);
        switchlistRsp.DataDTO.ItemDataDTO closeTimeBean = getCloseTimeBean(switchlistrsp);
        Log.i("TAG", "openTimelist: " + JSON.toJSONString(openTimeBean));
        Log.i("TAG", "closeTimelist: " + JSON.toJSONString(closeTimeBean));
        int[] iArr = new int[5];
        int[] iArr2 = new int[5];
        String[] strArr = new String[5];
        String[] strArr2 = new String[5];
        if (openTimeBean != null && closeTimeBean != null && !TextUtils.isEmpty(openTimeBean.openTime) && !TextUtils.isEmpty(closeTimeBean.closeTime)) {
            iArr2[0] = Integer.parseInt((openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(0, 4));
            iArr2[1] = Integer.parseInt((openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(4, 6));
            iArr2[2] = Integer.parseInt((openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(6, 8));
            iArr2[3] = Integer.parseInt(openTimeBean.openTime.substring(0, 2));
            iArr2[4] = Integer.parseInt(openTimeBean.openTime.substring(3, 5));
            iArr[0] = Integer.parseInt((closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(0, 4));
            iArr[1] = Integer.parseInt((closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(4, 6));
            iArr[2] = Integer.parseInt((closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(6, 8));
            iArr[3] = Integer.parseInt(closeTimeBean.closeTime.substring(0, 2));
            iArr[4] = Integer.parseInt(closeTimeBean.closeTime.substring(3, 5));
            strArr2[0] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(0, 4);
            strArr2[1] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(4, 6);
            strArr2[2] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(6, 8);
            strArr2[3] = openTimeBean.openTime.substring(0, 2);
            strArr2[4] = openTimeBean.openTime.substring(3, 5);
            strArr[0] = (closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(0, 4);
            strArr[1] = (closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(4, 6);
            strArr[2] = (closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(6, 8);
            strArr[3] = closeTimeBean.closeTime.substring(0, 2);
            strArr[4] = closeTimeBean.closeTime.substring(3, 5);
            this.closebean = closeTimeBean;
            this.openbean = openTimeBean;
            BroCast.setpoweronoff(context, iArr2, iArr, strArr2, strArr, openTimeBean, closeTimeBean);
        } else {
            BroCast.clearPowerOnOffTime(context);
        }
        LogUtils.i("设置开机: " + JSON.toJSONString(iArr2));
        LogUtils.i("设置关机: " + JSON.toJSONString(iArr));
    }

    public int getCountdownBootTime() {
        String closeTime = getCloseTime(SpData.getTime());
        int i = 0;
        if (TextUtils.isEmpty(closeTime)) {
            return 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (BrandConfig.brandModelEnum != BrandModelEnum.ZLT_GreenOrange) {
            i = BrandConfig.brandModelEnum == BrandModelEnum.HUIDU_RK3288 ? 15000 : 60000;
        }
        return ((int) ((TimeUtil.gettime2(closeTime) + ((long) i)) - jCurrentTimeMillis)) / 1000;
    }

    public boolean isShowTip() {
        return getCountdownBootTime() < 0;
    }

    public void setRetryTime(Context context) {
        switchlistRsp.DataDTO.ItemDataDTO openTimeBean = getOpenTimeBean(SpData.getTime());
        switchlistRsp.DataDTO.ItemDataDTO closeTimeBean = getCloseTimeBean(SpData.getTime());
        if (openTimeBean == null) {
            Log.d("setRetryTime", "openbean: " + openTimeBean);
            return;
        }
        int[] iArr = new int[5];
        int[] iArr2 = new int[5];
        String[] strArr = new String[5];
        String[] strArr2 = new String[5];
        try {
            String current = TimeUtil.getCurrent("yyyyMMddHHmm", 300000);
            if (!TextUtils.isEmpty(openTimeBean.openTime)) {
                iArr[0] = Integer.parseInt((openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(0, 4));
                iArr[1] = Integer.parseInt((openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(4, 6));
                iArr[2] = Integer.parseInt((openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(6, 8));
                iArr[3] = Integer.parseInt(openTimeBean.openTime.substring(0, 2));
                iArr[4] = Integer.parseInt(openTimeBean.openTime.substring(3, 5));
                strArr2[0] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(0, 4);
                strArr2[1] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(4, 6);
                strArr2[2] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(6, 8);
                strArr2[3] = openTimeBean.openTime.substring(0, 2);
                strArr2[4] = openTimeBean.openTime.substring(3, 5);
            }
            iArr2[0] = Integer.parseInt(current.substring(0, 4));
            iArr2[1] = Integer.parseInt(current.substring(4, 6));
            iArr2[2] = Integer.parseInt(current.substring(6, 8));
            iArr2[3] = Integer.parseInt(current.substring(8, 10));
            iArr2[4] = Integer.parseInt(current.substring(10, 12));
            strArr[0] = current.substring(0, 4);
            strArr[1] = current.substring(4, 6);
            strArr[2] = current.substring(6, 8);
            strArr[3] = current.substring(8, 10);
            strArr[4] = current.substring(10, 12);
            BroCast.setpoweronoff(context, iArr, iArr2, strArr2, strArr, openTimeBean, closeTimeBean);
        } catch (Exception e) {
            LogUtils.i("setRetryTime", "设置推迟关机时间异常：" + e.getMessage());
            e.printStackTrace();
        }
        LogUtils.i("设备定时开关", "设置开机==>: " + JSON.toJSONString(iArr));
        LogUtils.i("设备定时开关", "设置关机==>: " + JSON.toJSONString(iArr2));
    }

    public void setWeekTime(Context context, switchlistRsp switchlistrsp) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[7];
        if (switchlistrsp == null || switchlistrsp.data == null || switchlistrsp.data.switchList == null) {
            return;
        }
        for (int i = 0; i < switchlistrsp.data.switchList.size(); i++) {
            if (switchlistrsp.data.switchList.get(i).openStatus) {
                iArr3[i] = 1;
            } else {
                iArr3[i] = 0;
            }
        }
        boolean z = true;
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO : switchlistrsp.data.switchList) {
            if (z && itemDataDTO.openStatus && !TextUtils.isEmpty(itemDataDTO.openTime) && !TextUtils.isEmpty(itemDataDTO.closeTime)) {
                String[] strArrSplit = itemDataDTO.openTime.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                String[] strArrSplit2 = itemDataDTO.closeTime.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (strArrSplit.length >= 2) {
                    iArr[0] = Integer.parseInt(strArrSplit[0]);
                    iArr[1] = Integer.parseInt(strArrSplit[1]);
                }
                if (strArrSplit2.length >= 2) {
                    iArr2[0] = Integer.parseInt(strArrSplit2[0]);
                    iArr2[1] = Integer.parseInt(strArrSplit2[1]);
                }
                z = false;
            }
        }
        BroCast.setWeekPower(context, iArr, iArr2, iArr3);
    }

    public switchlistRsp.DataDTO.ItemDataDTO getCloseTimeBean(switchlistRsp switchlistrsp) {
        if (switchlistrsp == null || switchlistrsp.data == null || switchlistrsp.data.switchList == null) {
            return null;
        }
        new ArrayList();
        ArrayList<switchlistRsp.DataDTO.ItemDataDTO> arrayList = new ArrayList();
        ArrayList<switchlistRsp.DataDTO.ItemDataDTO> arrayList2 = new ArrayList();
        List<switchlistRsp.DataDTO.ItemDataDTO> list = switchlistrsp.data.switchList;
        switchlistRsp.DataDTO dataDTO = new switchlistRsp.DataDTO();
        switchlistRsp.DataDTO dataDTO2 = new switchlistRsp.DataDTO();
        switchlistRsp.DataDTO dataDTO3 = new switchlistRsp.DataDTO();
        switchlistRsp.DataDTO dataDTO4 = new switchlistRsp.DataDTO();
        List<DayWeekBean> weekDay = Tool.getWeekDay();
        List<DayWeekBean> nextWeekDay = Tool.getNextWeekDay(weekDay.get(weekDay.size() - 1).day);
        for (DayWeekBean dayWeekBean : weekDay) {
            for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO : list) {
                if (itemDataDTO.week.intValue() == dayWeekBean.week) {
                    itemDataDTO.day = dayWeekBean.day;
                    arrayList.add(itemDataDTO);
                }
            }
        }
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO2 : list) {
            for (DayWeekBean dayWeekBean2 : nextWeekDay) {
                if (itemDataDTO2.week.intValue() == dayWeekBean2.week) {
                    itemDataDTO2.nextday = dayWeekBean2.day;
                    arrayList2.add(itemDataDTO2);
                }
            }
        }
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO3 : arrayList) {
            if (!TextUtils.isEmpty(itemDataDTO3.openTime)) {
                dataDTO.switchList.add(itemDataDTO3);
            }
            if (!TextUtils.isEmpty(itemDataDTO3.closeTime)) {
                dataDTO2.switchList.add(itemDataDTO3);
            }
        }
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO4 : arrayList2) {
            if (!TextUtils.isEmpty(itemDataDTO4.openTime)) {
                dataDTO3.switchList.add(itemDataDTO4);
            }
            if (!TextUtils.isEmpty(itemDataDTO4.closeTime)) {
                dataDTO4.switchList.add(itemDataDTO4);
            }
        }
        return getCloseTimeBean(Integer.parseInt(Tool.getWeek2(System.currentTimeMillis())), dataDTO2, dataDTO4);
    }

    public switchlistRsp.DataDTO.ItemDataDTO getOpenTimeBean(switchlistRsp switchlistrsp) {
        if (switchlistrsp == null || switchlistrsp.data == null || switchlistrsp.data.switchList == null) {
            return null;
        }
        new ArrayList();
        ArrayList<switchlistRsp.DataDTO.ItemDataDTO> arrayList = new ArrayList();
        ArrayList<switchlistRsp.DataDTO.ItemDataDTO> arrayList2 = new ArrayList();
        List<switchlistRsp.DataDTO.ItemDataDTO> list = switchlistrsp.data.switchList;
        switchlistRsp.DataDTO dataDTO = new switchlistRsp.DataDTO();
        switchlistRsp.DataDTO dataDTO2 = new switchlistRsp.DataDTO();
        switchlistRsp.DataDTO dataDTO3 = new switchlistRsp.DataDTO();
        switchlistRsp.DataDTO dataDTO4 = new switchlistRsp.DataDTO();
        List<DayWeekBean> weekDay = Tool.getWeekDay();
        List<DayWeekBean> nextWeekDay = Tool.getNextWeekDay(weekDay.get(weekDay.size() - 1).day);
        for (DayWeekBean dayWeekBean : weekDay) {
            for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO : list) {
                if (itemDataDTO.week.intValue() == dayWeekBean.week) {
                    itemDataDTO.day = dayWeekBean.day;
                    arrayList.add(itemDataDTO);
                }
            }
        }
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO2 : list) {
            for (DayWeekBean dayWeekBean2 : nextWeekDay) {
                if (itemDataDTO2.week.intValue() == dayWeekBean2.week) {
                    itemDataDTO2.nextday = dayWeekBean2.day;
                    arrayList2.add(itemDataDTO2);
                }
            }
        }
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO3 : arrayList) {
            if (!TextUtils.isEmpty(itemDataDTO3.openTime)) {
                dataDTO.switchList.add(itemDataDTO3);
            }
            if (!TextUtils.isEmpty(itemDataDTO3.closeTime)) {
                dataDTO2.switchList.add(itemDataDTO3);
            }
        }
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO4 : arrayList2) {
            if (!TextUtils.isEmpty(itemDataDTO4.openTime)) {
                dataDTO3.switchList.add(itemDataDTO4);
            }
            if (!TextUtils.isEmpty(itemDataDTO4.closeTime)) {
                dataDTO4.switchList.add(itemDataDTO4);
            }
        }
        return getopenTimeBean(Integer.parseInt(Tool.getWeek2(System.currentTimeMillis())), dataDTO, dataDTO3);
    }

    public String getOpenTime(switchlistRsp switchlistrsp) {
        if (switchlistrsp != null && switchlistrsp.data != null && switchlistrsp.data.switchList != null) {
            String[] strArr = new String[5];
            switchlistRsp.DataDTO.ItemDataDTO openTimeBean = getOpenTimeBean(switchlistrsp);
            if (openTimeBean != null && !TextUtils.isEmpty(openTimeBean.openTime)) {
                strArr[0] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(0, 4);
                strArr[1] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(4, 6);
                strArr[2] = (openTimeBean.isthisweek ? openTimeBean.day : openTimeBean.nextday).substring(6, 8);
                strArr[3] = openTimeBean.openTime.substring(0, 2);
                strArr[4] = openTimeBean.openTime.substring(3, 5);
                String str = strArr[0] + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[1] + '-' + strArr[2] + " " + strArr[3] + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + strArr[4];
                LogUtils.e("openTime = " + str);
                return str;
            }
        }
        return "";
    }

    public String getCloseTime(switchlistRsp switchlistrsp) {
        if (switchlistrsp != null && switchlistrsp.data != null && switchlistrsp.data.switchList != null) {
            switchlistRsp.DataDTO.ItemDataDTO closeTimeBean = getCloseTimeBean(switchlistrsp);
            String[] strArr = new String[5];
            if (closeTimeBean != null && !TextUtils.isEmpty(closeTimeBean.closeTime)) {
                strArr[0] = (closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(0, 4);
                strArr[1] = (closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(4, 6);
                strArr[2] = (closeTimeBean.isthisweek ? closeTimeBean.day : closeTimeBean.nextday).substring(6, 8);
                strArr[3] = closeTimeBean.closeTime.substring(0, 2);
                strArr[4] = closeTimeBean.closeTime.substring(3, 5);
                return strArr[0] + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + strArr[1] + '-' + strArr[2] + " " + strArr[3] + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + strArr[4];
            }
        }
        return "";
    }

    public switchlistRsp.DataDTO.ItemDataDTO getCloseTimeBean(int i, switchlistRsp.DataDTO dataDTO, switchlistRsp.DataDTO dataDTO2) {
        switchlistRsp.DataDTO.ItemDataDTO itemDataDTO = null;
        for (int i2 = 0; i2 < dataDTO.switchList.size(); i2++) {
            if (i == dataDTO.switchList.get(i2).week.intValue()) {
                dataDTO.switchList.get(i2).isthisweek = true;
                itemDataDTO = dataDTO.switchList.get(i2);
            }
        }
        if (itemDataDTO == null) {
            for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO2 : dataDTO.switchList) {
                if (itemDataDTO2.week.intValue() > i) {
                    itemDataDTO2.isthisweek = true;
                    return itemDataDTO2;
                }
            }
        }
        return (itemDataDTO != null || dataDTO2.switchList.size() <= 0) ? itemDataDTO : dataDTO2.switchList.get(0);
    }

    switchlistRsp.DataDTO.ItemDataDTO getopenTimeBean(int i, switchlistRsp.DataDTO dataDTO, switchlistRsp.DataDTO dataDTO2) {
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO : dataDTO.switchList) {
            if (itemDataDTO.week.intValue() > i) {
                itemDataDTO.isthisweek = true;
                return itemDataDTO;
            }
        }
        if (dataDTO2.switchList.size() > 0) {
            return dataDTO2.switchList.get(0);
        }
        return null;
    }
}
