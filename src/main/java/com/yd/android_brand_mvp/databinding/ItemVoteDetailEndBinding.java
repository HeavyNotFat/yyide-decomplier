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
public final class ItemVoteDetailEndBinding implements ViewBinding {
    public final ImageView ivItemVoteDetailEnd;
    private final ConstraintLayout rootView;
    public final TextView tvItemVoteDetailEndCount;
    public final TextView tvItemVoteDetailEndTitle;
    public final ImageView viewLineProgress;

    private ItemVoteDetailEndBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.ivItemVoteDetailEnd = imageView;
        this.tvItemVoteDetailEndCount = textView;
        this.tvItemVoteDetailEndTitle = textView2;
        this.viewLineProgress = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemVoteDetailEndBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemVoteDetailEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_vote_detail_end, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemVoteDetailEndBinding bind(View view) {
        int i = R.id.iv_item_vote_detail_end;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_vote_detail_end);
        if (imageView != null) {
            i = R.id.tv_item_vote_detail_end_count;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_vote_detail_end_count);
            if (textView != null) {
                i = R.id.tv_item_vote_detail_end_title;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_vote_detail_end_title);
                if (textView2 != null) {
                    i = R.id.view_line_progress;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.view_line_progress);
                    if (imageView2 != null) {
                        return new ItemVoteDetailEndBinding((ConstraintLayout) view, imageView, textView, textView2, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
