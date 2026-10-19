package com.yd.android_brand_mvp.landscape.book;

import com.alibaba.fastjson.TypeReference;

/* JADX INFO: loaded from: classes4.dex */
public class GetBookListByKeyReq extends BaseBeanReq<GetBookListByKeyRsp> {
    public int currentPage;
    public String key;
    public String officeId;
    public int showCount = 16;

    @Override // com.yd.android_brand_mvp.landscape.book.BaseBeanReq
    public String myAddr() {
        return "/api/library/getBookListByKey.html";
    }

    @Override // com.yd.android_brand_mvp.landscape.book.BaseBeanReq
    public TypeReference<GetBookListByKeyRsp> myTypeReference() {
        return new TypeReference<GetBookListByKeyRsp>() { // from class: com.yd.android_brand_mvp.landscape.book.GetBookListByKeyReq.1
        };
    }
}
