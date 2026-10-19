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
public final class ItemLeaveCcBinding implements ViewBinding {
    public final ImageView ivDel;
    public final ImageView ivHead;
    public final ImageView ivItemLeaveCcProcess;
    private final ConstraintLayout rootView;
    public final TextView tvName;

    private ItemLeaveCcBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = constraintLayout;
        this.ivDel = imageView;
        this.ivHead = imageView2;
        this.ivItemLeaveCcProcess = imageView3;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemLeaveCcBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLeaveCcBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_leave_cc, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLeaveCcBinding bind(View view) {
        int i = R.id.ivDel;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivDel);
        if (imageView != null) {
            i = R.id.ivHead;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ivHead);
            if (imageView2 != null) {
                i = R.id.iv_item_leave_cc_process;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_item_leave_cc_process);
                if (imageView3 != null) {
                    i = R.id.tvName;
                    TextView textView = (TextView) view.findViewById(R.id.tvName);
                    if (textView != null) {
                        return new ItemLeaveCcBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
