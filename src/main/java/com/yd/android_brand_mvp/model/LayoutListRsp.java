package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutListRsp {
    public int code;
    public List<DataBean> data;
    public String msg;

    public static class DataBean {
        public String id;
        public List<LayoutClassSignDetailsEntityListBean> layoutClassSignDetailsEntityList;
        public String pagination;

        public static class LayoutClassSignDetailsEntityListBean implements Serializable {
            public String backgropColour;
            public String backgropPhoto;
            public String borderColor;
            public Object createdBy;
            public String createdDateTime;
            public int current;
            public String delInd;
            public String descriptive;
            public int height;
            public String id;
            public String images;
            public List<String> imagesList;
            public String imgType;
            public String jsonParam;
            public List<LayoutClassSignDetailsEntityListBean> layoutClassSignDetailsEntityList;
            public Object layoutId;
            public String moduleId;
            public String moduleName;
            public int secPageBackTime;
            public Boolean showModuleName = true;
            public int size;
            public StreamDetails streamDetails;
            public String tag;
            public int total;
            public Object updatedBy;
            public String updatedDateTime;
            public String url;
            public int versionStamp;
            public int width;
            public int x;
            public int y;
        }
    }

    public static class StreamDetails {
        public String brandId;
        public int nums;
        public List<StreamUrlsDTO> streamUrls;

        public static class StreamUrlsDTO {
            public String url;
        }
    }
}
