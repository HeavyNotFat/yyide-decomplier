package com.yd.android_brand_mvp.db;

/* JADX INFO: loaded from: classes4.dex */
public class Attendance {
    public String attendanceId;
    public String attendanceName;
    public String attendanceTimeId;
    public String attendanceType;
    public String cardNo;
    public String createdBy;
    public long createdDateTime;
    public String deviceName;
    public Long id;
    public String iscard;

    /* JADX INFO: renamed from: no, reason: collision with root package name */
    public String f2013no;
    public String path;
    public String peopleId;
    public String peopleName;
    public String schoolId;
    public String type;

    public Attendance(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j, String str10, String str11, String str12) {
        this.type = str;
        this.peopleId = str2;
        this.schoolId = str3;
        this.attendanceId = str4;
        this.attendanceTimeId = str5;
        this.attendanceName = str6;
        this.f2013no = str7;
        this.peopleName = str8;
        this.attendanceType = str9;
        this.createdDateTime = j;
        this.createdBy = str10;
        this.deviceName = str11;
        this.path = str12;
    }

    public Attendance() {
    }

    public long getcreatedDateTime() {
        return this.createdDateTime;
    }
}
