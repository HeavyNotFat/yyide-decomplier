package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class saveFaceLogRsp {
    private Integer code;
    private DataDTO data;
    private String msg;
    private Boolean success;

    public static class DataDTO {
        private Integer comparisonScore;
        private String createdBy;
        private String createdDateTime;
        private Integer current;
        private long id;
        private String name;

        /* JADX INFO: renamed from: no, reason: collision with root package name */
        private String f2020no;
        private String path;
        private long peopleId;
        private long schoolId;
        private Integer size;
        private String templatePath;
        private Integer total;
    }
}
