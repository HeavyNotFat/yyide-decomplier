package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ProductionCommentItemBinding implements ViewBinding {
    public final ImageView ivHeadPortrait;
    private final RelativeLayout rootView;
    public final TextView tvComment;
    public final TextView tvName;
    public final TextView tvTime;

    private ProductionCommentItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.ivHeadPortrait = imageView;
        this.tvComment = textView;
        this.tvName = textView2;
        this.tvTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ProductionCommentItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProductionCommentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.production_comment_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ProductionCommentItemBinding bind(View view) {
        int i = R.id.iv_head_portrait;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_head_portrait);
        if (imageView != null) {
            i = R.id.tv_comment;
            TextView textView = (TextView) view.findViewById(R.id.tv_comment);
            if (textView != null) {
                i = R.id.tv_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                if (textView2 != null) {
                    i = R.id.tv_time;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_time);
                    if (textView3 != null) {
                        return new ProductionCommentItemBinding((RelativeLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
