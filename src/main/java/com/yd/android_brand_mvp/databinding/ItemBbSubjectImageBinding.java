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
public final class ItemBbSubjectImageBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView tvSubject;

    private ItemBbSubjectImageBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivIcon = imageView;
        this.tvSubject = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBbSubjectImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBbSubjectImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_bb_subject_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBbSubjectImageBinding bind(View view) {
        int i = R.id.ivIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
        if (imageView != null) {
            i = R.id.tvSubject;
            TextView textView = (TextView) view.findViewById(R.id.tvSubject);
            if (textView != null) {
                return new ItemBbSubjectImageBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
