package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassMeAppraisalBinding implements ViewBinding {
    public final RadioGroup rgMeAppraisal;
    private final ConstraintLayout rootView;
    public final RecyclerView rvClassMeAppraisal;
    public final TextView tvCurrentScoreLabel;
    public final TextView tvCurrentWeek;
    public final TextView tvHello;
    public final TextView tvSubmit;
    public final TextView tvToBeAppraisedClass;
    public final TextView tvToBeAppraisedClassLabel;

    private FragmentClassMeAppraisalBinding(ConstraintLayout constraintLayout, RadioGroup radioGroup, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.rgMeAppraisal = radioGroup;
        this.rvClassMeAppraisal = recyclerView;
        this.tvCurrentScoreLabel = textView;
        this.tvCurrentWeek = textView2;
        this.tvHello = textView3;
        this.tvSubmit = textView4;
        this.tvToBeAppraisedClass = textView5;
        this.tvToBeAppraisedClassLabel = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassMeAppraisalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassMeAppraisalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_me_appraisal, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassMeAppraisalBinding bind(View view) {
        int i = R.id.rg_me_appraisal;
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_me_appraisal);
        if (radioGroup != null) {
            i = R.id.rv_class_me_appraisal;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_class_me_appraisal);
            if (recyclerView != null) {
                i = R.id.tv_current_score_label;
                TextView textView = (TextView) view.findViewById(R.id.tv_current_score_label);
                if (textView != null) {
                    i = R.id.tv_current_week;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_current_week);
                    if (textView2 != null) {
                        i = R.id.tv_hello;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_hello);
                        if (textView3 != null) {
                            i = R.id.tv_submit;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_submit);
                            if (textView4 != null) {
                                i = R.id.tv_to_be_appraised_class;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_to_be_appraised_class);
                                if (textView5 != null) {
                                    i = R.id.tv_to_be_appraised_class_label;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_to_be_appraised_class_label);
                                    if (textView6 != null) {
                                        return new FragmentClassMeAppraisalBinding((ConstraintLayout) view, radioGroup, recyclerView, textView, textView2, textView3, textView4, textView5, textView6);
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
