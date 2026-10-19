package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentEvaluationPointBinding implements ViewBinding {
    public final View line;
    public final LinearLayoutCompat llCenter;
    public final LinearLayoutCompat llEnd;
    public final LinearLayoutCompat llStart;
    public final LinearLayout lltime;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvEndTime;
    public final TextView tvRedeemedPoint;
    public final TextView tvRemainingPoint;
    public final TextView tvStartTime;
    public final TextView tvTitle;
    public final TextView tvTotalPoint;

    private FragmentEvaluationPointBinding(ConstraintLayout constraintLayout, View view, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.line = view;
        this.llCenter = linearLayoutCompat;
        this.llEnd = linearLayoutCompat2;
        this.llStart = linearLayoutCompat3;
        this.lltime = linearLayout;
        this.recyclerView = recyclerView;
        this.tvEndTime = textView;
        this.tvRedeemedPoint = textView2;
        this.tvRemainingPoint = textView3;
        this.tvStartTime = textView4;
        this.tvTitle = textView5;
        this.tvTotalPoint = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEvaluationPointBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEvaluationPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_evaluation_point, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentEvaluationPointBinding bind(View view) {
        int i = R.id.line;
        View viewFindViewById = view.findViewById(R.id.line);
        if (viewFindViewById != null) {
            i = R.id.llCenter;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llCenter);
            if (linearLayoutCompat != null) {
                i = R.id.llEnd;
                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.llEnd);
                if (linearLayoutCompat2 != null) {
                    i = R.id.llStart;
                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view.findViewById(R.id.llStart);
                    if (linearLayoutCompat3 != null) {
                        i = R.id.lltime;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lltime);
                        if (linearLayout != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                            if (recyclerView != null) {
                                i = R.id.tv_end_time;
                                TextView textView = (TextView) view.findViewById(R.id.tv_end_time);
                                if (textView != null) {
                                    i = R.id.tvRedeemedPoint;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tvRedeemedPoint);
                                    if (textView2 != null) {
                                        i = R.id.tvRemainingPoint;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tvRemainingPoint);
                                        if (textView3 != null) {
                                            i = R.id.tv_start_time;
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_start_time);
                                            if (textView4 != null) {
                                                i = R.id.tvTitle;
                                                TextView textView5 = (TextView) view.findViewById(R.id.tvTitle);
                                                if (textView5 != null) {
                                                    i = R.id.tvTotalPoint;
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tvTotalPoint);
                                                    if (textView6 != null) {
                                                        return new FragmentEvaluationPointBinding((ConstraintLayout) view, viewFindViewById, linearLayoutCompat, linearLayoutCompat2, linearLayoutCompat3, linearLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
