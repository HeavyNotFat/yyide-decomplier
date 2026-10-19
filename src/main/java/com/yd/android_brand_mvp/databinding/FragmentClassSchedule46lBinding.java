package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassSchedule46lBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvWeek;

    private FragmentClassSchedule46lBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView;
        this.tvWeek = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule46lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule46lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule4_6l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule46lBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.tv_week;
            TextView textView = (TextView) view.findViewById(R.id.tv_week);
            if (textView != null) {
                return new FragmentClassSchedule46lBinding((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
