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
public final class ItemYyLayoutBinding implements ViewBinding {
    public final ImageView img;
    public final LinearLayout layoutContent;
    public final TextView name;
    private final LinearLayout rootView;
    public final TextView time;

    private ItemYyLayoutBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.layoutContent = linearLayout2;
        this.name = textView;
        this.time = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemYyLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemYyLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_yy_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemYyLayoutBinding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.name;
            TextView textView = (TextView) view.findViewById(R.id.name);
            if (textView != null) {
                i = R.id.time;
                TextView textView2 = (TextView) view.findViewById(R.id.time);
                if (textView2 != null) {
                    return new ItemYyLayoutBinding(linearLayout, imageView, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
