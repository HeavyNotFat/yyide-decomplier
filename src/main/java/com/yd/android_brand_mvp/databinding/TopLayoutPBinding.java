package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class TopLayoutPBinding implements ViewBinding {
    public final LinearLayout calendarLayout;
    public final ImageView ivBlank;
    public final ImageView ivTiming;
    public final ImageView logo;
    public final TextView officename;
    private final FrameLayout rootView;
    public final TextView tvText;
    public final TextView wd;
    public final ImageView weathericon;
    public final LinearLayout weatherlayout;
    public final TextView weathertext;
    public final ImageView wifi;

    private TopLayoutPBinding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, ImageView imageView4, LinearLayout linearLayout2, TextView textView4, ImageView imageView5) {
        this.rootView = frameLayout;
        this.calendarLayout = linearLayout;
        this.ivBlank = imageView;
        this.ivTiming = imageView2;
        this.logo = imageView3;
        this.officename = textView;
        this.tvText = textView2;
        this.wd = textView3;
        this.weathericon = imageView4;
        this.weatherlayout = linearLayout2;
        this.weathertext = textView4;
        this.wifi = imageView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TopLayoutPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TopLayoutPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.top_layout_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TopLayoutPBinding bind(View view) {
        int i = R.id.calendar_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.calendar_layout);
        if (linearLayout != null) {
            i = R.id.ivBlank;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivBlank);
            if (imageView != null) {
                i = R.id.ivTiming;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.ivTiming);
                if (imageView2 != null) {
                    i = R.id.logo;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.logo);
                    if (imageView3 != null) {
                        i = R.id.officename;
                        TextView textView = (TextView) view.findViewById(R.id.officename);
                        if (textView != null) {
                            i = R.id.tv_text;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_text);
                            if (textView2 != null) {
                                i = R.id.wd;
                                TextView textView3 = (TextView) view.findViewById(R.id.wd);
                                if (textView3 != null) {
                                    i = R.id.weathericon;
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.weathericon);
                                    if (imageView4 != null) {
                                        i = R.id.weatherlayout;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.weatherlayout);
                                        if (linearLayout2 != null) {
                                            i = R.id.weathertext;
                                            TextView textView4 = (TextView) view.findViewById(R.id.weathertext);
                                            if (textView4 != null) {
                                                i = R.id.wifi;
                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.wifi);
                                                if (imageView5 != null) {
                                                    return new TopLayoutPBinding((FrameLayout) view, linearLayout, imageView, imageView2, imageView3, textView, textView2, textView3, imageView4, linearLayout2, textView4, imageView5);
                                                }
                                            }
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
