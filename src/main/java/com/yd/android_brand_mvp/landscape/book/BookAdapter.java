package com.yd.android_brand_mvp.landscape.book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BookAdapter extends BaseAdapter {
    public List<GetBookListByKeyRsp.DataBean.BookListBean> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public GetBookListByKeyRsp.DataBean.BookListBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item, (ViewGroup) null, false);
        }
        GlideUtil.loadImage(view.getContext(), getItem(i).bookImage, (ImageView) view.findViewById(R.id.item));
        return view;
    }

    public void notifyData(List<GetBookListByKeyRsp.DataBean.BookListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
