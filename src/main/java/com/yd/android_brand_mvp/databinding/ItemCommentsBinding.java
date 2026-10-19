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
public final class ItemCommentsBinding implements ViewBinding {
    public final ImageView ivImg;
    private final ConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvName;
    public final TextView tvReply;
    public final TextView tvTime;

    private ItemCommentsBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivImg = imageView;
        this.tvContent = textView;
        this.tvName = textView2;
        this.tvReply = textView3;
        this.tvTime = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCommentsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCommentsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_comments, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCommentsBinding bind(View view) {
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) view.findViewById(R.id.tv_content);
            if (textView != null) {
                i = R.id.tv_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                if (textView2 != null) {
                    i = R.id.tv_reply;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_reply);
                    if (textView3 != null) {
                        i = R.id.tv_time;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_time);
                        if (textView4 != null) {
                            return new ItemCommentsBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
