package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.NewWeatherItemBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherAdapter2 extends BaseAdapter {
    List<NewWeatherItemBean> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list.size() >= 5) {
            return 5;
        }
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public NewWeatherItemBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_weather_item2, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.day);
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.icon);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.weather);
        imageView.setImageDrawable(WeatherUtils.imgCode_y(view.getContext(), this.list.get(i).getWeather()));
        if (i == TimeUtil.getIntWeekDay(System.currentTimeMillis()) - 1) {
            textView.setText("今天");
        } else {
            textView.setText(getItem(i).getDate());
        }
        textView2.setText(WeatherUtils.getTemperature(this.list.get(i).getLowest()) + "℃~" + WeatherUtils.getTemperature(this.list.get(i).getHighest()) + "℃");
        return view;
    }

    public void notifyData(List<NewWeatherItemBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
