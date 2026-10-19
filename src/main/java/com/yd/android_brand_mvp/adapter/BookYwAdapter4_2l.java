package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwAdapter4_2l extends BaseQuickAdapter<YwBookRsp, BaseViewHolder> {
    public boolean iscl;

    public BookYwAdapter4_2l(int i) {
        super(i);
        this.iscl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, YwBookRsp ywBookRsp) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.booktitle);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.bookname);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.bookname2);
        String strTrim = ywBookRsp.title.replaceAll(" ", "").trim();
        if (strTrim.length() > 7) {
            int length = strTrim.length();
            textView2.setText(strTrim.substring(0, 7));
            textView3.setText(strTrim.substring(7, length));
        } else {
            textView2.setText(ywBookRsp.title);
            textView3.setText("");
        }
        textView.setText(ywBookRsp.title);
        if (this.iscl) {
            textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
        }
        GlideUtil.loadBook(imageView.getContext(), ywBookRsp.photo, imageView);
    }

    public void setcolor(boolean z) {
        this.iscl = z;
    }
}
