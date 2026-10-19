package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentNoticeTemplateBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView iv3;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout top;
    public final TextView top3;
    public final TextView tvRight;

    private FragmentNoticeTemplateBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RecyclerView recyclerView, ConstraintLayout constraintLayout3, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.iv3 = imageView;
        this.recyclerView = recyclerView;
        this.top = constraintLayout3;
        this.top3 = textView;
        this.tvRight = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNoticeTemplateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNoticeTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_notice_template, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentNoticeTemplateBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv3;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv3);
        if (imageView != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.top;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.top);
                if (constraintLayout2 != null) {
                    i = R.id.top3;
                    TextView textView = (TextView) view.findViewById(R.id.top3);
                    if (textView != null) {
                        i = R.id.tvRight;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvRight);
                        if (textView2 != null) {
                            return new FragmentNoticeTemplateBinding(constraintLayout, constraintLayout, imageView, recyclerView, constraintLayout2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
