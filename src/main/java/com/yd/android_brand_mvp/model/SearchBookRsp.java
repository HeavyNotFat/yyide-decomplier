package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SearchBookRsp {
    public List<ListDTO> list;
    public String sid;
    public Integer total;

    public static class ListDTO {
        public String author;
        public List<String> callNos;
        public String clc;
        public Integer clickCount;
        public Integer copyLent;
        public Integer copyTotal;
        public Integer copyUnlendable;
        public String ctrlNo;
        public String photo;
        public String pubDate;
        public String publisher;
        public String title;
    }
}
