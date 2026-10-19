package com.yd.android_brand_mvp.landscape.book;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GetBookListByKeyRsp {
    public DataBean data;
    public String info;
    public int status;

    public static class DataBean {
        public List<BookListBean> bookList;

        public static class BookListBean {
            public String bookImage;
            public String bookName;
            public int id;
        }
    }
}
