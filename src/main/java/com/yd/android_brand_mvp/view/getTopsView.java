package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface getTopsView extends BaseView {
    void getBookassetsFail(String str);

    void getBookassetsSuccess(List<BookassetsRsp> list);

    void getTopsFail(String str);

    void getTopsSuccess(List<YwBookRsp> list);

    void getctrlNoFail(String str);

    void getctrlNoSuccess(ctrlNoRsp ctrlnorsp);

    void searchBookFail(String str);

    void searchBookSuccess(SearchBookRsp searchBookRsp);
}
