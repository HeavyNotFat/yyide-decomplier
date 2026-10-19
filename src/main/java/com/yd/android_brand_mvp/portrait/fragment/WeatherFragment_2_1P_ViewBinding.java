package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherFragment_2_1P_ViewBinding implements Unbinder {
    private WeatherFragment_2_1P target;

    public WeatherFragment_2_1P_ViewBinding(WeatherFragment_2_1P weatherFragment_2_1P, View view) {
        this.target = weatherFragment_2_1P;
        weatherFragment_2_1P.wd = (TextView) Utils.findRequiredViewAsType(view, R.id.wd, "field 'wd'", TextView.class);
        weatherFragment_2_1P.weathertext = (TextView) Utils.findRequiredViewAsType(view, R.id.weathertext, "field 'weathertext'", TextView.class);
        weatherFragment_2_1P.site = (TextView) Utils.findRequiredViewAsType(view, R.id.site, "field 'site'", TextView.class);
        weatherFragment_2_1P.tvWeather = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_weather, "field 'tvWeather'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WeatherFragment_2_1P weatherFragment_2_1P = this.target;
        if (weatherFragment_2_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        weatherFragment_2_1P.wd = null;
        weatherFragment_2_1P.weathertext = null;
        weatherFragment_2_1P.site = null;
        weatherFragment_2_1P.tvWeather = null;
    }
}
