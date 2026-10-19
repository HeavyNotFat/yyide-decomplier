package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AttChildrensOneItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvName;

    private AttChildrensOneItemBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AttChildrensOneItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AttChildrensOneItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.att_childrens_one_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttChildrensOneItemBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        if (textView != null) {
            return new AttChildrensOneItemBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_name)));
    }
}
