package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCustomTextBinding implements ViewBinding {
    public final LinearLayout linearLayout;
    private final LinearLayout rootView;
    public final TextView tvText;
    public final View view;

    private ItemCustomTextBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, View view) {
        this.rootView = linearLayout;
        this.linearLayout = linearLayout2;
        this.tvText = textView;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemCustomTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCustomTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_custom_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCustomTextBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.tvText;
        TextView textView = (TextView) view.findViewById(R.id.tvText);
        if (textView != null) {
            i = R.id.view;
            View viewFindViewById = view.findViewById(R.id.view);
            if (viewFindViewById != null) {
                return new ItemCustomTextBinding(linearLayout, linearLayout, textView, viewFindViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
