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
public final class HonorCartoonFragmentBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ConstraintLayout constraintlayout;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvHonorClass;
    public final TextView tvHonorStudent;

    private HonorCartoonFragmentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.constraintlayout = constraintLayout3;
        this.recyclerView = recyclerView;
        this.tvHonorClass = textView;
        this.tvHonorStudent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorCartoonFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorCartoonFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_cartoon_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorCartoonFragmentBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.constraintlayout;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.constraintlayout);
        if (constraintLayout2 != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.tvHonorClass;
                TextView textView = (TextView) view.findViewById(R.id.tvHonorClass);
                if (textView != null) {
                    i = R.id.tvHonorStudent;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvHonorStudent);
                    if (textView2 != null) {
                        return new HonorCartoonFragmentBinding(constraintLayout, constraintLayout, constraintLayout2, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
