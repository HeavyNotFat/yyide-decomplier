package com.yd.android_brand_mvp.landscape.book;

import com.alibaba.fastjson.TypeReference;

/* JADX INFO: loaded from: classes4.dex */
public class GetBookContentReq extends BaseBeanReq<GetBookContentRsp> {
    public int id;

    @Override // com.yd.android_brand_mvp.landscape.book.BaseBeanReq
    public String myAddr() {
        return "/api/library/getBookContent.html";
    }

    @Override // com.yd.android_brand_mvp.landscape.book.BaseBeanReq
    public TypeReference<GetBookContentRsp> myTypeReference() {
        return new TypeReference<GetBookContentRsp>() { // from class: com.yd.android_brand_mvp.landscape.book.GetBookContentReq.1
        };
    }
}
