package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumTabBean {
    public int code;
    public List<DataBean> data;
    public String message;

    public static class DataBean {
        public List<?> albumDTOList;
        public int classesId;
        public String createdBy;
        public long createdDateTime;
        public int current;
        public String delInd;
        public int id;
        public String kind;
        public String name;
        public int schoolId;
        public String show;
        public int size;
        public int total;
        public String updatedBy;
        public long updatedDateTime;
        public int versionStamp;
    }
}
