package com.yd.android_brand_mvp.adapter.attence;

/* JADX INFO: loaded from: classes4.dex */
public class AttendancePeople {
    public long AttenceId;
    public String AttenceIdList;
    public String AttenceName;
    public long Timeid;
    public String classesId;
    public long id;
    public String identy;
    public String listCouseId;
    public String name;
    public String reqTime;
    private String siteTimetableId;
    public String status;
    public String time;
    public int type;
    public String CardNo = "";
    public Boolean isFromTable = false;

    public String getListCouseId() {
        return this.listCouseId;
    }

    public void setListCouseId(String str) {
        this.listCouseId = str;
    }

    public String getAttenceIdList() {
        return this.AttenceIdList;
    }

    public void setAttenceIdList(String str) {
        this.AttenceIdList = str;
    }

    public String getSiteTimetableId() {
        return this.siteTimetableId;
    }

    public void setSiteTimetableId(String str) {
        this.siteTimetableId = str;
    }

    public String getCardNo() {
        return this.CardNo;
    }

    public void setCardNo(String str) {
        this.CardNo = str;
    }

    public String getAttenceName() {
        return this.AttenceName;
    }

    public void setAttenceName(String str) {
        this.AttenceName = str;
    }

    public String getClassesId() {
        return this.classesId;
    }

    public void setClassesId(String str) {
        this.classesId = str;
    }

    public String getIdenty() {
        return this.identy;
    }

    public void setIdenty(String str) {
        this.identy = str;
    }

    public long getTimeid() {
        return this.Timeid;
    }

    public void setTimeid(long j) {
        this.Timeid = j;
    }

    public long getAttenceId() {
        return this.AttenceId;
    }

    public void setAttenceId(long j) {
        this.AttenceId = j;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getReqTime() {
        return this.reqTime;
    }

    public void setReqTime(String str) {
        this.reqTime = str;
    }
}
