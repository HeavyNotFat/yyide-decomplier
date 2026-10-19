package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.NcMsgALLBean;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NcMsgALLAdapter extends BaseAdapter {
    List<NcMsgALLBean> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public NcMsgALLBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nc_list_msg_all_item, (ViewGroup) null);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.item);
        if (!TextUtils.isEmpty(getItem(i).startTime)) {
            textView.setText(getItem(i).startTime + "   " + getItem(i).remark);
        } else {
            textView.setText(getItem(i).remark);
        }
        return view;
    }

    public void notydata(List<NcMsgALLBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
