package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBlackBoardFragment2x3Binding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivBg;
    public final ImageView ivNoData;
    public final ImageView ivToday;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding top;

    private FragmentBlackBoardFragment2x3Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivBg = imageView;
        this.ivNoData = imageView2;
        this.ivToday = imageView3;
        this.recyclerView = recyclerView;
        this.top = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBlackBoardFragment2x3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBlackBoardFragment2x3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_black_board_fragment2x3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBlackBoardFragment2x3Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivBg;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivBg);
        if (imageView != null) {
            i = R.id.iv_no_data;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_no_data);
            if (imageView2 != null) {
                i = R.id.ivToday;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.ivToday);
                if (imageView3 != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                    if (recyclerView != null) {
                        i = R.id.top;
                        View viewFindViewById = view.findViewById(R.id.top);
                        if (viewFindViewById != null) {
                            return new FragmentBlackBoardFragment2x3Binding(constraintLayout, constraintLayout, imageView, imageView2, imageView3, recyclerView, LayoutHeadTitleBinding.bind(viewFindViewById));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
