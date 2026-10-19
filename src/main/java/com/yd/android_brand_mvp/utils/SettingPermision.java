package com.yd.android_brand_mvp.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.model.IdentityBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class SettingPermision {
    public static SettingPermision settingPermision;
    public selectTeacherByClassesIdRsp.DataDTO mDataDTO = null;

    public static SettingPermision getInstance() {
        if (settingPermision == null) {
            synchronized (SettingPermision.class) {
                if (settingPermision == null) {
                    settingPermision = new SettingPermision();
                }
            }
        }
        return settingPermision;
    }

    public boolean isHavePermission(String str, String str2) {
        if (SpData.getClassPermision() == null || SpData.getClassPermision().data == null || SpData.getClassPermision().data.size() <= 0) {
            return false;
        }
        for (selectTeacherByClassesIdRsp.DataDTO dataDTO : SpData.getClassPermision().data) {
            if (!TextUtils.isEmpty(str) && str.equals(dataDTO.cardNumber)) {
                this.mDataDTO = dataDTO;
                return true;
            }
            if (!TextUtils.isEmpty(str) && str2.equals(dataDTO.id)) {
                this.mDataDTO = dataDTO;
                return true;
            }
        }
        return false;
    }

    public selectTeacherByClassesIdRsp.DataDTO getHavePermission(String str, String str2) {
        if (SpData.getClassPermision() == null || SpData.getClassPermision().data == null || SpData.getClassPermision().data.size() <= 0) {
            return null;
        }
        Iterator<selectTeacherByClassesIdRsp.DataDTO> it2 = SpData.getClassPermision().data.iterator();
        while (it2.hasNext()) {
            selectTeacherByClassesIdRsp.DataDTO next = it2.next();
            if (str.equals(next.cardNumber) || str2.equals(next.id)) {
                return next;
            }
        }
        return null;
    }

    public boolean isHavePermissionByFace(String str) {
        if (SpData.getClassPermision() == null || SpData.getClassPermision().data == null || SpData.getClassPermision().data.size() <= 0) {
            return false;
        }
        for (selectTeacherByClassesIdRsp.DataDTO dataDTO : SpData.getClassPermision().data) {
            Log.e("datum:", JSON.toJSONString(dataDTO));
            if (str.equals(dataDTO.id)) {
                return true;
            }
        }
        return false;
    }

    public IdentityBean getPermissionIdentityInfo(String str) {
        if (SpData.getClassPermision() != null && SpData.getClassPermision().data != null && SpData.getClassPermision().data.size() > 0) {
            for (selectTeacherByClassesIdRsp.DataDTO dataDTO : SpData.getClassPermision().data) {
                if (str.equals(dataDTO.cardNumber)) {
                    return new IdentityBean(dataDTO.id + "", dataDTO.name, "2");
                }
                if (str.equals(dataDTO.id)) {
                    return new IdentityBean(dataDTO.id + "", dataDTO.name, "2");
                }
            }
        }
        return StudentPermision.getInstance().getStudent(str);
    }
}
