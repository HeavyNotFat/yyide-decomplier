package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassSchedule23lBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final LinearLayout linearLayoutCompat;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private FragmentClassSchedule23lBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.linearLayoutCompat = linearLayout2;
        this.recyclerView = recyclerView;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule23lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule23lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule2_3l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule23lBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.linearLayoutCompat;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayoutCompat);
            if (linearLayout != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.tvTitle;
                    TextView textView = (TextView) view.findViewById(R.id.tvTitle);
                    if (textView != null) {
                        return new FragmentClassSchedule23lBinding((LinearLayout) view, frameLayout, linearLayout, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
