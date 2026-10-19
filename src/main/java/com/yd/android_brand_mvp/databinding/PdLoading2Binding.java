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
public final class PdLoading2Binding implements ViewBinding {
    public final ImageView img;
    private final LinearLayout rootView;
    public final TextView text;

    private PdLoading2Binding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PdLoading2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PdLoading2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.pd_loading2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PdLoading2Binding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        if (imageView != null) {
            i = R.id.text;
            TextView textView = (TextView) view.findViewById(R.id.text);
            if (textView != null) {
                return new PdLoading2Binding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
