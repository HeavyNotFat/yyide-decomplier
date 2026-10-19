package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NcMsgAdapter extends BaseAdapter {
    int index = -1;
    public List<selectSchoolCalendarRsp.DataDTO> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public selectSchoolCalendarRsp.DataDTO getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nc_msg_layout, (ViewGroup) null);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.name);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        if (TextUtils.isEmpty(getItem(i).startTime)) {
            textView2.setText("");
        } else if (getItem(i).startTime.equals(getItem(i).endTime)) {
            textView2.setText(getItem(i).startTime);
        } else {
            textView2.setText(getItem(i).startTime + " - " + (getItem(i).endTime + ""));
        }
        textView.setText(getItem(i).remark);
        return view;
    }

    public void setPosition(int i) {
        this.index = i;
        notifyDataSetChanged();
    }

    public int getPosition() {
        return this.index;
    }

    public void notfydata(List<selectSchoolCalendarRsp.DataDTO> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
