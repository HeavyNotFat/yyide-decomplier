package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMinNullLayout21PBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvNull;

    private ItemMinNullLayout21PBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvNull = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemMinNullLayout21PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMinNullLayout21PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_min_null_layout_2_1_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMinNullLayout21PBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_null);
        if (textView != null) {
            return new ItemMinNullLayout21PBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_null)));
    }
}
