package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class sss {
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
        private int current;
        private int pages;
        private List<RecordsBean> records;
        private boolean searchCount;
        private int size;
        private int total;

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

        public boolean isSearchCount() {
            return this.searchCount;
        }

        public void setSearchCount(boolean z) {
            this.searchCount = z;
        }

        public int getPages() {
            return this.pages;
        }

        public void setPages(int i) {
            this.pages = i;
        }

        public List<RecordsBean> getRecords() {
            return this.records;
        }

        public void setRecords(List<RecordsBean> list) {
            this.records = list;
        }

        public static class RecordsBean {
            private Object applicationType;
            private String delInd;
            private int id;
            private List<ListBean> list;
            private String name;
            private Object owner;
            private Object schoolId;
            private Object type;

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

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public Object getSchoolId() {
                return this.schoolId;
            }

            public void setSchoolId(Object obj) {
                this.schoolId = obj;
            }

            public Object getType() {
                return this.type;
            }

            public void setType(Object obj) {
                this.type = obj;
            }

            public Object getApplicationType() {
                return this.applicationType;
            }

            public void setApplicationType(Object obj) {
                this.applicationType = obj;
            }

            public Object getOwner() {
                return this.owner;
            }

            public void setOwner(Object obj) {
                this.owner = obj;
            }

            public List<ListBean> getList() {
                return this.list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private Object applicationId;
                private Object createdBy;
                private String createdDateTime;
                private int current;
                private String delInd;
                private Object groupId;
                private int id;
                private String img;
                private Object isAdd;
                private String name;
                private Object num;
                private Object owner;
                private String path;
                private Object schoolApplicationGroupId;
                private Object schoolId;
                private int size;
                private Object sort;
                private int total;
                private Object type;
                private Object updatedBy;
                private String updatedDateTime;
                private Object userId;
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

                public Object getCreatedBy() {
                    return this.createdBy;
                }

                public void setCreatedBy(Object obj) {
                    this.createdBy = obj;
                }

                public String getCreatedDateTime() {
                    return this.createdDateTime;
                }

                public void setCreatedDateTime(String str) {
                    this.createdDateTime = str;
                }

                public Object getUpdatedBy() {
                    return this.updatedBy;
                }

                public void setUpdatedBy(Object obj) {
                    this.updatedBy = obj;
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

                public Object getApplicationId() {
                    return this.applicationId;
                }

                public void setApplicationId(Object obj) {
                    this.applicationId = obj;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public Object getGroupId() {
                    return this.groupId;
                }

                public void setGroupId(Object obj) {
                    this.groupId = obj;
                }

                public Object getSchoolId() {
                    return this.schoolId;
                }

                public void setSchoolId(Object obj) {
                    this.schoolId = obj;
                }

                public Object getSchoolApplicationGroupId() {
                    return this.schoolApplicationGroupId;
                }

                public void setSchoolApplicationGroupId(Object obj) {
                    this.schoolApplicationGroupId = obj;
                }

                public Object getSort() {
                    return this.sort;
                }

                public void setSort(Object obj) {
                    this.sort = obj;
                }

                public Object getType() {
                    return this.type;
                }

                public void setType(Object obj) {
                    this.type = obj;
                }

                public String getImg() {
                    return this.img;
                }

                public void setImg(String str) {
                    this.img = str;
                }

                public String getPath() {
                    return this.path;
                }

                public void setPath(String str) {
                    this.path = str;
                }

                public Object getOwner() {
                    return this.owner;
                }

                public void setOwner(Object obj) {
                    this.owner = obj;
                }

                public Object getNum() {
                    return this.num;
                }

                public void setNum(Object obj) {
                    this.num = obj;
                }

                public Object getUserId() {
                    return this.userId;
                }

                public void setUserId(Object obj) {
                    this.userId = obj;
                }

                public Object getIsAdd() {
                    return this.isAdd;
                }

                public void setIsAdd(Object obj) {
                    this.isAdd = obj;
                }
            }
        }
    }
}
