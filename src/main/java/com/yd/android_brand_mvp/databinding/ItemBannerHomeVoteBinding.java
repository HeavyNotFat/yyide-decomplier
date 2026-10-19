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
public final class ItemBannerHomeVoteBinding implements ViewBinding {
    public final ImageView ivItemBannerHomeVote;
    private final ConstraintLayout rootView;
    public final TextView tvItemBannerHomeVote;

    private ItemBannerHomeVoteBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivItemBannerHomeVote = imageView;
        this.tvItemBannerHomeVote = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBannerHomeVoteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerHomeVoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_banner_home_vote, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBannerHomeVoteBinding bind(View view) {
        int i = R.id.iv_item_banner_home_vote;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_banner_home_vote);
        if (imageView != null) {
            i = R.id.tv_item_banner_home_vote;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_banner_home_vote);
            if (textView != null) {
                return new ItemBannerHomeVoteBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
