package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMinNullLayout222Binding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvNull;

    private ItemMinNullLayout222Binding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvNull = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemMinNullLayout222Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMinNullLayout222Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_min_null_layout_2_2_2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMinNullLayout222Binding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_null);
        if (textView != null) {
            return new ItemMinNullLayout222Binding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_null)));
    }
}
