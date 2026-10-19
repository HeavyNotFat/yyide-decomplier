package com.yd.android_brand_mvp.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.AttenceUser;
import com.yd.android_brand_mvp.model.AttencelistRsp;
import com.yd.android_brand_mvp.model.AttencelistRsp2;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.MessageListBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewRemindRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.model.getSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.listSwkRsp;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.selectStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByClassesId2Rsp;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.model.studentListRsp;
import com.yd.android_brand_mvp.model.switchlistRsp;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import demo.model.LockObj;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SpData {
    public static String ATTENCEPERSON = "ATTENCEPERSON2";
    public static String ATTENCERULE = "ATTENCERULE2";
    public static String ATTENCERULE2 = "ATTENCERULE22";
    public static String Announcement3 = "Announcement32";
    public static String Announcement4 = "Announcement42";
    public static String Announcement5 = "Announcement26";
    public static String AttenceEnable = "AttenceEnable2";
    public static String AttenceKBData = "AttenceKBData2";
    public static String ClassDuty = "ClassDuty2";
    public static String ClassInfo = "ClassInfo2";
    public static String ClassInfoBean = "ClassInfoBean2";
    public static String ClassPermision = "ClassPermision2";
    public static String FileName = "FileName2";
    public static String HomeData = "HomeData2";
    public static String LASTATTENCEID = "LASTATTENCEID2";
    public static String LOGINDATA = "LOGINDATA2";
    public static String LOG_TIME = "log_time";
    public static String LockDevice = "LockDevice2";
    public static String LockMac = "LockMac";
    public static final String MESSAGE_DOMINATE = "message_dominate2";
    public static final String MESSAGE_HOME_BENA = "message_home_bena";
    public static String MSGTYPE = "MSGTYPE2";
    public static String NEWCLASSINFO = "NewClassInfo2";
    public static String NEWKB = "NEWKB2";
    public static String NEWNCALENDARLGET = "NEWNCALENDARL2";
    public static String NEWNCALENDARLSELECT = "NEWNCALENDARLSELECT2";
    public static String NEWWATCHWORD = "NewWatchWord2";
    public static String NewBrandUser = "NewBrandUser2";
    public static String REFRESHTOKEN = "REFRESHTOKEN2";
    public static String RESERVATION_LIST = "reservation_list";
    public static String Refresh = "Refresh2";
    public static String RegCode = "RegCode22";
    public static String ResponseCode = "ResponseCode2";
    public static String SCHOOLID = "SCHOOLID2";
    public static String SCHOOLINFO = "SCHOOLINFO2";
    public static String SCHOOLINFO2 = "SCHOOLINFO22";
    public static String SITEKB = "SITEKB";
    public static String SKIN = "SKIN";
    public static String SettingsPersons = "SettingsPersons2";
    public static String StudentList = "StudentList2";
    public static String Studentproduction = "Studentproduction2";
    public static String TOKEN = "TOKEN2";
    public static String Table = "Table2";
    public static String Time = "Time2";
    public static String Timelist = "Timelist2";
    public static String USERCENT = "USERCENT2";
    public static String USERCENT2 = "USERCENT2";
    public static String USERSIG = "USERSIG2";
    public static String VERTIFY_TYPE = "vertify_type";
    public static String Voice = "Voice2";
    public static String allStudents = "allStudents2";
    public static String bookloan = "bookloan2";
    public static String booknew = "booknew2";
    public static String brandApplicationId = "brandApplicationId2";
    public static String historyNum = "historyNum2";
    public static final String isCounselor = "isCounselor";
    public static String isFaceEnable = "isFaceEnable2";
    public static String listSwkRsp = "listSwkRsp2";
    public static String saveTime = "saveTime2";

    public static boolean isNight() {
        return SPUtils.getInstance().getBoolean(SKIN, false);
    }

    public static NewClassInfoRsp getNewClassInfoRsp() {
        String string = SPUtils.getInstance().getString(NEWCLASSINFO, "");
        if (string.isEmpty()) {
            return null;
        }
        return (NewClassInfoRsp) GsonUtils.fromJson(string, NewClassInfoRsp.class);
    }

    public static String getClassesName() {
        NewClassInfoRsp newClassInfoRsp = (NewClassInfoRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(NEWCLASSINFO, ""), NewClassInfoRsp.class);
        return (newClassInfoRsp == null || newClassInfoRsp.data == null) ? "" : newClassInfoRsp.data.classesName;
    }

    public static boolean getIsUploadLogFile() {
        return System.currentTimeMillis() - SPUtils.getInstance().getLong(LOG_TIME, 0L) >= 86400000;
    }

    public static getSchoolCalendarRsp getNewSchoolCalendarRsp() {
        String string = SPUtils.getInstance().getString(NEWNCALENDARLGET, "");
        if (string.isEmpty()) {
            return null;
        }
        return (getSchoolCalendarRsp) GsonUtils.fromJson(string, getSchoolCalendarRsp.class);
    }

    public static List<ReservationRecordBean> getReservationToDayList() {
        String string = SPUtils.getInstance().getString(RESERVATION_LIST, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (List) GsonUtils.fromJson(string, new TypeReference<List<ReservationRecordBean>>() { // from class: com.yd.android_brand_mvp.utils.SpData.1
        }.getType());
    }

    public static selectSchoolCalendarRsp getNewSelectSchoolCalendarRsp() {
        String string = SPUtils.getInstance().getString(NEWNCALENDARLSELECT, "");
        if (string.isEmpty()) {
            return null;
        }
        return (selectSchoolCalendarRsp) GsonUtils.fromJson(string, selectSchoolCalendarRsp.class);
    }

    public static NewWatchWordRsp getNewWatchWordRsp() {
        String string = SPUtils.getInstance().getString(NEWWATCHWORD, "");
        if (string.isEmpty()) {
            return null;
        }
        return (NewWatchWordRsp) GsonUtils.fromJson(string, NewWatchWordRsp.class);
    }

    public static boolean getMsgType() {
        return SPUtils.getInstance().getBoolean(MSGTYPE);
    }

    public static String RegisterCode() {
        return SPUtils.getInstance().getString(RegCode, "");
    }

    public static boolean isFaceEnable() {
        return SPUtils.getInstance().getBoolean(isFaceEnable);
    }

    public static String getToken() {
        return SPUtils.getInstance().getString(TOKEN, "");
    }

    public static String isAttenceEnable() {
        return SPUtils.getInstance().getString(AttenceEnable, "");
    }

    public static NewBrandLoginRsp NewUser() {
        NewBrandLoginRsp newBrandLoginRsp = (NewBrandLoginRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(NewBrandUser, ""), NewBrandLoginRsp.class);
        return newBrandLoginRsp == null ? new NewBrandLoginRsp() : newBrandLoginRsp;
    }

    public static String getSchoolId() {
        return (NewUser() == null || NewUser().data == null) ? "" : NewUser().data.schoolId;
    }

    public static String getClassesId() {
        return (NewUser() == null || NewUser().data == null) ? "" : NewUser().data.classesId;
    }

    public static String getSchoolName() {
        return (getSchoolInfo2() == null || getSchoolInfo2().data == null) ? "" : getSchoolInfo2().data.schoolName;
    }

    public static String getSchoolType() {
        return getSchoolInfo2().data != null ? NewUser().data.schoolType : "";
    }

    public static String getBrandId() {
        return (NewUser() == null || NewUser().data == null) ? "" : NewUser().data.id;
    }

    public static String getBrandName() {
        return (NewUser() == null || NewUser().data == null) ? "" : NewUser().data.brandName;
    }

    public static String getSiteName() {
        return (NewUser() == null || NewUser().data == null) ? "" : NewUser().data.siteName;
    }

    public static String getSiteId() {
        return (NewUser() == null || NewUser().data == null) ? "" : NewUser().data.siteId;
    }

    public static LayoutListRsp HomeIndexData() {
        String string = SPUtils.getInstance().getString(HomeData, "");
        if (string.isEmpty()) {
            return new LayoutListRsp();
        }
        return (LayoutListRsp) GsonUtils.fromJson(string, LayoutListRsp.class);
    }

    public static List<MessageItemBean> getMessageDominateList() {
        String string = SPUtils.getInstance().getString(MESSAGE_DOMINATE, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (List) GsonUtils.fromJson(string, new TypeReference<List<MessageItemBean>>() { // from class: com.yd.android_brand_mvp.utils.SpData.2
        }.getType());
    }

    public static List<MessageItemBean> getMessageHomeCache(String str) {
        String string = SPUtils.getInstance().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (List) GsonUtils.fromJson(string, new TypeReference<List<MessageItemBean>>() { // from class: com.yd.android_brand_mvp.utils.SpData.3
        }.getType());
    }

    public static MessageListBean getMessageHomeCache() {
        String string = SPUtils.getInstance().getString(MESSAGE_HOME_BENA, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (MessageListBean) GsonUtils.fromJson(string, MessageListBean.class);
    }

    public static String getUiserSig() {
        return SPUtils.getInstance().getString(USERSIG, "");
    }

    public static selectStudentByIcCardRsp USERCENTINFO() {
        return (selectStudentByIcCardRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(USERCENT, ""), selectStudentByIcCardRsp.class);
    }

    public static selectNewStudentByIcCardRsp USERCENTINFO2() {
        selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp = (selectNewStudentByIcCardRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(USERCENT2, ""), selectNewStudentByIcCardRsp.class);
        return selectnewstudentbyiccardrsp == null ? new selectNewStudentByIcCardRsp() : selectnewstudentbyiccardrsp;
    }

    public static SchoolStytleRsp getSchoolInfo2() {
        SchoolStytleRsp schoolStytleRsp = (SchoolStytleRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(SCHOOLINFO2, ""), SchoolStytleRsp.class);
        return schoolStytleRsp == null ? new SchoolStytleRsp() : schoolStytleRsp;
    }

    public static AttencelistRsp getAttenceRule() {
        String string = SPUtils.getInstance().getString(ATTENCERULE, "");
        if (string.isEmpty()) {
            return null;
        }
        return (AttencelistRsp) GsonUtils.fromJson(string, AttencelistRsp.class);
    }

    public static AttencelistRsp2 getAttenceRule2() {
        String string = SPUtils.getInstance().getString(ATTENCERULE2, "");
        if (string.isEmpty()) {
            return null;
        }
        return (AttencelistRsp2) GsonUtils.fromJson(string, AttencelistRsp2.class);
    }

    public static KBRsp2 KBData() {
        String string = SPUtils.getInstance().getString(NEWKB, "");
        if (string.isEmpty()) {
            return null;
        }
        return (KBRsp2) GsonUtils.fromJson(string, KBRsp2.class);
    }

    public static KBRsp2 getSiteKBData() {
        String string = SPUtils.getInstance().getString(SITEKB, "");
        if (string.isEmpty()) {
            return null;
        }
        return (KBRsp2) GsonUtils.fromJson(string, KBRsp2.class);
    }

    public static KBRsp2 AttenceKBData() {
        String string = SPUtils.getInstance().getString(AttenceKBData, "");
        if (string.isEmpty()) {
            return null;
        }
        return (KBRsp2) GsonUtils.fromJson(string, KBRsp2.class);
    }

    public static List<AttenceUser.DataDTO> getAttencePersons() {
        return (List) GsonUtils.fromJson(SPUtils.getInstance().getString(ATTENCEPERSON, ""), new TypeReference<List<AttenceUser.DataDTO>>() { // from class: com.yd.android_brand_mvp.utils.SpData.4
        }.getType());
    }

    public static switchlistRsp getTime() {
        return (switchlistRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Time, ""), switchlistRsp.class);
    }

    public static UserTableRsp getTable() {
        return (UserTableRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Table, ""), UserTableRsp.class);
    }

    public static studentListRsp getStudenList() {
        return (studentListRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(StudentList, ""), studentListRsp.class);
    }

    public static AllstudentRsp getAllStudents() {
        return (AllstudentRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(allStudents, ""), AllstudentRsp.class);
    }

    public static selectTeacherByClassesId2Rsp getSettingPersonsData() {
        return (selectTeacherByClassesId2Rsp) GsonUtils.fromJson(SPUtils.getInstance().getString(SettingsPersons, ""), selectTeacherByClassesId2Rsp.class);
    }

    public static boolean isRefreash() {
        return SPUtils.getInstance().getBoolean(Refresh);
    }

    public static String getFileName() {
        return SPUtils.getInstance().getString(FileName, "");
    }

    public static selectTeacherByClassesIdRsp getClassPermision() {
        return (selectTeacherByClassesIdRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(ClassPermision, ""), selectTeacherByClassesIdRsp.class);
    }

    public static String getSaveTime() {
        return SPUtils.getInstance().getString(saveTime, "");
    }

    public static NewRemindRsp getVoiceData() {
        return (NewRemindRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Voice, ""), NewRemindRsp.class);
    }

    public static selectClassesInfoRsp getClassInfoRsp() {
        return (selectClassesInfoRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(ClassInfo, ""), selectClassesInfoRsp.class);
    }

    public static ClassesInfoBean getClassesInfoBean() {
        return (ClassesInfoBean) GsonUtils.fromJson(SPUtils.getInstance().getString(ClassInfoBean, ""), ClassesInfoBean.class);
    }

    public static StudenDutyBean getStudenDutyBean() {
        return (StudenDutyBean) GsonUtils.fromJson(SPUtils.getInstance().getString(ClassDuty, ""), StudenDutyBean.class);
    }

    public static StudentWorkListBean getStudentproduction() {
        return (StudentWorkListBean) GsonUtils.fromJson(SPUtils.getInstance().getString(Studentproduction, ""), StudentWorkListBean.class);
    }

    public static getNoticeRsp getAnnouncement3() {
        return (getNoticeRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Announcement3, ""), getNoticeRsp.class);
    }

    public static getNoticeRsp getAnnouncement4() {
        return (getNoticeRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Announcement4, ""), getNoticeRsp.class);
    }

    public static getNoticeRsp getAnnouncement5() {
        return (getNoticeRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Announcement5, ""), getNoticeRsp.class);
    }

    public static TimelistRsp getTimelist() {
        return (TimelistRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(Timelist, ""), TimelistRsp.class);
    }

    public static LockObj getDeviceMsg() {
        return (LockObj) GsonUtils.fromJson(SPUtils.getInstance().getString(LockDevice, ""), LockObj.class);
    }

    public static String getLockMac() {
        return SPUtils.getInstance().getString(LockMac, "");
    }

    public static listSwkRsp getlistSwkRsp() {
        return (listSwkRsp) GsonUtils.fromJson(SPUtils.getInstance().getString(listSwkRsp, ""), listSwkRsp.class);
    }

    public static int gethistoryPower() {
        return SPUtils.getInstance().getInt(historyNum, 0);
    }

    public static int getResponseCode() {
        return SPUtils.getInstance().getInt(ResponseCode, 0);
    }

    public static getSchoolCalendarRsp getNcData() {
        return (getSchoolCalendarRsp) GsonUtils.fromJson(SPUtils.getInstance().getString("nc", ""), getSchoolCalendarRsp.class);
    }

    public static String getTimePoweroff() {
        List<switchlistRsp.DataDTO.ItemDataDTO> list = getTime().data.switchList;
        if (list == null || list.size() <= 0) {
            return "无开关机设置";
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, 1);
        String strSubstring = "";
        String strSubstring2 = "";
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO : list) {
            Log.e("TAG", "getTimePower2: " + JSON.toJSONString(itemDataDTO));
            int i = calendar.get(7);
            int i2 = calendar2.get(7);
            if (i == (itemDataDTO.week.intValue() + 1 == 8 ? 1 : itemDataDTO.week.intValue() + 1)) {
                strSubstring = itemDataDTO.closeTime.substring(0, 2);
                strSubstring2 = itemDataDTO.closeTime.substring(3, 5);
                itemDataDTO.openTime.substring(0, 2);
                itemDataDTO.openTime.substring(3, 5);
                calendar.get(1);
                calendar.get(2);
                calendar.get(5);
                Integer.parseInt(itemDataDTO.closeTime.substring(0, 2));
                Integer.parseInt(itemDataDTO.closeTime.substring(3, 5));
            }
            if (i2 == (itemDataDTO.week.intValue() + 1 == 8 ? 1 : itemDataDTO.week.intValue() + 1)) {
                calendar2.get(1);
                calendar2.get(2);
                calendar2.get(5);
                Integer.parseInt(itemDataDTO.openTime.substring(0, 2));
                Integer.parseInt(itemDataDTO.openTime.substring(3, 5));
            }
        }
        return strSubstring + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + strSubstring2;
    }

    public static String getTimePoweron() {
        List<switchlistRsp.DataDTO.ItemDataDTO> list = getTime().data.switchList;
        if (list == null || list.size() <= 0) {
            return "无开关机设置";
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, 1);
        String strSubstring = "";
        String strSubstring2 = "";
        for (switchlistRsp.DataDTO.ItemDataDTO itemDataDTO : list) {
            Log.e("TAG", "getTimePower2: " + JSON.toJSONString(itemDataDTO));
            int i = calendar.get(7);
            int i2 = calendar2.get(7);
            if (i == (itemDataDTO.week.intValue() + 1 == 8 ? 1 : itemDataDTO.week.intValue() + 1)) {
                strSubstring = itemDataDTO.openTime.substring(0, 2);
                strSubstring2 = itemDataDTO.openTime.substring(3, 5);
                calendar.get(1);
                calendar.get(2);
                calendar.get(5);
                Integer.parseInt(itemDataDTO.closeTime.substring(0, 2));
                Integer.parseInt(itemDataDTO.closeTime.substring(3, 5));
            }
            if (i2 == (itemDataDTO.week.intValue() + 1 == 8 ? 1 : itemDataDTO.week.intValue() + 1)) {
                calendar2.get(1);
                calendar2.get(2);
                calendar2.get(5);
                Integer.parseInt(itemDataDTO.openTime.substring(0, 2));
                Integer.parseInt(itemDataDTO.openTime.substring(3, 5));
            }
        }
        return strSubstring + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + strSubstring2;
    }

    public static List<YwBookRsp> getBookDataNew() {
        return (List) GsonUtils.fromJson(SPUtils.getInstance().getString(booknew, ""), new TypeReference<List<YwBookRsp>>() { // from class: com.yd.android_brand_mvp.utils.SpData.5
        }.getType());
    }

    public static List<YwBookRsp> getBookDataLoan() {
        return (List) GsonUtils.fromJson(SPUtils.getInstance().getString(bookloan, ""), new TypeReference<List<YwBookRsp>>() { // from class: com.yd.android_brand_mvp.utils.SpData.6
        }.getType());
    }
}
