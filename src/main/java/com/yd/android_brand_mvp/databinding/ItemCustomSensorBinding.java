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
public final class ItemCustomSensorBinding implements ViewBinding {
    public final ImageView ivItemCustomIcon;
    private final ConstraintLayout rootView;
    public final TextView tvItemCustomTemperature;
    public final TextView tvItemCustomTemperatureName;

    private ItemCustomSensorBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivItemCustomIcon = imageView;
        this.tvItemCustomTemperature = textView;
        this.tvItemCustomTemperatureName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCustomSensorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCustomSensorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_custom_sensor, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCustomSensorBinding bind(View view) {
        int i = R.id.iv_item_custom_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_custom_icon);
        if (imageView != null) {
            i = R.id.tv_item_custom_temperature;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_custom_temperature);
            if (textView != null) {
                i = R.id.tv_item_custom_temperature_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_custom_temperature_name);
                if (textView2 != null) {
                    return new ItemCustomSensorBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
