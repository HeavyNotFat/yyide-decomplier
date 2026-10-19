package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassesScoreDetailsBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final LinearLayoutCompat rootView;
    public final TextView textView27;
    public final TextView textView28;
    public final TextView textView29;
    public final TextView tvTotal;
    public final TextView tvTotalDemerit;
    public final TextView tvTotalScore;

    private FragmentClassesScoreDetailsBinding(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayoutCompat;
        this.recyclerView = recyclerView;
        this.textView27 = textView;
        this.textView28 = textView2;
        this.textView29 = textView3;
        this.tvTotal = textView4;
        this.tvTotalDemerit = textView5;
        this.tvTotalScore = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentClassesScoreDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassesScoreDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_classes_score_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassesScoreDetailsBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.textView27;
            TextView textView = (TextView) view.findViewById(R.id.textView27);
            if (textView != null) {
                i = R.id.textView28;
                TextView textView2 = (TextView) view.findViewById(R.id.textView28);
                if (textView2 != null) {
                    i = R.id.textView29;
                    TextView textView3 = (TextView) view.findViewById(R.id.textView29);
                    if (textView3 != null) {
                        i = R.id.tv_total;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_total);
                        if (textView4 != null) {
                            i = R.id.tv_total_demerit;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_total_demerit);
                            if (textView5 != null) {
                                i = R.id.tv_total_score;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_total_score);
                                if (textView6 != null) {
                                    return new FragmentClassesScoreDetailsBinding((LinearLayoutCompat) view, recyclerView, textView, textView2, textView3, textView4, textView5, textView6);
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
