package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ddd {
    public List<DataDTO> data;
    public Integer pageNumber;
    public Integer pageSize;
    public Boolean success;
    public Integer totalElements;
    public Integer totalPages;

    public static class DataDTO {
        public String branch_code;
        public String branch_name;
        public String business_type;
        public String business_unit;
        public String cast_type;
        public String check_flag;
        public String dist_code;
        public String fence_type;
        public String fence_unit;
        public Integer fid;
        public GeomDTO geom;
        public Integer gis_id;
        public String gmt_modified;
        public String rgb;
        public String section_code;
        public String section_name;
        public String task_type;

        public static class GeomDTO {
            public List<List<List<List<Double>>>> coordinates;
            public String type;
        }
    }
}
