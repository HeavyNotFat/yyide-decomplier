package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassSchedule26lBinding implements ViewBinding {
    public final LinearLayoutCompat contentLayout;
    public final TextClock hh;
    public final LinearLayoutCompat linearLayoutCompat;
    public final LinearLayoutCompat linearLayoutCompat2;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextClock textClock6;
    public final TextView tvTitle;

    private FragmentClassSchedule26lBinding(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, TextClock textClock, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, RecyclerView recyclerView, TextClock textClock2, TextView textView) {
        this.rootView = constraintLayout;
        this.contentLayout = linearLayoutCompat;
        this.hh = textClock;
        this.linearLayoutCompat = linearLayoutCompat2;
        this.linearLayoutCompat2 = linearLayoutCompat3;
        this.recyclerView = recyclerView;
        this.textClock6 = textClock2;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule26lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule26lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule2_6l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule26lBinding bind(View view) {
        int i = R.id.content_layout;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.content_layout);
        if (linearLayoutCompat != null) {
            i = R.id.hh;
            TextClock textClock = (TextClock) view.findViewById(R.id.hh);
            if (textClock != null) {
                i = R.id.linearLayoutCompat;
                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat);
                if (linearLayoutCompat2 != null) {
                    i = R.id.linearLayoutCompat2;
                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat2);
                    if (linearLayoutCompat3 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            i = R.id.textClock6;
                            TextClock textClock2 = (TextClock) view.findViewById(R.id.textClock6);
                            if (textClock2 != null) {
                                i = R.id.tvTitle;
                                TextView textView = (TextView) view.findViewById(R.id.tvTitle);
                                if (textView != null) {
                                    return new FragmentClassSchedule26lBinding((ConstraintLayout) view, linearLayoutCompat, textClock, linearLayoutCompat2, linearLayoutCompat3, recyclerView, textClock2, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
