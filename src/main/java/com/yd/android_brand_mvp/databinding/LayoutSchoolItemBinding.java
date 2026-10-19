package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutSchoolItemBinding implements ViewBinding {
    public final TextView item;
    public final TextView name;
    private final LinearLayout rootView;
    public final TextView type;

    private LayoutSchoolItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.item = textView;
        this.name = textView2;
        this.type = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSchoolItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSchoolItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_school_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSchoolItemBinding bind(View view) {
        int i = R.id.item;
        TextView textView = (TextView) view.findViewById(R.id.item);
        if (textView != null) {
            i = R.id.name;
            TextView textView2 = (TextView) view.findViewById(R.id.name);
            if (textView2 != null) {
                i = R.id.type;
                TextView textView3 = (TextView) view.findViewById(R.id.type);
                if (textView3 != null) {
                    return new LayoutSchoolItemBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
