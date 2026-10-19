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
public final class LayoutWeatherItemBinding implements ViewBinding {
    public final ImageView icon;
    public final TextView line;
    private final LinearLayout rootView;
    public final TextView time;
    public final TextView weather;

    private LayoutWeatherItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.icon = imageView;
        this.line = textView;
        this.time = textView2;
        this.weather = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWeatherItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWeatherItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_weather_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutWeatherItemBinding bind(View view) {
        int i = R.id.icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        if (imageView != null) {
            i = R.id.line;
            TextView textView = (TextView) view.findViewById(R.id.line);
            if (textView != null) {
                i = R.id.time;
                TextView textView2 = (TextView) view.findViewById(R.id.time);
                if (textView2 != null) {
                    i = R.id.weather;
                    TextView textView3 = (TextView) view.findViewById(R.id.weather);
                    if (textView3 != null) {
                        return new LayoutWeatherItemBinding((LinearLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
