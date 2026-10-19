package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemClassesScoreDetailsBinding implements ViewBinding {
    public final ConstraintLayout llClass;
    private final ConstraintLayout rootView;
    public final TextView tvClassScore;
    public final TextView tvClassTotalScore;
    public final TextView tvDate;
    public final TextView tvWeek;

    private ItemClassesScoreDetailsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.llClass = constraintLayout2;
        this.tvClassScore = textView;
        this.tvClassTotalScore = textView2;
        this.tvDate = textView3;
        this.tvWeek = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemClassesScoreDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemClassesScoreDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_classes_score_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemClassesScoreDetailsBinding bind(View view) {
        int i = R.id.ll_class;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_class);
        if (constraintLayout != null) {
            i = R.id.tv_class_score;
            TextView textView = (TextView) view.findViewById(R.id.tv_class_score);
            if (textView != null) {
                i = R.id.tv_class_total_score;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_class_total_score);
                if (textView2 != null) {
                    i = R.id.tv_date;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_date);
                    if (textView3 != null) {
                        i = R.id.tv_week;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_week);
                        if (textView4 != null) {
                            return new ItemClassesScoreDetailsBinding((ConstraintLayout) view, constraintLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
