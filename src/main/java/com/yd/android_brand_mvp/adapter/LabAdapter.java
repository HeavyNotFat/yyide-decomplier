package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.AttenceBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LabAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflate;
    int layoutId;
    List<AttenceBean.DataBean.StudentsBean.PeopleBean> nameList;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public LabAdapter(Context context, List<AttenceBean.DataBean.StudentsBean.PeopleBean> list, int i) {
        this.nameList = new ArrayList();
        this.nameList = list;
        this.layoutId = i;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nameList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.nameList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.inflate.inflate(this.layoutId, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
        textView.setTextSize(SizeUtils.px2sp(20.0f));
        textView.setText(this.nameList.get(i).name + "");
        return viewInflate;
    }
}
