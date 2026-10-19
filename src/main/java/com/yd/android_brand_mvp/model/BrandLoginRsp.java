package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BrandLoginRsp {
    public Integer code;
    public DataDTO data;
    public String msg;

    public static class DataDTO {
        public SignDTO sign;
        public List<SiteDTO> site;
        public List<VerifyDTO> verify;

        public static class SignDTO {
            public Object buildingId;
            public long classesId;
            public Object classesSignSwitchEntitys;
            public String createdBy;
            public String createdDateTime;
            public Integer current;
            public Object dataPermission;
            public String delInd;
            public Object equipmentNo;
            public long id;
            public String isMessage;
            public Object isOnLine;
            public String isSecond;
            public Object layoutClassSignDetailsEntitieList;
            public Object layoutClassSignDetailsEntities;
            public String loginName;
            public Object name;
            public Object page;
            public String password;
            public Object registrationCode;
            public Object remarks;
            public Object saveList;
            public Object schoolId;
            public String signName;
            public String siteId;
            public Object siteList;
            public Object siteSet;
            public Integer size;
            public String status;
            public String sysId;
            public Integer total;
            public Object updatedBy;
            public Object updatedDateTime;
            public Object versionStamp;
        }

        public static class SiteDTO {
            public Object area;
            public long buildingId;
            public String buildingName;
            public Object buildingNme;
            public long classesId;
            public String classesName;
            public Object classesSignId;
            public Object delInd;
            public Object floor;
            public Object gradeName;
            public long gradesId;
            public long id;
            public Object ids;
            public String name;
            public Object peppleNumber;
            public String roomNumber;
            public long schoolId;
            public Object schoolType;
            public List<?> siteManagers;
            public Object siteManagersStr;
            public String siteTypeId;
            public String siteTypeName;
        }

        public static class VerifyDTO {
            public String id;
            public String name;
        }
    }
}
