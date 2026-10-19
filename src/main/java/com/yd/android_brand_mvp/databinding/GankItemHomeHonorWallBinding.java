package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class GankItemHomeHonorWallBinding implements ViewBinding {
    public final LayoutHeadTitleBinding gankInclude;
    public final ImageView ivItemHonerWallTemplate;
    private final ConstraintLayout rootView;
    public final TextView tvItemHonerWallGetClass;
    public final TextView tvItemHonerWallTitle;
    public final TextView tvItemHonerWallType;

    private GankItemHomeHonorWallBinding(ConstraintLayout constraintLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.gankInclude = layoutHeadTitleBinding;
        this.ivItemHonerWallTemplate = imageView;
        this.tvItemHonerWallGetClass = textView;
        this.tvItemHonerWallTitle = textView2;
        this.tvItemHonerWallType = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GankItemHomeHonorWallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GankItemHomeHonorWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.gank_item_home_honor_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GankItemHomeHonorWallBinding bind(View view) {
        int i = R.id.gank_include;
        View viewFindViewById = view.findViewById(R.id.gank_include);
        if (viewFindViewById != null) {
            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
            i = R.id.iv_item_honer_wall_template;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_honer_wall_template);
            if (imageView != null) {
                i = R.id.tv_item_honer_wall_getClass;
                TextView textView = (TextView) view.findViewById(R.id.tv_item_honer_wall_getClass);
                if (textView != null) {
                    i = R.id.tv_item_honer_wall_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_item_honer_wall_title);
                    if (textView2 != null) {
                        i = R.id.tv_item_honer_wall_type;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_item_honer_wall_type);
                        if (textView3 != null) {
                            return new GankItemHomeHonorWallBinding((ConstraintLayout) view, layoutHeadTitleBindingBind, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
