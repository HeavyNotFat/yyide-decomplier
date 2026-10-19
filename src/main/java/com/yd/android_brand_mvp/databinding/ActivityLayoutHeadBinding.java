package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityLayoutHeadBinding implements ViewBinding {
    public final LinearLayout calendarLayout;
    public final ImageView logo;
    public final TextView officename;
    private final LinearLayout rootView;
    public final ImageView weathericon;
    public final LinearLayout weatherlayout;
    public final TextView weathertext;
    public final CheckedTextView wifi;

    private ActivityLayoutHeadBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView, ImageView imageView2, LinearLayout linearLayout3, TextView textView2, CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.calendarLayout = linearLayout2;
        this.logo = imageView;
        this.officename = textView;
        this.weathericon = imageView2;
        this.weatherlayout = linearLayout3;
        this.weathertext = textView2;
        this.wifi = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLayoutHeadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLayoutHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_layout_head, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLayoutHeadBinding bind(View view) {
        int i = R.id.calendar_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.calendar_layout);
        if (linearLayout != null) {
            i = R.id.logo;
            ImageView imageView = (ImageView) view.findViewById(R.id.logo);
            if (imageView != null) {
                i = R.id.officename;
                TextView textView = (TextView) view.findViewById(R.id.officename);
                if (textView != null) {
                    i = R.id.weathericon;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.weathericon);
                    if (imageView2 != null) {
                        i = R.id.weatherlayout;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.weatherlayout);
                        if (linearLayout2 != null) {
                            i = R.id.weathertext;
                            TextView textView2 = (TextView) view.findViewById(R.id.weathertext);
                            if (textView2 != null) {
                                i = R.id.wifi;
                                CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.wifi);
                                if (checkedTextView != null) {
                                    return new ActivityLayoutHeadBinding((LinearLayout) view, linearLayout, imageView, textView, imageView2, linearLayout2, textView2, checkedTextView);
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
