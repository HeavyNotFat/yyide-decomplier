package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutWeekItem42pBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final CheckedTextView weekItem;

    private LayoutWeekItem42pBinding(LinearLayout linearLayout, CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.weekItem = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWeekItem42pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWeekItem42pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_week_item4_2p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutWeekItem42pBinding bind(View view) {
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.weekItem);
        if (checkedTextView != null) {
            return new LayoutWeekItem42pBinding((LinearLayout) view, checkedTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.weekItem)));
    }
}
