package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudenCenterAdapter2 extends BaseAdapter {
    List<StudentMsgBean.Data0> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public StudentMsgBean.Data0 getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_student_item, (ViewGroup) null, false);
        }
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.img);
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.name);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.msg);
        textView.setText(getItem(i).name + "");
        if (getItem(i).msgNum > 99) {
            str = "99+";
        } else {
            str = getItem(i).msgNum + "";
        }
        textView2.setText(str);
        textView2.setVisibility(getItem(i).msgNum <= 0 ? 8 : 0);
        GlideUtil.loadCircleImage(view.getContext(), getItem(i).image, imageView);
        return view;
    }

    public void notifyData(List<StudentMsgBean.Data0> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
