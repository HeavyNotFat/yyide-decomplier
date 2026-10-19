package com.yd.android_brand_mvp.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.model.AttencelistRsp;
import com.yd.android_brand_mvp.model.UserTableRsp;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class TableUtils {
    private static TableUtils instance;

    public static TableUtils getInstance() {
        if (instance == null) {
            instance = new TableUtils();
        }
        return instance;
    }

    public UserTableRsp.DataDTO.SubListDTO isTable2(int i, String str) {
        if (SpData.getAttenceRule().data.courseList.size() > 0) {
            for (AttencelistRsp.DataDTO.CourseListDTO courseListDTO : SpData.getAttenceRule().data.courseList) {
                if (!TextUtils.isEmpty(courseListDTO.afterTime)) {
                    Integer.parseInt(courseListDTO.afterTime);
                }
                if (!TextUtils.isEmpty(courseListDTO.beforeTime)) {
                    Integer.parseInt(courseListDTO.beforeTime);
                }
            }
        }
        int i2 = Integer.parseInt(TimeUtil.getWeek2(System.currentTimeMillis()));
        ArrayList<UserTableRsp.DataDTO.SubListDTO> arrayList = new ArrayList();
        UserTableRsp.DataDTO.SubListDTO subListDTO = null;
        if (SpData.getTable() != null && SpData.getTable().data.subList.size() > 0) {
            for (UserTableRsp.DataDTO.SubListDTO subListDTO2 : SpData.getTable().data.subList) {
                if (subListDTO2.weekTime == i2) {
                    arrayList.add(subListDTO2);
                }
            }
            CheckTime checkTime = new CheckTime();
            for (UserTableRsp.DataDTO.SubListDTO subListDTO3 : arrayList) {
                if (str.equals("1")) {
                    if (checkTime.forTime222(subListDTO3.fromDateTime, subListDTO3.toDateTime, i, 0)) {
                        subListDTO = subListDTO3;
                    }
                } else if (checkTime.forTime333(subListDTO3.fromDateTime, subListDTO3.toDateTime, i, 0)) {
                    subListDTO = subListDTO3;
                }
            }
            if (subListDTO != null) {
                if (TextUtils.isEmpty(subListDTO.subjectName)) {
                    Log.e("TAG", "isTable: 无课");
                } else {
                    Log.e("TAG", "isTable: " + JSON.toJSONString(subListDTO));
                }
            }
        }
        return subListDTO;
    }
}
