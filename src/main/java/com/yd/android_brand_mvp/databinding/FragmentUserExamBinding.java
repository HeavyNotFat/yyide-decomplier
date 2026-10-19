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
public final class FragmentUserExamBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentUserExam;
    public final TextView tvFragmentUserExamTitle;

    private FragmentUserExamBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.rvFragmentUserExam = recyclerView;
        this.tvFragmentUserExamTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserExamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserExamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_exam, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUserExamBinding bind(View view) {
        int i = R.id.rv_fragment_user_exam;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_user_exam);
        if (recyclerView != null) {
            i = R.id.tv_fragment_user_exam_title;
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_user_exam_title);
            if (textView != null) {
                return new FragmentUserExamBinding((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
