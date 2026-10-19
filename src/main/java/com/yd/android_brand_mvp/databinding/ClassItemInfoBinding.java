package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassItemInfoBinding implements ViewBinding {
    public final TextView item;
    public final TextView item2;
    private final FrameLayout rootView;

    private ClassItemInfoBinding(FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.item = textView;
        this.item2 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ClassItemInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ClassItemInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.class_item_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ClassItemInfoBinding bind(View view) {
        int i = R.id.item;
        TextView textView = (TextView) view.findViewById(R.id.item);
        if (textView != null) {
            i = R.id.item2;
            TextView textView2 = (TextView) view.findViewById(R.id.item2);
            if (textView2 != null) {
                return new ClassItemInfoBinding((FrameLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
