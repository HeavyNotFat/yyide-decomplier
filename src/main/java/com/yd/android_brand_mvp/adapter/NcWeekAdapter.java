package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.MonthBean;
import com.yd.android_brand_mvp.model.NcMsgALLBean;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class NcWeekAdapter extends BaseAdapter {
    public List<String> list = new ArrayList();
    public List<NcMsgALLBean> listindex = new ArrayList();
    public List<MonthBean> listnc = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nc_week_item, (ViewGroup) null);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.week);
        if (!TextUtils.isEmpty(this.list.get(i))) {
            textView.setText(Integer.parseInt(TimeUtil.stampToDate12(TimeUtil.gettime10(this.list.get(i)))) + "");
            String week2 = TimeUtil.getWeek2(TimeUtil.gettime10(this.list.get(i)));
            if (week2.equals(ConversionUtil.conditionWithCallNumber) || week2.equals(ConversionUtil.conditionWithBookType)) {
                textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.nc_r));
            } else {
                textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.nc_b));
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.listnc.size(); i3++) {
                if (this.list.get(i).contains(this.listnc.get(i3).Month)) {
                    i2 = i3;
                }
            }
            if (i2 % 2 == 0) {
                textView.setBackground(view.getContext().getResources().getDrawable(R.drawable.bg_ac_nc_item));
            } else {
                textView.setBackground(view.getContext().getResources().getDrawable(R.drawable.bg_ac_nc_item2));
            }
        }
        if (TextUtils.isEmpty(this.list.get(i))) {
            textView.setText("");
        }
        for (NcMsgALLBean ncMsgALLBean : this.listindex) {
            if (!TextUtils.isEmpty(ncMsgALLBean.startTime) && ncMsgALLBean.startTime.equals(getItem(i))) {
                textView.setBackground(view.getContext().getResources().getDrawable(R.drawable.bg_ac_nc_item3));
                if (SpData.isNight()) {
                    textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.N_white));
                }
            }
        }
        return view;
    }

    public void notyfaData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setindex(List<NcMsgALLBean> list) {
        this.listindex = list;
        notifyDataSetChanged();
    }

    public void setNc(List<MonthBean> list) {
        this.listnc = list;
        notifyDataSetChanged();
    }
}
