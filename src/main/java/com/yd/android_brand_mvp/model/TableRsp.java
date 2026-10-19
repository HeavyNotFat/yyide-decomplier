package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TableRsp implements Serializable {
    public String courseType;
    public String endTime;
    public int flag;
    public String id;
    public boolean isHighlighted;
    public String kbIndex;
    public String location;
    public int mark;
    public String otherClassesTeacher;
    public String otherSubjectName;
    public String sectionName;
    public int seletion;
    public String sex;
    public String slot;
    public String startTime;
    public String subjectsName;
    public String teacherName;
    public String teacherPhoto;
    public String timeFrame;
    public int type;
    public int week;
    public int weekCount;
    public boolean isselect = false;
    public List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> teacherList = new ArrayList();

    public static class TeacherListDTO {
        public String id;
        public String name;
    }
}
