package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.VHUtil;

/* JADX INFO: loaded from: classes4.dex */
public class TopWeekAdapter extends BaseAdapter {
    String[] listweek = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.listweek.length;
    }

    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.listweek[i];
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nc_week_item_gray, (ViewGroup) null);
        }
        ((TextView) VHUtil.ViewHolder.get(view, R.id.week)).setText(this.listweek[i]);
        return view;
    }
}
