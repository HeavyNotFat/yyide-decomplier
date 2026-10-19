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
public final class ItemMessageListNewsBinding implements ViewBinding {
    public final ConstraintLayout clItem;
    public final ImageView ivImg;
    private final ConstraintLayout rootView;
    public final TextView tvTime;
    public final TextView tvTitle;

    private ItemMessageListNewsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clItem = constraintLayout2;
        this.ivImg = imageView;
        this.tvTime = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemMessageListNewsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMessageListNewsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_message_list_news, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMessageListNewsBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivImg;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivImg);
        if (imageView != null) {
            i = R.id.tvTime;
            TextView textView = (TextView) view.findViewById(R.id.tvTime);
            if (textView != null) {
                i = R.id.tvTitle;
                TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
                if (textView2 != null) {
                    return new ItemMessageListNewsBinding(constraintLayout, constraintLayout, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
