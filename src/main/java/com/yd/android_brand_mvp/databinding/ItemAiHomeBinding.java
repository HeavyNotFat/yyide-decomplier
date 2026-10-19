package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemAiHomeBinding implements ViewBinding {
    public final CardView cvItem;
    public final ImageView ivAvatar;
    private final ConstraintLayout rootView;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private ItemAiHomeBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cvItem = cardView;
        this.ivAvatar = imageView;
        this.tvDescription = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemAiHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAiHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_ai_home, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemAiHomeBinding bind(View view) {
        int i = R.id.cv_item;
        CardView cardView = (CardView) view.findViewById(R.id.cv_item);
        if (cardView != null) {
            i = R.id.iv_avatar;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
            if (imageView != null) {
                i = R.id.tv_description;
                TextView textView = (TextView) view.findViewById(R.id.tv_description);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        return new ItemAiHomeBinding((ConstraintLayout) view, cardView, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
