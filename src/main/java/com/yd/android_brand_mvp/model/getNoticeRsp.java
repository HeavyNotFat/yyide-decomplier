package com.yd.android_brand_mvp.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yd.android_brand_mvp.model.message.DocumentBean;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class getNoticeRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public List<RecordsDTO> list;
        public int pageNo;
        public int pageSize;
        public int total;

        public static class RecordsDTO implements MultiItemEntity {
            public List<DocumentBean> attachments;
            public String author;
            public String content;
            public String contentImg;
            public int contentType;
            public String coverImg;
            public List<detailsBean> details;
            public String id;
            public String identityUserName;
            public String messJson;
            public int messType;
            public String source;
            public String timerDate;
            public String title;
            public int type;

            @Override // com.chad.library.adapter.base.entity.MultiItemEntity
            public int getItemType() {
                int i = this.messType;
                return (i == 2 || i == 5) ? 2 : 1;
            }

            public class detailsBean {
                public String coverImg;
                public String height;
                public String id;
                public String width;

                public detailsBean() {
                }
            }
        }
    }
}
