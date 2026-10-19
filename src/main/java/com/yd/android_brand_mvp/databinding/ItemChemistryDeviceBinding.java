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
public final class ItemChemistryDeviceBinding implements ViewBinding {
    public final ImageView ivItemChemistryDevice;
    private final ConstraintLayout rootView;
    public final TextView tvItemChemistryDeviceSubTitle;
    public final TextView tvItemChemistryDeviceTitle;

    private ItemChemistryDeviceBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivItemChemistryDevice = imageView;
        this.tvItemChemistryDeviceSubTitle = textView;
        this.tvItemChemistryDeviceTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemChemistryDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChemistryDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chemistry_device, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemChemistryDeviceBinding bind(View view) {
        int i = R.id.iv_item_chemistry_device;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_chemistry_device);
        if (imageView != null) {
            i = R.id.tv_item_chemistry_device_subTitle;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_chemistry_device_subTitle);
            if (textView != null) {
                i = R.id.tv_item_chemistry_device_title;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_chemistry_device_title);
                if (textView2 != null) {
                    return new ItemChemistryDeviceBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
