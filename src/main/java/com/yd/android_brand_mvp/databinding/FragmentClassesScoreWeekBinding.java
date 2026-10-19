package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassesScoreWeekBinding implements ViewBinding {
    public final ConstraintLayout llClass;
    public final RecyclerView recyclerView;
    private final FrameLayout rootView;
    public final TextView tvClassName;
    public final TextView tvClassScore;
    public final TextView tvThisClassRank;

    private FragmentClassesScoreWeekBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.llClass = constraintLayout;
        this.recyclerView = recyclerView;
        this.tvClassName = textView;
        this.tvClassScore = textView2;
        this.tvThisClassRank = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassesScoreWeekBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassesScoreWeekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_classes_score_week, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassesScoreWeekBinding bind(View view) {
        int i = R.id.ll_class;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_class);
        if (constraintLayout != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.tv_class_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_class_name);
                if (textView != null) {
                    i = R.id.tv_class_score;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_class_score);
                    if (textView2 != null) {
                        i = R.id.tv_this_class_rank;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_this_class_rank);
                        if (textView3 != null) {
                            return new FragmentClassesScoreWeekBinding((FrameLayout) view, constraintLayout, recyclerView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
