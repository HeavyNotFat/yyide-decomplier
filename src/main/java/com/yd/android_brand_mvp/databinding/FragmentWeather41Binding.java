package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentWeather41Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView site;
    public final ImageView tvWeather;
    public final TextView wd;
    public final TextView weathertext;

    private FragmentWeather41Binding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.site = textView;
        this.tvWeather = imageView;
        this.wd = textView2;
        this.weathertext = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWeather41Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWeather41Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_weather_4_1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentWeather41Binding bind(View view) {
        int i = R.id.site;
        TextView textView = (TextView) view.findViewById(R.id.site);
        if (textView != null) {
            i = R.id.tv_weather;
            ImageView imageView = (ImageView) view.findViewById(R.id.tv_weather);
            if (imageView != null) {
                i = R.id.wd;
                TextView textView2 = (TextView) view.findViewById(R.id.wd);
                if (textView2 != null) {
                    i = R.id.weathertext;
                    TextView textView3 = (TextView) view.findViewById(R.id.weathertext);
                    if (textView3 != null) {
                        return new FragmentWeather41Binding((ConstraintLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
