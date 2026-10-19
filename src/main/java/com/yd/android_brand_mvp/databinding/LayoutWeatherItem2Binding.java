package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutWeatherItem2Binding implements ViewBinding {
    public final TextView day;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView time;
    public final TextView weather;

    private LayoutWeatherItem2Binding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.day = textView;
        this.icon = imageView;
        this.time = textView2;
        this.weather = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWeatherItem2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWeatherItem2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_weather_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutWeatherItem2Binding bind(View view) {
        int i = R.id.day;
        TextView textView = (TextView) view.findViewById(R.id.day);
        if (textView != null) {
            i = R.id.icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.icon);
            if (imageView != null) {
                i = R.id.time;
                TextView textView2 = (TextView) view.findViewById(R.id.time);
                if (textView2 != null) {
                    i = R.id.weather;
                    TextView textView3 = (TextView) view.findViewById(R.id.weather);
                    if (textView3 != null) {
                        return new LayoutWeatherItem2Binding((LinearLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
