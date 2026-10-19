package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class RegisterDeviceRsp {
    private int code;
    private DataBean data;
    private String msg;
    private boolean success;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public static class DataBean {
        private int buildingId;
        private String createdBy;
        private String createdDateTime;
        private int current;
        private String delInd;
        private int equipmentTypeId;
        private int id;
        private String name;

        /* JADX INFO: renamed from: no, reason: collision with root package name */
        private String f2017no;
        private int schoolId;
        private int siteId;
        private int size;
        private String status;
        private int total;
        private String updatedDateTime;
        private int versionStamp;

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public String getDelInd() {
            return this.delInd;
        }

        public void setDelInd(String str) {
            this.delInd = str;
        }

        public String getCreatedBy() {
            return this.createdBy;
        }

        public void setCreatedBy(String str) {
            this.createdBy = str;
        }

        public String getCreatedDateTime() {
            return this.createdDateTime;
        }

        public void setCreatedDateTime(String str) {
            this.createdDateTime = str;
        }

        public String getUpdatedDateTime() {
            return this.updatedDateTime;
        }

        public void setUpdatedDateTime(String str) {
            this.updatedDateTime = str;
        }

        public int getVersionStamp() {
            return this.versionStamp;
        }

        public void setVersionStamp(int i) {
            this.versionStamp = i;
        }

        public int getTotal() {
            return this.total;
        }

        public void setTotal(int i) {
            this.total = i;
        }

        public int getSize() {
            return this.size;
        }

        public void setSize(int i) {
            this.size = i;
        }

        public int getCurrent() {
            return this.current;
        }

        public void setCurrent(int i) {
            this.current = i;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getNo() {
            return this.f2017no;
        }

        public void setNo(String str) {
            this.f2017no = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public int getBuildingId() {
            return this.buildingId;
        }

        public void setBuildingId(int i) {
            this.buildingId = i;
        }

        public int getSiteId() {
            return this.siteId;
        }

        public void setSiteId(int i) {
            this.siteId = i;
        }

        public int getSchoolId() {
            return this.schoolId;
        }

        public void setSchoolId(int i) {
            this.schoolId = i;
        }

        public int getEquipmentTypeId() {
            return this.equipmentTypeId;
        }

        public void setEquipmentTypeId(int i) {
            this.equipmentTypeId = i;
        }
    }

    public String toString() {
        return "RegisterDeviceRsp{code=" + this.code + ", success=" + this.success + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
