package com.yd.android_brand_mvp.adapter.attence;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.C;
import com.orhanobut.hawk.Hawk;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.AttenceUser;
import com.yd.android_brand_mvp.model.AttencelistRsp2;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.SiteAttendanceBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RuleUtils {
    private String TAG = RuleUtils.class.getSimpleName();
    private KBRsp2.DataDTO.TimetableListDTO table = null;
    private KBRsp2.DataDTO.TimetableListDTO siteTable = null;
    private List<String> attendanceIds = null;

    private static final class RuleHolder {
        static final RuleUtils rule = new RuleUtils();

        private RuleHolder() {
        }
    }

    public static RuleUtils getInstance() {
        return RuleHolder.rule;
    }

    public AttendancePeople IsTeacherByCard(String str) {
        return getAttendanceTeacher(str, SpData.AttenceKBData());
    }

    public AttendancePeople getSiteTeacher(String str) {
        return getAttendanceTeacher(str, (KBRsp2) Hawk.get(BaseHawk.NEWCDKB));
    }

    private AttendancePeople getAttendanceTeacher(String str, KBRsp2 kBRsp2) {
        int i;
        int i2;
        int i3;
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        if (kBRsp2 == null || attenceRule2 == null) {
            return null;
        }
        AttendancePeople attendancePeople = new AttendancePeople();
        List arrayList = new ArrayList();
        if (attenceRule2.data.eventTimetableRule != null) {
            if (!TextUtils.isEmpty(attenceRule2.data.eventTimetableRule.amMinute)) {
                i2 = Integer.parseInt(attenceRule2.data.eventTimetableRule.amMinute);
            } else {
                i2 = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
            }
            if (!TextUtils.isEmpty(attenceRule2.data.eventTimetableRule.pmMinute)) {
                i3 = Integer.parseInt(attenceRule2.data.eventTimetableRule.pmMinute);
            } else {
                i3 = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
            }
            i = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        int i4 = Integer.parseInt(TimeUtil.getWeek2(System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        if (kBRsp2.data.timetableList.size() > 0) {
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2.data.timetableList) {
                if (timetableListDTO.week == i4) {
                    arrayList2.add(timetableListDTO);
                }
            }
            Log.e(this.TAG, "timetableList = " + JSON.toJSONString(arrayList2));
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                if (((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).week == i4) {
                    String str2 = ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).sectionType;
                    attendancePeople.listCouseId = ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).id;
                    attendancePeople.setAttenceName(((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).subjectName);
                    byte b = -1;
                    int iHashCode = str2.hashCode();
                    if (iHashCode != 50) {
                        if (iHashCode == 51 && str2.equals("3")) {
                            b = 1;
                        }
                    } else if (str2.equals("2")) {
                        b = 0;
                    }
                    if (b != 0) {
                        if (b == 1) {
                            if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).endTime, i3)) {
                                arrayList = ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).teacherList;
                            }
                        } else if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).endTime, i)) {
                            arrayList = ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).teacherList;
                        }
                    } else if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).endTime, i2)) {
                        arrayList = ((KBRsp2.DataDTO.TimetableListDTO) arrayList2.get(i5)).teacherList;
                    }
                }
            }
        }
        Log.e(this.TAG, "TeacherList = " + JSON.toJSONString(arrayList));
        if (arrayList.size() > 0) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (str.equals(((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) arrayList.get(i6)).cardNumber) || str.equals(((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) arrayList.get(i6)).id)) {
                    attendancePeople.name = ((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) arrayList.get(i6)).name;
                    attendancePeople.id = Long.parseLong(((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) arrayList.get(i6)).id);
                    attendancePeople.CardNo = ((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) arrayList.get(i6)).cardNumber;
                    attendancePeople.status = "0";
                    attendancePeople.setTime(TimeUtil.stampToDate9(System.currentTimeMillis()));
                    attendancePeople.identy = "1";
                }
            }
        }
        return attendancePeople;
    }

    public AttendancePeople getAttendancePeople(String str) {
        AttendancePeople attendancePeople = new AttendancePeople();
        if (SpData.getAttenceRule2() != null && SpData.getAttencePersons() != null) {
            for (AttenceUser.DataDTO dataDTO : SpData.getAttencePersons()) {
                if (dataDTO.studentList != null) {
                    for (AttenceUser.DataDTO.StudentListDTO studentListDTO : dataDTO.studentList) {
                        if (str.equals(studentListDTO.userId) || str.equals(studentListDTO.icCardNo)) {
                            if (isAttendance(dataDTO.attendanceId)) {
                                attendancePeople.setId(Long.parseLong(studentListDTO.userId));
                                attendancePeople.setName(studentListDTO.userName);
                                attendancePeople.setAttenceId(Long.parseLong(dataDTO.attendanceId));
                                return attendancePeople;
                            }
                        }
                    }
                }
            }
        }
        if (isTable() != null) {
            for (AllstudentRsp.DataDTO dataDTO2 : SpData.getAllStudents().data) {
                if (str.equals(dataDTO2.id + "") || str.equals(dataDTO2.icCardNo)) {
                    attendancePeople.setId(dataDTO2.id);
                    attendancePeople.setIdenty("0");
                    attendancePeople.isFromTable = true;
                    attendancePeople.setName(dataDTO2.name);
                    return attendancePeople;
                }
            }
        }
        List<SiteAttendanceBean> list = (List) Hawk.get(BaseHawk.SITE_ATTENDANCE_PEOPLE);
        if (list != null && list.size() > 0) {
            for (SiteAttendanceBean siteAttendanceBean : list) {
                if ((!TextUtils.isEmpty(str) && str.equals(siteAttendanceBean.getPersonId())) || (!TextUtils.isEmpty(siteAttendanceBean.getIcCardNo()) && str.equals(siteAttendanceBean.getIcCardNo()))) {
                    attendancePeople.setId(Long.parseLong(siteAttendanceBean.getPersonId()));
                    attendancePeople.setIdenty("0");
                    attendancePeople.setName(siteAttendanceBean.getName());
                }
            }
        }
        return attendancePeople;
    }

    public List<String> getAttendanceIds() {
        ArrayList arrayList = new ArrayList();
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        if (attenceRule2 != null && attenceRule2.data != null && attenceRule2.data.attendanceList != null) {
            List<AttencelistRsp2.DataDTO.AttendanceListDTO> list = attenceRule2.data.attendanceList;
            for (int i = 0; i < list.size(); i++) {
                AttencelistRsp2.DataDTO.AttendanceListDTO attendanceListDTO = list.get(i);
                long j = TimeUtil.gettime66(attendanceListDTO.startDate);
                long j2 = TimeUtil.gettime66(attendanceListDTO.endDate);
                long j3 = TimeUtil.gettime66(TimeUtil.getCurrentyyyyMMdd());
                if (j3 >= j && j3 <= j2) {
                    List<AttencelistRsp2.DataDTO.AttendanceListDTO.TimeListDTO> list2 = list.get(i).timeList;
                    if (list.get(i).timeList.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            AttencelistRsp2.DataDTO.AttendanceListDTO.TimeListDTO timeListDTO = list2.get(i2);
                            if (forTime(timeListDTO.startTime, timeListDTO.endTime)) {
                                arrayList.add(timeListDTO.attendanceId);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public boolean isAttendance(String str) {
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        if (attenceRule2 == null || attenceRule2.data == null || attenceRule2.data.attendanceList == null) {
            return false;
        }
        for (AttencelistRsp2.DataDTO.AttendanceListDTO attendanceListDTO : attenceRule2.data.attendanceList) {
            if (!TextUtils.isEmpty(str) && str.equals(attendanceListDTO.id)) {
                return true;
            }
        }
        return false;
    }

    public AttendancePeople IsTime(AttendancePeople attendancePeople) {
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        if (attenceRule2 == null || attenceRule2.data == null || attenceRule2.data.attendanceList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = attenceRule2.data.attendanceList.size();
        String str = size > 0 ? attenceRule2.data.attendanceList.get(size - 1).id : "";
        ArrayList<String> arrayList = new ArrayList();
        for (AttencelistRsp2.DataDTO.AttendanceListDTO attendanceListDTO : attenceRule2.data.attendanceList) {
            String str2 = attendanceListDTO.id;
            if (TimeUtil.isBelong3(attendanceListDTO.startDate, attendanceListDTO.endDate)) {
                Log.e(this.TAG, "单次考勤: ");
                for (AttencelistRsp2.DataDTO.AttendanceListDTO.TimeListDTO timeListDTO : attendanceListDTO.timeList) {
                    if (forTime(timeListDTO.startTime, timeListDTO.endTime)) {
                        attendancePeople.setTime(TimeUtil.stampToDate9(System.currentTimeMillis()));
                        if (str2.equals(str)) {
                            sb.append(str2);
                        } else {
                            sb.append(str2);
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        arrayList.add(str2);
                    }
                }
            }
        }
        List<AttenceUser.DataDTO> attencePersons = SpData.getAttencePersons();
        if (attencePersons != null) {
            for (AttenceUser.DataDTO dataDTO : attencePersons) {
                for (String str3 : arrayList) {
                    if (!TextUtils.isEmpty(dataDTO.attendanceId) && str3.equals(dataDTO.attendanceId) && dataDTO.studentList != null) {
                        Iterator<AttenceUser.DataDTO.StudentListDTO> it2 = dataDTO.studentList.iterator();
                        while (it2.hasNext()) {
                            if (String.valueOf(attendancePeople.id).equals(it2.next().userId)) {
                                attendancePeople.setAttenceIdList(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(attendancePeople.getAttenceIdList()) && TextUtils.isEmpty(attendancePeople.listCouseId) && TextUtils.isEmpty(attendancePeople.getSiteTimetableId())) {
            attendancePeople.setTime("");
        }
        List<SiteAttendanceBean> list = (List) Hawk.get(BaseHawk.SITE_ATTENDANCE_PEOPLE);
        String siteTimetableId = attendancePeople.getSiteTimetableId();
        attendancePeople.setSiteTimetableId("");
        if (!TextUtils.isEmpty(siteTimetableId) && list != null) {
            for (SiteAttendanceBean siteAttendanceBean : list) {
                if (!TextUtils.isEmpty(siteTimetableId) && siteTimetableId.equals(siteAttendanceBean.getTimetableId()) && String.valueOf(attendancePeople.id).equals(siteAttendanceBean.getPersonId())) {
                    attendancePeople.setSiteTimetableId(siteAttendanceBean.getTimetableId());
                    attendancePeople.setTime(TimeUtil.stampToDate9(System.currentTimeMillis()));
                    break;
                }
            }
        }
        return attendancePeople;
    }

    public KBRsp2.DataDTO.TimetableListDTO isSiteTable() {
        int i;
        int i2;
        int i3;
        int i4 = Integer.parseInt(TimeUtil.getWeek2(System.currentTimeMillis()));
        KBRsp2 siteKBData = SpData.getSiteKBData();
        ArrayList arrayList = new ArrayList();
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        if (attenceRule2 == null || attenceRule2.data == null || attenceRule2.data.eventTimetableRule == null) {
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            if (!TextUtils.isEmpty(attenceRule2.data.eventTimetableRule.amMinute)) {
                i2 = Integer.parseInt(attenceRule2.data.eventTimetableRule.amMinute);
            } else {
                i2 = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
            }
            if (!TextUtils.isEmpty(attenceRule2.data.eventTimetableRule.pmMinute)) {
                i3 = Integer.parseInt(attenceRule2.data.eventTimetableRule.pmMinute);
            } else {
                i3 = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
            }
            i = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
        }
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO = null;
        if (siteKBData != null && siteKBData.data != null && siteKBData.data.timetableList != null) {
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 : siteKBData.data.timetableList) {
                if (timetableListDTO2.week == i4) {
                    arrayList.add(timetableListDTO2);
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                if (((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).week == i4) {
                    String str = ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).sectionType;
                    byte b = -1;
                    int iHashCode = str.hashCode();
                    if (iHashCode != 50) {
                        if (iHashCode == 51 && str.equals("3")) {
                            b = 1;
                        }
                    } else if (str.equals("2")) {
                        b = 0;
                    }
                    if (b != 0) {
                        if (b == 1) {
                            if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).endTime, i3)) {
                                timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5);
                            }
                        } else if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).endTime, i)) {
                            timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5);
                        }
                    } else if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).endTime, i2)) {
                        timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5);
                    }
                }
            }
        }
        return timetableListDTO;
    }

    public List<KBRsp2.DataDTO.TimetableListDTO> getNowDayTableList() {
        ArrayList arrayList = new ArrayList();
        KBRsp2 kBRsp2AttenceKBData = SpData.AttenceKBData();
        int i = Integer.parseInt(TimeUtil.getWeek2(System.currentTimeMillis()));
        if (kBRsp2AttenceKBData != null && kBRsp2AttenceKBData.data.timetableList.size() > 0) {
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2AttenceKBData.data.timetableList) {
                if (timetableListDTO.week == i && TimeUtil.isDate(timetableListDTO.date)) {
                    arrayList.add(timetableListDTO);
                }
            }
        }
        return arrayList;
    }

    public KBRsp2.DataDTO.TimetableListDTO isTable() {
        int i;
        boolean z;
        int i2;
        int i3;
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO = null;
        if (attenceRule2 != null && attenceRule2.data != null && SpData.AttenceKBData() != null) {
            if (attenceRule2.data == null || attenceRule2.data.eventTimetableRule == null) {
                i = 0;
                z = false;
                i2 = 0;
                i3 = 0;
            } else {
                z = attenceRule2.data.eventTimetableRule.isStudent;
                if (!TextUtils.isEmpty(attenceRule2.data.eventTimetableRule.amMinute)) {
                    i2 = Integer.parseInt(attenceRule2.data.eventTimetableRule.amMinute);
                } else {
                    i2 = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
                }
                if (!TextUtils.isEmpty(attenceRule2.data.eventTimetableRule.pmMinute)) {
                    i3 = Integer.parseInt(attenceRule2.data.eventTimetableRule.pmMinute);
                } else {
                    i3 = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
                }
                i = Integer.parseInt(attenceRule2.data.eventTimetableRule.otherMinute);
            }
            int i4 = Integer.parseInt(TimeUtil.getWeek2(System.currentTimeMillis()));
            ArrayList arrayList = new ArrayList();
            KBRsp2 kBRsp2AttenceKBData = SpData.AttenceKBData();
            if (kBRsp2AttenceKBData != null && kBRsp2AttenceKBData.data.timetableList.size() > 0) {
                for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 : kBRsp2AttenceKBData.data.timetableList) {
                    if (timetableListDTO2.week == i4 && TimeUtil.isDate(timetableListDTO2.date)) {
                        arrayList.add(timetableListDTO2);
                    }
                }
                Hawk.get(BaseHawk.SITE_ATTENDANCE_PEOPLE);
                if (z) {
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        if (((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).week == i4 && ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).isStudent) {
                            String str = ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).sectionType;
                            byte b = -1;
                            int iHashCode = str.hashCode();
                            if (iHashCode != 50) {
                                if (iHashCode == 51 && str.equals("3")) {
                                    b = 1;
                                }
                            } else if (str.equals("2")) {
                                b = 0;
                            }
                            if (b != 0) {
                                if (b == 1) {
                                    if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).endTime, i3)) {
                                        timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5);
                                    }
                                } else if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).endTime, i)) {
                                    timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5);
                                }
                            } else if (forFiveTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5)).endTime, i2)) {
                                timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i5);
                            }
                        }
                    }
                }
            }
            Log.i(this.TAG, "课表 = " + JSON.toJSONString(timetableListDTO));
        }
        return timetableListDTO;
    }

    public KBRsp2.DataDTO.TimetableListDTO isRemindTable() {
        KBRsp2 kBRsp2KBData = SpData.KBData();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO = null;
        if (kBRsp2KBData == null) {
            return null;
        }
        int i = Integer.parseInt(TimeUtil.getWeek2(System.currentTimeMillis()));
        ArrayList arrayList = new ArrayList();
        if (kBRsp2KBData.data != null && kBRsp2KBData.data.timetableList != null && kBRsp2KBData.data.timetableList.size() > 0) {
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 : kBRsp2KBData.data.timetableList) {
                if (timetableListDTO2.week == i) {
                    arrayList.add(timetableListDTO2);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i2)).week == i && forRemindTime(((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i2)).startTime, ((KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i2)).endTime)) {
                    timetableListDTO = (KBRsp2.DataDTO.TimetableListDTO) arrayList.get(i2);
                }
            }
        }
        return timetableListDTO;
    }

    public boolean forTime(String str, String str2) {
        long j = TimeUtil.gettime99(str) + 5000;
        long j2 = TimeUtil.gettime99(str2) + C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        long timeHHmmss = TimeUtil.getTimeHHmmss(TimeUtil.stampToDate18(System.currentTimeMillis()));
        return j < timeHHmmss && timeHHmmss < j2;
    }

    public boolean forFiveTime(String str, String str2, int i) {
        long j = TimeUtil.gettime99(str) - (((long) i) * 60000);
        long j2 = TimeUtil.gettime99(str2);
        long j3 = TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
        return j <= j3 && j3 < j2;
    }

    public boolean isTableEnd(String str) {
        return TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis())) >= TimeUtil.gettime99(str);
    }

    public boolean forRemindTime(String str, String str2) {
        long j = TimeUtil.gettime99(str) - 600000;
        long j2 = TimeUtil.gettime99(str2) + 120000;
        long j3 = TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
        return j <= j3 && j3 < j2;
    }

    public boolean isCurrentTimeAttendance() {
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = getInstance().isTable();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsSiteTable = getInstance().isSiteTable();
        List<String> attendanceIds = getInstance().getAttendanceIds();
        Log.d(this.TAG, "old attendanceIds = " + GsonUtils.toJson(this.attendanceIds));
        Log.d(this.TAG, "new attendanceIds = " + GsonUtils.toJson(attendanceIds));
        boolean zEquals = GsonUtils.toJson(this.table).equals(GsonUtils.toJson(timetableListDTOIsTable)) ^ true;
        boolean zEquals2 = GsonUtils.toJson(timetableListDTOIsSiteTable).equals(GsonUtils.toJson(this.siteTable)) ^ true;
        boolean zEquals3 = GsonUtils.toJson(this.attendanceIds).equals(GsonUtils.toJson(attendanceIds)) ^ true;
        Log.d(this.TAG, "isCurrentTimeAttendance: table = " + zEquals);
        Log.d(this.TAG, "isCurrentTimeAttendance: siteTable = " + zEquals2);
        Log.d(this.TAG, "isCurrentTimeAttendance: attendanceIds = " + zEquals3);
        this.table = timetableListDTOIsTable;
        this.siteTable = timetableListDTOIsSiteTable;
        this.attendanceIds = attendanceIds;
        return zEquals || zEquals2 || zEquals3;
    }

    public boolean isRefreshAttendance(List<AttenceNewListBean.DataDTO> list) {
        boolean z;
        AttencelistRsp2 attenceRule2 = SpData.getAttenceRule2();
        boolean z2 = false;
        if (attenceRule2 == null || attenceRule2.data == null || attenceRule2.data.attendanceList == null || attenceRule2.data.attendanceList.size() == 0) {
            Log.i(this.TAG, "暂无考勤规则");
            return false;
        }
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = getInstance().isTable();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsSiteTable = getInstance().isSiteTable();
        List<String> attendanceIds = getInstance().getAttendanceIds();
        if ((list == null || list.size() == 0) && timetableListDTOIsTable == null && timetableListDTOIsSiteTable == null && attendanceIds.size() == 0) {
            Log.i(this.TAG, "考勤规则是否更新 = false");
            return false;
        }
        if (list == null || list.size() == 0) {
            if (timetableListDTOIsTable != null) {
                Log.i(this.TAG, "考勤规则是否更新 = true");
                return true;
            }
            if (timetableListDTOIsSiteTable != null) {
                Log.i(this.TAG, "考勤规则是否更新 = true");
                return true;
            }
            if (attendanceIds != null && attendanceIds.size() > 0) {
                Log.i(this.TAG, "考勤规则是否更新 = true");
                return true;
            }
        }
        if (timetableListDTOIsTable == null) {
            z = true;
            break;
        }
        Iterator<AttenceNewListBean.DataDTO> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            if (it2.next().name.equals(timetableListDTOIsTable.subjectName)) {
                z = false;
                break;
            }
        }
        if (timetableListDTOIsSiteTable != null) {
            Iterator<AttenceNewListBean.DataDTO> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().name.equals(timetableListDTOIsSiteTable.subjectName)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            Log.i(this.TAG, "考勤规则是否更新 = true");
            return true;
        }
        if (attendanceIds != null && attendanceIds.size() > 0) {
            int i = 0;
            for (String str : attendanceIds) {
                Iterator<AttenceNewListBean.DataDTO> it4 = list.iterator();
                while (it4.hasNext()) {
                    if (!it4.next().attendanceId.equals(str)) {
                        i++;
                    }
                }
            }
            z2 = i == attendanceIds.size();
            Log.i(this.TAG, "考勤规则是否更新 = " + z2);
        }
        return z2;
    }
}
