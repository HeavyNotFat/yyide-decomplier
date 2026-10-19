package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwActivitySearchAdapter extends BaseQuickAdapter<SearchBookRsp.ListDTO, BaseViewHolder> {
    public BookYwActivitySearchAdapter(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, SearchBookRsp.ListDTO listDTO) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.booktitle);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.bookname);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.bookname2);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.msg2);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.msg3);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.msg4);
        TextView textView7 = (TextView) baseViewHolder.getView(R.id.clik);
        String str = listDTO.title;
        if (str.length() > 7) {
            int length = str.length();
            str.substring(0, 6);
            textView2.setText(str.substring(0, 7));
            textView3.setText(str.substring(7, length));
        } else {
            textView2.setText(listDTO.title);
        }
        textView4.setText("可借" + (listDTO.copyTotal.intValue() - listDTO.copyLent.intValue()));
        textView5.setText(listDTO.author + "编著 | " + listDTO.publisher + " | " + listDTO.pubDate);
        textView6.setText(listDTO.callNos.toString());
        textView.setText(listDTO.title);
        GlideUtil.loadBook(imageView.getContext(), listDTO.photo, imageView);
        textView7.setText(listDTO.copyLent + "");
    }
}
