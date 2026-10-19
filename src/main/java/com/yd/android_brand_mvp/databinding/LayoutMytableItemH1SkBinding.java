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
public final class LayoutMytableItemH1SkBinding implements ViewBinding {
    public final ConstraintLayout clBg;
    public final ImageView icon;
    private final ConstraintLayout rootView;
    public final TextView subjectName;
    public final TextView teacherName;
    public final TextView time;

    private LayoutMytableItemH1SkBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clBg = constraintLayout2;
        this.icon = imageView;
        this.subjectName = textView;
        this.teacherName = textView2;
        this.time = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMytableItemH1SkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMytableItemH1SkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_mytable_item_h1_sk, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMytableItemH1SkBinding bind(View view) {
        int i = R.id.cl_bg;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_bg);
        if (constraintLayout != null) {
            i = R.id.icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.icon);
            if (imageView != null) {
                i = R.id.subjectName;
                TextView textView = (TextView) view.findViewById(R.id.subjectName);
                if (textView != null) {
                    i = R.id.teacherName;
                    TextView textView2 = (TextView) view.findViewById(R.id.teacherName);
                    if (textView2 != null) {
                        i = R.id.time;
                        TextView textView3 = (TextView) view.findViewById(R.id.time);
                        if (textView3 != null) {
                            return new LayoutMytableItemH1SkBinding((ConstraintLayout) view, constraintLayout, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
