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
public final class DialogHonorMedalBinding implements ViewBinding {
    public final ImageView ivMedal;
    private final ConstraintLayout rootView;
    public final TextView tvActiveTitle;
    public final TextView tvConfirm;
    public final TextView tvTimeClass;
    public final TextView tvTitle;

    private DialogHonorMedalBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivMedal = imageView;
        this.tvActiveTitle = textView;
        this.tvConfirm = textView2;
        this.tvTimeClass = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogHonorMedalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogHonorMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_honor_medal, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogHonorMedalBinding bind(View view) {
        int i = R.id.ivMedal;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivMedal);
        if (imageView != null) {
            i = R.id.tvActiveTitle;
            TextView textView = (TextView) view.findViewById(R.id.tvActiveTitle);
            if (textView != null) {
                i = R.id.tvConfirm;
                TextView textView2 = (TextView) view.findViewById(R.id.tvConfirm);
                if (textView2 != null) {
                    i = R.id.tvTimeClass;
                    TextView textView3 = (TextView) view.findViewById(R.id.tvTimeClass);
                    if (textView3 != null) {
                        i = R.id.tvTitle;
                        TextView textView4 = (TextView) view.findViewById(R.id.tvTitle);
                        if (textView4 != null) {
                            return new DialogHonorMedalBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
