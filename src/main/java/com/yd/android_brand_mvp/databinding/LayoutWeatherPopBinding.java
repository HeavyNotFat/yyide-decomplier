package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutWeatherPopBinding implements ViewBinding {
    public final ImageView icon;
    public final ImageView img;
    public final FrameLayout layout;
    public final FrameLayout layoutBg;
    public final TextView line;
    public final ListView list;
    private final FrameLayout rootView;
    public final TextView text;
    public final TextView time;
    public final TextView weather;

    private LayoutWeatherPopBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView, ListView listView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.icon = imageView;
        this.img = imageView2;
        this.layout = frameLayout2;
        this.layoutBg = frameLayout3;
        this.line = textView;
        this.list = listView;
        this.text = textView2;
        this.time = textView3;
        this.weather = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWeatherPopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWeatherPopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_weather_pop, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutWeatherPopBinding bind(View view) {
        int i = R.id.icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        if (imageView != null) {
            i = R.id.img;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img);
            if (imageView2 != null) {
                i = R.id.layout;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout);
                if (frameLayout != null) {
                    i = R.id.layout_bg;
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.layout_bg);
                    if (frameLayout2 != null) {
                        i = R.id.line;
                        TextView textView = (TextView) view.findViewById(R.id.line);
                        if (textView != null) {
                            i = R.id.list;
                            ListView listView = (ListView) view.findViewById(R.id.list);
                            if (listView != null) {
                                i = R.id.text;
                                TextView textView2 = (TextView) view.findViewById(R.id.text);
                                if (textView2 != null) {
                                    i = R.id.time;
                                    TextView textView3 = (TextView) view.findViewById(R.id.time);
                                    if (textView3 != null) {
                                        i = R.id.weather;
                                        TextView textView4 = (TextView) view.findViewById(R.id.weather);
                                        if (textView4 != null) {
                                            return new LayoutWeatherPopBinding((FrameLayout) view, imageView, imageView2, frameLayout, frameLayout2, textView, listView, textView2, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
