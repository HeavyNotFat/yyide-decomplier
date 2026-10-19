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
public final class HonorCommentFragmentBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    public final LayoutSelectedStudentBinding layoutSelect;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvActiveTitle;
    public final TextView tvConfirm;
    public final View view;
    public final View view2;

    private HonorCommentFragmentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LayoutSelectedStudentBinding layoutSelectedStudentBinding, RecyclerView recyclerView, TextView textView, TextView textView2, View view, View view2) {
        this.rootView = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.layoutSelect = layoutSelectedStudentBinding;
        this.recyclerView = recyclerView;
        this.tvActiveTitle = textView;
        this.tvConfirm = textView2;
        this.view = view;
        this.view2 = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorCommentFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorCommentFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_comment_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorCommentFragmentBinding bind(View view) {
        int i = R.id.constraintLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
        if (constraintLayout != null) {
            i = R.id.layout_select;
            View viewFindViewById = view.findViewById(R.id.layout_select);
            if (viewFindViewById != null) {
                LayoutSelectedStudentBinding layoutSelectedStudentBindingBind = LayoutSelectedStudentBinding.bind(viewFindViewById);
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.tvActiveTitle;
                    TextView textView = (TextView) view.findViewById(R.id.tvActiveTitle);
                    if (textView != null) {
                        i = R.id.tvConfirm;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvConfirm);
                        if (textView2 != null) {
                            i = R.id.view;
                            View viewFindViewById2 = view.findViewById(R.id.view);
                            if (viewFindViewById2 != null) {
                                i = R.id.view2;
                                View viewFindViewById3 = view.findViewById(R.id.view2);
                                if (viewFindViewById3 != null) {
                                    return new HonorCommentFragmentBinding((ConstraintLayout) view, constraintLayout, layoutSelectedStudentBindingBind, recyclerView, textView, textView2, viewFindViewById2, viewFindViewById3);
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
