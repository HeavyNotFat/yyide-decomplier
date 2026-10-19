package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewKbLeftAdapter extends BaseAdapter {
    public List<String> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_section, (ViewGroup) null, false);
        }
        ((TextView) view.findViewById(R.id.tv_name)).setText(this.list.get(i));
        return view;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
