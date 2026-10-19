package com.yd.android_brand_mvp.landscape.book;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GetBookContentRsp {
    public DataBean data;
    public String info;
    public int status;

    public static class DataBean {
        public BookBean book;

        public static class BookBean {
            public String bookAuthor;
            public String bookFile;
            public String bookImage;
            public String bookIntro;
            public String bookName;
            public String bookState;
            public int bookTotalPage;
            public int bookUploadType;
            public CategoryBean category;
            public List<ChapterListBean> chapterList;
            public Object chapters;
            public Object createBy;
            public String createDate;
            public String delFlag;
            public int id;
            public String isEnd;
            public String isNew;
            public String isRecommended;
            public String isbnIssn;
            public int popularity;
            public String publishingDate;
            public String publishingName;
            public Object recoOrder;
            public Object updateBy;
            public String updateDate;

            public static class CategoryBean {
                public Object bookList;
                public Object createBy;
                public Object createDate;
                public Object delFlag;
                public Object dictImage;
                public int dictOrder;
                public int dictType;
                public Object dictUrl;
                public String dictValue;
                public String id;
                public String parentId;
                public String remarks;
                public Object updateBy;
                public Object updateDate;
            }

            public static class ChapterListBean {
                public Object book;
                public String chapterFile;
                public String chapterName;
                public int chapterOrder;
                public int chapterTotalPage;
                public Object createBy;
                public Object createDate;
                public Object delFlag;
                public Object end;
                public int id;
                public Object remarks;
                public Object start;
                public Object updateBy;
                public Object updateDate;
            }
        }
    }
}
