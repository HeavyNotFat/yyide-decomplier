package com.yd.android_brand_mvp.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.BookassetsRsp;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwAssetsAdatper extends BaseQuickAdapter<BookassetsRsp, BaseViewHolder> {
    public BookYwAssetsAdatper(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, BookassetsRsp bookassetsRsp) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.adress);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.no);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.dl);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.stuas);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.lx);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.jg);
        textView.setText(bookassetsRsp.libId + "");
        textView2.setText(bookassetsRsp.callNo + "");
        textView3.setText(bookassetsRsp.assetNo + "");
        if (!bookassetsRsp.status.equals("lendOut") && bookassetsRsp.lendable.booleanValue() && bookassetsRsp.status.equals("collIn")) {
            textView4.setText("可借");
        } else {
            textView4.setText("不可借");
        }
        textView5.setText(bookassetsRsp.bookTypeName);
        textView6.setText(bookassetsRsp.price + "");
    }
}
