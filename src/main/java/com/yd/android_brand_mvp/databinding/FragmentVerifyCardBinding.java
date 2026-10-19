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
public final class FragmentVerifyCardBinding implements ViewBinding {
    public final ImageView ivFragmentVerifyCard;
    private final ConstraintLayout rootView;
    public final TextView tvFragmentVerifyCard;

    private FragmentVerifyCardBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivFragmentVerifyCard = imageView;
        this.tvFragmentVerifyCard = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVerifyCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVerifyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_verify_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVerifyCardBinding bind(View view) {
        int i = R.id.iv_fragment_verify_card;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_verify_card);
        if (imageView != null) {
            i = R.id.tv_fragment_verify_card;
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_verify_card);
            if (textView != null) {
                return new FragmentVerifyCardBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
