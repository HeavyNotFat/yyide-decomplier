package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.getClassBrandRsp;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SchooldataAdapter extends BaseAdapter {
    Context context;
    public List<getClassBrandRsp.DataDTO> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public getClassBrandRsp.DataDTO getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.school_data, (ViewGroup) null, false);
        }
        ((TextView) VHUtil.ViewHolder.get(view, R.id.name)).setText(getItem(i).signName);
        return view;
    }

    public void notifyData(List<getClassBrandRsp.DataDTO> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
