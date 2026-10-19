package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutWeekItemLMBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final CheckedTextView weekItem;

    private LayoutWeekItemLMBinding(LinearLayout linearLayout, CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.weekItem = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWeekItemLMBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWeekItemLMBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_week_item_l_m, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutWeekItemLMBinding bind(View view) {
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.weekItem);
        if (checkedTextView != null) {
            return new LayoutWeekItemLMBinding((LinearLayout) view, checkedTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.weekItem)));
    }
}
