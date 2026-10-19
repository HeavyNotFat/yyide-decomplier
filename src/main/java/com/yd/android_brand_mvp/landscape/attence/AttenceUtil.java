package com.yd.android_brand_mvp.landscape.attence;

import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceListBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceUtil {
    public static List<AttencesExcBean> getAttenceCourseBean(AttenceListBean.DataDTO.CourseListDTO courseListDTO) {
        ArrayList arrayList = new ArrayList();
        AttencesExcBean attencesExcBean = new AttencesExcBean();
        AttencesExcBean attencesExcBean2 = new AttencesExcBean();
        AttencesExcBean attencesExcBean3 = new AttencesExcBean();
        AttencesExcBean attencesExcBean4 = new AttencesExcBean();
        AttencesExcBean attencesExcBean5 = new AttencesExcBean();
        attencesExcBean.lab = "未签退";
        attencesExcBean.count = courseListDTO.absenteeism;
        attencesExcBean.nameList = courseListDTO.absenteeismList;
        attencesExcBean.bgId = 1;
        attencesExcBean2.lab = "早退";
        attencesExcBean2.count = courseListDTO.early;
        attencesExcBean2.nameList = courseListDTO.earlyList;
        attencesExcBean2.bgId = 2;
        attencesExcBean3.lab = "请假";
        attencesExcBean3.count = courseListDTO.leave;
        attencesExcBean3.nameList = courseListDTO.leaveList;
        attencesExcBean3.bgId = 3;
        attencesExcBean4.lab = "未签到";
        attencesExcBean4.count = courseListDTO.absenteeism;
        attencesExcBean4.nameList = courseListDTO.absenteeismList;
        attencesExcBean4.bgId = 4;
        attencesExcBean5.lab = "迟到";
        attencesExcBean5.count = courseListDTO.late;
        attencesExcBean5.nameList = courseListDTO.lateList;
        attencesExcBean5.bgId = 5;
        if (attencesExcBean4.count > 0) {
            arrayList.add(attencesExcBean4);
        }
        if (attencesExcBean5.count > 0) {
            arrayList.add(attencesExcBean5);
        }
        if (attencesExcBean3.count > 0) {
            arrayList.add(attencesExcBean3);
        }
        return arrayList;
    }

    public static List<AttencesExcBean> getAttenceCourseBean(AttenceListBean.DataDTO.EventListDTO eventListDTO) {
        ArrayList arrayList = new ArrayList();
        AttencesExcBean attencesExcBean = new AttencesExcBean();
        AttencesExcBean attencesExcBean2 = new AttencesExcBean();
        AttencesExcBean attencesExcBean3 = new AttencesExcBean();
        AttencesExcBean attencesExcBean4 = new AttencesExcBean();
        AttencesExcBean attencesExcBean5 = new AttencesExcBean();
        attencesExcBean.lab = "未签退";
        attencesExcBean.count = eventListDTO.absenteeism;
        attencesExcBean.nameList = eventListDTO.absenteeismList;
        attencesExcBean.bgId = 1;
        attencesExcBean2.lab = "早退";
        attencesExcBean2.count = eventListDTO.early;
        attencesExcBean2.nameList = eventListDTO.earlyList;
        attencesExcBean2.bgId = 2;
        attencesExcBean3.lab = "请假";
        attencesExcBean3.count = eventListDTO.leave;
        attencesExcBean3.nameList = eventListDTO.leaveList;
        attencesExcBean3.bgId = 3;
        attencesExcBean4.lab = "未签到";
        attencesExcBean4.count = eventListDTO.absenteeism;
        attencesExcBean4.nameList = eventListDTO.absenteeismList;
        attencesExcBean4.bgId = 4;
        attencesExcBean5.lab = "迟到";
        attencesExcBean5.count = eventListDTO.late;
        attencesExcBean5.nameList = eventListDTO.lateList;
        attencesExcBean5.bgId = 5;
        if ("1".equals(eventListDTO.attendanceSignOut)) {
            if (attencesExcBean.count > 0) {
                arrayList.add(attencesExcBean);
            }
            if (attencesExcBean2.count > 0) {
                arrayList.add(attencesExcBean2);
            }
            if (attencesExcBean3.count > 0) {
                arrayList.add(attencesExcBean3);
            }
        } else {
            if (attencesExcBean4.count > 0) {
                arrayList.add(attencesExcBean4);
            }
            if (attencesExcBean5.count > 0) {
                arrayList.add(attencesExcBean5);
            }
            if (attencesExcBean3.count > 0) {
                arrayList.add(attencesExcBean3);
            }
        }
        return arrayList;
    }

    public static List<AttencesExcBean> getNewAttenceCourseBean(AttanceTodatDetailsRsp attanceTodatDetailsRsp) {
        ArrayList arrayList = new ArrayList();
        AttencesExcBean attencesExcBean = new AttencesExcBean();
        AttencesExcBean attencesExcBean2 = new AttencesExcBean();
        AttencesExcBean attencesExcBean3 = new AttencesExcBean();
        AttencesExcBean attencesExcBean4 = new AttencesExcBean();
        AttencesExcBean attencesExcBean5 = new AttencesExcBean();
        attencesExcBean.lab = "未签退";
        attencesExcBean.count = 0;
        attencesExcBean.bgId = 1;
        if (attanceTodatDetailsRsp.data == null) {
            return arrayList;
        }
        attencesExcBean2.lab = "早退";
        attencesExcBean2.count = attanceTodatDetailsRsp.data.leaveEarlyList.size();
        attencesExcBean2.listName = attanceTodatDetailsRsp.data.leaveEarlyList;
        attencesExcBean2.bgId = 2;
        attencesExcBean3.lab = "请假";
        attencesExcBean3.count = attanceTodatDetailsRsp.data.leaveList.size();
        attencesExcBean3.listName = attanceTodatDetailsRsp.data.leaveList;
        attencesExcBean3.bgId = 3;
        attencesExcBean4.lab = "未签到";
        attencesExcBean4.count = attanceTodatDetailsRsp.data.absenteeismList.size();
        attencesExcBean4.listName = attanceTodatDetailsRsp.data.absenteeismList;
        attencesExcBean4.bgId = 4;
        attencesExcBean5.lab = "迟到";
        attencesExcBean5.count = attanceTodatDetailsRsp.data.beLateList.size();
        attencesExcBean5.listName = attanceTodatDetailsRsp.data.beLateList;
        attencesExcBean5.bgId = 5;
        if (attencesExcBean.count > 0) {
            arrayList.add(attencesExcBean);
        }
        if (attencesExcBean2.count > 0) {
            arrayList.add(attencesExcBean2);
        }
        if (attencesExcBean3.count > 0) {
            arrayList.add(attencesExcBean3);
        }
        if (attencesExcBean4.count > 0) {
            arrayList.add(attencesExcBean4);
        }
        if (attencesExcBean5.count > 0) {
            arrayList.add(attencesExcBean5);
        }
        return arrayList;
    }
}
