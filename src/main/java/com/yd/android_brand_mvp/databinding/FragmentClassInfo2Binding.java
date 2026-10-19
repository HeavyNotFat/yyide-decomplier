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
public final class FragmentClassInfo2Binding implements ViewBinding {
    public final ConstraintLayout constraintLayout4;
    public final ImageView ivHead;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private FragmentClassInfo2Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.constraintLayout4 = constraintLayout2;
        this.ivHead = imageView;
        this.recyclerView = recyclerView;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassInfo2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassInfo2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassInfo2Binding bind(View view) {
        int i = R.id.constraintLayout4;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout4);
        if (constraintLayout != null) {
            i = R.id.ivHead;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivHead);
            if (imageView != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.tvTitle;
                    TextView textView = (TextView) view.findViewById(R.id.tvTitle);
                    if (textView != null) {
                        return new FragmentClassInfo2Binding((ConstraintLayout) view, constraintLayout, imageView, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
