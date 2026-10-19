package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AttChildrensAddItemBinding implements ViewBinding {
    public final TextView addLab;
    private final LinearLayout rootView;

    private AttChildrensAddItemBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.addLab = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AttChildrensAddItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AttChildrensAddItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.att_childrens_add_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttChildrensAddItemBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.add_lab);
        if (textView != null) {
            return new AttChildrensAddItemBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.add_lab)));
    }
}
