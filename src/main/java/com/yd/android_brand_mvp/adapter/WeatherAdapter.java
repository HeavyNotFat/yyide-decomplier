package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.WeatherRsp;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherAdapter extends BaseAdapter {
    List<WeatherRsp.DataBean.WeatherBean> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public WeatherRsp.DataBean.WeatherBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_weather_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.icon);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.weather);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.line);
        imageView.setImageDrawable(WeatherUtils.imgCode_y(view.getContext(), this.list.get(i).type));
        textView.setText(getItem(i).date);
        String str = this.list.get(i).low;
        String temperature = WeatherUtils.getTemperature(this.list.get(i).low);
        String temperature2 = WeatherUtils.getTemperature(this.list.get(i).high);
        textView2.setText(this.list.get(i).type + "  " + temperature + Constants.WAVE_SEPARATOR + temperature2 + "℃");
        textView3.setVisibility(i + 1 == getCount() ? 8 : 0);
        return view;
    }

    public void notifyData(List<WeatherRsp.DataBean.WeatherBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
