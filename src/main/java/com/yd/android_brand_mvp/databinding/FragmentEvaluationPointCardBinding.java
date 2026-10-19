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
public final class FragmentEvaluationPointCardBinding implements ViewBinding {
    public final View line;
    public final LinearLayoutCompat llEnd;
    public final LinearLayoutCompat llStart;
    public final LinearLayout lltime;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvCancelPoint;
    public final TextView tvEndTime;
    public final TextView tvPointCard;
    public final TextView tvStartTime;
    public final TextView tvTitle;

    private FragmentEvaluationPointCardBinding(ConstraintLayout constraintLayout, View view, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.line = view;
        this.llEnd = linearLayoutCompat;
        this.llStart = linearLayoutCompat2;
        this.lltime = linearLayout;
        this.recyclerView = recyclerView;
        this.tvCancelPoint = textView;
        this.tvEndTime = textView2;
        this.tvPointCard = textView3;
        this.tvStartTime = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEvaluationPointCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEvaluationPointCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_evaluation_point_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentEvaluationPointCardBinding bind(View view) {
        int i = R.id.line;
        View viewFindViewById = view.findViewById(R.id.line);
        if (viewFindViewById != null) {
            i = R.id.llEnd;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llEnd);
            if (linearLayoutCompat != null) {
                i = R.id.llStart;
                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.llStart);
                if (linearLayoutCompat2 != null) {
                    i = R.id.lltime;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lltime);
                    if (linearLayout != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            i = R.id.tvCancelPoint;
                            TextView textView = (TextView) view.findViewById(R.id.tvCancelPoint);
                            if (textView != null) {
                                i = R.id.tv_end_time;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_end_time);
                                if (textView2 != null) {
                                    i = R.id.tvPointCard;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tvPointCard);
                                    if (textView3 != null) {
                                        i = R.id.tv_start_time;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_start_time);
                                        if (textView4 != null) {
                                            i = R.id.tvTitle;
                                            TextView textView5 = (TextView) view.findViewById(R.id.tvTitle);
                                            if (textView5 != null) {
                                                return new FragmentEvaluationPointCardBinding((ConstraintLayout) view, viewFindViewById, linearLayoutCompat, linearLayoutCompat2, linearLayout, recyclerView, textView, textView2, textView3, textView4, textView5);
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
