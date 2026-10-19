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
public final class FragmentFormSituationBinding implements ViewBinding {
    public final ConstraintLayout clFragmentFormSituationNav;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentFormSituationList;
    public final TextView tvFragmentFormSituationCount;
    public final TextView tvFragmentFormSituationNotSign;
    public final TextView tvFragmentFormSituationSign;

    private FragmentFormSituationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clFragmentFormSituationNav = constraintLayout2;
        this.rvFragmentFormSituationList = recyclerView;
        this.tvFragmentFormSituationCount = textView;
        this.tvFragmentFormSituationNotSign = textView2;
        this.tvFragmentFormSituationSign = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFormSituationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFormSituationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_form_situation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentFormSituationBinding bind(View view) {
        int i = R.id.cl_fragment_form_situation_nav;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_form_situation_nav);
        if (constraintLayout != null) {
            i = R.id.rv_fragment_form_situation_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_form_situation_list);
            if (recyclerView != null) {
                i = R.id.tv_fragment_form_situation_count;
                TextView textView = (TextView) view.findViewById(R.id.tv_fragment_form_situation_count);
                if (textView != null) {
                    i = R.id.tv_fragment_form_situation_not_sign;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_form_situation_not_sign);
                    if (textView2 != null) {
                        i = R.id.tv_fragment_form_situation_sign;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_form_situation_sign);
                        if (textView3 != null) {
                            return new FragmentFormSituationBinding((ConstraintLayout) view, constraintLayout, recyclerView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
