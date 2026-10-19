package com.yd.android_brand_mvp.utils;

import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceUtil {
    public static List<AttenceExcBean> getAttenceExcBean(AttenceBean.DataBean dataBean) {
        ArrayList arrayList = new ArrayList();
        AttenceExcBean attenceExcBean = new AttenceExcBean();
        AttenceExcBean attenceExcBean2 = new AttenceExcBean();
        AttenceExcBean attenceExcBean3 = new AttenceExcBean();
        AttenceExcBean attenceExcBean4 = new AttenceExcBean();
        AttenceExcBean attenceExcBean5 = new AttenceExcBean();
        attenceExcBean.lab = "未签退";
        attenceExcBean.count = dataBean.students.absencePeople == null ? 0 : dataBean.students.absencePeople.size();
        attenceExcBean.nameList = dataBean.students.absencePeople;
        attenceExcBean.bgId = 1;
        attenceExcBean2.lab = "早退";
        attenceExcBean2.count = dataBean.students.leaveEarlyPeople == null ? 0 : dataBean.students.leaveEarlyPeople.size();
        attenceExcBean2.nameList = dataBean.students.leaveEarlyPeople;
        attenceExcBean2.bgId = 2;
        attenceExcBean3.lab = "请假";
        attenceExcBean3.count = dataBean.students.leavePeople == null ? 0 : dataBean.students.leavePeople.size();
        attenceExcBean3.nameList = dataBean.students.leavePeople;
        attenceExcBean3.bgId = 3;
        attenceExcBean4.lab = "缺勤";
        attenceExcBean4.count = dataBean.students.absencePeople == null ? 0 : dataBean.students.absencePeople.size();
        attenceExcBean4.nameList = dataBean.students.absencePeople;
        attenceExcBean4.bgId = 4;
        attenceExcBean5.lab = "迟到";
        attenceExcBean5.count = dataBean.students.latePeople != null ? dataBean.students.latePeople.size() : 0;
        attenceExcBean5.nameList = dataBean.students.latePeople;
        attenceExcBean5.bgId = 5;
        if (!"0".equals(dataBean.students.attendanceType) && !"Y".equals(dataBean.identityType)) {
            if (attenceExcBean.count > 0) {
                arrayList.add(attenceExcBean);
            }
            if (attenceExcBean2.count > 0) {
                arrayList.add(attenceExcBean2);
            }
            if (attenceExcBean3.count > 0) {
                arrayList.add(attenceExcBean3);
            }
        } else {
            if (attenceExcBean4.count > 0) {
                arrayList.add(attenceExcBean4);
            }
            if (attenceExcBean5.count > 0) {
                arrayList.add(attenceExcBean5);
            }
            if (attenceExcBean3.count > 0) {
                arrayList.add(attenceExcBean3);
            }
        }
        return arrayList;
    }

    public static String getTitle(AttenceBean.DataBean dataBean) {
        StringBuffer stringBuffer = new StringBuffer();
        if ("Y".equals(dataBean.identityType)) {
            if (dataBean.students.section == 0) {
                stringBuffer.append("早读 " + dataBean.students.subjectName);
            } else {
                stringBuffer.append("第" + dataBean.students.section + "节 " + dataBean.students.subjectName);
            }
            stringBuffer.append("  " + dataBean.students.name);
        } else {
            stringBuffer.append(dataBean.students.name);
            stringBuffer.append("  " + dataBean.students.thingName);
        }
        return ((Object) stringBuffer) + "考勤异常人员";
    }
}
