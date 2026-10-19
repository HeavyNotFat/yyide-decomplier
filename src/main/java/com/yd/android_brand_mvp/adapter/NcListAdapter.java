package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class NcListAdapter extends BaseAdapter {
    public String time;

    @Override // android.widget.Adapter
    public int getCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public String getItem(int i) {
        return "";
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nc_list_layout, (ViewGroup) null);
        }
        return view;
    }
}
