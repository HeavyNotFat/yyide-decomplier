package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemKbWeekBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvWeek;
    public final TextView tvWeekTime;

    private ItemKbWeekBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvWeek = textView;
        this.tvWeekTime = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemKbWeekBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemKbWeekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_kb_week, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemKbWeekBinding bind(View view) {
        int i = R.id.tvWeek;
        TextView textView = (TextView) view.findViewById(R.id.tvWeek);
        if (textView != null) {
            i = R.id.tvWeekTime;
            TextView textView2 = (TextView) view.findViewById(R.id.tvWeekTime);
            if (textView2 != null) {
                return new ItemKbWeekBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
