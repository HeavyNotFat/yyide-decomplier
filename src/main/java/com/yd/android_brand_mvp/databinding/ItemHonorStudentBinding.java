package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemHonorStudentBinding implements ViewBinding {
    public final ImageView ivCover;
    public final RecyclerView medalRecyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvHonorTitle;
    public final TextView tvName;
    public final View viewLine;

    private ItemHonorStudentBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.ivCover = imageView;
        this.medalRecyclerView = recyclerView;
        this.tvHonorTitle = textView;
        this.tvName = textView2;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorStudentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorStudentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_student, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorStudentBinding bind(View view) {
        int i = R.id.ivCover;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivCover);
        if (imageView != null) {
            i = R.id.medalRecyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.medalRecyclerView);
            if (recyclerView != null) {
                i = R.id.tvHonorTitle;
                TextView textView = (TextView) view.findViewById(R.id.tvHonorTitle);
                if (textView != null) {
                    i = R.id.tvName;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvName);
                    if (textView2 != null) {
                        i = R.id.viewLine;
                        View viewFindViewById = view.findViewById(R.id.viewLine);
                        if (viewFindViewById != null) {
                            return new ItemHonorStudentBinding((ConstraintLayout) view, imageView, recyclerView, textView, textView2, viewFindViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
