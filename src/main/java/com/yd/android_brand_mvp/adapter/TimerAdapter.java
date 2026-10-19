package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TimerAdapter extends BaseAdapter {
    Context context;
    int layoutId;
    public List<TimelistRsp.DataBean> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public TimerAdapter(Context context, int i) {
        this.context = context;
        this.layoutId = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TimelistRsp.DataBean> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public TimelistRsp.DataBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(this.layoutId, (ViewGroup) null);
        TextView textView = (TextView) VHUtil.ViewHolder.get(viewInflate, R.id.tv_content);
        FrameLayout frameLayout = (FrameLayout) VHUtil.ViewHolder.get(viewInflate, R.id.fl_bg);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(viewInflate, R.id.tv_num);
        textView.setText("距离" + this.list.get(i).activityTheme);
        textView2.setText(this.list.get(i).countDown + "");
        if ("1".equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg);
        } else if ("2".equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg2);
        } else if ("3".equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg3);
        } else if ("4".equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg4);
        } else if (ConversionUtil.conditionWithSeriesName.equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg5);
        } else if (ConversionUtil.conditionWithCallNumber.equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg6);
        } else if (ConversionUtil.conditionWithBookType.equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg7);
        } else if (ConversionUtil.conditionWithPublishStartYear.equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg8);
        } else if (ConversionUtil.conditionWithPublishEndYear.equals(this.list.get(i).templateUrl)) {
            frameLayout.setBackgroundResource(R.drawable.icon_timer_item_bg9);
        }
        return viewInflate;
    }

    public void notifyData(List<TimelistRsp.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
