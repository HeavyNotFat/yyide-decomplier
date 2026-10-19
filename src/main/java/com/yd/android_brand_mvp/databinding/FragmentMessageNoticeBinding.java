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
public final class FragmentMessageNoticeBinding implements ViewBinding {
    public final ImageView iv2;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView top2;
    public final TextView tvAll;

    private FragmentMessageNoticeBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.iv2 = imageView;
        this.recyclerView = recyclerView;
        this.top2 = textView;
        this.tvAll = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMessageNoticeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMessageNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_message_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMessageNoticeBinding bind(View view) {
        int i = R.id.iv2;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv2);
        if (imageView != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.top2;
                TextView textView = (TextView) view.findViewById(R.id.top2);
                if (textView != null) {
                    i = R.id.tvAll;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvAll);
                    if (textView2 != null) {
                        return new FragmentMessageNoticeBinding((ConstraintLayout) view, imageView, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
