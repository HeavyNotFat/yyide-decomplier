package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewLoadMoreBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvMoreView;

    private ViewLoadMoreBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.tvMoreView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLoadMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLoadMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_load_more, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewLoadMoreBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_more_view);
        if (textView != null) {
            return new ViewLoadMoreBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_more_view)));
    }
}
