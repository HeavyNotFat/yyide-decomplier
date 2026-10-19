package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.ScrollTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutMarqueeTextViewBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivIcon;
    public final LinearLayoutCompat llShow;
    private final ConstraintLayout rootView;
    public final TextView tvExpend;
    public final ScrollTextView tvMarquee;

    private LayoutMarqueeTextViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView, ScrollTextView scrollTextView) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivIcon = imageView;
        this.llShow = linearLayoutCompat;
        this.tvExpend = textView;
        this.tvMarquee = scrollTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMarqueeTextViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMarqueeTextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_marquee_text_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMarqueeTextViewBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
        if (imageView != null) {
            i = R.id.llShow;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llShow);
            if (linearLayoutCompat != null) {
                i = R.id.tvExpend;
                TextView textView = (TextView) view.findViewById(R.id.tvExpend);
                if (textView != null) {
                    i = R.id.tvMarquee;
                    ScrollTextView scrollTextView = (ScrollTextView) view.findViewById(R.id.tvMarquee);
                    if (scrollTextView != null) {
                        return new LayoutMarqueeTextViewBinding(constraintLayout, constraintLayout, imageView, linearLayoutCompat, textView, scrollTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
