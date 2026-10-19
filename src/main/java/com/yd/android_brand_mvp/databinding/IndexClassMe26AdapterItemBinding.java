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
public final class IndexClassMe26AdapterItemBinding implements ViewBinding {
    public final ImageView ivClassIcon;
    private final ConstraintLayout rootView;
    public final TextView tvClassName;
    public final TextView tvRanking;
    public final TextView tvScore;

    private IndexClassMe26AdapterItemBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ivClassIcon = imageView;
        this.tvClassName = textView;
        this.tvRanking = textView2;
        this.tvScore = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IndexClassMe26AdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static IndexClassMe26AdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.index_class_me_26_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IndexClassMe26AdapterItemBinding bind(View view) {
        int i = R.id.iv_class_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_class_icon);
        if (imageView != null) {
            i = R.id.tv_class_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_class_name);
            if (textView != null) {
                i = R.id.tv_ranking;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_ranking);
                if (textView2 != null) {
                    i = R.id.tv_score;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_score);
                    if (textView3 != null) {
                        return new IndexClassMe26AdapterItemBinding((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
