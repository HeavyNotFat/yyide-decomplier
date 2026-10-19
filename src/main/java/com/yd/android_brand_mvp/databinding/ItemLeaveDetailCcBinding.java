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
public final class ItemLeaveDetailCcBinding implements ViewBinding {
    public final ImageView ivCheck;
    public final ImageView ivUserHead;
    private final ConstraintLayout rootView;
    public final TextView tvName;

    private ItemLeaveDetailCcBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.ivCheck = imageView;
        this.ivUserHead = imageView2;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemLeaveDetailCcBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLeaveDetailCcBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_leave_detail_cc, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLeaveDetailCcBinding bind(View view) {
        int i = R.id.ivCheck;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivCheck);
        if (imageView != null) {
            i = R.id.iv_user_head;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_head);
            if (imageView2 != null) {
                i = R.id.tvName;
                TextView textView = (TextView) view.findViewById(R.id.tvName);
                if (textView != null) {
                    return new ItemLeaveDetailCcBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
