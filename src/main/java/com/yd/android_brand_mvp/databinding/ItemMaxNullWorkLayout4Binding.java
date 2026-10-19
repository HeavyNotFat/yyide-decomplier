package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMaxNullWorkLayout4Binding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvNull;

    private ItemMaxNullWorkLayout4Binding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvNull = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemMaxNullWorkLayout4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMaxNullWorkLayout4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_max_null_work_layout_4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMaxNullWorkLayout4Binding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_null);
        if (textView != null) {
            return new ItemMaxNullWorkLayout4Binding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_null)));
    }
}
