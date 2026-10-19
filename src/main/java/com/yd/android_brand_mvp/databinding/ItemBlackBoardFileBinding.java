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
public final class ItemBlackBoardFileBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView tvSubject;

    private ItemBlackBoardFileBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivIcon = imageView;
        this.tvSubject = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBlackBoardFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBlackBoardFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_black_board_file, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBlackBoardFileBinding bind(View view) {
        int i = R.id.ivIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
        if (imageView != null) {
            i = R.id.tvSubject;
            TextView textView = (TextView) view.findViewById(R.id.tvSubject);
            if (textView != null) {
                return new ItemBlackBoardFileBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
