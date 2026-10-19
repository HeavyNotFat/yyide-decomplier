package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwActivityhotAdapter extends BaseQuickAdapter<YwBookRsp, BaseViewHolder> {
    public BookYwActivityhotAdapter(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, YwBookRsp ywBookRsp) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.booktitle);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.msg2);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.msg3);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.msg4);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.clik);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.bookname);
        TextView textView7 = (TextView) baseViewHolder.getView(R.id.bookname2);
        String str = ywBookRsp.title;
        if (str.length() > 8) {
            int length = str.length();
            textView6.setText(str.substring(0, 8));
            textView7.setText(str.substring(8, length));
        } else {
            textView6.setText(ywBookRsp.title);
            textView7.setText("");
        }
        int iIntValue = ywBookRsp.copyTotal.intValue() - ywBookRsp.copyLent.intValue();
        textView.setText(ywBookRsp.title);
        GlideUtil.loadBook(imageView.getContext(), ywBookRsp.photo, imageView);
        textView2.setText("可借" + iIntValue);
        textView3.setText(ywBookRsp.author + "编著 | " + ywBookRsp.publisher + " | " + ywBookRsp.pubDate);
        textView4.setText(ywBookRsp.callNos.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(ywBookRsp.copyLent);
        sb.append("");
        textView5.setText(sb.toString());
    }
}
