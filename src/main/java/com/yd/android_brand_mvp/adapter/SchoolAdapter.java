package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.SchoolInfoBean;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolAdapter extends BaseAdapter {
    List<SchoolInfoBean> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public SchoolInfoBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_school_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.item);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.type);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.name);
        textView.setText(getItem(i).num + "");
        textView2.setText(getItem(i).type);
        textView3.setText(getItem(i).name);
        return view;
    }

    public void notifyData(List<SchoolInfoBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
