package com.yd.android_brand_mvp.utils;

import android.text.TextUtils;
import android.util.Log;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.IdentityBean;

/* JADX INFO: loaded from: classes4.dex */
public class StudentPermision {
    public static StudentPermision settingPermision;

    public static StudentPermision getInstance() {
        if (settingPermision == null) {
            synchronized (StudentPermision.class) {
                if (settingPermision == null) {
                    settingPermision = new StudentPermision();
                }
            }
        }
        return settingPermision;
    }

    public boolean isHavePermission(String str, String str2) {
        AllstudentRsp allStudents = SpData.getAllStudents();
        if (allStudents == null || allStudents.data == null || allStudents.data.size() <= 0) {
            return false;
        }
        for (AllstudentRsp.DataDTO dataDTO : allStudents.data) {
            StringBuilder sb = new StringBuilder();
            sb.append("faceId: ");
            sb.append(str2);
            sb.append(str2.equals(dataDTO.id + ""));
            sb.append(dataDTO.id);
            Log.e("isHavePermission", sb.toString());
            if (str.equals(dataDTO.icCardNo) && !TextUtils.isEmpty(str)) {
                return true;
            }
            if (str2.equals(dataDTO.id + "")) {
                return true;
            }
        }
        return false;
    }

    public AllstudentRsp.DataDTO getHavePermission(String str, String str2) {
        AllstudentRsp allStudents = SpData.getAllStudents();
        if (allStudents == null || allStudents.data == null || allStudents.data.size() <= 0) {
            return null;
        }
        for (AllstudentRsp.DataDTO dataDTO : allStudents.data) {
            StringBuilder sb = new StringBuilder();
            sb.append("faceId: ");
            sb.append(str2);
            sb.append(str2.equals(dataDTO.id + ""));
            sb.append(dataDTO.id);
            Log.e("isHavePermission", sb.toString());
            if (str.equals(dataDTO.icCardNo) && !TextUtils.isEmpty(str)) {
                return dataDTO;
            }
            if (str2.equals(dataDTO.id + "")) {
                return dataDTO;
            }
        }
        return null;
    }

    public IdentityBean getStudent(String str) {
        AllstudentRsp allStudents = SpData.getAllStudents();
        if (allStudents == null || allStudents.data == null || allStudents.data.size() <= 0) {
            return null;
        }
        for (AllstudentRsp.DataDTO dataDTO : allStudents.data) {
            if (str.equals(dataDTO.icCardNo) && !TextUtils.isEmpty(str)) {
                return new IdentityBean(dataDTO.id + "", dataDTO.name, "1");
            }
            if (str.equals(dataDTO.id + "")) {
                return new IdentityBean(dataDTO.id + "", dataDTO.name, "1");
            }
        }
        return null;
    }
}
